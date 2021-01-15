import java.util.HashMap;
import java.util.Set;

public class _387Nam {
    static public int firstUniqChar(String s) {
        HashMap<Character, Integer> count = new HashMap<>();
        for (int i = 0; i <s.length(); i++) {
            char c = s.charAt(i);
            count.put(c, count.getOrDefault(c, 0) + 1);
        }

        for (int i = 0; i < s.length(); i++) {
            if (count.get(s.charAt(i)) == 1)
                return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        String s1 = "aadadaad";
        String s2 = "loveleetcode";
        System.out.println(firstUniqChar(s2));
    }
}
