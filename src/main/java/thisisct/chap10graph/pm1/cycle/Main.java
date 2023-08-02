package thisisct.chap10graph.pm1.cycle;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n+1];

        for(int i=1;i<arr.length;i++){
            arr[i] = i;
        }

        for(int i=0;i<m;i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            if(findRoot(arr, a) == findRoot(arr, b)){
                System.out.println("싸이클 발생");
                return;
            } else{
                union(arr, a, b);
            }
        }
    }

    public static void union(int[] arr, int a, int b){
        int aRoot = findRoot(arr, a);
        int bRoot = findRoot(arr, b);
        if(aRoot < bRoot){
            arr[b] = aRoot;
        } else{
            arr[a] = bRoot;
        }
    }

    public static int findRoot(int[] arr, int n){
        if(arr[n] != n){
            arr[n] = findRoot(arr, arr[n]);
        }
        return arr[n];
    }
}
