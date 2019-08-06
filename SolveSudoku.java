import java.util.stream.IntStream;

public class SolveSudoku {
    public boolean solve(int [][] table)
    {
        for (int row = 0; row < 9; row ++)
        {
            for (int column = 0; column < 9; column++)
            {
                if (table[row][column] == 0)
                {
                    for (int k = 1; k <= 9; k++)
                    {
                        table[row][column]=k;
                        if(isValid(table, row, column) && solve(table))
                        {
                            return true;
                        }
                        table[row][column] = 0;
                    }
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isValid(int[][] table, int row, int column)
    {
        return (rowConstraint(table, row) && columnConstraint(table, column) && subsectionConstraint(table, row, column));
    }

    private boolean rowConstraint(int[][] table, int row)
    {
        boolean[] constraint = new boolean[9];
        return IntStream.range(0, 9).allMatch(column -> checkConstraint(table, row, constraint, column));
    }

    private boolean columnConstraint(int[][] table, int column)
    {
        boolean[] constraint = new boolean[9];
        return IntStream.range(0, 9).allMatch(row -> checkConstraint(table, row, constraint, column));
    }

    private boolean subsectionConstraint(int[][] table, int row, int column) {
        boolean[] constraint = new boolean[9];
        int subsectionRowStart = (row / 3) * 3;
        int subsectionRowEnd = subsectionRowStart + 3;

        int subsectionColumnStart = (column / 3) * 3;
        int subsectionColumnEnd = subsectionColumnStart + 3;

        for (int r = subsectionRowStart; r < subsectionRowEnd; r++) {
            for (int c = subsectionColumnStart; c < subsectionColumnEnd; c++) {
                if (!checkConstraint(table, r, constraint, c)) return false;
            }
        }
        return true;
    }

    private boolean checkConstraint(int[][] table, int row,boolean[] constraint, int column) {
        if (table[row][column] != 0) {
            if (!constraint[table[row][column] - 1]) {
                constraint[table[row][column] - 1] = true;
            } else {
                return false;
            }
        }
        return true;
    }
}
