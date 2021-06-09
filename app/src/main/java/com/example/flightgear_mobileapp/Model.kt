package com.example.flightgear_mobileapp

import android.os.StrictMode
import java.io.OutputStream
import java.net.Socket

class Model {
    private lateinit var socket : Socket
    private lateinit var outputStream : OutputStream
    private var ip_addr : String = " "
    private var port_num : String = " "
    private var throttle_val : Float = 0f
    private var rudder_val : Float = 0f
    private var aileron_val : Float = 0f
    private var elevator_val : Float = 0f

    fun connect(ip: String, port: String) {
        ip_addr = ip
        port_num = port
        val portInt : Int = port.toInt()
        println("IP IS: " + ip + " PORT IS: " + port)
        val thread = Thread(Runnable {
            try{
                socket = Socket(ip,portInt)
                println("GOT HERE")
                outputStream = socket.getOutputStream()
            }
            catch (e : Exception) {
                e.printStackTrace()
            }
        })
        thread.start()
        thread.join()
    }
    fun setThrottle(throttle : Float) {
        throttle_val = throttle / 100
        //println("THROTTLE: " + throttle_val)
        val thread = Thread(Runnable {
            val string : String = "set /controls/engines/current-engine/throttle "+throttle_val.toString()+"\r\n"
            println(string)
            outputStream.write(string.toByteArray());
            outputStream.flush();
        })
        thread.start()
        thread.join()
    }
    fun setRudder(rudder : Float) {
        rudder_val = (rudder - 50) / 50
        println("RUDDER: " + rudder_val)
        val thread = Thread(Runnable {
            val string : String = "set /controls/flight/rudder "+rudder_val.toString()+"\r\n"
            outputStream.write(string.toByteArray());
            outputStream.flush();
        })
        thread.start()
        thread.join()
    }
    fun setAileron(aileron : Float) {
        aileron_val = aileron
        val thread = Thread(Runnable {
            val string : String = "set /controls/flight/aileron "+aileron_val.toString()+"\r\n"
            outputStream.write(string.toByteArray());
            outputStream.flush();
        })
        thread.start()
        thread.join()
    }
    fun setElevator(elevator : Float) {
        elevator_val = elevator
        val thread = Thread(Runnable {
            val string : String = "set /controls/flight/elevator "+elevator_val.toString()+"\r\n"
            outputStream.write(string.toByteArray());
            outputStream.flush();
        })
        thread.start()
        thread.join()
    }

}