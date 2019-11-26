package kirjaTietokanta;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ButtonGroup;

public class kirjaTietokanta extends JFrame {
	DefaultTableModel model = new DefaultTableModel();
	private JPanel contentPane;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					kirjaTietokanta frame = new kirjaTietokanta();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
					frame.setResizable(false);
					frame.setTitle("Kirjoja");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public kirjaTietokanta() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 446);
		
  	    String url = "jdbc:mysql://sql7.freemysqlhosting.net:3306/sql7313303";
  	    String käyttäjä = "sql7313303";
  	    String salasana = "zqyjuGtFpK";
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnTiedosto = new JMenu("Tiedosto");
		menuBar.add(mnTiedosto);
		
		JMenuItem mntmPivitTaulukko = new JMenuItem("P\u00E4ivit\u00E4 taulukko");
		mntmPivitTaulukko.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {

  	    			Connection con = DriverManager.getConnection(url, käyttäjä, salasana);		
  	    			Statement stmt = con.createStatement();
  	    			ResultSet rs = stmt.executeQuery("SELECT * FROM Kirjat");
  	    			
  	    			
  	    			if (model.getRowCount() > 0) {
  	    			    for (int i = model.getRowCount() - 1; i > -1; i--) {
  	    			    	model.removeRow(i);
  	    			    }
  	    			}

  	    			while (rs.next()) {
  	    				System.out.println(rs.getInt(1)+"  "+rs.getString(2) + "  " + rs.getString(3) + "  " + rs.getInt(4));
  	    						model.addRow(new Object[] {rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4) });
  	    				}
  	    			con.close();
  	    			} catch (Exception e1) {
  	    				// TODO Auto-generated catch block
  	    				e1.printStackTrace();
  	    			}
			}
		});
		mnTiedosto.add(mntmPivitTaulukko);
		
		JMenuItem mntmSuljeOhjelma = new JMenuItem("Sulje ohjelma");
		mntmSuljeOhjelma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		mnTiedosto.add(mntmSuljeOhjelma);
		
		JMenu mnTietojaOhjelmasta = new JMenu("Tietoja ohjelmasta");
		menuBar.add(mnTietojaOhjelmasta);
		
		JMenuItem mntmTietoja = new JMenuItem("Tietoja");
		mntmTietoja.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				JFrame firstFrame = new JFrame("first Frame");
				firstFrame.getContentPane().setLayout(null);
				firstFrame.setBounds(0, 0, 400, 200);
				firstFrame.setLocationRelativeTo(null);
				firstFrame.setVisible(true);
				firstFrame.setTitle("Tietoja ohjelmasta");
				firstFrame.setResizable(false);
				firstFrame.setAlwaysOnTop(true);

				JLabel tiedot = new JLabel("Tekijä: Juha Suvanto");
				firstFrame.getContentPane().add(tiedot);
				tiedot.setBounds(140, 15, 200, 100);
				// Sulje nappi joka sulkee tietoja ikkunan ja sen kuutelija
				JButton sulje = new JButton("Sulje");
				sulje.setBounds(160, 100, 75, 25);

				sulje.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {

						firstFrame.dispose();

					}
				});
				firstFrame.getContentPane().add(sulje, BorderLayout.SOUTH);
				
			}
		});
		mnTietojaOhjelmasta.add(mntmTietoja);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		

		model.addColumn("ID");
		model.addColumn("Kirjan nimi");
		model.addColumn("Tekijä");
		model.addColumn("Julkaisuvuosi");
		
		JTable table = new JTable(model);
  	    JScrollPane scrollPane = new JScrollPane();
  	    contentPane.add(scrollPane);
  	    scrollPane.setViewportView(table);
  	    
  	    JPanel panel = new JPanel();
  	    contentPane.add(panel, BorderLayout.SOUTH);
  	    
  	    JButton lisää = new JButton("Lis\u00E4\u00E4 rivi");
  	    lisää.addActionListener(new ActionListener() {
  	    	public void actionPerformed(ActionEvent e) {
  	    		

  	    		JFrame ikkuna = new JFrame("Second Frame");

				GridLayout sijoittelija = new GridLayout(5, 2);
				ikkuna.getContentPane().setLayout(sijoittelija);
				ikkuna.setBounds(0, 0, 300, 120);
				ikkuna.setLocationRelativeTo(null);
				ikkuna.setVisible(true);
				ikkuna.setTitle("Syötä kirjan tiedot");
				ikkuna.setResizable(false);
				ikkuna.setAlwaysOnTop(true);
				
				
				JLabel id = new JLabel("ID");
				ikkuna.getContentPane().add(id);
				
				JTextField id1 = new JTextField();
				ikkuna.getContentPane().add(id1);

				JLabel kirja = new JLabel("Kirjan nimi");
				ikkuna.getContentPane().add(kirja);

				JTextField kirja1 = new JTextField();
				ikkuna.getContentPane().add(kirja1);

				JLabel kirjailija = new JLabel("Kirjailija");
				ikkuna.getContentPane().add(kirjailija);

				JTextField kirjailija1 = new JTextField();
				ikkuna.getContentPane().add(kirjailija1);
				
				JLabel julkaisuvuosi = new JLabel("Julkaisuvuosi");
				ikkuna.getContentPane().add(julkaisuvuosi);

				JTextField julkaisuvuosi1 = new JTextField();
				ikkuna.getContentPane().add(julkaisuvuosi1);
				
  	    		
				JButton ok = new JButton("Ok");
				ok.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
		  	    		Connection con;
						try {
							
							String numero = id1.getText();
							int uusiNumero = Integer.parseInt(numero);
							
							String kirjanNimi = kirja1.getText();

							String kirjailijanNimi = kirjailija1.getText();

							String julkaisuVuosi = julkaisuvuosi1.getText();
							int newValue = Integer.parseInt(julkaisuVuosi);

								
							con = DriverManager.getConnection(url, käyttäjä, salasana);
				    		java.sql.PreparedStatement pst = con.prepareStatement("insert into Kirjat(ID,Teos,Tekijä,vuosi) values(?,?,?,?)");
				    		pst.setInt(1,uusiNumero);
				    		pst.setString(2,kirjanNimi);
				    		pst.setString(3,kirjailijanNimi);
				    		pst.setInt(4,newValue);
				    		
				    	      int i = pst.executeUpdate();
				    	      if(i!=0){
				    	        System.out.println("Kirja lisätty");
				    	      }
				    	      else{
				    	        System.out.println("Kirjan lisääminen epäonnistui");
				    	      }
				    		
						} catch (Exception e) {

							e.printStackTrace();
						}
					}
				});
  	    		
 
				ikkuna.getContentPane().add(ok);

				JButton peruuta = new JButton("Peruuta");
				peruuta.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {

						ikkuna.dispose();
					}
				});
				ikkuna.getContentPane().add(peruuta);

				
  	    		
  	    	}
  	    });
  	    panel.add(lisää);
  	    
  	    JButton poista = new JButton("Poista valittu rivi");
  	    poista.addActionListener(new ActionListener() {
  	    	public void actionPerformed(ActionEvent e) {
  	    		Connection con;
  	    		int valittu = table.getSelectedRow();
  	    		String cell = table.getModel().getValueAt(valittu, 0).toString();
  	    		String sql = "DELETE FROM Kirjat Where ID = " + cell;
	
  	    		try {
  	    			con = DriverManager.getConnection(url, käyttäjä, salasana);
  	    			java.sql.PreparedStatement pst = con.prepareStatement(sql);
  	    		  int i = pst.executeUpdate();
	    	      if(i!=0){
	    	        System.out.println("Kirja poistettu");
	    	      }
	    	      else{
	    	        System.out.println("Kirjan poistaminen epäonnistui");
	    	      }
  	    			
  	    		} catch (Exception e2) {
  	    			e2.printStackTrace();
  	    		}
  	    		
  	    		
  	    		
  	    	}
  	    });
  	    panel.add(poista);
  	    
  	    JButton päivitä = new JButton("P\u00E4ivit\u00E4 taulukko");
  	    päivitä.addActionListener(new ActionListener() {
  	    	public void actionPerformed(ActionEvent e) {
  	    		
  	    		try {

  	    			Connection con = DriverManager.getConnection(url, käyttäjä, salasana);		
  	    			Statement stmt = con.createStatement();
  	    			ResultSet rs = stmt.executeQuery("SELECT * FROM Kirjat");
  	    			
  	    			
  	    			if (model.getRowCount() > 0) {
  	    			    for (int i = model.getRowCount() - 1; i > -1; i--) {
  	    			    	model.removeRow(i);
  	    			    }
  	    			}

  	    			while (rs.next()) {
  	    				System.out.println(rs.getInt(1)+"  "+rs.getString(2) + "  " + rs.getString(3) + "  " + rs.getInt(4));
  	    						model.addRow(new Object[] {rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4) });
  	    				}
  	    			con.close();
  	    			} catch (Exception e1) {
  	    				// TODO Auto-generated catch block
  	    				e1.printStackTrace();
  	    			}
  	    		
  	    		
  	    	}
  	    });
  	    panel.add(päivitä);
  	    
  	   
  	    
		try {
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection(url, käyttäjä, salasana);		
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM Kirjat");

		while (rs.next()) {
			System.out.println(rs.getInt(1)+ "  "+rs.getString(2) + "  " + rs.getString(3) + "  " + rs.getInt(4));
					model.addRow(new Object[] {rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4) });
			}
		con.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
	}
	

}
