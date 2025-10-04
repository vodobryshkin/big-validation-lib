package x;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.ifmo.se.validation.handlers.isnumber.XIsNumberHandler;
import ru.ifmo.se.validation.request.ValidationRequest;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class XIsNumberTest {
    @Test
    @DisplayName("Проверка x скипнется.")
    public void valueInTheArrayTest() {
        List<BigDecimal> arrayList = new ArrayList<>();

        arrayList.add(new BigDecimal("1"));
        arrayList.add(new BigDecimal("2"));
        arrayList.add(new BigDecimal("3"));
        arrayList.add(new BigDecimal("-4"));
        arrayList.add(new BigDecimal("-5"));
        arrayList.add(new BigDecimal("-6"));

        XIsNumberHandler xIsNumberHandler = new XIsNumberHandler();

        ValidationRequest validationRequest = new ValidationRequest("1000000", "1", "1");

        assertTrue(xIsNumberHandler.handle(validationRequest));
    }

    @Test
    @DisplayName("Проверка r не скипнется.")
    public void isNotANumber() {
        List<BigDecimal> arrayList = new ArrayList<>();

        arrayList.add(new BigDecimal("1"));
        arrayList.add(new BigDecimal("2"));
        arrayList.add(new BigDecimal("3"));
        arrayList.add(new BigDecimal("-4"));
        arrayList.add(new BigDecimal("-5"));
        arrayList.add(new BigDecimal("-6"));

        XIsNumberHandler xIsNumberHandler = new XIsNumberHandler();

        ValidationRequest validationRequest = new ValidationRequest("вова", "1", "1");

        assertFalse(xIsNumberHandler.handle(validationRequest));
    }
}
