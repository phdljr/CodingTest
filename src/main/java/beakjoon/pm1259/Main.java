package beakjoon.pm1259;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuilder result = new StringBuilder();
        while (true) {
            String str = br.readLine();
            if(str.equals("0")) {
                break;
            }

            if(str.contentEquals(new StringBuilder(str).reverse())) {
                result.append("yes");
            } else{
                result.append("no");
            }

            result.append("\n");
        }

        bw.write(result + "");
        bw.flush();
        bw.close();
        br.close();
    }
}


