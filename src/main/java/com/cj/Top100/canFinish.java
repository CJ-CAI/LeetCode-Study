package com.cj.Top100;

import java.util.ArrayList;
import java.util.List;

/**
 * 课程表
 *
 * @author CJ_CA
 * @date 2023/08/28
 */
public class canFinish {
    public static void main(String[] args) {
        int numCourses = 2;
        int[][] prerequisites = new int[][]{{1, 0}};
        int[] flag = new int[numCourses];
        List<ArrayList<Integer>> lists = new ArrayList<>(prerequisites.length);
        for (int i = 0; i < numCourses; i++) {
            lists.add(new ArrayList());
        }
        for (int[] prerequisite : prerequisites) {
            lists.get(prerequisite[1]).add(prerequisite[0]);
        }
        for (int i = 0; i < flag.length; i++) {
            if (!dfs(lists, i, flag)) {
                System.out.println(false);
                return;
            }
        }
        System.out.println(true);
    }

    public static boolean dfs(List<ArrayList<Integer>> lists, int i, int[] flag) {
        if (flag[i] == -1) {
            return true;
        }
        if (flag[i] == 1) {
            return false;
        }
        flag[i] = 1;
        for (Integer number : lists.get(i)) {
            if (!dfs(lists, number, flag)) {
                return false;
            }
        }
        flag[i] = -1;
        return true;
    }
}
