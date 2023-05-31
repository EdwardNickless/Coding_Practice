'''
Simulates a game of Naughts and Crosses (tic-tac-toe)
Not very difficult to win
'''
from random import randrange
import time

board = [
    [1,2,3],
    [4,5,6],
    [7,8,9]
    ]


def display_board(board):
    # The function accepts one parameter containing the board's current status
    # and prints it out to the console.
    for row in board:
        print("+-------"*3+"+",end="\n")
        print("|       "*3+"|",end="\n")

        for slot in row:
            print("|   ",end="")
            if slot == 'X':
                print("X   ",end="")
            elif slot == 'O':
                print("O   ",end="")
            else:
                print(slot,"  ",end="")

        print("|",end="")
        print("\n",end="")
        print("|       "*3+"|",end="\n")

    print("+-------"*3 + "+",end="\n")
    print("")
    return


def enter_move(board):
    # The function accepts the board current status, asks the user about their move, 
    # checks the input and updates the board according to the user's decision.

    while True:
        user_move = input("Choose a space (1-9).. ")
        print("")
        slot_num = 0
        
        if user_move == "":
            continue
        elif int(user_move) not in free_fields:
            continue            
        else:
            user_move = int(user_move)            
            for row in board:                
                if user_move not in row:
                    continue                
                else:
                    for slot in row:                        
                        if user_move == slot:
                            del row[slot_num]
                            row.insert(slot_num, player_sign)
                            return                        
                        else:
                            slot_num +=1
    return


def make_list_of_free_fields(board):
    # The function browses the board and builds a list of all the free squares; 
    # the list consists of tuples, while each tuple is a pair of row and column numbers.
    global free_fields
    free_fields=[]

    for row in board:
        for slot in row:
            if slot != 'X' and slot != 'O':
                free_fields.append(slot)
            else:
                continue    
    return


def victory_for(board, sign):
    # The function analyzes the board status in order to check if 
    # the player using 'O's or 'X's has won the game
    
    if board[0][0] == sign and\
       board[0][1] == sign and\
       board[0][2] == sign:
        return True
    elif board[1][0] == sign and\
         board[1][1] == sign and\
         board[1][2] == sign:
        return True
    elif board[2][0] == sign and\
         board[2][1] == sign and\
         board[2][2] == sign:
        return True
    elif board[0][0] == sign and\
         board[1][0] == sign and\
         board[2][0] == sign:
        return True
    elif board[0][1] == sign and\
         board[1][1] == sign and\
         board[2][1] == sign:
        return True
    elif board[0][2] == sign and\
         board[1][2] == sign and\
         board[2][2] == sign:
        return True
    elif board[0][0] == sign and\
         board[1][1] == sign and\
         board[2][2] == sign:
        return True
    elif board[0][2] == sign and\
         board[1][1] == sign and\
         board[2][0] == sign:
        return True
    
    return False


def draw_move(board):
    # The function draws the computer's move and updates the board.
    while True:
        comp_move = int(randrange(10))
        slot_num = 0
        
        if comp_move not in free_fields:
            continue            
        else:
                        
            for row in board:                
                if comp_move not in row:
                    continue                
                else:
                    for slot in row:                        
                        if comp_move == slot:
                            del row[slot_num]
                            row.insert(slot_num, comp_sign)
                            return                        
                        else:
                            slot_num +=1
    return


def ask_user():
    #Asks the player if they would like to play again when the game has finished. 
    global choice
    choice_made = False
    user_input = ""
    
    while choice_made == False:
        user_input = input("Play again? ")
        print("")

        if user_input == 'y' or user_input == 'Y':
            choice = 'Y'
            choice_made = True

        elif user_input == 'n' or user_input == 'N':
            choice = 'N'
            choice_made = True
            
        else:
            continue

    return choice


def whos_move():
    secret_num = randrange(10)
    check = True
    
    while check == True:
        user_guess = input("Guess a number (1 - 10).. ")
        print("")
        comp_guess = randrange(10)
        
        if user_guess == "":
            continue
        else:
            user_guess = int(user_guess)
            if user_guess < 1 or user_guess > 10:
                continue
            else:
                user_distance = secret_num - user_guess
                comp_distance = secret_num - comp_guess

                if comp_distance > user_distance:
                    player1 = 'user'
                    print("You go first.. \n")
                    time.sleep(0.75)
                    check = False
                    
                elif comp_distance < user_distance:
                    player1 = 'comp'
                    print("I go first.. \n")
                    time.sleep(0.75)
                    check = False
                    
                else:
                    print("\nNo winner.. Go again...\n")
                    continue
    return player1


def sign_option():
    global player_sign
    player_sign = []
    options = ['O','X','o','x']
    decided = False
    
    while not decided:
        user_choice = input("Which sign would you like to play with? (X or O)")
        user_choice=str(user_choice)
        print(user_choice)
        
        if user_choice not in options:
            print("Invalid choice..")
            continue
        elif user_choice == 'X' or user_choice == 'x':
            player_sign = 'X'
            decided = False
            return player_sign
        
        elif user_choice == 'O' or user_choice == 'o':
            player_sign = 'O'
            decided = False
            return player_sign


make_list_of_free_fields(board)
play = 'Y'
game = 'Y'

print("A random number has been generated..\nWe both guess a number and whoever is closest takes the first move.\n")

while play == 'Y':
    turn = whos_move()
    player_sign = sign_option()
    if player_sign == 'X':
        comp_sign = 'O'
    elif player_sign == 'O':
        comp_sign = 'X'
    board = [
            [1,2,3],
            [4,5,6],
            [7,8,9]
            ]
    make_list_of_free_fields(board)
    turn_count = 0
    comp_turn_count = 0
    
    while game == 'Y':
        if turn == 'user':
            if turn_count == 0 and comp_turn_count == 0:
                display_board(board)
            enter_move(board)
            turn_count+=1
            make_list_of_free_fields(board)

            if free_fields==[] and game == 'Y' and\
               not victory_for(board, comp_sign) and\
               not victory_for(board, player_sign):
                print("\nIt's a Tie..\n")
                game = 'N'

            if victory_for(board, player_sign):
                display_board(board)
                print("You Win!\n","You did it in ",turn_count," turns!",sep="")
                game = 'N'

            turn = 'comp'

                
        elif turn == 'comp':
            draw_move(board)
            print("\nMy turn.. \n")
            time.sleep(0.75)
            display_board(board)
            comp_turn_count +=1
            make_list_of_free_fields(board)

            if free_fields==[] and game == 'Y' and\
               not victory_for(board, comp_sign) and\
               not victory_for(board, player_sign):
                print("\nIt's a Tie..\n")
                game = 'N'
                
            if victory_for(board, comp_sign):
                print("\nYou Lose..\n")
                game = 'N'
                

            turn = 'user'    

        
    play_again = ask_user()
    game = play_again
    play = play_again
