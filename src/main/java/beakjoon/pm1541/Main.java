package beakjoon.pm1541;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();
        int[] nums = Arrays.stream(str.split("[+-]")).mapToInt(Integer::parseInt).toArray();
        String[] opers = str.replaceAll("\\d+", "").split("");

        int result = nums[0];
        int temp = 0;
        for(int i=0;i<opers.length;i++){
            if(opers[i].equals("-")){
                temp+=nums[i+1];
            } else{
                if(temp == 0)
                    result += nums[i+1];
                else{
                    temp+=nums[i+1];
                    result -= temp;
                    temp = 0;
                }
            }
        }

        result += temp;

        bw.write(result + "");
        bw.flush();
    }
}
