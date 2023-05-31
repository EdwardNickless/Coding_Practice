display=[
    ['### ','  # ','### ','### ','# # ','### ','### ','### ','### ','### '],
    ['# # ','  # ','  # ','  # ','# # ','#   ','#   ','  # ','# # ','# # '],
    ['# # ','  # ','### ','### ','### ','### ','### ','  # ','### ','### '],
    ['# # ','  # ','#   ','  # ','  # ','  # ','# # ','  # ','# # ','  # '],
    ['### ','  # ','### ','### ','  # ','### ','### ','  # ','### ','  # ']
    ]

input_pass=False
numbers_list=[]
digits=['0','1','2','3','4','5','6','7','8','9']

while not input_pass:
    user_input=input("Enter a sequence of digits(integers only).. ")
    for char in user_input:	
        if char not in digits:
            fail=True
            break
        else:
            number=int(char)
            numbers_list.append(number)
            fail=False
    if fail==False:
        input_pass=True

for row in range(5):
    for digit in numbers_list:
        print(display[row][digit],end='')
    print('')
