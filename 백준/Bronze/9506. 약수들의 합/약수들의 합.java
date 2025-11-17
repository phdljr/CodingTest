import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder result = new StringBuilder();
        while(true){
            List<Integer> list = new ArrayList<>();
            int n = Integer.parseInt(br.readLine());
            if(n == -1)
                break;

            result.append(n);
            for(int i=1;i<n;i++){
                if(n % i == 0){
                    list.add(i);
                }
            }

            int sum = 0;
            for(int s: list){
                sum += s;
            }

            if(sum == n){
                result.append(" = ");
                for(int i=0;i<list.size();i++){
                    result.append(list.get(i));
                    if(i != list.size() - 1)
                        result.append(" + ");
                }
            } else{
                result.append(" is NOT perfect.");
            }
            result.append("\n");
        }

        bw.write(result.toString().trim());
        bw.flush();
    }
}