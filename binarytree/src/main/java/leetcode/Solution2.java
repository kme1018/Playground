package leetcode;

import java.util.HashMap;
import java.util.Scanner;

public class Solution2 {

	public static void main(String[] args) {
		// Scanner scan = new Scanner(System.in);
		// int n = scan.nextInt();
		Trie trie = new Trie();
		boolean isGood = true;
		if(!trie.add("a")){
			System.out.println("BAD SET");
			System.out.println("aab");
			return;
		}

		if (!trie.add("a")) {
			System.out.println("BAD SET");
			System.out.println("aac");
			return;
		}

//		if (!trie.add("aacghgh")) {
//			System.out.println("BAD SET");
//			System.out.println("aacghgh");
//			return;
//		}
//
//		if (!trie.add("aabghgh")) {
//			System.out.println("BAD SET");
//			System.out.println("aabghgh");
//			return;
//		}
		System.out.println("GOOD SET");

		// for (int i = 0; i < n; i++) {
		// String operation = scan.next();
		// String contact = scan.next();
		// if (operation.equals("add")) {
		// trie.add(contact);
		// } else if (operation.equals("find")) {
		// System.out.println(trie.find(contact));
		// }
		// }
		// scan.close();
	}
}

class TrieNodetemp {
	public HashMap<Character, TrieNodetemp> children = new HashMap<Character, TrieNodetemp>();
	public boolean isWord = false;

	public void putChildIfAbsent(char ch) {
		children.putIfAbsent(ch, new TrieNodetemp());
	}

	public TrieNodetemp getChild(char ch) {
		return children.get(ch);
	}
}

class Trie {
	TrieNodetemp root = new TrieNodetemp();

	Trie() {
	}

	public boolean add(String str) {
		TrieNodetemp curr = root;
		
		for (int i = 0; i < str.length(); i++) {
			Character ch = str.charAt(i);
			curr.putChildIfAbsent(ch);
			
			curr = curr.getChild(ch);
			if(curr.isWord){
				return false;
			}
		}
		curr.isWord = true;
		if(curr.children.size()>0){
			return false;
		}
		return true;
	}
}
