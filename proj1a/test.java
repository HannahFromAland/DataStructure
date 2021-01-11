public class test {
    public static void main(String[] args){
        String s = "abcabcbb";
        System.out.print(lengthOfLongestSubstring(s));
    }
    public static int lengthOfLongestSubstring(String s) {
        int max = 0;
        for(int i=0;i<s.length()-1;i++){
            String sub = s.substring(i,i+1);
            for(int j=i+1;j<s.length();j++){
                String next = s.substring(j,j+1);
                if(sub.indexOf(next)!= -1){
                    break;
                }else{
                    sub += next;
                }
            }
            if(sub.length()>max){
                max = sub.length();
            }
        }
        return max;
    }
}
