package datastructure;

import java.util.ArrayList;

public class Tree {

	public static void main(String[] args) {
		int[] arr = { 0, 1, 2, 3, 4, 5, 6 };
		TreeNode<Integer> root = buildTree(arr);
		preorder(root);
		System.out.println("\n");
		inorder(root);
		System.out.println("\n");
		postorder(root);
	}

	public static TreeNode<Integer> buildTree(int[] arr) {
		if(arr==null || arr.length==0) return null;
		ArrayList<TreeNode<Integer>> list = new ArrayList<TreeNode<Integer>>();
		for (int i = 0; i < arr.length; i++) {
			list.add(new TreeNode<Integer>(arr[i]));
		}
		for (int i = 0; i < list.size(); i++) {
			int left = 2 * i + 1;
			int right = 2 * i + 2;
			if (left < list.size())
				list.get(i).left = list.get(left);
			if (right < list.size())
				list.get(i).right = list.get(right);
		}
		return list.get(0);

	}

	public static void preorder(TreeNode root) {
		if (root == null)
			return;
		System.out.print(root.element + " ");
		preorder(root.left);
		preorder(root.right);
	}

	public static void inorder(TreeNode node) {
		if (node == null)
			return;
		inorder(node.left);
		System.out.print(node.element + " ");
		inorder(node.right);
	}

	public static void postorder(TreeNode node) {
		if (node == null)
			return;
		postorder(node.left);
		postorder(node.right);
		System.out.print(node.element + " ");
	}
}

class TreeNode<E> {
	E element;
	TreeNode<E> left;
	TreeNode<E> right;

	public TreeNode(E e) {
		this.element = e;
	}
}
