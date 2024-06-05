//{ Driver Code Starts
//Initial Template for Java
import java.util.*;

class Node
{
	int data;
	Node next;
	Node prev;
	Node(int d)
	{
		data = d;
		next = prev = null;
	}
}
class Delete_Node_From_DLL
{
	Node head;
	Node tail;
	
	void addToTheLast(Node node)
	{
		if(head ==  null)
		{
			head = node;
			tail = node;
		}
		else
		{
			tail.next = node;
			tail.next.prev = tail;
			tail = tail.next;
		}
	}
	
	void printList(Node head)
	{	Node temp = head;
		while(temp != null)
		{
			System.out.print(temp.data+" ");
			temp =  temp.next;
		}
		System.out.println();
	}
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t>0)
		{
			int n = sc.nextInt();
			Delete_Node_From_DLL list = new Delete_Node_From_DLL();
			
			int a1 = sc.nextInt();
			Node head = new Node(a1);
			list.addToTheLast(head);
			
			for(int i=1;i<n;i++)
			{
				int a = sc.nextInt();
				list.addToTheLast(new Node(a));
			}
			a1 = sc.nextInt();
			Solution g = new Solution();
			//System.out.println(list.temp.data);
			Node ptr = g.deleteNode(list.head, a1);
			list.printList(ptr);
			t--;
		}
	}
}


                               
// } Driver Code Ends


//User function Template for Java

/* Structure of linkedlist node
class Node
{
	int data;
	Node next;
	Node prev;
	Node(int d)
	{
		data = d;
		next = prev = null;
	}
}
*/
class Solution
{
    // function returns the head of the linkedlist
    Node deleteNode(Node head,int x)
    {
        
	// Your code here
	if (head==null){
	    return null;
	}
	int c=1;
	Node knode=head;
	while(knode!=null && c<x){
	    c++;
	    knode=knode.next;
	}
	   if (knode == null) {
            // Position x is out of bounds
            return head;
        }
	Node prev=knode.prev;
	Node front=knode.next;
	if (prev==null && front==null){
	    return null;
	}
	if (prev==null){
	    return deletehead(head);
	}
	if (front==null){
	    return deletetail(head);
	}
	
	prev.next=front;
	front.prev=prev;
	knode.next=null;
	knode.prev=null;
	return head;
    }
    Node deletehead(Node head){
        if (head==null || head.next==null){
            return null;
        }
        // Node prev=head;
        Node newhead=head.next;
        newhead.prev=null;
        head.next=null;
        return newhead;
    }
    Node deletetail(Node head){
        if (head==null || head.next==null){
            return null;
        }
        Node tail=head;
        while(tail.next!=null){
            tail=tail.next;
        }
        Node prev=tail.prev;
        if (prev!=null){
            
        prev.next=null;
        }
        tail.prev=null;
        return head;
    }
    
}
