import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] str = in.readLine().split(" ");
        int n = Integer.parseInt(str[0]);
        int m = Integer.parseInt(str[1]);
        int[] arr = new int[n];
        
        for(int i=0;i<n;i++){
            arr[i] = i+1;
        }
        
        for(int i=0;i<m;i++){
            str = in.readLine().split(" ");
            int a = Integer.parseInt(str[0]) - 1;
            int b = Integer.parseInt(str[1]) - 1;
            
            int temp = arr[a];
            arr[a] = arr[b];
            arr[b] = temp;
        }
        
        for(int i=0;i<n;i++){
            out.write(""+arr[i]+" ");
        }
        out.flush();
    }
}