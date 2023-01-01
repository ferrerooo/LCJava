public class LC_0547_NumberofProvince {
    public int findCircleNum(int[][] isConnected) {
        
        int n = isConnected.length;
        UnionFind uf = new UnionFind(n);

        for (int i=0; i<n; i++) {
            for (int j=i+1; j<n; j++) {
                if (isConnected[i][j] == 1)
                    uf.union(i, j);
            }
        }
        
        Set<Integer> set = new HashSet<>();

        for (int i=0; i<n; i++) {
            set.add(uf.find(i));
        }

        return set.size();
    }

    private class UnionFind {

        private int[] parent;
    
        public UnionFind (int size) {
            parent = new int[size];
            for (int i=0; i<size; i++) {
                parent[i] = i;
            }
        }
    
        public int find(int a) {
            if (a == parent[a])
                return a;
            
            parent[a] = this.find(parent[a]);
            return parent[a];
        }
    
        public void union(int a, int b) {
            int roota = this.find(a);
            int rootb = this.find(b);
            if (roota != rootb) {
                parent[roota] = rootb;
            }
        }
    
    }
}

