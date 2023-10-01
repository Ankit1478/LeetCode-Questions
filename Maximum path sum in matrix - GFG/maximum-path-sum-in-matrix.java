//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(in.readLine());
            String input_line[] = in.readLine().trim().split("\\s+");
            int Matrix[][] = new int[N][N];
            for(int i = 0; i < N*N; i++)
                Matrix[(i/N)][i%N] = Integer.parseInt(input_line[i]);
            
            Solution ob = new Solution();
            System.out.println(ob.maximumPath(N, Matrix));
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution{
    static int maximumPath(int N, int a[][])
    {
        int n = a.length;
        int m = a[0].length;
        int dp[][]  = new int[n][m];
        for(int row[] : dp){
            Arrays.fill(row,-1);
        }
        int max = Integer.MIN_VALUE;
        for(int i=0;i<m;i++){
            int getmax = f(n-1,i,n,m,a,dp);
            
            max =Math.max(max,getmax);
        }
        return max;
    }
    static int f(int i,int j, int n ,int m, int a[][] , int dp[][]){
       
        if(j<0 || j>=m){
              return (int) Math.pow(-10, 9);
        }
        
         if(i==0)return a[0][j];
        
        
        if(dp[i][j]!=-1)return dp[i][j];
        
        int up = a[i][j]+f(i-1,j,n,m,a,dp);
        int leftdia = a[i][j]+f(i-1,j-1,n,m,a,dp);
        int rightdia = a[i][j]+f(i-1,j+1,n,m,a,dp);
        
        return dp[i][j] = Math.max(up, Math.max(leftdia,rightdia));
    }
}
