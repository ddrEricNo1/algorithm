package com.dr.improve02.class05;

import java.util.List;

public class MaxHappy {
    public static class Employee {
        public int happy;   // 这名员工可以带来的快乐值
        public List<Employee> nexts;    // 这名员工的直接下级
    }

    // 返回信息
    public static class Info {
        // 当前节点来的情况下整棵树的最大快乐值
        public int laiMaxHappy;
        // 当前节点不来的情况下整棵树的最大快乐值
        public int buMaxHappy;
        public Info(int lai, int bu) {
            this.laiMaxHappy = lai;
            this.buMaxHappy = bu;
        }
    }
    public static Info process(Employee x) {
        // 基层员工
        if (x.nexts.isEmpty()) {
            return new Info(x.happy, 0);
        }

        // x来的情况下，整棵树最大快乐值
        int lai = x.happy;
        // x不来的情况下，整棵树最大快乐值
        int bu = 0;
        for (Employee next: x.nexts) {
            Info nextInfo = process(next);
            lai += nextInfo.buMaxHappy;
            bu += Math.max(nextInfo.laiMaxHappy, nextInfo.buMaxHappy);
        }
        return new Info(lai, bu);
    }

    // 主函数
    public static int maxHappy(Employee boss) {
        Info headInfo = process(boss);
        return Math.max(headInfo.laiMaxHappy, headInfo.buMaxHappy);
    }
}
