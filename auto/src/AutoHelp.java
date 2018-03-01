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

	ta.append("A program használatának rövid leírása\n\n");

	ta.append("A program három osztályból áll:\n");
	ta.append("- AutoTxtProgram.java - a programablak kódja\n");
	ta.append("- AutoLp.java - a listákat megjelenítõ ablak kódja\n");
	ta.append("- AutoHelp.java - a Help ablak kódja\n\n");
	ta.append("Indításkor automatikusan létrejön az AutóAdatB.txt fájl, abba a könyvtárba, ahonnan a program elindul, üres fejléccel,");
	ta.append(" értékes adatok nélkül. A Lista ilyenkor üres.\n");
	ta.append("A Feltölt gomb megnyomásakor 10 adatsor kerül a fájlba.\n");
	ta.append("A Beszúr gombbal a fájl végére beszúrható egy adatsor, az adatokat a beviteli mezõkbe kell beírni. FONTOS: nincs ellenõrzés,");
	ta.append(" így üres adatsort is beszúrhatunk.\n");
	ta.append("A RESET gomb törli a beszúrás összes adatbeviteli mezõjének a tartalmát.\n");
	ta.append("A Keres és a Töröl funkciók szó eleji egyezést vizsgálnak, így ha a C-ként megadott rendszámra keresünk, megjelenik az összes");
	ta.append(" C-vel kezdõdõ rendszámú autó.\n");
	ta.append("\n(c) by BitMan, 2017.09.12");

	javax.swing.SwingUtilities.invokeLater(new Runnable() {	
	   public void run() { 
       	       spa.getVerticalScrollBar().setValue(0);			//==== A görgetõpanelen a látható terület felül legyen
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