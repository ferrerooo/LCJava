/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

import java.util.*;

public class LC_0297_SerializeandDeserializeBinaryTree {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        
        if (root == null)
            return "";

        StringBuilder sb = new StringBuilder();

        Queue<TreeNode> current = new LinkedList<>();
        Queue<TreeNode> next = new LinkedList<>();

        current.offer(root);

        while (current.size() > 0) {

            StringBuilder layer = new StringBuilder();
            boolean hasNonNullNode = false;

            while (current.size() > 0) {

                TreeNode n = current.poll();

                if (n == null) {
                    layer.append("null,");
                } else {
                    hasNonNullNode = true;
                    layer.append(n.val + ",");
                    next.offer(n.left);
                    next.offer(n.right);
                }
            }

            if (!hasNonNullNode)
                break;
            
            sb.append(layer);
            current = next;
            next = new LinkedList<>();
        }

        sb.subSequence(0, sb.length()-1);
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.equals(""))
            return null;

        String[] arr = data.split(",");

        int pointer = 0;

        TreeNode root = new TreeNode(Integer.parseInt(arr[pointer]));

        Queue<TreeNode> current = new LinkedList<>();
        Queue<TreeNode> next = new LinkedList<>();

        current.offer(root);
        pointer++;

        while (current.size() > 0) {

            while (current.size() > 0) {
                TreeNode n = current.poll();
                n.left = this.getNode(arr, pointer);
                pointer++;
                if (n.left != null)
                    next.offer(n.left);
                n.right = this.getNode(arr, pointer);
                pointer++;
                if (n.right != null)
                    next.offer(n.right);
            }

            current = next;
            next = new LinkedList<>();
        }

        return root;
    }

    private TreeNode getNode(String[] arr, int pointer) {
        
        if (pointer >= arr.length)
            return null;
        
        String val = arr[pointer];
        if (val.equals("null"))
            return null;
        else 
            return new TreeNode(Integer.parseInt(arr[pointer]));

    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));