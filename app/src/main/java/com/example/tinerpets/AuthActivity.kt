package com.example.tinerpets

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.auth


class AuthActivity : AppCompatActivity(){

//region Регион АУНТЕФИКАЦИ!!!

    // [START declare_auth]
    private lateinit var auth: FirebaseAuth
    // [END declare_auth]




    public  fun SingOut(){
        auth.signOut()


    }
    // [START on_start_check_user]
    public fun Checklogin(): Boolean {
        auth = Firebase.auth
        // Check if user is signed in (non-null) and update UI accordingly.
        val currentUser = auth.currentUser
        if (currentUser != null) {
            Log.d(TAG, "Успешно войдено в аккаунт ${currentUser.uid}")
            return true
        }
        return  false

    }
    // [END on_start_check_user]

    public fun createAccount(email: String, password: String) {
        // [START create_user_with_email]
        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information
                    Log.d(TAG, "createUserWithEmail:success ${task.result.user?.uid}")



                } else {
                    // If sign in fails, display a message to the user.
                    Log.w(TAG, "createUserWithEmail:failure", task.exception)
                    return@addOnCompleteListener


                }
            }
            .addOnFailureListener(this){
                Log.d(TAG, "Error register")
                return@addOnFailureListener
            }
        // [END create_user_with_email]
    }

    public fun signIn(email: String, password: String) {
        // [START sign_in_with_email]
        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information
                    Log.d(TAG, "signInWithEmail:success ${task.result.user?.uid}")
                    val intent = Intent(this, MainActivity::class.java)
                    intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK.or(Intent.FLAG_ACTIVITY_NEW_TASK)
                    startActivity(intent)


                } else {
                    // If sign in fails, display a message to the user.
                    Log.w(TAG, "signInWithEmail:failure", task.exception)

                    return@addOnCompleteListener
                }
            }
            .addOnFailureListener(this) {
                Log.d(TAG, "Error singIn")
                return@addOnFailureListener
            }
        // [END sign_in_with_email]
    }

    public fun sendEmailVerification() {
        // [START send_email_verification]
        val user = auth.currentUser!!
        user.sendEmailVerification()
            .addOnCompleteListener(this) {task ->
                // Email Verification sent
            }
        // [END send_email_verification]
    }

    private fun updateUI(user: FirebaseUser?) {
    }

    private fun reload() {
    }

    companion object {
        private const val TAG = "test1"
    }



//endregion


    override fun onStart() {
        super.onStart()
        LoginOrNot()
    }
    private fun LoginOrNot(){
        if(this.Checklogin()) {

            Log.d("test1", "Проверка пройдена, пользователь авторизован")
            val intent = Intent(this, MainActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK.or(Intent.FLAG_ACTIVITY_NEW_TASK)
            startActivity(intent)

        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_auth)

        val buttonLogin: Button = findViewById(R.id.button_loginAuth)
        val linkToReg: TextView = findViewById(R.id.Linkreglog)

        val userEmail: EditText = findViewById(R.id.editTextEmail_logn)
        val userPassword: EditText = findViewById(R.id.editTextTextPassword_login)

        linkToReg.setOnClickListener(){
            val intent = Intent(this, LoginActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK.or(Intent.FLAG_ACTIVITY_NEW_TASK)
            startActivity(intent)

        }

        buttonLogin.setOnClickListener {
            val email = userEmail.text.toString().trim()
            val password = userPassword.text.toString().trim()

            if(email =="" || password == "") {
                Toast.makeText(this, "Не все поля заполнены", Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }
            this.signIn(email, password)


        }
    }
}