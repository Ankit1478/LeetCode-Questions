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
    static class Pair {
        int row;
        int col;

        Pair(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    static char[][] fill(int n, int m, char[][] mat) {
        int[] dx = {-1, 0, 0, 1};
        int[] dy = {0, -1, 1, 0};
        Queue<Pair> q = new LinkedList<>();
        int[][] vis = new int[n][m];
        char[][] ans = new char[n][m];
        
        for (int i = 0; i < n; i++) {
            Arrays.fill(vis[i], -1);
            Arrays.fill(ans[i], 'X');
        }
        
        for (int i = 0; i < m; i++) {
            if (mat[0][i] == 'O') {
                q.add(new Pair(0, i));
            }
            if (mat[n - 1][i] == 'O') {
                q.add(new Pair(n - 1, i));
            }
        }
        
        for (int i = 1; i < n - 1; i++) {
            if (mat[i][0] == 'O') {
                q.add(new Pair(i, 0));
            }
            if (mat[i][m - 1] == 'O') {
                q.add(new Pair(i, m - 1));
            }
        }
        
        while (!q.isEmpty()) {
            Pair xx = q.poll();
            int x = xx.row, y = xx.col;
            ans[x][y] = 'O';
            vis[x][y] = 1;
            
            for (int i = 0; i < 4; i++) {
                int newx = x + dx[i];
                int newy = y + dy[i];
                
                if (newx >= 0 && newy >= 0 && newx < n && newy < m && vis[newx][newy] == -1 && mat[newx][newy] == 'O') {
                    q.add(new Pair(newx, newy));
                }
            }
        }
        
        return ans;
    }
}










