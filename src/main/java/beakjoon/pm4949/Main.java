package beakjoon.pm4949;

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
        Stack<String> stack = new Stack<>();
        while(true){
            stack.clear();
            String str = br.readLine();

            if(str.equals("."))
                break;

            String[] arr = str.replaceAll("[^()\\[\\]]", "").split("");

            for(String ps: arr){
                if(arr.length == 1 && arr[0].isEmpty())
                    break;

                stack.push(ps);

                while(true){
                    if(stack.isEmpty() || stack.size() < 2){
                        break;
                    }

                    String top = stack.peek();
                    String prev = stack.get(stack.size()-2);

                    if(prev.equals("(") && top.equals(")") || prev.equals("[") && top.equals("]")){
                        stack.pop();
                        stack.pop();
                    } else{
                        break;
                    }
                }
            }

            if(stack.isEmpty())
                result.append("yes");
            else
                result.append("no");
            result.append("\n");
        }

        bw.write(result.toString().trim());
        bw.flush();
    }
}

