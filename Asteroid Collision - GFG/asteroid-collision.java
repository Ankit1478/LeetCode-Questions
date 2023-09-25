//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {

            int N;
            N = sc.nextInt();

            int[] asteroids = new int[N];
            for (int i = 0; i < N; i++) asteroids[i] = sc.nextInt();

            Solution obj = new Solution();
            int[] res = obj.asteroidCollision(N, asteroids);

            for (int e : res) System.out.print(e + " ");
            System.out.println();
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public static int[] asteroidCollision(int N, int[] arr) {
        // code here
        Stack<Integer> s= new Stack<>();
        
        for(int i : arr){
            
            while(!s.isEmpty() && i<0 && s.peek()>0){
                
                int sum = i+s.peek();
                
                if(sum==0){
                    s.pop();
                    i=0;
                }
                else if(sum>0 ){
                    i=0;
                }
                else {
                    s.pop();
                }
            }
            if(i!=0){
                s.push(i);
            }
            
}
       int res[]=new int[s.size()];
        int i=s.size()-1;
        while(!s.isEmpty()){
            int top=s.pop();
            
            res[i--]=top;
        }
        return res;
}
}
