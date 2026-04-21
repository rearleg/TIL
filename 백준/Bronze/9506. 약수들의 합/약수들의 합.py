while True:
    n = int(input())
    l = []
    if n == -1:
        break
    else:
        for i in range(2, n):
            if n % i == 0:
                l.append(i)
        if sum(l) + 1 == n:
            print(f"{n} = 1", end=" ")
            for i in l:
                print(f"+ {i}", end=" ")
            print()
        else:
            print(f"{n} is NOT perfect.")
