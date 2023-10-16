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
            String s = br.readLine().trim();
            String[] s1 = s.split(" ");
            int[] nums = new int[n];
            for(int i = 0; i < s1.length; i++)
                nums[i] = Integer.parseInt(s1[i]);
            Solution ob = new Solution();
            int ans = ob.LongestBitonicSequence(nums);
            System.out.println(ans);           
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int LongestBitonicSequence(int[] arr)
    {
        
        int n = arr.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
       
    
        for (int i = 0; i < n ; i++) {
            for (int j = 0; j < i; j++) {  
                if (arr[i]>arr[j] && 1 + dp[j] > dp[i]) {
                    dp[i] = 1 + dp[j];
                }
            }
           
        }
        int[] dp2 = new int[n];
        Arrays.fill(dp2, 1);
        
        for (int i = n-1; i >=0 ; i--) {
            for (int j = n-1; j >i ; j--) { 
                if (arr[i]>arr[j] && 1 + dp2[j] > dp2[i]) {
                    dp2[i] = 1 + dp2[j];
                }
            }
            
        }
         int max = 0;
        for(int k=0;k<n;k++){
            max = Math.max(max,dp[k]+dp2[k]-1);
        }
        
        return max;
        
    }
}