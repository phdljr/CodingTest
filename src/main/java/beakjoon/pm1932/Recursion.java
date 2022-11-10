package beakjoon.pm1932;

import java.util.Scanner;

public class Recursion {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        int[][] a = new int[n+1][n+1];
        for(int i=1;i<=n;i++){
            String[] s = sc.nextLine().split(" ");
            for(int j=1;j<=i;j++){
                a[i][j] = Integer.parseInt(s[j-1]);
            }
        }
    }
}
