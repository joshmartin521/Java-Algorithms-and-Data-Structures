class Node{
    char val;
    Node[] children;
    boolean isEndOfWord;

    Node() {
        this.val = '@';
        this.children = new Node[26];
        this.isEndOfWord = false;
    }

    Node(char val) {
        this();
        this.val = val;
    }
}

class WordDictionary {
    private Node root;

    public WordDictionary() {
        root=new Node();
    }
    
    public void addWord(String word) {
        Node current = root;
        for(int i = 0; i<word.length(); i++)
        {
            char c = word.charAt(i);
            int index = c - 'a';
            if(current.children[index]==null)
            {
                current.children[index] = new Node(c);
            }

            current = current.children[index];
        }
        current.isEndOfWord = true;
    }
    

    public boolean search(String word) {
        return searchFor(word, root);
    }   

    public boolean searchFor(String word, Node current) {
        if (current == null) {
            return false;
        }

        if (word.length() == 0) {
            return current.isEndOfWord; // Check if it's the end of a valid word
        }

        char c = word.charAt(0);
        if (c == '.') {
            for (Node child : current.children) {
                if (searchFor(word.substring(1), child)) {
                    return true;
                }
            }
            return false;
        } else {
            int index = c - 'a';
            Node child = current.children[index];
            return searchFor(word.substring(1), child);
        }
    }
}
