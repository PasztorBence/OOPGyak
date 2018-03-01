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
	super(f,"Adatmegjelen�t� panel",true);
	setSize(400,300);
	setLocationRelativeTo(null);
	setResizable(false);

	dp = new JPanel();
	dp.setBackground(hsz);
	dp.setLayout(null);
	this.getContentPane().add( dp);

	JLabel jl00 = new JLabel("A keres�si felt�telnek megfelel� adatok:");
	dp.add(jl00);
	jl00.setBounds(10,10,295,20);
	Font fntf = new Font("Arial",Font.BOLD, 12);
	jl00.setFont(fntf);

	ta = new JTextArea("");					//==== Sz�vegdoboz l�trehoz�sa (t�bbsoros sz�vegekhez)
	ta.setLineWrap(true);					//==== Sort�r�s enged�lyez�se
	ta.setEditable(false);					//==== Szerkeszthet�s�g letilt�sa
	JScrollPane spa = new JScrollPane(ta);			//==== G�rget�panel megad�sa, melynek tartalma a sz�vegdoboz
	dp.add(spa);
	spa.setBounds(10,40,375,180);

	if (!lista.isEmpty()) for (int i=0; i < lista.size(); i++) ta.append(lista.get(i)+"\n");
								//==== Ha van a rugalmas t�mbnek eleme, az elemek soronk�nti megjelen�t�se - \n a sort�r�s k�dja!

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