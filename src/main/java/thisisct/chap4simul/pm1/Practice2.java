package thisisct.chap4simul.pm1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Practice2 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(in.readLine());
        int res = 0;
        for(int i=0;i<n+1;i++){
            for(int j=0;j<60;j++){
                for(int k=0;k<60;k++){
                    String str = i + String.valueOf(j) + k;
                    if(str.contains("3"))
                        res++;
                }
            }
        }
        System.out.println(res);
    }
}
