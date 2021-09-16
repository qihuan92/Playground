package io.github.qihuan92.handler;

import java.util.concurrent.DelayQueue;

/**
 * MessageQueue
 *
 * @author qi
 * @since 2021/9/16
 */
public final class MessageQueue {

    private final DelayQueue<Message> queue = new DelayQueue<>();

    public void enqueueMessage(Message msg) {
        queue.add(msg);
    }

    public Message next() {
        try {
            return queue.take();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void quit() {
        queue.clear();
    }
}
