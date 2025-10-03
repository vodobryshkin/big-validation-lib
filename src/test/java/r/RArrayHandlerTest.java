package r;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.ifmo.se.validation.handlers.RArrayHandler;
import ru.ifmo.se.validation.request.ValidationRequest;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RArrayHandlerTest {
    @Test
    @DisplayName("Значение входит в массив.")
    public void valueInTheArrayTest() {
        List<BigDecimal> arrayList = new ArrayList<>();

        arrayList.add(new BigDecimal("1"));
        arrayList.add(new BigDecimal("2"));
        arrayList.add(new BigDecimal("3"));
        arrayList.add(new BigDecimal("-4"));
        arrayList.add(new BigDecimal("-5"));
        arrayList.add(new BigDecimal("-6"));

        RArrayHandler rArrayHandler = new RArrayHandler(arrayList);

        ValidationRequest validationRequest = new ValidationRequest("1", "1", "1");

        assertTrue(rArrayHandler.handle(validationRequest));
    }

    @Test
    @DisplayName("Отрицательное значение входит в массив .")
    public void negativeValueInTheArrayTest() {
        List<BigDecimal> arrayList = new ArrayList<>();

        arrayList.add(new BigDecimal("1"));
        arrayList.add(new BigDecimal("2"));
        arrayList.add(new BigDecimal("3"));
        arrayList.add(new BigDecimal("-4"));
        arrayList.add(new BigDecimal("-5"));
        arrayList.add(new BigDecimal("-6"));

        RArrayHandler rArrayHandler = new RArrayHandler(arrayList);

        ValidationRequest validationRequest = new ValidationRequest("-5", "-5", "-5");

        assertTrue(rArrayHandler.handle(validationRequest));
    }

    @Test
    @DisplayName("Дробное значение входит в массив .")
    public void floatValueInTheArrayTest() {
        List<BigDecimal> arrayList = new ArrayList<>();

        arrayList.add(new BigDecimal("1.0000000000000000000000001"));
        arrayList.add(new BigDecimal("2"));
        arrayList.add(new BigDecimal("3"));
        arrayList.add(new BigDecimal("-4"));
        arrayList.add(new BigDecimal("-5"));
        arrayList.add(new BigDecimal("-6"));

        RArrayHandler rArrayHandler = new RArrayHandler(arrayList);

        ValidationRequest validationRequest = new ValidationRequest("1", "1", "1.0000000000000000000000001");

        assertTrue(rArrayHandler.handle(validationRequest));
    }

    @Test
    @DisplayName("Значение не входит в массив.")
    public void valueNotInTheArrayTest() {
        List<BigDecimal> arrayList = new ArrayList<>();

        arrayList.add(new BigDecimal("1"));
        arrayList.add(new BigDecimal("2"));
        arrayList.add(new BigDecimal("3"));
        arrayList.add(new BigDecimal("-4"));
        arrayList.add(new BigDecimal("-5"));
        arrayList.add(new BigDecimal("-6"));

        RArrayHandler rArrayHandler = new RArrayHandler(arrayList);

        ValidationRequest validationRequest = new ValidationRequest("10", "11", "-1");

        assertFalse(rArrayHandler.handle(validationRequest));
    }
}
