[< Back To Algorithm Patterns](../../../../)

# DFS-BFS Algorithm Patterns
### Please support my repo with your ⭐

## Concept

**DFS (Depth-First Search)** and **BFS (Breadth-First Search)** are fundamental **graph traversal algorithms** used to explore nodes and edges in graphs or trees.
- **DFS** explores as deep as possible before backtracking.
- **BFS** explores level by level using a queue.

Both algorithms are used to:
- Traverse graphs and grids
- Find connected components
- Detect cycles
- Check reachability
- Find shortest paths in **unweighted graphs** (BFS)

## Graph Perspective

Many problems that don’t *look* like graphs actually are:
- Grid problems → graph of cells
- Islands / regions → connected components
- Word transformations → graph of words
- Course prerequisites → directed graph

> If a problem asks you to **visit all reachable neighbors**, think **DFS/BFS**.

## When to Use BFS vs DFS

| Use Case                       | BFS | DFS |
|--------------------------------|-----|-----|
| Traverse all nodes             | ✅  | ✅  |
| Shortest path (unweighted)     | ✅  | ❌  |
| Connected components           | ✅  | ✅  |
| Cycle detection                | ❌  | ✅  |
| Topological sort               | ❌  | ✅  |
| Flood fill / islands           | ✅  | ✅  |
| Avoid recursion stack overflow | ✅  | ❌  |

## Connected vs Disconnected Graphs

### Connected Graph
- All nodes are reachable from a single start node
- One BFS/DFS call is enough

### Disconnected Graph
- Graph has multiple components
- Requires an **outer loop**
- Each BFS/DFS call processes **one component**

> 💡 **Rule of thumb:**  
> If you need an outer loop to start BFS/DFS multiple times → the graph is disconnected.

## BFS Templates

### 1️⃣ BFS – Connected Graph
```java
void bfsConnected(List<List<Integer>> graph, int start) {
    boolean[] visited = new boolean[graph.size()];
    Queue<Integer> queue = new LinkedList<>();

    visited[start] = true;
    queue.offer(start);

    while (!queue.isEmpty()) {
        int node = queue.poll();
        System.out.print(node + " ");

        for (int neighbor : graph.get(node)) {
            if (!visited[neighbor]) {
                visited[neighbor] = true;
                queue.offer(neighbor);
            }
        }
    }
}
```

### Use when:
- Graph is guaranteed to be connected
- You are given a starting node (e.g. Clone Graph)

### 2️⃣ BFS – Disconnected Graph (Connected Components)
```java
void bfsDisconnected(List<List<Integer>> graph) {
    boolean[] visited = new boolean[graph.size()];

    for (int i = 0; i < graph.size(); i++) {
        if (!visited[i]) {
            bfs(graph, i, visited);
        }
    }
}
```

### Use when:
- Counting components (e.g. Number of Islands)
- Graph may be disconnected

## DFS Templates

### 3️⃣ DFS – Connected Graph (Recursive)
```java
void dfsConnected(List<List<Integer>> graph, int start) {
    boolean[] visited = new boolean[graph.size()];
    dfs(start, graph, visited);
}

void dfs(int node, List<List<Integer>> graph, boolean[] visited) {
    visited[node] = true;
    System.out.print(node + " ");

    for (int neighbor : graph.get(node)) {
        if (!visited[neighbor]) {
            dfs(neighbor, graph, visited);
        }
    }
}
```

### Use when:
- Graph is connected
- Depth-first exploration is needed

### 4️⃣ DFS – Disconnected Graph (Most Common Pattern)
```java
void dfsDisconnected(List<List<Integer>> graph) {
    boolean[] visited = new boolean[graph.size()];

    for (int i = 0; i < graph.size(); i++) {
        if (!visited[i]) {
            dfs(i, graph, visited);
        }
    }
}
```

### Use when:
- Counting connected components
- Grid problems (islands, regions)
- Cycle detection in graphs


## Examples
| #  | Name                                                        | Java | Python | Go | Link                                                                       | Company |
|----|-------------------------------------------------------------|------|--------|----|----------------------------------------------------------------------------|---------|
| 1  | [Number of Islands](number_of_islands/)                     | ✅   | ✅     | ❌ | [LeetCode #200](https://leetcode.com/problems/number-of-islands)           |         |
| 2  | [Clone Graph](clone_graph/)                                 | ✅   | ✅     | ❌ | [LeetCode #133](https://leetcode.com/problems/clone-graph)                 |         |
| 3  | [Word Ladder](word_ladder/)                                 | ✅   | ✅     | ❌ | [LeetCode #127](https://leetcode.com/problems/word-ladder)                 |         |
| 4  | [Course Schedule](course_schedule/)                         | ✅   | ❌     | ❌ | [LeetCode #207](https://leetcode.com/problems/course-schedule)             |         |
| 5  | [Pacific Atlantic Water Flow](pacific_atlantic_water_flow/) | ❌   | ❌     | ❌ | [LeetCode #417](https://leetcode.com/problems/pacific-atlantic-water-flow) |         |

<p align="center">
  <a href="../binary_search">⬅️ <strong>Binary Search</strong></a>
  🔸
  <a href="../dynamic_programming"><strong>Dynamic Programming</strong> ➡️</a>
</p>

[< Back To Algorithm Patterns](../../../../)
