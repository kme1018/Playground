package leetcode;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

public class Solution {

	public int lengthOfLongestSubstring(String s) {

		Set<Character> set = new HashSet<Character>();

		int i = 0, j = 0, max = 0;
		while (j < s.length()) {

			if (!set.contains(s.charAt(j))) {
				// add the value to the set
				set.add(s.charAt(j++));
				// reset max to either the size of the set or the current max,
				// whichever is greater
				max = Math.max(max, set.size());
			} else {
				// remove the letter from the set;
				set.remove(s.charAt(i++));
			}
		}
		return max;
	}

	public int removeElement(int[] nums, int val) {
		int n = nums.length;
		int i = 0;
		while (i < n) {
			if (nums[i] == val) {
				// swap the last spot with the current location in array. This
				// will get rid of the value that needs removal
				nums[i] = nums[n - 1];
				n--;
			} else {
				// increase index only if the value is not to be removed.
				i++;
			}
		}
		// this should be the new length of the array, anything after does not
		// matter;
		return n;
	}

	public boolean isPalindrome(int x) {
		int num1 = x;
		int num2 = 0;

		while (x > 0) {
			// create a second number by reversing the original;
			num2 = num2 * 10 + x % 10;
			x /= 10;
		}
		// if the numbers are equal, this will return true
		return num1 == num2;
	}

	public boolean isPalindromeAgain(int x) {
		if (x < 0)
			return false;
		String a = x + "";
		int i = 0;
		int j = a.length() - 1;
		while (i < j) {
			if (a.charAt(i) != a.charAt(j))
				return false;
			i++;
			j--;
		}
		return true;
	}

	public boolean isPalindrome(ListNode head) {

		Stack<ListNode> stack = new Stack<ListNode>();
		ListNode tempNode = head;
		while (tempNode != null) {
			stack.add(tempNode);
			tempNode = tempNode.next;
		}
		while (head != null) {
			if (head.val != stack.pop().val) {
				return false;
			}
			head = head.next;
		}

		return true;
	}

	public boolean judgeSquareSum(int c) {

		int i = 0;
		int j = (int) Math.sqrt(c);
		while (i <= j) {
			int squareSum = i * i + j * j;
			if (squareSum > c) {
				j--;
			} else if (squareSum < c) {
				i++;
			} else {
				return true;
			}
		}
		return false;
	}

	public boolean isPerfectSquare(int num) {
		if (num == 1) {
			return true;
		}
		int max = (int) Math.ceil(num / 2);

		for (int i = 0; i <= max; i++) {
			if (i * i == num) {
				return true;
			}
		}
		return false;
	}

	public boolean isPerfectSquareBetter(int num) {
		if (num == 0 || num == 1)
			return true;

		int p = 0;
		int q = Math.min(num / 2, 92680);
		while (p <= q) {
			int mid = (p + q) >>> 1;
			int sqrt = mid * mid;
			if (sqrt == num)
				return true;
			else if (sqrt < num)
				p = mid + 1;
			else
				q = mid - 1;
		}
		return false;
	}

	public boolean isPerfectSquareNewton(int num) {
		// is the square root equal to the rounded up square root?
		return Math.sqrt(num) == Math.ceil(Math.sqrt(num));

	}

	public ListNode removeNthFromEnd(ListNode head, int n) {

		ListNode left = new ListNode(0);
		ListNode right = new ListNode(0);
		left.next = head;
		right.next = head;
		ListNode holdOnToLeft = left;

		for (int i = 0; i < n; i++) {
			right = right.next;
		}
		while (right.next != null) {
			left = left.next;
			right = right.next;
		}
		left.next = left.next.next;

		return holdOnToLeft.next;
	}

	public void printList(ListNode head) {
		if (head == null) {
			System.out.print("The list is empty");
		}
		while (head != null) {
			System.out.print(head.val + " -> ");
			head = head.next;
		}
	}

	public void add(ListNode head, int val) {
		while (head.next != null) {
			head = head.next;

		}
		head.next = new ListNode(val);
	}

	public ListNode detectCycle(ListNode head) {
		ListNode slow, fast;
		if(head == null){
			return head;
		}
		slow = fast = head;
		while(true){
			slow = slow.next; //move foward 1 time;
			if(fast.next != null){
				fast = fast.next.next;
			}
			else{
				return null;
			}
			if(slow== null || fast == null) return null;
			if(slow == fast) {
				slow = head;
				while(slow!= fast){
					slow = slow.next;
					fast = fast.next;
				}
				return slow;
			}
		}
		
		
	}
	
	 public  String isBalanced(String s) {
	        Stack<Character> stack = new Stack<Character>();
	      
	        for(char symbol : s.toCharArray()){
	        	switch (symbol){
	        		case '(':
	        			stack.push(symbol);
	        			break;
	        		case '[':
	        			stack.push(symbol);
	        			break;
	        		case '{':
	        			stack.push(symbol);
	        			break;
	        		case ')':
	        			if(stack.isEmpty() || stack.pop()!='('){
	        				return "NO";
	        			}
	        			break;
	        			
	        		case ']':
	        			if(stack.isEmpty() || stack.pop()!='['){
	        				return "NO";
	        			};
	        			break;
	        		case '}':
	        			if(stack.isEmpty() || stack.pop()!='{'){
	        				return "NO";
	        			};
	        			break;
	        	}
	        }
	        return stack.isEmpty() ? "YES" : "NO";
	    }
	
	 public static class MyQueue<T> {
	        Stack<T> stackNewestOnTop = new Stack<T>();
	        Stack<T> stackOldestOnTop = new Stack<T>();

	        public void enqueue(T value) { // Push onto newest stack
	            stackNewestOnTop.push(value);
	        }

	        public T peek() {
	        	if(stackOldestOnTop.isEmpty()){
	        		while (!stackNewestOnTop.isEmpty()){
	        			stackOldestOnTop.push(stackNewestOnTop.pop());
	        		}
	        	}
	             return stackOldestOnTop.peek();
	        }

	        public T dequeue() {
	        	if(stackOldestOnTop.isEmpty()){
	        		while (!stackNewestOnTop.isEmpty()){
	        			stackOldestOnTop.push(stackNewestOnTop.pop());
	        		}
	        	}
	            return stackOldestOnTop.pop();
	        }
	    }
	 
	 public class Heap{
		 private Queue<Integer> low = new PriorityQueue<Integer>(10, Collections.reverseOrder());
		 private Queue<Integer> high = new PriorityQueue<Integer>();
	 }
	 
}
