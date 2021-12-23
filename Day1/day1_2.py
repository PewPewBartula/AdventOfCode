#!/usr/bin/env python3
# -*- coding: utf-8 -*-

prevThree = 0
nextThree = 0
increased = 0
n = 0

with open("input.txt") as f:
    data = f.readlines()

for line in data:
    n += 1

for x in range(3):
    prevThree += int(data[x].rstrip())

for x in range(0,n-3):
    nextThree = prevThree - int(data[x].rstrip()) + int(data[x+3].rstrip())
    if prevThree < nextThree:
        increased += 1
    prevThree = nextThree

print(increased)