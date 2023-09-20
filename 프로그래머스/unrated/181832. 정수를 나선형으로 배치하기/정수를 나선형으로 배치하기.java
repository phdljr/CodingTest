class Solution {
    public int[][] solution(int n) {
        int[][] answer = new int[n][n];
        int count = 1; // 2가 되면 이 1씩 줄어들도록하고 0으로 설정
        int dir = 0; // 0: 오른쪽 1: 밑 2: 왼쪽 3: 위
        int num = 1;
        int x = 0;
        int y = -1;
        
        while(n > 0){
            for(int i=0;i<n;i++){
                switch(dir){
                    case 0: y++; break;
                    case 1: x++; break;
                    case 2: y--; break;
                    case 3: x--; break;
                }
                answer[x][y] = num++;
            }
            dir = (++dir) % 4;
            if(++count == 2){
                n--;
                count = 0;
            }
        }
        
        return answer;
    }
}