//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
import java.math.*;

class Node  
{ 
    int data; 
    Node left, right; 
   
    public Node(int d)  
    { 
        data = d; 
        left = right = null; 
    } 
}

class GFG
{
    static Node buildTree(String str)
    {
        // Corner Case
        if(str.length() == 0 || str.equals('N'))
            return null;
        String[] s = str.split(" ");
        
        Node root = new Node(Integer.parseInt(s[0]));
        Queue <Node> q = new LinkedList<Node>();
        q.add(root);
        
        // Starting from the second element
        int i = 1;
        while(!q.isEmpty() && i < s.length)
        {
              // Get and remove the front of the queue
              Node currNode = q.remove();
        
              // Get the current node's value from the string
              String currVal = s[i];
        
              // If the left child is not null
              if(!currVal.equals("N")) 
              {
        
                  // Create the left child for the current node
                  currNode.left = new Node(Integer.parseInt(currVal));
        
                  // Push it to the queue
                  q.add(currNode.left);
              }
        
              // For the right child
              i++;
              if(i >= s.length)
                  break;
              currVal = s[i];
        
              // If the right child is not null
              if(!currVal.equals("N")) 
              {
        
                  // Create the right child for the current node
                  currNode.right = new Node(Integer.parseInt(currVal));
        
                  // Push it to the queue
                  q.add(currNode.right);
              }
              
              i++;
        }
    
        return root;
    }
    
    public static void main(String args[]) throws IOException {
    
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while(t>0)
        {
            String s = br.readLine();
            Node root = buildTree(s);
            
            int target = Integer.parseInt(br.readLine().trim());
            
            Solution T = new Solution();
            System.out.println(T.isPairPresent(root,target));
            t--;
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
     public class BSTitertator{
        private Stack<Node>s=new Stack<>();
        boolean reverse=true; //before;

        public  BSTitertator(Node root, Boolean isReverse){
            reverse=isReverse;
            pushAll(root);
        }
        public boolean hasNext(){
            return !s.isEmpty();
        }
        public int next(){
            Node temp=s.pop();
            if(reverse==false) pushAll(temp.right);
            else pushAll(temp.left);
            return temp.data;
        }
        public void pushAll(Node root){
            while(root!=null){
                s.push(root);
                if(reverse==false){
                   root=root.left;
                }else{
                    root=root.right;
                }
            }
        }
    }
    
    public int isPairPresent(Node root, int k)
    {
      
        if(root==null)return 0;
        BSTitertator l= new BSTitertator(root,false);
        BSTitertator r= new BSTitertator(root,true);

        int i=l.next();
        int j=r.next();

        while(i<j){
            if(i+j==k)return 1;
            else if(i+j<k)  i =  l.next();
            else j= r.next() ;
        }
        return 0;
        
    }
}
