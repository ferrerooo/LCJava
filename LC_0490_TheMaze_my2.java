import java.util.*;

public class LC_0490_TheMaze_my2 {
    
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {

        LinkedList<int[]> cur = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        visited.add(start[0]+","+start[1]);
        cur.add(start);
        LinkedList<int[]> next = new LinkedList<>();

        while (cur.size() > 0) {
            //System.out.println("1");
            while (cur.size() > 0) {
                //System.out.println("visited size "+visited.size());
                int[] local = cur.poll();

                int[] up = getUp(maze, local, visited);
                int[] down = getDown(maze, local, visited);
                int[] left = getLeft(maze, local, visited);
                int[] right = getRight(maze, local, visited);

                if (up != null) {
                    //System.out.println("up"+up[0]+","+up[1]);
                    next.add(up);
                }
                if (down != null) {
                    //System.out.println("down"+down[0]+","+down[1]);
                    next.add(down);
                }
                if (left != null) {
                    //System.out.println("left"+left[0]+","+left[1]);
                    next.add(left);
                }
                if (right != null){
                    //System.out.println("right"+right[0]+","+right[1]);
                    next.add(right);
                }
            }

            for (int[] n : next) {
                visited.add(n[0]+","+n[1]);
            }

            if (visited.contains(destination[0]+","+destination[1])) {
                return true;
            }

            cur = next;
            next = new LinkedList<>();

        }

        return false;
        
    }

    private int[] getUp(int[][] maze, int[] local, Set<String> visited) {

        int r = local[0];
        int l = local[1];
        int m = maze.length;
        int n = maze[0].length;

        while (r>=0 && maze[r][l] == 0) {
            r = r-1;
        }

        if (visited.contains((r+1)+","+l))
            return null;
        else
            return new int[]{r+1, l};
    }

    private int[] getDown(int[][] maze, int[] local, Set<String> visited) {

        int r = local[0];
        int l = local[1];
        int m = maze.length;
        int n = maze[0].length;

        while (r<m && maze[r][l] == 0) {
            r = r+1;
        }

        if (visited.contains((r-1)+","+l))
            return null;
        else
            return new int[]{r-1, l};

    }

    private int[] getLeft(int[][] maze, int[] local, Set<String> visited) {

        int r = local[0];
        int l = local[1];
        int m = maze.length;
        int n = maze[0].length;

        while (l>=0 && maze[r][l] == 0) {
            l = l-1;
        }

        if (visited.contains(r+","+(l+1)))
            return null;
        else
            return new int[]{r, l+1};

    }

    private int[] getRight(int[][] maze, int[] local, Set<String> visited) {

        int r = local[0];
        int l = local[1];
        int m = maze.length;
        int n = maze[0].length;

        while (l<n && maze[r][l] == 0) {
            l = l+1;
        }

        if (visited.contains(r+","+(l-1)))
            return null;
        else
            return new int[]{r, l-1};

    }
}