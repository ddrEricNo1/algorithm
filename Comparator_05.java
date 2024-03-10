// 对数器
public class Comparator_05 {
    // 返回1～v范围内的随机数组，长度为n
	public static int[] randomArray(int n, int v) {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = (int)(Math.random() * v) + 1;
        }
        return arr;
    }

    // 拷贝一份数组，用于验证
    public static int[] copyArray(int[] arr) {
        int n = arr.length;
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            ans[i] = arr[i];
        }
        return ans;
    }

    public static boolean sameArray(int[] arr1, int[] arr2) {
        int n = arr1.length;
        for (int i = 0; i < n; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        // 随机数组最大长度
        int N = 100;

        // 随机数组每个值的范围
        int V = 1000;

        // 测试次数
        int testTimes = 50000;

        System.out.println("start testing");
        for (int i = 0; i < testTimes; i++) {
            // 随机得到一个长度
            int n = (int)(Math.random() * N);
            int[] arr = randomArray(n, V);
            int[] arr1 = copyArray(arr);
            int[] arr2 = copyArray(arr);
            int[] arr3 = copyArray(arr);
            Selection_Bubble_InsertionSort_04.selectionSort(arr1);
            Selection_Bubble_InsertionSort_04.BubbleSort(arr2);
            Selection_Bubble_InsertionSort_04.InsertionSort(arr3);
            if (!sameArray(arr1, arr2) || !sameArray(arr1, arr3)) {
                System.out.println("error");
            }
        }
        System.out.println("finish testing");
    }
}
