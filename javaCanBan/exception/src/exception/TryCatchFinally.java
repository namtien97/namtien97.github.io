package exception;

//try, catch, finally, throw, throws
// Nội dung này sẽ tìm hiểu cách sử dụng của try-catch-finally
/*
    Các trường hợp có thể xảy ra với try-catch or try-catch-finally:
    1. Ngoại lệ xảy ra trong khối try và được xử lý trong khối catch
    2. Ngoại lệ xảy tra trong khối try nhưng không được xử lý trong khối catch
    3. Ngoại lệ không xảy ra trong khối try

    Các trường hợp có thể gặp với try-finally:
    1. Ngoại lệ xảy ra trong khối try
    2. Ngoại lệ không xảy ra trong khối try
 */

public class TryCatchFinally {
    public static void main(String [] args){
        try{
            String str = null;
            System.out.println(str.length());
            System.out.println("Trong khoi try");
        }catch (NullPointerException e){
            System.out.println("Ngoai le: NullPointerException");
            System.out.println("Trong khoi catch");
        }
        System.out.println("Ra ngoai khoi catch");
    }
}
