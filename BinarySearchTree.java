
public class BinarySearchTree {

	public static void main(String[] args) {
		Tree t = new Tree();
		TreeNode root = new TreeNode(100);
		t.insertTreeNode(root, 50);
		t.insertTreeNode(root, 200);
		t.insertTreeNode(root, 150);
		t.insertTreeNode(root, 300);
		t.insertTreeNode(root, 25);
		t.insertTreeNode(root, 75);
		t.insertTreeNode(root, 12);
		t.insertTreeNode(root, 37);
		t.insertTreeNode(root, 125);
		t.insertTreeNode(root, 175);
		t.insertTreeNode(root, 250);
		t.insertTreeNode(root, 320);
		t.insertTreeNode(root, 67);
		t.insertTreeNode(root, 87);
		t.insertTreeNode(root, 94);
		t.insertTreeNode(root, 89);
		t.insertTreeNode(root, 92);
		t.insertTreeNode(root, 88);
		
		System.out.println("Tree before deleting 100:");
		t.inorderPrint(root);
		t.deleteNode(root, 100);
		System.out.println("\nTree after deleting 100:");
		t.inorderPrint(root);
	}

}

class TreeNode{
	int val;
	TreeNode left = null, right = null;
	
	TreeNode(int val){
		this.val = val;
	}
}

class Tree{
	
	void insertTreeNode(TreeNode root, int val) {
		TreeNode temp = root;
		if(val < temp.val) {
			if(temp.left == null) {
				temp.left = new TreeNode(val);
				return;
			}
			insertTreeNode(temp.left, val);
		} else {
			if(temp.right == null) {
				temp.right = new TreeNode(val);
				return;
			}
			insertTreeNode(temp.right, val);
		}
		
	}
	
	void inorderPrint(TreeNode root) {
		if(root == null)
			return;
		inorderPrint(root.left);
		System.out.print(root.val + " ");
		inorderPrint(root.right);
	}
	
	void deleteNode(TreeNode root, int val) {
		
		TreeNode parent = null, temp = root;
		
		while(temp != null && temp.val != val) {
			parent = temp;
			if(val < temp.val)
				temp = temp.left;
			else
				temp = temp.right;
		}
		if(temp == null) {
			return;
		}
		if(temp.left != null && temp.right != null) {
			int value = getPredecessor(temp.left);
			deleteNode(root, value);
			temp.val = value;
		}
		else if(temp.left == null && temp.right == null) {
			if(temp == root) {
				root = null;
			}
			else {
				if(parent.left == temp)
					parent.left = null;
				else
					parent.right = null;
			}
		}
		else {
			TreeNode child = (temp.left == null) ? temp.right : temp.left;
			if(temp == root) {
				root = child;
			}else {
				if(parent.left == temp)
					parent.left = child;
				else
					parent.right = child;
			}
		}
	}
	
	int getPredecessor(TreeNode node) {
		while(node.right != null) {
			node = node.right;
		}
		return node.val;
	}
}

