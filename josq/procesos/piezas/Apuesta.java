package josq.procesos.piezas;

public class Apuesta implements Comparable<Apuesta>
{
    // FINALIZADO
    private String nombre;
    private int monto;
    private int[] posiciones;
    private int puntaje = 0;

    public Apuesta(String nombre, int monto, int[] posiciones) {
        this.nombre = nombre;
        this.monto = monto;
        this.posiciones = posiciones;
    }

    public int getPuntaje()
    {
        return puntaje;
    }
    public void setPuntaje(int puntos)
    {
        puntaje = puntos;
    }

    public int[] getPosiciones() {
        return posiciones;
    }

    public void setPosiciones(int[] posiciones) {
        this.posiciones = posiciones;
    }

    public String informacion()
    {
        return toString() + "," + puntaje;
    }

    @Override
    public String toString() 
    {
        StringBuilder info = new StringBuilder();
        info.append(nombre + ","+monto);
        for (int i = 0; i < posiciones.length; i++) {
            info.append(","+posiciones[i]);
        }
        return info.toString();
    }

    @Override
    public int compareTo(Apuesta o) {
        if (puntaje > o.getPuntaje()) {
            return 1;
        }
        if (puntaje < o.getPuntaje()) {
            return -1;
        }
        if (puntaje == o.getPuntaje()) {
            return 0;
        }
        return 0;
    }

    public String getNombre() {
        return nombre;
    }

}
