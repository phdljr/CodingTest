class Solution {
    static int answer = 0;
    static boolean[] check;
    
    public int solution(int k, int[][] dungeons) {
        check = new boolean[dungeons.length];
        dfs(k, dungeons, 0);
        return answer;
    }
    
    public void dfs(int k, int[][] dungeons, int count){
        answer = Math.max(answer, count);
        for(int i=0;i<dungeons.length;i++){
            if(check[i] == true || k < dungeons[i][0]){
                continue;
            }
            
            check[i] = true;
            k -= dungeons[i][1];
            
            dfs(k, dungeons, count+1);
            
            check[i] = false;
            k += dungeons[i][1];
        }
    }
}