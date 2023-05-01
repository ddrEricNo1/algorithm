package com.dr.improve02.SlidingWindow05;

import java.util.LinkedList;

public class SlidingWindowMaxArray {
    public static class WindowMax {
        private int L;
        private int R;
        private int[] arr;
        private LinkedList<Integer> qMax;
        public WindowMax(int[] a) {
            arr = a;
            L = -1;
            R = 0;
            qMax = new LinkedList<>();
        }

        public void addNumFromRight() {
            if (R == arr.length) {
                return;
            }
            while (!qMax.isEmpty() && arr[qMax.peekLast()] <= arr[R]) {
                qMax.pollLast();
            }
            qMax.addLast(R);
            R++;
        }

        public void removeNumFromLeft() {
            if (L >= R - 1) {
                return;
            }
            L++;
            if (qMax.peekFirst() == L) {
                qMax.pollFirst();
            }
        }

        public Integer getMax() {
            if (!qMax.isEmpty()) {
                return arr[qMax.peekFirst()];
            }
            return null;
        }

        // 针对这道题如何定制
        public static int[] getMaxWindow(int[] arr, int w) {
            if (arr == null || w < 1 || arr.length < w) {
                return null;
            }
            // 下标 值 大->小
            LinkedList<Integer> qmax =  new LinkedList<>();
            int[] res = new int[arr.length - w + 1];
            int index = 0;
            for (int i = 0; i < arr.length; i++) {
                while (!qmax.isEmpty() && arr[qmax.peekLast()] <= arr[i]) {
                    qmax.pollLast();
                }
                qmax.addLast(i);

                // 过期的下标
                if (qmax.peekFirst() == i - w) {
                    qmax.pollFirst();
                }
                if (i >= w - 1) {
                    res[index++] = arr[qmax.peekFirst()];
                }
            }
            return res;
        }
    }
}
