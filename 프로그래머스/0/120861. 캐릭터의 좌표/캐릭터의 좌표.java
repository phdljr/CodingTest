class Solution {
    public int[] solution(String[] keyinput, int[] board) {
        int xMax = board[0] / 2;
        int xMin = -1 * xMax;
        int yMax = board[1] / 2;
        int yMin = -1 * yMax;
        int x = 0;
        int y = 0;
        
        for(int i=0;i < keyinput.length; i++){
            String dir = keyinput[i];
            switch(dir){
                case "up": y++; break;
                case "down": y--; break;
                case "left": x--; break;
                case "right": x++; break;
            }
            
            if(x > xMax) x--;
            if(x < xMin) x++;
            if(y > yMax) y--;
            if(y < yMin) y++;
        }
        
        int[] answer = {x, y};
        return answer;
    }
}