package com.example.myhistoryapp

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {


    private lateinit var outputTxt: TextView
    private var enterAge: EditText? = null
    private var backButton = 0L


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        enterAge = findViewById(R.id.enterAge)
        outputTxt = findViewById(R.id.outputTxt)
        val clearBtn = findViewById<Button>(R.id.clearBtn)
        val enterBtn = findViewById<Button>(R.id.enterBtn)

//  clearBtn inspired by Kincade because he taught us how to allow a user to clear their past inputs and results
        clearBtn.setOnClickListener {
            enterAge?.text?.clear()
            outputTxt.text = ""
        }
//   enterBtn is linked to both checkCeleb and isNotEmpty to ensure user input has the desired output and errors are explained to users
        enterBtn.setOnClickListener {
           checkCeleb()
            isNotEmpty()
            
        }
    }


//checkCeleb inspired by Donn Felker because it assists in giving an output to any user input given in enterAge EditText. Link to Youtube video: https://www.youtube.com/watch?v=vsprV3NGkA4
    private fun checkCeleb() {

         when {
            enterAge?.text.toString() == "23" -> {
                outputTxt.text = "You are the same age as Tomwad when he died"
            }
//             multiple else statements do not show the desired text when user input is entered
             else->{
                 outputTxt.text="Please enter valid age between 20-100"
             }

        }
        when {
            enterAge?.text.toString() == "27" -> {
                outputTxt.text = "You are the same age as Kurt Cobain when he died"
            }

        }
        when {
            enterAge?.text.toString() == "35" -> {
                outputTxt.text = "You are the same age as Wolfgang Amadeus when he died"
            }

        }
        when {
            enterAge?.text.toString() == "58" -> {
                outputTxt.text = "You are the same age as Barry White when he died"
            }

        }
        when {
            enterAge?.text.toString() == "88" -> {
                outputTxt.text = "You are the same age as Michelangelo when he died"
            }

        }





    }
//    isNotEmpty inspired by Kincade because he taught us how to add this function in order to ensure user errors are addressed
    private fun isNotEmpty(): Boolean {
        var b = true
        if (enterAge?.text.toString().trim().isEmpty()) {
            enterAge?.error = "Required!"
            b = false
        }
        return b
    }


//    onBackPressed inspired by Kincade bacause he taught us how to allow a user to end or exit an app
    override fun onBackPressed() {
        if(backButton+2500>System.currentTimeMillis())
        {super.onBackPressed()}
        else{
            Toast.makeText(this,"Please Press again to Exit!", Toast.LENGTH_LONG).show()
        }
        backButton=System.currentTimeMillis()
        }
    }


