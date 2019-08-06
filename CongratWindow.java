import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Color;

public class CongratWindow extends JFrame
{
    public static final int w = 350;
    public static final int h = 180;

    public CongratWindow(){}
    public CongratWindow(int number, int seconds)
    {
        super("Congratulation Window");
        setSize(w,h);
        setBackground(Color.LIGHT_GRAY);

        if(number == 1)
        {
            setLocation(275,160);
        }
        else if (number == 2)
        {
            setLocation(275,460);
        }
        else if (number == 3)
        {
            setLocation(875,160);
        }
        else if (number == 4)
        {
            setLocation(875,460);
        }

        JLabel a = new JLabel("Congratulation! You Solved Sudoku " + number + " in " + seconds + " seconds");
        a.setForeground(Color.RED);
        a.setHorizontalAlignment(JLabel.CENTER);
        add(a);
    }
}
