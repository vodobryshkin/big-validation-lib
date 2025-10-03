package y;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.ifmo.se.validation.handlers.YArrayHandler;
import ru.ifmo.se.validation.parser.YCoordinateParser;
import ru.ifmo.se.validation.request.ValidationRequest;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class YCoordinateParserTest {
    @Test
    @DisplayName("Значение входит в массив.")
    public void valueInTheArrayTest() throws IOException {
        String json = Files.readString(Path.of("/home/vodobryshkin/progs/proj/IdeaProjects/coordinates-validation-web-labs/src/main/resources/array-val.json"));
        YCoordinateParser xCoordinateParser = new YCoordinateParser(json);
        YArrayHandler xArrayHandler = (YArrayHandler) xCoordinateParser.parse();

        ValidationRequest validationRequest = new ValidationRequest("1", "1", "1");

        assertTrue(xArrayHandler.handle(validationRequest));
    }

    @Test
    @DisplayName("Отрицательное значение входит в массив .")
    public void negativeValueInTheArrayTest() throws IOException {
        String json = Files.readString(Path.of("/home/vodobryshkin/progs/proj/IdeaProjects/coordinates-validation-web-labs/src/main/resources/array-val.json"));
        YCoordinateParser xCoordinateParser = new YCoordinateParser(json);
        YArrayHandler xArrayHandler = (YArrayHandler) xCoordinateParser.parse();

        ValidationRequest validationRequest = new ValidationRequest("-5", "-5", "1");

        assertTrue(xArrayHandler.handle(validationRequest));
    }

    @Test
    @DisplayName("Дробное значение входит в массив .")
    public void floatValueInTheArrayTest()  throws IOException {
        String json = Files.readString(Path.of("/home/vodobryshkin/progs/proj/IdeaProjects/coordinates-validation-web-labs/src/main/resources/array-val.json"));
        YCoordinateParser xCoordinateParser = new YCoordinateParser(json);
        YArrayHandler xArrayHandler = (YArrayHandler) xCoordinateParser.parse();

        ValidationRequest validationRequest = new ValidationRequest("1.2", "1.2", "1");

        assertTrue(xArrayHandler.handle(validationRequest));
    }

    @Test
    @DisplayName("Значение не входит в массив.")
    public void valueNotInTheArrayTest()  throws IOException {
        String json = Files.readString(Path.of("/home/vodobryshkin/progs/proj/IdeaProjects/coordinates-validation-web-labs/src/main/resources/array-val.json"));
        YCoordinateParser xCoordinateParser = new YCoordinateParser(json);
        YArrayHandler xArrayHandler = (YArrayHandler) xCoordinateParser.parse();

        ValidationRequest validationRequest = new ValidationRequest("10", "11", "1");

        assertFalse(xArrayHandler.handle(validationRequest));
    }

    @Test
    @DisplayName("Значение не входит в массив.")
    public void valueNotInTheArrayTest2()  throws IOException {
        String json = Files.readString(Path.of("/home/vodobryshkin/progs/proj/IdeaProjects/coordinates-validation-web-labs/src/main/resources/array-val.json"));
        YCoordinateParser xCoordinateParser = new YCoordinateParser(json);
        YArrayHandler xArrayHandler = (YArrayHandler) xCoordinateParser.parse();

        ValidationRequest validationRequest = new ValidationRequest("10", "6", "1");

        assertFalse(xArrayHandler.handle(validationRequest));
    }
}
