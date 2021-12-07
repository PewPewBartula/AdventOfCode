#!/usr/bin/env python3
# -*- coding: utf-8 -*-

increased = 0

with open("input.txt") as f:
    data = f.readlines()

first = int(data[0].rstrip())
for line in data:
    if line==data[0]:
        continue
    line = int(line.rstrip())
    if first < line:
        increased+=1
    first = line

print(increased)
