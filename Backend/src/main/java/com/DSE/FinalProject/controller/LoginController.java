package com.DSE.FinalProject.controller;

import com.DSE.FinalProject.dto.LoginDTO;
import com.DSE.FinalProject.service.LoginService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import java.util.Map;




@RestController
@RequestMapping("/api/login")
@CrossOrigin(origins = "*")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @PostMapping
    public ResponseEntity<?> login(@Valid @RequestBody LoginDTO loginDTO) {
        String role = loginService.authenticateUser(loginDTO.getEmail(), loginDTO.getPassword());

        if (role != null) {
            return ResponseEntity.ok().body(Map.of("role", role));
        } else {
            return ResponseEntity.status(401).body(Map.of("message", "Invalid email or password"));
        }
    }




}
