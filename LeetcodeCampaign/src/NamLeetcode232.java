public class NamLeetcode232 {
    static class MyQueue {
        private int SIZE;
        private int[] array;
        private int headIndex = -1;
        private int tailIndex = -1;

        /**
         * Initialize your data structure here.
         */
        public MyQueue() {
            SIZE = 10;
            array = new int[SIZE];
        }

        /**
         * Push element x to the back of queue.
         */
        public void push(int x) {
            if (!isFull()) {
                if (empty()) {
                    headIndex++;
                }
                tailIndex++;
                array[tailIndex] = x;
            }
        }

        /**
         * Removes the element from in front of queue and returns that element.
         */
        public int pop() {
            int value = -1;
            if (!empty()) {
                value = array[headIndex];
                headIndex++;
                if (headIndex > tailIndex) {
                    headIndex = tailIndex = -1;
                }
            }
            return value;
        }

        /**
         * Get the front element.
         */
        public int peek() {
            return array[headIndex];
        }

        /**
         * Returns whether the queue is empty.
         */
        public boolean empty() {
            return (headIndex == -1) && (tailIndex == -1);
        }

        public boolean isFull() {
            return tailIndex == SIZE - 1;
        }
    }

    /**
     * Your MyQueue object will be instantiated and called as such:
     * MyQueue obj = new MyQueue();
     * obj.push(x);
     * int param_2 = obj.pop();
     * int param_3 = obj.peek();
     * boolean param_4 = obj.empty();
     */
    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue();
        myQueue.push(1);
        myQueue.push(2);
        //System.out.println("peek : "+myQueue.peek());
        //System.out.println("pop: "+myQueue.pop());
        System.out.println("empty: "+myQueue.empty());
    }
}
