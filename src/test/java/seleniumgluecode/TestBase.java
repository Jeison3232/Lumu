package seleniumgluecode;

import org.openqa.selenium.WebDriver;
import pom.contadorPage;

public class TestBase {

    protected WebDriver driver = Hooks.getDriver();
    protected Hooks hooks = new Hooks();
    protected contadorPage ContadorPage = new contadorPage();

}