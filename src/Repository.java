import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Collection;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * Класс для работы с данными
 */
public class Repository {
    /**
     * Коллекция HashMap, хранящая строки
     */
    private static HashMap<String, String> _map = new HashMap<>();

    static {
        initializeData();
    }

    /**
     * Метод инициализации данных
     */
    private static void initializeData() {
        _map.put("A", "101");
        _map.put("B", "102");
        _map.put("C", "103");
        _map.put("D", "104");
        _map.put("E", "105");
        _map.put("F", "106");
        _map.put("G", "107");
        _map.put("H", "108");
        _map.put("I", "109");
        _map.put("J", "110");
    }

    /**
     * Метод возвращает итератор для коллекции
     * @return итератор пар ключ-значение
     */
    public static Iterator<Map.Entry<String, String>> getIterator() {
        return _map.entrySet().iterator();
    }

    /**
     * Метод возвращает множество ключей
     * @return множество ключей
     */
    public static Set<String> getKeys() {
        return _map.keySet();
    }

    /**
     * Метод возвращает коллекцию значений
     * @return коллекция значений
     */
    public static Collection<String> getValues() {
        return _map.values();
    }

    /**
     * Метод возвращает список ключей в виде строк
     * @return список ключей
     */
    public static String getKeysAsString() {
        List<String> keys = new ArrayList<>();
        Iterator<Map.Entry<String, String>> iterator = _map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, String> entry = iterator.next();
            keys.add(entry.getKey());
        }
        return String.join("\n", keys);
    }

    /**
     * Метод сохраняет полный отчет в файл
     * @param filename имя файла
     * @return true - если запись успешна, false - в противном случае
     */
    public static boolean saveToFile(String filename) {
        try {
            List<String> lines = new ArrayList<>();

            Iterator<Map.Entry<String, String>> iterator = getIterator();
            while (iterator.hasNext()) {
                Map.Entry<String, String> entry = iterator.next();
                lines.add(entry.getKey() + " = " + entry.getValue());
            }
            lines.add("");

            lines.add("keys");
            for (String key : getKeys()) {
                lines.add(key);
            }
            lines.add("");

            lines.add("values");
            for (String value : getValues()) {
                lines.add(value);
            }

            Files.write(Paths.get(filename), lines);
            return true;
        } catch (IOException e) {
            return false;
        }
    }
}