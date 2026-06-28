import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        int[] arr = new int[26];
        String str = in.readLine().toUpperCase();
        for(char ch: str.toCharArray()){
            arr[ch - 'A']++;
        }
        
        int max = -1;
        int maxIndex = 0;
        boolean flag = false;
        for(int i=0;i<arr.length;i++){
            if(max <= arr[i]){
                if(max == arr[i]){
                    flag = true;
                } else{
                    flag = false;
                    max = arr[i];
                    maxIndex = i;
                }
            }
        }
        
        if(flag == true){
            out.write("?");
        } else{
            out.write('A' + maxIndex);
        }
        
        out.flush();
    }
}
