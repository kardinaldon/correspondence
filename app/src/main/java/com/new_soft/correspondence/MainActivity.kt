package com.new_soft.correspondence

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import com.google.firebase.auth.FirebaseAuth
import com.new_soft.correspondence.activities.RegisterActivity
import com.new_soft.correspondence.databinding.ActivityMainBinding
import com.new_soft.correspondence.ui.fragments.ChatsFragment
import com.new_soft.correspondence.ui.objects.AppDrawer
import com.new_soft.correspondence.utilits.AUTH
import com.new_soft.correspondence.utilits.initFirebase
import com.new_soft.correspondence.utilits.replaceActivity
import com.new_soft.correspondence.utilits.replaceFragment

class MainActivity : AppCompatActivity() {

    private lateinit var mBinding: ActivityMainBinding
    lateinit var mAppDrawer: AppDrawer
    private lateinit var mToolbar: Toolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mBinding.root)
    }

    override fun onStart() {
        super.onStart()
        initFields()
        initFunc()
    }

    private fun initFunc() {
        if (AUTH.currentUser != null) {
            setSupportActionBar(mToolbar)
            mAppDrawer.create()
            replaceFragment(ChatsFragment())
        } else {
            replaceActivity(RegisterActivity())
        }
    }


    private fun initFields() {
        mToolbar = mBinding.mainToolbar
        mAppDrawer = AppDrawer(this, mToolbar)
        initFirebase()
    }
}