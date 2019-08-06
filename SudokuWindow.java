import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.lang.String;
import java.awt.event.WindowListener;
import java.awt.event.WindowEvent;


public class SudokuWindow extends JFrame
{
    public static final int smallWIDTH = 300;
    public static final int smallHEIGHT = 300;
    public static final int NUMBER_OF_CHAR = 1;



    private class CheckOnExit extends GetArrays implements WindowListener
    {
        private GetArrays array_instance = new GetArrays();
        public CheckOnExit(){}
        public CheckOnExit(String filename, int[][]arrquestion, int[][]arrsolution)
        {
            array_instance.fileName1 = filename;
            for (int i=0;i<9;i++)
            {
                for(int j=0;j<9;j++)
                {
                    array_instance.arr_problem1[i][j] = arrquestion[i][j];
                    array_instance.arr1[i][j] = arrsolution[i][j];
                }
            }
        }
        public void windowOpened(WindowEvent e){}
        public void windowClosing(WindowEvent e)
        {
            ConfirmWindow checkers = new ConfirmWindow(array_instance.fileName1, array_instance.arr1, array_instance.arr_problem1);
            checkers.setVisible(true);
        }
        public void windowClosed(WindowEvent e){}
        public void windowIconified(WindowEvent e){}
        public void windowDeiconified(WindowEvent e){}
        public void windowDeactivated(WindowEvent e){}
        public void windowActivated(WindowEvent e){}
    }

    private class ConfirmWindow extends JFrame
    {
        public ConfirmWindow() {
        }

        public ConfirmWindow(String fileName1, int[][] arr1, int[][] arr_problem1)
        {
            super("Answer Key");
            setSize(smallWIDTH, smallHEIGHT);
            if (fileName1.equals("samplesudoku1.txt"))
            {
                setLocation(300,100);
            }
            else if (fileName1.equals("samplesudoku2.txt"))
            {
                setLocation(300,400);
            }
            else if (fileName1.equals("samplesudoku3.txt"))
            {
                setLocation(900,100);
            }
            else if (fileName1.equals("samplesudoku4.txt"))
            {
                setLocation(900,400);
            }
            JPanel panel1 = new JPanel();
            panel1.setLayout(new GridLayout(3,3));
            panel1.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));

            JPanel subPanel11 = new JPanel();
            subPanel11.setLayout(new GridLayout(3,3));
            subPanel11.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            JPanel subPanel12 = new JPanel();
            subPanel12.setLayout(new GridLayout(3,3));
            subPanel12.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            JPanel subPanel13 = new JPanel();
            subPanel13.setLayout(new GridLayout(3,3));
            subPanel13.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            JPanel subPanel14 = new JPanel();
            subPanel14.setLayout(new GridLayout(3,3));
            subPanel14.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            JPanel subPanel15 = new JPanel();
            subPanel15.setLayout(new GridLayout(3,3));
            subPanel15.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            JPanel subPanel16 = new JPanel();
            subPanel16.setLayout(new GridLayout(3,3));
            subPanel16.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            JPanel subPanel17 = new JPanel();
            subPanel17.setLayout(new GridLayout(3,3));
            subPanel17.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            JPanel subPanel18 = new JPanel();
            subPanel18.setLayout(new GridLayout(3,3));
            subPanel18.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            JPanel subPanel19 = new JPanel();
            subPanel19.setLayout(new GridLayout(3,3));
            subPanel19.setBorder(BorderFactory.createLineBorder(Color.BLACK));

            int num1;
            int num2;
            for (int row = 0; row<9; row++) {
                for (int column = 0; column < 9; column++) {
                    num1 = arr_problem1[row][column];
                    num2 = arr1[row][column];
                    JTextField piece = new JTextField(NUMBER_OF_CHAR);
                    piece.setHorizontalAlignment(JTextField.CENTER);

                    if (arr_problem1[row][column] != 0) {
                        piece.setText(Integer.toString(num1));
                        piece.setEditable(false);
                    }
                    else
                    {
                        piece.setText(Integer.toString(num2));
                        piece.setForeground(Color.GREEN);
                        piece.setEditable(false);
                    }
                    piece.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
                    if (row <= 2 && column <= 2) {
                        subPanel11.add(piece);
                    } else if (row <= 2 && column <= 5) {
                        subPanel12.add(piece);
                    } else if (row <= 2) {
                        subPanel13.add(piece);
                    } else if (row <= 5 && column <= 2) {
                        subPanel14.add(piece);
                    } else if (row <= 5 && column <= 5) {
                        subPanel15.add(piece);
                    } else if (row <= 5) {
                        subPanel16.add(piece);
                    } else if (column <= 2) {
                        subPanel17.add(piece);
                    } else if (column <= 5) {
                        subPanel18.add(piece);
                    } else {
                        subPanel19.add(piece);
                    }
                }
            }
            panel1.add(subPanel11);
            panel1.add(subPanel12);
            panel1.add(subPanel13);
            panel1.add(subPanel14);
            panel1.add(subPanel15);
            panel1.add(subPanel16);
            panel1.add(subPanel17);
            panel1.add(subPanel18);
            panel1.add(subPanel19);
            add(panel1);
        }
    }







    public SudokuWindow() {}
    public SudokuWindow(GetArrays arrayClass)
    {
        super("Sudoku Board");

        CountTime counttime = new CountTime();
        counttime.start();

        if (arrayClass.fileName1.equals("samplesudoku1.txt"))
        {
            setLocation(300,100);
        }
        else if (arrayClass.fileName1.equals("samplesudoku2.txt"))
        {
            setLocation(300,400);
        }
        else if (arrayClass.fileName1.equals("samplesudoku3.txt"))
        {
            setLocation(900,100);
        }
        else if (arrayClass.fileName1.equals("samplesudoku4.txt"))
        {
            setLocation(900,400);
        }

        setSize(smallWIDTH, smallHEIGHT);
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3,3));
        panel.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));

        JPanel subPanel1 = new JPanel();
        subPanel1.setLayout(new GridLayout(3,3));
        subPanel1.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        JPanel subPanel2 = new JPanel();
        subPanel2.setLayout(new GridLayout(3,3));
        subPanel2.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        JPanel subPanel3 = new JPanel();
        subPanel3.setLayout(new GridLayout(3,3));
        subPanel3.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        JPanel subPanel4 = new JPanel();
        subPanel4.setLayout(new GridLayout(3,3));
        subPanel4.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        JPanel subPanel5 = new JPanel();
        subPanel5.setLayout(new GridLayout(3,3));
        subPanel5.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        JPanel subPanel6 = new JPanel();
        subPanel6.setLayout(new GridLayout(3,3));
        subPanel6.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        JPanel subPanel7 = new JPanel();
        subPanel7.setLayout(new GridLayout(3,3));
        subPanel7.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        JPanel subPanel8 = new JPanel();
        subPanel8.setLayout(new GridLayout(3,3));
        subPanel8.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        JPanel subPanel9 = new JPanel();
        subPanel9.setLayout(new GridLayout(3,3));
        subPanel9.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        int num;
        for (int row = 0; row<9; row++)
        {
            for (int column = 0; column < 9; column++)
            {
                num = arrayClass.arr_problem1[row][column];
                JTextField piece = new JTextField(NUMBER_OF_CHAR);
                piece.setHorizontalAlignment(JTextField.CENTER);

                if (arrayClass.arr_problem1[row][column] != 0)
                {
                    piece.setText(Integer.toString(num));
                    piece.setEditable(false);
                }
                piece.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
                if (row <= 2 && column <= 2)
                {
                    subPanel1.add(piece);
                }
                else if (row <= 2  && column <= 5)
                {
                    subPanel2.add(piece);
                }
                else if (row <= 2)
                {
                    subPanel3.add(piece);
                }
                else if (row <= 5 && column <= 2)
                {
                    subPanel4.add(piece);
                }
                else if (row <= 5 && column <= 5)
                {
                    subPanel5.add(piece);
                }
                else if (row <= 5)
                {
                    subPanel6.add(piece);
                }
                else if (column <= 2)
                {
                    subPanel7.add(piece);
                }
                else if (column <= 5)
                {
                    subPanel8.add(piece);
                }
                else
                {
                    subPanel9.add(piece);
                }
                int temp_row = row;
                int temp_column = column;
                piece.addKeyListener(new KeyAdapter()
                {
                    @Override
                    public void keyPressed(KeyEvent e)
                    {
                        if(e.getKeyCode() == KeyEvent.VK_ENTER)
                        {
                            String input = piece.getText();
                            int int_input = Integer.parseInt(input);
                            if (int_input == arrayClass.arr1[temp_row][temp_column])
                            {
                                piece.setEditable(false);
                                piece.setForeground(Color.GREEN);
                                arrayClass.game_over1[temp_row][temp_column] = int_input;
                            } else
                                {
                                piece.setForeground(Color.BLUE);
                            }
                            boolean check = true;
                            for (int i = 0; i<9; i++)
                            {
                                for (int j = 0; j<9;j++)
                                {
                                    if (arrayClass.game_over1[i][j] != arrayClass.arr1[i][j])
                                    {
                                        check = false;
                                    }
                                }
                            }
                            if (check)
                            {
                                counttime.stop();
                                if (arrayClass.fileName1.equals("samplesudoku1.txt"))
                                {
                                    CongratWindow congrat = new CongratWindow(1, counttime.seconds);
                                    congrat.setVisible(true);
                                }
                                else if (arrayClass.fileName1.equals("samplesudoku2.txt"))
                                {
                                    CongratWindow congrat = new CongratWindow(2, counttime.seconds);
                                    congrat.setVisible(true);
                                }
                                else if (arrayClass.fileName1.equals("samplesudoku3.txt"))
                                {
                                    CongratWindow congrat = new CongratWindow(3, counttime.seconds);
                                    congrat.setVisible(true);
                                }
                                else if (arrayClass.fileName1.equals("samplesudoku4.txt"))
                                {
                                    CongratWindow congrat = new CongratWindow(4, counttime.seconds);
                                    congrat.setVisible(true);
                                }
                            }
                        }
                    }
                });
            }
        }

        panel.add(subPanel1);
        panel.add(subPanel2);
        panel.add(subPanel3);
        panel.add(subPanel4);
        panel.add(subPanel5);
        panel.add(subPanel6);
        panel.add(subPanel7);
        panel.add(subPanel8);
        panel.add(subPanel9);
        add(panel);
        addWindowListener(new CheckOnExit(arrayClass.fileName1, arrayClass.arr_problem1, arrayClass.arr1));
    }
}
