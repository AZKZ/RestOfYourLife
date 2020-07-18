package com.example.restofyourlife

import android.app.DatePickerDialog
import android.app.Dialog
import android.app.TimePickerDialog
import android.os.Bundle
import android.widget.DatePicker
import android.widget.EditText
import androidx.fragment.app.DialogFragment
import kotlinx.android.synthetic.main.activity_main.*

class DatePickerFragment : DialogFragment(), DatePickerDialog.OnDateSetListener {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        // 日付ピッカーの生成
        return DatePickerDialog(this.requireContext(),this,2000,1,1)
    }

    /**
     * 日付選択時に呼び出されるメソッド
     *
     * @param view 日付ピッカーのビュー
     * @param year 年
     * @param month 月
     * @param dayOfMonth 日
     */
    override fun onDateSet(view: DatePicker?, year: Int, month: Int, dayOfMonth: Int) {
        // 日付をYYYY-MM-DD形式の文字列にする
        val strBirthday = "${year}-${month.toString().padStart(2,'0')}-${dayOfMonth.toString().padStart(2,'0')}"

        // EditTextのbirthdayのビューオブジェクトを取得
        val birthdayTextView = activity?.findViewById<EditText>(R.id.birthday)

        // テキスト内を初期化した上で、日付を追加する
        birthdayTextView?.text?.clear()
        birthdayTextView?.text?.append(strBirthday)
    }
}