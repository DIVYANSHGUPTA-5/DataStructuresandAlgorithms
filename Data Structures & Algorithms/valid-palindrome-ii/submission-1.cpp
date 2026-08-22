class Solution {
public:
bool pay(string s,int l,int r)
{
    while(l<=r)
    {
        if(s[l]!=s[r])
        {
            return false;
        }
        l++;
        r--;
    }
    return true;
}
    bool validPalindrome(string s) {
        int len=s.size();
        int i=0,j=len-1;
        while(i<j)
        {
            if(s[i]!=s[j])
            {
                return pay(s,i,j-1)|| pay(s,i+1,j);
            }
        i++;
        j--;
        }
        return true;
    }
};