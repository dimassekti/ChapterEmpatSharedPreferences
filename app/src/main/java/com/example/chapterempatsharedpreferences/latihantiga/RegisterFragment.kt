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
import kotlinx.android.synthetic.main.fragment_register.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [RegisterFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class RegisterFragment : Fragment() {

    lateinit var prefsTiga : SharedPreferences

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_register, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        prefsTiga = requireContext().getSharedPreferences("SFLATTIGA", Context.MODE_PRIVATE)

        btn_register.setOnClickListener {
            val nama = et_nama.text.toString()
            val pass = et_password.text.toString()
            val noHp = et_hp.text.toString()

            prefsTiga.edit().putString("NAMA",nama).apply()
            prefsTiga.edit().putString("PASSWORD",pass).apply()
            prefsTiga.edit().putString("NOHP",noHp).apply()

            Navigation.findNavController(view).navigate(R.id.action_registerFragment_to_loginFragment)
        }

        tv_login.setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.action_registerFragment_to_loginFragment)
        }
    }

}