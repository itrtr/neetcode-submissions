class Solution {
    public boolean isValidSudoku(char[][] board) {
        int N = 9;
        HashSet<Character>[] rows = new HashSet[N];
        HashSet<Character>[] cols = new HashSet[N];
        HashSet<Character>[] boxes = new HashSet[N];
        
        for(int i=0; i<N; ++i) {
            rows[i] = new HashSet<>();
            cols[i] = new HashSet<>();
            boxes[i] = new HashSet<>();
        }

        for(int i=0; i<N; ++i) {
            for(int j=0; j<N; ++j) {
                char c = board[i][j];
                if (c == '.') continue;
                if (rows[i].contains(c)) return false;
                rows[i].add(c);
                if (cols[j].contains(c)) return false;
                cols[j].add(c);
                int boxi = (i/3)*3 + (j/3);
                if (boxes[boxi].contains(c)) return false;
                boxes[boxi].add(c);
            }
        }
        return true;
    }
}
