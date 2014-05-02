/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kalaha.kayttoliittyma;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author Krista
 * Luokka luo napit Alkukayttoliittymaan.
 */
public class AlunValikko extends JPanel {

    private ValikonKuuntelija kuuntelija;

    public AlunValikko(ValikonKuuntelija v) {
        super(new GridLayout(1, 3));
        luoKomponentit();
        kuuntelija = v;
    }

    private void luoKomponentit() {

        JButton a = new JButton("4 pistettä");
        a.setActionCommand("4");
        add(a);
        a.addActionListener(new ValikonKuuntelija());
        JButton b = new JButton("6 pistettä");
        b.setActionCommand("6");
        add(b);
        b.addActionListener(new ValikonKuuntelija());
        JButton c = new JButton("8 pistettä");
        c.setActionCommand("8");
        add(c);
        c.addActionListener(new ValikonKuuntelija());
    }
}
