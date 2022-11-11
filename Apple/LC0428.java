package Apple;

import java.util.*;

public class LC0428 {
    
    public String serialize(Node root) {
        
        if (root == null)
            return "";
        
        StringBuilder sb = new StringBuilder();
        
        sb.append(String.valueOf(root.val));
        
        if (root.children == null || root.children.size() == 0)
            return sb.toString();
        
        sb.append(" ( ");
        for (Node n : root.children) {
            sb.append(serialize(n));
            sb.append(" ");
        }
        
        sb.append(")");
        return sb.toString();
    }
	
    // Decodes your encoded data to tree.
    public Node deserialize(String data) {
        
        List<String> strList = this.getList(data);
        LinkedList<Node> nodeList = new LinkedList<>();
        
        for (String s : strList) {
            
            if ( !s.equals("(") && !s.equals(")")) {
                Node node = new Node(Integer.parseInt(s));
                nodeList.offerLast(node);
                continue;
            }
            
            if (s.equals("(")) {
                nodeList.add(null);
                continue;
            }
            
            if (s.equals(")")) {
                LinkedList<Node> childList = new LinkedList<>();
                
                while (nodeList.get(nodeList.size() -1 ) != null) {
                    childList.offerFirst(nodeList.pollLast());
                }
                
                nodeList.pollLast();
                nodeList.peekLast().children = childList;
                continue;
            }
        }
        
        Node n = nodeList.get(0);
        System.out.println("Serialize it again : " + this.serialize(n));
        
        return nodeList.get(0);
    }
    
    public List<String> getList(String data) {
        String[] arr = data.split(" ");
        return Arrays.asList(arr);  
    }

}