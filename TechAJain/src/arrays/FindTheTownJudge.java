package arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindTheTownJudge {
    public int findJudge(int N, int[][] trust) {
        if(N == 1 && trust.length == 0)
            return 1;

        Map<Integer, List<Integer>> map = new HashMap<>();
        int maxTrust = -1;
        for(int[] pair : trust) {
            List<Integer> list = map.getOrDefault(pair[1], new ArrayList<>());
            list.add(pair[0]);
            map.put(pair[1], list);
            if(list.size() == N - 1)
                maxTrust = pair[1];
        }

        for(int[] pair : trust) {
            if(pair[0] == maxTrust)
                return -1;
        }

        return maxTrust;
    }

    public int findJudgeFastest(int N, int[][] trust) {
        if(trust.length < N-1){
            return -1;
        }

        int [] inEdges = new int[N+1];
        int [] outEdges = new int[N+1];
        for(int[] relation :trust){
            outEdges[relation[0]]++;
            inEdges[relation[1]]++;
        }
        for (int i = 1; i <= N; i++) {
            if (inEdges[i] == N - 1 && outEdges[i] == 0) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        FindTheTownJudge obj = new FindTheTownJudge();
        System.out.println(obj.findJudge(2, new int[][]{{1,2}}));
        System.out.println(obj.findJudge(1, new int[][]{}));
        System.out.println(obj.findJudge(3, new int[][]{{1,3}, {2,3}}));
        System.out.println(obj.findJudge(3, new int[][]{{1,3},{2,3},{3,1}}));
        System.out.println(obj.findJudge(3, new int[][]{{1,2},{2,3}}));
        System.out.println(obj.findJudge(4, new int[][]{{1,3},{1,4},{2,3},{2,4},{4,3}}));
    }
}
