package josq.procesos;

import josq.procesos.piezas.Apuesta;

public class Ordenador {

    // SE UTILIZO ES EL ORDENAMIENTO DE BURBUJA YA QUE ES UN ALGORITMO QUE OFRECE 
    // UNA COMPLEJIDAD (O^2) (QUE SE PUEDE VERIFICAR EN LOS COMENTARIOS DE CADA METODO)
    // Y QUE CUMPLE CORRECTAMENTE SEGUN LO REQUERIDO POR EL CLIENTE

    // ORDENAMIENTO DE BURBUJA
    public void porPuntaje(Apuesta[] apuestas) {
        pasosTotal = 0;
        int n = apuestas.length; 
        for (int i = 0; i < n - 1; i++) {  // n - 1 veces
            for (int j = 0; j < n - 1 - i; j++) { // 0 <= j <= n - 2 - i
                if (apuestas[j].getPuntaje() > apuestas[j + 1].getPuntaje()) { // 1
                    Apuesta temp = apuestas[j]; // 1
                    apuestas[j] = apuestas[j + 1]; // 1
                    apuestas[j + 1] = temp; // 1

                    pasosTotal += 4;
                }
            }
        }
    } // T(n) = 4(n-1)+4(n-2)+...+4(2)+4(1)=2(n-1)n = O(n^2)


    // ORDENAMIENTO DE BURBUJA
    public void porNombre(Apuesta[] apuestas) {
        pasosTotal = 0;
        int n = apuestas.length;
        for (int i = 0; i < n - 1; i++) {  // n - 1 veces
            for (int j = 0; j < n - 1 - i; j++) { // 0 <= j <= n - 2 - i
                if (apuestas[j].getNombre().compareTo(apuestas[j + 1].getNombre()) > 0) { // 1
                    Apuesta temp = apuestas[j]; // 1
                    apuestas[j] = apuestas[j + 1]; // 1
                    apuestas[j + 1] = temp; // 1

                    pasosTotal += 4;
                }
            }
        }
    } // T(n) = 4(n-1)+4(n-2)+...+4(2)+4(1)=2(n-1)n = O(n^2)

    private int pasosTotal = 0;
    public int getPasosTotal()
    {
        return pasosTotal;
    }

}
