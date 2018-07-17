package pandp;

import java.util.LinkedList;
import java.util.Queue;
import java.util.*;

public class trees {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
work b=new work();
tree root=null;
root=b.insert(10, root);
b.insert(120, root);
b.insert(101, root);
b.insert(110, root);
b.insert(103, root);
b.insert(104, root);
b.insert(2, root);
b.insert(3, root);
b.insert(4, root);
b.insert(5, root);
b.insert(6, root);
b.insert(7, root);
//b.printqt(root);
b.top_view(root);
System.out.println("###########################################################");
b.distfromknode(root, 2);
tree head=b.cons(root);

b.print(head);
	}

}
class tree{
	int val;
	tree right,left;
	tree(int v){
		this.val=v;
		this.left=this.right=null;
	}}
class item{
	tree node;
	int hd;
	item(tree n,int h)
	{
		this.node=n;
		this.hd=h;
	}
}
class work{
	 tree insert(int v,tree root)
		{
			if(root==null)
			{
				root=new tree(v);
				return root;
			}
			if(root.val>v)
			{
				root.left=insert(v,root.left);
				
			}
			else
			{
				root.right=insert(v,root.right);}
			return root;
		}
		tree convert(tree node)
		{
		//	System.out.println("tera jaan");
			if(node==null)
			{
				return node;}
			
			if(node.left!=null)
			{
				tree left=convert(node.left);
				for(;left.right!=null;left=left.right);
				{
					left.right=node;
					node.left=left;
				}}
			if(node.right!=null) {
				tree right=convert(node.right);
			for(;right.left!=null;right=right.left);
			{
				right.left=node;
				node.right=right;
			}}
			return node;
		}
		tree cons(tree node)
		{
			if(node==null)
			{
				return node;
			}
			node =convert(node);
					while(node.left!=null)
					{
						node=node.left;
					}
		return node;
		}
		void printqt(tree root)
		{
			System.out.println("queue");
			Queue<tree> q=new LinkedList<tree>();
			q.add(root);
			while(!q.isEmpty())
			{
				tree tm=q.poll();
				System.out.println(tm.val);
				if(tm.left!=null)
				{
					q.add(tm.left);
				}
				if(tm.right!=null)
				{
					q.add(tm.right);
				}
			}
		}
		void distfromknode(tree root,int k)
		{
			if(root==null)
				return;
			if(k==0)
			{
				System.out.println("this for distance "+root.val+" ");
				return;
			}
			else {
			distfromknode(root.left,k-1);
			distfromknode(root.right,k-1);}
			
		}
		void top_view(tree node)
		{
			System.out.println(" heloo");
			if(node==null)
			{
				return;
			}
			Queue<item>	q=new LinkedList<item>();
			HashSet<Integer> hm=new HashSet<Integer>();
			q.add(new item(node,0));
			while(!q.isEmpty()) {
				item n=q.remove();
				int h=n.hd;
				while(!hm.contains(h)) {
					hm.add(h);
					System.out.print(n.node.val+" ");
				}
				if(n.node.left!=null)
				{
					q.add(new item(n.node.left,h-1));
					//node=node.left;
				}
				if(n.node.right!=null)
				{
					q.add(new item(n.node.right,h+1));
					//node=node.right;
				}
			}
		}
	void print(tree node) 
    {
		System.out.println("doubly linked list");
        while (node != null) 
        {
            System.out.print(node.val + " ");
            node = node.right;
        }
    }}

