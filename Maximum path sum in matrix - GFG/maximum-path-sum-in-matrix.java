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
        int prev[] = new int[m];
        int curr[] = new int[m];

        for (int j = 0; j < m; j++) {
            prev[j] = a[0][j];
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int up = a[i][j] + prev[j];

                int leftdia = a[i][j] + (j - 1 >= 0 ? prev[j - 1] : (int) Math.pow(-10, 9));
                int rightdia = a[i][j] + (j + 1 < m ? prev[j + 1] : (int) Math.pow(-10, 9));

                curr[j] = Math.max(up, Math.max(leftdia, rightdia));
            }
            for (int j = 0; j < m; j++) {
                prev[j] = curr[j]; // Copy the values from curr to prev
            }
        }

        int max = Integer.MIN_VALUE;
        for (int j = 0; j < m; j++) {
            max = Math.max(max, prev[j]);
        }

        return max;

    }
}
