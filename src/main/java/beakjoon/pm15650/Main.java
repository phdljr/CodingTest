package beakjoon.pm15650;

import java.util.Scanner;

public class Main {

    static boolean[] check = new boolean[10];
    static int[] a = new int[10];
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        print(0, 1, n, m);
        System.out.println(sb.toString());
    }

    /**
     * n: 1~n까지의 자연수, m: 중복 없이 m개 뽑기
     * @param index
     * @param n
     * @param m
     */

    private static void print(int index, int start, int n, int m){
        if(index == m){
            for(int i=0;i<m;i++){
                sb.append(a[i]);
                if(i != m-1)
                    sb.append(" ");
                else
                    sb.append("\n");
            }
            return;
        }
        for(int i=start;i<=n;i++){
            a[index] = i;
            print(index+1, i + 1, n, m);
        }
    }
}
