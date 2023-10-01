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
       
       for(int j=0;j<m;j++){
           dp[0][j] = a[0][j];
       }
       
       for(int i=1;i<n;i++){
           for(int j=0;j<m;j++){
               
               int up= a[i][j]+dp[i-1][j];
               
               int leftdia =a[i][j];
               if(j-1>=0){
                   leftdia+= dp[i-1][j-1];
               }
               else{
                   leftdia+= (int) Math.pow(-10, 9);
               }
               
               int rightdia = a[i][j] ;
               if(j+1<m){
                   rightdia+= dp[i-1][j+1];
               }else{
                   rightdia+= (int) Math.pow(-10, 9);
               }
               
               dp[i][j] = Math.max(up, Math.max(leftdia,rightdia));
               
           }
       }
       int max = Integer.MIN_VALUE;
       for(int j=0;j<m;j++){
           max = Math.max(max,dp[n-1][j]);
       }
       return max;
    }
}
