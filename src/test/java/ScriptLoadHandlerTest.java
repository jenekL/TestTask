import entities.VulnerabilityScript;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


class ScriptLoadHandlerTest {
    private ScriptLoadHandler scriptLoadHandler = new ScriptLoadHandler(new DataService());

    @Test
    void shouldReturnFullScriptList() {
        List<VulnerabilityScript> scripts = new ArrayList<>(
                Arrays.asList(
                        new VulnerabilityScript(8, new ArrayList<>()),
                        new VulnerabilityScript(9, new ArrayList<>()),
                        new VulnerabilityScript(4, new ArrayList<>(Arrays.asList(8, 9))),
                        new VulnerabilityScript(10, new ArrayList<>()),
                        new VulnerabilityScript(11, new ArrayList<>()),
                        new VulnerabilityScript(5, new ArrayList<>(Arrays.asList(10, 11))),
                        new VulnerabilityScript(2, new ArrayList<>(Arrays.asList(4, 5))),
                        new VulnerabilityScript(12, new ArrayList<>()),
                        new VulnerabilityScript(13, new ArrayList<>()),
                        new VulnerabilityScript(6, new ArrayList<>(Arrays.asList(12, 13))),
                        new VulnerabilityScript(7, new ArrayList<>()),
                        new VulnerabilityScript(3, new ArrayList<>(Arrays.asList(6, 7))),
                        new VulnerabilityScript(1, new ArrayList<>(Arrays.asList(2, 3)))
                )
        );
        assertIterableEquals(scripts, scriptLoadHandler.start(1));
    }

    @Test
    void shouldReturnNotNullList() {
        assertNotNull(scriptLoadHandler.start(7).toArray());
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 6, 7})
    void shouldReturnListWithLastElementEqualsArgument(int argument) {
        final List<VulnerabilityScript> loadScripts = scriptLoadHandler.start(argument);
        assertEquals(argument, loadScripts.get(loadScripts.size() - 1).getScriptId());
    }

    @Test
    @DisplayName("ShouldReturnListWithSingleElement")
    void shouldReturnSingletonList() {
        assertEquals(1, scriptLoadHandler.start(7).size());
    }

    @Test
    void assertThrowException() {
        assertThrows(IndexOutOfBoundsException.class,
                () -> scriptLoadHandler.start(20));
    }

    @Test
    void shouldThrowException() {
        Throwable exception = assertThrows(IndexOutOfBoundsException.class,
                () -> scriptLoadHandler.start(20));
        assertEquals(exception.getMessage(), "not existing dependency");
    }
}