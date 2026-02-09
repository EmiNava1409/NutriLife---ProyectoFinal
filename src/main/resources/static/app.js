const API = "/api/nutrilife-plans";


const PHOTO_POOL = [
  "https://okdiario.com/img/2025/06/11/cenas-ligeras-con-carne.jpg",
  "https://img.freepik.com/fotos-premium/mezcla-verduras-hervidas-plato_73872-2439.jpg",
  "https://mejorconsalud.as.com/wp-content/uploads/2019/05/platos-de-la-dieta-mediterranea.jpg",
  "https://docs3.hmhospitales.com/app/uploads/2025/03/20100942/beneficios-alimentos-fibra-imagen1.jpg",
  "https://www.brillante.es/wp-content/uploads/2024/11/Menu-vegetariano.jpg",
  "https://cdn0.uncomo.com/es/posts/1/3/9/realfooding_que_es_y_en_que_consiste_51931_orig.jpg",
  "https://www.sportlife.es/uploads/s1/75/75/68/6/5dadceb80ee694a573349419-dieta-baja-en-carbohidratos-estos-son-los-alimentos-clave.jpeg",
  "https://assets.zyrosite.com/cdn-cgi/image/format=auto,w=315,h=240,fit=crop/A0x1bvvWNqHp0o5N/disea--o-sin-tatulo-12-mnlW3M8BLxsDyRbL.png",
  "https://www.dietistasnutricionistas.es/wp-content/uploads/2021/02/products-in-textile-bags-glassware-eco-friendly-sh-8TVJRBG-1024x683.jpg",
  "https://www.diariomedico.pe/wp-content/uploads/2020/01/10-consejos-basicos-para-una-alimentacion-saludabl.jpg",
  "https://cdn1.cocina-familiar.com/pasos/thumb/15657.jpg"
];

function sanitize(str) {
  return (str ?? "").replaceAll("<", "&lt;").replaceAll(">", "&gt;");
}
function cleanName(name) {
  return (name || "").replace(/\d+\s*d[ií]as?/gi, "").trim();
}

/* ============ MODAL ============ */
const modalEl = () => document.getElementById("modal");

function setModalOpen(open) {
  modalEl().setAttribute("aria-hidden", String(!open));
  document.body.style.overflow = open ? "hidden" : "";
}

function openModal(item) {
  document.getElementById("mTitle").textContent = item.name || "Plan";
  document.getElementById("mGoal").textContent = item.goal || "";
  document.getElementById("mTag").textContent = item.tag || "Plan saludable";

  const img = item.imageUrl || PHOTO_POOL[0];
  const mImg = document.getElementById("mImg");
  mImg.src = img;

  document.getElementById("mMeta").innerHTML = `
    <span>${sanitize(String(item.caloriesPerDay ?? 0))} kcal/día</span>
    <span>${sanitize(String(item.days ?? 0))} días</span>
  `;

  const meals = Array.isArray(item.meals) ? item.meals : [];
  document.getElementById("mMeals").innerHTML =
    meals.map((m) => `<li>${sanitize(m)}</li>`).join("");

  setModalOpen(true);
}

function attachModalEvents() {
  modalEl().addEventListener("click", (e) => {
    if (e.target?.dataset?.close) setModalOpen(false);
  });
  document.addEventListener("keydown", (e) => {
    if (e.key === "Escape" && modalEl().getAttribute("aria-hidden") === "false") {
      setModalOpen(false);
    }
  });
}

/* ============ MENÚ (planes del backend, con imagen) ============ */
function imageForApiPlan(p) {
  const id = Number(p.id);
  if (Number.isFinite(id) && id > 0) {
    return PHOTO_POOL[(id - 1) % PHOTO_POOL.length];
  }
  return PHOTO_POOL[0];
}

function normalizeMeals(p) {
  // tu API puede devolver meals o no
  if (Array.isArray(p.meals)) return p.meals;
  if (Array.isArray(p.mealList)) return p.mealList;
  return [];
}

function renderMenu(allApiPlans) {
  const menu = document.getElementById("menuGrid");

  menu.innerHTML = allApiPlans
    .map(
      (p) => `
    <div class="menuItem" data-id="${sanitize(String(p.id))}" tabindex="0">
      <div class="menuThumb">
        <img src="${sanitize(p.imageUrl)}" alt="${sanitize(p.name)}">
      </div>

      <div class="menuName">${sanitize(cleanName(p.name))}</div>
      <div class="menuDesc">${sanitize(p.goal || "")}</div>

      <div class="menuBottom">
        <span class="chip chip--green">${sanitize(p.tag || "Saludable")}</span>
        <span class="chip">${sanitize(String(p.days || 0))} días</span>
      </div>
    </div>
  `
    )
    .join("");

  menu.querySelectorAll(".menuItem").forEach((el) => {
    const open = () => {
      const plan = allApiPlans.find((p) => String(p.id) === String(el.dataset.id));
      if (plan) openModal(plan);
    };
    el.onclick = open;
    el.onkeydown = (e) => {
      if (e.key === "Enter" || e.key === " ") {
        e.preventDefault();
        open();
      }
    };
  });
}

/* ============ PLANES POR EDAD (3 tarjetas estilo tu imagen) ============ */
const AGE_PLANS = [
  {
    id: "age1",
    name: "Plan Adulto",
    goal: "Energía, control de porciones y hábitos sostenibles para el día a día.",
    tag: "Recomendado",
    caloriesPerDay: 2000,
    days: 14,
    meals: [
      "Desayuno: Avena + fruta + yogur natural",
      "Almuerzo: Pollo/pescado + arroz integral + ensalada",
      "Cena: Ensalada completa + proteína ligera",
      "Snack: Fruta + nueces",
    ],
    imageUrl:
      "https://thumbs.dreamstime.com/b/adulto-comiendo-sano-feliz-saludable-con-verduras-en-casa-231459308.jpg",
  },
  {
    id: "age2",
    name: "Plan Niño",
    goal: "Comidas simples, nutritivas y fáciles, pensadas para crecimiento y energía.",
    tag: "Para niños",
    caloriesPerDay: 1800,
    days: 10,
    meals: [
      "Desayuno: Pan integral + huevo + fruta",
      "Almuerzo: Arroz + pollo + verduras",
      "Cena: Crema de verduras + tostada integral",
      "Snack: Yogur natural + fruta",
    ],
    imageUrl:
      "https://saposyprincesas.elmundo.es/assets/2011/04/comer-sano-tambien-en-vacaciones.jpg",
  },
  {
    id: "age3",
    name: "Plan Tercera Edad",
    goal: "Suave, digestivo y balanceado. Enfocado en proteína, fibra y menos sodio.",
    tag: "Cuidado",
    caloriesPerDay: 1700,
    days: 14,
    meals: [
      "Desayuno: Avena suave + plátano + canela",
      "Almuerzo: Pescado al vapor + vegetales + arroz",
      "Cena: Sopa de verduras + proteína ligera",
      "Snack: Fruta blanda + yogur natural",
    ],
    imageUrl:
      "https://teleasistenciavital.com/wp-content/uploads/2024/04/Alimentacion-saludable-adultos-mayores.png",
  },
];

function renderAgePlans() {
  const wrap = document.getElementById("ageGrid");

  wrap.innerHTML = AGE_PLANS
    .map(
      (p) => `
    <div class="ageCard" data-id="${sanitize(String(p.id))}" tabindex="0">
      <div class="ageCircle">
        <img src="${sanitize(p.imageUrl)}" alt="${sanitize(p.name)}">
      </div>

      <div class="ageSmall">NUTRIlife</div>
      <div class="ageName">${sanitize(p.name)}</div>
      <div class="ageDesc">${sanitize(p.goal)}</div>

      <div class="agePlus">+</div>
    </div>
  `
    )
    .join("");

  wrap.querySelectorAll(".ageCard").forEach((el) => {
    const open = () => {
      const plan = AGE_PLANS.find((p) => String(p.id) === String(el.dataset.id));
      if (plan) openModal(plan);
    };
    el.onclick = open;
    el.onkeydown = (e) => {
      if (e.key === "Enter" || e.key === " ") {
        e.preventDefault();
        open();
      }
    };
  });
}

/* ============ INIT ============ */
async function init() {
  attachModalEvents();
  document.getElementById("year").textContent = new Date().getFullYear();

  // Hero image
  document.getElementById("heroImg").src =
  "https://images.squarespace-cdn.com/content/v1/561718ebe4b062a227c4fcf2/4a1f1f7a-03d6-45a2-a32d-3c06ab10940c/Gemini_Generated_Image_wdyub5wdyub5wdyu.jpeg"
  ;

  // Cargar backend para el menú
  let apiRaw = [];
  try {
    const res = await fetch(API);
    apiRaw = await res.json();
  } catch (e) {
    apiRaw = [];
  }

  const apiPlans = (Array.isArray(apiRaw) ? apiRaw : []).map((p) => ({
    id: p.id,
    name: p.name || "Plan",
    goal: p.goal || "",
    caloriesPerDay: p.caloriesPerDay ?? p.calories_per_day ?? 0,
    days: p.days ?? 0,
    tag: p.tag || "Saludable",
    meals: normalizeMeals(p),
    imageUrl: imageForApiPlan(p),
  }));

  renderMenu(apiPlans);
  renderAgePlans();
}

document.addEventListener("DOMContentLoaded", init);