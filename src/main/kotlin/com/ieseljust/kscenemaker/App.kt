/*
 * This Kotlin source file was generated by the Gradle 'init' task.
 */

package com.ieseljust.kscenemaker

import kotlin.system.exitProcess        // Per utilitzar exitPRocess

// Imports per gestionar el color de les imatges
import java.awt.Color;

class App {

    var escena = Escena()

    fun getColor(color: String): Color {
        /*
         * Mètode auxiliar per tal de "traduir" els colors en mode text a la seua
         * representació com a constants en awt.Color
         */

        return when (color) {
            "roig" -> Color.RED
            "verd" -> Color.GREEN
            "blau" -> Color.BLUE
            "groc" -> Color.YELLOW
            "magenta" -> Color.MAGENTA
            "cyan" -> Color.CYAN
            "blanc" -> Color.WHITE
            "negre" -> Color.BLACK
            "gris" -> Color.GRAY
            "grisClar" -> Color.LIGHT_GRAY
            "grisFosc" -> Color.DARK_GRAY
            "rosa" -> Color.PINK
            "taronja" -> Color.ORANGE
            else -> Color.BLACK
        }
    }


    fun addFigura(figura: List<String>) {
        val tipusFigura: String
        tipusFigura = figura[0]
        when (tipusFigura) {
            // TO-DO: Afegir la resta de figures
            "rectangle" -> {
                try {
                    val x = figura[1].toInt()
                    val y = figura[2].toInt()
                    val w = figura[3].toInt()
                    val h = figura[4].toInt()
                    val color = figura[5]

                    // Si tot és correcte creem la figura rectangle
                    var nouRect = Rectangle(x, y, w, h, this.getColor(color))
                    // I l'afegim a la llista
                    escena.add(nouRect)
                } catch (err: Exception) {
                    println("\u001B[31m Arguments incorrectes \u001B[0m");
                }

            }
            "cercle" -> {
                try {
                    val x = figura[1].toInt()
                    val y = figura[2].toInt()
                    val radi = figura[3].toInt()
                    val color = figura[4]

                    // Si tot és correcte creem la figura rectangle
                    var nouCer = Cercle(x, y, radi, this.getColor(color))
                    // I l'afegim a la llista
                    escena.add(nouCer)
                } catch (err: Exception) {
                    println("\u001B[31m Arguments incorrectes \u001B[0m");
                }
            }
            "linia" -> {
                try {
                    val x = figura[1].toInt()
                    val y = figura[2].toInt()
                    val x2 = figura[3].toInt()
                    val y2 = figura[4].toInt()
                    val color = figura[5]

                    // Si tot és correcte creem la figura linia
                    var nouLinia = Linia(x, y, x2, y2, this.getColor(color))
                    // I l'afegim a la llista
                    escena.add(nouLinia)
                } catch (err: Exception) {
                    println("\u001B[31m Arguments incorrectes \u001B[0m");
                }
            }
            "quadrat" -> {
                try {
                    val x = figura[1].toInt()
                    val y = figura[2].toInt()
                    val lado = figura[3].toInt()
                    val color = figura[4]

                    // Si tot és correcte creem la figura quadrat
                    var nouQua = Quadrat(x, y, lado, this.getColor(color))
                    // I l'afegim a la llista
                    escena.add(nouQua)
                } catch (err: Exception) {
                    println("\u001B[31m Arguments incorrectes \u001B[0m");
                }
                // TO-DO: Afegir la resta de figures
            }
            "ellipse" -> {
                try {
                    val x = figura[1].toInt()
                    val y = figura[2].toInt()
                    val r1 = figura[3].toInt()
                    val r2 = figura[4].toInt()
                    val color = figura[5]

                    // Si tot és correcte creem la figura ellipse
                    var nouElli = Ellipse(x, y, r1, r2, this.getColor(color))
                    // I l'afegim a la llista
                    escena.add(nouElli)
                } catch (err: Exception) {
                    println("\u001B[31m Arguments incorrectes \u001B[0m");
                }

            }

            else -> {
                println("\u001B[31m Figura no implementada \u001B[0m");
            }

        } // when

    }

    fun startCli() {
        do {
            // Preguntem la següent figura a emmagatzemar
            print("# Figura: ")

            var ordre: String = readLine()!!

            // Separem l'ordre introduida pel teclat en la forma:
            // "Figura Posicio Mida  Color"
            var components = ordre.split(" ")
            var figura = components[0];

            when (figura) {
                in arrayOf("rectangle", "cercle", "linia", "quadrat", "ellipse") -> {
                    addFigura(components);
                }

                "dimensions" -> {
                    // TO-DO: Agafar les dimensions de l'ordre
                    // i modificar les propietats de l'escena
                    try {
                        escena.tamX = components[1].toInt();
                        escena.tamY = components[2].toInt();
                    }catch (e : Exception){
                        println("La sintaxi es incorrecta: ")
                        println(e)
                    }

                }
                "list" -> escena.renderText()
                "render" -> escena.renderScene()

                "remotelist" -> {
                    try {
                        // Descarrega l'index de figures del servidor remot
                        val liniaFitxers: ArrayList<String>? // Pot ser null
                        liniaFitxers = RemoteManager.download("index.php")
                        // Ús del safe Call Operator
                        var fitxers: List<String>?
                        fitxers = liniaFitxers?.get(0)?.split("<br/>")

                        for (fitxer in fitxers.orEmpty()) {
                            println(fitxer)
                        }

                    } catch (e: Exception) {
                        println("Excepció en la càrrega del fitxer: ")
                        println(e)
                    }


                }

                "get" -> {
                    try {
                        val fitxer: String = components[1]
                        // Descarrega l'index de figures del servidor remot
                        val novesFigures: ArrayList<String>? // Pot ser null
                        novesFigures = RemoteManager.download(fitxer)

                        // Creem una nova escena
                        escena = Escena()

                        // La recorrem
                        for (linia in novesFigures?.get(0)?.split("\n").orEmpty()) {
                            var items: List<String>? = linia.split(" ")

                            when (items!![0]) {
                                in arrayOf("rectangle", "cercle", "linia", "quadrat", "ellipse") -> {
                                    addFigura(items);
                                }

                                "dimensions" -> {
                                    // TO-DO:
                                    // Modificar les dimensions de l'escena
                                    // especificades al fitxer
                                    try{
                                        escena.tamX = items[1].toInt()
                                        escena.tamY = items[2].toInt()

                                    }catch (e :Exception){

                                    }

                                }

                            }// When
                        }


                    } catch (e: Exception) {
                        println("Excepció en la càrrega del fitxer: ")
                        println(e)
                    }
                }

                "quit" -> {
                    exitProcess(0)
                }

                else -> {
                    println("\u001B[31m Figura no reconeguda \u001B[0m");
                }
            }

        } while (true);
    }
}

fun main(args: Array<String>) {
    var myApp = App()
    myApp.startCli()
}
