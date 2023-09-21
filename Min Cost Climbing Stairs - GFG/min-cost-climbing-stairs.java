//{ Driver Code Starts
//Initial Template for JAVA

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());
            
            String S[] = read.readLine().split(" ");
            
            int[] cost = new int[N];
            
            for(int i=0 ; i<N ; i++)
                cost[i] = Integer.parseInt(S[i]);

            Solution ob = new Solution();
            System.out.println(ob.minCostClimbingStairs(cost,N));
        }
    }
}
// } Driver Code Ends


//Back-end complete function Template for Java

class Solution {
    static int minCostClimbingStairs(int[] cost , int N) {
        //Write your code here
        int dp[]= new int[N+1];
        Arrays.fill(dp,-1);
        return  Math.min(f(0, cost, N, dp), f(1, cost, N, dp));
    }
    static int f(int idx,int arr[],int n,int dp[]){
        if(idx>=n){
            return 0;
        }
        if(dp[idx]!=-1)return dp[idx];
        int jump1= f(idx+1,arr,n,dp)+Math.abs(arr[idx]);
        int jump2=f(idx+2,arr,n,dp)+Math.abs(arr[idx]);
            
        return dp[idx]=Math.min(jump1,jump2);
    }
};