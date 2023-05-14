'''
Returns a list of characters of a given string ignoring any whitespace
'''
def mysplit(string):
    
    string_list = []
    
    for letter in string:
        if not letter.isspace():
            string_list.append(letter)
    
    return string_list

# Uncomment the following line and run the file to test
# print(mysplit("Hello"))