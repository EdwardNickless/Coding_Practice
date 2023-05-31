'''
Prints to the console a list of numbers in the
fibonnaci sequence starting at 0

Continues until the program is interrupted by the user!
'''
def fib(n):
    if n < 1:
         return 0
    if n < 3:
        return 1

    return fib(n - 1) + fib(n - 2)

active = True
n = 0

while active:
    print(n, "->", fib(n))
    n += 1
