from typing import List, Tuple, Optional
import unittest

debug = True


# Definition for a Node.
class Node:
    def __init__(self, val=0, neighbors=None):
        self.val = val
        self.neighbors = neighbors if neighbors is not None else []

    def __repr__(self):
        return f"Node({self.val})"


class Graph:
    @staticmethod
    def build(adj_list: List[List[int]]) -> Optional[Node]:
        if not adj_list:
            return None
        nodes = [Node(i + 1) for i in range(len(adj_list))]
        for i, neighbors in enumerate(adj_list):
            nodes[i].neighbors = [nodes[j - 1] for j in neighbors]
        return nodes[0]

    @staticmethod
    def to_adj_list(node: Optional[Node]) -> List[List[int]]:
        if not node:
            return []
        adj_list = {}
        visited = set()
        queue = [node]
        while queue:
            curr = queue.pop(0)
            if curr.val not in adj_list:
                adj_list[curr.val] = [n.val for n in curr.neighbors]
            visited.add(curr)
            for neighbor in curr.neighbors:
                if neighbor not in visited and neighbor not in queue:
                    queue.append(neighbor)
        return [adj_list[i] for i in sorted(adj_list)]


class Solution:
    def matrixToString(self, myMatrix: List[List] | Tuple[Tuple]) -> str:
        if myMatrix == []:
            return "[]"
        elif myMatrix == [[]]:
            return "[[]]"

        str_matrix = [[str(val) for val in row] for row in myMatrix]
        max_width = max(len(val) for row in str_matrix for val in row)

        return "\n".join(
            "[ " + ", ".join(f"{val:>{max_width}}" for val in row) + " ]"
            for row in str_matrix
        )

    def listToString(self, myList: List | Tuple) -> str:
        if myList == []:
            return "[]"

        items = [f"({i}) {item}" for i, item in enumerate(myList)]
        return f"[{', '.join(items)}]"

    def cloneGraph(self, node: Optional[Node]) -> Optional[Node]:
        if debug:
            print()

        seen = dict()

        def clone(n: Optional["Node"]):
            if n in seen:
                return seen[n]

            node_clone = Node(n.val)

            if debug:
                print("clone node=" + str(node_clone.val))

            seen[n] = node_clone

            for neighbor in n.neighbors:
                neighbor_clone = clone(neighbor)
                node_clone.neighbors.append(neighbor_clone)
            return node_clone

        return clone(node) if node is not None else None


class Test(unittest.TestCase):
    def setUp(self):
        self.solution = Solution()

    def compare_graphs(
        self, node1: Optional[Node], node2: Optional[Node], visited=None
    ) -> bool:
        if visited is None:
            visited = set()

        if node1 is node2:
            return False  # Must be a deep copy

        if node1 is None or node2 is None:
            return node1 is node2

        if node1.val != node2.val:
            return False

        if node1 in visited:
            return True

        visited.add(node1)

        if len(node1.neighbors) != len(node2.neighbors):
            return False

        flag = True
        for n1, n2 in zip(node1.neighbors, node2.neighbors):
            if not self.compare_graphs(n1, n2, visited):
                print(
                    "Node with value {} was not copied but a reference to the original one. same memory address {} = {}".format(
                        n1.val, hex(id(n1)), hex(id(n2))
                    )
                )
                flag = False

        return flag

    def test_default_case(self):
        input_adj = [[2, 4], [1, 3], [2, 4], [1, 3]]
        input_graph = Graph.build(input_adj)
        cloned_graph = self.solution.cloneGraph(input_graph)
        output_adj = Graph.to_adj_list(cloned_graph)
        self.assertEqual(output_adj, input_adj)
        self.assertTrue(self.compare_graphs(input_graph, cloned_graph, set()))

        input_adj = [[]]
        input_graph = Graph.build(input_adj)
        cloned_graph = self.solution.cloneGraph(input_graph)
        output_adj = Graph.to_adj_list(cloned_graph)
        self.assertEqual(output_adj, input_adj)
        self.assertTrue(self.compare_graphs(input_graph, cloned_graph, set()))

        self.assertIsNone(self.solution.cloneGraph(None))

    def test_square_graph(self):
        input_adj = [[2, 4], [1, 3], [2, 4], [1, 3]]
        input_graph = Graph.build(input_adj)
        cloned_graph = self.solution.cloneGraph(input_graph)
        output_adj = Graph.to_adj_list(cloned_graph)
        self.assertEqual(output_adj, input_adj)
        self.assertTrue(self.compare_graphs(input_graph, cloned_graph))

    def test_single_node(self):
        input_adj = [[]]
        input_graph = Graph.build(input_adj)
        cloned_graph = self.solution.cloneGraph(input_graph)
        output_adj = Graph.to_adj_list(cloned_graph)
        self.assertEqual(output_adj, input_adj)
        self.assertTrue(self.compare_graphs(input_graph, cloned_graph))

    def test_none_input(self):
        self.assertIsNone(self.solution.cloneGraph(None))

    def test_two_connected_nodes(self):
        input_adj = [[2], [1]]
        input_graph = Graph.build(input_adj)
        cloned_graph = self.solution.cloneGraph(input_graph)
        output_adj = Graph.to_adj_list(cloned_graph)
        self.assertEqual(output_adj, input_adj)
        self.assertTrue(self.compare_graphs(input_graph, cloned_graph))

    def test_fully_connected_graph(self):
        input_adj = [[2, 3, 4], [1, 3, 4], [1, 2, 4], [1, 2, 3]]
        input_graph = Graph.build(input_adj)
        cloned_graph = self.solution.cloneGraph(input_graph)
        output_adj = Graph.to_adj_list(cloned_graph)
        self.assertEqual(output_adj, input_adj)
        self.assertTrue(self.compare_graphs(input_graph, cloned_graph))


def main():
    unittest.main()


if __name__ == "__main__":
    main()
