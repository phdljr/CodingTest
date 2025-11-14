

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] str = br.readLine().split(" ");
        String n = str[0];
        int b = Integer.parseInt(str[1]);
        int result = 0;

        int len = n.length();
        for(int i=0;i<len;i++){
            int num = 0;
            char ch = n.charAt(i);
            if(48 <= ch && ch <= 57)
                num = ch - 48;
            else
                num = ch - 65 + 10;

            result += num * (int)Math.pow(b, len-i-1);
        }

        bw.write(String.valueOf(result));
        bw.flush();
    }
}
