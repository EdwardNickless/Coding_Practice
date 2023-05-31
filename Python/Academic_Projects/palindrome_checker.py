'''
Outputs a message that informs a user if the string
that they supply is a palindrome or not
'''

# Get the users string
text = input("Enter your text here.. ")

# Convert user string to a list
text = list(text.lower())

# Initialise output message
message = "It's a palindrome"

# Iterate through the list checking if each pair
# of corresponding characters match
i=0
for char in text:
    if char==' ':
        continue
    if text[i-1] == ' ':
        i = i-1
    if char == text[i-1]:
        i = i-1
        continue
    else:
        message = "It's not a palindrome"
        break

print(message)
