package io.github.qihuan92.handler;

import org.junit.Test;

import java.util.concurrent.Executors;

/**
 * HandlerTest
 *
 * @author qi
 * @since 2021/9/16
 */
public class HandlerTest {

    private Handler handler;

    @Test
    public void testHandler() {
        Looper.prepare();

        handler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                System.out.println(msg);
            }
        };

        Executors.newSingleThreadExecutor().submit(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 5; i++) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    for (int j = 0; j < 10; j++) {
                        Message message = new Message();
                        message.what = j;
                        message.obj = String.format("i=%d, j=%d", i, j);
                        handler.sendMessageDelayed(message, 500L);
                    }
                }
            }
        });

        Looper.loop();
    }
}
