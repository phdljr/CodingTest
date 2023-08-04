package thisisct.chap12.pm7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String[] s = in.readLine().split("");

        int left = 0, right = 0;
        for (int i = 0; i < s.length / 2; i++) {
            left += Integer.parseInt(s[i]);
            right += Integer.parseInt(s[s.length - 1 - i]);
        }

        if(left == right){
            System.out.println("LUCKY");
        } else{
            System.out.println("READY");
        }
    }
}
