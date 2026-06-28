import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        List<String> list = new ArrayList<>();
        int maxLen = 0;
        for(int i=0;i<5;i++){
            list.add(in.readLine());
            if(list.get(i).length() > maxLen)
                maxLen = list.get(i).length();
        }
        String answer = "";
        
        int at = 0;
        while(maxLen > at){
            for(String str:list){
                if(str.length() <= at){
                    continue;
                }
                answer += str.charAt(at);
            }
            at++;
        }
        
        out.write(""+answer);
        out.flush();
    }
}