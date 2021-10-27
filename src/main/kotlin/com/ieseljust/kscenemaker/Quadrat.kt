@file:JvmName("Quadrat")

package com.ieseljust.kscenemaker

import java.awt.Color
import java.awt.Graphics

class Quadrat : Figura {
    var lado: Int = 100;

    constructor() : super()
    constructor(x: Int, y: Int) : super(x, y)
    constructor(x: Int, y: Int, lado: Int, color: Color) : super(x, y, color) {
        this.lado = lado
    }

    override fun describeMe() {

        println("quadrat " + x + " " + y + " " + lado + " " + color)
    }

    override fun render(g: Graphics) {
        g.setColor(color)             // Establim el color interior
        g.fillRect(x, y, lado, lado)    // Dibuixem un quadrat en la posició i mida indicades
    }


}