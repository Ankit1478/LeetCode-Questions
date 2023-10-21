//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String str = br.readLine().trim();
            Solution ob = new Solution();
            int ans = ob.CountWays(str);
            out.println(ans);
        }
        out.close();
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int CountWays(String s)
    {
        int mod=(int)1e9+7;
        int n = s.length();
        int dp[] = new int[n+1];
        dp[n]=1;

        for(int idx=n-1;idx>=0;idx--){
         if (s.charAt(idx) == '0') dp[idx]=0;

        else{
            int takeOneDigit = dp[idx+1];
        int takeTwoDigit = 0;
        if (idx + 1 < s.length() && (s.charAt(idx) == '1' || (s.charAt(idx) == '2') 
        && s.charAt(idx + 1) <= '6')) {
            takeTwoDigit =dp[idx+2];
        }
         dp[idx] =( takeOneDigit + takeTwoDigit)%mod;
        }
        
        }
        return dp[0];
    }
}