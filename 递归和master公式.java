public class 递归和master公式 {
    /*
     * master 公式:
        T(N) = a * T(N/b) + O(N^c), master公式必须是所有子问题规模相同才可以使用, O(N^c)表示除了递归行为之外其他行为的时间复杂度
        如果log(b, a) < c, 时间复杂度: O(n^c)
        如果log(b, a) > c, 时间复杂度: O(n^log(b,a))
        如果log(b, a) = c, 时间复杂度: O(n^c*log(n))
        补充：T(n) = 2*T(n/2)+O(n*logn), 时间复杂度为O(n*(logn)^2)
     */
}
