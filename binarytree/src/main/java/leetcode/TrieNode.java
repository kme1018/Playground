package leetcode;

import java.util.HashMap;

//public class TrieNode {
//		public HashMap<Character, TrieNode> children;
//		public boolean isWord;
//
//		public TrieNode(String word){
//			this(word.toCharArray(), 0);
//		}
//		public TrieNode(char[] word, int index) {
//			children = new HashMap<Character, TrieNode>();
//			isWord = false;
//			if (word.length == index+1) {
//				isWord = true;
//				return;
//			}
//			children.put(word[index], new TrieNode(word, index + 1));
//		}
//		
//		public void add( String word){
//			 
//			this.addHelper(word.toCharArray(),0 );
//		}
//		public void addHelper( char[] word, int index) {
//			if(word.length == 0){
//				isWord= true;
//				return;
//			}
//			TrieNode node = children.get(word[index]);
//			
//			if (node == null) {
//				//this will add all nodes, done when it is complete
//				children.put(word[index], new TrieNode(word, index+1));
//				
//			} else{
//				//recurisve add to the node that I have retrieved
//				node.addHelper( word, index+1);
//			}
//		}
//		
//		public int findPartial(String word){
//			return findPartialHelper(word.toCharArray(), 0, 0);
//		
//		}
//		
//		public int countWildCards(char[] word, int counts){
//				//go through the list of letters and see how many have is word == true
//				//should I do breadth first of depth first?
//				for(TrieNode node : children.values()){
//					counts = node.isWord ? counts+1:counts;
//					node.countWildCards(word, counts );
//				}
//				return counts;
//		}
//		public int findPartialHelper(char[] word, int index, int counts){
//			if(word.length-1 == index){
//				return isWord ? 1 + countWildCards(word, counts) : countWildCards(word, counts) ;
//			}
//			
//			
//			if(children.containsKey(word[index])){
//				TrieNode node = children.get(word[index]);
//				node.findPartialHelper(word, index+1, counts);
//			}
//			else{
//				return 0;
//			}
//			
//		}
//
//	}