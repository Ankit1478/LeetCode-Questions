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
            int []arr=new int[N];
            for(int i=0;i<N;i++){
                arr[i]=sc.nextInt();
            }
            Solution obj=new Solution();
            int res=obj.NumberofLIS(N, arr);
            System.out.println(res);
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    public int NumberofLIS(int N, int arr[]){
        // Code here
         int n = arr.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        int max=1;
       
       
        int[] count = new int[n];
        Arrays.fill(count, 1);
    
        for (int i = 0; i < n ; i++) {
            for (int j = 0; j < i; j++) {  
                if (arr[i]>arr[j] && 1 + dp[j] > dp[i]) {
                    dp[i] = 1 + dp[j];
                    count[i] = count[j];
                }
                else if(arr[i]>arr[j] && 1+dp[j] == dp[i]){
                    count[i] += count[j];
                }
            }
            max = Math.max(max,dp[i]);
        }
        
        int cnt =0;
        for(int i=0;i<n;i++){
            if(dp[i]==max)cnt+= count[i];
        }
        return cnt;
    }
}