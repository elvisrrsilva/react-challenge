package com.workana.challenge.controller;

import static org.hamcrest.Matchers.hasKey;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.oneOf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import com.workana.challenge.junit.AbstractMvcIntegrationTest;

/**
 * Created by: Elvis Ribeiro
 */
class PeriodicElementControllerTest extends AbstractMvcIntegrationTest {

    @Test
    @DisplayName("test if the first and last name results are correct")
    void testEmptyFirstAndLastName() throws Exception {
        var json = """
                    {
                    
                    }
                """;
        var requestBuilder = post("/api/process")
                .content(json)
                .with(noAuthentication());

        var oneOf = oneOf("firstName cant be null", "lastName cant be null");
        mockMvc.perform(requestBuilder)
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$", hasKey("messages")))
                .andExpect(jsonPath("$.messages", hasSize(2)))
                .andExpect(jsonPath("$.messages.[0]").value(oneOf))
                .andExpect(jsonPath("$.messages.[1]").value(oneOf));
    }

    @Test
    @DisplayName("test empty first name")
    void testEmptyFirstName() throws Exception {
        var json = """
                    {
                      "lastName":"some"
                    }
                """;
        var requestBuilder = post("/api/process")
                .content(json)
                .with(noAuthentication());

        mockMvc.perform(requestBuilder)
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$", hasKey("messages")))
                .andExpect(jsonPath("$.messages", hasSize(1)))
                .andExpect(jsonPath("$.messages.[0]").value("firstName cant be null"));
    }

    @Test
    @DisplayName("test empty last name")
    void testEmptyLastName() throws Exception {
        var json = """
                    {
                      "firstName":"some"
                    }
                """;
        var requestBuilder = post("/api/process")
                .content(json)
                .with(noAuthentication());

        mockMvc.perform(requestBuilder)
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$", hasKey("messages")))
                .andExpect(jsonPath("$.messages", hasSize(1)))
                .andExpect(jsonPath("$.messages.[0]").value("lastName cant be null"));
    }

    @ParameterizedTest
    @ValueSource(strings = {"a,b", "aa,bb"})
    @DisplayName("test empty highlights")
    void testCreateEmptyHighlights(final String fullName) throws Exception {
        var nameParts = fullName.split(",");
        var firstName = nameParts[0];
        var lastName = nameParts[1];

        var json = """
                    {
                      "firstName":"%s",
                      "lastName": "%s"
                    }
                """.formatted(firstName, lastName);

        var requestBuilder = post("/api/process")
                .content(json)
                .with(noAuthentication());

        mockMvc.perform(requestBuilder)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasKey("firstName")))
                .andExpect(jsonPath("$.firstName", hasKey("word")))
                .andExpect(jsonPath("$.firstName.word").value(firstName))
                .andExpect(jsonPath("$.firstName", hasKey("highlights")))
                .andExpect(jsonPath("$.firstName.highlights", hasSize(0)));
    }

}