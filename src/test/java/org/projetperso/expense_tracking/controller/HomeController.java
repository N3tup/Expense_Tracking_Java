package org.projetperso.expense_tracking.controller;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.projetperso.expense_tracking.dto.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RestController
@RequestMapping("/api")  // Bonne pratique : préfixer les endpoints API
public class HomeController {

    @GetMapping("/status")  // Endpoint pour vérifier l'état de l'API
    public ResponseEntity<ApiResponse> getApiStatus() {
        ApiResponse response = ApiResponse.builder()
                .success(true)
                .message("API is running")
                .data(new SystemStatus(
                        "Expense Tracking Application",
                        "1.0.0",
                        "UP"
                ))
                .build();

        return ResponseEntity.ok(response);
    }


    @Nested
    @WebMvcTest(HomeController.class)
    class HomeControllerTest {

        @Autowired
        private MockMvc mockMvc;

        @Test
        public void getApiStatus_ShouldReturnSuccessResponse() throws Exception {
            mockMvc.perform(get("/api/status"))
                    .andExpect(status().isOk())
                    .andExpect(jsonPath("$.success").value(true))
                    .andExpect(jsonPath("$.message").value("API is running"))
                    .andExpect(jsonPath("$.data.applicationName").value("Expense Tracking Application"));
        }
    }
}

// Classe interne pour les informations système
record SystemStatus(String applicationName, String version, String status) {}
