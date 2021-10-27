@file:JvmName("Cercle")

package com.ieseljust.kscenemaker

import java.awt.Color
import java.awt.Graphics

class Cercle : Figura {

    //Inicializamos las variables
    var radi: Int = 50;

    //Constructor vacio
    constructor() : super()

    //Constructor con x e y
    constructor(x: Int, y: Int) : super(x, y)

    //constructor con x, y y color
    constructor(x: Int, y: Int, radi: Int, color: Color) : super(x, y, color) {
        //super(x, y, color)
        this.radi = radi;

    }

    override fun describeMe() {
        println("cercle " + x + " " + y + " " + radi + " " + color)
    }

    override fun render(g: Graphics) {
        g.setColor(color)             // Establim el color interior
        g.fillOval(x, y, radi, radi)    // Dibuixem un rectangle en la posició i mida indicades
    }

}