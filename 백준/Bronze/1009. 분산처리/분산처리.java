
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
            String[] str = br.readLine().split(" ");
            int a =  Integer.parseInt(str[0]);
            int b = Integer.parseInt(str[1]);

            int temp = 1;
            for(int j=0;j<b;j++){
                temp *= a;
                temp %= 10;
            }

            if(temp == 0){
                temp = 10;
            }

            result.append(temp).append("\n");
        }

        bw.write(result.toString().trim());
        bw.flush();
    }
}


