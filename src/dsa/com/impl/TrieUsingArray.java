package dsa.com.impl;

import java.util.ArrayList;
import java.util.HashMap;

class TrieNode {
	TrieNode[] children = new TrieNode[26];
	boolean isCompleteWord;
}

// worst solution using array, use map to optimize count calculation
public class TrieUsingArray {

	TrieNode root;

	public TrieUsingArray() {
		root = new TrieNode();
	}

	public void insert(String word) {
		TrieNode curNode = root;
		for (int i = 0; i < word.length(); i++) {
			if (curNode.children[word.charAt(i) - 'a'] == null) {
				curNode.children[word.charAt(i) - 'a'] = new TrieNode();
			}
			curNode = curNode.children[word.charAt(i) - 'a'];
		}
		curNode.isCompleteWord = true;
	}

	public boolean search(String word) {
		TrieNode curNode = root;
		for (int i = 0; i < word.length(); i++) {
			if (curNode.children[word.charAt(i) - 'a'] == null) {
				return false;
			}
			curNode = curNode.children[word.charAt(i) - 'a'];
		}

		return curNode.isCompleteWord;
	}

	class NodeCountAndIndexes {
		int count;
		ArrayList<Integer> indexes;

		public NodeCountAndIndexes(int count, ArrayList<Integer> indexes) {
			this.count = count;
			this.indexes = indexes;
		}
	}

	public NodeCountAndIndexes findNodeCountAndIndexes(TrieNode node) {
		int count = 0;
		ArrayList<Integer> indexes = new ArrayList<>();

		for (int i = 0; i < node.children.length; i++) {
			TrieNode child = node.children[i];
			if (child != null) {
				count++;
				indexes.add(i);
			}
		}

		return new NodeCountAndIndexes(count, indexes);
	}

	public String getLongestPrefix() {
		TrieNode curNode = root;
		String longestPrefix = "";

		while (findNodeCountAndIndexes(curNode).count == 1) {
			int index = findNodeCountAndIndexes(curNode).indexes.get(0);
			longestPrefix += (char) (index + 'a');
			curNode = curNode.children[index];
		}

		return longestPrefix;
	}

	public static void main(String[] args) {
		TrieUsingArray trie = new TrieUsingArray();
		trie.insert("flower");
		trie.insert("flow");
		trie.insert("floght");

		System.out.println("Trie has flower " + trie.search("flower"));
		System.out.println("Trie has bac " + trie.search("bac"));
		System.out.println("Trie has fligh " + trie.search("flight"));

		System.out.println("The longest prefix is " + trie.getLongestPrefix());
	}
}
