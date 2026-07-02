class Solution {

    static class Node {
        Node[] child = new Node[26];
        boolean eow = false;
        int count = 0;
    }

    static Node root = new Node();

    // Insert a word into Trie
    public static void insert(String str) {
        Node curr = root;

        for (int i = 0; i < str.length(); i++) {
            int idx = str.charAt(i) - 'a';

            if (curr.child[idx] == null) {
                curr.child[idx] = new Node();
            }

            curr = curr.child[idx];
            curr.count++;
        }

        curr.eow = true;
    }

    // Count children of current node
    public static int childCount(Node node) {
        int count = 0;

        for (int i = 0; i < 26; i++) {
            if (node.child[i] != null) {
                count++;
            }
        }

        return count;
    }

    // Find longest common prefix
    public static String longestPrefix(int n) {

        Node curr = root;
        StringBuilder sb = new StringBuilder();

        while (childCount(curr) == 1 && !curr.eow) {

            for (int i = 0; i < 26; i++) {

                if (curr.child[i] != null && curr.child[i].count == n) {

                    sb.append((char) ('a' + i));
                    curr = curr.child[i];
                    break;
                }
            }
        }

        return sb.toString();
    }

    public String longestCommonPrefix(String[] strs) {

        if (strs.length == 0)
            return "";

        // Reset root for each test case
        root = new Node();

        for (String word : strs) {
            insert(word);
        }

        return longestPrefix(strs.length);
    }
}
