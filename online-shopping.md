# Testovací Scénáře pro Online Shopping

## 1. Vyhledávání položek (Search Items)

### Scénář 1: Úspěšné vyhledání položek

**Předpoklad:** Uživatel je na hlavní stránce a je připojen k internetu.  
**Kroky:**
1. Uživatel zadá do vyhledávacího pole platné klíčové slovo.
2. Uživatel klikne na tlačítko pro vyhledání.  
   **Očekávaný výsledek:** Systém zobrazí seznam položek odpovídajících klíčovému slovu.

### Scénář 2: Vyhledávání s nulovým výsledkem

**Předpoklad:** Uživatel je na hlavní stránce a je připojen k internetu.  
**Kroky:**
1. Uživatel zadá do vyhledávacího pole neexistující klíčové slovo.
2. Uživatel klikne na tlačítko pro vyhledání.  
   **Očekávaný výsledek:** Systém zobrazí zprávu "Položky nenalezeny."

## 2. Procházení položek (Browse Items)

### Scénář 3: Procházení dostupných kategorií

**Předpoklad:** Uživatel je na hlavní stránce a je připojen k internetu.  
**Kroky:**
1. Uživatel klikne na kategorii z hlavního menu.  
   **Očekávaný výsledek:** Systém zobrazí seznam položek dostupných v dané kategorii.

## 3. Zobrazení položky (View Item)

### Scénář 4: Zobrazení detailů položky

**Předpoklad:** Uživatel je na stránce s výsledky vyhledávání nebo v kategorii.  
**Kroky:**
1. Uživatel klikne na název nebo obrázek položky.  
   **Očekávaný výsledek:** Systém zobrazí detailní informace o vybrané položce.

## 4. Přidání položky do košíku (Add to Shopping Cart)

### Scénář 5: Úspěšné přidání položky do košíku

**Předpoklad:** Uživatel je na detailní stránce položky.  
**Kroky:**
1. Uživatel klikne na tlačítko "Přidat do košíku".  
   **Očekávaný výsledek:** Systém přidá položku do nákupního košíku a zobrazí potvrzovací zprávu.

## 5. Zobrazení nákupního košíku (View Shopping Cart)

### Scénář 6: Zobrazení obsahu košíku

**Předpoklad:** Uživatel přidal alespoň jednu položku do košíku.  
**Kroky:**
1. Uživatel klikne na ikonu nebo odkaz "Košík".  
   **Očekávaný výsledek:** Systém zobrazí seznam všech položek v nákupním košíku.

## 6. Aktualizace nákupního košíku (Update Shopping Cart)

### Scénář 7: Aktualizace množství položky v košíku

**Předpoklad:** Uživatel má položky v nákupním košíku.  
**Kroky:**
1. Uživatel klikne na košík.
2. Uživatel změní množství položky.
3. Uživatel klikne na tlačítko "Aktualizovat".  
   **Očekávaný výsledek:** Systém aktualizuje množství položky a celkovou cenu.

## 7. Pokračování k pokladně (Proceed to Checkout)

### Scénář 8: Pokračování k pokladně

**Předpoklad:** Uživatel má položky v nákupním košíku.  
**Kroky:**
1. Uživatel klikne na tlačítko "Pokračovat k pokladně".  
   **Očekávaný výsledek:** Systém přesměruje uživatele na stránku s pokladnou.

## 8. Dokončení nákupu (Checkout)

### Scénář 9: Úspěšné dokončení nákupu

**Předpoklad:** Uživatel je na stránce s pokladnou a má vyplněné všechny povinné údaje.  
**Kroky:**
1. Uživatel vyplní všechny potřebné údaje pro doručení a platbu.
2. Uživatel klikne na tlačítko "Dokončit nákup".  
   **Očekávaný výsledek:** Systém zpracuje objednávku a zobrazí potvrzovací stránku s číslem objednávky.