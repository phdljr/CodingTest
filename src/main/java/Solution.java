import java.util.Scanner;

public class Solution {

    static int[][] a = new int[7][7];

    public static void main(String args[]) throws Exception {

        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for(int test_case = 1; test_case <= T; test_case++) {
            int n = sc.nextInt();
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    a[i][j] = sc.nextInt();
                }
            }
            rotate(a, n, test_case);
        }
    }

    public static void rotate(int[][] arr, int n, int t){
        System.out.printf("#%d\n", t);
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                System.out.print(arr[n-j-1][i]);
            }
            System.out.print(" ");
            for(int j=0;j<n;j++){
                System.out.print(arr[n-i-1][n-j-1]);
            }
            System.out.print(" ");
            for(int j=0;j<n;j++){
                System.out.print(arr[n-(n-j-1)-1][n-i-1]);
            }
            System.out.println();
        }
    }
}