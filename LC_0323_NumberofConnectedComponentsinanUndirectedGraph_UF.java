import java.util.*;

public class LC_0323_NumberofConnectedComponentsinanUndirectedGraph_UF {
    public int countComponents(int n, int[][] edges) {
        
        UnionFind uf = new UnionFind(n);

        for (int[] e:edges) {
            uf.union(e[0], e[1]);
        }
        
        Set<Integer> head = new HashSet<>();

        for (int i=0; i<n; i++) {
            head.add(uf.find(i));
        }

        return head.size();
    }

    private class UnionFind {

        private int[] parents;

        public UnionFind (int size) {
            parents = new int[size];
            for (int i=0; i<size; i++) {
                parents[i] = i;
            }
        }

        public int find(int a) {

            if (a == parents[a])
                return a;
            
            parents[a] = find(parents[a]);
            return parents[a];
        }

        public void union(int a, int b) {
            int roota = find(a);
            int rootb = find(b);

            if (roota != rootb) {
                parents[roota] = rootb;
            }
        }

    }
}