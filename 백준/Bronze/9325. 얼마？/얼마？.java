
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());
        StringBuilder result = new StringBuilder();

        for(int i=0;i<t;i++){
            long sum = Integer.parseInt(br.readLine());
            int options = Integer.parseInt(br.readLine());
            for(int j=0;j<options;j++){
                String[] str = br.readLine().split(" ");
                int optionCount = Integer.parseInt(str[0]);
                int optionPrice = Integer.parseInt(str[1]);
                sum += (long)optionCount * optionPrice;
            }
            result.append(sum).append("\n");
        }

        bw.write(result.toString().trim());
        bw.flush();
        bw.close();
        br.close();
    }
}

