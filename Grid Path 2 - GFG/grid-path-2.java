//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int N = sc.nextInt();
            int M = sc.nextInt();
            int[][] grid = new int[N][M];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    grid[i][j] = sc.nextInt();
                }
            }
            Solution obj = new Solution();
            int res = obj.totalWays(N, M, grid);
            System.out.println(res);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    static int mod = (int)1e9+7;
    public int totalWays(int m, int n, int grid[][]) {
        // Code here
       int dp[][]= new int[m+1][n+1];
        for(int row[]:dp){
            Arrays.fill(row,-1);
        }
        return f(m-1,n-1,m,n,grid,dp);
    }
    static int f(int i,int j, int m,int n,int a[][],int dp[][]){

         if (i >= 0 && j >= 0 && a[i][j] == 1)
            return 0;
            
        // If we've reached the start cell, there's one valid path
        if (i == 0 && j == 0)
            return 1;
        // If we're out of bounds, return 0
        if (i < 0 || j < 0)
            return 0;

        if(dp[i][j]!=-1)return dp[i][j];
        int up = f(i-1,j,m,n,a,dp);
        int down = f(i,j-1,m,n,a,dp);
        return dp[i][j]=(up+down)%mod;
    }
}