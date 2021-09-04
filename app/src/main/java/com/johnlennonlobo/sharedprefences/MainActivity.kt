package com.johnlennonlobo.sharedprefences

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {

    private lateinit var buttonSave: Button
    private lateinit var inputText: TextInputEditText
    private lateinit var textResult: TextView

    companion object {
        private const val FILE_PREFERENCE="FilePreference"
        private const val NAME = "name"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonSave = findViewById(R.id.buttonSave)
        inputText = findViewById(R.id.inputName)
        textResult = findViewById(R.id.textResult)

        //TODO ->> sharedPrefences cria um arquivo xml para guardar o dado
        val sharedPreferences = getSharedPreferences(FILE_PREFERENCE, 0)

        buttonSave.setOnClickListener {

            val editor = sharedPreferences.edit()
            val name = inputText.text.toString()
            if (name == "") {
                Toast.makeText(this, "Preencha o seu nome", Toast.LENGTH_SHORT).show()
            } else {
                //TODO ->> colocar dados no arquivo
                editor.putString(NAME,name)

                //TODO ->> salvar dados
                editor.apply()

                textResult.text = "Olá, $name"
            }

        }

        //TODO ->> recuperar dados
        if(sharedPreferences.contains(NAME)){
            val name = sharedPreferences.getString(NAME, "usuario não definido")
            textResult.text = "Olá, $name"
        }
    }


}