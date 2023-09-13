package seleniumgluecode;

import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import lombok.Getter;
import models.ScreenRecorder.MyScreenRecorder;
import org.junit.After;
import org.openqa.selenium.WebDriver;
import runner.browser_manager.NavegatorDriverManager;

import java.io.FileReader;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

import static runner.browser_manager.NavegatorDriverManager.loadProperty;


public class Hooks {

    @Getter
    public static WebDriver driver;
    private static int numberOfCase = 0;
    public String grabar = loadProperty.getProperty("grabar");


//    @Before
    public void SetUp(String nameTest) throws Exception {
        numberOfCase++;
        System.out.println("Se está ejecutando el escenario #" + numberOfCase);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        System.out.println("Fecha y hora de ejecución: " + dtf.format(LocalDateTime.now()));
        NavegatorDriverManager.openBrowser();
        driver.get("https://wordcounter.net/");
        driver.manage().window().maximize();
//        if (grabar.equals("s")){
            MyScreenRecorder.startRecording(nameTest);
//        }
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        Thread.sleep(4000);
    }


//    @After
    public void TearDown() throws Exception {
        System.out.println("El escenario # " + numberOfCase + " se ejecutó correctamente");
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        System.out.println("Fecha y hora ejecución finalizada: " + dtf.format(LocalDateTime.now()));
        System.out.println("");
        System.out.println("");
//        if (grabar.equals("s")){
            MyScreenRecorder.stopRecording();
//        }
        driver.quit();
    }
}
