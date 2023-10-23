//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    int n = sc.nextInt();
                    int Arr[] = new int[n];
                    for(int i = 0;i<n;i++)
                        Arr[i] = sc.nextInt();
                    Solution ob = new Solution();
                    System.out.println(ob.maxSumIS(Arr,n));
                }
        }
}    
// } Driver Code Ends


//User function Template for Java

class Solution
{
	public int maxSumIS(int arr[], int n)  
	{  
	   
       int dp[][] = new int[n+1][n+1];

       
       for(int i=n-1;i>=0;i--){
           for(int j=i-1;j>=-1;j--){
               int nottake = dp[i+1][j+1];
               int take = 0;
        if(j==-1 || arr[i] > arr[j]){
            take = arr[i] + dp[i+1][i+1];
            }

         dp[i][j+1] = Math.max(nottake,take);
           }
       }
       return dp[0][0];
       
	}  
	static int f(int idx,int prev,int arr[],int dp[][]){
        if(idx==arr.length)return 0;

        if(dp[idx][prev+1]!=-1)return dp[idx][prev+1];

        int nottake = f(idx+1,prev,arr,dp);
        int take = 0;
        if(prev==-1 || arr[idx] > arr[prev]){
            take = arr[idx] + f(idx+1,idx,arr,dp);
        }

        return dp[idx][prev+1] = Math.max(nottake,take);
    }
}