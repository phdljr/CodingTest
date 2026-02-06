package beakjoon.pm25682;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        LocalDate now = LocalDate.now();

        bw.write(now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        bw.flush();
        bw.close();
        br.close();
    }
}


