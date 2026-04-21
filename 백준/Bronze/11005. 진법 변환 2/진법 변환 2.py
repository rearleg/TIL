n, m = map(int, input().split())

def to_base(n, base):
    digits = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ"

    if n == 0:
        return("0")
    
    result = ""

    while n > 0:
        r = n % base
        result = digits[r] + result
        n //= base
    
    return result

print(to_base(n, m))