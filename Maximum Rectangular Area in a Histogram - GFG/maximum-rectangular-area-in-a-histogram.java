//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    
    
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0){
		    long n = Long.parseLong(br.readLine().trim());
		    String inputLine[] = br.readLine().trim().split(" ");
		    long[] arr = new long[(int)n];
		    for(int i=0; i<n; i++)arr[i]=Long.parseLong(inputLine[i]);
		    System.out.println(new Solution().getMaxArea(arr, n));
		}
	}
}




// } Driver Code Ends


class Solution
{
    static class Pair {
        long val;
        int idx;
        Pair(long val, int idx) {
            this.val = val;
            this.idx = idx;
        }
    }
    
    //Function to find largest rectangular area possible in a given histogram.
    public static long getMaxArea(long arr[], long intN) 
    {
        int n = (int) intN;
        long left[]= new long[n];
        long right[]= new long[n];
        Stack<Pair>s = new Stack<>();
        
        
        for(int i=0;i<n;i++){
            while(!s.isEmpty() && s.peek().val>=arr[i]){
                s.pop();
            }
            left[i] = s.isEmpty() ? -1 : s.peek().idx;
            s.push(new Pair(arr[i], i));
        }
        
        s.clear();
        
         for(int i=n-1;i>=0;i--){
            while(!s.isEmpty() && s.peek().val>=arr[i]){
                s.pop();
            }
            right[i] = s.isEmpty() ? n : s.peek().idx;
            s.push(new Pair(arr[i], i));
        }
        
        long max=0;
        for(int i=0;i<n;i++){
            long width = right[i] - left[i] - 1;
            long area = width * arr[i];
            max = Math.max(max, area);
        }
        return max;
    }
        
}




























