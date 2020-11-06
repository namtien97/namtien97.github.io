public class Leetcode_Replace_Elements_with_Greatest_Element_on_Right_Side {
    public static int[] replaceElements(int[] arr) {
        int n = arr.length;
        //So sanh
        for (int i = n - 1; i >= 0; i--) {
            if (i != n - 1) {
                arr[i] = Math.max(arr[i], arr[i+1]);
            }
        }
        //Dich len tren 1 index
        for (int i = 1; i < n; i++) {
            arr[i - 1] = arr[i];
        }
        //Cho index cuoi = -1
        if(n>0){
            arr[n-1]=-1;
        }

        return arr;
    }

    public static void main(String[] args) {
        int[] arr = {17, 18, 5, 4, 6, 1};
        replaceElements(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
