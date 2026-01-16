package dfs_bfs.clone_graph;

import common.PrintHelper;

import java.util.*;


public class Solution {

    public Node cloneGraph(Node node) {
        if (PrintHelper.debug) {
            System.out.println();
        }
        if (Objects.isNull(node)) {
            return null;
        }
        return bfsConnected(node);
    }

    private Node bfsConnected(Node graph) {
        Set<Node> visited = new HashSet<>();
        Queue<Node> queue = new LinkedList<>();
        Map<Node, Node> clone = new HashMap<>();

        visited.add(graph);
        queue.add(graph);
        clone.put(graph, new Node(graph.val));

        while (!queue.isEmpty()) {
            Node currentNode = queue.poll();

            for (Node neighbor : currentNode.neighbors) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.add(neighbor);
                    clone.put(neighbor, new Node(neighbor.val));
                }
                clone.get(currentNode).neighbors.add(clone.get(neighbor));
            }
        }
        return clone.get(graph);
    }

    // Definition for a Node.
    static class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<>();
        }

        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<>();
        }

        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }

        @Override
        public String toString() {
            return "Node(" + val + ")";
        }
    }

    static class Graph {
        public static Node build(int[][] adjList) {
            if (adjList == null || adjList.length == 0) return null;

            Node[] nodes = new Node[adjList.length];
            for (int i = 0; i < adjList.length; i++) {
                nodes[i] = new Node(i + 1);
            }

            for (int i = 0; i < adjList.length; i++) {
                List<Node> nbrs = new ArrayList<>();
                for (int neighborVal : adjList[i]) {
                    // Python uses 1-based values; array is 0-based
                    nbrs.add(nodes[neighborVal - 1]);
                }
                nodes[i].neighbors = nbrs;
            }
            return nodes[0];
        }

        public static List<List<Integer>> toAdjList(Node node) {
            if (node == null) return Collections.emptyList();

            Map<Integer, List<Integer>> adj = new HashMap<>();
            Set<Node> visited = new HashSet<>();
            ArrayDeque<Node> q = new ArrayDeque<>();
            q.add(node);

            while (!q.isEmpty()) {
                Node curr = q.removeFirst();

                if (!adj.containsKey(curr.val)) {
                    List<Integer> neighborsVals = new ArrayList<>();
                    for (Node n : curr.neighbors) neighborsVals.add(n.val);
                    adj.put(curr.val, neighborsVals);
                }

                visited.add(curr);

                for (Node neighbor : curr.neighbors) {
                    if (!visited.contains(neighbor) && !q.contains(neighbor)) {
                        q.addLast(neighbor);
                    }
                }
            }

            List<Integer> keys = new ArrayList<>(adj.keySet());
            Collections.sort(keys);

            List<List<Integer>> res = new ArrayList<>();
            for (int k : keys) {
                res.add(adj.get(k));
            }
            return res;
        }
    }
}
