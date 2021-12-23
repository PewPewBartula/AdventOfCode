horizontal = 0
depth = 0
n = 0
separated = []

with open("input.txt") as f:
    data = f.readlines()

for line in data:
    n += 1

for x in range(0, n):
    separated.append([0 for y in range(0,2)])
    separated[x] = data[x].split()
    if separated[x][0] == "forward":
        horizontal += int(separated[x][1])
    if separated[x][0] == "down":
        depth += int(separated[x][1])
    if separated[x][0] == "up":
        depth -= int(separated[x][1])

print("Horizontal = ",(horizontal))
print("Depth = ",(depth))

print("Multiplied = ",(depth*horizontal))