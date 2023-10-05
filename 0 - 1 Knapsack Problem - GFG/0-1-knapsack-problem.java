//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class gfg
{
    public static void main(String args[])throws IOException
    {
        //reading input using BufferedReader class
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        
        //reading total testcases
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0)
        {
            //reading number of elements and weight
            int n = Integer.parseInt(read.readLine());
            int w = Integer.parseInt(read.readLine());
            
            int val[] = new int[n];
            int wt[] = new int[n];
            
            String st[] = read.readLine().trim().split("\\s+");
            
            //inserting the values
            for(int i = 0; i < n; i++)
              val[i] = Integer.parseInt(st[i]);
             
            String s[] = read.readLine().trim().split("\\s+"); 
            
            //inserting the weigths
            for(int i = 0; i < n; i++)
              wt[i] = Integer.parseInt(s[i]);
              
            //calling method knapSack() of class Knapsack
            System.out.println(new Solution().knapSack(w, wt, val, n));
        }
    }
}




// } Driver Code Ends


class Solution 
{ 
    //Function to return max value that can be put in knapsack of capacity W.
    static int knapSack(int W, int wt[], int val[], int n) 
    { 
         // your code here 
        int dp[][] = new int[n][W+1];
        for(int i=wt[0];i<=W;i++){
                dp[0][i] = val[0];
        }
        
        for(int i=1;i<n;i++){
            for(int cap =0;cap<=W;cap++){
                int nottake = dp[i-1][cap];
                int take = Integer.MIN_VALUE;
                if(wt[i]<=cap){
                take = val[i]+dp[i-1][cap-wt[i]];
                }
                dp[i][cap] = Math.max(take,nottake);
            }
        }
        return dp[n-1][W];
    } 
    
    static int f(int idx,int W,int wt[],int val[],int dp[][]){
        if(idx==0){
            if(wt[0]<=W){
                return val[0];
            }
            return 0;
        }
        if(dp[idx][W]!=-1)return dp[idx][W];
        
        int nottake = f(idx-1,W,wt,val,dp);
        int take = Integer.MIN_VALUE;
        if(wt[idx]<=W){
            take = val[idx]+f(idx-1,W-wt[idx],wt,val,dp);
        }
        return dp[idx][W] = Math.max(take,nottake);
    }
}


