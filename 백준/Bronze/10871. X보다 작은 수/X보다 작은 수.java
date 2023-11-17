import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] str = in.readLine().split(" ");
        int count = Integer.parseInt(str[0]);
        int x = Integer.parseInt(str[1]);
        
        int[] arr = new int[count];
        int i = 0;
        for(String num: in.readLine().split(" ")){
            arr[i++] = Integer.parseInt(num);
        }
        for(i=0;i<count;i++){
            if(arr[i] < x)
                out.write(""+arr[i]+" ");
        }
        out.flush();
    }
}