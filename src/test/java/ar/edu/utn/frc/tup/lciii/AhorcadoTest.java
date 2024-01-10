package ar.edu.utn.frc.tup.lciii;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AhorcadoTest {
    private final InputStream systemIn = System.in;
    private final PrintStream systemOut = System.out;

    private ByteArrayOutputStream testOut;

    @BeforeEach
    public void setUpOutput() {
        testOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(testOut));
    }

    @AfterEach
    public void restoreSystemInputOutput() {
        System.setIn(systemIn);
        System.setOut(systemOut);
    }

    @Test
    @DisplayName("Testing de Bienvenida")
    public void testCase1(){
        Ahorcado ahorcado = new Ahorcado();
        ahorcado.bienvenida();
        assertEquals(
                "------------------------------------" + System.lineSeparator() +
                        "---------Welcome to Ahorcado---------" + System.lineSeparator() +
                        "------------------------------------" + System.lineSeparator(), getOutput());
    }

    @Test
    @DisplayName("Testing de metodo privado")
    public void testCase2() throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        Ahorcado ahorcado = new Ahorcado();
        Method metodoPrivado = Ahorcado.class.getDeclaredMethod("isNumeric", String.class);
        metodoPrivado.setAccessible(true);
        metodoPrivado.invoke(ahorcado, "1");
    }
    private String getOutput() {
        return testOut.toString();
    }
}
