while True:
    a, b, c = map(int, input().split())
    if a == 0 and b == 0 and c == 0:
        break
    nums = [a, b, c]
    nums.sort()

    if nums[0]**2 + nums[1]**2 == nums[2]**2:
        print('right')
    else:
        print('wrong')