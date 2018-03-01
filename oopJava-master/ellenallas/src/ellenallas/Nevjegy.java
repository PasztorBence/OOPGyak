package ellenallas;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import java.awt.Font;

public class Nevjegy extends JDialog implements ActionListener {
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JButton okButton;

	
	
	public static void main(String[] args) {
		try {
			Nevjegy dialog = new Nevjegy();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	
	public Nevjegy() {
		this.setModal(true);
		setType(Type.UTILITY);
		setTitle("N\u00E9vjegy");
		setBounds(100, 100, 298, 176);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		/* ablak automatikusan kozepre */
		Toolkit toolkit = Toolkit.getDefaultToolkit();  
		Dimension kepernyoMeret = toolkit.getScreenSize(); 
		int x = (kepernyoMeret.width - this.getWidth()) / 2;  
		int y = (kepernyoMeret.height - this.getHeight()) / 2;  
		this.setLocation(x, y);  
		
		
		JLabel lblNewLabel = new JLabel("LED el\u0151t\u00E9t ellen\u00E1ll\u00E1s m\u00E9retez\u0151 program");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(20, 20, 270, 25);
		contentPanel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("K\u00E9sz\u00EDtette: Tompa Tam\u00E1s");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1.setBounds(44, 56, 193, 14);
		contentPanel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("2012.05.28.");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_2.setBounds(94, 92, 80, 14);
		contentPanel.add(lblNewLabel_2);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			
			okButton = new JButton("OK");
			okButton.setActionCommand("okButton");
			buttonPane.add(okButton);
			getRootPane().setDefaultButton(okButton);
		}
		
		this.okButton.addActionListener(this);
	}



	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("okButton")) {
			this.setVisible(false);
		}
		
	}
}
