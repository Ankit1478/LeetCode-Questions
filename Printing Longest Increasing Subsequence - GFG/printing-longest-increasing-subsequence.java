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
            ArrayList<Integer>ans=obj.longestIncreasingSubsequence(N, arr);
            for(int i=0;i<ans.size();i++){
                System.out.print(ans.get(i)+" ");
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    public ArrayList<Integer> longestIncreasingSubsequence(int n, int arr[]){
        // Code here
        int dp[] = new int[n];
        Arrays.fill(dp,1);
        
        int hash[] = new int[n];
        Arrays.fill(hash,1);
        
        int lastidx=0;
        int max=1;
        
        for(int idx=0;idx<n;idx++){
            hash[idx] =idx;
            for(int prev=0;prev<idx;prev++){
                if(arr[idx]>arr[prev] && 1+dp[prev]>dp[idx]){
                    dp[idx] = 1+dp[prev];
                    hash[idx] = prev;
                }
            }
            if(dp[idx]>max){
                max=dp[idx];
                lastidx=idx;
            }
        }
        ArrayList<Integer>ans = new ArrayList<>();
        ans.add(arr[lastidx]);
        
        while(hash[lastidx]!=lastidx){
            lastidx =  hash[lastidx];
            ans.add(arr[lastidx]);
        }
        Collections.sort(ans);
        return ans;
    }
}











