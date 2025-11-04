import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Класс итератора для HashMap
 */
public class HashMapIterator extends HashMap {

    /** Статический объект интерфейса итератор */
    private static Iterator<Map.Entry<String, Key>> _iterator;

    /**
     * Конструктор с параметрами
     */
    HashMapIterator(HashMap<String, Key> hm) {
        _iterator  = hm.entrySet().iterator();
    }

    /**
     * Метод, возвращающий следующий элемент структуры
     * @return элемент структуры
     */
    public Map.Entry<String, Key> nextKey() {
        return _iterator.next();
    }

    /**
     * Метод проверяет существование следующего элемента
     * @return true если существует, false - в противном случае
     */
    public boolean hasNextKey() {
        return _iterator.hasNext();
    }

    /**
     * Метод возвращает длину структуры
     * @return длина HashMap
     */
    public int length() {
        int length = 0;
        while (hasNextKey()) {
            nextKey();
            length++;
        }
        return length;
    }
}