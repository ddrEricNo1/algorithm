package com.dr.basic01.LinkedList_04;

import java.util.Stack;

public class IsPalindromeList {
    class Node {
        public int value;
        public Node next;
        public Node(int data) {
            this.value = data;
        }
    }

    public static boolean isPalindromeList1(Node head) {
//        Stack<Node> stack = new Stack<>();
//        Node cur = head;
//        while (cur != null) {
//            stack.push(cur);
//            cur = cur.next;
//        }
//        while (head != null) {
//            if (head.value != stack.pop().value) {
//                return false;
//            }
//            head = head.next;
//        }
//        return true;
        Stack<Node> stack = new Stack<>();
        Node cur = head;
        while (cur != null) {
            stack.push(cur);
            cur = cur.next;
        }
        while (head != null) {
            if (head.value != stack.pop().value) {
                return false;
            }
            head = head.next;
        }
        return true;
    }

    // need n/2 extra space
    public static boolean isPalindromeList2(Node head) {
//        if (head == null || head.next == null) {
//            return true;
//        }
//
//        // 慢指针
//        Node slow = head.next;
//
//        // 快指针
//        Node fast = head;
//
//        while (fast.next != null && fast.next.next != null) {
//            slow = slow.next;
//            fast = fast.next.next;
//        }
//        Stack<Node> stack = new Stack<>();
//        while (slow != null) {
//            stack.push(slow);
//            slow = slow.next;
//        }
//        while (!stack.isEmpty()) {
//            if (head.value != stack.pop().value) {
//                return false;
//            }
//            head = head.next;
//        }
//        return true;
        Node slow = head.next;
        Node fast = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        Stack<Node> stack = new Stack<>();
        while (slow != null) {
            stack.push(slow);
            slow = slow.next;
        }
        while(!stack.isEmpty()) {
            if (head.value != stack.pop().value) {
                return false;
            }
            head = head.next;
        }
        return true;
    }

    // 通过翻转链表的方式，达到时间复杂度为O(n),空间复杂度为O(1)
    public static boolean isPalindrome3(Node head) {
//        if (head == null || head.next == null) {
//            return true;
//        }
//        Node n1 = head;
//        Node n2 = head;
//        while (n2.next != null && n2.next.next != null) {
//            n1 = n1.next;
//            n2 = n2.next.next;
//        }

//        n2 = n1.next;
//        n1.next = null;
//        Node n3 = null;
//        while (n2 != null) {
//            n3 = n2.next;
//            n2.next = n1;
//            n1 = n2;
//            n2 = n3;
//        }
//        n3(last) = n1(slow);
//        n2(fast) = head;
//        boolean res = true;
//
//        只改变n1(slow)和n2(fast)
//        while (n1 != null && n2 != null) {
//            if (n1.value != n2.value) {
//                res = false;
//                break;
//            }
//            n1 = n1.next;
//            n2 = n2.next;
//        }

//        n1 = n3.next;
//        n3.next = null;
//        while (n1 != null) {
//            n2 = n1.next;
//            n1.next = n3;
//            n3 = n1;
//            n1 = n2;
//        }
//        return res;
        Node n1 = head;
        Node n2 = head;
        // 快慢指针
        while (n2.next != null && n2.next.next != null) {
            n1 = n1.next;
            n2 = n2.next.next;
        }

        // 翻转链表
        Node n3 = null;
        n2 = n1.next;
        n1.next = null;
        while (n2 != null) {
            n3 = n2.next;
            n2.next = n1;
            n1 = n2;
            n2 = n3;
        }

        // 对比, n1从右往左，n2从左往右
        n3 = n1;
        n2 = head;
        while (n2 != null && n1 != null) {
            if (n2.value != n1.value) {
                return false;
            }
            n2 = n2.next;
            n1 = n1.next;
        }
        n2 = n3.next;
        n3.next = null;
        while (n2 != null) {
            n1 = n2.next;
            n2.next = n3;
            n3 = n2;
            n2 = n1;
        }
        return true;
    }
    public static void main(String[] args) {

    }
}
