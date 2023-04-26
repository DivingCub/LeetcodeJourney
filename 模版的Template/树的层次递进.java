public void levelOrderTraverse(TreeNode root) {
        if (root == null) {
            return;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            System.out.print(node.val + "->");

            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
    }