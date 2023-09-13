package pom;

import org.junit.Assert;
import org.openqa.selenium.By;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

public class contadorPage extends BasePage {

    By cuadroTexto = By.id("box");
    By primerParrafo = By.cssSelector("#description p:nth-of-type(1)");
    By segundoParrafo = By.cssSelector("#description p:nth-of-type(2)");
    By tercerParrafo = By.cssSelector("#description p:nth-of-type(3)");
    By cuartoParrafo = By.cssSelector("#description p:nth-of-type(4)");
    By quintoParrafo = By.cssSelector("#description p:nth-of-type(5)");
    By conteoCaracteres = By.id("character_count");
    By conteoPalabras = By.id("word_count");


    public void escribirCuadroTexto(String frase) throws Exception {
        click(cuadroTexto);
        Thread.sleep(1000);
        input(frase,cuadroTexto);
        Thread.sleep(1000);
    }

    public void validarCantidadCaracteres(String frase) throws Exception {
        System.out.println("");
        System.out.println("Numero de Caracteres: " + frase.split("|\\s+|\n|,|").length);
        String validarTexto = String.valueOf(frase.split("|\\s+|\n|,|").length);
        if (validarTexto.equals(getText(conteoCaracteres))){
            System.out.println("El conteo de caracteres enviados "+validarTexto+", son iguales al que se muestra en wordCounter "+getText(conteoCaracteres)+"!!!!.");
        } else {
            System.out.println("Error, no concuerda la cantidad de caracteres enviados.");
            Assert.fail("Error, no concuerda la cantidad de caracteres enviados.");
        }
    }

    public void validarCantidadPalabras(String frase) throws Exception {
        String text = frase;
        text = text.replace(",", "").replace(".", "").replace(":", "");
        System.out.println("Numero de palabras: " + text.split("\\s+|\n").length);
        String validarTexto = String.valueOf(text.split("\\s+|\n").length);
        if (validarTexto.equals(getText(conteoPalabras))){
            System.out.println("El conteo de palabras enviado "+validarTexto+", es igual al que se muestra en wordCounter "+getText(conteoPalabras)+"!!!!.");
        } else {
            System.out.println("Error, no concuerda la cantidad de palabras enviadas.");
            Assert.fail("Error, no concuerda la cantidad de palabras enviadas.");
        }
        System.out.println("");
        System.out.println("Palabras repetidas: ");
        String[] palabras = text.split(" ");
        HashMap<String, Integer> palabrasFrecuentes = new HashMap<>();
        for (String palabra : palabras) {
            if (palabrasFrecuentes.containsKey(palabra)) {
                palabrasFrecuentes.put(palabra, palabrasFrecuentes.get(palabra) + 1);
            } else {
                palabrasFrecuentes.put(palabra, 1);
            }
        }
        Arrays.sort(palabras, Collections.reverseOrder());

        for (HashMap.Entry<String, Integer> entry : palabrasFrecuentes.entrySet()) {
            System.out.printf("Palabra '%s' con una repetición de: %d\n", entry.getKey(), entry.getValue());
        }
    }

    public void contarPalabrasPrimerParrafo() throws Exception {
        String text = String.valueOf(getText(primerParrafo));
        System.out.println("PRIMER PARRAFO**************************************");
        System.out.println("Numero de Caracteres: " + text.split("|\\s+|\n|,|").length);

        text = text.replace(",", "").replace(".", "").replace(":", "");
        System.out.println("Numero de palabras: " + text.split("\\s+|\n").length);

        String[] palabras = text.split(" ");
        HashMap<String, Integer> palabrasFrecuentes = new HashMap<>();
        for (String palabra : palabras) {
            if (palabrasFrecuentes.containsKey(palabra)) {
                palabrasFrecuentes.put(palabra, palabrasFrecuentes.get(palabra) + 1);
            } else {
                palabrasFrecuentes.put(palabra, 1);
            }
        }
        Arrays.sort(palabras, Collections.reverseOrder());

        for (HashMap.Entry<String, Integer> entry : palabrasFrecuentes.entrySet()) {
            System.out.printf("Palabra '%s' con una repetición de: %d\n", entry.getKey(), entry.getValue());
        }

        System.out.println("Parrafo 1: " + getText(primerParrafo));
    }

    public void confirmarConteoPrimerParrafo() throws Exception {
        String text = String.valueOf(getText(primerParrafo));
        int textConteo = text.split("|\\s+|\n|,|").length;
        int conteoCaracteresWeb = Integer.parseInt(getText(conteoCaracteres));
        System.out.println("Numero de Caracteres: " + text.split("|\\s+|\n|,|").length);
        if (textConteo == conteoCaracteresWeb){
            System.out.println("Conteo de caracteres el igual");
        } else {
            Assert.fail("Error, no concuerda la cantidad de caracteres.");
        }
    }


    public void contarPalabrasSegundoParrafo() throws Exception {
        System.out.println("SEGUNDO PARRAFO**************************************");
        String text = String.valueOf(getText(segundoParrafo));
        System.out.println("Numero de Caracteres: " + text.split("|\\s+|\n|,|").length);
        text = text.replace(",", "").replace(".", "").replace(":", "");
        System.out.println("Numero de palabras: " + text.split("\\s+|\n").length);
        String[] palabras = text.split(" ");

        HashMap<String, Integer> palabrasFrecuentes = new HashMap<>();
        for (String palabra : palabras) {
            if (palabrasFrecuentes.containsKey(palabra)) {
                palabrasFrecuentes.put(palabra, palabrasFrecuentes.get(palabra) + 1);
            } else {
                palabrasFrecuentes.put(palabra, 1);
            }
        }
        Arrays.sort(palabras, Collections.reverseOrder());

        for (HashMap.Entry<String, Integer> entry : palabrasFrecuentes.entrySet()) {
            System.out.printf("Palabra '%s' con una repetición de: %d\n", entry.getKey(), entry.getValue());
        }
        System.out.println("Parrafo 2: " + getText(segundoParrafo));
    }


    public void contarPalabrasTercerParrafo() throws Exception {
        System.out.println("TERCER PARRAFO**************************************");
        String text = String.valueOf(getText(tercerParrafo));

        System.out.println("Numero de Caracteres: " + text.split("|\\s+|\n|,|").length);
        text = text.replace(",", "").replace(".", "").replace(":", "");
        System.out.println("Numero de palabras: " + text.split("\\s+|\n").length);
        String[] palabras = text.split(" ");

        HashMap<String, Integer> palabrasFrecuentes = new HashMap<>();
        for (String palabra : palabras) {
            if (palabrasFrecuentes.containsKey(palabra)) {
                palabrasFrecuentes.put(palabra, palabrasFrecuentes.get(palabra) + 1);
            } else {
                palabrasFrecuentes.put(palabra, 1);
            }
        }
        Arrays.sort(palabras, Collections.reverseOrder());

        for (HashMap.Entry<String, Integer> entry : palabrasFrecuentes.entrySet()) {
            System.out.printf("Palabra '%s' con una repetición de: %d\n", entry.getKey(), entry.getValue());
        }

        System.out.println("Parrafo 3: " + getText(tercerParrafo));
    }

    public void contarPalabrasCuartoParrafo() throws Exception {
        System.out.println("CUARTO PARRAFO**************************************");
        String text = String.valueOf(getText(cuartoParrafo));

        System.out.println("Numero de Caracteres: " + text.split("|\\s+|\n|,|").length);
        text = text.replace(",", "").replace(".", "").replace(":", "");
        System.out.println("Numero de palabras: " + text.split("\\s+|\n").length);
        String[] palabras = text.split(" ");

        HashMap<String, Integer> palabrasFrecuentes = new HashMap<>();
        for (String palabra : palabras) {
            if (palabrasFrecuentes.containsKey(palabra)) {
                palabrasFrecuentes.put(palabra, palabrasFrecuentes.get(palabra) + 1);
            } else {
                palabrasFrecuentes.put(palabra, 1);
            }
        }
        Arrays.sort(palabras, Collections.reverseOrder());

        for (HashMap.Entry<String, Integer> entry : palabrasFrecuentes.entrySet()) {
            System.out.printf("Palabra '%s' con una repetición de: %d\n", entry.getKey(), entry.getValue());
        }

        System.out.println("Parrafo 4: " + getText(cuartoParrafo));
    }

    public void contarPalabrasQuintoParrafo() throws Exception {
        System.out.println("QUINTO PARRAFO**************************************");
        String text = String.valueOf(getText(quintoParrafo));

        System.out.println("Numero de Caracteres: " + text.split("|\\s+|\n|,|").length);
        text = text.replace(",", "").replace(".", "").replace(":", "");
        System.out.println("Numero de palabras: " + text.split("\\s+|\n").length);
        String[] palabras = text.split(" ");

        HashMap<String, Integer> palabrasFrecuentes = new HashMap<>();
        for (String palabra : palabras) {
            if (palabrasFrecuentes.containsKey(palabra)) {
                palabrasFrecuentes.put(palabra, palabrasFrecuentes.get(palabra) + 1);
            } else {
                palabrasFrecuentes.put(palabra, 1);
            }
        }
        Arrays.sort(palabras, Collections.reverseOrder());

        for (HashMap.Entry<String, Integer> entry : palabrasFrecuentes.entrySet()) {
            System.out.printf("Palabra '%s' con una repetición de: %d\n", entry.getKey(), entry.getValue());
        }

        System.out.println("Parrafo 5: " + getText(quintoParrafo));
    }

}
