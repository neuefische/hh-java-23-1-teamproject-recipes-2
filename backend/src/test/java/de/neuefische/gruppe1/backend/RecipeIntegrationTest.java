package de.neuefische.gruppe1.backend;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithAnonymousUser;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class RecipeIntegrationTest {
    @Autowired
    MockMvc mockMvc;

    @Test
    @WithAnonymousUser
    void getAll_ShouldReturnAllRecipesWithAnonymousUser() throws Exception {
        mockMvc.perform(get("/api/recipes"))
                .andExpect(status().isOk())
                .andExpect(content().json(
                        """
                                []
                                """
                ));
    }

    @Test
    @WithMockUser
    void getAll_ShouldReturnAllRecipesWithMockUser() throws Exception {
        mockMvc.perform(get("/api/recipes"))
                .andExpect(status().isOk())
                .andExpect(content().json(
                        """
                                []
                                """
                ));
    }
}

