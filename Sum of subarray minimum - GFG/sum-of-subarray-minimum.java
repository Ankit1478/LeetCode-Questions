//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t;
        t = sc.nextInt();
        while (t-- > 0) {

            int N;
            N = sc.nextInt();

            int[] arr = new int[N];
            for (int i = 0; i < N; i++) arr[i] = sc.nextInt();

            Solution obj = new Solution();
            int res = obj.sumSubarrayMins(N, arr);

            System.out.println(res);
        }
    }
}

// } Driver Code Ends


class Solution {
    public static int sumSubarrayMins(int n, int[] arr) {
        // code here
        long left[]=new long[n];
        long right[]= new long[n];
        Stack<Integer>s = new Stack<>();
        int mod = (int)1e9+7;

        for(int i=0;i<n;i++){
            while(!s.isEmpty() &&  arr[s.peek()] > arr[i]){
                s.pop();
            }
            left[i]=s.isEmpty()? i+1:i-s.peek();
            s.push(i);
        }
        s.clear();

        for(int i=n-1;i>=0;i--){
            while(!s.isEmpty() &&  arr[s.peek()]>= arr[i]){
                s.pop();
            }
            right[i]=s.isEmpty()?n-i:s.peek()-i;
            s.push(i);
        }

        long result=0;
        for(int i=0;i<n;i++){
            result= (result+(arr[i]*left[i]*right[i])%mod)%mod;
        }
        return (int)result;
    }
}
