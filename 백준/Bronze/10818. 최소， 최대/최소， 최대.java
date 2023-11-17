import java.io.*;
import java.util.Arrays;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        int count = Integer.parseInt(in.readLine());
        
        int[] arr = new int[count];
        int i = 0;
        for(String num: in.readLine().split(" ")){
            arr[i++] = Integer.parseInt(num);
        }
        
        Arrays.sort(arr);

        out.write(""+arr[0]+" "+arr[count-1]);
        out.flush();
    }
}