package runner.browser_manager;

import models.ScreenRecorder.MyScreenRecorder;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileReader;
import java.util.Properties;

import static seleniumgluecode.Hooks.driver;

public class NavegatorDriverManager{

    public static Properties loadProperty = new Properties();

    public static void openBrowser() throws Exception {
        String sDirectorioTrabajo = System.getProperty("user.dir");
        loadProperty.load(new FileReader("./params.properties"));
        String browser = loadProperty.getProperty("nav");
//        System.out.printf("Browser: ******"+browser+" ******");
        if (browser.equals("google")) {
            System.setProperty("webdriver.chrome.driver", sDirectorioTrabajo + "/src/test/resources/Chromedriver/chromedriver.exe");
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.addArguments("--remote-allow-origins=*");
            driver = new ChromeDriver(chromeOptions);
        } else if (browser.equals("firefox")) {
            System.setProperty("webdriver.gecko.driver", sDirectorioTrabajo+"/src/test/resources/Drivers/geckodriver.exe");
            driver = new FirefoxDriver();
        } else if (browser.equals("edge")) {
            System.setProperty("webdriver.edge.drive", sDirectorioTrabajo+"/src/test/resources/Drivers/msedgedriver.exe");
            driver = new EdgeDriver();

        }else {
            throw new Exception("Error al ingresar con el navegador.");
        }
    }
}
