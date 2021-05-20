package com.new_soft.correspondence.ui.fragments

import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import com.new_soft.correspondence.MainActivity
import com.new_soft.correspondence.R
import com.new_soft.correspondence.utilits.*
import kotlinx.android.synthetic.main.fragment_change_name.*


class ChangeNameFragment : BaseFragment(R.layout.fragment_change_name) {

    override fun onResume() {
        super.onResume()
        setHasOptionsMenu(true)
        val fullnameList: List<String> = USER.fullname.split(" ")
        if(fullnameList.size>1){
            settings_input_name.setText(fullnameList[0])
            settings_input_surname.setText(fullnameList[1])
        }
        else {
            settings_input_name.setText(fullnameList[0])
        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        (activity as MainActivity).menuInflater.inflate(R.menu.settings_menu_confirm, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.settings_confirm_change -> changeName()
        }
        return true
    }

    private fun changeName() {
        val name = settings_input_name.text.toString()
        val surname = settings_input_surname.text.toString()
        if (name.isEmpty()) {
            showToast(getString(R.string.settings_toast_name_is_empty))
        } else {
            val fullname = "$name $surname"
            REF_DATABASE_ROOT.child(NODE_USERS).child(UID).child(CHILD_FULLNAME)
                .setValue(fullname).addOnCompleteListener {
                    if (it.isSuccessful) {
                        showToast(getString(R.string.toast_data_update))
                        USER.fullname = fullname;
                        fragmentManager?.popBackStack()
                    }
                }
        }

    }
}