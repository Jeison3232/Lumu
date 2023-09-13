package pom;

import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Set;

import static seleniumgluecode.Hooks.*;

public class BasePage{

    /**
     * Hace click sobre el elemento ingresado
     * @param element es el localizador o campo al cual le vamos a relizar la acción
     * @throws Exception
     */
    public void click(By element) throws Exception {
        try {
            driver.findElement(element).click();
        } catch (Exception e) {
            throw new Exception("No se pudo realizar clic sobre el elemento " + element);
        }
    }

    public void cerrarModales() throws Exception {
        try {
        Alert alert = driver.switchTo().alert();
        alert.accept();
        }catch (Exception e) {
            throw new Exception("No se pudo cerrar el elemento "+ e);
        }
    }

    /**
     * Esta acción realiza un refresh o F5, en la pagina que se encuentra actualmente
     * @throws Exception
     */
    protected void update() throws Exception {
        try {
            JavascriptExecutor executor = (JavascriptExecutor) driver;
            executor.executeScript("location.reload()");
        } catch (Exception e){
            throw new Exception("No se pudo actualizar la pagina");
        }
    }

    /**
     * Esta acción permite enviar un texto en un localizador INPUT el cual pueda ingresar texto libre.
     * @param inputText es para enviar un texto que se desee ingresar en el campo
     * @param locator es el localizador o campo al cual le vamos a relizar la acción
     * @throws Exception
     */
    protected void input(String inputText, By locator) throws Exception {
        try {
            if (inputText != null){
                driver.findElement(locator).clear();
                driver.findElement(locator).sendKeys(inputText);
            } else {
                driver.findElement(locator).sendKeys(inputText);
            }
        } catch (Exception e) {
            throw new Exception("No se pudo escribir en el elemento " + locator);
        }
    }

    /**
     * Esta acción permite seleccionar de una lista desplegable el texto solicitado
     * @param texto se debe enviar en tipo String el texto que se solicita de la lista desplegable
     * @param locator es el localizador o campo al cual le vamos a relizar la acción
     */
    protected void selectElement(String texto,By locator){
        try {
            Select select = new Select(driver.findElement(locator));
            select.selectByVisibleText(texto);
        } catch(Exception e) {
            System.out.print("No se selecciono el localizador: " + locator);
            driver.quit();
        }
    }

    public String getText(By element) throws Exception {
        try {
            return driver.findElement(element).getText();
        }catch (Exception e){
            throw  new Exception("No se encontró el texto del elemento: "+element);
        }
    }

    /**
     * Esta acción permite confirmar si un texto tipo String es igual a otro texto o objeto esperado convertido
     * en String, tienen la misma información
     * @param textExpected se envia un texto o objeto tipo String para ser validado contra el localizador
     * @param locator es el localizador o campo al cual le vamos a relizar la acción
     */
    protected void textEquals(String textExpected, By locator){
        String getText = driver.findElement(locator).getText();
        Assert.assertEquals(textExpected,getText);
        System.out.println("El texto esperado es: " + textExpected);
        System.out.println("El texto actual es: " + getText);
    }

    /**
     * Esta acción permite localizar un objeto en dado caso cuando la automatización no lo logre vizualizar, esta función
     * muestra el localizador en la pantalla y puede seguir realizando las acciones futuras.
     * va a hacer el conteo de las paginas y interactuamos con la ultima que abrimos.
     * @param locator es el localizador o campo al cual le vamos a relizar la acción
     */
    protected void locateObject(By locator){
        try {
            int cont = 0;
            int tamaño = 0;
            Set<String> handles = driver.getWindowHandles();
            tamaño = handles.toArray().length;
            //System.out.println("la cantidad de pestañas es :"+tamaño);
            if(tamaño > 1) {
                //System.out.println("la cantidad de pestañas son :" + tamaño);
                for (String actual : handles) {
                    cont++;
                   // System.out.println("corriendo pestaña : " + cont + " su id pestaña es :" + actual);
                    if (cont == tamaño) {
                        driver.switchTo().window(actual);
                      //  System.out.println("entro a la pestaña con id  :" + actual);
                    }
                }
            }
            WebElement element = driver.findElement(locator);
            Actions actions = new Actions(driver);
            actions.moveToElement(element);
            actions.perform();
        }catch(Exception e) {
            System.out.print("No se encontro el objeto: " + locator);
            driver.quit();
        }
    }

    /**
     * Esta acción permite bajar la barra espaciadora hasta el elemento seleccionado
     * @param locator es el localizador o campo al cual le vamos a relizar la acción
     */
    protected void scrollDown(By locator) {
        WebElement element = driver.findElement(locator);
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("window.scrollBy(0,1000);",element);

    }
    protected void scrollDownManual(int pixeles) {
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("window.scrollBy(0,"+pixeles+");");

    }
    /**
     * Esta acción permite subir la barra espaciadora hasta el elemento seleccionado
     * @param locator es el localizador o campo al cual le vamos a relizar la acción
     */
    protected void scrollUp(By locator) {
        WebElement element = driver.findElement(locator);
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("window.scrollBy(0,-1000)",element);
    }
    protected void scrollUpManual() {
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("window.scrollBy(0,-500)");
    }

    /**
     * Esta acción permite realizar una espera a nuestros localizadores mientras termina de cargar la pagina, si el localizador
     * no es encontrado entre el N° de segundos establecidos, finalizara la prueba indicando que no encontro el localizador
     * @param locator es el localizador o campo al cual le vamos a relizar la acción
     */
    protected void waitImplicit(By locator) {
        try {
            WebDriverWait myWaitVar = new WebDriverWait(driver, Duration.ofSeconds(20));
            myWaitVar.until(ExpectedConditions.visibilityOfElementLocated(locator));
        } catch (Exception e) {
            System.out.print("No se encontro el localizador: " + locator);
            driver.quit();
        }
    }
}
