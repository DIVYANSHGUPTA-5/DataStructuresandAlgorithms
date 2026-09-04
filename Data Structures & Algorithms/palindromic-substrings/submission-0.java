class Solution {
    int count=0;
    public int countSubstrings(String s) {
      int n=s.length();
        Boolean[][]dp=new Boolean[n+1][n+1];
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                if(solve(s , i , j ,dp)){
                    count++;
                }
                
            }
            
        }
        return count;
        
    }

    public boolean solve(String s ,int i ,int j , Boolean[][]dp){
        if(i>=j) return true;
        if(dp[i][j]!=null) return dp[i][j];
        if(s.charAt(i)!=s.charAt(j)){

          return   dp[i][j]= false;
        } 
        return dp[i][j]=solve(s,i+1,j-1,dp);
    }
}
    



