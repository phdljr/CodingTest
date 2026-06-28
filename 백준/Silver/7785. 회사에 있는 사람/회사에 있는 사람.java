import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        Set<String> set = new HashSet<>();
        for(int i=0;i<n;i++){
            String[] str = br.readLine().split(" ");
            String name = str[0];
            String status = str[1];

            if(status.equals("enter"))
                set.add(name);
            else
                set.remove(name);
        }

        String result = String.join("\n", set.stream().sorted(Comparator.reverseOrder()).collect(
            Collectors.toList()));

        bw.write(result);
        bw.flush();
    }
}
