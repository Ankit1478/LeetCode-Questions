//{ Driver Code Starts
//Initial Template for Java

import java.util.*; 
import java.io.*;
import java.lang.*;

class GFG
{
	public static void main(String[] args) 
	{ 
	    Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while (t-- > 0)
        {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[][] matrix = new int[n][m];
            
            for (int i = 0; i < n; i++)
                for (int j = 0; j < m; j++)
                    matrix[i][j] = sc.nextInt();
            
            Solution ob = new Solution();
            ob.diagonalSort(matrix,n,m);
            printMatrix (matrix);
        }
	} 
	
	static void printMatrix(int arr[][]) 
	{ 
		for (int i = 0; i < arr.length; i++) { 
			for (int j = 0; j < arr[0].length; j++) 
				System.out.print(arr[i][j] + " "); 
			System.out.println(""); 
		} 
	} 
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    void diagonalSort(int mat[][], int n, int m)
    {

        HashMap<Integer, ArrayList<Integer>> map = new HashMap();
        for (int i=0; i< n; i++)
            for (int j=0; j < m; j++) {
                map.putIfAbsent(i-j, new ArrayList<>());
                map.get(i-j).add(mat[i][j]);
            }
            
        for (Map.Entry<Integer, ArrayList<Integer>> entry : map.entrySet()) {
            if (entry.getKey() > 0)
                Collections.sort(entry.getValue());
            else if (entry.getKey() < 0)
                Collections.sort(entry.getValue(), Collections.reverseOrder());
        }
        
        for (int i=0; i< n; i++)
            for (int j=0; j < m; j++) {
                mat[i][j] = map.get(i-j).get(0);
                map.get(i-j).remove(0);
            }
    }
}

