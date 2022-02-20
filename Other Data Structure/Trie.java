/**
* Problem #208
*/
class Trie {
  private TrieNode root;

  static class TrieNode {
    Map<Character, TrieNode> children;
    boolean isLeaf;

    TrieNode() {
      children = new HashMap<>();
    }
  }

  public Trie() {
    root = new TrieNode();
  }

  public void insert(String word) {
    if (search(word)) {
      return;
    }

    TrieNode curr = root;
    for (int i = 0; i < word.length(); i++) {
      TrieNode next = curr.children.get(word.charAt(i));

      if (next == null) {
        next = new TrieNode();
        curr.children.put(word.charAt(i), next);
      }
      curr = next;
    }
    curr.isLeaf = true;
  }

  public boolean search(String word) {
    TrieNode curr = root;
    for (int i = 0; i < word.length(); i++) {
      TrieNode next = curr.children.get(word.charAt(i));
      if (next == null) {
        return false;
      }
      curr = next;
    }
    return curr.isLeaf;
  }

  public boolean startsWith(String word) {
    TrieNode curr = root;
    for (int i = 0; i < word.length(); i++) {
      TrieNode next = curr.children.get(word.charAt(i));
      if (next == null) {
        return false;
      }
      curr = next;
    }
    return true;
  }
}