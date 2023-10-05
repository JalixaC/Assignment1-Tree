package tree;

class Node{
	   int value;
	   Node left, right;
	   
	   public Node(int value){
	      this.value = value;
	      left = null;
	      right = null;
	   }

	}

	class BinarySearchTree{

	   Node root;
	  
	   
	   /*
	   recursive insert method
		
	   */
	   /*
	   inserts a node into the tree
	   */
	   public void insert(int value){
	      //tree is empty
	      if(root == null){
	         root = new Node(value);
	         return;
	      }else{
	         Node current = root;
	         Node parent = null;
	         
	         while(true){
	            parent = current;
	            
	            if(value < current.value){
	               current = current.left;
	               if(current == null){
	                  parent.left = new Node(value);
	                  return;
	               }
	            }else{
	               current = current.right;
	               if(current == null){
	                  parent.right = new Node(value);
	                  return;
	               }
	            }
	           
	         }//closing while
	      
	      }//closing main if-else 
	   }
	   
	   /**
	   prints the nodes in pre-order; root, left, right
	   @param Node root is used to reach the rest of the tree
	   
	   */
	   public void preOrderTraversal(Node root){
		   if(root == null) {
			   return;
		}
		
		System.out.println(root.value + " "); 
		
		preOrderTraversal(root.left); //recursively keeps printing left until there are no more left
	   
		preOrderTraversal(root.right); //then goes to the right subtree 
		
	   }

	   
	   
	   /**
	   goes through the tree in-order traversal; left, root, right
	   @param root node is used to search the tree
	   */
	   public void inOrderTraversal(Node root){
	      if(root == null) {
	    	  return; 
	        }
	      
	      inOrderTraversal(root.left); //recursively goes through the left side then prints everything out
	      
	      System.out.println(root.value + " ");
	      
	      inOrderTraversal(root.right); //then goes into the right
	   }
	   
	   
	   
	   /**
	   post-order traversal, prints left, right and lastly the root
	   @param root node which is used to search the tree
	   */
	  
	   public void postOrderTraversal(Node root){
		 if(root == null){
		         return;
		   }
		 postOrderTraversal(root.left); //recursively into left subtree
		      
		 postOrderTraversal(root.right); //recursively into right subtree 
		      
		 System.out.print(root.value + " "); //lastly prints the value 
		   
	   }
	   
	   
	   
	   /**
	   	Method used to find the key in the root tree
	   	@param root is the tree 
	   	@param key is the node trying to be found
	   	@return is the boolean declaring if key was found
	   */
	   public boolean find(Node root, int key){
		 if(root == null) {
			 return false; //if root is null, the root wasn't found
		 }
		 if(root.value == key) { //once found true is returned
			 return true;
		 } else if (key < root.value) { 
			//recursively keeps looking in the left subtree if key is less then current value
			 return find(root.left, key); 
		 }else {
			 // keeps looking in the right subtree if key is greater than current value
			 return find(root.right, key);
		 }
		  
	   }
	   
	   
	   
	   /**
	   a method to find the node in the tree with the 
	   smallest value
	   @param the root of to search the tree
	   @return the smallest node in the tree
	   */
	   public int getMin(Node root){
         if(root == null) {
        	 return -1;
         }
	      while(root.left != null) { //if no leaf node has been reached, keeps going
	    	  if(root.left.value < root.value) { 
	    		  root = root.left; //keeps going left to find the smallest
	    	  }else {
	    		  root = root.right; //goes right if root is not less than current root value
	    	  }
	      }
	      return root.value; //returns the smallest node value
	   }
	  
	  
	  
	   /*
	   a method to find the node in the tree
	   with a largest key
	   */
	   public int getMax(Node root){
         //implement in here
	   }
	   
	   
	   
	   /*
	   this method will not compile until getMax
	   is implemented
	   */
	   public Node delete(Node root, int key){
	      
	      if(root == null){
	         return root;
	      }else if(key < root.value){
	         root.left = delete(root.left, key);
	      }else if(key > root.value){
	         root.right = delete(root.right, key);
	      }else{
	         //node has been found
	         if(root.left==null && root.right==null){
	            //case #1: leaf node
	            root = null;
	         }else if(root.right == null){
	            //case #2 : only left child
	            root = root.left;
	         }else if(root.left == null){
	            //case #2 : only right child
	            root = root.right;
	         }else{
	            //case #3 : 2 children
	            root.value = getMax(root.left);
	            root.left = delete(root.left, root.value);
	         }
	      }
	      return root;  
	   }
	   
	   
	   
	}



	public class TreeDemov1{
	   public static void main(String[] args){
	      BinarySearchTree t1  = new BinarySearchTree();
	      t1.insert( 24);
	      t1.insert(80);
	      t1.insert(18);
	      t1.insert(9);
	      t1.insert(90);
	      t1.insert(22);
	            
	      System.out.print("in-order :   ");
	      t1.inOrderTraversal(t1.root);
	      System.out.println();
	           
	      
	   }  
	}
