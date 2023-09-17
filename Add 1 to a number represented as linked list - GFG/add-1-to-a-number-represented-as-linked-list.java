//{ Driver Code Starts
import java.io.*;
import java.util.*;
class Node
{
    int data;
    Node next;
    
    Node(int x)
    {
        data = x;
        next = null;
    }
}
class GfG
{
    public static void printList(Node node) 
    { 
        while (node != null)
        { 
            System.out.print(node.data);
            node = node.next; 
        }  
        System.out.println();
    } 
    public static void main(String args[])throws IOException
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    String s = sc.next();
                    Node head = new Node( s.charAt(0) - '0' );
                    Node tail = head;
                    for(int i=1; i<s.length(); i++)
                    {
                        tail.next = new Node( s.charAt(i) - '0' );
                        tail = tail.next;
                    }
                    Solution obj = new Solution();
                    head = obj.addOne(head);
                    printList(head); 
                }
        }
}
// } Driver Code Ends


/*
class Node{
    int data;
    Node next;
    
    Node(int x){
        data = x;
        next = null;
    }
} 
*/

class Solution
{
    public static Node addOne(Node head) 
    { 
        //code here.
        Node l1=head;
        Node temp = new Node(1);
        Node l2 = temp;
        return addTwoLists(l1,l2);
    }
     static Node addTwoLists(Node head1, Node head2){
        // code here
        // return head of sum list
        Node l1=reverseList(head1);
        Node l2=reverseList(head2);
        Node dummy=new Node(0);
        Node temp = dummy;
        int carry=0;

        while(l1!=null || l2!=null || carry>0){
            int sum=0;

            if(l1!=null){
                sum+=l1.data;
                l1=l1.next;
            }
            if(l2!=null){
                sum+=l2.data;
                l2=l2.next;
            }

            sum+=carry;
            carry=sum/10;

            Node node = new Node(sum%10);
            temp.next=node;
            temp= temp.next;
        }
        return reverseList(dummy.next);
    }
    public static Node reverseList(Node head)
    {
     Node prev=null;
     Node curr=head;
     Node next;
     while(curr!=null){
         next=curr.next;
         curr.next=prev;
         prev=curr;
         curr=next;
     }
     return prev;
    }
}
