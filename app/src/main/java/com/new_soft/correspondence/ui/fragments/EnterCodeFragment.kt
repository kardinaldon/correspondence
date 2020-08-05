package com.new_soft.correspondence.ui.fragments

import androidx.fragment.app.Fragment
import com.new_soft.correspondence.R
import com.new_soft.correspondence.utilits.AppTextWatcher
import com.new_soft.correspondence.utilits.showToast
import kotlinx.android.synthetic.main.fragment_enter_code.*

class EnterCodeFragment : Fragment(R.layout.fragment_enter_code) {

    override fun onStart() {
        super.onStart()
        register_input_code.addTextChangedListener(AppTextWatcher {

            val string: String = register_input_code.text.toString()
            if (string.length == 6) {
                verifyCode()
            }

        })
    }

    fun verifyCode() {
        showToast("ok")
    }
}