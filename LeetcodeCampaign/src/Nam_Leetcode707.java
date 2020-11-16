public class Nam_Leetcode707 {
    public static class SinglyListNode {
        int val;
        SinglyListNode next;

        SinglyListNode(int x, SinglyListNode next) {
            this.val = x;
            this.next = next;
        }
    }

    public static class MyLinkedList {
        private SinglyListNode head;

        /**
         * Initialize your data structure here.
         */
        public MyLinkedList() {
            head = null;
        }

        /**
         * Get the value of the index-th node in the linked list. If the index is invalid, return -1.
         */
        public int get(int index) {
            SinglyListNode temp = head;
            int count = 0;
            int result = -1;
            while (true) {
                if (temp == null) {
                    break;
                }
                if (count == index) {
                    result = temp.val;
                    break;
                }
                temp = temp.next;
                count++;
            }
            return result;
        }

        /**
         * Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list.
         */
        public void addAtHead(int val) {
            SinglyListNode newNode = new SinglyListNode(val, null);
            newNode.next = head;
            head = newNode;
        }

        /**
         * Append a node of value val to the last element of the linked list.
         */
        public void addAtTail(int val) {
            SinglyListNode newNode = new SinglyListNode(val, null);
            if (head == null) {
                head = newNode;
            } else {
                SinglyListNode lastNode = head;
                while (lastNode != null) {
                    if (lastNode.next == null) {
                        lastNode.next = newNode;
                        break;
                    }
                    lastNode = lastNode.next;
                }
            }
        }

        /**
         * Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted.
         */
        public void addAtIndex(int index, int val) {
            if (index == 0) {
                addAtHead(val);
                return;
            }
            SinglyListNode temp = head;
            int count = 0;
            SinglyListNode newNode = new SinglyListNode(val, null);
            while (true) {
                if (count == (index - 1)) {
                    newNode.next = temp.next;
                    temp.next = newNode;
                    break;
                }
                count++;
                temp = temp.next;
            }
        }

        /**
         * Delete the index-th node in the linked list, if the index is valid.
         */
        public void deleteAtIndex(int index) {
            if (index < 0) {
                return;
            }
            SinglyListNode cur = head;
            SinglyListNode prev = null;
            int count = 0;

            while (cur != null) {
                if (count == index) {
                    if (index == 0) {
                        head = head.next;
                    } else {
                        prev.next = cur.next;
                        return;
                    }
                }
                count++;
                prev = cur;
                cur = cur.next;
            }
        }

        public void print() {
            if (head == null) {
                System.out.println("List is empty");
            } else {
                SinglyListNode temp = head;
                while (temp != null) {
                    System.out.print(temp.val + " ");
                    temp = temp.next;
                }
            }
        }
    }

    /**
     * Your MyLinkedList object will be instantiated and called as such:
     * MyLinkedList obj = new MyLinkedList();
     * int param_1 = obj.get(index);
     * obj.addAtHead(val);
     * obj.addAtTail(val);
     * obj.addAtIndex(index,val);
     * obj.deleteAtIndex(index);
     */


    public static void main(String[] args) {
        MyLinkedList obj = new MyLinkedList();
        obj.addAtHead(1);
        obj.addAtTail(3);
        obj.addAtTail(3);
        obj.addAtIndex(1, 4);
        obj.print();
    }
}
