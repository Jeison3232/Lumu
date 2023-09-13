package seleniumgluecode.Consulta;

import io.cucumber.java.en.*;
import seleniumgluecode.TestBase;

import static models.ScreenRecorder.MyScreenRecorder.startRecording;

public class loginDefinition extends TestBase {

    @Given("Ingresar al sitio wordCounter {string}")
    public void ingresarAlSitioPLEXI(String nameTest) throws Exception {
        hooks.SetUp(nameTest);

    }

    @Given("Contar las palabas")
    public void contar_las_palabas() throws Exception {
        ContadorPage.contarPalabrasPrimerParrafo();
        ContadorPage.confirmarConteoPrimerParrafo();
        ContadorPage.contarPalabrasSegundoParrafo();
        ContadorPage.contarPalabrasTercerParrafo();
        hooks.TearDown();
    }

    @Given("Escribir en el campo de texto {string}")
    public void escribirEnElCampoDeTexto(String frase) throws Exception {
        ContadorPage.escribirCuadroTexto(frase);
    }

    @And("validar cantidad de palabras {string}")
    public void validarCantidadDePalabras(String frase) throws Exception {
        ContadorPage.validarCantidadPalabras(frase);
    }

    @And("Validar cantidad de caracteres {string}")
    public void validarCantidadDeCaracteres(String frase) throws Exception {
        ContadorPage.validarCantidadCaracteres(frase);
    }

    @Then("Finalizar prueba")
    public void finalizarPrueba() throws Exception {
        hooks.TearDown();
    }
}
