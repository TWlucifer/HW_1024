package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.TextView
import org.w3c.dom.Text
import kotlin.random.Random


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //宣告
        val ed_name = findViewById<EditText>(R.id.ed_name)
        val tv_text = findViewById<TextView>(R.id.tv_test)
        val tv_name = findViewById<TextView>(R.id.tv_name)
        val tv_winner = findViewById<TextView>(R.id.tv_winner)
        val tv_mmora = findViewById<TextView>(R.id.tv_mmora)
        val tv_cmora = findViewById<TextView>(R.id.tv_cmora)
        val btn_mora = findViewById<Button>(R.id.btn_mora)
        val btn_scissor = findViewById<RadioButton>(R.id.btn_scissor)
        val btn_stone = findViewById<RadioButton>(R.id.btn_stone)
        val btn_paper = findViewById<RadioButton>(R.id.btn_paper)

        btn_mora.setOnClickListener(){
            if (ed_name.length() == 0){
                tv_text.text="輸入玩家姓名"
                return@setOnClickListener
            }
            val name = ed_name.text
            val playclk = when{
                btn_scissor.isChecked -> "剪刀"
                btn_stone.isChecked -> "石頭"
                else -> "布"
            }
            val comptu = (Math.random()*3).toInt()

            val compuText = when(comptu){
                0 -> "剪刀"
                1 -> "石頭"
                else -> "布"
            }

            tv_name.text = "名字\n$name"
            tv_text.text = "我方\n$playclk"
            tv_cmora.text = "電腦\n$compuText"

            when{
                (btn_scissor.isChecked()&&comptu==2)||(btn_stone.isChecked()&&comptu==0)||(btn_paper.isChecked()&&comptu==1) -> {
                    tv_winner.text = "勝利者\n$name"
                    tv_text.text = "恭喜您獲勝"
                }
                btn_scissor.isChecked()&&comptu==1 || btn_stone.isChecked()&&comptu==2 || btn_paper.isChecked()&&comptu==0 ->
                {
                    tv_winner.text = "勝利者\n電腦"
                    tv_text.text = "恭喜您輸了"
                }
                else -> {
                    tv_winner.text = "平手"
                    tv_text.text = "平局，再一次"
                }

            }
        }

    }
}