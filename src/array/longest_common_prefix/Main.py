debug = True


class Solution:
    def listToString(self, myList: list | tuple) -> str:
        items = [f"({i}) {item}" for i, item in enumerate(myList)]
        return f"[{', '.join(items)}]"

    def Solution(self, strs: list[str]) -> str:
        biggestPrefix = ""
        minStr = min(strs, key=len)

        for i in range(len(minStr), 0, -1):
            prefixStr = minStr[0:i]
            print("prefixStr=" + prefixStr)

            flag = 0
            for currentStr in strs:
                if minStr == currentStr:
                    continue

                if not currentStr.startswith(prefixStr):
                    flag = 1
                    break

            if flag == 0:
                biggestPrefix = prefixStr
                break

        return biggestPrefix


def main():
    strs = ["flower", "flow", "flight"]
    solution = Solution()
    result = solution.Solution(strs)
    print("result=" + str(result))


if __name__ == "__main__":
    main()
