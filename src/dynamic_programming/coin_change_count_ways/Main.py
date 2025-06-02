debug = True


def listToString(myList: list | tuple) -> str:
    items = [f"({i}) {item}" for i, item in enumerate(myList)]
    return f"[{', '.join(items)}]"


def solution(N: int, coins: tuple) -> int:
    ways = [0 for _ in range(N + 1)]

    ways[0] = 1

    # print
    if debug:
        print("coins=" + listToString(coins))
        print()

    for i, coin in enumerate(coins):
        # print
        if debug:
            print("i=" + str(i) + " coin=" + str(coin))

        for j in range(len(ways)):
            if coin <= j:
                # Update the ways array
                index = j - coin
                ways[j] = ways[j] + ways[index]

                # print
                if debug:
                    print(
                        "j="
                        + str(j)
                        + " index="
                        + str(index)
                        + " ways="
                        + listToString(ways)
                    )

    # print
    if debug:
        print()

    return ways[N]


def main():
    N = 12
    coins = (1, 2, 5, 10)
    result = solution(N, coins)
    print("Result=" + str(result))


if __name__ == "__main__":
    main()
