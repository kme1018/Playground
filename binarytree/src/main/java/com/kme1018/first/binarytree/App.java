package com.kme1018.first.binarytree;

import java.util.Scanner;

import leetcode.ListNode;
import leetcode.Solution;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
//    	Node head = new Node(10);
//    	head.insert(20);
//    	head.insert(15);
//    	head.insert(32);
//    	head.insert(2);
//    	head.insert(9);
//    	Node.PrintLeafNodesIteratively(head);
    	
    	Solution solution = new Solution();
//    	System.out.println(solution.lengthOfLongestSubstring("abcabcbbcbawxyz"));
//    	System.out.println(solution.removeElement(new int[]{3,2,2,3}, 3));
//    	System.out.println(solution.isPalindromeAgain(312213));
//    	System.out.println(solution.judgeSquareSum(5));
//    	System.out.println(solution.isPerfectSquareNewton(16));
    	//solution.printList(solution.removeNthFromEnd(new ListNode(1), 1));
    	Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int i = 0; i < t; i++){
            String temp = in.nextLine();
            String[] tempNums = temp.split(" ");
            
            int[] nums = new int[tempNums.length];
            int j =0;
            for(String num : tempNums){
            	nums[j++] = Integer.parseInt(num);
            }
            System.out.println(nums[0]);
            
        }
        in.close();
    }
}
