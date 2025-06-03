//package com.DSE.FinalProject.repository;
//
//public interface FullAmcReportRepository {
//}
package com.DSE.FinalProject.repository;

import com.DSE.FinalProject.model.AddAmc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface FullAmcReportRepository extends JpaRepository<AddAmc, Long> {

    // Fetch AddAmc entities within the specified date range
    List<AddAmc> findByStartDateBetween(LocalDate startDate, LocalDate endDate);
}