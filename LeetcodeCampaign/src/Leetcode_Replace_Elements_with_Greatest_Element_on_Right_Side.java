public class Leetcode_Replace_Elements_with_Greatest_Element_on_Right_Side {
    public static int[] replaceElements(int[] arr) {
        int i = 0;
        int j = 1;
        while (true) {
            if (i == arr.length - 1) {
                arr[i] = -1;
                break;
            }
            if(arr[i]<arr[j]){
                if(i!=0) {
                    arr[i - 1] = arr[j];
                }
                while (true){
                    if(i==j){
                        break;
                    }else {
                        arr[i]=arr[j];
                        i++;
                    }
                }
                i = j+(arr.length)-j+2;
                j+=2;
            }else{
                j++;
            }
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
