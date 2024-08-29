package puj.desarrolloweb.proyecto.init;
import java.util.concurrent.atomic.AtomicLong;

public class CustomIdGenerator {
    private static final AtomicLong idCounter = new AtomicLong(1);

    public static synchronized Long createID() {
        return idCounter.getAndIncrement();
    }
}