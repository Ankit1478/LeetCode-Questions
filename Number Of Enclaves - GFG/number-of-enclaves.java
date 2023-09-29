//{ Driver Code Starts
// Initial Template for Java

// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

// Position this line where user code will be pasted.

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int T = Integer.parseInt(in.readLine());
        while (T-- > 0) {
            String s[] = in.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            int a[][] = new int[n][m];
            for (int i = 0; i < n; i++) {
                s = in.readLine().trim().split(" ");
                for (int j = 0; j < m; j++) {
                    a[i][j] = Integer.parseInt(s[j]);
                }
            }
            Solution ob = new Solution();
            out.println(ob.numberOfEnclaves(a));
        }
        out.close();
    }
}
// } Driver Code Ends




// User function Template for Java

class Solution {

      // Your code hereclass Solution {
    static class pair{
        int first;
        int second;
        pair(int first,int second){
            this.first=first;
            this.second=second;
        }
    }

    int numberOfEnclaves(int[][] grid) {
        int n =grid.length;
        int m =grid[0].length;
        Queue<pair>q = new LinkedList<>();
        int vis[][]= new int[n][m];
        // for first row,col and last row,col
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(i==0 ||j==0||i==n-1 ||j==m-1){
                    if(grid[i][j]==1){
                        q.add(new pair(i,j));
                        vis[i][j]=1;
                    }
                }
            }
        }
        int delrow[]={-1,0,1,0};
        int delcol[]={0,-1,0,1};
        while(!q.isEmpty()){
            int row=q.peek().first;
            int col=q.peek().second;
            q.remove();

            // tarnverse all four direction
            for(int i=0;i<4;i++){
                int nrow=row+delrow[i];
                int ncol =col+delcol[i];

                if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && vis[nrow][ncol]==0 && grid[nrow][ncol]==1){
                    q.add(new pair(nrow,ncol));
                    vis[nrow][ncol]=1;
                }
            }
        }
        int count=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1 && vis[i][j]==0){
                    count++;
                }
            }
        }
        return count;
    }
}