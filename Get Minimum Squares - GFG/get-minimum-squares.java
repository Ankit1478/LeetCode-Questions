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
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            Solution ob = new Solution();
            int ans = ob.MinSquares(n);
            System.out.println(ans);           
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int MinSquares(int n)
    {
        int dp[] = new int[n+1];
        Arrays.fill(dp,-1);
        return f(n,dp);
    }
    static int f(int n,int dp[]){
         if (n <= 0) {
            return 0;
        }
        
        if(dp[n]!=-1)return dp[n];
        int minSquares = Integer.MAX_VALUE;

        for (int i = 1; i*i  <= n; i++) {
            int squaresNeeded = f(n - i * i,dp) + 1;
            minSquares = Math.min(minSquares, squaresNeeded);
        }
        return dp[n]=minSquares;
    }
}