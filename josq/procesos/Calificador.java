package josq.procesos;

import josq.procesos.piezas.Apuesta;

public class Calificador {

    // FINALIZADO ** METODO RAIZ **
    public void calificarApuestas(Apuesta[] apuestas, int[] posicionesFinCarrera)
    {
        for (int i = 0; i < apuestas.length; i++) // 0 <= i <= n - 1, n veces
        {
            int puntos = getPuntaje(apuestas[i].getPosiciones(), posicionesFinCarrera); // 20
            apuestas[i].setPuntaje(puntos); // 1

            pasosTotal += 21;
        }
    } // T(n) = 21n = O(n)

    // FINALIZADO
    public int getPuntaje(int[] posicionesApuesta, int[] posicionesFinCarrera)
    {
        int puntaje = 0;
        for (int i = 0; i < 10; i++) // 10 veces
        {
            if (posicionesFinCarrera[i] == posicionesApuesta[i]) // 1
            {
                puntaje = puntaje + (10-i); // 1
            }
        }
        return puntaje;
    } // T(n) = 10*2 = 20 = O(1)


    private int pasosTotal = 0;
    public int getPasosTotal()
    {
        int temp = pasosTotal;
        pasosTotal = 0;
        return temp;
    }


}
