
///////////////////////////////////////
//Programmer: Richard Idigo
// PROJECT 2: MYTREEMAP
// DUE: 10/27/14
//STATUS: REVISED
///////////////////////////////////////////
/**
 *	TreeMap implemented as Binary Search Tree
 */
import tree.*;
public class MyTreeMap<K extends Comparable<K>,V> {
	private BinaryTree<Element> map;
	java.util.Set<K> keys;  // to return keys in order
	private int size;
		
	public boolean containsKey(K key)
	{
		return get(key)!=null;
	}
	public V put(K key, V value)
	{
	 insert(new Element(key,value));
	 size++; // inc size by 1
	 return value;
	}
	public V get(K key)
	{
		Element find = search(new Element(key,null),map);
		if(find==null) return null;
		if(key.equals(find.key)) return find.value;
		 return null;
	}
	public V remove(K key)
	{
		Element del= delete(map,new Element(key,null),map);
		 size--;
		 return del.value;
	}
	public int size()
	{
		 return size;
	}
	public int height()
	{
		 return height(map);
	}
	public String toString()
	{
		return map.toString();
	}
	public java.util.Set<K> keySet()
	{
	 keys= new java.util.TreeSet<>();
	 if(map!=null) inorder(map);
	 return keys;
	}

// Element class
	private class Element{
	K key; V value;
	public Element(K key, V value)
	{
		this.key=key;
		this.value=value;
	}
	public int compareTo(Element that)
	{
	 return (this.key).compareTo(that.key);
	
	}
	public boolean equals(Element that)
	{
		return (this.key).equals(that.key);
	}
	public String toString()
	{
	 return map.toString();
	}
	
}
	
// private methods implementing BST operations search, insert, delete, inorder
// reference: Wikipedia article on Binary Search Tree
//
	private Element search(Element element, BinaryTree<Element> tree)
	{
		if(tree==null) return null;
		Element r= tree.getRoot();
		if(element.equals(r)) return r;
		else if(element.compareTo(r)<0) return search(element, tree.getLeft());
		else return search(element,tree.getRight());

	}
	private Element insert(Element element)
	{
		if(map==null)
		{
		    map=new BinaryTree<Element>(element);
			return null;	
		}
		else
			return insert(element,map);
	
	}
	private Element insert(Element element, BinaryTree<Element> tree)
	{
		Element r= tree.getRoot();
		if(element.equals(r))
		{
			tree.setRoot(element);
			return r;
	    }
			else if( element.compareTo(r) <0)
			{
				if(tree.getLeft()==null)
				{
					tree.setLeft(new BinaryTree<Element>(element));	
					return null;
				}
			    else
			      return insert(element, tree.getLeft());
			}
	            else//((element.compareTo(r)) > 0)
		        {
			         if(tree.getRight()==null)
			         {
			             tree.setRight(new BinaryTree<Element>(element));
			             return null;
			          }
			           else 
			             return insert(element, tree.getRight());
		
                }		
	}
	private Element delete(BinaryTree<Element> tree, Element element, BinaryTree<Element> parent)
    {
		if(tree==null) return null;
			Element r= tree.getRoot();
			if(element.compareTo(r)<0)
			{
				return delete(tree.getLeft(), element,tree);
			}
			else if(element.compareTo(r)>0)
			{
				return delete(tree.getRight(),element,tree);
			}
			else  //(element.equals(r))
			{
			////////////////
			/// leaf
			///////////////////
				if(tree.isLeaf())
				{
					promote(tree,parent,null);
			
				}
			//////////////////////
			// one child
			/////////////////////////
				else if(tree.getLeft()!=null){
					tree.setRoot(tree.getLeft().getRoot());
					promote(tree.getLeft(), parent, tree.getLeft());
				}
				
				else if(tree.getRight()!=null){
					tree.setRoot(tree.getRight().getRoot());
					promote(tree.getRight(), parent, tree.getRight());
				}
			/////////////////////
			//two children     //
			/////////////////////
				else
				{
					tree.setRoot(tree.getLeft().getRoot());
					delete(tree.getLeft(), tree.getLeft().getRoot(), tree);
			   }
				return r;
			}
	    
	}
// make newChild the appropriate (left or right) child of parent, if parent exists
	private void promote(BinaryTree<Element> tree, BinaryTree<Element> parent, BinaryTree<Element> newChild)
	{
		if(parent==null) map=newChild;
		else if(tree==parent.getLeft()) parent.setLeft(newChild);
		else parent.setRight(newChild);
	
	}
	private Element inorderSucc(BinaryTree<Element> tree, BinaryTree<Element> parent)
	{
		BinaryTree<Element> x=null;
		BinaryTree <Element> succ=null;
		x=tree;
		parent=tree;
		if(tree.getRight().getLeft()==null)  // meaning there is no left make, IS is right of x
		{
			x.setRight(x.getRight());
			return x.getRoot();
		}
		
		else       // we can make atleast one left, so go right once
		{
			tree=tree.getRight();
			while( tree.getLeft()!=null)
			{
				parent=tree;
				tree=tree.getLeft();
			}	
			succ=tree;
			x.setRoot(tree.getRoot());
			
			parent.setLeft(tree.getRight());
		}
		
	   return x.getRoot();
	}
	private void inorder(BinaryTree<Element> tree)
	{
	   if (tree!=null) //  there is a tree
	   {
		   inorder(tree.getLeft());
		   keys.add(tree.getRoot().key);
		   inorder(tree.getRight());
		   
	   }
	
	}
	private int height(BinaryTree<Element> tree)
	{
	   if(tree==null)return 0;
			int lHeight=height(tree.getLeft()); // height of left subtree
			int rHeight=height(tree.getRight());
		
			return (lHeight > rHeight) ? lHeight +1: rHeight + 1;
	
	
	}
}	