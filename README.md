# ☕ Školní projekty – Java

Objektově orientované programování v Javě ze střední školy.
Najdeš tu menší simulace a textové hry, na kterých jsem se učil **třídy, dědičnost, polymorfismus a abstraktní třídy**.

---

## ⭐ Nejzajímavější projekty

### ⚔️ `hrdina_dedicnost/` – textová RPG hra
Hrdina (🛡️ rytíř nebo 🧙 kouzelník) prochází lokace, jako je les nebo cesta, bojuje s nepřáteli (🔥 ohnivý a ❄️ mrazivý kostlivec) a nakupuje v obchodě.
- společná abstraktní třída `Hrdina`, z ní dědí `Rytir` a `Kouzelnik`
- nepřátelé a lokace jsou také postavené na dědičnosti
- polymorfismus: každý typ hrdiny a nepřítele se chová jinak

### 🏠 `simici/` – simulace domácnosti
Simík má potřeby a v domácnosti používá předměty, třeba jídlo a elektroniku.
- hierarchie předmětů: `Predmet` → `Jidlo`, `Elektronika`

### 🚀 `vesmirna stanice/` – vesmírná stanice
Stanice řídí drony, které těží asteroidy.

---

## 📂 Další cvičení

| Projekt | Co dělá |
|---|---|
| 🚗 `mycka/` | Autoservis s myčkou: zákazníci, auta a mycí boxy |
| 💻 `servis IT/` | IT servis: technici, zákazníci a opravovaná zařízení |
| 🔧 `autoservis/` | Jednoduchá evidence aut v servisu |
| 🐣 `Tamagochi/`, `tamagochi.java` | Virtuální mazlíček |
| 🌾 `Farmig_simulator.java` | Jednoduchý farmářský simulátor |
| ✨ `obchod_s_kouzly.java` | Obchod s kouzly |
| 🔐 `Mavenproject1.java` | Caesarova šifra: šifrování a dešifrování textu posunem v abecedě |

---

## ▶️ Spuštění

Většina projektů je v jedné složce nebo v jednom souboru. Zkompiluj je a spusť třídu s metodou `main`:

```bash
cd mycka
javac *.java
java Mycka
```

> 💡 Projekty `hrdina_dedicnost` a `simici` jsou v balíčcích (`com.mycompany...`), protože vznikly v NetBeans.
> Nejsnáz se spustí, když je otevřeš v IDE (NetBeans, IntelliJ IDEA).

---

🛠️ **Technologie:** Java · OOP · NetBeans
