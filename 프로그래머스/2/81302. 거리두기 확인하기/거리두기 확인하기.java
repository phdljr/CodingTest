class Solution {
    static final int dx[] = {0, 1, 0, -1};
    static final int dy[] = {-1, 0, 1, 0};
    
    public int[] solution(String[][] places) {
        int[] answer = new int[places.length];
        for(int i=0; i<answer.length; i++){
            if(isDistanced(places[i])){
                answer[i] = 1;
            } else{
                answer[i] = 0;
            }
        }
        return answer;
    }
    
    private boolean isDistanced(String[] place){
        char[][] room = new char[5][5];
        for(int i=0;i<place.length;i++){
            room[i] = place[i].toCharArray();
            for(int j=0;j<room[i].length;j++){
                if(room[i][j] != 'P'){
                    continue;
                }
                if(!isDistanced(room, j, i)){
                    return false;
                }
            }
        }
        return true;
    }
    
    private boolean isDistanced(char[][] room, int x, int y){
        for(int i=0;i<4;i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(ny < 0 || ny >= 5 || nx < 0 || nx >= 5){
                continue;
            }
            switch(room[ny][nx]){
                case 'P':
                    return false;
                case 'O':
                    if(isNextToVolunteer(room, nx, ny, (i + 2) % 4 )){
                        return false;
                    }
            }
        }
        return true;
    }
    
    private boolean isNextToVolunteer(char[][] room, int x, int y, int exclude){
        for(int i=0;i<4;i++){
            if(i == exclude){
                continue;
            }
            
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(ny < 0 || ny >= 5 || nx < 0 || nx >= 5){
                continue;
            }
            if(room[ny][nx] == 'P'){
                return true;
            }
        }
        return false;
    }
}