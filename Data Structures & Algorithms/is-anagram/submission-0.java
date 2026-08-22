class Solution {
    public boolean isAnagram(String s, String t) {

        if (s.length()!=t.length()){
            return false ;

        }
        int []n=new int[26];

        for(int i=0;i<s.length();i++)
        {
            n[s.charAt(i)-'a']++;
            n[t.charAt(i)-'a']--;
        }
        for(int m =0;m<n.length;m++){
        if(n[m]!=0){
        return false;}
        }
         return true;

    }
}
