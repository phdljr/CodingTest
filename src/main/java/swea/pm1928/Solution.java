package swea.pm1928;

import java.util.Arrays;
import java.util.Base64;
import java.util.Date;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        byte[] decode = Base64.getDecoder().decode(sc.nextLine().getBytes());
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<decode.length;i++)
            sb.append((char)decode[i]);
        System.out.println(sb);
    }
}
