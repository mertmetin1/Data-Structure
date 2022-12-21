package amkpackage;

public class BinaryTree {
	node root;

	public BinaryTree(node root) {
		this.root = null;
		this.root = root;
	}

	public boolean isEmpty() {
		if (root == null) {
			return true;
		} else {
			return false;
		}
	}

	public void insert(node ekleneceknode) {
		root = inserthelper(root, ekleneceknode);
	}

	public void Myinsert(node root, node eklenceknode) {
		if (root == null) {
			root = eklenceknode;
		}
		if (root.data < eklenceknode.data) {
			Myinsert(root.right, eklenceknode);
		}
		if (root.data > eklenceknode.data) {
			Myinsert(root.left, eklenceknode);
		}
	}

	private node inserthelper(node root, node ekleneceknode) {
		int data = ekleneceknode.data;
		if (root == null) {
			root = ekleneceknode;
			return ekleneceknode;
		} else if (data < root.data) {
			root.left = inserthelper(root.left, ekleneceknode);
		} else if (data > root.data) {
			root.right = inserthelper(root.right, ekleneceknode);
		}
		return root;
	}

	public void InOrder() {
		InOrderHelper(root);
	}

	private void InOrderHelper(node node) {
		if (node != null) {
			InOrderHelper(node.left);
			System.out.println(node.data);
			InOrderHelper(node.right);
		}
	}

	public void PreOrder() {
		PreOrderHelper(root);
	}

	private void PreOrderHelper(node node) {
		if (node != null) {
			System.out.println(node.data);
			PreOrderHelper(node.left);
			PreOrderHelper(node.right);
		}
	}

	public void PostOrder() {
		PostOrderHelper(root);
	}

	private void PostOrderHelper(node node) {
		if (node != null) {
			PostOrderHelper(node.left);
			PostOrderHelper(node.right);
			System.out.println(node.data);
		}
	}

	public boolean search(int aranandata1) {
		return searchHelper(root, aranandata1);
	}

	private boolean searchHelper(node node, int aranandata) {
		if (node == null) {
			return false;
		} else if (node.data == aranandata) {
			return true;
		} else if (node.data < aranandata) {
			return searchHelper(node.right, aranandata);
		} else {
			return searchHelper(node.left, aranandata);
		}
	}

	public void remove(int silinecek) {
		if (search(silinecek)) {
			removeHelper(root, silinecek);
		} else {
			System.out.println(silinecek + " doesnt exist");
		}
	}

	private node removeHelper(node node, int silinecek) {
		if (node == null) {
			return node;
		} else if (silinecek < node.data) {
			root.left = removeHelper(node.left, silinecek);
		} else if (silinecek > node.data) {
			root.right = removeHelper(node.right, silinecek);
		} else {// node found
			if (node.left == null && node.right == null) {
				node = null;
			} else if (node.right != null) {// find a successor to replace this node
				node.data = successor(node);
				node.right = removeHelper(node.right, node.data);
			} else {// find the predecessor to replace this node
				node.data = predecessor(node);
				node.left = removeHelper(node.left, node.data);
			}
		}
		return node;
	}

	private int predecessor(node node) {
		node = node.left;
		while (node.right != null) {
			node = node.right;
		}
		return node.data;
	}

	private int successor(node node) {
		node = node.right;
		while (node.left != null) {
			node = node.left;
		}
		return node.data;
	}

}
