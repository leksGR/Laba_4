import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Collection;
import java.util.ArrayList;
import java.util.List;

/**
 * Класс для работы с данными
 */
public class Repository {

    /**
     * Коллекция HashMap, хранящая строки
     */
    private final static HashMap<String, String> _map = new HashMap<>();

    // Инициализация данных
    static {
        initializeData();
    }

    /**
     * Метод инициализации данных
     */
    private static void initializeData() {
        _map.put("A", "1a0a1");
        _map.put("B", "1b0b2");
        _map.put("C", "1c0c3");
        _map.put("D", "1d0d4");
        _map.put("E", "1e2e5");
        _map.put("F", "1f0f6");
        _map.put("G", "1g0g7");
        _map.put("H", "1h0h8");
        _map.put("I", "1i0i9");
        _map.put("J", "1j1j0");
    }

    /*private void putNew(String input) {
        String[] newParams = new String[]{String.join(" ", input)};
        _map.put(newParams[0], newParams[1]);
    }*/

    /**
     * Метод возвращает итератор для коллекции
     * @return итератор пар ключ-значение
     */
    public Iterator<Map.Entry<String, String>> getIterator() {
        return _map.entrySet().iterator();
    }

    /**
     * Метод возвращает множество ключей
     * @return множество ключей
     */
    public Set<String> getKeys() {
        return _map.keySet();
    }

    /**
     * Метод возвращает коллекцию значений
     * @return коллекция значений
     */
    public Collection<String> getValues() {
        return _map.values();
    }

    /**
     * Метод возвращает список ключей в виде строк
     * @return список ключей
     */
    public String getKeysAsString() {
        List<String> keys = new ArrayList<>();
        for (Map.Entry<String, String> entry : _map.entrySet()) {
            keys.add(entry.getKey());
        }
        return String.join("\n", keys);
    }
}