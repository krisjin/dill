package dill.lee.window;


/**
 * 交站间的距离
 * https://leetcode.cn/problems/distance-between-bus-stops
 * <pre>
 * 环形公交路线上有 n 个站，按次序从 0 到 n - 1 进行编号。我们已知每一对相邻公交站之间的距离，
 * distance[i] 表示编号为 i 的车站和编号为 (i + 1) % n 的车站之间的距离。
 *
 * 环线上的公交车都可以按顺时针和逆时针的方向行驶。
 *
 * 返回乘客从出发点 start 到目的地 destination 之间的最短距离。
 * </pre>
 */
public class DistanceBetweenBusStops1184 {

    public int distanceBetweenBusStops(int[] distance, int start, int destination) {
        if (start > destination) {
            int temp = start;
            start = destination;
            destination = temp;
        }
        int sum1 = 0, sum2 = 0;
        for (int i = 0; i < distance.length; i++) {
            if (i >= start && i < destination) {
                sum1 += distance[i];
            } else {
                sum2 += distance[i];
            }
        }
        return Math.min(sum1, sum2);
    }


    public int distanceBetweenBusStops2(int[] dist, int s, int t) {
        int n = dist.length, i = s, j = s, a = 0, b = 0;
        while (i != t) {
            a += dist[i];
            if (++i == n) i = 0;
        }
        while (j != t) {
            if (--j < 0) j = n - 1;
            b += dist[j];
        }
        return Math.min(a, b);
    }

    public static void main(String[] args) {
        // distance = [1,2,3,4], start = 0, destination = 2
        int distance[] = {1, 2, 3, 4};
        int start = 0;
        int destination = 2;

        DistanceBetweenBusStops1184 distanceBetweenBusStops = new DistanceBetweenBusStops1184();
        int distances = distanceBetweenBusStops.distanceBetweenBusStops(distance, start, destination);

        System.out.println(distances);
    }

}
