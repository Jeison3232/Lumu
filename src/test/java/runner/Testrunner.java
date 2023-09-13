package runner;

import io.cucumber.junit.*;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.AfterClass;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        //features = "src/test/java/features/testWebTable.feature", // se pueden ejecutar directamente llamando los features junto con los tags
        features = "src/test/java/features/",
        glue = {"seleniumgluecode"},
        plugin = {"json:ReporteCucumber/cucumber_report.json"},
        tags = "@prueba" // Se pueden ejecutar desde los tags de los features que desean
)
public class Testrunner {
    // Para los reportes es necesario tener instalado NodeJS en su PC
    @AfterClass
    public static void finish(){
        try {
            System.out.println("El reporte se esta generando");
//            String [] cmd = {"cmd.exe","/c","npm run report"};
//            Runtime.getRuntime().exec("npm run report");
            System.out.println("Reporte Generado satisfactoriamente!!!");
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

}