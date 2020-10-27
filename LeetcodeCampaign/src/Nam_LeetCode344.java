public class Nam_LeetCode344 {
    public static void reverseString(char[] s) {
        int n = s.length;
        char temp = '\0';
        int j = 1;

        for (int i = 0; i < n; i++) {
            if (n == 0 || n == 1) {
                break;
            }
            if (n % 2 == 0) {
                temp = s[i];
                s[i] = s[n - j];
                s[n - j] = temp;
                j++;
                if (i == n / 2 - 1 || n == 2) {
                    break;
                }
            } else if(n%2!=0){
                if (i == n / 2) {
                    break;
                } else {
                    temp = s[i];
                    s[i] = s[n - j];
                    s[n - j] = temp;
                    j++;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            System.out.println(s[i]);
        }
    }

    public static void main(String[] args) {
        char[] s = {};
        reverseString(s);
    }
}
