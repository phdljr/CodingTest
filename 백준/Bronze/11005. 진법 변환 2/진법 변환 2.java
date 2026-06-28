
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
        String[] str = br.readLine().split(" ");
        int n = Integer.parseInt(str[0]);
        int b = Integer.parseInt(str[1]);
        StringBuilder result = new StringBuilder();
        Stack<Integer> stack = new Stack<>();

        while(n > 0){
            stack.add(n%b);
            n/=b;
        }

        while(!stack.isEmpty()){
            int t = stack.pop();
            if(t >= 10)
                result.append((char) (t + 55));
            else
                result.append(t);
        }

        bw.write(result.toString());
        bw.flush();
    }
}
