package io.github.qihuan92.playground;

import android.app.Application;

import com.alibaba.android.arouter.launcher.ARouter;

/**
 * App
 *
 * @author qi
 * @since 2022/4/18
 */
public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        ARouter.init(this);
    }
}
