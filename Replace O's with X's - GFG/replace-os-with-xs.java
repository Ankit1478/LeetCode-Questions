//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String a[] = in.readLine().trim().split(" ");
            int n = Integer.parseInt(a[0]);
            int m = Integer.parseInt(a[1]);
            char mat[][] = new char[n][m];
            for(int i=0; i<n; i++)
            {
                String S[] = in.readLine().trim().split(" ");
                for(int j=0; j<m; j++)
                {
                    mat[i][j] = S[j].charAt(0);
                }
            }
            
            Solution ob = new Solution();
            char[][] ans = ob.fill(n, m, mat);
            for(int i = 0;i < n;i++) {
                for(int j = 0;j < m;j++) {
                    System.out.print(ans[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static void dfs(int row,int col,int n, int m,boolean vis[][] ,char ch[][],int delrow[],int delcol[]){
        vis[row][col]=true;
        
        for(int i=0;i<4;i++){
            int nrow= row+ delrow[i];
            int ncol = col+ delcol[i];
            
            if(nrow>=0 && ncol>=0 && ncol<m && nrow<n && vis[nrow][ncol]==false  && ch[nrow][ncol]=='O'){
                dfs(nrow,ncol,n,m,vis,ch,delrow,delcol);
            }
        }
    }
    static char[][] fill(int n, int m, char ch[][])
    {
        // code here
       boolean vis[][]= new boolean [n][m];
       int delrow[] ={0,0,-1,1};
       int delcol[]={1,-1,0,0};
       
       for(int i=0;i<m;i++){
           if(ch[0][i]=='O' && !vis[0][i]){
               dfs(0,i,n,m,vis,ch,delrow,delcol);
           }
           
           if(ch[n-1][i]=='O' && !vis[n-1][i] ){
               dfs(n-1,i,n,m,vis,ch,delrow,delcol);
           }
       }
       
       
       for(int i=0;i<n;i++){
           if(ch[i][0]=='O' && !vis[i][0] ){
               dfs(i,0,n,m,vis,ch,delrow,delcol);
           }
           
           if(ch[i][m-1]=='O' && !vis[i][m-1] ){
               dfs(i,m-1,n,m,vis,ch,delrow,delcol);
           }
       }
       
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(!vis[i][j] && ch[i][j]=='O'){
                    ch[i][j]='X';
                }
            }
        }
        return ch;
    }
}