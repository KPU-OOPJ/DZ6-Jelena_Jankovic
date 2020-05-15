package javaapplication20;

import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.util.LinkedList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class RukometGUI extends javax.swing.JFrame {

   
    
        private JPanel contentPane;
	
	private JTextField jtfImePrezime;
	private JTextField jtfPoeni;

	private LinkedList<Rukometas> igraci = new LinkedList<Rukometas>();

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RukometGUI frame = new RukometGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public RukometGUI() {
		setTitle("Rukomet");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 419, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblImeIPrezime = new JLabel("Ime i prezime");
		contentPane.add(lblImeIPrezime);
		
		jtfImePrezime = new JTextField();
		contentPane.add(jtfImePrezime);
		jtfImePrezime.setColumns(10);
		
		JLabel lblPozicija = new JLabel("Pozicija");
		contentPane.add(lblPozicija);
		
		final JComboBox jcbPozicija = new JComboBox();
		jcbPozicija.addItem("golman");
		jcbPozicija.addItem("krilo");
		jcbPozicija.addItem("bek");
		jcbPozicija.addItem("centar");
		contentPane.add(jcbPozicija);
		
		JLabel lblPoeni = new JLabel("Poeni");
		contentPane.add(lblPoeni);
		
		jtfPoeni = new JTextField();
		contentPane.add(jtfPoeni);
		jtfPoeni.setColumns(10);
		
		JButton btnObrisi = new JButton("Obrisi");
		btnObrisi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jtfImePrezime.setText(null);
				jtfPoeni.setText(null);
			}
		});
		contentPane.add(btnObrisi);
		
		JButton btnSacuvaj = new JButton("Sacuvaj");
		btnSacuvaj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					DataOutputStream golmaniOut = new DataOutputStream(
													new BufferedOutputStream(
															new FileOutputStream("golmani.out")));
					
					DataOutputStream igraciOut = new DataOutputStream(
													new BufferedOutputStream(
															new FileOutputStream("igraci.out")));
					
					for (int i = 0; i < igraci.size(); i++) {
						if (igraci.get(i).getPozicija().equals("golman")) {
							golmaniOut.writeUTF(igraci.get(i).getImePrezime());
							golmaniOut.writeChar('\t');
							golmaniOut.writeUTF(igraci.get(i).getPozicija());
							golmaniOut.writeChar('\t');
							golmaniOut.writeInt(igraci.get(i).getPoeni());
							golmaniOut.writeChar('\n');
						} else {
							igraciOut.writeUTF(igraci.get(i).getImePrezime());
							igraciOut.writeChar('\t');
							igraciOut.writeUTF(igraci.get(i).getPozicija());
							igraciOut.writeChar('\t');
							igraciOut.writeInt(igraci.get(i).getPoeni());
							igraciOut.writeChar('\n');
						}
					}
					
					// zatvaramo stream-ove
					golmaniOut.close();
					igraciOut.close();
				} catch (Exception ex) {
					System.out.println("Greska: " + ex.getMessage());
				}
			}
		});
		contentPane.add(btnSacuvaj);
		
		JButton btnUnesi = new JButton("Unesi");
		btnUnesi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String imePrezime = jtfImePrezime.getText();
					String pozicija = jcbPozicija.getSelectedItem().toString();
					int poeni = Integer.parseInt(jtfPoeni.getText());
					
					Rukometas noviRukometas = new Rukometas();
					noviRukometas.setImePrezime(imePrezime);
					noviRukometas.setPozicija(pozicija);
					noviRukometas.setPoeni(poeni);
					
					if (!igraci.contains(noviRukometas)) {
						
						boolean unesen = false;
						
						for (int i = 0; i < igraci.size(); i++) {
							if (noviRukometas.getPoeni() > igraci.get(i).getPoeni()) {
								igraci.add(i, noviRukometas);
								unesen = true;
								break;
							}
						}
						
						
						if (!unesen) {
							igraci.add(noviRukometas);
						}
					} else {
						setTitle(getTitle() + " GRESKA");
					}
				} catch (NumberFormatException nfe) {
					setTitle(getTitle() + " GRESKA");
				}
			}
		});
		contentPane.add(btnUnesi);
	}
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    

        

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
