@file:JvmName("RemoteManager")

package com.ieseljust.kscenemaker

/*import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;*/

import java.net.URL
import java.net.URLConnection
//import java.util.ArrayList;

object RemoteManager {
    /*
     * Aquest objecte s'encarrega de comunicar-se amb un servidor extern
     * (joamuran.net/EDD), que ens proporciona figures ja dibuixades, per tal de no
     * haver d'estar dibuixant-les cada vegada.
     */

    public fun download(filename:String):ArrayList<String>? {
        /*
        Retorna una llista de cadenes de text amb el contingut del fitxer `filename`,
        descarregat del servidor.
        */

        
        var linies: ArrayList<String> = arrayListOf<String>()
        

        try {
            val myURL:URL = URL("http://joamuran.net/EDD/" + filename)

            // Determinem el tipus de fitxer
            val uc:URLConnection = myURL.openConnection()
            val data = uc.inputStream.bufferedReader().use { it.readText() }
    
            linies.add(data)
            return linies;

        }  catch (e: Exception) {
            println("Error")
            return null
        }

    }

}
