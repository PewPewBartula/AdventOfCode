gamma = ""
epsilon = ""
n = 0
zeros = 0
ones = 0
bits = 0

with open("input.txt") as f:
    data = f.readlines()

for line in data:
    n += 1

bits = len(data[0].rstrip())

gammaRate = [0 for x in range(0,bits)]
epsilonRate = [0 for x in range(0,bits)]

for x in range(0,bits):
    for y in range(0,n):
        if int(data[y][x].rstrip()) == 0:
            zeros += 1
        else: 
            ones += 1
    if zeros > ones: 
        gammaRate[x] = 0
        epsilonRate[x] = 1
    else: 
        gammaRate[x] = 1
        epsilonRate[x] = 0
    zeros = 0
    ones = 0

for x in range(0,bits):
    gamma += str(gammaRate[x])
    epsilon += str(epsilonRate[x])

print("Gamma Rate:",int(gamma,2))
print("Epsilon Rate:",int(epsilon,2))

print("Multiplied:",(int(gamma,2))*(int(epsilon,2)))