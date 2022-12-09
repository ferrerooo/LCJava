import java.util.*;

class LC_0743_NetworkDelayTime {
    public int networkDelayTime(int[][] times, int n, int k) {
                // Dijkstra
                int[][] adjMatrics = new int[n][n];

                for (int[] arr : adjMatrics) {
                    Arrays.fill(arr, 100*101);
                }
        
                for (int i=0; i<n; i++)
                    adjMatrics[i][i] = 0;
        
                for (int[] time : times) {
                    adjMatrics[time[0]-1][time[1]-1] = time[2];
                }
        
                Set<Integer> visited = new HashSet<>();
                int[] dis = new int[n];
                Arrays.fill(dis, 100*101);
                dis[k-1] = 0;
        
                while (visited.size() < n) {
        
                    // get shortest distance
                    int shortest = 100*101;
                    int index = -1;
                    for (int i=0; i<n; i++) {
                        if (!visited.contains(i) && dis[i] < shortest) {
                            shortest = dis[i];
                            index = i;
                        }                
                    }
        
                    if (shortest == 100*101)
                        return -1;
        
                    visited.add(index);
        
                    for (int i=0; i<n; i++) {
                        if (!visited.contains(i))
                            dis[i] = Math.min(dis[i], adjMatrics[index][i]+dis[index]);
                    }
                }
        
                int result = -1;
                for (int i=0; i<n; i++) {
                    result = Math.max(result, dis[i]);
                }
        
                return result;
        
                // Floyd
                // time O(V^3) V- vertice count
                // time O(V^2)
                /*int[][] adjMatrics = new int[n][n];
        
                for (int[] arr : adjMatrics) {
                    Arrays.fill(arr, 100*101);
                }
        
                for (int i=0; i<n; i++)
                    adjMatrics[i][i] = 0;
        
                for (int[] time : times) {
                    adjMatrics[time[0]-1][time[1]-1] = time[2];
                }
        
                for (int m=0; m<n; m++) {
                    for (int i=0; i<n; i++) {
                        for (int j=0; j<n; j++) {
                            adjMatrics[i][j] = Math.min(adjMatrics[i][j], adjMatrics[i][m]+adjMatrics[m][j]);
                        }
                    }
                }
        
                int result = -1;
                for (int i=0; i<n; i++) {
                    System.out.println(adjMatrics[k-1][i]);
                    result = Math.max(result, adjMatrics[k-1][i]);
                }
        
                if (result == 100*101)
                    return -1;
                return result;*/
        
                // Bellman-Ford
                // time O(VE), V-Vertices count; E-Edges count;
                // space O(V)
                /*int[] result = new int[n+1];
                Arrays.fill(result, 100*101);
                result[k] = 0;
        
                for (int i=1; i<n; i++) {
                    for (int[] time : times) {
                        result[time[1]] = Math.min(result[time[0]]+time[2], result[time[1]]);
                    }
                }
        
                int minTime = -1;
                for (int i=1; i<=n; i++) {
                    minTime = Math.max(minTime, result[i]);
                }
                
                if (minTime == 100*101)
                    return -1;
        
                return minTime;*/
    }
}