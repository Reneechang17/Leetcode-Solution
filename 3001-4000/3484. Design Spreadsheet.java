class Spreadsheet {

    private class CellPosition {
        int row, col;

        CellPosition(String cell) {
            this.col = cell.charAt(0) - 'A';
            this.row = Integer.parseInt(cell.substring(1)) - 1;
        }
    }

    private int[][] grid;

    public Spreadsheet(int rows) {
        this.grid = new int[rows][26];
    }
    
    public void setCell(String cell, int value) {
        CellPosition pos = new CellPosition(cell);
        grid[pos.row][pos.col] = value;
    }

    public void resetCell(String cell) {
        setCell(cell, 0);
    }
    
    public int getValue(String formula) {
        formula = formula.substring(1);
        String[] tokens = formula.split("\\+");
        return evaluate(tokens[0]) + evaluate(tokens[1]);
    }

    private int evaluate(String token) {
        if (Character.isLetter(token.charAt(0))) {
            CellPosition pos = new CellPosition(token);
            return grid[pos.row][pos.col];
        }
        return Integer.parseInt(token);
    }
}
