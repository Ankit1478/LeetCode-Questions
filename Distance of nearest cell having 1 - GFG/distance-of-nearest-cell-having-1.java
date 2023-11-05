//{ Driver Code Starts
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
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            int[][] grid = new int[n][m];
            for(int i = 0; i < n; i++){
                String[] S = br.readLine().trim().split(" ");
                for(int j = 0; j < m; j++){
                    grid[i][j] = Integer.parseInt(S[j]);
                }
            }
            Solution obj = new Solution();
            int[][] ans = obj.nearest(grid);
            for(int i = 0; i < ans.length; i++){
                for(int j = 0; j < ans[i].length; j++){
                    System.out.print(ans[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
}
// } Driver Code Ends


class Solution
{
    static class Pair{
        int row;
        int col;
        int step;
        Pair(int row,int col,int step){
            this.row=row;
            this.col=col;
            this.step= step;
        }
    }
    //Function to find distance of nearest 1 in the grid for each cell.
    public int[][] nearest(int[][] grid)
    {
       int n = grid.length;
       int m = grid[0].length;
       Queue<Pair>q = new LinkedList<>();
       int vis[][] = new int[n][m];
       int dist[][] = new int[n][m]; 
       
       for(int i=0;i<n;i++){
           for(int j=0;j<m;j++){
               if(grid[i][j]==1){
                   q.add(new Pair(i,j,0));
                   vis[i][j]=1;
               }
               else{
                   vis[i][j]=0;
               }
           }
       }
       
       
       while(!q.isEmpty()){
           int row= q.peek().row;
           int col= q.peek().col;
           int step = q.peek().step;
           dist[row][col]=step;
           q.poll();
           
           int dr[] ={0,0,-1,1};
           int dc[] ={1,-1,0,0};
           
           for(int i=0;i<4;i++){
               
               int nrow= row+dr[i];
               int ncol = col+dc[i];
               
               if(nrow>=0 && ncol>=0 && nrow<n && ncol<m && vis[nrow][ncol]==0){
                   q.add(new Pair(nrow,ncol,step+1));
                   vis[nrow][ncol]=1;
                   dist[nrow][ncol]=step+1;
               }
           }
       }
       return dist;
    }
}
































