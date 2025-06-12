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


    def solution(self, r: int, total: int) -> int:
        ways = [0 for _ in range(total + 1)]

        ways[0] = 1

        steps = [n for n in range(1, r + 1)]

        # print
        if debug:
            print("steps=" + self.listToString(steps))
            print()

        for i, step in enumerate(steps):
            # print
            if debug:
                print("i=" + str(i) + " step=" + str(step))

            for j in range(len(ways)):
                if step <= j:
                    # Update the ways array
                    index = j - step
                    ways[j] = ways[j] + ways[index]

                    # print
                    if debug:
                        print(
                            "j="
                            + str(j)
                            + " index="
                            + str(index)
                            + " ways="
                            + self.listToString(ways)
                        )

        # print
        if debug:
            print()

        return ways[total]


def main():
    r = 2
    total = 8
    solution = Solution()
    result = solution.solution(r, total)
    print("Result=" + str(result))


if __name__ == "__main__":
    main()
