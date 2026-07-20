class Solution {
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        boolean[][] visited = new boolean[n][n];

        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        minHeap.offer(new int[]{grid[0][0], 0, 0});
        visited[0][0] = true;

        int result = 0;
        int[][] dirs = {{0,1}, {0,-1},{1,0},{-1,0}};

        while(!minHeap.isEmpty()) {
            int[] curr = minHeap.poll();
            int elev = curr[0], r = curr[1], c = curr[2];

            result = Math.max(result, elev);

            if(r == n-1 && c == n-1) {
                return result;
            }

            for(int[]dir : dirs) {
                int nr = r + dir[0];
                int nc = c + dir[1];
                if (nr < 0 || nr >= n || nc < 0 || nc >= n) {
                    continue;
                }
                if(visited[nr][nc]) {
                    continue;
                }
                visited[nr][nc] = true;
                minHeap.offer(new int[]{grid[nr][nc], nr, nc});
            }
        }
        return result;
    }
}
