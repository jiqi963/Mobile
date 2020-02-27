package com.example.a01touchinput

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.view.get
import androidx.core.view.isEmpty
import kotlinx.android.synthetic.main.activity_main.*
import android.widget.Spinner
import android.widget.ArrayAdapter


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btn1.setOnClickListener(ButtonOnClickListener())
        btn2.setOnClickListener(EnrolButtonOnClickListion())
        val Mofy = resources.getStringArray(R.array.Monthsoftheyear)
        populateSpinner(spn1, Mofy)
    }


    inner class ButtonOnClickListener : View.OnClickListener {
        override fun onClick(view: View?) {
            if (email.text.isBlank()) {
                email.error = "Email is empty"
            } else if (password.text.isBlank()) {
                password.error = "Password is empty"
            } else {
                textView2.text = email.text
                textView3.text = password.text
            }
        }
    }

    inner class EnrolButtonOnClickListion : View.OnClickListener {
        override fun onClick(viwe: View?) {
            if (radiogruop.checkedRadioButtonId.equals(-1)) {
                textView4.text = "choose a radio button"
            } else if (radiogruop.checkedRadioButtonId.equals(1)) {
                textView4.text = "Option 1"
            } else if (radiogruop.checkedRadioButtonId.equals(2)) {
                textView4.text = "Option 2"
            } else if (radiogruop.checkedRadioButtonId.equals(3)) {
                textView4.text = "Option 3"
            }
        }
    }

    private fun populateSpinner(spinner: Spinner, array: Array<String>) {

        val layoutID: Int = android.R.layout.simple_spinner_item
        spinner.adapter = ArrayAdapter(this@MainActivity, layoutID, array)
    }
}
