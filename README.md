# Final Project 7SWI – E-shop backend

Springboot aplikace pro e-shop s využitím Spring Data JPA, Spring Security do předmětu 7SWI1 za pomocí Reactu.
Projekt využívá Docker Desktop pro spuštění databáze PostgreSQL a pro běh aplikace.

## Technologie
- Java
- Spring Boot
- Spring Security (JWT)
- Spring Data JPA
- PostgreSQL
- Maven
- React (Frontend)
- Docker Desktop

## Spuštění aplikace
1. **Docker**: Ujistěte se, že máte nainstalovaný Docker Desktop a běží na vašem počítači.
2. **Databáze**: Databázi lze spustit pomocí spuštění souboru `docker-compose.yml`, který vytvoří kontejner s PostgreSQL (pokud ještě neexistuje) a následně jej spustí.
3. **Vložení dat do databáze**: Pro vložení testovacích dat importujte CSV soubory z adresáře `DB data` do databáze (například pomocí IDE nástrojů, pokud to umožňují). CSV soubory obsahují testovací data pro všechny potřebné tabulky (uživatelé, produkty, kategorie atd.). CSV mají jako první řádek header s názvy sloupců a jsou odděleny čárkou (`,`).   **Doporučené pořadí importu (pokud nelze vložit všechny najednou):**
   - `brand`
   - `product_category`
   - `product`
   - `app_user`
   - `address`
   - `cart_item`
   - `order_information`
   - `order_item`
4. **Backend**: Spusťte backend aplikaci pomocí spuštění třídy `FinalProject7SwiApplication` v IDE.
5. **Frontend**: Spusťte frontend aplikaci pomocí příkazu `npm install` a `npm run dev` v adresáři `frontend` projektu.

## Testovací účet
Pro testování aplikace můžete použít následující přihlašovací údaje: <br />
E-mail: test@test.com  <br />
Heslo: Heslo123

## API klíče
Tento veřejně dostupný projekt obsahuje API klíče a JWT token určené pro jednoduché testování a demonstraci aplikace. Tyto klíče a token nejsou jakkoliv spojeny s mou identitou, nejsou zpoplatněné a nelze s nimi překročit žádný bezpečný limit. Ve finální verze aplikace by tyto klíče a tokeny měly být bezpečně uloženy a spravovány, například pomocí .env a nevyskytovaly by se v GitHub repozitáři.

