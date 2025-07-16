import bisect
from collections import Counter

n, m = map(int, input().split())
tickets = list(map(int, input().split()))
customers = list(map(int, input().split()))

tickets.sort()
counter = Counter(tickets)

for price in customers:
    idx = bisect.bisect_right(tickets, price) - 1  # max ticket <= price
    if idx < 0:
        print(-1)
    else:
        ticket = tickets[idx]
        print(ticket)
        counter[ticket] -= 1
        if counter[ticket] == 0:
            tickets.pop(idx)  # remove one occurrence
