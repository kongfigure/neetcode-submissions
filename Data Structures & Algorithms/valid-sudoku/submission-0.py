class Solution:
    def isValidSudoku(self, board: List[List[str]]) -> bool:
        rows = defaultdict(set)
        cols = defaultdict(set)
        boxes = defaultdict(set)

        for i in range(9):
            for j in range(9):
                if board[i][j] == ".":
                    continue

                val = board[i][j]
                boxIndex = (i // 3) * 3 + (j // 3)

                if val in rows[i] or val in cols[j] or val in boxes[boxIndex]:
                    return False

                rows[i].add(val)
                cols[j].add(val)
                boxes[boxIndex].add(val)

        return True