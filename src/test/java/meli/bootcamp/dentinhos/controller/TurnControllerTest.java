package meli.bootcamp.dentinhos.controller;

import meli.bootcamp.dentinhos.domain.Dentist;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ActiveProfiles("test")
@SpringBootTest
@AutoConfigureMockMvc
public class TurnControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void should_getEmployesDone_withinADay() throws Exception {

        mockMvc.perform(get("/turns/completed/2021-07-21/patients")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content()
                        .contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].name", is("dentinho3")));
    }

    @Test
    public void should_getPendingTurns_withinADay() throws Exception {
        mockMvc.perform(get("/turns/pending/2021-07-23")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content()
                        .contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].patientDTO.name", is("dentinho5")))
                .andExpect(jsonPath("$[0].patientDTO.lastName", is("dba5")));
    }

    @Test
    public void should_getRescheduledTurnsforADentist() throws Exception {
        Dentist dentist = new Dentist();
        dentist.setId(1);
        mockMvc.perform(get("/turns/rescheduled/" + dentist.getId())
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].turnStatus.id", is(4)))
                .andExpect(jsonPath("$[0].turnStatus.name", is("Reprogramado")))
                .andExpect(status().isOk());
    }
}

