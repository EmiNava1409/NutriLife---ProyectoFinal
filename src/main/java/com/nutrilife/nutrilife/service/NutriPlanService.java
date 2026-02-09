package com.nutrilife.nutrilife.service;

import com.nutrilife.nutrilife.domain.NutriPlan;
import com.nutrilife.nutrilife.repository.NutriPlanRepository;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class NutriPlanService {

  private final NutriPlanRepository repository;

  public NutriPlanService(NutriPlanRepository repository) {
    this.repository = repository;
  }

  public NutriPlan create(NutriPlan plan) {
    plan.setId(null);
    return repository.save(plan);
  }

  public List<NutriPlan> getAll() {
    return repository.findAll();
  }

  public NutriPlan getById(Long id) {
    return repository.findById(id)
        .orElseThrow(() -> new IllegalArgumentException("Plan not found: " + id));
  }

  public NutriPlan update(Long id, NutriPlan updated) {
    NutriPlan existing = getById(id);
    existing.setName(updated.getName());
    existing.setGoal(updated.getGoal());
    existing.setCaloriesPerDay(updated.getCaloriesPerDay());
    existing.setDays(updated.getDays());
    existing.setMeals(updated.getMeals());
    existing.setImageKey(updated.getImageKey());
    existing.setTag(updated.getTag());
    return repository.save(existing);
  }

  public void delete(Long id) {
    NutriPlan existing = getById(id);
    repository.delete(existing);
  }
}
