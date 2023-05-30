package com.dr.middleImprove03.class01;

import java.util.HashMap;

public class LRU {
    // 双向链表中的节点
    public static class Node<K, V> {
        public K key;
        public V value;
        public Node<K, V> last;
        public Node<K, V> next;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    // 双向链表
    public static class NodeDoubleLinkedList<K, V> {
        // 头指针
        private Node<K, V> head;
        // 尾指针
        private Node<K, V> tail;

        public NodeDoubleLinkedList() {
            this.head = null;
            this.tail = null;
        }

        // 如果一个新的节点加入，放到尾巴上
        public void addNode(Node<K, V> newNode) {
            if (newNode == null) {
                return;
            }

            // 当前双向链表中并没有节点
            if (this.head == null) {
                this.head = newNode;
                this.tail = newNode;
            } else {
                // 当前双向链表中存在节点
                this.tail.next = newNode;
                newNode.last = this.tail;
                this.tail = newNode;
            }
        }

        // node分理出去，前后环境重新连接
        // 并且将新的node移动到双向链表尾部
        public void moveNodeToTail(Node<K, V> node) {
            // 当前节点已经是尾部节点
            if (this.tail == node) {
                return;
            }
            // 当前节点为头部节点，需要调整head指针的指向
            if (this.head == node) {
                this.head = node.next;
                this.head.last = null;
            } else {
                // 当前node为双向链表中任意一个节点
                // 与node节点出现在头节点的情形相比，区别只在于一个需要更新head，而另一个不需要
                node.last.next = node.next;
                node.next.last = node.last;
            }
            node.last = this.tail;
            node.next = null;
            this.tail.next = node;
            this.tail = node;
        }

        // 内存替换的逻辑
        public Node<K, V> removeHead() {
            // 当前链表为空
            if (this.head == null) {
                return null;
            }

            // 头节点指向的节点为最不常用的节点
            Node<K, V> res = this.head;

            // 需要考虑两种情况，双向链表中只有一个节点和双向链表中有很多节点
            // 当前情况: 双向链表中只有一个节点
            if (this.head == this.tail) {
                //全部指向为空
                this.head = null;
                this.tail = null;
            } else {
                // 双向链表中有若干节点
                this.head = this.head.next;
                this.head.last = null;
                res.next = null;
            }
            return res;
        }
    }

    public static class LRUCache<K, V> {
        public int capacity = 0;
        private HashMap<K, Node<K, V>> keyNodeMap;
        private NodeDoubleLinkedList<K, V> nodeList;

        public LRUCache(int capacity) {
            if (capacity < 1) {
                throw new RuntimeException("should be more than 0");
            }
            this.capacity = capacity;
            this.keyNodeMap = new HashMap<>();
            this.nodeList = new NodeDoubleLinkedList<>();
        }

        // get操作
        public V get(K key) {
            // 先需要判断当前结构中是否存在以key为K的节点
            if (keyNodeMap.containsKey(key)) {
                // 从哈希表中获取value
                Node<K, V> node = keyNodeMap.get(key);
                this.nodeList.moveNodeToTail(node);
                return node.value;
            }
            return null;
        }

        public void set(K key, V value) {
            // 当前已经有这个key，直接更新对应节点的值
            if (this.keyNodeMap.containsKey(key)) {
                Node<K, V> node = this.keyNodeMap.get(key);
                node.value = value;
                this.nodeList.moveNodeToTail(node);
            } else {
                // 当前没有这个key
                Node<K, V> node = new Node<K, V>(key, value);
                keyNodeMap.put(key, node);
                this.nodeList.addNode(node);
                // 超过最大容量
                if (this.keyNodeMap.size() == this.capacity + 1) {
                    this.removeMostUnusedCache();
                }
            }
        }

        // 删除双向链表中最左边的记录
        private void removeMostUnusedCache() {
            Node<K, V> node = this.nodeList.removeHead();
            this.keyNodeMap.remove(node.key);
        }
    }
}
