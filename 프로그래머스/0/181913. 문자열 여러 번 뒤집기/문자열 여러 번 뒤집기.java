class Solution {
    public String solution(String my_string, int[][] queries) {
        String answer = my_string;
        for(int i=0; i<queries.length; i++){
            String temp = new StringBuilder(answer.substring(queries[i][0], queries[i][1]+1))
                .reverse()
                .toString();
            answer = new StringBuilder(answer)
                .delete(queries[i][0], queries[i][1]+1)
                .insert(queries[i][0], temp)
                .toString();
        }
        return answer;
    }
}