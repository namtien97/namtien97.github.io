import java.util.Stack;

public class NamLeetcode20 {
    public static boolean isValid(String s) {
        Stack<String> myStack = new Stack<>();
        String[] arr = s.split("");
        for (String a : arr) {
            if(myStack.size()<=0&&a.equals("]") || myStack.size()<=0&&a.equals("}") || myStack.size()<=0&&a.equals(")")){
                return false;
            }
            if (a.equals("[") || a.equals("{") || a.equals("(")) {
                myStack.push(a);
                continue;
            }
            if (myStack.size() > 0) {
                if (myStack.peek().equals("[") && a.equals("]") ||
                        myStack.peek().equals("{") && a.equals("}") ||
                        myStack.peek().equals("(") && a.equals(")")) {
                    myStack.pop();
                }else {
                    return false;
                }
            }
        }
        return myStack.isEmpty();
    }

    public static void main(String[] args) {
        String s = "()[]{}";
        System.out.println(isValid(s));
    }
}
