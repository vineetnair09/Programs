
import sys
import random
list=[];
while len(list) <= 1000000:
    num =random.randint(0, 1000000)
    list.append(num)
with open ("Input_1000K_Int.txt","w")as fp:
        for line in list:
            fp.write(str(line)+"\n")
