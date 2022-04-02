package com.example.chapterempatsharedpreferences.latihantiga

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.chapterempatsharedpreferences.R
import kotlinx.android.synthetic.main.fragment_login.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [LoginFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class LoginFragment : Fragment() {

    lateinit var prefsTiga : SharedPreferences

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        prefsTiga = requireContext().getSharedPreferences("SFLATTIGA", Context.MODE_PRIVATE)

//        if (requireContext().getSharedPreferences("SFLATTIGA", Context.MODE_PRIVATE).contains("NOHP")){
//            Navigation.findNavController(view).navigate(R.id.action_loginFragment_to_homeFragment)
//        }

        btn_login.setOnClickListener {
            login()
//            Navigation.findNavController(view).navigate(R.id.action_loginFragment_to_homeFragment)
        }

        tv_register.setOnClickListener{
            Navigation.findNavController(view).navigate(R.id.action_loginFragment_to_registerFragment)
        }
    }

    fun login(){
        val dataNoHp = et_hp.text.toString()
        val dataPassword = et_password.text.toString()

        if(dataNoHp == prefsTiga.getString("NOHP","")){
            view?.let { Navigation.findNavController(it).navigate(R.id.action_loginFragment_to_homeFragment) }
        }else{
            tv_error.setText("No Hp Tidak ditemukan")
        }

//        val dataNoHp = prefsTiga.getString("NOHP","")
//        val dataPassword = prefsTiga.getString("PASSWORD","")
    }

}