package com.ylchang.guess03

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AlertDialog
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
//import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_material.*

class MaterialActivity : AppCompatActivity() {

    val secretNumber =  SecretNumber()
    val TAG = MaterialActivity::class.java.simpleName


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_material)
        setSupportActionBar(findViewById(R.id.toolbar))

        findViewById<FloatingActionButton>(R.id.fab).setOnClickListener { view ->
            AlertDialog.Builder(this)
                .setTitle("Replay game")
                .setMessage("Are you sure?")
                .setPositiveButton("OK", { dialog, which ->
                    secretNumber.reset()
                    counter.setText(secretNumber.count.toString())
                    number.setText("$$$")
                })
                .setNeutralButton("Cancel", null)
                .show()
        }
        counter.setText(secretNumber.count.toString())
    }

    fun check(view: View)
    {
        val n : Int = number.text.toString().toInt()
        println("number :$n")
        Log.d("MainActivity","number " + n)
        val diff : Int = secretNumber.validate(n)
        var message = "Yes, you got it"
        if (diff < 0)
        {
            message = "Bigger"
        }
        else if(diff > 0)
        {
            message = "Smaller"
        }

        counter.setText(secretNumber.count.toString())
        //  Toast.makeText(this ,message, Toast.LENGTH_LONG).show()
        AlertDialog.Builder(this)
            .setTitle(message)
            .setPositiveButton("OK", null)
            .show()
    }
}