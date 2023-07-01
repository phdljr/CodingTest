package thisisct.chap3greedy.pm3;

import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        int n, m;
        String[] s = in.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);

        Integer[][] arr = new Integer[n][m];
        for(int i=0;i<n;i++){
            s = in.readLine().split(" ");
            for(int j=0;j<m;j++){
                arr[i][j] = Integer.parseInt(s[j]);
            }
        }
        for (int i = 0; i < n; i++)
            Arrays.sort(arr[i]);

        int[] arr2 = new int[n];
        for (int i = 0; i < n; i++) {
            arr2[i] = arr[i][0];
        }
        Arrays.sort(arr2);

        out.write(String.valueOf(arr2[n - 1]));
        out.flush();
    }
}
