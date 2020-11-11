package validacao;

import org.junit.Assert;

import java.util.Date;

public class Asserts {


    public static void assertEquals(String expected, String actual) {
        System.out.println("Esperado: " + expected + " Retornou: " + actual);
        Assert.assertEquals(expected, actual);
    }

    //sobrecarga: metodo com mesmo nome com parametros diferentes
    public static void assertEquals(int expected, int actual) {
        System.out.println("Esperado: " + expected + " Retornou: " + actual);
        Assert.assertEquals(expected, actual);
    }

    public static void assertEquals(Date expected, Date actual) {
        System.out.println("Esperado: " + expected + " Retornou: " + actual);
        Assert.assertEquals(expected, actual);
    }




}
