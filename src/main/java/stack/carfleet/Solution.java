package stack.carfleet;

import java.util.Arrays;
import java.util.Stack;

class Pair implements Comparable<Pair> {
    float speed;
    float position;

    Pair(int position, int speed) {
        this.position = position;
        this.speed = speed;
    }

    @Override
    public int compareTo(Pair other) {
        return (int) (other.position - this.position);
    }
}

class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int fleet = 0;
        Stack<Float> fleets = new Stack<>();
        Pair[] points = new Pair[position.length];

        for (int i = 0; i < position.length; i++) {
            points[i] = new Pair(position[i], speed[i]);
        }

        Arrays.sort(points);

        for (Pair pair: points) {
            float time = (target - pair.position) / pair.speed;

            if(fleets.isEmpty() || time > fleets.peek()) {
                fleets.push(time);
            }
        }

        return fleets.size();
    }
}

/**
 *
 target=12
 position=[10,8,0,5,3] => [{10: 2}, {8: 4}, {5: 1}, {3: 3}, {0: 1}]
 speed=[2,4,1,1,3]     => [1, 1, 7, 3, 12]

 1   2
   |---|---|---|---|---|---|---|---|---|---|
 3   2           1           4
   |---|---|---|---|---|---|---|---|---|---|

**/