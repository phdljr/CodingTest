package thisisct.chap7binarysearch.pm2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        int n, m;
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(in.readLine());

        int[] na = new int[n];
        String[] s = in.readLine().split(" ");
        for(int i=0;i<n;i++){
            na[i] = Integer.parseInt(s[i]);
        }

        m = Integer.parseInt(in.readLine());

        int[] ma = new int[m];
        s = in.readLine().split(" ");
        for(int i=0;i<m;i++){
            ma[i] = Integer.parseInt(s[i]);
        }

        String answer = "";

        Arrays.sort(na);
        Arrays.sort(ma);

        for(int i=0;i<m;i++){
            int start = 0;
            int end = n - 1;
            int target = ma[i];
            while(true){
                int index = (int) Math.round((double)(start + end) / 2.0);
                if(start > end){
                    answer += "no ";
                    break;
                }
                if(na[index] < target){
                    start = index + 1;
                } else if(na[index] > target){
                    end = index - 1;
                } else{
                    answer += "yes ";
                    break;
                }
            }
        }

        System.out.println(answer);
    }
}
