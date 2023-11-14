class Solution {
    public String[] solution(String[] strings, int n) {
        String[] answer;
        
        for(int i=0;i<strings.length - 1;i++)
        {
            for(int j=0;j<strings.length - 1 - i; j++)
            {
                if(strings[j].compareTo(strings[j+1]) > 0)
                    swap(strings, j, j+1);
                if(strings[j].charAt(n) > strings[j+1].charAt(n))
                    swap(strings, j, j+1);
            }
        }
        
        answer = strings;
        
        return answer;
    }
    
    public void swap(String[] strings, int a, int b)
    {
        String temp = strings[a];
        strings[a] = strings[b];
        strings[b] = temp;
    }
}