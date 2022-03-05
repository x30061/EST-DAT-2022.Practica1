package josq.interfaz.ventanas;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.PrintWriter;
import javax.swing.SwingConstants;
import josq.interfaz.contenedores.*;
import josq.interfaz.controles.*;
import josq.interfaz.selectores.*;
import josq.interfaz.texto.*;
import josq.procesos.Calificador;
import josq.procesos.Filtrador;
import josq.procesos.Ingresador;
import josq.procesos.Ordenador;
import josq.procesos.piezas.Apuesta;
import josq.procesos.piezas.Linea;

public class Principal 
{

    // >>> INICIO acceso rapido a: fuente, paleta de colores
    private Color cFondoTexto = new Color(20,20,20);
    private Color cTexto = new Color(0,230,230);
    private Color cFondoTexto2 = new Color(30,30,30);
    private Color cTexto2 = new Color(90,180,0);
    private Color cResaltado = new Color(100,0,30);

    private String fontPackage = "/interfaz/fuentes/";
    private String fontName = "JetBrainsMono-Regular.ttf";
    private float fontSize = 13.5f;
    private Font fuente;
    // <<< FIN

    private JFileChooser1 fcArchivo = new JFileChooser1();

    private JFrame1 fPrincipal = new JFrame1("APUESTAS");

    private JButton1 bElegirArchivo = new JButton1("ELEGIR", 100, 26);
    private JButton1 bCargarApuestas = new JButton1("CARGAR", 100, 26);
    private JButton1 bFiltrarApuestas = new JButton1("FILTRAR", 100, 26);
    private JButton1 bResultadoCarrera = new JButton1("AJUSTAR", 100, 26);
    private JButton1 bCalificarApuestas = new JButton1("CALIFICAR", 100, 26);
    private JButton1 bPorNombre = new JButton1("POR NOMBRE", 100, 26);
    private JButton1 bPorPuntaje = new JButton1("POR PUNTAJE", 100, 26);


    private int pX = 40;
    private JTextField1 fP1 = new JTextField1(pX, 26);
    private JTextField1 fP2 = new JTextField1(pX, 26);
    private JTextField1 fP3 = new JTextField1(pX, 26);
    private JTextField1 fP4 = new JTextField1(pX, 26);
    private JTextField1 fP5 = new JTextField1(pX, 26);
    private JTextField1 fP6 = new JTextField1(pX, 26);
    private JTextField1 fP7 = new JTextField1(pX, 26);
    private JTextField1 fP8 = new JTextField1(pX, 26);
    private JTextField1 fP9 = new JTextField1(pX, 26);
    private JTextField1 fP10 = new JTextField1(pX, 26);

    private String infoArchivo  = "<html><center>ELIJA UN ARCHIVO DE TEXTO QUE CONTENGA LAS APUESTAS, CARGUELAS A ESTE PROGRAMA LUEGO FILTRELAS SEGUN SU APROBACION</center></html>";
    private String infoResultadoCarrera = "<html><center>INGRESE TODOS LOS NUMEROS DE LOS CABALLOS SEGUN EL ORDEN EN EL QUE ESTOS LLEGUEN A LA META SIENDO EL PRIMER CAMPO DESDE LA IZQUIERDA EL PRIMERO EN LLEGAR</center></html>";
    private JLabel1 lElegirArchivo = new JLabel1(infoArchivo, 600, 42);
    private JLabel1 lInfoResultadoCarrera = new JLabel1(infoResultadoCarrera, 600, 42);
    private String infoCalificacion = "<html><center>CALIFIQUE LAS APUESTAS APROBADAS RESPECTO AL ORDEN ANTERIOR Y ORDENELAS SEGUN EL PUNTAJE OBTENIDO O POR EL NOMBRE DEL APOSTADOR</center></html>";
    private JLabel1 lInfoCalificacion = new JLabel1(infoCalificacion, 600, 42);

    private JLabel1 lPathArchivo = new JLabel1("", SwingConstants.CENTER, 500, 26);
    private JLabel1 lCargarApuestas = new JLabel1("", SwingConstants.CENTER, 500, 26);
    private JLabel1 lFiltrarApuestas = new JLabel1("", SwingConstants.CENTER, 500, 26);
    private JLabel1 lResultadoCarrera = new JLabel1("", SwingConstants.CENTER, 500, 26);
    private JLabel1 lCalificarApuestas = new JLabel1("", SwingConstants.CENTER, 500, 26);


    private JLabel1 lPorNombre = new JLabel1("", SwingConstants.CENTER, 500, 26);
    private JLabel1 lPorPuntaje = new JLabel1("", SwingConstants.CENTER, 500, 26);


    private int altura = 1;
    private int ancho = 640;
    private JLabel1 separador1 = new JLabel1("", SwingConstants.CENTER, ancho, altura);
    private JLabel1 separador2 = new JLabel1("", SwingConstants.CENTER, ancho, altura);
    private JLabel1 separador3 = new JLabel1("", SwingConstants.CENTER, ancho, altura);

    public void inicio()
    {

        bElegirArchivo.addActionListener(acciones);
        bCargarApuestas.addActionListener(acciones);
        bFiltrarApuestas.addActionListener(acciones);
        bResultadoCarrera.addActionListener(acciones);
        bCalificarApuestas.addActionListener(acciones);
        bPorNombre.addActionListener(acciones);
        bPorPuntaje.addActionListener(acciones);

        //fcArchivo.setFilter(".txt", new String[] {"txt","TXT"});
        lElegirArchivo.setForeground(cTexto);
        fPrincipal.add(lElegirArchivo);
        fPrincipal.add(bElegirArchivo);
        lPathArchivo.setForeground(cTexto2);
        lPathArchivo.backgroundSettings(cFondoTexto2);
        fPrincipal.add(lPathArchivo);

        fPrincipal.add(bCargarApuestas);
        lCargarApuestas.setForeground(cTexto2);
        lCargarApuestas.backgroundSettings(cFondoTexto2);
        fPrincipal.add(lCargarApuestas);

        fPrincipal.add(bFiltrarApuestas);
        lFiltrarApuestas.setForeground(cTexto2);
        lFiltrarApuestas.backgroundSettings(cFondoTexto2);
        fPrincipal.add(lFiltrarApuestas);


        // SEPARADOR
        //fPrincipal.add(separador1);


        fPrincipal.add(lInfoResultadoCarrera);
        lInfoResultadoCarrera.setForeground(cTexto);

        // SEPARADOR
        fPrincipal.add(separador2);

        fPrincipal.add(fP1);
        fPrincipal.add(fP2);
        fPrincipal.add(fP3);
        fPrincipal.add(fP4);
        fPrincipal.add(fP5);
        fPrincipal.add(fP6);
        fPrincipal.add(fP7);
        fPrincipal.add(fP8);
        fPrincipal.add(fP9);
        fPrincipal.add(fP10);
        

        // SEPARADOR
        fPrincipal.add(separador3);

        fPrincipal.add(bResultadoCarrera);
        lResultadoCarrera.setForeground(cTexto2);
        lResultadoCarrera.backgroundSettings(cFondoTexto2);
        fPrincipal.add(lResultadoCarrera);

        lInfoCalificacion.setForeground(cTexto);
        lInfoCalificacion.backgroundSettings(cFondoTexto);
        fPrincipal.add(lInfoCalificacion);

        fPrincipal.add(bCalificarApuestas);
        lCalificarApuestas.setForeground(cTexto2);
        lCalificarApuestas.backgroundSettings(cFondoTexto2);
        fPrincipal.add(lCalificarApuestas);

        fPrincipal.add(bPorNombre);
        lPorNombre.setForeground(cTexto2);
        lPorNombre.backgroundSettings(cFondoTexto2);
        fPrincipal.add(lPorNombre);

        fPrincipal.add(bPorPuntaje);
        lPorPuntaje.setForeground(cTexto2);
        lPorPuntaje.backgroundSettings(cFondoTexto2);
        fPrincipal.add(lPorPuntaje);

        fPrincipal.sizeSettings(false,660,500);
        fPrincipal.getContentPane().setBackground(cFondoTexto);
        fPrincipal.locationSettings();
    }

    private File archivo;
    private Linea[] lineas;
    private Apuesta[] apuestasConNulos;
    private Apuesta[] apuestasSinNulos;
    private int apuestasAprobadas = 0;
    private int[] ordenFinCarrera = new int[10]; // NUNCA ASIGNARLO A NULL!
    private Ingresador ingresador = new Ingresador();
    private Filtrador filtrador = new Filtrador();
    private Ordenador ordenador = new Ordenador();
    private Calificador calificador = new Calificador();

    void reiniciarCargar()
    {
        lineas = null;
        apuestasConNulos = null;
        apuestasSinNulos = null;

        apuestasAprobadas = 0;
        lCargarApuestas.setText("");
        lFiltrarApuestas.setText("");
        lCalificarApuestas.setText("");
        lPorNombre.setText("");
        lPorPuntaje.setText("");

    }
    void reiniciarFiltrar()
    {
        apuestasConNulos = null;
        apuestasSinNulos = null;

        apuestasAprobadas = 0;
        lFiltrarApuestas.setText("");
        lCalificarApuestas.setText("");
        lPorNombre.setText("");
        lPorPuntaje.setText("");

    }
    void reiniciarAjustar()
    {
        apuestasConNulos = null;
        apuestasSinNulos = null;

        apuestasAprobadas = 0;
        lFiltrarApuestas.setText("");
        lCalificarApuestas.setText("");
        lPorNombre.setText("");
        lPorPuntaje.setText("");
    }

    void reiniciarCalificar()
    {
        lPorNombre.setText("");
        lPorPuntaje.setText("");
    }

    private ActionListener acciones = new ActionListener()
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            switch (e.getActionCommand()) 
            {
                case "ELEGIR":
                    reiniciarCargar();
                    try 
                    {
                        archivo = fcArchivo.getFile(fPrincipal);
                        lPathArchivo.setText(archivo.getPath());
                    }
                        catch (Exception e1) 
                        {
                        }
                    break;
                case "CARGAR":
                    reiniciarCargar();
                    try 
                    {
                        lineas = ingresador.llenarLineas(archivo);

                        lCargarApuestas.setText("encontradas="+lineas.length);
                    } 
                        catch (Exception e2) 
                        {
                        }
                    break;
                case "FILTRAR":
                    reiniciarFiltrar();
                    try 
                    {
                        long t1 = System.nanoTime();
                        // CRITICO CRITICO CRITICO CRITICO CRITICO CRITICO CRITICO CRITICO
                        apuestasConNulos = filtrador.filtrarLineas(lineas);
                        long t2 = System.nanoTime();

                        for (int i = 0; i < apuestasConNulos.length; i++) {
                            if (apuestasConNulos[i] != null) 
                            {
                                apuestasAprobadas += 1;
                            }
                        }

                        apuestasSinNulos = new Apuesta[apuestasAprobadas];
                        int apuestasNoNulas = 0;
                        for (int i = 0; i < apuestasConNulos.length; i++) {
                            if (apuestasConNulos[i] != null) {
                                apuestasSinNulos[apuestasNoNulas] = apuestasConNulos[i];
                                apuestasNoNulas += 1;
                            }
                        }

                        lFiltrarApuestas.setText("rechazadas="+(lineas.length-apuestasAprobadas)+" tiempo-promedio="+((t2-t1)/lineas.length)+" pasos-promedio="+(filtrador.getPasosTotal()/lineas.length));
                        exportar("RECHAZADAS");
                    } 
                        catch (Exception e3) 
                        {
                        }
                    break;
                case "AJUSTAR":
                    ajustarPosiciones();
                    break;
                case "CALIFICAR":
                    reiniciarCalificar();
                    try 
                    {
                        // TIEMPO
                        long t1 = System.nanoTime();
                        // CRITICO CRITICO CRITICO CRITICO CRITICO CRITICO CRITICO CRITICO
                        calificador.calificarApuestas(apuestasSinNulos, ordenFinCarrera);
                        long t2 = System.nanoTime();

                        lCalificarApuestas.setText("tiempo-promedio="+((t2-t1)/apuestasSinNulos.length)+" pasos-promedio="+(calificador.getPasosTotal()/apuestasSinNulos.length));
                    } 
                        catch (Exception e3) 
                        {
                        }
                    break;
                case "POR NOMBRE":
                    try 
                    {
                        // TIEMPO
                        long t1 = System.nanoTime();
                        // CRITICO CRITICO CRITICO CRITICO CRITICO CRITICO CRITICO CRITICO
                        ordenador.porNombre(apuestasSinNulos);
                        long t2 = System.nanoTime();

                        lPorNombre.setText("tiempo-promedio="+((t2-t1)/apuestasSinNulos.length)+" pasos-promedio="+(ordenador.getPasosTotal()/apuestasSinNulos.length));

                        lPorPuntaje.setText("");
                        exportar("APROBADAS");
                    } 
                        catch (Exception e4) 
                        {
                        }
                    break;
                case "POR PUNTAJE":
                    try 
                    {
                        // TIEMPO
                        long t1 = System.nanoTime();
                        // CRITICO CRITICO CRITICO CRITICO CRITICO CRITICO CRITICO CRITICO
                        ordenador.porPuntaje(apuestasSinNulos);
                        long t2 = System.nanoTime();

                        lPorPuntaje.setText("tiempo-promedio="+((t2-t1)/apuestasSinNulos.length)+" pasos-promedio="+(ordenador.getPasosTotal()/apuestasSinNulos.length));

                        lPorNombre.setText("");
                        exportar("APROBADAS");
                    } 
                        catch (Exception e4) 
                        {
                        }
                    break;
                default:
                    break;
            }
        }
    };

    void ajustarPosiciones()
    {
        try
        {
            ordenFinCarrera[0] = Integer.parseInt(fP1.getText());
            ordenFinCarrera[1] = Integer.parseInt(fP2.getText());
            ordenFinCarrera[2] = Integer.parseInt(fP3.getText());
            ordenFinCarrera[3] = Integer.parseInt(fP4.getText());
            ordenFinCarrera[4] = Integer.parseInt(fP5.getText());
            ordenFinCarrera[5] = Integer.parseInt(fP6.getText());
            ordenFinCarrera[6] = Integer.parseInt(fP7.getText());
            ordenFinCarrera[7] = Integer.parseInt(fP8.getText());
            ordenFinCarrera[8] = Integer.parseInt(fP9.getText());
            ordenFinCarrera[9] = Integer.parseInt(fP10.getText());

            if (filtrador.aceptarPosiciones(ordenFinCarrera)) {
                StringBuilder pos = new StringBuilder();
                for (int i = 0; i < ordenFinCarrera.length; i++) 
                {
                    pos.append("["+(i+1)+"]="+ordenFinCarrera[i]+"  ");
                }
                lResultadoCarrera.setText(pos.toString());
            }
                else
                {
                    lResultadoCarrera.setText("POSICIONES RECHAZADAS");
                }
        } 
            catch (Exception e1) 
            {
                lResultadoCarrera.setText("POSICIONES RECHAZADAS");
            }
    }

    void exportar(String tipo)
    {
        File txt = fcArchivo.getFile(fPrincipal);
        //System.out.println(txt.getPath());
        
        try(PrintWriter pwTexto = new PrintWriter(txt);)
        {
            switch (tipo) {
                case "APROBADAS":
                    for (int i = 0; i < apuestasSinNulos.length; i++) {
                        pwTexto.print(apuestasSinNulos[i].informacion() + "\n");
                    }
                    break;
                case "RECHAZADAS":
                    for (int i = 0; i < apuestasConNulos.length; i++) {
                        if (apuestasConNulos[i] == null) {
                            pwTexto.print(lineas[i].toString()+"\n");
                        }
                    }
                    break;

                default:
                    break;
            }
            
        } 
        catch (Exception e) 
            {
                //System.out.println("[!] exportar()");
            }
    }

}
