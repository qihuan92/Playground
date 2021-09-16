package io.github.qihuan92.handler;

import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * Message
 *
 * @author qi
 * @since 2021/9/16
 */
public class Message implements Delayed {
    Handler target;
    long when;
    Runnable callback;
    public int what;
    public Object obj;

    @Override
    public long getDelay(TimeUnit unit) {
        return unit.convert(when - System.currentTimeMillis(), TimeUnit.MILLISECONDS);
    }

    @Override
    public int compareTo(Delayed o) {
        if (o instanceof Message) {
            return (int) (when - ((Message) o).when);
        } else {
            return (int) (getDelay(TimeUnit.MILLISECONDS) - o.getDelay(TimeUnit.MILLISECONDS));
        }
    }

    @Override
    public String toString() {
        return "Message{" + "what=" + what +
                ", obj=" + obj +
                '}';
    }
}
