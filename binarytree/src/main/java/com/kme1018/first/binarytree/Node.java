package com.kme1018.first.binarytree;

import java.util.Stack;

public class Node {

	private int value;
	private Node left;
	private Node right;

	public Node(int value) {
		this.value = value;
	}

	/**
	 * Returns -1 if it is not going to add up to target. Returns 0 if it does
	 * add to target.
	 */
	public int addsToValue(Node node, int target) {
		if (target == 0) {
			return target;
		}
		if (addsToValue(node.left, target - node.value) == 0) {
			return 0;
		} else if (addsToValue(node.right, target - node.value) == 0) {
			return 0;
		} else {
			return -1;
		}

	}

	public void insert(int newValue) {
		if (newValue < this.value)
			if (this.left == null)
				this.left = new Node(newValue);
			else
				this.left.insert(newValue);
		else if (this.right == null)
			this.right = new Node(newValue);
		else
			this.right.insert(newValue);
	}

	public void printLeafNode(Node node) {
		if (node == null) {
			return;
		}
		// if(node.leftNode==null && node.rightNode == null){
		//
		// }
		System.out.printf("%d ", node.value);
		printLeafNode(node.left);
		printLeafNode(node.right);

	}

	public static void PrintLeafNodesIteratively(Node root) {
		if (root == null) {
			return;
		}
		Stack<Node> stack = new Stack<Node>();
		stack.push(root);
		while (!stack.isEmpty()) {
			Node node = stack.pop();
			if (node.right != null) {
				stack.add(node.right);
			}
			if (node.left != null) {
				stack.add(node.left);
			}
			if (node.left == null && node.right == null) {
				System.out.printf("%d ", node.value);
			}
		}
	}

}
