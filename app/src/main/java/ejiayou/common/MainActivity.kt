package ejiayou.common

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

/**
 * @author: lr
 * @created on: 2022/7/15 10:30 下午
 * @description:
 */
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<TextView>(R.id.tv).setOnClickListener {
            startActivity(Intent(MainActivity@ this, TestActivity::class.java))
        }
    }
}