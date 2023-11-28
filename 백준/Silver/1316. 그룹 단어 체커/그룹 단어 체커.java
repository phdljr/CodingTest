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
        
        int count = Integer.parseInt(in.readLine());
        int answer = 0;
        
        for(int i=0;i<count;i++){
            boolean flag = true;
            Map<Character, Integer> map = new HashMap<>();
            char[] cArr = in.readLine().toCharArray();
            for(int j=0;j<cArr.length;j++){
                if(j != 0 && cArr[j] != cArr[j-1] && map.get(cArr[j]) != null){
                    flag = false;
                    break;
                } else{
                    map.put(cArr[j], 1);
                }
            }
            if(flag)
                answer++;
        }

        out.write(""+answer);
        out.flush();
    }
}