package com.nutrilife.nutrilife.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "nutri_plans")
public class NutriPlan {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotBlank
  @Column(nullable = false)
  private String name;

  @NotBlank
  @Column(nullable = false)
  private String goal;

  @NotNull
  @Min(800)
  @Max(6000)
  @Column(name = "calories_per_day", nullable = false)
  private Integer caloriesPerDay;

  @NotNull
  @Min(1)
  @Max(31)
  @Column(nullable = false)
  private Integer days;

  @ElementCollection
  @CollectionTable(name = "nutri_plan_meals", joinColumns = @JoinColumn(name = "nutri_plan_id"))
  @Column(name = "meal", nullable = false)
  private List<String> meals = new ArrayList<>();

  // UI helpers (front)
  @Column(name = "image_key")
  private String imageKey;

  @Column(name = "tag")
  private String tag;

  public NutriPlan() {}

  public NutriPlan(Long id, String name, String goal, Integer caloriesPerDay, Integer days, List<String> meals, String imageKey, String tag) {
    this.id = id;
    this.name = name;
    this.goal = goal;
    this.caloriesPerDay = caloriesPerDay;
    this.days = days;
    this.meals = meals == null ? new ArrayList<>() : meals;
    this.imageKey = imageKey;
    this.tag = tag;
  }

  public Long getId() { return id; }
  public void setId(Long id) { this.id = id; }

  public String getName() { return name; }
  public void setName(String name) { this.name = name; }

  public String getGoal() { return goal; }
  public void setGoal(String goal) { this.goal = goal; }

  public Integer getCaloriesPerDay() { return caloriesPerDay; }
  public void setCaloriesPerDay(Integer caloriesPerDay) { this.caloriesPerDay = caloriesPerDay; }

  public Integer getDays() { return days; }
  public void setDays(Integer days) { this.days = days; }

  public List<String> getMeals() { return meals; }
  public void setMeals(List<String> meals) { this.meals = meals == null ? new ArrayList<>() : meals; }

  public String getImageKey() { return imageKey; }
  public void setImageKey(String imageKey) { this.imageKey = imageKey; }

  public String getTag() { return tag; }
  public void setTag(String tag) { this.tag = tag; }
}
