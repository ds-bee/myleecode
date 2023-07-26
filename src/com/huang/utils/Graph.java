package com.huang.utils;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Graph {

    public static void main(String[] args) {
        int[][] graph = {{4, 3, 1}, {3, 2, 4}, {3}, {4}, {}};
        int V = graph.length;

        Graph g = new Graph(V);

        for (int i = 0; i < V; i++) {
            for (int j = 0; j < graph[i].length; j++) {
                g.addEdge(i, graph[i][j]);
            }
        }

        g.topologicalSort();
    }

    private int V; // 顶点的数量
    private List<List<Integer>> adjacencyList; // 邻接表

    public Graph(int V) {
        this.V = V;
        adjacencyList = new ArrayList<>(V);
        for (int i = 0; i < V; i++) {
            adjacencyList.add(new ArrayList<>());
        }
    }

    public void addEdge(int u, int v) {
        adjacencyList.get(u).add(v);
    }

    public void topologicalSort() {
        int[] inDegree = new int[V]; // 存储每个顶点的入度

        // 计算每个顶点的入度
        for (List<Integer> neighbors : adjacencyList) {
            for (int neighbor : neighbors) {
                inDegree[neighbor]++;
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        // 将入度为0的顶点添加到队列中
        for (int i = 0; i < V; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }

        List<Integer> topologicalOrder = new ArrayList<>();

        while (!queue.isEmpty()) {
            int u = queue.poll();
            topologicalOrder.add(u);

            for (int neighbor : adjacencyList.get(u)) {
                // 将相邻顶点的入度减1
                inDegree[neighbor]--;

                // 若入度减为0，则添加到队列中
                if (inDegree[neighbor] == 0) {
                    queue.offer(neighbor);
                }
            }
        }

        // 检查是否存在环
        if (topologicalOrder.size() != V) {
            System.out.println("图中存在环！");
            return;
        }

        // 输出拓扑排序结果
        System.out.println("拓扑排序结果:");
        for (int vertex : topologicalOrder) {
            System.out.print(vertex + " ");
        }
    }
}




