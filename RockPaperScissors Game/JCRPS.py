import random

run = True
print("Welcome to Rock, Paper, Scissors!")
playerScore = 0
cpuScore = 0


while True:
    player = input("\nType 'r' for Rock, 'p' for Paper, 's' for Scissors or 'q' to Quit the Game: ")
    choices = ['r','p','s']
    cpu=random.choice(choices)

    if player == cpu:
        print("\nDraw")
        print("You Both Picked " + str(cpu))

    elif(player == 'r' and cpu == 's'):
        print("\nPlayer Wins")
        print("You Picked: Rock, CPU Picked: Scissors")
        playerScore+=1

    elif(player == 'p' and cpu == 'r'):
        print("\nPlayer Wins")
        print("You Picked: Paper, CPU Picked: Rock")
        playerScore+=1

    elif(player == 's' and cpu == 'p'):
        print("\nPlayer Wins")
        print("You Picked: Scissors, CPU Picked: Paper")
        playerScore+=1

    elif(cpu == 'r' and player == 's'):
        print("\nCPU Wins")
        print("You Picked: Rock, CPU Picked: Scissors")
        cpuScore+=1

    elif(cpu == 'p' and player == 'r'):
        print("\nCPU Wins")
        print("You Picked: Paper, CPU Picked: Rock")
        cpuScore+=1

    elif(cpu == 's' and player == 'p'):
        print("\nCPU Wins")
        print("You Picked: Scissors, CPU Picked: Paper")
        cpuScore+=1

    elif(player == 'q'):
        break

    elif(player == 'Q'):
        break
    
    else:
        print("Not the Correct Input!")

    print("Score: Player " + str(playerScore) + " CPU " + str(cpuScore)) # Prints the score of the game after each round.
print("\nThanks For Playing!") # After the player quits the game, It will do these 3 prints below.
print("Final Score:")
print("Player: " + str(playerScore) + " CPU: " + str(cpuScore))
