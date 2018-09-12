package com.example.caballep.firebasekotlinexample

import android.app.Activity
import android.content.Intent
import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.Toast
import com.example.caballep.firebasekotlinexample.adapter.FireBaseAdapter
import com.example.caballep.firebasekotlinexample.databinding.ActivityMainBinding
import com.firebase.ui.auth.AuthUI
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*

class MainActivity : AppCompatActivity() {

    val TAG = "MainActivity_LOG"
    lateinit var database: FirebaseDatabase
    lateinit var databaseReference: DatabaseReference
    var userName: String = Constants.ANONYMOUS
    lateinit var binding: ActivityMainBinding
    lateinit var valueEventListener: ValueEventListener
    lateinit var firebaseLayoutManager: LinearLayoutManager
    lateinit var firebaseAdapter : FireBaseAdapter
    lateinit var firebaseAuth : FirebaseAuth
    lateinit var authStateListener : FirebaseAuth.AuthStateListener
    var messages : ArrayList<Message> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        initializeRecyclerViewAdapter()
        initializeFireComponents()
        addAuthStateListener()
        addTextWatchers()
    }

    override fun onResume() {
        super.onResume()
        addReadListeners()
    }

    override fun onPause() {
        super.onPause()
        removeReadListeners()
        removeAuthStateListener()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode == Constants.RC_SIGN_IN && resultCode == Activity.RESULT_OK)
            Toast.makeText(this, "", Toast.LENGTH_LONG).show()
        else
            finish()
    }

    fun sendMessage(view: View) {
        var message = Message(binding.etMessage.text.toString(), userName)
        databaseReference.push().setValue(message)
        binding.etMessage.setText("")
    }

    fun signOut(view:View){
        AuthUI.getInstance().signOut(this)
    }

    private fun initializeFireComponents() {
        database = FirebaseDatabase.getInstance()
        databaseReference = database.reference.child("messages")
        firebaseAuth = FirebaseAuth.getInstance()
    }

    private fun initializeRecyclerViewAdapter() {
        firebaseLayoutManager = LinearLayoutManager(this);
        firebaseAdapter = FireBaseAdapter(messages)
        binding.rvMain.apply {
            adapter = firebaseAdapter
            layoutManager = firebaseLayoutManager
        }
    }

    private fun addAuthStateListener() {
        authStateListener = FirebaseAuth.AuthStateListener {firebaseAuth ->

            firebaseAuth.currentUser?.let {
                it.displayName?.let {
                    it_2 -> onSignedInInitialize(it_2)
                }
            }?: onSignedOutCleanup()
            firebaseAuth.addAuthStateListener(authStateListener)
        }
    }

    private fun removeAuthStateListener() {
        firebaseAuth.removeAuthStateListener(authStateListener)
    }

    private fun onSignedInInitialize(userName: String) {
        this.userName = userName
    }

    private fun onSignedOutCleanup () {
        this.userName = Constants.ANONYMOUS
        firebaseAdapter.clear()
        startFirebaseSignIn()
    }

    private fun startFirebaseSignIn() {
        startActivityForResult(AuthUI.getInstance()
                .createSignInIntentBuilder()
                .setIsSmartLockEnabled(false)
                .setAvailableProviders(listOf(AuthUI.IdpConfig.EmailBuilder().build()))
                .build(), Constants.RC_SIGN_IN)
    }

    private fun addReadListeners(){
        valueEventListener = object : ValueEventListener {

            override fun onCancelled(databaseError: DatabaseError) {

            }

            override fun onDataChange(dataSnapshot: DataSnapshot) {

                messages.clear()
                dataSnapshot.children.forEach { dataSnapshot ->
                    var message = dataSnapshot.getValue(Message::class.java)
                    message?.let {
                        messages.add(it)
                    }
                }
            }
        }
        databaseReference.addValueEventListener(valueEventListener)
    }

    private fun removeReadListeners() {
        databaseReference.removeEventListener(valueEventListener)
    }

    private fun addTextWatchers(){
        binding.etMessage.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {

            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                binding.btnSend.isEnabled = s.toString().isNotBlank()
            }

        })
    }

    private fun FireBaseAdapter.clear(){
        chatMessages.clear()
        notifyDataSetChanged()
    }

    private fun Any?.isNotNull() : Boolean {
        return this != null
    }
}
