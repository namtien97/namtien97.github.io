public class NamLeetcode225 {
    class MyStack {
        private int SIZE;
        private int[] arr;
        private int topIndex;

        /**
         * Initialize your data structure here.
         */
        public MyStack() {
            SIZE = 10;
            arr = new int[SIZE];
            topIndex = -1;
        }

        /**
         * Push element x onto stack.
         */
        public void push(int x) {
            if (!isFull()) {
                topIndex++;
                arr[topIndex] = x;
            }
        }

        /**
         * Removes the element on top of the stack and returns that element.
         */
        public int pop() {
            if(!empty()){
                return arr[topIndex--];
            }
            return -1;
        }

        /**
         * Get the top element.
         */
        public int top() {
            if(!empty()){
                return arr[topIndex];
            }
            return -1;
        }

        /**
         * Returns whether the stack is empty.
         */
        public boolean empty() {
            return topIndex < 0;
        }

        public boolean isFull() {
            return topIndex == SIZE - 1;
        }
    }

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
}
