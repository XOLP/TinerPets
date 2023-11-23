package com.example.tinerpets.fragmentsNavMenu

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.lifecycle.findViewTreeViewModelStoreOwner
import com.example.tinerpets.AuthActivity
import com.example.tinerpets.AuthenticatorRobot
import com.example.tinerpets.LoginActivity
import com.example.tinerpets.MainActivity
import com.example.tinerpets.R
import com.example.tinerpets.UpdateStausAuth
import com.google.firebase.auth.FirebaseAuth




class HomeFragment : Fragment()   {

//Интерфейс для отправки данных в mainActivity
    lateinit var dataPasser: UpdateStausAuth
    override fun onAttach(context: Context) {
        super.onAttach(context)
        dataPasser = context as UpdateStausAuth
    }
    fun passData(data: Boolean){
        dataPasser.OnDataPass(data)
    }


    private val auth = AuthenticatorRobot()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view: View = inflater.inflate(R.layout.fragment_home, container, false)

        val btnSingout: Button = view.findViewById(R.id.buttonSingOut)
        btnSingout.setOnClickListener(){
            if(auth.Checklogin()) {
                auth.SingOut()
                Log.d("test1","выход выполнен" )
                Toast.makeText(context, "Успешно вышли из аккаунта", Toast.LENGTH_SHORT)
                passData(true)
            }
            else{
            passData(false)
                 }


        }
        return view
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


    }



}
