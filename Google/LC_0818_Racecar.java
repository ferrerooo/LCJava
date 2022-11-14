package Google;

import java.util.*;
import javafx.util.Pair;

public class LC_0818_Racecar {

    public int racecar(int target) {
        
        Queue<Pair<Integer, Integer>> q = new ArrayDeque<>();
        Set<Pair<Integer, Integer>> visited = new HashSet<>();

        q.offer(new Pair<>(0, 1));
        visited.add(q.peek());
        int steps = 0;

        while (!q.isEmpty()) {

            var size = q.size();

            for (int i = 0; i < size; i++) {

                var node = q.poll();
                var position = node.getKey();
                var speed = node.getValue();

                if (position == target)
                    return steps;
                
                // A
                var newNodeA = new Pair<Integer, Integer>(position + speed, speed * 2);
                if (newNodeA.getKey() > 0 && newNodeA.getKey() < 2 * target && !visited.contains(newNodeA)) {
                    q.offer(newNodeA);
                    visited.add(newNodeA);
                }
                // R
                var newNodeR = new Pair<Integer, Integer>(position, speed > 0 ? -1 : 1);
                if (newNodeR.getKey() > 0 && newNodeR.getKey() < 2 * target && !visited.contains(newNodeR)) {
                    q.offer(newNodeR);
                    visited.add(newNodeR);
                }
            }

            steps++;
        }

        return -1;
    }
}