import java.util.*;

public class LC_0297_SerializeandDeserializeBinaryTree_my2 {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {

        StringBuilder sb = new StringBuilder();

        LinkedList<TreeNode> cur = new LinkedList<>();
        LinkedList<TreeNode> next = new LinkedList<>();

        if (root == null) {
            return sb.toString();
        }

        cur.offer(root);

        while (cur.size() > 0) {

            while (cur.size() > 0) {

                TreeNode node = cur.pollFirst();
                if (node != null) {
                    sb.append(node.val);
                    sb.append(",");
                    next.offer(node.left);
                    next.offer(node.right);
                } else {
                    sb.append("null");
                    sb.append(",");
                }
            }

            cur = next;
            next = new LinkedList<>();
        }

        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {

        if (data == null || data.length() == 0)
            return null;

        String[] arr = data.split(",");

        TreeNode root = new TreeNode(Integer.valueOf(arr[0]));

        LinkedList<TreeNode> cur = new LinkedList<>();
        LinkedList<TreeNode> next = new LinkedList<>();

        cur.offer(root);
        int index = 1;

        while (cur.size() > 0) {

            while (cur.size() > 0) {

                TreeNode node = cur.pollFirst();
                if (arr[index].equals("null")) {
                    node.left = null;
                } else {
                    node.left = new TreeNode(Integer.valueOf(arr[index]));
                    next.offer(node.left);
                }

                index++;

                if (arr[index].equals("null")) {
                    node.right = null;
                } else {
                    node.right = new TreeNode(Integer.valueOf(arr[index]));
                    next.offer(node.right);
                }

                index++;
            }

            cur = next;
            next = new LinkedList<>();
        }

        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));