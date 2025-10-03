package r;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.ifmo.se.validation.handlers.RArrayHandler;
import ru.ifmo.se.validation.parser.RCoordinateParser;
import ru.ifmo.se.validation.request.ValidationRequest;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RCoordinateParserTest {
    @Test
    @DisplayName("Значение входит в массив.")
    public void valueInTheArrayTest() throws IOException {
        String json = Files.readString(Path.of("/home/vodobryshkin/progs/proj/IdeaProjects/coordinates-validation-web-labs/src/main/resources/array-val.json"));
        RCoordinateParser xCoordinateParser = new RCoordinateParser(json);
        RArrayHandler xArrayHandler = (RArrayHandler) xCoordinateParser.parse();

        ValidationRequest validationRequest = new ValidationRequest("1", "1", "1");

        assertTrue(xArrayHandler.handle(validationRequest));
    }

    @Test
    @DisplayName("Отрицательное значение входит в массив .")
    public void negativeValueInTheArrayTest() throws IOException {
        String json = Files.readString(Path.of("/home/vodobryshkin/progs/proj/IdeaProjects/coordinates-validation-web-labs/src/main/resources/array-val.json"));
        RCoordinateParser xCoordinateParser = new RCoordinateParser(json);
        RArrayHandler xArrayHandler = (RArrayHandler) xCoordinateParser.parse();

        ValidationRequest validationRequest = new ValidationRequest("-5", "1", "-5");

        assertTrue(xArrayHandler.handle(validationRequest));
    }

    @Test
    @DisplayName("Дробное значение входит в массив .")
    public void floatValueInTheArrayTest()  throws IOException {
        String json = Files.readString(Path.of("/home/vodobryshkin/progs/proj/IdeaProjects/coordinates-validation-web-labs/src/main/resources/array-val.json"));
        RCoordinateParser xCoordinateParser = new RCoordinateParser(json);
        RArrayHandler xArrayHandler = (RArrayHandler) xCoordinateParser.parse();

        ValidationRequest validationRequest = new ValidationRequest("1.2", "1", "1.2");

        assertTrue(xArrayHandler.handle(validationRequest));
    }

    @Test
    @DisplayName("Значение не входит в массив.")
    public void valueNotInTheArrayTest()  throws IOException {
        String json = Files.readString(Path.of("/home/vodobryshkin/progs/proj/IdeaProjects/coordinates-validation-web-labs/src/main/resources/array-val.json"));
        RCoordinateParser xCoordinateParser = new RCoordinateParser(json);
        RArrayHandler xArrayHandler = (RArrayHandler) xCoordinateParser.parse();

        ValidationRequest validationRequest = new ValidationRequest("10", "1", "110");

        assertFalse(xArrayHandler.handle(validationRequest));
    }
}

