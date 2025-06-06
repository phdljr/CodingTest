class Solution {
    public String solution(String polynomial) {
        String[] arr = polynomial.split("\\+");
        
        int num = 0;
        int poly = 0;
        
        for(String s: arr){
            s = s.trim();
            if(s.contains("x")){
                String st = s.replace("x", "");
                if(st.equals("")){
                    poly++;
                }else{
                    poly += Integer.parseInt(st);
                }
            } else{
                num += Integer.parseInt(s);
            }
        }
        
        String answer = "";
        if(poly > 0){
            if(poly == 1){
                answer = "x";
            }   
            else{
                answer = poly + "x";
            }
            
            if(num > 0){
                answer = answer + " + " + num;
            }
        } else{
            answer = num + "";
        }
        
        return answer;
    }
}