public class Bitset {
    private final int size;

    private int ones;

    private int zeros;

    private boolean reverse;

    private int[] set;

    // constructor
    public Bitset(int size) {
        this.ones = 0;
        this.zeros = size;
        this.size = size;
        this.set = new int[(size + 31) / 32];
        this.reverse = false;
    }

    // update the bit with index idx to 1
    public void fix(int idx) {
        int index = idx / 32;
        int bit = idx % 32;
        
        // if the whole structure isn't reversed
        if (!this.reverse) {
            /*
             0: not exist
             1: exist
             */
            if ((this.set[index] & (1 << bit)) == 0) {
                this.zeros--;
                this.ones++;
                this.set[index] |= (1 << bit);
            }
        } else {
            /*
             0: exist
             1: not exist
             */
            if ((this.set[index] & (1 << bit)) != 0) {
                this.zeros--;
                this.ones++;
                set[index] ^= (1 << bit);
            }
        }
    }

    // remove idx from the structure
    public void unfix(int idx) {
        int index = idx / 32;
        int bit = idx % 32;
        if (!reverse) {
            if ((set[index] & (1 << bit)) != 0) {
                ones--;
                zeros++;
                set[index] ^= (1 << bit);
            }
        } else {
            if ((set[index] ^ (1 << bit)) == 0) {
                ones--;
                zeros++;
                set[index] |= (1 << bit);
            }
        }
    }

    public void flip() {
        reverse = !reverse;
        int tmp = this.zeros;
        this.zeros = this.ones;
        this.ones = tmp;
    }

    public boolean all() {
        return this.ones == this.size;
    }

    public boolean one() {
        return this.ones > 0;
    }

    public int count() {
        return this.ones;
    }

    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (int k = 0, i = 0, number, status; i < this.size; k++) {
            number = this.set[k];
            for (int j = 0; j < 32 && i < size; j++, i++) {
                status = (number >>j) & 1;
                status ^= this.reverse ? 1 : 0;
                builder.append(status);
            }
        }
        return builder.toString();
    }
}
