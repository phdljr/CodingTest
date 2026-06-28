import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        String str = "";
        while((str = in.readLine()) != null){
            out.write(str + "\n");
        }
        out.flush();
    }
}