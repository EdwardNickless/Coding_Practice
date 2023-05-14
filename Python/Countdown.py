import time

number = int(input("Enter a number to countdown from: "))

for countdown in range(number, 0, -1):
    print(countdown)
    time.sleep(1)
print("Time's up!")
