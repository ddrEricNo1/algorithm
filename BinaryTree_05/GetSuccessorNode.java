package BinaryTree_05;

public class GetSuccessorNode {
    public static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node parent;
        public Node(int val) {
            this.val = val;
        }
    }

    // 返回该节点的后继节点，后继节点为中序遍历中的下一个节点
    public static Node getSuccessorNode(Node node) {
        if (node == null) {
            return null;
        }
        // 如果节点有右子树
        if (node.right != null) {
            return getLeftMost(node.right);
        } else {
            // 无右子树
            Node parent = node.parent;
            while (parent != null && parent.left != node) {
                node = parent;
                parent = node.parent;
            }
            return parent;
        }
    }

    public static Node getLeftMost(Node node) {
        if (node == null) {
            return null;
        }
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }
}
