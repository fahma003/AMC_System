package com.DSE.FinalProject.repository;
import com.DSE.FinalProject.dto.AmcReminderDTO;
import com.DSE.FinalProject.model.AddAmc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface AddAmcRepository extends JpaRepository<AddAmc, Long> {
    Optional<AddAmc> findTopByOrderByAmcIdDesc();
    @Query("SELECT a FROM AddAmc a WHERE a.user.id = :userId")
    List<AddAmc> findByUserId(@Param("userId") Long userId);
    boolean existsById(Long amcId);
    List<AddAmc> findByContractName(String contractName);
    @Query("SELECT a FROM AddAmc a WHERE a.startDate >= :startDate AND a.endDate <= :endDate")
    List<AddAmc> findByStartDateBetween(@Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate);

@Query("SELECT FUNCTION('MONTH', a.startDate) AS month, " +
        "FUNCTION('YEAR', a.startDate) AS year, " +
        "SUM(a.cost) AS totalCost " +
        "FROM AddAmc a " +
        "WHERE a.cost IS NOT NULL " + // Ensure only valid costs are included
        "GROUP BY FUNCTION('YEAR', a.startDate), FUNCTION('MONTH', a.startDate) " +
        "ORDER BY year, month")
List<Object[]> getMonthlyCosts();

    @Query("SELECT new com.DSE.FinalProject.dto.AmcReminderDTO(a.contractName, a.endDate) " +
            "FROM AddAmc a " +
            "WHERE a.endDate BETWEEN :startDate AND :endDate")
    List<AmcReminderDTO> findAmcRemindersBetweenDates(@Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate);

    @Query("SELECT FUNCTION('MONTH', a.startDate) AS month, " +
            "FUNCTION('YEAR', a.startDate) AS year, " +
            "COUNT(a) AS totalAmcCount " +
            "FROM AddAmc a " +
            "GROUP BY FUNCTION('YEAR', a.startDate), FUNCTION('MONTH', a.startDate) " +
            "ORDER BY year, month")
    List<Object[]> getAmcCountOverTime();

    @Query("SELECT a.category AS category, COUNT(a) AS count " +
            "FROM AddAmc a " +
            "GROUP BY a.category " +
            "ORDER BY count DESC")
    List<Object[]> getCategoryDistribution();


}
