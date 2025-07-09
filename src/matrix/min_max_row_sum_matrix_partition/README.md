Title: Min Max Row Sum Matrix Partition

You are given an array of integers of a non prime length. Your task is to partition the array into a matrix with 2 dimensions(rows and columns both >1) while preserving the order of the elements.
The goal is to find the matrix dimensions that minimize the maximum row sum.

You should return the matrix dimensions (n,p) that minimize the maximum row sum.

Example:
array :  [1,1,1,20,1,1,1,1,30,5,1,1].
possible matrices:

[1,1,1,20,1,1] // 25
[1,1,30,5,1,1] // 39
maximum row sum = 39

[1,1,1,20]
[1,1,1,1]
[30,5,1,1] // 37
maximum row sum = 37

[1,1,1]
[20,1,1]
[1,1,30]
[5,1,1]
maximum row sum = 32

[1,1]
[1,20]
[1,1]
[1,1]
[30,5]
[1,1]
maximum row sum = 35

the solution should be (4,3)
