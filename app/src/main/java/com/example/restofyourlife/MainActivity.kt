package com.example.restofyourlife

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup

const val EXTRA_GENDER = "com.example.restofyourlife.GENDER"
const val EXTRA_BIRTHDAY = "com.example.restofyourlife.BIRTHDAY"

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    /**
     * 入力データを結果画面に送信する
     * @param view activity_main
     */
    fun sendInputData(view: View){

        // 性別の値を取得
        val radioGroup = findViewById<RadioGroup>(R.id.genderRadioGroup)
        val checkedRadioButton = findViewById<RadioButton>(radioGroup.checkedRadioButtonId)
        val gender = checkedRadioButton.text.toString()

        // 生年月日の値を取得
        val birthday = findViewById<EditText>(R.id.birthday).text.toString()

        // インテントに値を追加
        val intent = Intent(this,ResultActivity::class.java).apply {
            putExtra(EXTRA_GENDER,gender)
            putExtra(EXTRA_BIRTHDAY,birthday)
        }

        // ResultActivityを開始する
        startActivity(intent)
    }

    /**
     * 日付ピッカーを表示する
     * @param view activity_main
     */
    fun showDatePickerDialog(view: View){
        // 日付ピッカーフラグメントの生成
        val newFragment = DatePickerFragment()

        // 表示する
        newFragment.show(supportFragmentManager,"datePicker")
    }
}