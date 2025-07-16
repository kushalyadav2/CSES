#include <iostream>
#include <vector>
#include <algorithm>
#include <queue>

using namespace std;

int main() {
    int n;
    cin >> n;

    vector<pair<int, int>> arr(n);

    for (int i = 0; i < n; ++i) {
        cin >> arr[i].first >> arr[i].second; // arrival and departure
    }

    // Sort by arrival time
    sort(arr.begin(), arr.end());

    // Min-heap for tracking departure times
    priority_queue<int, vector<int>, greater<int>> pq;

    int ans = 0;

    for (int i = 0; i < n; ++i) {
        int arrival = arr[i].first;
        int departure = arr[i].second;

        // Remove customers who have already left
        while (!pq.empty() && pq.top() < arrival) {
            pq.pop();
        }

        pq.push(departure);
        ans = max(ans, (int)pq.size());
    }

    cout << ans << endl;

    return 0;
}
