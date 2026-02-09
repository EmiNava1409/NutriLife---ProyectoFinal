package com.nutrilife.nutrilife.controller;

import com.nutrilife.nutrilife.domain.NutriPlan;
import com.nutrilife.nutrilife.service.NutriPlanService;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(NutriPlanController.class)
class NutriPlanControllerTest {

  @Autowired private MockMvc mockMvc;
  @MockBean private NutriPlanService service;

  @Test
  void getAll_returns200_andJson() throws Exception {
    Mockito.when(service.getAll()).thenReturn(
            List.of(new NutriPlan(1L, "Plan Mediterráneo 14 días", "Salud", 2000, 14,
                    List.of("Avena"), "mediterraneo", "Top recomendado"))
    );

    mockMvc.perform(get("/api/nutrilife-plans").accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
            .andExpect(jsonPath("$[0].id").value(1));
  }

  @Test
  void getById_returns200() throws Exception {
    Mockito.when(service.getById(1L)).thenReturn(
            new NutriPlan(1L, "Plan X", "Meta", 1800, 7, List.of("Comida"), "keto", "Low carb")
    );

    mockMvc.perform(get("/api/nutrilife-plans/1"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.id").value(1))
            .andExpect(jsonPath("$.name").value("Plan X"));
  }

  @Test
  void create_returns201() throws Exception {
    Mockito.when(service.create(Mockito.any(NutriPlan.class))).thenAnswer(inv -> {
      NutriPlan p = inv.getArgument(0);
      p.setId(10L);
      return p;
    });

    String body = """
      {
        "id": null,
        "name": "Plan Nuevo",
        "goal": "Bienestar",
        "caloriesPerDay": 1900,
        "days": 10,
        "meals": ["Avena"],
        "imageKey": "dash",
        "tag": "Bajo sodio"
      }
      """;

    mockMvc.perform(post("/api/nutrilife-plans")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(body))
            .andExpect(status().isCreated())
            .andExpect(jsonPath("$.id").value(10))
            .andExpect(jsonPath("$.name").value("Plan Nuevo"));
  }

  @Test
  void update_returns200() throws Exception {
    Mockito.when(service.update(Mockito.eq(1L), Mockito.any(NutriPlan.class)))
            .thenReturn(new NutriPlan(1L, "Plan Editado", "Meta", 2000, 14,
                    List.of("Avena"), "mediterraneo", "Top recomendado"));

    String body = """
      {
        "id": 999,
        "name": "Plan Editado",
        "goal": "Meta",
        "caloriesPerDay": 2000,
        "days": 14,
        "meals": ["Avena"],
        "imageKey": "mediterraneo",
        "tag": "Top recomendado"
      }
      """;

    mockMvc.perform(put("/api/nutrilife-plans/1")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(body))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.id").value(1))
            .andExpect(jsonPath("$.name").value("Plan Editado"));
  }

  @Test
  void delete_returns204() throws Exception {
    mockMvc.perform(delete("/api/nutrilife-plans/1"))
            .andExpect(status().isNoContent());

    Mockito.verify(service).delete(1L);
  }
}