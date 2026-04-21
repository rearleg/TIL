import sys

input = sys.stdin.readline
arr = []
for _ in range(3):
    arr.append(input().rstrip())

last_num = None
idx = None

for i in range(len(arr)):
    if arr[i].isdigit():
        last_num = int(arr[i])
        idx = i + 1

if last_num:
    temp = 4 - idx
    tg_num = last_num + temp
    if tg_num % 3 == 0 and tg_num % 5 == 0:
        print("FizzBuzz")
    elif tg_num % 3 == 0:
        print("Fizz")
    elif tg_num % 5 == 0:
        print("Buzz")
    else:
        print(tg_num)
else:
    print(tg_num)