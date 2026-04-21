cnt = 1

while True:
    s = input()
    if s == '0':
        break
    r, w, l = map(int, s.split())
    if r*2 >= (w**2 + l**2) ** 0.5:
        print(f"Pizza {cnt} fits on the table.")
        cnt += 1
    else:
        print(f"Pizza {cnt} does not fit on the table.")
        cnt += 1
