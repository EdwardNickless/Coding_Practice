checking = True
i = 0
message = "Is an anagram"

text_1 = list(input("Enter your first line of text.. ").lower())
text_2 = list(input("Enter your second line of text.. ").lower())

while (i <  len(text_1)) and checking:
    char = text_1[i]
    if char in text_2:
        text_2.remove(char)
    else:
        message = "Is not an anagram"
        checking = False
    i += 1

print(message)
