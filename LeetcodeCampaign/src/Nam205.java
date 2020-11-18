import java.util.HashMap;
import java.util.Map;

public class Nam205 {
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> map = new HashMap<>();

        char[] a = s.toCharArray();
        char[] b = t.toCharArray();

        for (int i = 0; i < a.length; i++) {
            if (!map.containsKey(a[i]) && !map.containsValue(b[i])) {
                map.put(a[i], b[i]);
            }
            if (map.get(a[i]) == null || map.get(a[i]) != b[i]) {
                return false;
            }
        }
        return true;
    }
}
