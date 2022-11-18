package swea.pm1928;


import java.util.Scanner;

public class Solution {

    static final int L = 6;

    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);

        for(int t=0;t<10;t++) {
            int len = Integer.parseInt(sc.nextLine());
            StringBuilder sb = new StringBuilder(sc.nextLine());

            int opLen = Integer.parseInt(sc.nextLine());

            for (int k = 0; k < opLen; k++) {
                String op = sc.next();

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
            sc.nextLine();
            System.out.printf("#%d %s\n", t+1, sb);
        }
    }

    // 맨 뒤에 y개의 s를 덧붙임
    private static void A(StringBuilder sb, int y, int[] s) {
        for(int i=0;i<y;i++)
            sb.append(" ").append(s[i]);
    }

    private static void D(StringBuilder sb, int x, int y) {
        int start = (x-1)*(L+1);
        int end = start + y*(L+1);
        sb.delete(start, end);
    }

    private static void I(StringBuilder sb, int x, int y, int[] s) {
        int start = (x-1)*(L+1);
        for(int i=0;i<y;i++)
            sb.insert(start, s[i]+" ");
    }
}
