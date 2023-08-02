package thisisct.chap10graph.pm1.union;

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
            union(arr, a, b);
        }

        System.out.println("각 원소가 속한 집합: ");
        for(int i=1;i<=n;i++)
            System.out.print(findRoot(arr, i) + " ");

        System.out.println("\n부모 테이블: ");
        for(int i=1;i<=n;i++)
            System.out.print(arr[i] + " ");
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
