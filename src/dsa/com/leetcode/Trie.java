package dsa.com.leetcode;

import java.util.HashMap;
import java.util.Map;

class TrieNode {
	boolean isCompleteWord;
	Map<Character, TrieNode> children = new HashMap<>();
}

public class Trie {

	TrieNode root;

	public Trie() {
		root = new TrieNode();
	}

	public void insert(String word) {
		TrieNode curNode = root;
		for (int i = 0; i < word.length(); i++) {
			if (curNode.children.containsKey(word.charAt(i)) == false) {
				curNode.children.put(word.charAt(i), new TrieNode());
			}
			curNode = curNode.children.get(word.charAt(i));
		}

		curNode.isCompleteWord = true;

	}

	public boolean search(String word) {
		TrieNode curNode = root;
		for (int i = 0; i < word.length(); i++) {
			if (curNode.children.containsKey(word.charAt(i)) == false) {
				return false;
			}
			curNode = curNode.children.get(word.charAt(i));
		}

		return curNode.isCompleteWord;
	}

	public boolean startsWith(String prefix) {
		TrieNode curNode = root;
		for (int i = 0; i < prefix.length(); i++) {
			if (curNode.children.containsKey(prefix.charAt(i)) == false) {
				return false;
			}
			curNode = curNode.children.get(prefix.charAt(i));
		}
		return true;
	}

	public static void main(String[] args) {
		Trie trie = new Trie();

		trie.insert("ab");
		trie.search("abc"); // false
		trie.search("ab"); // true
		// trie.startsWith("abc"); // false
		// trie.startsWith("ab"); // true
		trie.insert("ab"); // null
		trie.search("abc"); // false
		// trie.startsWith("abc"); // false
		trie.insert("abc"); // null
		trie.search("abc"); // true
		System.out.println(trie.startsWith("abc")); // true

		/**
		 * 
		 * [,"insert","search","startsWith","insert","search","startsWith"]
		 * [["ab"],["abc"],["abc"],["abc"],["abc"],["abc"]]
		 * 
		 */

//		trie.insert("flower");
//		trie.insert("flow");
//		trie.insert("floght");
//		
//		System.out.println("Trie has flower " + trie.search("flower"));
//		System.out.println("Trie has bac " + trie.search("bac"));
//		System.out.println("Trie has flight " + trie.search("flight"));
//
//		System.out.println("The longest prefix is " + trie.startsWith("flo"));
	}
}

/**
 * Your Trie object will be instantiated and called as such: Trie obj = new
 * Trie(); obj.insert(word); boolean param_2 = obj.search(word); boolean param_3
 * = obj.startsWith(prefix);
 */