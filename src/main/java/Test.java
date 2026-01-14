public class Test {
    public String solution(String str)
    {
        StringBuilder sb = new StringBuilder(str);
        return sb.reverse().toString();
    }

    public static void main(String[] args)
    {
        Test sol = new Test();
        System.out.println(sol.solution("hello"));
    }
}