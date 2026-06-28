package beakjoon.pm10773;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int k = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<k;i++){
            int n = Integer.parseInt(br.readLine());

            if(n != 0)
                stack.push(n);
            else
                stack.pop();
        }

        int sum = 0;
        for(int num: stack){
            sum += num;
        }

        bw.write(sum + "");
        bw.flush();
    }
}
