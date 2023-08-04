package thisisct.chap12.pm8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String s = in.readLine();
        String numstr = s.replaceAll("[^\\d]", "");
        String alphastr = s.replaceAll("[^A-Z]", "");

        char[] charArray = alphastr.toCharArray();
        Arrays.sort(charArray);
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<charArray.length;i++){
            sb.append(charArray[i]);
        }

        int sum = 0;
        for(int i=0;i<numstr.length();i++){
            sum += numstr.charAt(i) - '0';
        }

        System.out.println(sb.toString() + sum);
    }
}
