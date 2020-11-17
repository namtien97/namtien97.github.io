public class NamLeetcode622 {
    class MyCircularQueue {
        int[] array;
        int SIZE;
        int headIndex;
        int tailIndex;
        int count;

        /**
         * Initialize your data structure here. Set the size of the queue to be k.
         */
        public MyCircularQueue(int k) {
            SIZE = k;
            array = new int[SIZE];
            headIndex = tailIndex = -1;
            count = 0;
        }

        /**
         * Insert an element into the circular queue. Return true if the operation is successful.
         */
        public boolean enQueue(int value) {
            if (isFull())
                return false;

            tailIndex++;
            if (tailIndex == SIZE)
                tailIndex = 0;
            if (isEmpty())
                headIndex = tailIndex;
            array[tailIndex] = value;
            count++;
            return true;
        }

        /**
         * Delete an element from the circular queue. Return true if the operation is successful.
         */
        public boolean deQueue() {
            if (isEmpty())
                return false;
            headIndex++;
            if (headIndex == SIZE)
                headIndex = 0;
            count--;
            return true;
        }

        /**
         * Get the front item from the queue.
         */
        public int Front() {
            return isEmpty() ? -1 : array[headIndex];
        }

        /**
         * Get the last item from the queue.
         */
        public int Rear() {
            return isEmpty() ? -1 : array[tailIndex];
        }

        /**
         * Checks whether the circular queue is empty or not.
         */
        public boolean isEmpty() {
            return count <= 0;
        }

        /**
         * Checks whether the circular queue is full or not.
         */
        public boolean isFull() {
            return count >= SIZE;
        }
    }

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */
}
