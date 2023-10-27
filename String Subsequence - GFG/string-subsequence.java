//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

public class GFG {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(in.readLine().trim());
        while (tc-- > 0) {
            String S1 = in.readLine();
            String S2 = in.readLine();
            Solution ob = new Solution();
            System.out.println( ob.countWays(S1,S2) );
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    int countWays(String s1, String s2) { 
        // code here 
         int n = s1.length();
        int m = s2.length();
       
        int dp[][] = new int[n+1][m+1];
        for(int i=0;i<=n;i++){
            dp[i][0]=1;
        }
        
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                int nottake =dp[i-1][j];
               int take = 0;

               if (s1.charAt(i-1) == s2.charAt(j-1)) {
                    take = dp[i-1][j-1];
                      }

               dp[i][j] = take + nottake;
              }
        }
        return dp[n][m];
    }

    // static int f(int i, int j, String s1, String s2,int dp[][]) {
    //     if (j == 0) {
    //         return 1; // If s2 is empty, there's one valid subsequence (empty subsequence).
    //     }

    //     if (i == 0) {
    //         return 0; // If s1 is empty and s2 is not, there are no valid subsequences.
    //     }
        
    //     if(dp[i][j]!=-1)return dp[i][j];

    //     int nottake = f(i - 1, j, s1, s2);
    //     int take = 0;

    //     if (s1.charAt(i-1) == s2.charAt(j-1)) {
    //         take = f(i - 1, j - 1, s1, s2);
    //     }

    //     return take + nottake;
    // }
}