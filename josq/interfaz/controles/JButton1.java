package josq.interfaz.controles;

import java.awt.Dimension;
import java.awt.Insets;
import javax.swing.JButton;

public class JButton1 extends JButton
{
    public JButton1(String text, int width, int height)
    {
        super(text);
        setMargin(new Insets(0, 0, 0, 0));
        setPreferredSize(new Dimension(width, height));
    }
}

