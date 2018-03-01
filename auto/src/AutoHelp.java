import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.util.ArrayList;


public class AutoHelp extends JDialog {
	private Color hsz = new Color(247,240,213);
	public JPanel dp;
	private JTextArea ta;
	private JButton okb;


    public AutoHelp (JFrame f) {
	super(f,"HELP",true);
	setSize(400,300);
	setLocationRelativeTo(null);
	setResizable(false);

	dp = new JPanel();
	dp.setBackground(hsz);
	dp.setLayout(null);
	this.getContentPane().add( dp);

	ta = new JTextArea("");	
	ta.setLineWrap(true);
	ta.setEditable(false);
	final JScrollPane spa = new JScrollPane(ta);
	dp.add(spa);
	spa.setBounds(10,10,375,210);

	ta.append("A program haszn�lat�nak r�vid le�r�sa\n\n");

	ta.append("A program h�rom oszt�lyb�l �ll:\n");
	ta.append("- AutoTxtProgram.java - a programablak k�dja\n");
	ta.append("- AutoLp.java - a list�kat megjelen�t� ablak k�dja\n");
	ta.append("- AutoHelp.java - a Help ablak k�dja\n\n");
	ta.append("Ind�t�skor automatikusan l�trej�n az Aut�AdatB.txt f�jl, abba a k�nyvt�rba, ahonnan a program elindul, �res fejl�ccel,");
	ta.append(" �rt�kes adatok n�lk�l. A Lista ilyenkor �res.\n");
	ta.append("A Felt�lt gomb megnyom�sakor 10 adatsor ker�l a f�jlba.\n");
	ta.append("A Besz�r gombbal a f�jl v�g�re besz�rhat� egy adatsor, az adatokat a beviteli mez�kbe kell be�rni. FONTOS: nincs ellen�rz�s,");
	ta.append(" �gy �res adatsort is besz�rhatunk.\n");
	ta.append("A RESET gomb t�rli a besz�r�s �sszes adatbeviteli mez�j�nek a tartalm�t.\n");
	ta.append("A Keres �s a T�r�l funkci�k sz� eleji egyez�st vizsg�lnak, �gy ha a C-k�nt megadott rendsz�mra keres�nk, megjelenik az �sszes");
	ta.append(" C-vel kezd�d� rendsz�m� aut�.\n");
	ta.append("\n(c) by BitMan, 2017.09.12");

	javax.swing.SwingUtilities.invokeLater(new Runnable() {	
	   public void run() { 
       	       spa.getVerticalScrollBar().setValue(0);			//==== A g�rget�panelen a l�that� ter�let fel�l legyen
   	   }
	});

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