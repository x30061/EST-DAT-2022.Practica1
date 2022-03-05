package josq.procesos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import josq.procesos.piezas.Linea;

// obtener los valores de cada linea del archivo CSV
public class Ingresador 
{
    // obtener cantidad de lineas
    // crear un arreglo de Lineas segun la cantidad de lineas
    // por cada linea hallar cantidad de comas, eso determina la cantidad de valores
    // crear por cada linea un arreglo con la cantidad de valores segun comas halladas
    // despues recorrer el archivo en cada linea caracter por caracter
    // e ir generando cada valor e ingresarlo en un arreglo de valores de cada linea

    /*
    ASCII control characters 
    DEC="10" Symbol="LF" Description="Line Feed"
    DEC="13" Symbol="CR" Description="Carriage Return"
    SALTO = \r|\n|\r\n
    
    ASCII printable characters 
    DEC="44" Symbol="," Description="Comma"
    */

    // FINALIZADO ** METODO RAIZ **
    public Linea[] llenarLineas(File txt)
    {
        Linea[] lineas = crearLineas(txt); // n + 6m + 5

        try (FileReader lector = new FileReader(txt);) 
        {
            int lineaActual = 0; // 1
            int comas = 0; // 1
            int caracterActual = 0; // 1
            String valorActual = ""; // 1

            while (caracterActual != -1) // m
            {
                caracterActual = lector.read(); // 1

                if (caracterActual == 10 | caracterActual == -1) // 2
                {
                    // acceder a los valores de la linea
                    // si hay una coma guardar cada valor encontrado en su espacio respectivo
                    // si hay un line feed pasar a siguiente linea y repetir lo mismo

                    lineas[lineaActual].getValores()[comas] = valorActual; // 1

                    comas = 0; // 1
                    lineaActual += 1; // 1
                    valorActual = ""; // 1
                } // 6
                    else
                    {
                        if (caracterActual != 13) // 1
                        {
                            if (caracterActual != 44) // 1
                            {
                                valorActual = valorActual + (char) caracterActual; // 1
                            } // 5
                                else
                                {
                                    lineas[lineaActual].getValores()[comas] = valorActual; // 1

                                    valorActual = ""; // 1
                                    comas += 1; // 1
                                } // 7
                        }
                    }
            }
        }
            catch (Exception e) 
            {
                //System.out.println("[!] llenarLineas()");
            }

        return lineas;
    } // T(n) = n + 6m + 5 + 4 + 7m = n + 13m + 9 = O(n+m)

    public Linea[] crearLineas(File txt)
    {
        Linea[] valores = new Linea[getCantidadLineas(txt)]; // n + 1

        try (FileReader lector = new FileReader(txt);) 
        {
            int lineaActual = 0; // 1
            int comas = 0; // 1
            int caracterActual = 0; // 1

            while (caracterActual != -1) // m
            {
                caracterActual = lector.read(); // 1

                if (caracterActual == 10 | caracterActual == -1) // 2
                {
                    // cada objeto Linea debe tener un arreglo de Strings que
                    // contiene los valores en esa linea (en el archivo CSV)
                    valores[lineaActual] = new Linea(new String[comas + 1]); // 1

                    comas = 0; // 1
                    lineaActual += 1; // 1
                }
                    else
                    {
                        if (caracterActual == 44)
                        {
                            comas += 1;
                        }
                    }
            }
        }
            catch (Exception e) 
            {
                //System.out.println("[!] crearLineas()");
            }
        
        return valores;
    } // T(n) = n+1+3+6m = n + 6m + 4 = O(n+m)

    public int getCantidadLineas(File txt)
    {
        try (FileReader l1 = new FileReader(txt);
            BufferedReader l2 = new BufferedReader(l1);) 
        {
            int lineas = 0;
            while (l2.readLine() != null) // n veces
            {
                lineas += 1;
            }

            return lineas;
        }
            catch (Exception e) 
            {
                //System.out.println("[!] getCantidadLineas()");
            }
        return 0;
    } // T(n) = n = O(n)
}
