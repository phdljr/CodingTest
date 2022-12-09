package beakjoon.pm14890;

import java.util.*;

public class Main {
    static int l;
    static int n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int[][] a = new int[n][n];
        l = sc.nextInt();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                a[i][j] = sc.nextInt();
            }
        }

        int res = 0;
        for (int i = 0; i < n; i++) {
            int[] sa = a[i];
            if (go(sa)) {
                res++;
            }
        }

        for (int i = 0; i < n; i++) {
            int[] sa = new int[n];
            for (int j = 0; j < n; j++) {
                sa[j] = a[j][i];
            }
            if (go(sa)) {
                res++;
            }
        }
        System.out.println(res);
    }

    static boolean go(int[] arr) {
        boolean[] c = new boolean[arr.length];

        // 왼쪽 -> 오른쪽
        for (int i = 1; i < arr.length; i++) {
            // 높이 차이가 난다면
            if (arr[i - 1] != arr[i]) {
                // 두 칸 이상 차이난다면 못감
                if (Math.abs(arr[i - 1] - arr[i]) != 1) {
                    return false;
                }

                // 경사로를 놓을 수 있는지 확인
                // 증가하는 경사로를 놓아야 할 때
                if(arr[i-1] < arr[i]) {
                    for (int j = 1; j <= l; j++) {
                        // 경사로를 놓을 자리가 없어도 못감
                        if (i - j < 0) {
                            return false;
                        }
                        // 이미 경사로가 놓여있어도 못감
                        if (c[i - j] == true) {
                            return false;
                        }
                        // 경사로를 놓을 자리가 고르지 않아도 못감
                        if (arr[i - 1] != arr[i - j]) {
                            return false;
                        }
                        // 경사로를 놓음
                        c[i-j] = true;
                    }
                }
                // 감소하는 경사로를 놓아야 할 때
                else{
                    for (int j = 0; j < l; j++) {
                        // 경사로를 놓을 자리가 없어도 못감
                        if (i + j >= n) {
                            return false;
                        }
                        // 이미 경사로가 놓여있어도 못감
                        if (c[i + j] == true) {
                            return false;
                        }
                        // 경사로를 놓을 자리가 고르지 않아도 못감
                        if (arr[i] != arr[i + j]) {
                            return false;
                        }
                        // 경사로를 놓음
                        c[i+j] = true;
                    }
                }
            }
        }
        return true;
    }
}
