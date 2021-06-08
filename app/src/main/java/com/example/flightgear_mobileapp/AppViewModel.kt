package com.example.flightgear_mobileapp

class AppViewModel {
    val model = Model()
    fun VM_connect(ip: String, port: String) {
        model.connect(ip, port)
    }
    fun VM_setThrottle(throttle : Float) {
        model.setThrottle(throttle)
    }
    fun VM_setRudder(rudder : Float) {
        model.setRudder(rudder)
    }
    fun VM_setAileron(aileron : Float) {
        model.setAileron(aileron)
    }
    fun VM_setElevator(elevator : Float) {
        model.setElevator(elevator)
    }
}