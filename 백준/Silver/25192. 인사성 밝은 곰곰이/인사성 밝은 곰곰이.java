
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Set;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int result = 0;
        Set<String> set = new HashSet<>();

        for(int i=0;i<n;i++){
            String chat = br.readLine();
            if(chat.equals("ENTER")){
                result += set.size();
                set.clear();
            } else{
                set.add(chat);
            }
        }
        result += set.size();
        
        bw.write(result + "");
        bw.flush();
    }
}