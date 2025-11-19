
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder result = new StringBuilder();

        while(true){
            String[] str = br.readLine().split(" ");
            int a = Integer.parseInt(str[0]);
            int b = Integer.parseInt(str[1]);
            int c = Integer.parseInt(str[2]);

            if(a == 0 && b == 0 && c == 0)
                break;

            int max = Math.max(a, Math.max(b, c));
            if(a + b + c - max <= max){
                result.append("Invalid");
                result.append("\n");
                continue;
            }

            Set<Integer> set = new HashSet<>();
            set.add(a);
            set.add(b);
            set.add(c);
            if(set.size() == 3){
                result.append("Scalene");
            } else if(set.size() == 2){
                result.append("Isosceles");
            } else {
                result.append("Equilateral");
            }

            result.append("\n");
        }

        bw.write(result.toString());
        bw.flush();
    }
}
