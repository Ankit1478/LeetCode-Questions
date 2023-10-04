//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));

        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String roman = br.readLine().trim();
            Solution ob = new Solution();
            System.out.println(ob.romanToDecimal(roman));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    // Finds decimal value of a given roman numeral
    public int pattern(char c){
        if(c=='I') return 1;
        else if(c=='V') return 5;
        else if(c =='X') return 10;
        else if(c=='L') return 50;
        else if(c=='C') return 100;
        else if(c == 'D') return 500;
        else if(c=='M')  return 1000;
        else return c;
    }
    public int romanToDecimal(String s) {
        // code here
        int num =0;
        int n = s.length();

        for(int i=0;i<n-1;i++){
            int diff = pattern(s.charAt(i)) - pattern(s.charAt(i+1));
            if(diff<0){
                num -= pattern(s.charAt(i));
            }
            else{
                num  += pattern(s.charAt(i));
            }
        }
        num+= pattern(s.charAt(n-1));
        return num;
    }
}