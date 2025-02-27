# Enter message in the 'input.txt' file
# You can use spaces and several lines
# You can even use capital letters but it won't make a difference
# Then just copy the output from the 'output.txt' file and paste that into discord

with open('input.txt') as f:
    o = open('output.txt', 'w')
    for line in f:
        for char in line:
            if char != '\n':
                if char == ' ':
                    o.write('   ')
                else:
                    o.write(':regional_indicator_' + str(char.lower()) + ': ')
        o.write('\n')