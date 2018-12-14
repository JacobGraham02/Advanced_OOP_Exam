import java.time.LocalDate;
import java.time.LocalDateTime;

public class HelloRunnable implements Runnable {

    private boolean loop = true;

    public void endLoop()
    {
        loop = false;
    }

    public void restartLoop()
    {
        loop = true;
    }

    @Override
    public void run() {

        while(loop)
        {
            System.out.println("Schevene & Rodrigo don't get bored...go to Jaret's class! "+ LocalDateTime.now());

            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
