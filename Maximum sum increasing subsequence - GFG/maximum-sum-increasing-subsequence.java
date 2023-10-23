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
	public int maxSumIS(int nums[], int n)  
	{  
	    //code here.
	   
       int dp[][] = new int[n][n+1];

       for(int row[]:dp)Arrays.fill(row,-1);

       return f(0,-1,nums,dp);
          
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