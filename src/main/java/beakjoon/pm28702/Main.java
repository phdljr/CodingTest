package beakjoon.pm28702;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] str = new String[3];
        for(int i=0;i<3;i++){
            str[i] = br.readLine();
        }

        String result = "";

        int num = 0;
        int numIdx = 0;
        for(int i=0;i<3;i++){
            if(str[i].equals("Fizz") || str[i].equals("Buzz") || str[i].equals("FizzBuzz"))
                continue;

            num = Integer.parseInt(str[i]);
            numIdx = i;
        }

        int res = num + (3 - numIdx);
        if(res % 3 == 0 && res % 5 == 0 ) {
            result = "FizzBuzz";
        } else if(res % 3 == 0) {
            result = "Fizz";
        } else if(res % 5 == 0) {
            result = "Buzz";
        } else{
            result = res + "";
        }

        bw.write(result);
        bw.flush();
    }
}