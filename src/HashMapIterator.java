import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class HashMapIterator extends HashMap {

    private static Iterator<Map.Entry<String, Key>> _iterator;

    HashMapIterator(HashMap<String, Key> hm) {
        _iterator  = hm.entrySet().iterator();
    }

    public Map.Entry<String, Key> nextKey() {
        return _iterator.next();
    }

    public boolean hasNextKey() {
        return _iterator.hasNext();
    }

    public int length() {
        int length = 0;
        while (hasNextKey()) {
            nextKey();
            length++;
        }
        return length;
    }
}
