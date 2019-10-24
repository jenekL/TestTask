import entities.VulnerabilityScript;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


class ScriptLoadHandlerTest {
    private ScriptLoadHandler scriptLoadHandler = new ScriptLoadHandler(new DataService());

    @Test
    void mainLoad() {
        scriptLoadHandler.startScript(1);
    }

    @Test
    void assertThrowException() {
        assertThrows(IndexOutOfBoundsException.class,
                () -> scriptLoadHandler.startScript(
                        new VulnerabilityScript(2, new ArrayList<>(Arrays.asList(5, 6, 15)))
                ));
    }

    @Test
    void shouldThrowException() {
        Throwable exception = assertThrows(IndexOutOfBoundsException.class,
                () -> scriptLoadHandler.startScript(
                new VulnerabilityScript(
                        1,
                        new ArrayList<>(Arrays.asList(5, 6, 15))
                )));
        assertEquals(exception.getMessage(), "out of array");
    }

}