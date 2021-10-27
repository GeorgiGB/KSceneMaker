@file:JvmName("Rectangle")

package com.ieseljust.kscenemaker

import java.awt.Graphics
import java.awt.Color

class Rectangle : Figura {

    // Inicialitzem les variables en la delcaració mateix
    // No utilitzarem cap constructor primari
    var width: Int = 100
    var height: Int = 100

    // Constructors secundaris
    constructor() : super() //Sense arguments

    constructor(x: Int, y: Int, width: Int = 100, height: Int = 100, color: Color) : super(x, y, color) {
        //super(x, y, color)
        this.width = width
        this.height = height
        this.color = color

    }

    override fun describeMe() {
        /*
        * Mètode que mostra en mode text una descripció de la figura per la consola.
        * S'utilitzarà per al mètode llista de la CLI.
        */
        println("rectangle " + x + " " + y + " " + width + " " + height + " " + color)
    }

    override fun render(g: Graphics) {

        /*
         * Mètode que dibuixa sobre un context gràfic la figura rectangle.
         * S'utilitza per al mètode render() de App.
         *
         * Per dibuixar altres primitives de la classe Graphics, podeu consultar
         * https://docs.oracle.com/javase/10/docs/api/java/awt/Graphics.html
         *
         * Fixeu-vos que això són classes de java que estem utilitzant
         * directament des de Kotlin!
         *
         */

        g.setColor(color)             // Establim el color interior
        g.fillRect(x, y, width, height)    // Dibuixem un rectangle en la posició i mida indicades
    }

}

