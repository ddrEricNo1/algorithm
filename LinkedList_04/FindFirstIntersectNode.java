package LinkedList_04;

public class FindFirstIntersectNode {
    class Node {
        public int value;
        public Node next;
        public Node(int data) {
            this.value = data;
        }
    }

    // 找到链表第一个入环节点, 如果无环，返回null
    public static Node getLoopNode(Node head) {
        if (head == null || head.next == null || head.next.next == null) {
            return null;
        }
        Node n1 = head.next;    // 慢指针
        Node n2 = head.next.next;   // 快指针
        while (n1 != n2) {
            if (n2.next == null || n2.next.next == null) {
                return null;
            }
            n2 = n2.next.next;
            n1 = n1.next;
        }
        n2 = head;
        while (n1 != n2) {
            n1 = n1.next;
            n2 = n2.next;
        }
        return n1;
    }

    
}
