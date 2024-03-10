package 哈希表有序表和比较器用法;

import java.util.Arrays;
import java.util.Comparator;

public class HashSetAndHashMap {
    public static class Employee {
        public int company;
        public int age;
        public Employee(int c, int a) {
            this.company = c;
            this.age = a;
        }
    }

    public static class EmployeeComparator implements Comparator<Employee> {
        // 任何比较器都默认，如果返回负数表示o1的优先级更高
        @Override
        public int compare(Employee o1, Employee o2) {
            // 谁年龄小，谁优先级高
            return o1.age - o2.age;
        }
    }

    public static void main(String[] args) {
        // 默认是小根堆，如果需要改成大根堆，需要传入一个比较器
        Employee s1 = new Employee(2, 27);
        Employee s2 = new Employee(2, 26);
        Employee s3 = new Employee(2, 25);
        Employee s4 = new Employee(2, 24);
        Employee s5 = new Employee(2, 23);
        Employee s6 = new Employee(2, 22);
        Employee[] arr = new Employee[]{s1, s2, s3, s4, s5, s6};
        Arrays.sort(arr, new EmployeeComparator());
        for (Employee e: arr) {
            System.out.println(e.age);
        }

        // lambda 表达式
        Arrays.sort(arr, (a, b)-> b.age - a.age);
    }
}
