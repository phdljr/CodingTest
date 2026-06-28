
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int min = 1;
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<arr.length;i++){
            if(arr[i] == min){
                min++;
                while(true){
                    if(!stack.isEmpty() && stack.peek() == min){
                        stack.pop();
                        min++;
                    } else{
                        break;
                    }
                }
            } else{
                stack.push(arr[i]);
            }
        }
        
        String result = "";
        if(stack.isEmpty()){
            result = "Nice";
        } else{
            result = "Sad";
        }

        bw.write(result);
        bw.flush();
    }
}

