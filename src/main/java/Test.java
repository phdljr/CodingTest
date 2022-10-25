import java.util.*;

public class Test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();

        long result = g(num);
        System.out.println(result);
    }

    // 1~num
    private static long g(int num) {
        long res = 0L;
        for(int i=1;i<=num;i++){
            res += Math.floor(num/i) * i;
        }
        return res;
    }
}
