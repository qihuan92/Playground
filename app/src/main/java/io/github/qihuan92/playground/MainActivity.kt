package io.github.qihuan92.playground

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.alibaba.android.arouter.launcher.ARouter
import io.github.qihuan92.learnbinderclient.BookListActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.btn_second)
            .setOnClickListener {
                ARouter.getInstance()
                    .build("/second/activity")
                    .withString("id", "123")
                    .withString("name", "ZhangSan")
                    .navigation()
            }

        findViewById<Button>(R.id.btn_learn_binder)
            .setOnClickListener {
                startActivity(Intent(this, BookListActivity::class.java))
            }
    }
}