package com.example.flightgear_mobileapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.SeekBar

class MainActivity : AppCompatActivity() {
    val vm = AppViewModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val button : Button = findViewById(R.id.button)
        button.setOnClickListener {connect()}
        updateJoystick()
        updateThrottle()
        updateRudder()
    }

    fun updateJoystick() {
        val joystick = findViewById<com.example.flightgear_mobileapp.Joystick>(R.id.joystick)
        joystick.onChange = {aileron : Float, elevator : Float ->
            vm.VM_setAileron(aileron)
            vm.VM_setElevator(elevator)
        }
    }

    fun updateThrottle() {
        //seekbar throttle: min=0, max=100
        val throttle = findViewById<SeekBar>(R.id.seekBarThrottle)
        throttle.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                vm.VM_setThrottle(throttle.progress.toFloat())
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
                vm.VM_setRudder(rudder.progress.toFloat())
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {

            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {

            }

        })
    }

    fun connect() {
        val ip = findViewById<com.google.android.material.textfield.TextInputEditText>(R.id.ip_address).text.toString()
        val port = findViewById<com.google.android.material.textfield.TextInputEditText>(R.id.port).text.toString()
        vm.VM_connect(ip, port)
    }
}