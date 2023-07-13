package programmers.level1.pm172928;

public class Solution {
    public int[] solution(String[] park, String[] routes) {
        int[] answer = new int[2];
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};

        int cx = 0, cy = 0;

        int[][] map = new int[park.length][];
        for(int i=0;i<park.length;i++){
            map[i] = new int[park[i].length()];
            String[] str = park[i].split("");
            for(int j=0;j<park[i].length();j++){
                if(str[j].equals("O")){
                    map[i][j] = 0;
                } else if(str[j].equals("X")){
                    map[i][j] = 1;
                } else if(str[j].equals("S")){
                    map[i][j] = 2;
                    cx = i;
                    cy = j;
                }
            }
        }

        for(int i=0;i<routes.length;i++){
            char op = routes[i].charAt(0);
            int d = 0;
            switch(op){
                case 'N': d = 0; break;
                case 'E': d = 1; break;
                case 'S': d = 2; break;
                case 'W': d = 3; break;
            }
            int n = routes[i].charAt(2) - '0';
            int nx = cx;
            int ny = cy;
            for(int j=0;j<n;j++){
                nx += dx[d];
                ny += dy[d];
                if(0 <= nx && nx < park.length && 0 <= ny && ny < park[0].length()){
                    if(map[nx][ny] == 1){
                        nx = cx;
                        ny = cy;
                        break;
                    }
                } else{
                    nx = cx;
                    ny = cy;
                    break;
                }
            }
            cx = nx;
            cy = ny;
        }

        answer[0] = cx;
        answer[1] = cy;

        return answer;
    }
}
