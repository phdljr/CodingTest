
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Set<Integer> set = new HashSet<>();
        List<Integer> list = new ArrayList<>();

        for(int i=0;i<3;i++){
            int n = Integer.parseInt(br.readLine());
            set.add(n);
            list.add(n);
        }

        String result = "";
        if(list.stream().mapToInt(m -> m).sum() != 180){
            result = "Error";
        } else {
            if(set.size() == 3){
                result = "Scalene";
            } else if(set.size() == 2){
                result = "Isosceles";
            } else {
                result = "Equilateral";
            }
        }

        bw.write(result);
        bw.flush();
    }
}

