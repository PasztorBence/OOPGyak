import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.util.ArrayList;

public class AutoLp extends JDialog {
	private Color hsz = new Color(247,240,213);
	public JPanel dp;
	private JTextArea ta;
	private JButton okb;


    public AutoLp (JFrame f, ArrayList<String> lista) {
	super(f,"Adatmegjelenítõ panel",true);
	setSize(400,300);
	setLocationRelativeTo(null);
	setResizable(false);

	dp = new JPanel();
	dp.setBackground(hsz);
	dp.setLayout(null);
	this.getContentPane().add( dp);

	JLabel jl00 = new JLabel("A keresési feltételnek megfelelõ adatok:");
	dp.add(jl00);
	jl00.setBounds(10,10,295,20);
	Font fntf = new Font("Arial",Font.BOLD, 12);
	jl00.setFont(fntf);

	ta = new JTextArea("");					//==== Szövegdoboz létrehozása (többsoros szövegekhez)
	ta.setLineWrap(true);					//==== Sortörés engedélyezése
	ta.setEditable(false);					//==== Szerkeszthetõség letiltása
	JScrollPane spa = new JScrollPane(ta);			//==== Görgetõpanel megadása, melynek tartalma a szövegdoboz
	dp.add(spa);
	spa.setBounds(10,40,375,180);

	if (!lista.isEmpty()) for (int i=0; i < lista.size(); i++) ta.append(lista.get(i)+"\n");
								//==== Ha van a rugalmas tömbnek eleme, az elemek soronkénti megjelenítése - \n a sortörés kódja!

	okb = new JButton();
        okb.setText(" OK");
	dp.add(okb);
	okb.setBounds(150,230,100,26);
	okb.addActionListener( new ActionListener() {    
	    public void actionPerformed( ActionEvent e ) { 
		dispose(); setVisible(false);
	    }
	});

    }

}