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
    private static HashMap<String, String> _map = new HashMap<>();

    // Инициализация данных
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
        _map.put("E", "125");
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