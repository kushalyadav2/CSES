#include <iostream>
#include <set>

using namespace std;

int main() {
    int n, m;
    cin >> n >> m;

    multiset<int> tickets;

    for (int i = 0; i < n; ++i) {
        int price;
        cin >> price;
        tickets.insert(price);
    }

    for (int i = 0; i < m; ++i) {
        int customer;
        cin >> customer;

        // Find the upper_bound of customer's price, then step back
        auto it = tickets.upper_bound(customer);
        if (it == tickets.begin()) {
            cout << -1 << endl;
        } else {
            --it;
            cout << *it << endl;
            tickets.erase(it); // Remove one occurrence
        }
    }

    return 0;
}
