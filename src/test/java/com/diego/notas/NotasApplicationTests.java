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
import java.util.Calendar;
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
    public void deberiaGuardarNotaYDevolverIdYFecha() throws Exception {
        Date fechaPrestamo = Calendar.getInstance().getTime();
        DateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        String fechaRegistro = formato.format(fechaPrestamo);

        MvcResult resultadoNotaRegistrada = mvc.perform(
                MockMvcRequestBuilders.post("/notas")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(new RegistroNotaTest("Prueba de Test 2", fechaRegistro))))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").exists())
                .andExpect(jsonPath("$.fecha").exists())
                .andReturn();

        ResultadoNotaTest resultado = objectMapper.readValue(resultadoNotaRegistrada.getResponse().getContentAsString(), ResultadoNotaTest.class);

        mvc.perform(MockMvcRequestBuilders
                .get("/notas/nota/" + resultado.getId().intValue())
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").exists())
                .andExpect(jsonPath("$[0].descripcion").exists())
                .andExpect(jsonPath("$[0].fecha", is(fechaRegistro)));
    }

}

