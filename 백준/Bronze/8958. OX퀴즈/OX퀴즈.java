
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
        int score = 0;
        int conti = 1;
        for(int i=0;i<t;i++){
            char[] arr = br.readLine().toCharArray();
            for(char ch: arr){
                if(ch == 'O'){
                    score += conti++;
                } else{
                    conti = 1;
                }
            }

            result.append(score).append("\n");
            score = 0;
            conti = 1;
        }

        bw.write(result.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
