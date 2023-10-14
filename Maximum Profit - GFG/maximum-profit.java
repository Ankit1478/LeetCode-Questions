//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader in =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while (t-- > 0) {
            int K = Integer.parseInt(in.readLine());
            int N = Integer.parseInt(in.readLine());
            String input_line[] = in.readLine().trim().split("\\s+");
            int A[] = new int[N];
            for (int i = 0; i < N; i++) A[i] = Integer.parseInt(input_line[i]);

            Solution ob = new Solution();
            System.out.println(ob.maxProfit(K, N, A));
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    static int maxProfit(int k, int n, int prices[]) {
        // code here
    int dp[][][]  = new int[n+1][2][k+1];
      
      for(int idx=n-1;idx>=0;idx--){
          for(int buy=0;buy<=1;buy++){
              for(int cap=1;cap<=k;cap++){
                   int profit=0;
        if(buy==0){ // mtlb abhi tk kch nhi liya hai to
             dp[idx][buy][cap] = Math.max(-prices[idx]+dp[idx+1][1][cap], dp[idx+1][0][cap]);
        }
        else{
               dp[idx][buy][cap] = Math.max(prices[idx]+dp[idx+1][0][cap-1], dp[idx+1][1][cap]);
        }
              }
          }
      }
      return dp[0][0][k];
    }
}