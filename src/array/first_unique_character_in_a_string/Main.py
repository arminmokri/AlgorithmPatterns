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
        if myList == []:
            return "[]"

        items = [f"({i}) {item}" for i, item in enumerate(myList)]
        return f"[{', '.join(items)}]"

    def Solution(self, string: str) -> int:
        singleIndex = None

        frequentList = [0] * 256

        if debug:
            print("frequentList=" + str(frequentList))

        for c in string:
            frequentIndex = ord(c)
            frequentList[frequentIndex] = frequentList[frequentIndex] + 1

        if debug:
            print("frequentList=" + str(frequentList))

        for i, c in enumerate(string):
            frequentIndex = ord(c)
            if frequentList[frequentIndex] == 1:
                singleIndex = i
                break

        return singleIndex


def main():
    string = "stress"
    solution = Solution()
    result = solution.Solution(string)
    print("result=" + str(result))


if __name__ == "__main__":
    main()
