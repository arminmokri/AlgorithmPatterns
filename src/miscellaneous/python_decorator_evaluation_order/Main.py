"""
Problem: Python Decorator Evaluation Order

This example demonstrates when a decorator function is executed and how it affects the decorated function.

Key points:
1. When Python reaches the line `@deco`, it *immediately executes* `deco(func)`, passing in `func` as the argument.
2. The `print("hi")` inside `deco` runs at decoration time — *not* when `func()` is later called.
3. The original `func` is returned by `deco`, so its behavior remains unchanged.

Output will be:
hi
A
B

Explanation:
- "hi" is printed when Python sees `@deco` during definition.
- "A" and "B" are printed when `func("A")` and `func("B")` are executed normally.
"""


def deco(func):
    print("hi")
    return func


@deco
def func(param):
    print(param)


func("A")
func("B")
