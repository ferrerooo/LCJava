import java.util.*;

class LC0210_CourseScheduleII {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        
        Map<Integer, Integer> map = new HashMap<>();
        Queue<Integer> ready = new LinkedList<>();
        int[] result = new int[numCourses];
        Map<Integer, List<Integer>> dependencies = new HashMap<>();
        
        for (int[] pair : prerequisites) {
            
            if (map.containsKey(pair[0]))
                map.put(pair[0], map.get(pair[0]) + 1);
            else
                map.put(pair[0], 1);
        
            if (dependencies.containsKey(pair[1])) {
                dependencies.get(pair[1]).add(pair[0]);
            } else {
                List<Integer> list = new LinkedList<>();
                list.add(pair[0]);
                dependencies.put(pair[1], list);
            }
        }
        
        for (int i = 0; i<numCourses; i++) {
            if (!map.containsKey(i))
                ready.offer(i);
        }
        
        int cur = 0;
        while (!ready.isEmpty()) {
            
            int course = ready.poll();
            System.out.println(course);
            result[cur] = course;
            cur += 1;
            
            if (dependencies.containsKey(course)) {
                System.out.println("dependencies.containsKey(course) " + course);
                for (int i : dependencies.get(course)) {
                    map.put(i, map.get(i) - 1);
                    System.out.println("map.put(i, map.get(i) - 1); " + i + " " + map.get(i));
                    if (map.get(i) == 0) {
                        map.remove(i);
                        ready.offer(i);
                    }
                }
            }
            
        }
        
        if (!map.isEmpty())
            return new int[0];
        else
            return result;
        
    }
}