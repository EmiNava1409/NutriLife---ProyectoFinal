package com.nutrilife.nutrilife.controller;

import com.nutrilife.nutrilife.domain.NutriPlan;
import com.nutrilife.nutrilife.service.NutriPlanService;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/nutrilife-plans")
public class NutriPlanController {

  private final NutriPlanService service;

  public NutriPlanController(NutriPlanService service) {
    this.service = service;
  }

  @GetMapping
  public List<NutriPlan> getAll() {
    return service.getAll();
  }

  @GetMapping("/{id}")
  public NutriPlan getById(@PathVariable Long id) {
    return service.getById(id);
  }

  @PostMapping
  public ResponseEntity<NutriPlan> create(@Valid @RequestBody NutriPlan plan) {
    NutriPlan created = service.create(plan);
    return ResponseEntity.status(HttpStatus.CREATED).body(created);
  }

  @PutMapping("/{id}")
  public NutriPlan update(@PathVariable Long id, @Valid @RequestBody NutriPlan plan) {
    return service.update(id, plan);
  }

  @DeleteMapping("/{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void delete(@PathVariable Long id) {
    service.delete(id);
  }
}