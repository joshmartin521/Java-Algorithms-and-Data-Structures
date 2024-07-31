class Solution {
    // Two private variables to keep track of the current index in preorder and inorder arrays
    private int i = 0; // index for inorder array
    private int p = 0; // index for preorder array

    // Public method to build a binary tree given preorder and inorder traversal arrays
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder, inorder, Integer.MIN_VALUE); // Start building with a sentinel stop value
    }

    // Private helper method to recursively build the tree
    private TreeNode build(int[] preorder, int[] inorder, int stop) {
        // Base case: if the current index in preorder array is out of bounds, return null
        if (p >= preorder.length) {
            return null;
        }
        // If the current inorder value equals the stop value, it means we've reached the end of a subtree
        if (inorder[i] == stop) {
            ++i; // Move to the next index in inorder array
            return null; // Return null to indicate no further nodes in this subtree
        }

        // Create a new TreeNode with the current value from preorder array
        TreeNode node = new TreeNode(preorder[p++]);
        
        // Recursively build the left subtree, with the stop value set to the current node's value
        node.left = build(preorder, inorder, node.val);
        
        // Recursively build the right subtree, keeping the original stop value
        node.right = build(preorder, inorder, stop);
        
        return node; // Return the constructed node
    }
}
