package dsa.com.impl;

import java.util.HashMap;
import java.util.Map;

class TrieNodeMap {
	Map<Character, TrieNodeMap> children = new HashMap<>();
	boolean isCompleteWord;
}

class TrieMap {
	TrieNodeMap root = new TrieNodeMap();

	public void insert(String word) {
		TrieNodeMap curNode = root;
		for (int i = 0; i < word.length(); i++) {
			if (curNode.children.containsKey(word.charAt(i)) == false) {
				curNode.children.put(word.charAt(i), new TrieNodeMap());
			}
			curNode = curNode.children.get(word.charAt(i));
		}
		curNode.isCompleteWord = true;
	}

	public boolean search(String word) {
		TrieNodeMap curNode = root;
		for (int i = 0; i < word.length(); i++) {
			if (curNode.children.containsKey(word.charAt(i)) == false) {
				return false;
			}
			curNode = curNode.children.get(word.charAt(i));
		}

		return curNode.isCompleteWord;

	}

	public String getLongestPrefix() {
		String response = "";
		TrieNodeMap curNode = root;
		while (!curNode.isCompleteWord && curNode.children.size() == 1) {
			Map.Entry<Character, TrieNodeMap> onlyChild = curNode.children.entrySet().iterator().next();
			response += onlyChild.getKey();
			curNode = onlyChild.getValue();
		}
		return response;
	}

}

public class TrieUsingMap {
	public static void main(String[] args) {
		TrieMap trie = new TrieMap();
		trie.insert("flower");
		trie.insert("flow");
		trie.insert("floght");

		System.out.println("Trie has flower " + trie.search("flower"));
		System.out.println("Trie has bac " + trie.search("bac"));
		System.out.println("Trie has flight " + trie.search("flight"));

		System.out.println("The longest prefix is " + trie.getLongestPrefix());
	}
}
