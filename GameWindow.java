import javax.swing.JFrame;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.event.WindowListener;
import java.awt.event.WindowEvent;
import java.awt.Color;

public class GameWindow extends JFrame implements ActionListener
{
    public static final int WIDTH = 300;
    public static final int HEIGHT = 400;
    public static final int small_w = 200;
    public static final int small_h = 100;

    private class CheckOnExit implements WindowListener
    {
        public void windowOpened(WindowEvent e){}
        public void windowClosing(WindowEvent e)
        {
            ConfirmWindow checkers = new ConfirmWindow();
            checkers.setVisible(true);
        }
        public void windowClosed(WindowEvent e){}
        public void windowIconified(WindowEvent e){}
        public void windowDeiconified(WindowEvent e){}
        public void windowDeactivated(WindowEvent e){}
        public void windowActivated(WindowEvent e){}
    }

    private class ConfirmWindow extends JFrame implements ActionListener
    {
        public ConfirmWindow()
        {
            setSize(small_w, small_h);
            setLocation(650,350);
            getContentPane().setBackground(Color.CYAN);
            setLayout(new BorderLayout());
            JLabel confirmlabel = new JLabel("Are you sure you want to exit?");
            add(confirmlabel, BorderLayout.CENTER);

            JPanel buttonpanel = new JPanel();
            buttonpanel.setBackground(Color.YELLOW);
            buttonpanel.setLayout(new FlowLayout());

            JButton quitbutton = new JButton("Yes");
            quitbutton.addActionListener(this);
            buttonpanel.add(quitbutton);

            JButton cancel = new JButton("No");
            cancel.addActionListener(this);
            buttonpanel.add(cancel);

            add(buttonpanel, BorderLayout.SOUTH);
        }
        public void actionPerformed(ActionEvent e)
        {
            String choose = e.getActionCommand();
            if (choose.equals("Yes"))
            {
                System.exit(0);
            }
            else if (choose.equals("No"))
            {
                dispose();
            }
            else
            {
                System.out.println("Unexpected error in ConfirmWindow");
            }
        }
    }
    public GameWindow()
    {
        super("The Sudoku Game");
        setSize(WIDTH, HEIGHT);
        setLocation(600,200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(5,1));

        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        addWindowListener(new CheckOnExit());

        JPanel explain = new JPanel();
        explain.setLayout(new GridLayout(3,1));
        JLabel rule = new JLabel("Press 'Enter' to check your input");
        rule.setHorizontalAlignment(JLabel.CENTER);
        explain.add(rule);
        JLabel rule1 = new JLabel("Turn Sudoku Board off for solution");
        rule1.setHorizontalAlignment(JLabel.CENTER);
        explain.add(rule1);

        JLabel selection = new JLabel("Select the Sudoku you want to solve:");
        selection.setHorizontalAlignment(JLabel.CENTER);
        explain.add(selection);
        add(explain);

        JButton sudoku1 = new JButton("Sudoku 1");
        sudoku1.setActionCommand("samplesudoku1.txt");
        sudoku1.addActionListener(this);


        JButton sudoku2 = new JButton("Sudoku 2");
        sudoku2.setActionCommand("samplesudoku2.txt");
        sudoku2.addActionListener(this);


        JButton sudoku3 = new JButton("Sudoku 3");
        sudoku3.setActionCommand("samplesudoku3.txt");
        sudoku3.addActionListener(this);


        JButton sudoku4 = new JButton("Sudoku 4");
        sudoku4.setActionCommand("samplesudoku4.txt");
        sudoku4.addActionListener(this);


        JPanel subFrame1 = new JPanel();
        subFrame1.add(sudoku1);
        JPanel subFrame2 = new JPanel();
        subFrame2.add(sudoku2);
        JPanel subFrame3 = new JPanel();
        subFrame3.add(sudoku3);
        JPanel subFrame4 = new JPanel();
        subFrame4.add(sudoku4);
        add(subFrame1);
        add(subFrame2);
        add(subFrame3);
        add(subFrame4);
    }

    public void actionPerformed(ActionEvent e)
    {
        String buttonString = e.getActionCommand();
        GetArrays getArrays = new GetArrays(buttonString);
        SudokuWindow gui1 = new SudokuWindow(getArrays);
        gui1.setVisible(true);
    }
}
