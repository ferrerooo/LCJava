import Google.*;
import Apple.*;

import static org.junit.Assert.assertTrue;

import java.util.*;

public class Program {
    
    public static void main(String[] args) {
        
        LC0428 lc = new LC0428();

        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        Node n6 = new Node(6);
        Node n7 = new Node(7);
        Node n8 = new Node(8);
        Node n9 = new Node(9);
        Node n10 = new Node(10);
        Node n11 = new Node(11);
        Node n12 = new Node(12);
        Node n13 = new Node(13);
        Node n14 = new Node(14);

        List<Node> c11 = new LinkedList<>();
        c11.add(n14);
        n11.children = c11;

        List<Node> c7 = new LinkedList<>();
        c7.add(n11);
        n7.children = c7;

        List<Node> c3 = new LinkedList<>();
        c3.add(n6);
        c3.add(n7);
        n3.children = c3;

        List<Node> c8 = new LinkedList<>();
        c8.add(n12);
        n8.children = c8;

        List<Node> c4 = new LinkedList<>();
        c4.add(n8);
        n4.children = c4;

        List<Node> c1 = new LinkedList<>();
        c1.add(n2);
        c1.add(n3);
        c1.add(n4);
        c1.add(n5);
        n1.children = c1;

        List<Node> c9 = new LinkedList<>();
        c9.add(n13);
        n9.children = c9;

        List<Node> c5 = new LinkedList<>();
        c5.add(n9);
        c5.add(n10);
        n5.children = c5;

        String s = lc.serialize(n1);
        System.out.println("1st call serialization " + s);
        
        Node newNode = lc.deserialize(s);
        String s2 = lc.serialize(newNode);
        System.out.println("2nd call serialization " + s2);

        if (s.equals(s2))
            System.out.println("Equal!");

    }

}
