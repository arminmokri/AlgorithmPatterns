from typing import List, Tuple
import unittest

debug = True


class Result:
    value: int
    items: list

    def __init__(self, value: int, items: list):
        self.value = value
        self.items = items

    def __eq__(self, other):
        if isinstance(other, Result):
            return self.value == other.value and self.items == other.items
        return NotImplemented


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

    def knapsackTabulation(
        self, names: List[str], values: List[int], weights: List[int], capacity: int
    ) -> Result:
        number_of_items = len(values)

        matrix = [[0] * (capacity + 1) for i in range(number_of_items + 1)]

        if debug and capacity < 20:
            print()
            print("matrix=")
            print(self.matrixToString(matrix))

        for i in range(1, number_of_items + 1):
            item_value = values[i - 1]
            item_weight = weights[i - 1]
            for j in range(1, capacity + 1):
                if item_weight <= j:
                    include_value = item_value + matrix[i - 1][j - item_weight]
                    exclude_value = matrix[i - 1][j]
                    matrix[i][j] = max(include_value, exclude_value)
                else:
                    matrix[i][j] = matrix[i - 1][j]

            if debug and capacity < 20:
                print("matrix=")
                print(self.matrixToString(matrix))

        result = Result(matrix[number_of_items][capacity], list())
        current_capacity = capacity
        for i in range(number_of_items, 0, -1):
            item = names[i - 1]
            if not matrix[i][current_capacity] == matrix[i - 1][current_capacity]:
                result.items.append(item)
                current_capacity = current_capacity - weights[i - 1]
                if debug and capacity < 20:
                    print(item + " is included")
            else:
                if debug and capacity < 20:
                    print(item + " is excluded")
        result.items.reverse()

        return result


class Test(unittest.TestCase):
    def setUp(self):
        self.solution = Solution()

    def test_default_case(self):
        self.assertEqual(
            self.solution.knapsackTabulation(
                ["Microscope", "Globe", "Cup", "Crown"],
                [300, 200, 400, 500],
                [2, 1, 5, 3],
                10,
            ),
            Result(1200, ["Microscope", "Cup", "Crown"]),
        )

    def test_empty_items(self):
        self.assertEqual(
            self.solution.knapsackTabulation([], [], [], 10), Result(0, [])
        )

    def test_zero_capacity(self):
        self.assertEqual(
            self.solution.knapsackTabulation(["Item1"], [100], [1], 0), Result(0, [])
        )

    def test_single_item_fits(self):
        self.assertEqual(
            self.solution.knapsackTabulation(["Item1"], [100], [1], 1),
            Result(100, ["Item1"]),
        )

    def test_single_item_does_not_fit(self):
        self.assertEqual(
            self.solution.knapsackTabulation(["Item1"], [100], [5], 3), Result(0, [])
        )

    def test_all_items_fit_exactly(self):
        self.assertEqual(
            self.solution.knapsackTabulation(
                ["A", "B", "C"], [10, 20, 30], [1, 2, 3], 6
            ),
            Result(60, ["A", "B", "C"]),
        )

    def test_choose_optimal_combination(self):
        self.assertEqual(
            self.solution.knapsackTabulation(
                ["A", "B", "C"], [60, 100, 120], [10, 20, 30], 50
            ),
            Result(220, ["B", "C"]),
        )

    def test_items_with_same_weight_and_value(self):
        result = self.solution.knapsackTabulation(
            ["X", "Y", "Z"], [50, 50, 50], [5, 5, 5], 10
        )
        self.assertEqual(result.value, 100)
        self.assertEqual(len(result.items), 2)
        self.assertTrue(set(result.items).issubset({"X", "Y", "Z"}))

    def test_duplicate_best_value(self):
        result = self.solution.knapsackTabulation(
            ["Pen", "Notebook", "Calculator", "Book"],
            [10, 40, 50, 70],
            [1, 3, 4, 5],
            8,
        )
        self.assertEqual(result, Result(110, ["Notebook", "Book"]))

    def test_large_input_recursion_limit(self):
        items = [f"Item{i}" for i in range(30)]
        values = [i * 10 for i in range(30)]
        weights = [i + 1 for i in range(30)]
        capacity = 100

        # Recursive solution will be extremely slow or hit recursion limits
        # Tabulation / memoized solution should solve this
        result = self.solution.knapsackTabulation(items, values, weights, capacity)
        print("aaaaaaaaaaaaaaaaa" + str(result.value))

        self.assertTrue(result.value == 960)


def main():
    unittest.main()


if __name__ == "__main__":
    main()
