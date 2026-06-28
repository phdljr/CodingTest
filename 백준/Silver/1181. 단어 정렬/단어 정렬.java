
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        Set<String> set = new HashSet<>();

        for(int i=0;i<n;i++){
            set.add(br.readLine());
        }

        String[] arr = set.toArray(new String[0]);

        Arrays.sort(arr, (s1, s2) -> {
            if(s1.length() < s2.length())
                return -1;
            else if(s1.length() == s2.length()){
                return s1.compareTo(s2);
            } else{
                return 1;
            }
        });

        String result = "";
        for(String s: arr){
            result += s + "\n";
        }

        bw.write(result.trim());
        bw.flush();
    }
}
