@file:JvmName("Linia")

package com.ieseljust.kscenemaker

import java.awt.Color
import java.awt.Graphics

class Linia : Figura {

    private var x2:Int = 50
    private var y2:Int = 50

    constructor() : super()
    constructor(x: Int, y: Int, x2: Int, y2: Int, color: Color) : super(x, y){
        this.x2 = x2
        this.y2 = y2
    }


    override fun describeMe() {
        /*
        * Mètode que mostra en mode text una descripció de la figura per la consola.
        * S'utilitzarà per al mètode llista de la CLI.
        */
        println("linia " + x + " " + y + " " +x2+" "+y2+" "+ color)
    }

    override fun render(g: Graphics) {
        g.setColor(color)             // Establim el color interior
        g.drawLine(x, y, x2, y2) // Dibuixem la linia en la posició i mida indicades
    }


}