from random import randint
'''
Simulates playing the lottery

Prints each lottery number and corresponding user guess in turn
and then prints all lottery numbers and user guesses on a sepaarte line
Prints the numebr of correct guesses
'''

global lottery
lottery = []
global guesses
guesses = []


for x in range(7):
    x =randint(0,100)
    lottery.append(x)

def user_guess():
    input_test = False
    while input_test == False:
        guess = input("Enter your number (1-100): ")
        if guess.isdigit():
            guesses.append(int(guess))
            input_test = True
    return

def compare_lists(lot, num):
    correct_num = 0
    for item in range(len(lot)):
        print('Lottery: ',lot[item],' / User guess: ',num[item],sep='')
        if lot[item] == num[item]:
            correct_num += 1
        else:
            continue
    return correct_num

for x in range(7):
    user_guess()

score = compare_lists(lottery, guesses)
print(lottery,'\n',guesses, sep='')
print("You correctly guessed ", score, "!", sep='')
