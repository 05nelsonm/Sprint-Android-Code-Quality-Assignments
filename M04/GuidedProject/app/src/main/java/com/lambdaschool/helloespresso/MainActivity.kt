package com.lambdaschool.helloespresso

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.widget.doOnTextChanged
import com.lambdaschool.helloespresso.util.Validator
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    companion object {
        const val KEY_TITLE = "com.lambdaschool.helloespresso.MESSAGE"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initUI()
    }

    private fun initUI() {
        change_title_button.setOnClickListener {
            title_view.text = getTitleInput()
        }

        pass_title_button.setOnClickListener {
            val newTitle = getTitleInput()
            title_view.text = newTitle

            val intent = Intent(this@MainActivity, ShowTitleActivity::class.java)
            intent.putExtra(KEY_TITLE, newTitle)
            startActivity(intent)
        }

        email_input.doOnTextChanged { text, start, count, after ->
            check_email_box.isChecked = Validator.isEmailValid(text.toString())
        }

        password_input.doOnTextChanged { text, start, count, after ->
            check_password_box.isChecked = Validator.isPasswordValid(text.toString())
        }
    }

    private fun getTitleInput() = title_input.text.toString()

    override fun onStart() {
        super.onStart()
    }

    override fun onResume() {
        super.onResume()
    }

    override fun onPause() {
        super.onPause()
    }

    override fun onStop() {
        super.onStop()
    }

    override fun onDestroy() {
        super.onDestroy()
    }

    override fun onBackPressed() {
        super.onBackPressed()
    }
}
