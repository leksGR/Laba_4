import java.util.HashMap;
import java.util.Set;
import java.util.Map;

/**
 * Класс ключ
 */
public class Key {

    /** Значение ключа */
    private String _value;

    /** Коллекция ключей */
    public final static HashMap<String, Key> _keys = new HashMap<>();

    /**
     * Конструктор по умолчанию
     */
    Key() {
        this._value = "";
    }

    /**
     * Конструктор с параметром
     * @param value значение ключа
     */
    Key (String value) {
        this._value = value;
    }

    // Заполнение коллекции значениями
    static {
        initializeData();
    }

    /**
     * Статический метод инициализации коллекции значениями
     */
    private static void initializeData() {
        Key key1 = new Key("A");
        Key key2 = new Key("B");

        _keys.put(key1._value, key1);
        _keys.put(key2._value, key2);
    }

    /**
     * Нестатический метод возвращает значение ключа
     * @return значение ключа
     */
    public String getValue() {
        return this._value;
    }

    /**
     * Нестатический метод проверяет, является ли ключ пустым
     * @return true если ключ пустой, false в противном случае
     */
    public boolean isEmpty() {
        return this._value == null || this._value.isEmpty();
    }

    /**
     * Статический метод добавления ключей в коллекцию по значению
     * @param value значения ключа
     */
    public static String putNewByValue(String value) {
        if (value == null || value.trim().isEmpty())
            return "У ключа не может быть пустое значение!";
        Key k = new Key(value);
        _keys.put(k.getValue(), k);
        return "Ключ успешно добавлен";
    }

    /**
     * Метод выводит все ключей
     * @return строка ключей
     */
    public static String showAll() {
        HashMapIterator iterator = new HashMapIterator(Key._keys);
        if (!iterator.hasNextKey())
            return "Список пуст!";

        StringBuilder sb = new StringBuilder("keys:\n");

        while (iterator.hasNextKey()) {
            Map.Entry<String, Key> entry = iterator.nextKey();
            Key key = entry.getValue();

            if (!key.isEmpty()) {
                sb.append(key.getValue()).append("\n");
            }
        }
        return sb.toString();
    }
}