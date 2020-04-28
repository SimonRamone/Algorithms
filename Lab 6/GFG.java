// Java program to flatten the binary tree 
// using previous node approach 
class GFG 
{ 
	
// Structure to represent a node of the tree 
static class Node 
{ 
	int data; 
	Node left; 
	Node right; 
}; 

static Node AllocNode(int data) 
{ 
	Node temp = new Node(); 
	temp.left = null; 
	temp.right = null; 
	temp.data = data; 
	return temp; 
} 

// Utility function to print the inorder 
// traversal of the tree 
static void PrintInorderBinaryTree(Node root) 
{ 
	if (root == null) 
		return; 
	PrintInorderBinaryTree(root.left); 
	System.out.print( root.data + " "); 
	PrintInorderBinaryTree(root.right); 
} 

static Node last =null; 

// Function to make current node right of 
// the last node in the list 
static void FlattenBinaryTree(Node root) 
{ 
	if (root == null) 
		return; 

	Node left = root.left; 
	Node right = root.right; 

	// Avoid first iteration where root is 
	// the only node in the list 
	if (root != last) { 
		(last).right = root; 
		(last).left = null; 
		last = root; 
	} 

	FlattenBinaryTree(left); 
	FlattenBinaryTree(right); 
	if (left == null && right == null) 
		last = root; 
} 

static void PrintTree(Node root) 
{	System.out.print( root.data + " ");

	if(root.right != null) {
				 PrintTree(root.right);
}
		
} 
// Driver Code 
public static void main(String args[]) 
{ 

	// Build the tree 
	Node root = AllocNode(1); 
	root.left = AllocNode(2); 
	root.left.left = AllocNode(3); 
	root.left.right = AllocNode(4); 
	root.right = AllocNode(5); 
	root.right.right = AllocNode(6); 

	// Print the inorder traversal of the 
	// original tree 
	System.out.print("Original inorder traversal : "); 
	PrintInorderBinaryTree(root); 
	System.out.println(); 

	// Flatten a binary tree, at the beginning 
	// root node is the only and last in the list 
	last = root; 
	flatten(root); 

	// Print the inorder traversal of the flattened 
	// binary tree 
	System.out.print("Flattened inorder traversal : "); 
	PrintTree(root); 
	System.out.println(); 
	
} 
	static void flatten(Node root) 
	{ 	
		if(root.right != null && root.left != null){
			Node temp = root.right;
			
			flatten(root.left);
			
			
			flatten(root.right);
			 
			root.right= root.left;
			root.left = null;
			while(root.right != null) root = root.right;
			root.right = temp;
		}
		else return;
	} 

	
} 

// This code is contributed by Arnab Kundu 

