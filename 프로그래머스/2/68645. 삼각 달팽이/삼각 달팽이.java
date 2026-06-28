import java.util.*;

class Solution {
    public int[] solution(int n) {
        int[][] arr = new int[n][n];

        // 0: 밑으로, 1: 오른쪽, 2: 대각선
        int dir = 0;
        int num = 1;
        int count = n;
        int r = -1, c = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<count;j++){
                switch(dir){
                    case 0:
                        arr[++r][c] = num++;
                        break;
                    case 1:
                        arr[r][++c] = num++;
                        break;
                    case 2:
                        arr[--r][--c] = num++;
                        break;
                }
            }

            count--;
            dir = (dir + 1) % 3;
        }

        List<Integer> list = new ArrayList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(arr[i][j] != 0){
                    list.add(arr[i][j]);
                }
            }
        }

        return list.stream().mapToInt(i->i).toArray();
    }
}