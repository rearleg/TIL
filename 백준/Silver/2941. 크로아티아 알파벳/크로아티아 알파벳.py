lst = ['c=', 'c-', 'dz=', 'd-', 'lj', 'nj', 's=','z=']
cnt = 0
string = input()
while len(string) > 0 :
    if string[0:3] in lst:
        string = string[3:]
        cnt += 1

    elif string[0:2] in lst:
        string = string[2:]
        cnt += 1
        
    else:
        string = string[1:]
        cnt += 1

print(cnt)