package beakjoon.pm10828;

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

        StringBuilder result = new StringBuilder();
        Stack<Integer> stack = new Stack<>();
        int n =  Integer.parseInt(br.readLine());
        for(int i=0;i<n;i++){
            String[] str = br.readLine().split(" ");
            switch (str[0]){
                case "push": stack.push(Integer.parseInt(str[1])); break;
                case "pop": result.append(stack.isEmpty() ? -1 : stack.pop()).append("\n"); break;
                case "size": result.append(stack.size()).append("\n"); break;
                case "top": result.append(stack.isEmpty() ? -1 : stack.peek()).append("\n"); break;
                case "empty": result.append(stack.isEmpty() ? 1 : 0).append("\n"); break;
            }
        }

        bw.write(result.toString().trim());
        bw.flush();
        bw.close();
        br.close();
    }
}


