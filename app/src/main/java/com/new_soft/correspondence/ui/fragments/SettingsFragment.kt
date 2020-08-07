package com.new_soft.correspondence.ui.fragments

import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import com.new_soft.correspondence.MainActivity
import com.new_soft.correspondence.R
import com.new_soft.correspondence.activities.RegisterActivity
import com.new_soft.correspondence.utilits.AUTH
import com.new_soft.correspondence.utilits.replaceActivity
import com.new_soft.correspondence.utilits.replaceFragment

class SettingsFragment : BaseFragment(R.layout.fragment_settings) {

    override fun onResume() {
        super.onResume()
        setHasOptionsMenu(true)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        activity?.menuInflater?.inflate(R.menu.settings_action_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.settings_menu_exit -> {
                AUTH.signOut()
                (activity as MainActivity).replaceActivity(RegisterActivity())
            }
            R.id.settings_menu_change_name -> replaceFragment(ChangeNameFragment())
        }
        return true
    }

}