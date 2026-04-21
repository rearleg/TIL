import sys

input = sys.stdin.readline
while True:
    s = input().rstrip()
    if s == ".":
        break
    lst = []
    check = True

    for i in s:
        if i == '(' or i == '[':
            lst.append(i)
        
        elif i == ")":
            if not lst or lst[-1] != "(":
                check = False
                break
            else:
                lst.pop()
        elif i == "]":
            if not lst or lst[-1] != "[":
                check = False
                break
            else:
                lst.pop()
    
    if check and not lst:
        print('yes')
    else:
        print('no')