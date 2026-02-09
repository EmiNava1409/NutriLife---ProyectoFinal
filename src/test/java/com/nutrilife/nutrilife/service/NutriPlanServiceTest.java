package com.nutrilife.nutrilife.service;

import com.nutrilife.nutrilife.domain.NutriPlan;
import com.nutrilife.nutrilife.repository.NutriPlanRepository;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class NutriPlanServiceTest {

  @Test
  void getById_whenNotFound_throws() {
    NutriPlanRepository repo = Mockito.mock(NutriPlanRepository.class);
    Mockito.when(repo.findById(99L)).thenReturn(Optional.empty());

    NutriPlanService service = new NutriPlanService(repo);

    Assertions.assertThrows(IllegalArgumentException.class, () -> service.getById(99L));
  }

  @Test
  void create_setsIdNull_andSaves() {
    NutriPlanRepository repo = Mockito.mock(NutriPlanRepository.class);
    NutriPlan input = new NutriPlan(10L, "Plan", "Meta", 2000, 7, List.of("Comida 1"), "plantbased", "Tag");

    NutriPlan saved = new NutriPlan(1L, "Plan", "Meta", 2000, 7, List.of("Comida 1"), "plantbased", "Tag");
    Mockito.when(repo.save(Mockito.any(NutriPlan.class))).thenReturn(saved);

    NutriPlanService service = new NutriPlanService(repo);
    NutriPlan result = service.create(input);

    Assertions.assertEquals(1L, result.getId());
    Mockito.verify(repo).save(Mockito.argThat(p -> p.getId() == null));
  }

  @Test
  void getAll_returnsList() {
    NutriPlanRepository repo = Mockito.mock(NutriPlanRepository.class);
    Mockito.when(repo.findAll()).thenReturn(List.of(
            new NutriPlan(1L, "Plan", "Meta", 2000, 7, List.of("Comida"), "keto", "Tag")
    ));

    NutriPlanService service = new NutriPlanService(repo);

    Assertions.assertEquals(1, service.getAll().size());
  }

  @Test
  void update_whenNotFound_throws() {
    NutriPlanRepository repo = Mockito.mock(NutriPlanRepository.class);
    Mockito.when(repo.findById(50L)).thenReturn(Optional.empty());
    NutriPlanService service = new NutriPlanService(repo);

    Assertions.assertThrows(IllegalArgumentException.class, () ->
            service.update(50L, new NutriPlan(null, "X", "Y", 1500, 7, List.of("A"), "k", "t"))
    );
  }

  @Test
  void delete_whenNotFound_throws() {
    NutriPlanRepository repo = Mockito.mock(NutriPlanRepository.class);
    Mockito.when(repo.existsById(99L)).thenReturn(false);
    NutriPlanService service = new NutriPlanService(repo);

    Assertions.assertThrows(IllegalArgumentException.class, () -> service.delete(99L));
  }

  @Test
  void delete_whenExists_deletes() {
    NutriPlanRepository repo = Mockito.mock(NutriPlanRepository.class);
    NutriPlan plan = new NutriPlan(1L, "Plan", "Meta", 2000, 7, List.of("Comida"), "img", "Tag");

    Mockito.when(repo.findById(1L)).thenReturn(Optional.of(plan));

    NutriPlanService service = new NutriPlanService(repo);
    service.delete(1L);

    Mockito.verify(repo).delete(plan);
  }

}
