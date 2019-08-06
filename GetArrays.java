import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class GetArrays
{
    public String fileName1;
    public int[][]arr_problem1 = new int[9][9];
    public int[][]arr1 = new int[9][9];
    public int[][]game_over1 = new int[9][9];

    public GetArrays(){}
    public GetArrays(String fileName)
    {
        fileName1 = fileName;
        Scanner read = null;
        try
        {
            read = new Scanner(new FileInputStream(fileName));
        }
        catch (FileNotFoundException e)
        {
            System.out.println("Unable to open files");
        }

        int[][] arr = new int [9][9];
        int temp = 0;
        for (int i =0; i<9; i++)
        {
            for (int j = 0; j<9; j++)
            {
                temp = read.nextInt();
                arr[i][j] = temp;
            }
        }
        read.close();

        int[][] arr_problem = new int [9][9];
        int[][] game_over = new int[9][9];
        for (int z = 0; z<9; z++)
        {
            for (int v = 0; v<9; v++)
            {
                arr_problem[z][v] = arr[z][v];
                game_over[z][v] = arr[z][v];
            }
        }


        SolveSudoku obj = new SolveSudoku();
        boolean abc = obj.solve(arr);

        for (int i = 0; i<9;i++)
        {
            for (int j = 0; j<9 ; j++)
            {
                arr_problem1[i][j] = arr_problem[i][j];
                arr1[i][j] = arr[i][j];
                game_over1[i][j] = game_over[i][j];
            }
        }
    }
}
