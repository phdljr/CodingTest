package swea.pm1928;


import java.util.Scanner;

public class Solution {

    static final int L = 6;

    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);

        int len = sc.nextInt(); sc.nextLine();
        StringBuilder sb =  new StringBuilder(sc.nextLine());

        int opLen = sc.nextInt(); sc.nextLine();
        String op = sc.next();

        for(int k=0;k<opLen;k++) {
            if (op.equals("I")) {
                int x = sc.nextInt();
                int y = sc.nextInt();
                int[] s = new int[y];
                for (int i = 0; i < y; i++) {
                    s[i] = sc.nextInt();
                }
                I(sb, x, y, s);
            } else if (op.equals("D")) {
                int x = sc.nextInt();
                int y = sc.nextInt();
                D(sb, x, y);
            } else if (op.equals("A")) {
                int y = sc.nextInt();
                int[] s = new int[y];
                for (int i = 0; i < y; i++) {
                    s[i] = sc.nextInt();
                }
                A(sb, y, s);
            }
        }
    }
}
