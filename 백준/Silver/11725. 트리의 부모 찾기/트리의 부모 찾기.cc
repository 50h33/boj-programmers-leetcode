#include <bits/stdc++.h>
using namespace std;
int n, a, b, ans[100004];
vector<int> adj[100004];
bool visited[100004];

void dfs(int x) {
    visited[x] = 1;
    for (int nx : adj[x]) {
        if (visited[nx]) continue;
        ans[nx] = x;
        dfs(nx);
    }
}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cin >> n;
    for (int i = 0; i < n-1; i++) {
        cin >> a >> b;
        adj[a].push_back(b);
        adj[b].push_back(a);
    }

    dfs(1);

    for (int i = 2; i <= n; i++) {
        cout << ans[i] << "\n";
    }
}