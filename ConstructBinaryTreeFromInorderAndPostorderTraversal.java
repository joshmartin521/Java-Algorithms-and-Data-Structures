class Solution {
    int p,i;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        i = inorder.length-1;
        p = i;
        return build(inorder, postorder, Integer.MAX_VALUE);
    }

    public TreeNode build(int[] in, int[] post, int stop) {
        if (i >= 0 && in[i] != stop) {
            TreeNode node = new TreeNode(post[p--]);
            node.right = build(in, post, node.val);
            i--;
            node.left = build(in, post, stop);
            return node;
        }
        return null;
    }
}
