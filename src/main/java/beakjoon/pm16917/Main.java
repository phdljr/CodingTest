package beakjoon.pm16917;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a, b, c, x, y, res = 0;
        a = sc.nextInt(); // 양념
        b = sc.nextInt(); // 후라이드
        c = sc.nextInt(); // 반반

        x = sc.nextInt();
        y = sc.nextInt();

        if (a > 2 * c) {
            res += x * 2 * c;
            y -= x;
            x = 0;
            if(y < 0){
                System.out.println(res);
                return;
            }
        }

        if (b > 2 * c) {
            res += y * 2 * c;
            x -= y;
            y = 0;
            if(x < 0){
                System.out.println(res);
                return;
            }
        }

        if ((a + b) > 2 * c) {
            int min = Math.min(x, y);
            x -= min;
            y -= min;
            res += 2 * c * min;
            res += x * a;
            res += y * b;
        } else {
            res = x * a + y * b;
        }

        System.out.println(res);
    }
}
