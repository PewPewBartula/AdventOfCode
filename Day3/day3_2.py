
with open("input.txt") as f:
    data = f.readlines()

data1 = data.copy()

bits = len(data[0].rstrip())

def numberOfLines(data):
    n = 0
    for line in data:
        n += 1
    return n

def oxygen_rating(data):
    i = 0
    zeros = 0
    ones = 0
    newData = []
    for x in range(0,bits):
        n = numberOfLines(data)
        for y in range(0,n):
            if int(data[y][x].rstrip()) == 0:
                zeros += 1
            else: 
                ones += 1    
        if ones >= zeros:
            for y in range(0,n):
                if int(data[y][i].rstrip()) == 1:
                    newData.append(data[y].rstrip())
        else:
            for y in range(0,n):
                if int(data[y][i].rstrip()) == 0:
                    newData.append(data[y].rstrip())

        data.clear()
        data = newData.copy()
        newData.clear()
        if(len(data)==1):
            return data[0]
        else:
            i += 1
            zeros = 0
            ones = 0

def co2_rating(data):
    i = 0
    zeros = 0
    ones = 0
    newData = []
    for x in range(0,bits):
        n = numberOfLines(data)
        for y in range(0,n):
            if int(data[y][x].rstrip()) == 0:
                zeros += 1
            else: 
                ones += 1    
        if zeros > ones:
            for y in range(0,n):
                if int(data[y][i].rstrip()) == 1:
                    newData.append(data[y].rstrip())
        if zeros <= ones:
            for y in range(0,n):
                if int(data[y][i].rstrip()) == 0:
                    newData.append(data[y].rstrip())

        data.clear()
        data = newData.copy()
        newData.clear()
        if(len(data)==1):
            return data[0]
        else:
            i += 1
            zeros = 0
            ones = 0

print("CO2 rate:",int(co2_rating(data),2))
print("Oxygen rate:",int(oxygen_rating(data1),2))
