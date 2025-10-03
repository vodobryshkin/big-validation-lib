package managers;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.ifmo.se.validation.managers.ValidationManager;
import ru.ifmo.se.validation.request.ValidationRequest;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ValidationManagerArrayTest {
    @Test
    @DisplayName("Валидация правильного запроса.")
    void testChainAllCorrect() throws IOException {
        ValidationManager validationManager = new ValidationManager("/home/vodobryshkin/progs/proj/IdeaProjects/coordinates-validation-web-labs/src/main/resources/array-val.json");
        String x = "2";
        String y = "2";
        String r = "2";

        ValidationRequest validationRequest = new ValidationRequest(x, y, r);
        assertTrue(validationManager.validate(validationRequest));
    }

    @Test
    @DisplayName("Валидация полностью неправильного запроса.")
    void testChainAllIncorrect() throws IOException {
        ValidationManager validationManager = new ValidationManager("/home/vodobryshkin/progs/proj/IdeaProjects/coordinates-validation-web-labs/src/main/resources/array-val.json");
        String x = "-10";
        String y = "-10";
        String r = "-10";

        ValidationRequest validationRequest = new ValidationRequest(x, y, r);
        assertFalse(validationManager.validate(validationRequest));
    }

    @Test
    @DisplayName("Валидация запроса с неправильным X.")
    void testChainXIncorrect() throws IOException {
        ValidationManager validationManager = new ValidationManager("/home/vodobryshkin/progs/proj/IdeaProjects/coordinates-validation-web-labs/src/main/resources/array-val.json");
        String x = "-10";
        String y = "1";
        String r = "2";

        ValidationRequest validationRequest = new ValidationRequest(x, y, r);
        assertFalse(validationManager.validate(validationRequest));
    }

    @Test
    @DisplayName("Валидация запроса с неправильным Y.")
    void testChainYIncorrect() throws IOException {
        ValidationManager validationManager = new ValidationManager("/home/vodobryshkin/progs/proj/IdeaProjects/coordinates-validation-web-labs/src/main/resources/array-val.json");
        String x = "2";
        String y = "1.4";
        String r = "2";

        ValidationRequest validationRequest = new ValidationRequest(x, y, r);
        assertFalse(validationManager.validate(validationRequest));
    }

    @Test
    @DisplayName("Валидация запроса с неправильным R.")
    void testChainRIncorrect() throws IOException {
        ValidationManager validationManager = new ValidationManager("/home/vodobryshkin/progs/proj/IdeaProjects/coordinates-validation-web-labs/src/main/resources/array-val.json");
        String x = "2";
        String y = "1";
        String r = "1.4";

        ValidationRequest validationRequest = new ValidationRequest(x, y, r);
        assertFalse(validationManager.validate(validationRequest));
    }
}
