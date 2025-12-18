
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    static int min = Integer.MAX_VALUE;
    static int[][] map;
    static boolean[] pick;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        map =  new int[n][n];
        pick = new boolean[n];
        for (int i = 0; i < n; i++) {
            map[i] =  Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        run(0, n/2, 0);

        bw.write(min + "");
        bw.flush();
    }

    private static void run(int currentCount, int targetCount, int index) {
        if(currentCount == targetCount){
            int score = getScoreGap();
            if(min > score){
                min = score;
            }

            return;
        }

        for(int i = index; i < map.length; i++){
            if(pick[i]){
                continue;
            }

            pick[i] = true;
            run(currentCount + 1, targetCount, i + 1);
            pick[i] = false;
        }
    }

    private static int getScoreGap() {
        List<Integer> startTeamIndexList = new ArrayList<>();
        List<Integer> linkTeamIndexList = new ArrayList<>();
        for(int i=0;i<map.length;i++){
            if(pick[i]){
                startTeamIndexList.add(i);
            } else{
                linkTeamIndexList.add(i);
            }
        }

        int startTeamScore = 0;
        int linkTeamScore = 0;
        for(int i=0;i<startTeamIndexList.size();i++){
            for(int j=i+1;j<startTeamIndexList.size();j++){
                startTeamScore += map[startTeamIndexList.get(i)][startTeamIndexList.get(j)] + map[startTeamIndexList.get(j)][startTeamIndexList.get(i)];
                linkTeamScore += map[linkTeamIndexList.get(i)][linkTeamIndexList.get(j)] + map[linkTeamIndexList.get(j)][linkTeamIndexList.get(i)];
            }
        }

        return Math.abs(startTeamScore - linkTeamScore);
    }
}
