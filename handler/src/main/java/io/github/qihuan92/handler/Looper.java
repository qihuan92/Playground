package io.github.qihuan92.handler;

/**
 * Looper
 *
 * @author qi
 * @since 2021/9/16
 */
public class Looper {
    private static final ThreadLocal<Looper> sThreadLocal = new ThreadLocal<>();
    final MessageQueue mQueue;

    public Looper() {
        this.mQueue = new MessageQueue();
    }

    public static void prepare() {
        if (sThreadLocal.get() != null) {
            throw new RuntimeException("Only one Looper may be created per thread");
        }
        sThreadLocal.set(new Looper());
    }

    public static Looper myLooper() {
        return sThreadLocal.get();
    }

    public static MessageQueue myQueue() {
        return myLooper().mQueue;
    }

    public static void loop() {
        final Looper me = myLooper();
        if (me == null) {
            throw new RuntimeException("No Looper; Looper.prepare() wasn't called on this thread.");
        }
        //noinspection InfiniteLoopStatement
        while (true) {
            Message msg = me.mQueue.next();
            if (msg == null) {
                continue;
            }
            msg.target.dispatchMessage(msg);
        }
    }

    public void quit() {
        mQueue.quit();
    }
}
