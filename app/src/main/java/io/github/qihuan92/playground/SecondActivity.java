package io.github.qihuan92.playground;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;

@Route(path = "/playground/second")
public class SecondActivity extends AppCompatActivity {

    private static final String TAG = "SecondActivity";

    @Autowired
    String id;

    @Autowired
    String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        ARouter.getInstance().inject(this);
        Log.i(TAG, "onCreate: id = " + id + ", name = " + name);
    }
}