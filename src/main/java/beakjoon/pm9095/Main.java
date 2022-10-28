package beakjoon.pm9095;

import java.util.Scanner;

public class Main {
    static int result;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int i=0;i<T;i++) {
            result = 0;
            int num = sc.nextInt();
            result = getResult(num);
            System.out.println(result);
        }
    }

    private static int getResult(int num) {
        if(num == 1)
            return 1;
        if(num == 2)
            return 2;
        if(num == 3)
            return 4;
        return getResult(num-1) + getResult(num-2) + getResult(num-3);
    }
}
