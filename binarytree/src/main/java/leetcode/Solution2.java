package leetcode;

import java.util.HashMap;
import java.util.Scanner;

public class Solution2 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		Trie trie = new Trie();
		for (int i = 0; i < n; i++) {
			String operation = scan.next();
			String contact = scan.next();
			if (operation.equals("add")) {
				trie.add(contact);
			} else if (operation.equals("find")) {
				System.out.println(trie.find(contact));
			}
		}
		scan.close();
	}
}

/* Based loosely on tutorial video in this problem */
class TrieNodetemp {
	private HashMap<Character, TrieNodetemp> children = new HashMap<Character, TrieNodetemp>();
	public int size;

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
	} // default constructor

	Trie(String[] words) {
		for (String word : words) {
			add(word);
		}
	}

	public void add(String str) {
		TrieNodetemp curr = root;
		for (int i = 0; i < str.length(); i++) {
			Character ch = str.charAt(i);
			curr.putChildIfAbsent(ch);
			curr = curr.getChild(ch);
			curr.size++;
		}
	}

	public int find(String prefix) {
		TrieNodetemp curr = root;

		/* Traverse down tree to end of our prefix */
		for (int i = 0; i < prefix.length(); i++) {
			Character ch = prefix.charAt(i);
			curr = curr.getChild(ch);
			if (curr == null) {
				return 0;
			}
		}
		return curr.size;
	}
}
