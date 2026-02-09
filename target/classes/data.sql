-- =========================
-- NUTRIlife - DATA.SQL
-- =========================

-- 1) TOP RECOMENDADO
INSERT INTO nutri_plans (id, name, goal, calories_per_day, days, image_key, tag)
VALUES (1, 'Plan Mediterráneo', 'Salud cardiovascular / Mantenimiento', 2000, 14, 'mediterraneo', 'Top recomendado');
INSERT INTO nutri_plan_meals (nutri_plan_id, meal) VALUES (1, 'Desayuno: Yogur griego + frutos rojos + nueces');
INSERT INTO nutri_plan_meals (nutri_plan_id, meal) VALUES (1, 'Almuerzo: Ensalada mediterránea con garbanzos y aceite de oliva');
INSERT INTO nutri_plan_meals (nutri_plan_id, meal) VALUES (1, 'Cena: Salmón al horno + verduras asadas');
INSERT INTO nutri_plan_meals (nutri_plan_id, meal) VALUES (1, 'Snack: Fruta + queso fresco');

INSERT INTO nutri_plans (id, name, goal, calories_per_day, days, image_key, tag)
VALUES (2, 'Plan Balance Total', 'Bienestar general / Hábitos saludables', 1950, 14, 'mediterraneo', 'Top recomendado');
INSERT INTO nutri_plan_meals (nutri_plan_id, meal) VALUES (2, 'Desayuno: Avena + manzana + canela');
INSERT INTO nutri_plan_meals (nutri_plan_id, meal) VALUES (2, 'Almuerzo: Bowl de quinoa + pollo + verduras');
INSERT INTO nutri_plan_meals (nutri_plan_id, meal) VALUES (2, 'Cena: Ensalada completa + atún + aceite de oliva');
INSERT INTO nutri_plan_meals (nutri_plan_id, meal) VALUES (2, 'Snack: Fruta + nueces');

-- 2) BAJO SODIO
INSERT INTO nutri_plans (id, name, goal, calories_per_day, days, image_key, tag)
VALUES (3, 'Plan DASH', 'Reducir presión arterial', 1900, 7, 'dash', 'Bajo sodio');
INSERT INTO nutri_plan_meals (nutri_plan_id, meal) VALUES (3, 'Desayuno: Avena con plátano y canela');
INSERT INTO nutri_plan_meals (nutri_plan_id, meal) VALUES (3, 'Almuerzo: Pollo a la plancha + quinoa + ensalada');
INSERT INTO nutri_plan_meals (nutri_plan_id, meal) VALUES (3, 'Cena: Sopa de verduras + tostada integral');
INSERT INTO nutri_plan_meals (nutri_plan_id, meal) VALUES (3, 'Snack: Yogur natural sin azúcar');

INSERT INTO nutri_plans (id, name, goal, calories_per_day, days, image_key, tag)
VALUES (4, 'Plan Control de Sodio', 'Retención de líquidos / Bienestar', 1850, 10, 'dash', 'Bajo sodio');
INSERT INTO nutri_plan_meals (nutri_plan_id, meal) VALUES (4, 'Desayuno: Omelette de claras + espinaca');
INSERT INTO nutri_plan_meals (nutri_plan_id, meal) VALUES (4, 'Almuerzo: Pescado al vapor + arroz integral + ensalada');
INSERT INTO nutri_plan_meals (nutri_plan_id, meal) VALUES (4, 'Cena: Crema de calabaza (sin sal añadida) + pan integral');
INSERT INTO nutri_plan_meals (nutri_plan_id, meal) VALUES (4, 'Snack: Fruta + yogur natural');

-- 3) FITNESS
INSERT INTO nutri_plans (id, name, goal, calories_per_day, days, image_key, tag)
VALUES (5, 'Plan Alto en Proteína', 'Definición / Ganancia muscular', 2300, 10, 'proteina', 'Fitness');
INSERT INTO nutri_plan_meals (nutri_plan_id, meal) VALUES (5, 'Desayuno: Tortilla de claras con espinaca');
INSERT INTO nutri_plan_meals (nutri_plan_id, meal) VALUES (5, 'Almuerzo: Bowl de pavo + arroz integral + brócoli');
INSERT INTO nutri_plan_meals (nutri_plan_id, meal) VALUES (5, 'Cena: Atún + ensalada + aguacate');
INSERT INTO nutri_plan_meals (nutri_plan_id, meal) VALUES (5, 'Snack: Requesón (cottage) + almendras');

INSERT INTO nutri_plans (id, name, goal, calories_per_day, days, image_key, tag)
VALUES (6, 'Plan Definición Fitness', 'Mantener músculo / Mejor composición corporal', 2150, 10, 'proteina', 'Fitness');
INSERT INTO nutri_plan_meals (nutri_plan_id, meal) VALUES (6, 'Desayuno: Huevos + pan integral + fruta');
INSERT INTO nutri_plan_meals (nutri_plan_id, meal) VALUES (6, 'Almuerzo: Carne magra + quinoa + ensalada');
INSERT INTO nutri_plan_meals (nutri_plan_id, meal) VALUES (6, 'Cena: Pechuga de pollo + verduras al horno');
INSERT INTO nutri_plan_meals (nutri_plan_id, meal) VALUES (6, 'Snack: Yogur griego + nueces');

-- 4) SIN CARNE
INSERT INTO nutri_plans (id, name, goal, calories_per_day, days, image_key, tag)
VALUES (7, 'Plan Vegetariano Balanceado', 'Bienestar general', 1850, 7, 'vegetariano', 'Sin carne');
INSERT INTO nutri_plan_meals (nutri_plan_id, meal) VALUES (7, 'Desayuno: Smoothie verde (espinaca, mango, yogur)');
INSERT INTO nutri_plan_meals (nutri_plan_id, meal) VALUES (7, 'Almuerzo: Lentejas guisadas + ensalada');
INSERT INTO nutri_plan_meals (nutri_plan_id, meal) VALUES (7, 'Cena: Tacos de tofu + verduras salteadas');
INSERT INTO nutri_plan_meals (nutri_plan_id, meal) VALUES (7, 'Snack: Hummus + zanahoria');

INSERT INTO nutri_plans (id, name, goal, calories_per_day, days, image_key, tag)
VALUES (8, 'Plan Sin Carne Ligero', 'Control de porciones / Bienestar', 1650, 7, 'vegetariano', 'Sin carne');
INSERT INTO nutri_plan_meals (nutri_plan_id, meal) VALUES (8, 'Desayuno: Yogur + chía + fruta');
INSERT INTO nutri_plan_meals (nutri_plan_id, meal) VALUES (8, 'Almuerzo: Ensalada de lentejas + vegetales');
INSERT INTO nutri_plan_meals (nutri_plan_id, meal) VALUES (8, 'Cena: Sopa de verduras + pan integral');
INSERT INTO nutri_plan_meals (nutri_plan_id, meal) VALUES (8, 'Snack: Hummus + pepino');

-- 5) LOW CARB
INSERT INTO nutri_plans (id, name, goal, calories_per_day, days, image_key, tag)
VALUES (9, 'Plan Keto Controlado', 'Reducir carbohidratos (bajo supervisión)', 2100, 7, 'keto', 'Low carb');
INSERT INTO nutri_plan_meals (nutri_plan_id, meal) VALUES (9, 'Desayuno: Huevos revueltos + aguacate');
INSERT INTO nutri_plan_meals (nutri_plan_id, meal) VALUES (9, 'Almuerzo: Ensalada César (sin crutones) + pollo');
INSERT INTO nutri_plan_meals (nutri_plan_id, meal) VALUES (9, 'Cena: Carne magra + verduras bajas en carbohidratos');
INSERT INTO nutri_plan_meals (nutri_plan_id, meal) VALUES (9, 'Snack: Nueces / aceitunas');

INSERT INTO nutri_plans (id, name, goal, calories_per_day, days, image_key, tag)
VALUES (10, 'Plan Bajo en Carbohidratos', 'Control de azúcar / Energía estable', 1850, 7, 'keto', 'Low carb');
INSERT INTO nutri_plan_meals (nutri_plan_id, meal) VALUES (10, 'Desayuno: Huevos + aguacate + café');
INSERT INTO nutri_plan_meals (nutri_plan_id, meal) VALUES (10, 'Almuerzo: Ensalada completa + atún');
INSERT INTO nutri_plan_meals (nutri_plan_id, meal) VALUES (10, 'Cena: Carne magra + ensalada verde');
INSERT INTO nutri_plan_meals (nutri_plan_id, meal) VALUES (10, 'Snack: Aceitunas + nueces');

-- 6) ALTA FIBRA
INSERT INTO nutri_plans (id, name, goal, calories_per_day, days, image_key, tag)
VALUES (11, 'Plan Fibra Plus', 'Mejor digestión / Saciedad', 1800, 10, 'plantbased', 'Alta fibra');
INSERT INTO nutri_plan_meals (nutri_plan_id, meal) VALUES (11, 'Desayuno: Avena + chía + manzana');
INSERT INTO nutri_plan_meals (nutri_plan_id, meal) VALUES (11, 'Almuerzo: Ensalada de garbanzos + verduras');
INSERT INTO nutri_plan_meals (nutri_plan_id, meal) VALUES (11, 'Cena: Lentejas + vegetales salteados');
INSERT INTO nutri_plan_meals (nutri_plan_id, meal) VALUES (11, 'Snack: Fruta + semillas');
