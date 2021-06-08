package com.example.flightgear_mobileapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.SeekBar

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        updateJoystick()
        updateThrottle()
        updateRudder()
    }


    fun updateJoystick() {
        val joystick = findViewById<com.example.flightgear_mobileapp.Joystick>(R.id.joystick)
        joystick.onChange = {aileron : Float, elevator : Float ->
            println("AILERON: " + aileron + "ELEVATOR" + elevator)
        }
    }

    fun updateThrottle() {
        //seekbar throttle: min=0, max=100
        val throttle = findViewById<SeekBar>(R.id.seekBarThrottle)
        throttle.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                println(throttle.progress.toString())
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {

            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {

            }

        })
    }

    fun updateRudder() {
        //seekbar rudder: min=0, max=100
        val rudder = findViewById<SeekBar>(R.id.seekBarRudder)
        rudder.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                println(rudder.progress.toString())
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {

            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {

            }

        })
    }

    fun connect(view: View) {
        val ip = findViewById<com.google.android.material.textfield.TextInputEditText>(R.id.ip_address).text.toString()
        val port = findViewById<com.google.android.material.textfield.TextInputEditText>(R.id.port).text.toString()
        println("IP ADDRESS IS: " + ip + "PORT IS: " + port)
    }
}