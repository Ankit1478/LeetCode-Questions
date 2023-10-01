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
            int M=sc.nextInt();
            
            int [][]grid=new int[N][M];
            for(int i=0;i<N;i++){
                for(int j=0;j<M;j++){
                    grid[i][j]=sc.nextInt();
                    
                }
            }
            
            Solution obj=new Solution();
            long res=obj.solve(N, M, grid);
            System.out.println(res);
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    public int solve(int n, int m, int grid[][]){
        // Code here
         int dp[][][] = new int[n][m][m];
         
         for(int rows[][]:dp){
             for(int row[]:rows){
                 Arrays.fill(row,-1);
             }
         }
         return   f(0, 0, m - 1, n, m, grid, dp);
    }
    
    static int f(int i,int j1,int j2,int n,int m,int grid[][],int dp[][][]){
        
        if(j1<0 || j2<0 || j1>=m || j2>=m)return (int)(Math.pow(-10, 9));
        
        if(i==n-1) {
            if (j1 == j2) return grid[i][j1];
            else return grid[i][j1] + grid[i][j2];
        }
        
         if (dp[i][j1][j2] != -1) return dp[i][j1][j2];
      
      
         int maxi = Integer.MIN_VALUE;
         for(int dj1=-1;dj1<=1;dj1++){
             for(int dj2=-1;dj2<=1;dj2++){
                 int ans;
                 if(j1==j2){
                     ans = grid[i][j1] + f(i + 1, j1 + dj1, j2 + dj2, n, m, grid, dp);
                 }
                 else{
                     ans = grid[i][j1]+grid[i][j2] + f(i + 1, j1 + dj1, j2 + dj2, n, m, grid, dp);
                 }
                 maxi = Math.max(maxi,ans);
             }
             
             
         }
          return dp[i][j1][j2] = maxi;
        
    }
}