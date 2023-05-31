'''
Removes vowels from a users name (or any string)
'''

# Get a user submitted string
original_name = input("What is your name? ")

# Initialise variables
vowels =['a','A','e','E','i','I','o','O','u','U']
new_name = ''

# Iterate through given string, add consonants to a new string
for letter in original_name:
    if letter in vowels:
        continue
    else:
        new_name += letter

# Output string without vowels
print(new_name)
