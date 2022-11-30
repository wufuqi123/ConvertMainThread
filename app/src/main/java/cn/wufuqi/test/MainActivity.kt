package cn.wufuqi.test

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import cn.wufuqi.convertmainthread.ConvertMainThread

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ConvertMainThread.runOnUiThread {
            Log.e("-------","-----")
        }
    }
}