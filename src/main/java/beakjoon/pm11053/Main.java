package beakjoon.pm11053;

import java.util.*;

public class Main {

    static int[] d = new int[1001];
    static int[] v = new int[1001];
    static int[] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        arr = new int[n+1];
        String[] str = sc.nextLine().split(" ");
        for(int i=1;i<=n;i++)
            arr[i] = Integer.parseInt(str[i-1]);

        for(int i=1;i<=n;i++){
            d[i] = 1;
            v[i] = 0;
            int max = 0;
            int temp = 0;
            for(int j=i-1;j>0;j--){
                if(arr[j] < arr[i]){
                    temp = d[j];
                }
                if(max < temp){
                    max = d[j];
                    v[i] = j;
                }
            }
            d[i] = max + 1;
        }

        int answer = 0;
        int index = 0;
        for(int i=1;i<=n;i++){
            if(answer < d[i]){
                answer = d[i];
                index = i;
            }
        }

        System.out.println(answer);
        go(index);
    }

    static void go(int p){
        if(p == 0){
            return;
        }
        go(v[p]);
        System.out.print(arr[p]+" ");
    }
}
