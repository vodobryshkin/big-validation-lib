package ru.ifmo.se.validation.parser;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import lombok.AllArgsConstructor;
import lombok.Getter;
import ru.ifmo.se.validation.abstractions.NullHandler;
import ru.ifmo.se.validation.handlers.array.XArrayHandler;
import ru.ifmo.se.validation.handlers.full.XHandler;
import ru.ifmo.se.validation.parser.interfaces.CoordinateParser;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Класс для парсинга данных о координате X.
 */
@AllArgsConstructor
@Getter
public class XCoordinateParser implements CoordinateParser {
    private final String jsonData;
    /**
     * Метод для парсинга данных о координате в экземпляр Handler'а.
     *
     * @return созданный обработчик для координаты X в зависимости от данных в json.
     */
    @Override
    public NullHandler parse() {
        Gson gson = new Gson();
        JsonObject obj = gson.fromJson(jsonData, JsonObject.class);

        String xType = obj.get("xType").getAsString();

        if (xType.equals("including")) {
            JsonObject objX = obj.get("x").getAsJsonObject();
            BigDecimal xLeft = objX.get("leftIncludingBorder").getAsBigDecimal();
            BigDecimal xRight = objX.get("rightIncludingBorder").getAsBigDecimal();

            return new XHandler(xLeft, xRight);
        } else {
            JsonArray decimalList = obj.getAsJsonArray("x");

            List<BigDecimal> values = new ArrayList<>(decimalList.size());
            for (JsonElement e : decimalList) {
                if (e == null || e.isJsonNull()) continue;
                values.add(e.getAsBigDecimal());
            }

            return new XArrayHandler(values);
        }
    }
}
