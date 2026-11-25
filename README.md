# CSM – Czech Soil Map (Česká půdní mapa)

Mobilní aplikace pro Android určená pro pedologický výzkum, terénní průzkum a ekologické mapování na území České republiky. Aplikace kombinuje interaktivní mapové služby ČGS (Česká geologická služba), ČÚZK a VÚMOP (KPP) s terénním deníkem a katalogem půdních typů.

---

## 🌟 Hlavní funkce

* 🗺️ **Interaktivní terénní mapa** – Zobrazení půdních typů ČGS 1:50 000, WRB 2022, historických půdních map KPP 1961–1970, geologických vrstev ČGS GEOČR50 a výškového reliéfu ČÚZK DMR 5G.
* 📍 **Terénní dokumentace & Sondy** – Ukládání terénních bodů, horizontů půdního profilu (Munsellovy barvy, zrnitost, struktura), poznámek a fotografií.
* 📏 **Tranzity a profil reliéfu** – Měření tranzitů s živým výškovým profilem terénu.
* 💾 **Export dat** – Export uložených bodů a tranzitů do GeoJSON, GPX a CSV.
* 📚 **Půdní katalog** – Přehledný seznam půdních typů dle české i mezinárodní klasifikace.
* 🌐 **Česko-anglické rozhraní** – Plná lokalizace aplikace i mapových podkladů.

---

## 🗺️ Plán rozvoje a modernizace (Krok za krokem)

Na základě vybraných priorit je připraven následující postup rozvoje aplikace:

### Fáze 1: Vyčištění projektu a aktualizace závislostí
* [ ] **1.1 Odstranění neaktivního kódu (Dead Code Cleanup)**
  * Odstranění zbytků starých `.java` souborů vzniklých při migraci do Kotlinu (`MainActivity.java`, `SplashActivity.java`, `CustomListAdapter.java`, `SoilAdapter.java` a dalších).
* [ ] **1.2 Aktualizace Target SDK a AndroidX knihoven**
  * Povýšení `compileSdk` a `targetSdk` z verze 33 na 35 (Android 15) v `app/build.gradle`.
  * Aktualizace závislostí (`androidx.appcompat`, `com.google.android.material`, `navigation-ui-ktx`).

### Fáze 2: Vylepšení Půdního katalogu
* [ ] **2.1 Náhledy a ilustrace půdních typů**
  * Nahrazení generovaných dvoupsímenných zástupných kruhů v `SoilAdapter.kt` a `DetailActivity.kt` reálnými fotografiemi a schématy půdních profilů.
* [ ] **2.2 Rozšířené filtrování**
  * Přidání filtrů podle půdních druhů (písčité, hlinité, jílovité), zamokření (gleje, pseudogleje) a klasifikace WRB v `GalleryFragment.kt`.
* [ ] **2.3 Propojení Katalogu s Mapou**
  * Přidání tlačítka „Zobrazit na mapě“ v detailu půdy s automatickým vyhledáním typických oblastí výskytu v mapovém okně.

### Fáze 3: Pokročilé mapové funkce a offline provoz
* [ ] **3.1 Nástroj pro vizuální srovnání vrstev (Swipe / Side-by-side slider)**
  * Implementace Leaflet posuvníku pro živé srovnání např. historické KPP / leteckého snímku ČÚZK vs. půdní mapy ČGS.
* [ ] **3.2 Offline kešování mapových kachlíků (Tile Caching / ServiceWorker)**
  * Implementace offline paměti kachlíků v HTML/JS Leaflet modulu pro práci na poli bez mobilního signálu.

### Fáze 4: Modernizace UI a Tmavý režim (Material 3 & Dark Mode)
* [ ] **4.1 Podpora Material 3 & Edge-to-Edge**
  * Sjednocení motivu na Material 3 a podporu celoplošného zobrazení.
* [ ] **4.2 Podpora tmavého režimu (Dark Mode)**
  * Příprava tmavého stylu pro aplikaci i HTML Leaflet podklad pro noční/šero pozorování.

---

## 🛠️ Architektura a technologie

* **Jazyk:** Kotlin 1.8+ / Android SDK 33 → 35
* **Architektura:** Android Architecture Components (Navigation Component, ViewModel, LiveData / StateFlow)
* **Mapové jádro:** WebView + Leaflet.js 1.9, ArcGIS REST Services (ČGS, ČÚZK), WMS (VÚMOP KPP)
* **Databáze terénních dat:** LocalStorage + IndexedDB (fotografie v plném rozlišení)

---

## 📄 Licencování a poděkování

Projekt vznikl na Katedře archeologie Filozofické fakulty Univerzity Karlovy.
Použitá data a webové služby:
* © Česká geologická služba (ČGS)
* © Český úřad zeměměřický a katastrální (ČÚZK)
* © VÚMOP, v.v.i. (Komplexní průzkum půd KPP)
* © CENIA, Česká informační agentura životního prostředí
