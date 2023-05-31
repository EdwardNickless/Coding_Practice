'''
Looks for the presence of the first string within the second string

Prints "Yes" if found, otherwise prints "No"
'''

string_1 = list(input("Enter the first string.. "))
string_2 = input("Enter the second string.. ")
position = 0
presence = "Yes"

for letter in string_1:
    position = string_2.find(letter, position, len(string_2))
    if position < 0:
        presence = "No"
        break

print(presence)
