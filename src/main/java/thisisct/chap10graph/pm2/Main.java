package thisisct.chap10graph.pm2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String[] str = in.readLine().split(" ");
        int n = Integer.parseInt(str[0]);
        int m = Integer.parseInt(str[1]);
        int[] arr = new int[n+1];

        for(int i=1;i<=n;i++){
            arr[i] = i;
        }

        String answer = "";
        for(int i=0;i<m;i++){
            str = in.readLine().split(" ");
            String command = str[0];
            int a = Integer.parseInt(str[1]);
            int b = Integer.parseInt(str[2]);
            if(command.equals("0")){
                unionParent(arr, a, b);
            } else{
                if(findParent(arr, a) == findParent(arr, b)){
                    answer += "YES\n";
                } else{
                    answer += "NO\n";
                }
            }
        }
        System.out.println(answer);
    }

    public static void unionParent(int[] arr, int a, int b){
        a = findParent(arr, a);
        b = findParent(arr, b);
        if(a<b){
            arr[b] = a;
        } else{
            arr[a] = b;
        }
    }

    public static int findParent(int[] arr, int n){
        if(arr[n] != n){
            arr[n] = findParent(arr, arr[n]);
        }
        return arr[n];
    }
}
