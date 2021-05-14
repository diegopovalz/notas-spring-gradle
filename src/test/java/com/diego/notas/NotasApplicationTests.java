package com.diego.notas;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.hamcrest.core.Is.is;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class NotasApplicationTests {

    @Autowired private MockMvc mvc;
    @Autowired private ObjectMapper objectMapper;

    @Test
    void deberiaGuardarNotaYDevolverIdYFecha() throws Exception {
        Date fechaPrestamo = new Date();
        DateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        String fechaRegistro = formato.format(fechaPrestamo);

        MvcResult resultadoNotaRegistrada = mvc.perform(
                MockMvcRequestBuilders.post("/notas/nota")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(new RegistroNotaTest("Prueba de Test 2", fechaRegistro))))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").exists())
                .andExpect(jsonPath("$.fecha").exists())
                .andReturn();

        ResultadoNotaTest resultado = objectMapper.readValue(resultadoNotaRegistrada.getResponse().getContentAsString(), ResultadoNotaTest.class);

        mvc.perform(MockMvcRequestBuilders
                .get("/notas/" + resultado.getId().intValue())
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").exists())
                .andExpect(jsonPath("$.descripcion").exists())
                .andExpect(jsonPath("$.fecha", is(fechaRegistro)));
    }

}

