import java.util.Timer;
import java.util.TimerTask;
public class CountTime
{

    Timer myTimer = new Timer();
    public int seconds = 0;
    TimerTask task = new TimerTask()
    {
        public void run() {
            if (seconds < 1000) {
                System.out.println("Seconds = " + seconds);
                seconds++;
            } else {
                // stop the timer
                cancel();
            }
        }
    };

    public void start()
    {
        myTimer.schedule(task, 0, 1000);
    }
    public void stop()
    {
        myTimer.cancel();
    }
}
