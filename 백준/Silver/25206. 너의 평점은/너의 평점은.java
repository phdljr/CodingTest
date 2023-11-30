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
        Map<String, Float> map = new HashMap<>();
        map.put("A+", 4.5f);
        map.put("A0", 4.0f);
        map.put("B+", 3.5f);
        map.put("B0", 3.0f);
        map.put("C+", 2.5f);
        map.put("C0", 2.0f);
        map.put("D+", 1.5f);
        map.put("D0", 1.0f);
        map.put("F", 0.0f);
        map.put("P", 0.0f);
        
        float creditSum = 0;
        float gradeSum = 0;
        float answer = 0;
        String str = "";
        while((str = in.readLine()) != null){
            String[] nStr = str.split(" ");
            if(nStr[2].equals("P"))
                continue;
            float temp = Float.parseFloat(nStr[1]);
            creditSum += temp;
            gradeSum += map.get(nStr[2]) * temp;
        }
        
        answer = gradeSum / creditSum;

        out.write(""+answer);
        out.flush();
    }
}