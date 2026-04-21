import sys

lines = sys.stdin.readlines()[1:]
lines.sort(key=lambda x: (int(x.split()[1]), (int(x.split()[0]))))
print(''.join(lines))
