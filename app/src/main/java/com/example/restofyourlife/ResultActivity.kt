package com.example.restofyourlife

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.format.DateUtils
import android.widget.EditText
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.core.util.rangeTo
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.Month
import java.time.Year
import java.time.chrono.ChronoLocalDate
import java.time.format.DateTimeFormatter
import java.time.temporal.ChronoUnit
import java.util.*

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)


        // インテントから値を取得
        val gender: String = intent.getStringExtra(EXTRA_GENDER)
        val strBirthday: String = intent.getStringExtra(EXTRA_BIRTHDAY)

        // 生年月日から残り日付を計算する
        val restDays = calcRestDaysCount(strBirthday,85)

        // TextViewのmessageのビューオブジェクトを取得
        val textViewMessage = findViewById<TextView>(R.id.message)
        // textをセット
        textViewMessage.text = """
                                |あなたの人生は、
                                |残り【${restDays}】日です！
                                """.trimMargin()

    }

    /**
     * 残りの日数を計算する
     * @param strBirthday 生年月日(YYYY-MM-DD)
     * @param lifeExpectancy 推定寿命
     * @return 残りの日数
     */
    fun calcRestDaysCount(strBirthday: String,lifeExpectancy:Long): Long {

        // 生年月日をLocalDate型に変換
        val birthday: LocalDate = LocalDate.parse(strBirthday)
        // 生年月日+推定寿命で命日を取得
        val deathDay: LocalDate = birthday.plusYears(lifeExpectancy)
        // 今日の日付を取得
        val today: LocalDate = LocalDate.now()

        // 今日から命日までの残り日数を取得
        val restDays = ChronoUnit.DAYS.between(today, deathDay)

        return restDays
    }
}