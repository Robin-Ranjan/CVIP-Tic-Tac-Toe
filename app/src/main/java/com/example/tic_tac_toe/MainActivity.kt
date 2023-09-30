package com.example.tic_tac_toe

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.Button
import android.widget.Toast
import com.example.tic_tac_toe.databinding.ActivityMainBinding
import java.util.Timer

class MainActivity : AppCompatActivity() {


    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    lateinit var button: Button
    lateinit var b1: String
    lateinit var b2: String
    lateinit var b3: String
    lateinit var b4: String
    lateinit var b5: String
    lateinit var b6: String
    lateinit var b7: String
    lateinit var b8: String
    lateinit var b9: String
    var flag = 0
    var count = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.btnRestart.setOnClickListener {
            restart()
        }

    }

    public fun Check(view: View) {
        button = view as Button
        if (button.text.toString().equals("")) {

            count++

            if (flag == 0) {
                button.text = "X"
                button.setBackgroundResource(R.color.X)
                flag = 1;
            } else {
                button.text = "O"
                button.setBackgroundResource(R.color.O)
                flag = 0;
            }

            if (count > 4) {
                b1 = binding.btn1.text.toString()
                b2 = binding.btn2.text.toString()
                b3 = binding.btn3.text.toString()
                b4 = binding.btn4.text.toString()
                b5 = binding.btn5.text.toString()
                b6 = binding.btn6.text.toString()
                b7 = binding.btn7.text.toString()
                b8 = binding.btn8.text.toString()
                b9 = binding.btn9.text.toString()

                if (b1 == b2 && b2 == b3 && b1 != "") {

                    Toast.makeText(this, "Winner is $b1", Toast.LENGTH_SHORT).show()
                    restartTimer()

                } else if (b4 == b5 && b5 == b6 && b4 != "") {

                    Toast.makeText(this, "Winner is $b4", Toast.LENGTH_SHORT).show()
                    restartTimer()

                } else if (b7 == b8 && b8 == b9 && b7 != "") {

                    Toast.makeText(this, "Winner is $b7", Toast.LENGTH_SHORT).show()
                    restartTimer()

                } else if (b1 == b4 && b4 == b7 && b1 != "") {

                    Toast.makeText(this, "Winner is $b1", Toast.LENGTH_SHORT).show()
                    restartTimer()

                } else if (b2 == b5 && b5 == b8 && b2 != "") {

                    Toast.makeText(this, "Winner is $b2", Toast.LENGTH_SHORT).show()
                    restartTimer()

                } else if (b3 == b6 && b6 == b9 && b3 != "") {

                    Toast.makeText(this, "Winner is $b3", Toast.LENGTH_SHORT).show()
                    restart()

                } else if (b1 == b5 && b5 == b9 && b1 != "") {

                    Toast.makeText(this, "Winner is $b1", Toast.LENGTH_SHORT).show()
                    restartTimer()

                } else if (b3 == b5 && b5 == b7 && b3 != "") {

                    Toast.makeText(this, "Winner is $b3", Toast.LENGTH_SHORT).show()
                    restartTimer()
                } else if (count == 9) {
                    Toast.makeText(this, "Game is Drawn", Toast.LENGTH_SHORT).show()
                    restartTimer()
                }
            }
        }
    }

    fun restart() {
        binding.btn1.text = ""
        binding.btn2.text = ""
        binding.btn3.text = ""
        binding.btn4.text = ""
        binding.btn5.text = ""
        binding.btn6.text = ""
        binding.btn7.text = ""
        binding.btn8.text = ""
        binding.btn9.text = ""
        flag = 0
        count = 0
    }

    fun restartTimer() {
        Handler(Looper.getMainLooper()).postDelayed({
            restart()
        }, 3000)
    }
}
