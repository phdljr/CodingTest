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
        int k = Integer.parseInt(br.readLine());
        Stack<String> stack = new Stack<>();
        for(int i=0;i<k;i++){
            stack.clear();
            String[] str= br.readLine().split("");

            for(String ps: str){
                stack.push(ps);

                while(true){
                    if(stack.isEmpty() || stack.size() < 2){
                        break;
                    }

                    String top = stack.peek();
                    String prev = stack.get(stack.size()-2);

                    if(prev.equals("(") && top.equals(")")){
                        stack.pop();
                        stack.pop();
                    } else{
                        break;
                    }
                }
            }

            if(stack.isEmpty())
                result.append("YES");
            else
                result.append("NO");
            result.append("\n");
        }

        bw.write(result.toString().trim());
        bw.flush();
    }
}
