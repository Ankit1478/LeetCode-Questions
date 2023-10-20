//{ Driver Code Starts
import java.util.*;

class FindMinCost
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t > 0)
		{
			int n = sc.nextInt();
			int m = sc.nextInt();
			int arr[][] = new int[n][m];
			for(int i=0; i<n; i++)
			{
				for(int j=0; j<m; j++ )
				{
					arr[i][j] = sc.nextInt();
				}
			}
			System.out.println(new Solution().maxArea(arr, n, m));
		t--;
		}
	}
}
// } Driver Code Ends


/*Complete the function given below*/
class Solution {
    

   static class Pair {
        int val;
        int idx;
        Pair(int val, int idx) {
            this.val = val;
            this.idx = idx;
        }
    }
    
    public static  int MAH(int[] arr) {
        int n = arr.length;
        int[] left = new int[n];
        int[] right = new int[n];
        
        Stack<Pair> s = new Stack<>();
        
        // Calculate the indices of the first smaller element on the left
        for (int i = 0; i < n; i++) {
            while (!s.isEmpty() && s.peek().val >= arr[i]) {
                s.pop();
            }
            left[i] = s.isEmpty() ? -1 : s.peek().idx;
            s.push(new Pair(arr[i], i));
        }
        
        // Clear the stack
        s.clear();
        
        // Calculate the indices of the first smaller element on the right
        for (int i = n - 1; i >= 0; i--) {
            while (!s.isEmpty() && s.peek().val >= arr[i]) {
                s.pop();
            }
            right[i] = s.isEmpty() ? n : s.peek().idx;
            s.push(new Pair(arr[i], i));
        }
        
        int max = 0;
        for (int i = 0; i < n; i++) {
            int width = right[i] - left[i] - 1;
            int area = width * arr[i];
            max = Math.max(max, area);
        }
        
        return max;
    }
    public int maxArea(int M[][], int n, int m) {
        // add code here.
      
        int max=0;
        int height[] = new int[n];
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(M[i][j]==1){
                    height[j]++;
                }
                else height[j]=0;
            }
            max = Math.max(max,MAH(height));
        }
        return max;
    }
}



















