import unittest

debug = True


class Solution:
    def martixToString(self, myMatrix: list[list] | tuple[tuple]) -> str:
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

    def listToString(self, myList: list | tuple) -> str:
        items = [f"({i}) {item}" for i, item in enumerate(myList)]
        return f"[{', '.join(items)}]"

    def knapsack_tabulation(
        self, names: list[str], values: list[int], weights: list[int], capacity: int
    ) -> int:
        number_of_items = len(values)

        matrix = [[0] * (capacity + 1) for i in range(number_of_items + 1)]

        if debug:
            print()
            print("matrix=")
            print(self.martixToString(matrix))

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

            if debug:
                print("matrix=")
                print(self.martixToString(matrix))

        items = list()
        current_capacity = capacity
        for i in range(number_of_items, 0, -1):
            item = names[i - 1]
            if not matrix[i][current_capacity] == matrix[i - 1][current_capacity]:
                items.append(item)
                current_capacity = current_capacity - weights[i - 1]
                if debug:
                    print(item + " is included")
            else:
                if debug:
                    print(item + " is excluded")
        items.reverse()

        return (matrix[number_of_items][capacity], items)


class Test(unittest.TestCase):
    def setUp(self):
        self.solution = Solution()

    def test_default_case(self):
        self.assertEqual(
            self.solution.knapsack_tabulation(
                ["Microscope", "Globe", "Cup", "Crown"],
                [300, 200, 400, 500],
                [2, 1, 5, 3],
                10,
            ),
            (1200, ["Microscope", "Cup", "Crown"]),
        )

    def test_empty_items(self):
        self.assertEqual(self.solution.knapsack_tabulation([], [], [], 10), (0, []))

    def test_zero_capacity(self):
        self.assertEqual(
            self.solution.knapsack_tabulation(["Item1"], [100], [1], 0), (0, [])
        )

    def test_single_item_fits(self):
        self.assertEqual(
            self.solution.knapsack_tabulation(["Item1"], [100], [1], 1),
            (100, ["Item1"]),
        )

    def test_single_item_does_not_fit(self):
        self.assertEqual(
            self.solution.knapsack_tabulation(["Item1"], [100], [5], 3), (0, [])
        )

    def test_all_items_fit_exactly(self):
        self.assertEqual(
            self.solution.knapsack_tabulation(
                ["A", "B", "C"], [10, 20, 30], [1, 2, 3], 6
            ),
            (60, ["A", "B", "C"]),
        )

    def test_choose_optimal_combination(self):
        self.assertEqual(
            self.solution.knapsack_tabulation(
                ["A", "B", "C"], [60, 100, 120], [10, 20, 30], 50
            ),
            (220, ["B", "C"]),
        )

    def test_items_with_same_weight_and_value(self):
        total_value, selected_items = self.solution.knapsack_tabulation(
            ["X", "Y", "Z"], [50, 50, 50], [5, 5, 5], 10
        )
        self.assertEqual(total_value, 100)
        self.assertEqual(len(selected_items), 2)
        self.assertTrue(set(selected_items).issubset({"X", "Y", "Z"}))

    def test_duplicate_best_value(self):
        result = self.solution.knapsack_tabulation(
            ["Pen", "Notebook", "Calculator", "Book"],
            [10, 40, 50, 70],
            [1, 3, 4, 5],
            8,
        )
        self.assertEqual(result, (110, ["Notebook", "Book"]))


def main():
    unittest.main()


if __name__ == "__main__":
    main()
