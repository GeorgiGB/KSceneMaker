@file:JvmName("Ellipse")

package com.ieseljust.kscenemaker

import java.awt.Color
import java.awt.Graphics

class Ellipse : Figura {

    private var r1: Int = 50
    private var r2: Int = 50


    constructor() : super()
    constructor(x: Int, y: Int, r1: Int, r2: Int, color: Color) : super(x, y, color) {
        this.r1 = r1
        this.r2 = r2
    }


    override fun describeMe() {

        println("ellipse " + x + " " + y + " " + r1 + " " + r2 + " " + color)
    }

    override fun render(g: Graphics) {
        g.setColor(color)             // Establim el color interior
        g.fillOval(x, y, r1, r2)    // Dibuixem un quadrat en la posició i mida indicades
    }

}