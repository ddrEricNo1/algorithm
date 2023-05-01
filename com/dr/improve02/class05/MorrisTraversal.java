package com.dr.improve02.class05;

public class MorrisTraversal {
    public static class Node {
        public int value;
        public Node left;
        public Node right;
    }

    public static void Morris(Node head) {
        if (head == null) {
            return;
        }
        Node cur = head;
        Node mostRight = null;
        while (cur != null) {
            mostRight = cur.left;
            // 有左子树
            if (mostRight != null) {
                while (mostRight.right != null && mostRight.right != cur) {
                    mostRight = mostRight.right;
                }
                // mostRight变成cur左子树上最右的节点
                if (mostRight.right == null) {  // 第一次来到cur
                    mostRight.right = cur;
                    cur = cur.left;
                    continue;
                } else {
                    mostRight.right = null;
                }
            }
            // 无左子树
            cur = cur.right;
        }
    }

    // Morris遍历更改的先序遍历
    public static void MorrisPre(Node head) {
        if (head == null) {
            return;
        }
        Node cur = head;
        Node mostRight = null;
        while (cur != null) {
            mostRight = cur.left;
            // 有左子树
            if (mostRight != null) {
                while (mostRight.right != null && mostRight.right != cur) {
                    mostRight = mostRight.right;
                }
                // mostRight变成cur左子树上最右边的节点
                if (mostRight.right == null) {  // 第一次遍历到该节点
                    System.out.println(cur.value);
                    mostRight.right = cur;
                    cur = cur.left;
                    continue;
                } else {
                    mostRight.right = null;
                }
            } else {
                // 无左子树，直接打印
                System.out.println(cur.value);
            }
            cur = cur.right;
        }
    }

    public void morrisIn(Node head) {
        if (head == null) {
            return;
        }
        Node cur = head;
        Node mostRight = null;
        while (cur != null) {
            mostRight = cur.left;
            // 有左子树
            if (mostRight != null) {
                while (mostRight.right != null && mostRight.right != cur) {
                    mostRight = mostRight.right;
                }

                if (mostRight.right == null) {
                    mostRight.right = cur;
                    cur = cur.left;
                    continue;
                } else {
                    mostRight.right = null;
                }
            }
            System.out.println(cur.value);
            cur = cur.right;
        }
    }

    // 以x为头的树，逆序打印这棵树的右边界
    public static void printEdge(Node x) {
        Node tail = reverseEdge(x);
        Node cur = tail;
        while (cur != null) {
            System.out.println(cur.value);
            cur = cur.right;
        }
        reverseEdge(tail);
    }

    // 返回头节点
    public static Node reverseEdge(Node from) {
        Node pre = null;
        Node next = null;
        while (from != null) {
            next = from.right;
            from.right = pre;
            pre = from;
            from = next;
        }
        return pre;
    }

    public void morrisPost(Node head) {
        if (head == null) {
            return;
        }
        Node cur = head;
        Node mostRight = null;
        while (cur != null) {
            mostRight = cur.left;
            if (mostRight != null) {
                while (mostRight.right != null && mostRight.right != cur) {
                    mostRight = mostRight.right;
                }
                if (mostRight.right == null) {
                    mostRight.right = cur;
                    cur = cur.left;
                    continue;
                } else {
                    mostRight.right = null;
                    printEdge(cur.left);
                }
            }
            cur = cur.right;
        }
        printEdge(head);
    }
}
