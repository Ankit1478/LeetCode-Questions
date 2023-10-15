//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG{
    public static void main(String args[]) throws IOException{
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int N=sc.nextInt();
            long []prices=new long[N];
            for(int i=0;i<N;i++){
                prices[i]=sc.nextLong();
            }
            Solution obj=new Solution();
            long res=obj.maximumProfit(prices,N);
            System.out.println(res);
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    public long maximumProfit(long prices[], int N){
        //Code here
        long dp[][] = new long[N+2][3];
        
        for(int idx=N-1;idx>=0;idx--){
            for(int buy=0;buy<2;buy++){
             long profit =0;
        
        if(buy==0){
            profit = Math.max(-prices[idx]+dp[idx+1][1], dp[idx+1][0] );
        }
        else{
             profit = Math.max(prices[idx]+dp[idx+2][0], dp[idx+1][1] );
        }
         dp[idx][buy] = profit;
                
            }
        }
        return dp[0][0];
    }
    static long f(int idx,int buy,long prices[],int n,long dp[][]){
        
        if(idx>=n)return 0; 
        
        if(dp[idx][buy]!=-1)return dp[idx][buy];
        
        long profit =0;
        
        if(buy==0){
            profit = Math.max(-prices[idx]+f(idx+1,1,prices,n,dp), f(idx+1,0,prices,n,dp) );
        }
        else{
             profit = Math.max(prices[idx]+f(idx+2,0,prices,n,dp), f(idx+1,1,prices,n,dp) );
        }
        return dp[idx][buy] = profit;
    }
}
