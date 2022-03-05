package josq.procesos;

import josq.procesos.piezas.Apuesta;
import josq.procesos.piezas.Linea;

public class Filtrador 
{

    // a cada apuesta le corresponde una linea, si la linea contiene los valores 
    // correctos para satisfacer los requerimentos de su apuesta entonces los 
    // valores de la linea se pasaran a los valores de su apuesta (apuesta aprobada),
    // caso contrario la apuesta sera nula (apuesta rechazada)

    // FINALIZADO ** METODO RAIZ **
    public Apuesta[] filtrarLineas(Linea[] lineas)
    { 
        Apuesta[] apuestas = new Apuesta[lineas.length];

        for (int i = 0; i < lineas.length; i++) // n veces
        {
            if (lineas[i].getValores().length == 12) { // 1
                pasosTotal += 1;
                try 
                {
                    String nombre = lineas[i].getValores()[0]; // 1

                    int monto = Integer.parseInt(lineas[i].getValores()[1]); // 1

                    pasosTotal += 2;

                    int[] posiciones = new int[10];
                    for (int j = 2; j <= 11; j++)
                    {
                        posiciones[j-2] = Integer.parseInt(lineas[i].getValores()[j]);
                    } // 10

                    pasosTotal += 10;
                    if(aceptarPosiciones(posiciones)) // 51
                    {
                        apuestas[i] = new Apuesta(nombre, monto, posiciones);
                        pasosTotal += 51;
                    }
                        else
                        {
                            apuestas[i] = null;
                            pasosTotal += 1;
                        }
                }
                    catch (Exception e) 
                    {
                        apuestas[i] = null;
                        pasosTotal += 1;
                    }
            }
                else
                {
                    apuestas[i] = null;
                    pasosTotal += 1;
                }
        }

        return apuestas;
    } // T(n) = n(1+1+1+10+51) = 64n = O(n)

    // FINALIZADO
    boolean[] estaRegistrado = new boolean[10];
    public boolean aceptarPosiciones(int[] posiciones)
    {
        // obligadamente debe ser de 10 posiciones
        if (posiciones.length != 10) // 1
        {
            return false;
        }

        // cada elemento se tiene que registrar una sola vez
        // sino algunas posiciones estan repetidas

        for (int i = 0; i < 10; i++) // 10
        {
            estaRegistrado[i] = false;
        }

        // 0 <= i <= 9
        for (int i = 0; i < 10; i++) // 10 veces
        {
            if (1 <= posiciones[i] & posiciones[i] <= 10)  // 2
            {
                if(!estaRegistrado[posiciones[i] - 1]) // 1
                {
                    estaRegistrado[posiciones[i] - 1] = true; // 1
                }
                    else
                    {
                        return false;
                    }
            }
                else 
                {
                    return false;
                }
        }
        return true;
    } // T(n) = 1 + 10*1 + 10*(2+1+1) = 51 = O(1)


    private int pasosTotal = 0;
    public int getPasosTotal()
    {
        int temp = pasosTotal;
        pasosTotal = 0;
        return temp;
    }

}
