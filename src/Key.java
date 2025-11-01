import java.util.HashMap;
import java.util.Set;

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
        //...//
        _keys.put(key1._value, key1);
        _keys.put(key2._value, key2);
    }

    /**
     * Статический метод добавления ключей в коллекцию
     * @param k
     */
    private static void putNew(Key k) {
        _keys.put(k._value, k);
    }

    /**
     * Статический метод, возвращает коллекцию ключей
     * @return коллекция ключей
     */
    public static Set<String> getKeys() {
        return _keys.keySet();
    }
}
