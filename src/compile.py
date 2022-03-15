alphabet = "abcdefghijklmnopqrstuvwxyz"
brainfuck = str(input("")).split(".")

index = 0

output = {}

for statement in brainfuck:

    index2 = 0

    for char in statement:

        if char == "+":

            index2 = index2 + 1
            result = alphabet[index2-1:index2]

        if char == "-":

            index2 = index2 - 1
            result = alphabet[index2-1:index2-1]
    
    index = index + 1
    output[index] = result

print(output)