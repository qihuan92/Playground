package io.github.qihuan92.handler;

import com.sun.istack.internal.NotNull;

/**
 * This is a fake Android Handler
 *
 * @author qi
 * @since 2021/9/16
 */
public class Handler {

    public interface Callback {
        boolean handleMessage(@NotNull Message msg);
    }

    private final Callback mCallback;
    private final Looper mLooper;
    private final MessageQueue mQueue;

    public Handler() {
        this(null);
    }

    public Handler(Looper looper) {
        this(looper, null);
    }

    public Handler(Looper looper, Callback callback) {
        this.mCallback = callback;
        this.mLooper = looper;
        this.mQueue = looper.mQueue;
    }

    public void handleMessage(Message msg) {
    }

    public void dispatchMessage(Message msg) {
        if (msg.callback != null) {
            handleCallback(msg);
        } else {
            if (mCallback != null) {
                if (mCallback.handleMessage(msg)) {
                    return;
                }
            }
            handleMessage(msg);
        }
    }

    private static void handleCallback(Message msg) {
        msg.callback.run();
    }

    public void sendMessage(Message msg) {
        sendMessageDelayed(msg, 0L);
    }

    public void sendMessageDelayed(Message msg, long delay) {
        msg.target = this;
        delay = Math.max(delay, 0L);
        // Android used SystemClock.uptimeMillis(), the millis after boot.
        msg.when = System.currentTimeMillis() + delay;
        mQueue.enqueueMessage(msg);
    }

    public void post(Runnable r) {
        postDelayed(r, 0L);
    }

    public void postDelayed(Runnable r, long delay) {
        Message msg = new Message();
        msg.callback = r;
        sendMessageDelayed(msg, delay);
    }

    public Looper getLooper() {
        return mLooper;
    }
}