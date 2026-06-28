
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

        Stack<Integer> stack = new Stack<>();
        int n = Integer.parseInt(br.readLine());
        StringBuilder result = new StringBuilder();
        for(int i=0;i<n;i++){
            String[] str = br.readLine().split(" ");
            int command = Integer.parseInt(str[0]);

            switch (command){
                case 1:
                    int num = Integer.parseInt(str[1]);
                    stack.add(num);
                    break;
                case 2:
                    if(stack.empty()){
                        result.append(-1);
                    } else{
                        result.append(stack.pop());
                    }
                    result.append("\n");
                    break;
                case 3:
                    result.append(stack.size());
                    result.append("\n");
                    break;
                case 4:
                    if(stack.empty()){
                        result.append(1);
                    } else{
                        result.append(0);
                    }
                    result.append("\n");
                    break;
                case 5:
                    if(stack.empty()){
                        result.append(-1);
                    } else{
                        result.append(stack.peek());
                    }
                    result.append("\n");
                    break;
            }
        }

        bw.write(result.toString().trim());
        bw.flush();
    }
}
