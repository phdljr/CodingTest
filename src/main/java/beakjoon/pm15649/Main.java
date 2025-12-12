package beakjoon.pm15649;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    static String result = "";
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[] temp = new int[10];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] str = br.readLine().split(" ");
        int n = Integer.parseInt(str[0]);
        int m = Integer.parseInt(str[1]);

        int[] arr = new int[n+1];
        boolean[] check = new boolean[n+1];
        for(int i=1;i<=n;i++){
            arr[i] = i;
        }

        print(0, n, m, arr, check);
    }

    private static void print(int count, int n, int m, int[] arr, boolean[] check)
        throws IOException {
        if(count == m){
            result = "";
            for(int i=0;i<m;i++){
                result += temp[i] + " ";
            }
            result = result.trim() + "\n";
            bw.write(result);
            bw.flush();
            return;
        }

        for(int i=1; i <= n; i++){
            if(check[i]){
                continue;
            }

            check[i] = true;
            temp[count] = arr[i];
            print(count+1, n, m, arr, check);
            check[i] = false;
        }
    }
}
