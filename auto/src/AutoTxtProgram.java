import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.io.*;
import java.util.ArrayList;

public class AutoTxtProgram extends JFrame {
	private Color hsz = new Color(202,211,227);
	public JPanel dp;
	private JTextField jtrsz, jttip, jtszin, jtgyev, jtar, jtrszk, jtszink, jtrszt;
	private JButton listab, ujadatb, keresb, keres2b, torolb, bezar, resetb, feltoltb, helpb, kod1b, kod2b, kod3b,modositb;
	private String fnev="Aut�AdatB.txt";

    public AutoTxtProgram () {
	setTitle(" CSV f�jlkezel� programocska");	//==== Az ablak neve
	setSize(450,400);				//==== Ablak m�rete
	setLocationRelativeTo(null);			//==== Ablak k�z�pre ker�l
	setResizable(false);				//==== �tm�retezhet�s�g letilt�sa

	dp = new JPanel();				//==== Grafikus panel l�trehoz�sa
	dp.setBackground(hsz);				//==== H�tt�rsz�n megad�sa
	dp.setLayout(null);				//==== Elemek automatikus elrendez�s�nek kikapcsol�sa
	this.getContentPane().add(dp);			//==== Az ablakhoz hozz�adjuk a grafikus panelt
//============
	
	boolean van = (new File("Aut�AdatB.txt")).exists(); 	//==== L�tezik a f�jl?
	if (!van) FileMaker();					//==== Ha nem l�tezik, l�trehozzuk a f�jlt
//============
	listab = new JButton();					//==== Nyom�gomb l�trehoz�sa
        listab.setText(" Lista");				//==== Nyom�gomb felirata
	dp.add(listab);						//==== Nyom�gombot hozz�adjuk a grafikus panelhez
	listab.setBounds(20,10,100,26);				//==== Nyom�gomb helye (balr�l 20, fentr�l 10 px), m�rete (100 px sz�les, 26 px magas)
	listab.addActionListener( new ActionListener() {    	//==== Nyom�gombhoz esem�nyfigyel� interf�sz rendel�se
	    public void actionPerformed( ActionEvent e ) { 	//==== Gombnyom�s esem�ny kezel�je
		ArrayList<String> lista = new ArrayList<String>();	//==== Rugalmas m�ret�, String t�pus� t�mb l�trehoz�sa

		try {
	    	    FileInputStream f=new FileInputStream(fnev);				//==== Bin�ris f�jlt beolvas� oszt�ly (f�jl megnyit�sa olvas�sra)
	    	    LineNumberReader in=new LineNumberReader(new InputStreamReader(f));		//==== Egy sort beolvas� oszt�ly p�ld�nyos�t�sa
	    	    String s=in.readLine();							//==== Egy sor beolvas�sa egy stringbe
		    s=in.readLine();
		    s=in.readLine();
	    	    while(s != null) {								//==== Ha nem �res a string
		        lista.add(s);								//==== A string hozz�ad�sa a rugalmas t�mbh�z
 	                s=in.readLine();
	    	    }
	    	    in.close();									//==== A f�jl lez�r�sa
		}catch (Exception ioe) {JOptionPane.showMessageDialog(null,""+ioe.getMessage(),"Aut�AdatB.txt f�jl hiba!",0);}
		AutoLp lp = new AutoLp(null, lista);						//==== AutoLp (megjelen�t�panel) p�ld�nyos�t�sa, rugalmas t�mb �tad�sa
		lp.setVisible(true);								//==== Az lp p�ld�ny megjelen�t�se
	    }
	});
//============
	feltoltb = new JButton();
        feltoltb.setText(" Felt�lt");
	dp.add(feltoltb);
	feltoltb.setBounds(170,10,100,26);
	feltoltb.addActionListener( new ActionListener() {    
	    public void actionPerformed( ActionEvent e ) {
		BasicData();
		JOptionPane.showMessageDialog(null,"10 adatsor beker�lt a f�jlba.","F�jlkezel�si m�velet t�rt�nt",1);
	    }
	});
//=====modositas======
	modositb=new JButton();
	modositb.setText("modositas");
	dp.add(modositb);
	modositb.setBounds(300,150,110,30);
//============
	helpb = new JButton();
        helpb.setText(" Help");
	dp.add(helpb);
	helpb.setBounds(330,10,100,26);
	helpb.addActionListener( new ActionListener() {    
	    public void actionPerformed( ActionEvent e ) {
		AutoHelp fkh = new AutoHelp(null);
		fkh.setVisible(true);
		listab.setEnabled(true);
		ujadatb.setEnabled(true);
		keresb.setEnabled(true);
		keres2b.setEnabled(true);
		torolb.setEnabled(true);
		resetb.setEnabled(true);
		feltoltb.setEnabled(true);

	    }
	});
//============
	int y=60;
	JLabel l1 = new JLabel("Rendszám   Típus                 Szín                 Gyárt_év   ár");
	dp.add(l1);
	l1.setBounds(20,y,400,20);					//==== JLabel - felirat
	y+=25;
	jtrsz = new JTextField("",10);					//==== JTextField - sz�vegbeviteli mez�
	dp.add(jtrsz);
	jtrsz.setBounds(20,y,60,20);

	jttip = new JTextField("",10);
	dp.add(jttip);
	jttip.setBounds(85,y,120,20);

	jtszin = new JTextField("",10);
	dp.add(jtszin);
	jtszin.setBounds(210,y,90,20);

	jtgyev = new JTextField("",10);
	dp.add(jtgyev);
	jtgyev.setBounds(305,y,45,20);

	jtar = new JTextField("",10);
	dp.add(jtar);
	jtar.setBounds(355,y,70,20);

	ujadatb = new JButton();
        ujadatb.setText(" Beszúr");
	dp.add(ujadatb);
	ujadatb.setBounds(20,y+30,100,26);
	ujadatb.addActionListener( new ActionListener() {    
	    public void actionPerformed( ActionEvent e ) { 
		String x=";";						//==== A csv f�jl szepar�tora a ;
		String rsz = jtrsz.getText().toString();		//==== Sz�vegek kiolvas�sa a beviteli mez�kb�l
		String tip = jttip.getText().toString();
		String szin = jtszin.getText().toString();
		String gyev = jtgyev.getText().toString();
		String ar = jtar.getText().toString();

		try {
	    	    PrintStream out=new PrintStream(new FileOutputStream(fnev, true));	//==== Bin�ris f�jlt ki�r� oszt�ly (f�jl megnyit�sa hozz�f�z�sre)
		    out.println(rsz+x+tip+x+szin+x+gyev+x+ar);				//==== Az �j adatsor ki�r�sa a f�jlba (;-el elv�lasztva!)
	            out.close();							//==== A f�jl lez�r�sa
		} catch (Exception ef) {JOptionPane.showMessageDialog(null,"Aut�AdatB.txt f�jl �r�si hiba!\nHibak�d: "+ef.getMessage(),"Gond van!",2);}
		JOptionPane.showMessageDialog(null,"Az �j adatsor beker�lt a f�jl v�g�re.","F�jlkezel�si m�velet t�rt�nt",1);
	    }
	});

	resetb = new JButton();
        resetb.setText(" RESET");
	dp.add(resetb);
	resetb.setBounds(180,y+30,80,26);
	resetb.addActionListener( new ActionListener() {    
	    public void actionPerformed( ActionEvent e ) { 
		jtrsz.setText("");
		jttip.setText("");
		jtszin.setText("");
		jtgyev.setText("");
		jtar.setText("");
	    }
	});
//============
	y=170;
	JLabel l2 = new JLabel("Rendsz�m:");
	dp.add(l2);
	l2.setBounds(20,y,70,20);

	jtrszk = new JTextField("",10);
	dp.add(jtrszk);
	jtrszk.setBounds(90,y,60,20);

	keresb = new JButton();
        keresb.setText(" Keres");
	dp.add(keresb);
	keresb.setBounds(170,y-3,100,26);
	keresb.addActionListener( new ActionListener() {    
	    public void actionPerformed( ActionEvent e ) { 
		ArrayList<String> lista = new ArrayList<String>();			//==== Rugalmas t�mb l�trehoz�sa
		String rszk = jtrszk.getText().toString();				//==== A keresett rendsz�m

		try {
	    	    FileInputStream f=new FileInputStream(fnev);
	    	    LineNumberReader in=new LineNumberReader(new InputStreamReader(f));
	    	    String s=in.readLine();
	    	    while(s != null) {
			int h = rszk.length();						//==== A rendsz�m hossza (h) (karaktereinek sz�ma)
			if (rszk.equals(s.substring(0,h))) lista.add(s);		//==== Ha a keresett rendsz�m megegyezik a f�jlb�l kiolvasott sor els� h darab 
 	                s=in.readLine();						//==== karakter�vel, az adatsor hozz�ad�sa a rugalmas t�mbh�z
	    	    }
	    	    in.close();
		}catch (Exception ioe) {JOptionPane.showMessageDialog(null,""+ioe.getMessage(),"Aut�AdatB.txt f�jl hiba!",0);}
		AutoLp lp = new AutoLp(null, lista);					//==== AutoLp (megjelen�t�panel) p�ld�nyos�t�sa, rugalmas t�mb �tad�sa
		lp.setVisible(true);							//==== Az lp p�ld�ny megjelen�t�se
	    }
	});
//============
	y=220;
	JLabel l3 = new JLabel("Sz�n:");
	dp.add(l3);
	l3.setBounds(20,y,40,20);

	jtszink = new JTextField("",10);
	dp.add(jtszink);
	jtszink.setBounds(60,y,90,20);

	keres2b = new JButton();
        keres2b.setText(" Keres");
	dp.add(keres2b);
	keres2b.setBounds(170,y-3,100,26);
	keres2b.addActionListener( new ActionListener() {    
	    public void actionPerformed( ActionEvent e ) { 
		ArrayList<String> lista = new ArrayList<String>();
		String szink = jtszink.getText().toString();				//==== A keresett sz�n

		try {
	    	    FileInputStream f=new FileInputStream(fnev);
	    	    LineNumberReader in=new LineNumberReader(new InputStreamReader(f));
	    	    String s=in.readLine();						//==== Az els� sor beolvas�sa (feliratokat tartalmaz)
		    s=in.readLine();							//==== A 2. sor beolvas�sa (tartalma: ==============)
		    s=in.readLine();							//==== A 3. sor beolvas�sa, ez az els� adatokat tartalmaz� adatsor
	    	    while(s != null) {
			int h = szink.length();						//==== A keresett sz�n hossza (h) (karaktereinek sz�ma)
			int index=s.indexOf(";");					//==== Az els� ; megkeres�se az adatsorban
			index=s.indexOf(";",++index);					//==== A m�sodik ; megkeres�se az adatsorban
			String pp = s.substring(++index,index+h);			//==== A m�sodik pontosvessz� ut�ni h-darab karakter kiemel�se az adatsorb�l
			if (szink.equals(pp)) lista.add(s);				//==== Ha a keresett sz�n megegyezik a kiemelt karakterekkel, az adatsor 
 	                s=in.readLine();						//==== hozz�ad�sa a rugalmas t�mbh�z
	    	    }
	    	    in.close();
		}catch (Exception ioe) {JOptionPane.showMessageDialog(null,""+ioe.getMessage(),"Aut�AdatB.txt f�jl hiba!",0);}
		AutoLp lp = new AutoLp(null, lista);
		lp.setVisible(true);

	    }
	});
//============
	y=270;
	JLabel l4 = new JLabel("Rendsz�m:");
	dp.add(l4);
	l4.setBounds(20,y,70,20);

	jtrszt = new JTextField("",10);
	dp.add(jtrszt);
	jtrszt.setBounds(90,y,60,20);

	torolb = new JButton();								//==== A f�jlb�l t�r�lni nem lehet adatsort. Megold�s: beolvasni bel�le a
        torolb.setText(" T�r�l");							//==== sz�ks�ges adatokat (kihagyva a t�rlend�t), �s ezekkel az adatokkal 
	dp.add(torolb);									//==== fel�l�rni az eredeti f�jl tartalm�t.
	torolb.setBounds(170,y-3,100,26);
	torolb.addActionListener( new ActionListener() {    
	    public void actionPerformed( ActionEvent e ) { 
		ArrayList<String> lista = new ArrayList<String>();
		String rszk = jtrszt.getText().toString();				//==== A t�rlend� aut� rendsz�ma
		try {
	    	    FileInputStream f=new FileInputStream(fnev);
	    	    LineNumberReader in=new LineNumberReader(new InputStreamReader(f));
	    	    String s=in.readLine();						//==== Adatok beolvas�sa 
	    	    while(s != null) {
			int h = rszk.length();
			if (!rszk.equals(s.substring(0,h))) lista.add(s);		//==== Ha az adatsor eleje nem egyezik meg a t�rlend� rendsz�mmal, hozz�adjuk
 	                s=in.readLine();						//==== az adatsort egy rugalmas t�mbh�z
	    	    }
	    	    in.close();								//==== F�jl lez�r�sa
		}catch (Exception ioe) {JOptionPane.showMessageDialog(null,""+ioe.getMessage(),"Aut�AdatB.txt f�jl hiba!",0);}
		try {	
	    	    PrintStream out=new PrintStream(new FileOutputStream(fnev));	//==== F�jl megnyit�sra �r�sra (fel�l�rja az eredeti f�jlt)
		    for (String s: lista) {						//==== A rugalmas t�mb bej�r�sa ciklussal, elemek �trak�sa az s stringbe
		        out.println(s);							//==== Az s string ki�r�sa a f�jlba
		    }
	            out.close();							//==== F�jl lez�r�sa
		} catch (Exception ef) {JOptionPane.showMessageDialog(null,"Aut�AdatB.txt f�jl �r�si hiba!\nHibak�d: "+ef.getMessage(),"Gond van!",2);}
		JOptionPane.showMessageDialog(null,"Az adott rendsz�m� aut� t�rl�d�tt a f�jlb�l.","F�jlkezel�si m�velet t�rt�nt",1);
	    }
	});


//============
	bezar = new JButton();
        bezar.setText(" Bez�r");
	dp.add(bezar);
	bezar.setBounds(175,330,100,26);
	bezar.addActionListener( new ActionListener() {    
	    public void actionPerformed( ActionEvent e ) { 
		dispose(); setVisible(false);						//==== Az ablak bez�r�sa, l�that�s�g�nak megsz�ntet�se
	    }
	});

	listab.setEnabled(false);
	ujadatb.setEnabled(false);
	keresb.setEnabled(false);
	keres2b.setEnabled(false);
	torolb.setEnabled(false);
	resetb.setEnabled(false);
	feltoltb.setEnabled(false);


    }
//===============================
    public void FileMaker(){
	try {	
	    PrintStream out=new PrintStream(new FileOutputStream(fnev));
	    out.println("Rendsz�m;T�pus;Sz�n;Gy�rt_�v;�r");
	    out.println("===============================");
	    out.close();
	} catch (Exception ef) {JOptionPane.showMessageDialog(null,"Aut�AdatB.txt f�jl �r�si hiba!\nHibak�d: "+ef.getMessage(),"Gond van!",2);}
    }
//===============================
    public void BasicData(){
	try {	
	    PrintStream out=new PrintStream(new FileOutputStream(fnev));
	    out.println("Rendsz�m;T�pus;Sz�n;Gy�rt_�v;�r");
	    out.println("===============================");
	    out.println("ABC-123;Opel Astra;feh�r;2001;780000");
	    out.println("XYZ-999;Suzuki Swift;piros;2008;1200000");
	    out.println("CIC-555;Renault Megane;barna;2001;800000");
	    out.println("QRV-311;Mercedes ML500;fekete;2018;31000000");
	    out.println("BMM-322;Honda Jazz;feh�r;2009;1500000");
	    out.println("KMN-761;Skoda Octavia;piros;2015;2300000");
	    out.println("CDF-947;Trabant 601;bilik�k;1981;400000");
	    out.println("MWM-310;Kia Ceed;feh�r;2014;3200000");
	    out.println("CET-417;Opel Corsa;k�k;1999;700000");
	    out.println("CXP-444;Opel Insignia;fekete;2013;5400000");
	    out.close();
	} catch (Exception ef) {JOptionPane.showMessageDialog(null,"Aut�AdatB.txt f�jl �r�si hiba!\nHibak�d: "+ef.getMessage(),"Gond van!",2);}
    }
//===============================
   public static void main(String[] args) {
        AutoTxtProgram fk1 = new AutoTxtProgram();
        fk1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fk1.setVisible(true);
   }

}