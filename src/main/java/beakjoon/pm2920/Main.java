package beakjoon.pm2920;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();
        String result = "";
        if(str.equals("1 2 3 4 5 6 7 8"))
            result = "ascending";
        else if(str.equals("8 7 6 5 4 3 2 1"))
            result = "descending";
        else
            result = "mixed";

        bw.write(result);
        bw.flush();
        bw.close();
        br.close();
    }
}
