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
            int n=sc.nextInt();
            int d=sc.nextInt();
            
            int []arr=new int[n];
            for(int i=0;i<n;i++){
                arr[i]=sc.nextInt();
            }
            
            Solution obj=new Solution();
            int res=obj.countPartitions(n, d, arr);
            System.out.println(res);
        }
    }
}
// } Driver Code Ends


//User function Template for Java

//Back-end complete function Template for Java

class Solution{
	static int mod =(int)(Math.pow(10,9)+7);

    public int countPartitions(int n, int d, int arr[]){
        // Code here
    int totSum = 0;
    for(int i=0; i<arr.length;i++){
        totSum += arr[i];
    }
    
    if(totSum-d<0) return 0;
    
    if((totSum -d)%2==1)return 0;
    
    int s2 = (totSum-d)/2;
    
    int dp[][] = new int[n][s2+1];
    
    for(int row[]: dp)
    Arrays.fill(row,-1);
        
     return sum(n-1,s2,arr,dp);
}
    public static int sum(int idx,int target,int[] arr,int[][]dp){
        
        // tabulation base case 
        // int dp[][] = new int[n][d+1];
        // if(nums[0]==0) dp[0][0] = 2;
        // dp[0][0] =1;
        
       // if(nums[0]!=0 && nums[0]<= target) dp[0][nums[0]] =1;
        
		if(idx==0){
			if(arr[0]==0 && target==0){
				return 2;
			}
			else if(target==arr[0] || target==0){
				return 1;
			}else{
				 return 0;
			}
		}
		 if(dp[idx][target]!=-1)return dp[idx][target];
		 
		int nottaken=sum(idx-1, target, arr, dp);
		int taken=0;
		if(arr[idx]<=target){
			taken+=sum(idx-1, target-arr[idx], arr, dp);
		}
		return dp[idx][target]=(nottaken+taken)%mod;
	}
}











