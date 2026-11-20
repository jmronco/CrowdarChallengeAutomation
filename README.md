# Challenge Automation Crowdar

Proyecto de automatización con Selenium, Java, Maven y TestNG. Usa Page Object Model con Page Factory.

Qué incluye:

- Pruebas web sobre [SauceDemo](https://www.saucedemo.com/): login válido, usuario bloqueado y agregar dos productos al carrito.
- Una prueba de servicio web contra Mercado Libre (`GET https://www.mercadolibre.com.ar/menu/departments`) que verifica que la respuesta traiga departamentos.
- Captura de pantalla automática cuando una prueba falla.
- Reportes HTML y XML después de cada ejecución.
- Ejecución en Chrome y Edge.

## Requisitos

- Java 21
- Maven 3.9 o superior
- Google Chrome y/o Microsoft Edge instalados
- Conexión a internet (Selenium descarga el driver solo la primera vez)

Para revisar que todo esté bien instalado:

```
java -version
mvn -version
```

## Instalación

1. Clona el repositorio:
   ```
   git clone https://github.com/jmronco/CrowdarChallengeAutomation.git
   cd Challenge Automation Crowdar
   ```
2. Descarga las dependencias:
   ```
   mvn clean install -DskipTests
   ```

## Cómo ejecutar las pruebas

Todas las pruebas en Chrome (es el navegador por defecto):

```
mvn clean test
```

Todas las pruebas en Edge:

```
mvn clean test -Dbrowser=edge
```

Si usas IntelliJ, puedes ejecutar la clase `SauceDemoTests` o `MercadoLibreApiTests` con el botón verde. Para elegir Edge, agrega `-Dbrowser=edge` en *VM options* de la configuración de ejecución.

## Fallo intencional

Como pide el reto, una prueba falla a propósito: `SauceDemoTests.invalidLogin`. Compara el mensaje de error del usuario bloqueado con un texto incorrecto (constante `LOCKED_USER_ERROR_MESSAGE` en `Constants.java`). Por eso `mvn test` termina con `BUILD FAILURE`: 5 pruebas, 1 fallo. Es lo esperado. Al fallar se guarda una captura de pantalla en `target/screenshots/`.

Para verla en verde, cambia la constante por `"Epic sadface: Sorry, this user has been locked out."`.

## Evidencias

En `evidencias/` hay reportes y capturas de una ejecución en Chrome y otra en Edge.

## Dónde ver los resultados

- Reportes: `target/surefire-reports/`. Abre `index.html` o `emailable-report.html` en el navegador. Los XML están en la misma carpeta (`testng-results.xml`).
- Capturas de pantalla de pruebas fallidas: `target/screenshots/`.

Ojo: `mvn clean` borra la carpeta `target`, así que copia los reportes a otro lugar si quieres conservarlos.

## Estructura

```
src/test/java/org/
  api/         Cliente HTTP para el servicio web
  constants/   Constantes (URLs, usuarios, mensajes)
  pages/       Page Objects (LoginPage, CartPage, BasePage)
  utils/       DriverFactory y ScreenshotUtil
  tests/       BaseTest, TestListener, SauceDemoTests, MercadoLibreApiTests
```
