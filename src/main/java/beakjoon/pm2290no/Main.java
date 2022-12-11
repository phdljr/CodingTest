package beakjoon.pm2290no;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    static final char HYPHEN = '-';
    static final char BAR = '|';

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int s = sc.nextInt();
        long n = sc.nextLong();
        int col = s+2;
        int row = 2*s+3;

        String nstr = Long.toString(n);
        for(int i=0;i<row;i++){
            for(int j=0;j<nstr.length();j++) {
                if(nstr.charAt(j) == '0'){
                }
            }
        }
    }
}
