import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        int count = Integer.parseInt(in.readLine());

        for(int i=0;i<count;i++){
            String[] arr = in.readLine().split(" ");
            int a = Integer.parseInt(arr[0]);
            int b = Integer.parseInt(arr[1]);
            out.write(String.valueOf(a + b));
//            if(i != count - 1)
                out.write("\n");
        }
        out.flush();
    }
}