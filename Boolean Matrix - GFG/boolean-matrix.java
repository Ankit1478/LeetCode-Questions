//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0)
        {
            String str[] = read.readLine().trim().split("\\s+");
            int r = Integer.parseInt(str[0]);
            int c = Integer.parseInt(str[1]);
            int matrix[][] = new int[r][c];
            
            for(int i = 0; i < r; i++)
            {
                int k = 0;
                str = read.readLine().trim().split("\\s+");
                for(int j = 0; j < c; j++){
                  matrix[i][j] = Integer.parseInt(str[k]);
                  k++;
                }
            }
            new Solution().booleanMatrix(matrix);
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < r; i++){
                for(int j = 0; j < c; j++){
                    sb.append(matrix[i][j] + " ");
                }
                sb.append("\n"); 
            }
            System.out.print(sb);
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    //Function to modify the matrix such that if a matrix cell matrix[i][j]
    //is 1 then all the cells in its ith row and jth column will become 1.
    void booleanMatrix(int matrix[][])
    {
        // code here 
        int n =matrix.length;
        int m =matrix[0].length;
        int x=1;
        int y=1;
        
        for(int i=0;i<n;i++){
            if(matrix[i][0]==1){
                x=0;
                break;
            }
        }
        for(int i=0;i<m;i++){
            if(matrix[0][i]==1){
                y=0;
                break;
            }
        }
        
        for(int i=1;i<n;i++){
            for(int j=1;j<m;j++){
                if(matrix[i][j]==1){
                    matrix[i][0]=1;
                    matrix[0][j]=1;
                }
            }
        }
        
        
        for(int i=1;i<n;i++){
            for(int j=1;j<m;j++){
                if(matrix[i][0]==1 ||   matrix[0][j]==1 ){
                   matrix[i][j]=1;
                }
            }
        }
        
        
        if(x==0){
            for(int i=0;i<n;i++){
                matrix[i][0] = 1;
            }
        }
        
        
        if(y==0){
            for(int i=0;i<m;i++){
                matrix[0][i] = 1;
            }
        }
        
    }
}















