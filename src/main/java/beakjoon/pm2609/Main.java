package beakjoon.pm2609;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int n1, n2;
        Scanner sc = new Scanner(System.in);
        n1 = sc.nextInt();
        n2 = sc.nextInt();

        int res1 = gcd(n1, n2);
        int res2 = lcd(n1, n2, res1);

        System.out.println(res1);
        System.out.println(res2);
    }

    private static int gcd(int n1, int n2) {
        if(n2 == 0) return n1;
        return gcd(n2, n1%n2);
    }

    private static int lcd(int n1, int n2, int g) {
        int l = g * (n1/g) * (n2/g);
        return l;
    }
}
