package com.kme1018.first.binarytree;

import java.util.ArrayList;

public class Node {

	private int value;
	private Node leftNode;
	private Node rightNode;
	
	public Node(int value){	
		this.value = value;
	}

	/**
	 * Returns -1 if it is not going to add up to target. Returns 0 if it does add to target.
	 */
	public int addsToValue(Node node, int target){
		if(target == 0){
			return target;
		} 
		if(addsToValue(node.leftNode, target-node.value) == 0){
			return 0;
		}else if(addsToValue(node.rightNode, target-node.value) == 0){
			return 0;
		}else{
			return -1;
		}
			
	}
	
	public void insert(int newValue) {
		Node leftNode = this.leftNode;
		Node rightNode = this.rightNode;
        if (newValue < value)
            if(leftNode == null)
            	leftNode=new Node(value);
            else
            	leftNode.insert(newValue);
        else
            if(rightNode == null)
            	rightNode=new Node(value);
            else
            	rightNode.insert(newValue);
      }

	
}
			
	
	

