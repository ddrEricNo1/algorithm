import java.util.HashSet;

// bitmap is used to store whether a number is stored in the structure or not
// use bit to form an array to fulfill the requirements, it can significantly save space

public class bitmap {
    // limitation: the range must be continous, but it can significantly save space compared with Hash map, 
    // a number takes up only 1 bit memory
    public int[] set;

    // initialize the bitmap, only support the retrieve between 0 to n - 1
    public bitmap(int n) {
        // ceiling (n / 32)
        set = new int[(n + 31) / 32];
        
    }

    // add the number into bitmap
    public void add(int num) {
        set[num / 32] |= (1 << num % 32);
    }

    // remove the number from the bitmap
    public void remove(int num) {
        set[num /32] &= ~(1 << (num % 32));
    }

    // if bitmap has this number, remove it, otherwise, add it 
    // use xor with the value 1 to flip the bit, xor with 0 to stay the same
    public void reverse(int num) {
        set[num / 32] ^= 1 << (num % 32);
    }

    // check whether bitmap has the value or not
    public boolean contains(int num) {
        return (set[num / 32] >> (num % 32) & 1) == 1;
    }

    // comparator
    public static void main(String[] args) {
        int testTimes = 5000;
        int n = 1000;
        System.out.println("start testing");
        bitmap bitset = new bitmap(n);
        HashSet<Integer> hashset = new HashSet<>();
        for (int i = 0; i < testTimes; i++) {
            double decide = Math.random();
            int number = (int)(Math.random() * n);
            // 1/3 probability to add the number
            if (decide < 0.333) {
                bitset.add(number);
                hashset.add(number);
            } else if (decide < 0.666) {    // 1/3 probability to remove the number
                bitset.remove(number);
                hashset.remove(number);
            } else {    // 1/3 to reverse the number
                bitset.reverse(number);
                if (hashset.contains(number)) {
                    hashset.remove(number);
                } else {
                    hashset.add(number);
                }
            }
        }
        for (int i = 0; i < n; i++) {
            if (bitset.contains(i) != hashset.contains(i)) {
                System.out.println("wrong");
            }
        }
        System.out.println("test ends");
    }
}