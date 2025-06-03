//package com.DSE.FinalProject.service;
//
//import com.DSE.FinalProject.model.User;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//import java.util.Collection;
//import java.util.List;
//
//@Service
//public class CustomUserDetailsService implements UserDetailsService {
//
//
//    private final UserService userService;  // your existing service
//
//    public CustomUserDetailsService(UserService userService) {
//        this.userService = userService;
//    }
//
//    @Override
//    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
//        // fetch user entity by username (or email)
//        User user = userService.findByEmail(email); // or findByEmail
//
//        if (user == null) {
//            throw new UsernameNotFoundException("User not found");
//        }
//
//        // Create UserDetails object from your user entity
//        return new org.springframework.security.core.userdetails.User(
//                user.getEmail(), // or email
//                user.getPassword(),
//                getAuthorities(user.getRole())
//        );
//    }
//
//        private Collection<? extends GrantedAuthority> getAuthorities(String role) {
//            return List.of(new SimpleGrantedAuthority(role));
//    }
//}
