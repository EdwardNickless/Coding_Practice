'''
Encodes a secret message by shifting each character by the given number.

For example, "abc" and 1 returns "bcd"
'''
# Get secret message from the user
cipher = input("Enter your cryptogram.. ")

# Initialise variables
shift_values = ['1','2','3','4','5','6','7','8','9','10',
                '11','12','13','14','15','16','17','18','19','20',
                '21','22','23','24','25']
shifting = False
text = ''

# Get the number of places to shift each character
while not shifting:
    shift = input("How far do you want to shift (1 - 25)?")
    if shift in shift_values:
        shift = int(shift)
        shifting = True

# Encode the secret message
for char in cipher:
    # Current character is not alphabetical
    if not char.isalpha():
        text += char
        continue

    # Current charcter is upper case
    if ord(char) <91:
        if (ord(char) + shift) > 90:
            code = ord('A') + (shift - (90 - ord(char) + 1))
        else:
            code = ord(char) + shift
                
    # Current character is lower case    
    elif ord(char) > 96:
        if (ord(char) + shift) > 122:
            code = ord('a') + (shift - (122 - ord(char) + 1))
        else:
            code = ord(char) + shift     
    
    # Append the shifted character to the ouotput string
    text += chr(code)

#Output the encoded message
print(text)
