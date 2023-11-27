class Solution {
    public String solution(String s, String skip, int index){
        StringBuilder sb = new StringBuilder();
        
        for(char ch: s.toCharArray()){
            for(int i=0;i<index;i++){
                ch++;
                if(ch == 'z' + 1){
                    ch = 'a';
                }
                if(skip.indexOf(ch) != -1){
                    i--;
                }
            }
            sb.append(ch);
        }
        
        return sb.toString();
    }
}