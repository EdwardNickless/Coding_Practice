'''
Prints all prime numbers upto a user defined limit
'''

# Tests whether a number is prime or not
def is_prime(num):
    prime = True
    for x in range (2, num):
        if num % x == 0:
            prime = False
            break
    return prime


# Get the limit from the user 
max_number = int(input("Enter a maximimum whole number using numerical characters only: "))

# Iterate upwards from 2, printing the number if it is prime
for i in range(2, max_number):
    if is_prime(i):
        print(i, end=" ")
