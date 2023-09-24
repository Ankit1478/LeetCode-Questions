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


class Solution {
    static class Pair {
        long val;
        int idx;

        Pair(long val, int idx) {
            this.val = val;
            this.idx = idx;
        }
    }

    // Function to find the largest rectangular area possible in a given histogram.
    public static long getMaxArea(long hist[], long n) {
        int intN = (int) n;
        long left[] = new long[intN];
        long right[] = new long[intN];
        Stack<Pair> s = new Stack<>();

        for (int i = 0; i < intN; i++) {
            while (!s.isEmpty() && s.peek().val >= hist[i]) {
                s.pop();
            }
            left[i] = s.isEmpty() ? -1 : s.peek().idx;
            s.push(new Pair(hist[i], i));
        }

        s.clear();

        for (int i = intN - 1; i >= 0; i--) {
            while (!s.isEmpty() && s.peek().val >= hist[i]) {
                s.pop();
            }
            right[i] = s.isEmpty() ? intN : s.peek().idx;
            s.push(new Pair(hist[i], i));
        }

        long max = 0;
        for (int i = 0; i < intN; i++) {
            long width = right[i] - left[i] - 1;
            long area = width * hist[i];
            max = Math.max(max, area);
        }
        return max;
    }
}














