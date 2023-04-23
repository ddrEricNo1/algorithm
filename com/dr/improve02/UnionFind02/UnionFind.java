package com.dr.improve02.UnionFind02;

import java.util.HashMap;
import java.util.List;
import java.util.Stack;

public class UnionFind {
    public static class Element<V> {
        public V value;
        public Element(V value) {
            this.value = value;
        }
    }

    public static class UnionFindSet<V> {
        // 元素与其对应的包装好的节点
        public HashMap<V, Element<V>> elementMap;
        // 某个元素和该元素的父节点
        public HashMap<Element<V>, Element<V>> fatherMap;
        // 某个集合的代表元素(头节点)和该集合的大小
        public HashMap<Element<V>, Integer> sizeMap;

        public UnionFindSet(List<V> list) {
            this.elementMap = new HashMap<>();
            this.fatherMap = new HashMap<>();
            sizeMap = new HashMap<>();
            for (V value: list) {
                Element<V> element = new Element<V>(value);
                elementMap.put(value, element);
                fatherMap.put(element, element);
                sizeMap.put(element, 1);
            }
        }

        // 判断是否属于同一个集合
        public boolean isSameSet(V a, V b) {
            if (elementMap.containsKey(a) && elementMap.containsKey((b))) {
                return findHead(elementMap.get(a)) == findHead(elementMap.get(b));
            }
            return false;
        }

        public void union(V a, V b) {
            if (elementMap.containsKey(a) && elementMap.containsKey(b)) {
                Element<V> aF = findHead(elementMap.get(a));
                Element<V> bF = findHead(elementMap.get(b));
                if (aF != bF) {
                    Element<V> big = sizeMap.get(aF) >= sizeMap.get(bF) ? aF : bF;
                    Element<V> small = big == aF ? bF : aF;
                    // 将元素少的集合的头指向元素多的集合的头节点
                    fatherMap.put(small, big);
                    sizeMap.put(big, sizeMap.get(aF) + sizeMap.get(bF));
                    sizeMap.remove(small);
                }
            }
        }

        private Element<V> findHead(Element<V> element) {
            Stack<Element<V>> path = new Stack<>();
            while (element != fatherMap.get(element)) {
                path.push(element);
                element = fatherMap.get(element);
            }

            // 将整条链扁平化
            while (!path.isEmpty()) {
                fatherMap.put(path.pop(), element);
            }
            return element;
        }
    }
}
