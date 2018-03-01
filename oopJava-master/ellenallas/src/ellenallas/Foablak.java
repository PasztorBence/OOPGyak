package ellenallas;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.DocumentFilter;
import javax.swing.text.NumberFormatter;
import javax.swing.InputVerifier;
import javax.swing.JComponent;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

/**
 * @author Tomi
 * Keszitette: Tompa Tamas, 2012.05.28.
 */

public class Foablak extends JFrame implements ActionListener, ItemListener {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblNewLabelKep;
	private JComboBox<String> comboBox;
	private JLabel lblNewLabelEredmeny;
	private JMenuBar menuBar;
	private JMenuItem mntmKilepes;
	private JMenuItem mntmNevjegy;
	private JLabel lblNewLabelTelj;
	private JLabel lblNewLabelFogy;
	private JFormattedTextField textFieldFesz;
	private JFormattedTextField textFieldNyitoFesz;
	private JFormattedTextField textFieldLEDSzam;
	private JFormattedTextField textFieldLEDAram;
	private JButton btnSzamol;
	
	private double tapFesz = 0.0;
	private double nyitoFesz = 0.0;
	private int ledekSzama = 0;
	private double ledAram = 0.0;
	private double sorosKeplet = 0.0;
	private double parhuzamosKeplet = 0.0;
	private double kulonKeplet = 0.0;
	private double sorosEllTeljesitmeny = 0.0;
	private double parhuzamosEllTeljesitmeny  = 0.0;
	private double kulonEllTeljesitmeny = 0.0;
	private double fogyasztas = 0.0;

	
	/**
	 * main metodus
	 * @param args
	 */	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Foablak frame = new Foablak();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	
	
	/**
	 * konstruktor
	 */
	public Foablak() {
		setTitle("LED el\u0151t\u00E9t ellen\u00E1ll\u00E1s sz\u00E1m\u00EDt\u00E1s");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 579, 331);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		/* ablak automatikusan kozepre */
		Toolkit toolkit = Toolkit.getDefaultToolkit();  
		Dimension kepernyoMeret = toolkit.getScreenSize(); 
		int x = (kepernyoMeret.width - this.getWidth()) / 2;  
		int y = (kepernyoMeret.height - this.getHeight()) / 2;  
		this.setLocation(x, y);  
		
		
		JLabel lblTpfeszltsg = new JLabel("T\u00E1pfesz\u00FClts\u00E9g:");
		lblTpfeszltsg.setBounds(23, 59, 116, 14);
		contentPane.add(lblTpfeszltsg);
		
		JLabel lblLedNyitfeszltsge = new JLabel("LED nyit\u00F3fesz\u00FClts\u00E9ge:");
		lblLedNyitfeszltsge.setBounds(23, 84, 135, 14);
		contentPane.add(lblLedNyitfeszltsge);
		
		JLabel lblLedekSzma = new JLabel("LED-ek sz\u00E1ma:");
		lblLedekSzma.setBounds(23, 109, 135, 14);
		contentPane.add(lblLedekSzma);
		
		JLabel lblSzmtttEllenlls = new JLabel("Sz\u00E1m\u00EDtott ellen\u00E1ll\u00E1s:");
		lblSzmtttEllenlls.setBounds(23, 208, 116, 14);
		contentPane.add(lblSzmtttEllenlls);
		
		lblNewLabelKep = new JLabel("");
		lblNewLabelKep.setIcon(new ImageIcon("img/led_elotet_parhuzamos.png"));
		lblNewLabelKep.setBounds(281, 71, 283, 126);
		contentPane.add(lblNewLabelKep);
		
		comboBox = new JComboBox<String>();
		comboBox.setActionCommand("comboBoxValaszt");
		comboBox.setModel(new DefaultComboBoxModel<String>(new String[] {"Soros LED", "P\u00E1rhuzamos LED", "Minden LED k\u00FCl\u00F6n"}));
		comboBox.setBounds(203, 25, 135, 20);
		contentPane.add(comboBox);
		
		
		
		this.comboBox.setSelectedIndex(1);
		
		JLabel lblV = new JLabel("V");
		lblV.setBounds(225, 59, 24, 14);
		contentPane.add(lblV);
		
		JLabel lblV_1 = new JLabel("V");
		lblV_1.setBounds(225, 84, 24, 14);
		contentPane.add(lblV_1);
		
		JLabel lblDb = new JLabel("db");
		lblDb.setBounds(225, 109, 24, 14);
		contentPane.add(lblDb);
		
		JLabel lblMa = new JLabel("mA");
		lblMa.setBounds(225, 134, 24, 14);
		contentPane.add(lblMa);
		
		btnSzamol = new JButton("Sz\u00E1mol!");
		btnSzamol.setActionCommand("Szamol");
		btnSzamol.setBounds(94, 159, 94, 23);
		contentPane.add(btnSzamol);
		
		lblNewLabelEredmeny = new JLabel("");
		lblNewLabelEredmeny.setBounds(143, 208, 70, 14);
		contentPane.add(lblNewLabelEredmeny);
		
		JLabel lblOhm = new JLabel("Ohm");
		lblOhm.setBounds(203, 208, 46, 14);
		contentPane.add(lblOhm);
		
		JLabel lblEllenllsMinTejl = new JLabel("Ellen\u00E1ll\u00E1s min. tejl.:");
		lblEllenllsMinTejl.setBounds(23, 233, 116, 14);
		contentPane.add(lblEllenllsMinTejl);
		
		menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 571, 21);
		contentPane.add(menuBar);
		
		JMenu mnFajl = new JMenu("F\u00E1jl");
		menuBar.add(mnFajl);
		
		mntmKilepes = new JMenuItem("Kil\u00E9p\u00E9s");
		mntmKilepes.setActionCommand("kilepesMenu");
		mnFajl.add(mntmKilepes);
		
		JMenu mnSg = new JMenu("S\u00FAg\u00F3");
		menuBar.add(mnSg);
		
		mntmNevjegy = new JMenuItem("N\u00E9vjegy");
		mntmNevjegy.setActionCommand("nevjegyMenu");
		mnSg.add(mntmNevjegy);
		
		lblNewLabelTelj = new JLabel("");
		lblNewLabelTelj.setBounds(143, 233, 70, 14);
		contentPane.add(lblNewLabelTelj);
		
		JLabel lblW = new JLabel("W");
		lblW.setBounds(203, 233, 46, 14);
		contentPane.add(lblW);
		
		JLabel lblFogyaszts = new JLabel("Fogyaszt\u00E1s:");
		lblFogyaszts.setBounds(23, 257, 94, 14);
		contentPane.add(lblFogyaszts);
		
		JLabel lblW_1 = new JLabel("W");
		lblW_1.setBounds(203, 258, 46, 14);
		contentPane.add(lblW_1);
		
		lblNewLabelFogy = new JLabel("");
		lblNewLabelFogy.setBounds(142, 258, 71, 14);
		contentPane.add(lblNewLabelFogy);
		
		JLabel lblLedrama = new JLabel("LED \u00E1rama:");
		lblLedrama.setBounds(23, 134, 116, 14);
		contentPane.add(lblLedrama);
		
		textFieldFesz = new JFormattedTextField();
		textFieldFesz.setBounds(152, 56, 72, 20);
		contentPane.add(textFieldFesz);
	
		textFieldNyitoFesz = new JFormattedTextField();
		textFieldNyitoFesz.setBounds(154, 81, 70, 20);
		contentPane.add(textFieldNyitoFesz);
		
		textFieldLEDSzam = new JFormattedTextField();
		textFieldLEDSzam.setBounds(152, 109, 72, 20);
		contentPane.add(textFieldLEDSzam);
		
		textFieldLEDAram = new JFormattedTextField();
		textFieldLEDAram.setBounds(152, 131, 72, 20);
		contentPane.add(textFieldLEDAram);
		
		
		
		/* szurok */
		DefaultFormatterFactory df = new DefaultFormatterFactory(new filteresFormatter());
		this.textFieldFesz.setFormatterFactory(df);
		this.textFieldLEDAram.setFormatterFactory(df);
		this.textFieldNyitoFesz.setFormatterFactory(df);
		
		DefaultFormatterFactory dfEgesz = new DefaultFormatterFactory(new egeszFilteresFormatter());
		this.textFieldLEDSzam.setFormatterFactory(dfEgesz);
		
		InputVerifier egeszjegyVerifier = new egeszJegyVerifier();
		this.textFieldLEDSzam.setInputVerifier(egeszjegyVerifier);
		
		InputVerifier jegyVerifier = new jegyVerifier();
		this.textFieldFesz.setInputVerifier(jegyVerifier);
		this.textFieldLEDAram.setInputVerifier(jegyVerifier);
		this.textFieldNyitoFesz.setInputVerifier(jegyVerifier);

		
		
		this.comboBox.addItemListener(this);
		btnSzamol.addActionListener(this);
		this.mntmKilepes.addActionListener(this);
		this.mntmNevjegy.addActionListener(this);
	}





	
	@Override
	public void actionPerformed(ActionEvent e) {
		DecimalFormat df = new DecimalFormat("####.0000");
        

		if(e.getActionCommand().equals("kilepesMenu")) {
			System.exit(0);
		}
		
		
		if(e.getActionCommand().equals("nevjegyMenu")) {
			Nevjegy nevjegy = new Nevjegy();
			nevjegy.setVisible(true);
		}
		
		
		
		/* Szamolas gomb */
		if(e.getActionCommand().equals("Szamol")) {
			
			if(this.textFieldFesz.getText().isEmpty()) {
				JOptionPane.showMessageDialog(this, "Nem adott meg tápfeszülzséget!");
				return;
			}
			
			if(this.textFieldNyitoFesz.getText().isEmpty()) {
				JOptionPane.showMessageDialog(this, "Nem adta meg a LED-ek nyitófeszülzségét!");
				return;
			}
			
			if(this.textFieldLEDSzam.getText().isEmpty()) {
				JOptionPane.showMessageDialog(this, "Nem adta meg a LED-ek számát!");
				return;
			}
			
			if(this.textFieldLEDAram.getText().isEmpty()) {
				JOptionPane.showMessageDialog(this, "Nem adta meg a LED áramát!");
				return;
			}
			
			
			/* soros LED */
			if(this.comboBox.getSelectedIndex() == 0) {
				this.tapFesz = ((Number) this.textFieldFesz.getValue()).doubleValue();
				this.nyitoFesz = ((Number) this.textFieldNyitoFesz.getValue()).doubleValue();
				this.ledekSzama = ((Number) this.textFieldLEDSzam.getValue()).intValue();
				this.ledAram = ((Number) this.textFieldLEDAram.getValue()).doubleValue();
				
				sorosKeplet = (tapFesz - (ledekSzama * nyitoFesz)) / (ledAram/1000);
				
				if(sorosKeplet <= 0) {
					JOptionPane.showMessageDialog(this, "Alacsony a tápfeszültség!");
					return;
				} 

				this.lblNewLabelEredmeny.setText(df.format(sorosKeplet));
				
				sorosEllTeljesitmeny = (tapFesz - (ledekSzama * nyitoFesz)) * (ledAram/1000);
				this.lblNewLabelTelj.setText(df.format(sorosEllTeljesitmeny));
				
				fogyasztas = (nyitoFesz * ledekSzama) * (ledAram / 1000);
				this.lblNewLabelFogy.setText(df.format(fogyasztas));
			}
			
			
			
			/* parhuzamos LED */
			if(this.comboBox.getSelectedIndex() == 1) {
				this.tapFesz = ((Number) this.textFieldFesz.getValue()).doubleValue();
				this.nyitoFesz = ((Number) this.textFieldNyitoFesz.getValue()).doubleValue();
				this.ledekSzama = ((Number) this.textFieldLEDSzam.getValue()).intValue();
				this.ledAram = ((Number) this.textFieldLEDAram.getValue()).doubleValue();
				
				parhuzamosKeplet = (tapFesz - nyitoFesz) / ((ledAram/1000)*ledekSzama);
				this.lblNewLabelEredmeny.setText(df.format(parhuzamosKeplet));
				
				parhuzamosEllTeljesitmeny = (tapFesz - nyitoFesz) * ((ledAram/1000)*ledekSzama);
				this.lblNewLabelTelj.setText(df.format(parhuzamosEllTeljesitmeny));
				
				fogyasztas = (nyitoFesz) * ((ledAram / 1000) * ledekSzama );
				this.lblNewLabelFogy.setText(df.format(fogyasztas));
			}
			
			
			/* minden LED kulon-kulon */
			if(this.comboBox.getSelectedIndex() == 2) {
				this.tapFesz = ((Number) this.textFieldFesz.getValue()).doubleValue();
				this.nyitoFesz = ((Number) this.textFieldNyitoFesz.getValue()).doubleValue();
				this.ledekSzama = 1;
				this.ledAram = ((Number) this.textFieldLEDAram.getValue()).doubleValue();
				
				kulonKeplet = (tapFesz - nyitoFesz) / ((ledAram/1000));
				this.lblNewLabelEredmeny.setText(df.format(kulonKeplet));
				
				kulonEllTeljesitmeny = (tapFesz - nyitoFesz) * ((ledAram/1000));
				this.lblNewLabelTelj.setText(df.format(kulonEllTeljesitmeny));
				
				fogyasztas = (nyitoFesz * ledekSzama) * (ledAram / 1000);
				this.lblNewLabelFogy.setText(df.format(fogyasztas));
			}
		}
	}


	

	@Override
	public void itemStateChanged(ItemEvent e) {
		if (this.comboBox.getSelectedIndex() == 0) {
			lblNewLabelKep.setIcon(new ImageIcon("img/led_elotet_soros.png"));
			this.textFieldLEDSzam.setText("");
			this.textFieldLEDSzam.setEditable(true);
		}

		if (this.comboBox.getSelectedIndex() == 1) {
			lblNewLabelKep.setIcon(new ImageIcon("img/led_elotet_parhuzamos.png"));
			this.textFieldLEDSzam.setText("");
			this.textFieldLEDSzam.setEditable(true);
		}
		
		
		if (this.comboBox.getSelectedIndex() == 2) {
			lblNewLabelKep.setIcon(new ImageIcon("img/led_elotet_kulon.png"));
			this.textFieldLEDSzam.setText("1");
			this.textFieldLEDSzam.setEditable(false);
		}	
	}
	
	


	
	/**
	 * tortszam filter osztaly
	 */
	private static class csakSzamFilter extends DocumentFilter {
		@Override
		public void insertString(FilterBypass fb, int offset, String string, AttributeSet attr) throws BadLocationException {
			if(szamE(string)) {
				super.insertString(fb, offset, string, attr);
				
			}
		}

		@Override
		public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
			if(szamE(text)) {
				super.replace(fb, offset, length, text, attrs);
			}
		}
		
		
		/* csak szam-e vagy tortszam-e */
		public boolean szamE(String inputString){
            boolean ret = true;
            boolean tizedesPont = false;
            char[] ch = inputString.toCharArray();
           
            for (int i=0; i<ch.length;i++){
              if (!Character.isDigit(ch[i])){
                if (ch[i] == '-')
                    ret = (i>0)?false:true;
                else if (ch[i] == ',') {
                    ret = (!tizedesPont)?true:false;
                    tizedesPont = true;
                } else
                    ret = false;
              }
              if (!ret)
                break;
            }
            return ret;
        }
	}

	
	
	/**
	 * tortszam formatter osztaly
	 */
	private static class filteresFormatter extends NumberFormatter {
		private static final long serialVersionUID = 1L;
		private csakSzamFilter filter;
		
		public filteresFormatter() {
			super(NumberFormat.getInstance());
		}

		@Override
		protected DocumentFilter getDocumentFilter() {
			return filter;
		}
	}
	
	
	private class jegyVerifier extends InputVerifier {
		@Override
		public boolean verify(JComponent input) {
			JFormattedTextField tf = (JFormattedTextField)input;
			double szam = 0.0;
			
			try {
				tf.commitEdit();
				if(tf.getValue() != null) {
					szam = ((Number)tf.getValue()).doubleValue();
					System.out.println(szam);
				}
			} catch (ParseException e) {
				return false;
			}
			return szam>=0;	
		}	
	}
	
	
	
	
	
	
	/** egesz szamhoz, a LED-ek szamahoz (csak egesz lehet) */
	private static class egeszFilteresFormatter extends NumberFormatter {
		private static final long serialVersionUID = 1L;
		private csakSzamFilter filter;
		
		public egeszFilteresFormatter() {
			super(NumberFormat.getIntegerInstance());
		}

		@Override
		protected DocumentFilter getDocumentFilter() {
			return filter;
		}
	}
	
	
	
	/** egesz szamhoz, (LED-ek szama csak egesz lehet) */
	private class egeszJegyVerifier extends InputVerifier {
		@Override
		public boolean verify(JComponent input) {
			JFormattedTextField tf = (JFormattedTextField)input;
			int szam = 0;
			
			try {
				tf.commitEdit();
				if(tf.getValue() != null) {
					szam = ((Number)tf.getValue()).intValue();
					System.out.println(szam);
				}
			} catch (ParseException e) {
				return false;
			}
			return szam>=0;	
		}	
	}
		
}