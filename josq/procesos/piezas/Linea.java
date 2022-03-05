package josq.procesos.piezas;

public class Linea 
{
    
    private String[] valores;
    private int cantidadValores;

    public Linea(String[] valores) {
        this.valores = valores;
    }

    public Linea(int cantidadValores) {
        this.cantidadValores = cantidadValores;
    }

    public int getCantidadValores() {
        return cantidadValores;
    }

    public void setCantidadValores(int cantidadValores) {
        this.cantidadValores = cantidadValores;
    }

    public String[] getValores() {
        return valores;
    }

    public void setValores(String[] valores) {
        this.valores = valores;
    }

    @Override
    public String toString() {
        StringBuilder v = new StringBuilder();
        for (int i = 0; i < valores.length; i++) {
            if (i == valores.length - 1) {
                v.append(valores[i]);
            } else {
                v.append(valores[i] + ",");
            }

        }

        return v.toString();
    }
}
