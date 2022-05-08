//aici facem interfata cu toate butoanele si action listeneri:
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class PoliclinicaView extends JFrame{
	private PoliclinicaModel m;
	private JTextField user = new JTextField(20);
	private JTextField password = new JTextField(20);
	private JButton btn = new JButton("Login");
	private JButton btnAdmin = new JButton("ADMIN");
	private JButton btnSAdmin = new JButton("SUPER-ADMIN");
	//private
	//PoliclinicaView2 f = new PoliclinicaView2();
	
	PoliclinicaView(PoliclinicaModel m){
		this.m = m;
		
		JPanel p1 = new JPanel();
		JPanel p2 = new JPanel();
		p1.setPreferredSize(new Dimension(200, 500));
		p1.setBackground(Color.pink);
		p2.setPreferredSize(new Dimension(200, 500));
		p2.setBackground(Color.pink);
		
		JPanel p3 = new JPanel();
		
		p3.setPreferredSize(new Dimension(300, 500));
		p3.setBackground(Color.pink);
		
		JLabel lu = new JLabel("Username: ");
		lu.setFont(new Font("Arial", Font.ITALIC, 15));
		JLabel lp = new JLabel("Password: ");
		lp.setFont(new Font("Arial", Font.ITALIC, 15));
		JLabel lt = new JLabel("Promedis");
		lt.setFont(new Font("Algerian", Font.BOLD, 50));
		
		user.setPreferredSize(new Dimension(100, 30));
		password.setPreferredSize(new Dimension(100, 30));
		
		JPanel pbtn = new JPanel();
		pbtn.setLayout(new FlowLayout());
		pbtn.add(btnAdmin);
		pbtn.add(btn);
		pbtn.add(btnSAdmin);
		pbtn.setBackground(Color.pink);
		
		p3.add(lt);
		p3.add(Box.createRigidArea(new Dimension(400, 50)));
		p3.add(lu);
		p3.add(user);
		p3.add(Box.createRigidArea(new Dimension(400, 50)));
		p3.add(lp);
		p3.add(password);
		p3.add(Box.createRigidArea(new Dimension(200, 50)));
		p3.add(pbtn);
		p3.add(Box.createRigidArea(new Dimension(200, 50)));
		
		JPanel p = new JPanel();
		p.setLayout(new BoxLayout(p, BoxLayout.X_AXIS));
		p.add(p1);
		p.add(p3);
		p.add(p2);
		
		ImageIcon img=new ImageIcon("C:\\Users\\Admin\\Desktop\\An2\\POO\\Workspace\\Proiect-BD\\doctors.PNG");
		JLabel l1 = new JLabel(img);
		l1.setBackground(Color.pink);
		JLabel l2 = new JLabel(img);
		l2.setBackground(Color.pink);
		JLabel l3 = new JLabel(img);
		l1.setBackground(Color.pink);
		JLabel l4 = new JLabel(img);
		l2.setBackground(Color.pink);
		p1.add(l1);
		p1.add(Box.createRigidArea(new Dimension(0, 400)));
		p1.add(l3);
		
		p2.add(l2);
		p2.add(Box.createRigidArea(new Dimension(0, 400)));
		p2.add(l4);
		
		this.setContentPane(p);
		this.pack(); //pune toate componentele la dimesiunile dorite
		this.setTitle("Policlinica");
		//this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.setPreferredSize(new Dimension(1000, 500));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	void addLoginListener(ActionListener e) {
		this.btn.addActionListener(e);
	}	
	
	
	void addAdminListener(ActionListener e) {
		this.btnAdmin.addActionListener(e);
	}	
	
	void addSAdminListener(ActionListener e) {
		this.btnSAdmin.addActionListener(e);
	}	
	
	JTextField getUser() {
		return user;
	}
	
	JTextField getPass() {
		return password;
	}
	
}

class PoliclinicaView2 extends JFrame{
	//frame pe care il facem visible cum vrem
	private JLabel numePrenumeUser = new JLabel("Nume Prenume");
	private JLabel functieUser = new JLabel("Functie");
	private JButton btn_disconnect = new JButton("Disconnect");
	private JLabel txt = new JLabel("Selectati departamentul dorit:");
	private JButton btn1 = new JButton("Resurse Umane");
	private JButton btn2 = new JButton("Financiar Contabil");
	private JButton btn3 = new JButton("Activitati Operationale");
	
	PoliclinicaView2(){
		
		numePrenumeUser.setFont(new Font("Times New Roman", Font.BOLD, 15));
		functieUser.setFont(new Font("Times New Roman", Font.BOLD, 15));
		txt.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		
		JPanel p1 = new JPanel();
		p1.setLayout(new BoxLayout(p1, BoxLayout.Y_AXIS));
		p1.add(numePrenumeUser);
		p1.add(functieUser);
		p1.setBackground(Color.pink);
		
		//panel-ul cu imaginea, pe care il pun intre cele doua panel-uri
		//cel cu nume, prenume si disconnect si cel cu butoanele
		//pentru module
		ImageIcon img=new ImageIcon("C:\\Users\\Admin\\Desktop\\An2\\POO\\Workspace\\Proiect-BD\\med1.PNG");
		JLabel l1 = new JLabel(img);
		JLabel l2 = new JLabel(img);
		JLabel l3 = new JLabel(img);
		
		JPanel pimg = new JPanel();
		pimg.setPreferredSize(new Dimension(600, 100));
		pimg.add(l1);
		pimg.add(l2);
		pimg.add(l3);
		pimg.setBackground(Color.pink);
		
		JPanel p2 = new JPanel();
		p2.setLayout(new BoxLayout(p2, BoxLayout.X_AXIS));
		p2.add(p1);
		p2.add(Box.createRigidArea(new Dimension(400, 0)));
		p2.add(btn_disconnect);
		p2.setBackground(Color.pink);
		
		JPanel pUmplutura1 = new JPanel();
		pUmplutura1.setPreferredSize(new Dimension(100, 150));
		pUmplutura1.setBackground(Color.pink);
		JPanel pUmplutura2 = new JPanel();
		pUmplutura2.setPreferredSize(new Dimension(100, 150));
		pUmplutura2.setBackground(Color.pink);
		
		JPanel p3 = new JPanel();
		p3.setPreferredSize(new Dimension(200, 150));
		p3.setLayout(new BoxLayout(p3, BoxLayout.Y_AXIS));
		p3.setBackground(Color.pink);
		
		p3.add(txt);
		p3.add(Box.createRigidArea(new Dimension(0, 20)));
		
		btn1.add(Box.createRigidArea(new Dimension(130, 20)),BorderLayout.WEST);
		p3.add(btn1);
		
		btn2.add(Box.createRigidArea(new Dimension(130, 20)),BorderLayout.WEST);
		p3.add(btn2);
		
		btn3.add(Box.createRigidArea(new Dimension(130, 20)),BorderLayout.WEST);
		p3.add(btn3);
		
		JPanel p33 = new JPanel();
		p33.setLayout(new BoxLayout(p33, BoxLayout.X_AXIS));
		p33.setPreferredSize(new Dimension(400, 150));
		p33.add(pUmplutura1);
		p33.add(p3);
		p33.add(pUmplutura2);
		p33.setBackground(Color.pink);
		
		JPanel p = new JPanel();
		p.setPreferredSize(new Dimension(700, 500));
		p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));
		p.add(p2);
		p.add(Box.createRigidArea(new Dimension(0, 20)));
		p.add(pimg);
		p.add(Box.createRigidArea(new Dimension(0, 20)));
		p.add(p33);
		p.setBackground(Color.pink);
		
		this.setContentPane(p);
		this.pack(); //pune toate componentele la dimesiunile dorite
		this.setTitle("Alegere Modul");
		//this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.setPreferredSize(new Dimension(600, 200));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	void addDisconnectListener(ActionListener e) {
		this.btn_disconnect.addActionListener(e);
	}
	void addBtn1Listener(ActionListener e) {
		this.btn1.addActionListener(e);
	}
	void addBtn2Listener(ActionListener e) {
		this.btn2.addActionListener(e);
	}
	void addBtn3Listener(ActionListener e) {
		this.btn3.addActionListener(e);
	}
	
	JLabel getNumePrenume() {
		return numePrenumeUser;
	}
	
	JLabel getFctie() {
		return functieUser;
	}
}

class PoliclinicaView3 extends JFrame{
	//frame pe care il facem visible cum vrem
	//modulul 1:
	
		private JLabel Modulul = new JLabel("RESURSE UMANE");
		private JLabel intrNume = new JLabel("Inserati nume angajat:");
		private JTextField numeAng = new JTextField();
		private JLabel intrPrenume = new JLabel("Inserati prenume angajat:");
		private JTextField prenumeAng = new JTextField();
		private JLabel intrFctie = new JLabel("Inserati functie angajat:");
		private JTextField fctieAng = new JTextField();
		private JButton btnInapoi = new JButton("Inapoi");
		private JButton btnCautare = new JButton("Date personale");
		private JButton btnVizOrar = new JButton("Vizualizare orar");
		private JButton btnVizConcedii = new JButton("Vizualizare concedii");
		private JButton btnAdaugConcediu = new JButton("Adaugare concediu");
		
		PoliclinicaView3(){
			//setare dimensiuni
			intrNume.setFont(new Font("Times New Roman", Font.PLAIN, 15));
			numeAng.setPreferredSize(new Dimension(200, 30));
			intrPrenume.setFont(new Font("Times New Roman", Font.PLAIN, 15));
			prenumeAng.setPreferredSize(new Dimension(200, 30));
			intrFctie.setFont(new Font("Times New Roman", Font.PLAIN, 15));
			fctieAng.setPreferredSize(new Dimension(200, 30));
			
			numeAng.setPreferredSize(new Dimension(200, 30));
			prenumeAng.setPreferredSize(new Dimension(200, 30));
			fctieAng.setPreferredSize(new Dimension(200, 30));
			
			ImageIcon img=new ImageIcon("C:\\Users\\Admin\\Desktop\\An2\\POO\\Workspace\\Proiect-BD\\hr.PNG");
			JLabel limg = new JLabel(img);
			
			//panel cu Modulul:
			JPanel pUmplutura = new JPanel();
			pUmplutura.setBackground(Color.pink);
			JPanel pModul = new JPanel();
			pModul.setLayout(new BoxLayout(pModul, BoxLayout.X_AXIS));
			pModul.setPreferredSize(new Dimension(700, 100));
			pModul.add(Modulul);
			pModul.add(Box.createRigidArea(new Dimension(200, 0)));
			pModul.add(limg);
			pModul.add(Box.createRigidArea(new Dimension(200, 0)));
			pModul.add(btnInapoi);
			pModul.setBackground(Color.pink);
			
			JPanel p1 = new JPanel();
			p1.setPreferredSize(new Dimension(700, 300));
			p1.setBackground(Color.pink);
			p1.add(intrNume);
			p1.add(numeAng);
			p1.add(intrPrenume);
			p1.add(prenumeAng);
			p1.add(Box.createRigidArea(new Dimension(0, 80)));
			p1.add(intrFctie);
			p1.add(fctieAng);
			
			//Panel cu butoanele:
			JPanel pu1 = new JPanel();
			JPanel pu2 = new JPanel();
			pu1.setPreferredSize(new Dimension(50, 100));
			pu2.setPreferredSize(new Dimension(50, 100));
			pu2.setBackground(Color.pink);
			pu1.setBackground(Color.pink);
			
			JPanel pbtn = new JPanel();
			pbtn.setLayout(new BoxLayout(pbtn, BoxLayout.Y_AXIS));
			pbtn.setPreferredSize(new Dimension(200, 200));
			btnCautare.add(Box.createRigidArea(new Dimension(130, 30)),BorderLayout.WEST);
			pbtn.add(btnCautare);
			btnVizOrar.add(Box.createRigidArea(new Dimension(130, 30)),BorderLayout.WEST);
			pbtn.add(btnVizOrar);
			btnVizConcedii.add(Box.createRigidArea(new Dimension(130, 30)),BorderLayout.WEST);
			pbtn.add(btnVizConcedii);
			btnAdaugConcediu.add(Box.createRigidArea(new Dimension(130, 30)),BorderLayout.WEST);
			pbtn.add(btnAdaugConcediu);
			pbtn.setBackground(Color.pink);
			
			JPanel pbtnComplet = new JPanel();
			pbtnComplet.add(pu1);
			pbtnComplet.add(pbtn);
			pbtnComplet.add(pu2);
			pbtnComplet.setBackground(Color.pink);
			
			//panel-ul final:
			JPanel p = new JPanel();
			p.setPreferredSize(new Dimension(700, 500));
			p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));
			p.add(pModul);
			p.add(Box.createRigidArea(new Dimension(0, 20)));
			p.add(p1);
			p.add(pbtnComplet);
			p.setBackground(Color.pink);
			
			this.setContentPane(p);
			this.pack(); //pune toate componentele la dimesiunile dorite
			this.setTitle("Resurse Umane");
			this.setPreferredSize(new Dimension(700, 500));
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}
		
		void addInapoiListener3(ActionListener e) {
			this.btnInapoi.addActionListener(e);
		}
		
		void addAdaugaConcediuListener(ActionListener e) {
			this.btnAdaugConcediu.addActionListener(e);
		}
		
		void addDatePersonaleListener(ActionListener e) {
			this.btnCautare.addActionListener(e);
		}
		
		void addVizOrarListener(ActionListener e) {
			this.btnVizOrar.addActionListener(e);
		}
		
		void addVizOrarConcListener(ActionListener e) {
			this.btnVizConcedii.addActionListener(e);
		}
		
		JTextField getNume() {
			return numeAng;
		}
		
		JTextField getPNume() {
			return prenumeAng;
		}
		
		JTextField getFctie() {
			return fctieAng;
		}
}

class PoliclinicaView4 extends JFrame{
	//frame pe care il facem visible cum vrem
	//modulul 1 - concediu si zile libere - ambele butoane ne duc aici:
		
		//facem un alt frame pentru inserare concediu in orar specific:
		private JLabel Modulul = new JLabel("RESURSE UMANE");
		private JLabel inceput = new JLabel("Introduceti perioada de concediu: ");
		//private JLabel sfarsit = new JLabel("Introduceti:");
		private JTextField inceputConcediu = new JTextField("data de inceput");
		private JTextField sfarsitConcediu = new JTextField("data de sfarsit");
		private JLabel zi = new JLabel("Alegeti ziua libera:");
		private JTextField ziLibera = new JTextField("data zi libera");
		private String[] Ore1 = new String[] {"ora de inceput", "01:00", "02:00", "03:00", "04:00", "05:00", "06:00", "07:00", "08:00", "09:00", "10:00", "11:00", "12:00", "13:00", "14:00", "15:00", "16:00", "17:00", "18:00", "19:00", "20:00", "21:00", "22:00", "23:00", "00:00"};
		private String[] Ore2 = new String[] {"ora de sfarsit", "01:00", "02:00", "03:00", "04:00", "05:00", "06:00", "07:00", "08:00", "09:00", "10:00", "11:00", "12:00", "13:00", "14:00", "15:00", "16:00", "17:00", "18:00", "19:00", "20:00", "21:00", "22:00", "23:00", "00:00"};
		private JComboBox OraInceputZi = new JComboBox(Ore1);
		private JComboBox OraSfarsitZi = new JComboBox(Ore2);
		private JButton btnConcediu = new JButton("Adauga concediu");
		private JButton btnZi = new JButton("Adauga zi libera");
		private JButton btnInapoi = new JButton("Inapoi");
		
		PoliclinicaView4(){
			
			//panel cu Modulul:
			JPanel pModul = new JPanel();
			pModul.setLayout(new BoxLayout(pModul, BoxLayout.X_AXIS));
			pModul.setPreferredSize(new Dimension(500, 50));
			pModul.add(Modulul);
			pModul.add(Box.createRigidArea(new Dimension(500, 0)));
			pModul.add(btnInapoi);
			pModul.setBackground(Color.pink);
			
			//Panel cu concediul:
			JPanel pUmplutura1 = new JPanel();
			pUmplutura1.setPreferredSize(new Dimension(200, 200));
			pUmplutura1.setBackground(Color.pink);
			JPanel p1 = new JPanel();
			p1.setLayout(new BoxLayout(p1, BoxLayout.Y_AXIS));
			p1.setPreferredSize(new Dimension(200, 200));
			//p1.add(Box.createRigidArea(new Dimension(10, 0)), BorderLayout.EAST);
			inceput.setAlignmentX(CENTER_ALIGNMENT);
			p1.add(inceput);
			p1.add(Box.createRigidArea(new Dimension(0, 5)));
			p1.add(inceputConcediu);
			p1.add(Box.createRigidArea(new Dimension(0, 5)));
			p1.add(sfarsitConcediu);
			//asta imi alineaza butonul sau orice alta componenta in centru:
			btnConcediu.setAlignmentX(CENTER_ALIGNMENT);
			p1.add(Box.createRigidArea(new Dimension(0, 5)));
			p1.add(btnConcediu);
			p1.add(pUmplutura1);
			p1.setBackground(Color.pink);
			
			//Panel cu ziua libera:
			JPanel pUmplutura2 = new JPanel();
			pUmplutura2.setPreferredSize(new Dimension(200, 200));
			pUmplutura2.setBackground(Color.pink);
			JPanel p2 = new JPanel();
			p2.setLayout(new BoxLayout(p2, BoxLayout.Y_AXIS));
			p2.setPreferredSize(new Dimension(200, 100));
			zi.setAlignmentX(CENTER_ALIGNMENT);
			p2.add(zi);
			p2.add(ziLibera);
			p2.add(OraInceputZi);
			p2.add(OraSfarsitZi);
			btnZi.setAlignmentX(CENTER_ALIGNMENT);
			p2.add(btnZi);
			p2.add(pUmplutura2);
			p2.setBackground(Color.pink);
			
			//panou de umplutura intre cele doua panouri:
			JPanel sau = new JPanel();
			sau.setPreferredSize(new Dimension(50, 200));
			sau.setBackground(Color.pink);
			
			JPanel p12 = new JPanel();
			p12.setLayout(new BoxLayout(p12, BoxLayout.X_AXIS));
			p12.add(p1);
			p12.add(sau);
			p12.add(p2);
			
			//panel-ul final:
			JPanel p = new JPanel();
			p.setPreferredSize(new Dimension(700, 300));
			p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));
			p.add(pModul);
			p.add(Box.createRigidArea(new Dimension(0, 20)));
			p.add(p12);
			p.setBackground(Color.pink);
			
			this.setContentPane(p);
			this.pack(); //pune toate componentele la dimesiunile dorite
			this.setTitle("Resurse Umane");
			this.setPreferredSize(new Dimension(700, 300));
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}
		
		JTextField getZiInceput() {
			return inceputConcediu;
		}
		
		JTextField getZiSfarsit() {
			return sfarsitConcediu;
		}
		
		JTextField getZiLibera() {
			return ziLibera;
		}
		
		JComboBox getOraInceput() {
			return OraInceputZi;
		}
		
		JComboBox getOraSfarsit() {
			return OraSfarsitZi;
		}
		
		void addInapoiListener4(ActionListener e) {
			this.btnInapoi.addActionListener(e);
		}
		
		void addBtnConcediuListener(ActionListener e) {
			this.btnConcediu.addActionListener(e);
		}
		
		void addBtnZiLiberaListener(ActionListener e) {
			this.btnZi.addActionListener(e);
		}
}

class PoliclinicaView5 extends JFrame{
	
	private JLabel Modulul = new JLabel("FINANCIAR CONTABIL");
	private JLabel l = new JLabel("Alegeti luna: ");
	private String[] Luni = new String[] {"luna", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"};
	private JComboBox Luna = new JComboBox(Luni);
	private JLabel lNA = new JLabel("Introduceti numele:");
	private JLabel lPA = new JLabel("Introduceti prenumele:");
	private JLabel lP = new JLabel("Introduceti policlinica:");
	private JTextField numeAngajat = new JTextField();
	private JTextField prenumeAngajat = new JTextField();
	private JTextField policlinica = new JTextField();
	private JButton btnAng = new JButton("Angajat");
	private JButton btnPoliclinica1 = new JButton("Policlinica");
	private JButton btnPoliclinici = new JButton("Policlinici");
	private JButton btnInapoi = new JButton("Inapoi");
	
	private JLabel vA = new JLabel("Venitul pentru un angajat:");
	private JLabel vP = new JLabel("Venitul pentru o policlinica sau toate policlinicile:");
	private JLabel vL = new JLabel("Luna pentru care se calculeaza venitul:");
	

	// Constructor:
	PoliclinicaView5()
	{	
		//Labels:
		Modulul.setFont(new Font("Times New Roman", Font.BOLD, 15));
		l.setFont(new Font("Times New Roman", Font.ITALIC, 15));
		numeAngajat.setPreferredSize(new Dimension(100, 20));	
		prenumeAngajat.setPreferredSize(new Dimension(100, 20));
		policlinica.setPreferredSize(new Dimension(100, 20));
		
		//Panels:
		JPanel p = new JPanel();
		p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));
		p.setPreferredSize(new Dimension(700, 500)); 
		p.setBackground(Color.pink);
			
		JPanel p1 = new JPanel();
		p1.setPreferredSize(new Dimension(700, 100));
		p1.setLayout(new FlowLayout());
		p1.setBackground(Color.pink);
	
		ImageIcon img=new ImageIcon("C:\\Users\\Admin\\Desktop\\An2\\POO\\Workspace\\Proiect-BD\\acc.PNG");
		JLabel limg = new JLabel(img);
		
		JPanel p2 = new JPanel();
		p2.setPreferredSize(new Dimension(700, 100));
		p2.setLayout(new FlowLayout());
		p2.setBackground(Color.pink);
		
		JPanel p3 = new JPanel();
		p3.setPreferredSize(new Dimension(700, 200));
		p3.setLayout(new FlowLayout());
		p3.setBackground(Color.pink);
			
		//Adaugari:
		p1.add(Modulul);
		p1.add(Box.createRigidArea(new Dimension(100, 0)));
		p1.add(limg);
		p1.add(Box.createRigidArea(new Dimension(100, 0)));
		p1.add(btnInapoi);
		p1.add(Box.createRigidArea(new Dimension(0, 100)));
		
		p2.add(Box.createRigidArea(new Dimension(50, 0)));
		p2.add(vA);
		p2.add(Box.createRigidArea(new Dimension(700, 30)));
		p2.add(lNA);
		p2.add(Box.createRigidArea(new Dimension(20, 0)));
		p2.add(numeAngajat);
	    p2.add(Box.createRigidArea(new Dimension(20, 0)));
		p2.add(lPA);
		p2.add(Box.createRigidArea(new Dimension(20, 0)));
		p2.add(prenumeAngajat);
		p2.add(Box.createRigidArea(new Dimension(20, 0)));
		p2.add(btnAng);
		
		p3.add(Box.createRigidArea(new Dimension(50, 0)));
		p3.add(vP);
		p3.add(Box.createRigidArea(new Dimension(700, 0)));
		p3.add(lP);
	    p3.add(Box.createRigidArea(new Dimension(20, 0)));
	    p3.add(policlinica);
	    p3.add(Box.createRigidArea(new Dimension(50, 0)));
	    p3.add(btnPoliclinica1);
	    p3.add(Box.createRigidArea(new Dimension(50, 0)));
	    p3.add(btnPoliclinici);
	    
	    p3.add(Box.createRigidArea(new Dimension(100, 100)));
		p3.add(vL);
		p3.add(Box.createRigidArea(new Dimension(50, 0)));
		p3.add(l);
		p3.add(Box.createRigidArea(new Dimension(10, 0)));
	    p3.add(Luna);
	    p3.add(Box.createRigidArea(new Dimension(10, 0)));
	    
	    p.add(p1);
	    p.add(Box.createRigidArea(new Dimension(0, 50)));
	    p.add(p2);
	    p.add(Box.createRigidArea(new Dimension(0, 50)));
	    p.add(p3);
			
		//Finalul frame-ului:
		this.setContentPane(p); 
		this.pack(); 
		this.setTitle("Financiar Contabil"); 
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	JTextField getNumeAng() {
		return numeAngajat;
	}
	
	JTextField getPrenumeAng() {
		return prenumeAngajat;
	}
	
	JTextField getNumePol() {
		return policlinica;
	}
	
	JComboBox getLuna() {
		return Luna;
	}
	
	void addInapoiListener5(ActionListener e) {
		this.btnInapoi.addActionListener(e);
	}
	
	void addVenitAngListener(ActionListener e) {
		this.btnAng.addActionListener(e);
	}
	
	void addBtnPolListener(ActionListener e) {
		this.btnPoliclinica1.addActionListener(e);
	}
	
	void addBtnPolicliniciListener(ActionListener e) {
		this.btnPoliclinici.addActionListener(e);
	}
	
}

class PoliclinicaView6 extends JFrame{
	
	private JLabel Modulul = new JLabel("ACTIVITATI OPERATIONALE");
	//prima coloana:
	private JLabel lP = new JLabel("1.Creare Programare:");
	private JLabel lB = new JLabel("2.Emitere bon:");
	private JLabel lPrg = new JLabel("Id Programare:");
	private JLabel lR = new JLabel("3.Inserare Raport:");
	private JLabel lPar = new JLabel("4.Parafa:");
	private JTextField idPrg = new JTextField();
	private JTextField idPrg1 = new JTextField("Id Programare");
	private JTextField idPrgBon = new JTextField("Id Programare");
	private JTextField prenumeAngajat = new JTextField();
	private JTextField policlinica = new JTextField();
	private JButton btnPrg = new JButton(">>");
	private JButton btnRap = new JButton(">>");
	private JButton btnBon = new JButton(">>");
	private JButton btnPar = new JButton(">>");
	private JButton btnInapoi = new JButton("Inapoi");
	
	//a doua coloana:
	private String[] Luni = new String[] {"luna", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"};
	private JComboBox Luna = new JComboBox(Luni);
	private String[] Zile = new String[] {"zi", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"};
	private JComboBox Zi = new JComboBox(Zile);
	private JLabel lPac = new JLabel("5.Vizualizare pacienti:");
	private JLabel lIst = new JLabel("6.Istoric pacient:");
	private JLabel lMed = new JLabel("Id Medic:");
	private JTextField idPac = new JTextField();
	private JLabel lPacient = new JLabel("Id Pacient:");
	private JTextField idMed = new JTextField();
	private JButton btnMed = new JButton(">>");
	private JButton btnPac = new JButton(">>");
	
	

	// Constructor:
	PoliclinicaView6()
	{	
		//Labels:
		Modulul.setFont(new Font("Times New Roman", Font.BOLD, 15));
		idMed.setPreferredSize(new Dimension(100, 20));
		idPac.setPreferredSize(new Dimension(100, 20));
		idPrgBon.setPreferredSize(new Dimension(100, 20));
		idPrg1.setPreferredSize(new Dimension(100, 20));
		
		//Panels:
		JPanel p = new JPanel();
		p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));
		p.setPreferredSize(new Dimension(700, 500)); 
		p.setBackground(Color.pink);
			
		JPanel p1 = new JPanel();
		p1.setLayout(new FlowLayout());
		p1.setBackground(Color.pink);
		p1.setPreferredSize(new Dimension(700, 300)); 

		JPanel p2 = new JPanel();
		p2.setLayout(new FlowLayout());
		p2.setBackground(Color.pink);
		p2.setPreferredSize(new Dimension(700, 200)); 
			
		ImageIcon img = new ImageIcon("C:\\Users\\Admin\\Desktop\\An2\\POO\\Workspace\\Proiect-BD\\doctor11.PNG");
		JLabel limg = new JLabel(img);
		ImageIcon img1 = new ImageIcon("C:\\Users\\Admin\\Desktop\\An2\\POO\\Workspace\\Proiect-BD\\med1.PNG");
		JLabel limg1 = new JLabel(img1);
		JLabel limg2 = new JLabel(img1);
		JLabel limg3 = new JLabel(img1);
		JLabel limg4 = new JLabel(img1);
			
		//Adaugari:
		p2.add(Modulul);
		p2.add(Box.createRigidArea(new Dimension(250, 25)));
		p2.add(btnInapoi);
		p2.add(limg1);
		p2.add(limg2);
		p2.add(limg3);
		p2.add(limg4);
		p2.add(Box.createRigidArea(new Dimension(250, 50)));
		
		p1.add(Box.createRigidArea(new Dimension(25, 0)));
		p1.add(lP);
		p1.add(Box.createRigidArea(new Dimension(25, 0)));
	    p1.add(btnPrg);
	    p1.add(Box.createRigidArea(new Dimension(100, 0)));
	    p1.add(lB);
		p1.add(Box.createRigidArea(new Dimension(25, 0)));
	    p1.add(idPrgBon);
	    p1.add(Box.createRigidArea(new Dimension(50, 0)));
	    p1.add(btnBon);
	    p1.add(lR);
	    p1.add(Box.createRigidArea(new Dimension(60, 0)));
	    p1.add(btnRap);
	    p1.add(Box.createRigidArea(new Dimension(100, 0)));
	    p1.add(lPar);
	    p1.add(Box.createRigidArea(new Dimension(30, 0)));
	    p1.add(idPrg1);
	    p1.add(Box.createRigidArea(new Dimension(30, 0)));
	    p1.add(btnPar);
	    p1.add(Box.createRigidArea(new Dimension(10, 100)));
			
	    p1.add(lPac);
	    p1.add(Box.createRigidArea(new Dimension(25, 0)));
	    p1.add(lMed);
	    p1.add(Box.createRigidArea(new Dimension(25, 0)));
	    p1.add(idMed);
	    p1.add(Box.createRigidArea(new Dimension(25, 0)));
	    p1.add(Zi);
	    p1.add(Box.createRigidArea(new Dimension(25, 0)));
	    p1.add(Luna);
	    p1.add(Box.createRigidArea(new Dimension(30, 0)));
	    p1.add(btnMed);
	    p1.add(Box.createRigidArea(new Dimension(30, 0)));
	    p1.add(lIst);
	    p1.add(Box.createRigidArea(new Dimension(30, 0)));
	    p1.add(lPacient);
	    p1.add(Box.createRigidArea(new Dimension(30, 0)));
	    p1.add(idPac);
	    p1.add(Box.createRigidArea(new Dimension(30, 0)));
	    p1.add(btnPac);
	    p1.add(Box.createRigidArea(new Dimension(30, 100)));
	    
	    p.add(p2);
	    p.add(p1);
			
		//Finalul frame-ului:
		this.setContentPane(p); 
		this.pack(); 
		this.setTitle("Castigatorul jocului."); 
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	void addInapoiListener6(ActionListener e) {
		this.btnInapoi.addActionListener(e);
	}
	
	void addBtnBon(ActionListener e) {
		this.btnBon.addActionListener(e);
	}
	
	void addBtnPar(ActionListener e) {
		this.btnPar.addActionListener(e);
	}
	
	JTextField getidPrgBon() {
		return idPrgBon;
	}
	
	JTextField getidPrgPar() {
		return idPrg1;
	}
	
	JTextField getidMed() {
		return idMed;
	}
	
	JTextField getidPac() {
		return idPac;
	}
	
	JComboBox getLuna() {
		return Luna;
	}
	
	JComboBox getZi() {
		return Zi;
	}
	
	void addBtnPrg(ActionListener e) {
		this.btnPrg.addActionListener(e);
	}
	
	void addBtnRap(ActionListener e) {
		this.btnRap.addActionListener(e);
	}
	
	void addBtnMed(ActionListener e) {
		this.btnMed.addActionListener(e);
	}
	
	void addBtnPac(ActionListener e) {
		this.btnPac.addActionListener(e);
	}
}

class PoliclinicaView7 extends JFrame{
	
	private JLabel Modulul = new JLabel("RESURSE UMANE - DATE PERSONALE");
	private JLabel lNume = new JLabel("Nume: ");
	private JLabel lPNume = new JLabel("Prenume:");
	private JLabel lCNP = new JLabel("CNP:");
	private JLabel lAdr = new JLabel("Adresa:");
	private JLabel lNr = new JLabel("Nr. Telefon:");
	private JLabel lEmail = new JLabel("Email:");
	private JLabel lIban = new JLabel("Iban:");
	private JLabel lNrContract = new JLabel("Nr. Contract:");
	private JLabel lDAng = new JLabel("Data Angajarii:");
	private JLabel lSal = new JLabel("Salariu:");
	private JLabel lNrOre = new JLabel("Nr. Ore:");
	
	private JTextField tNume = new JTextField();
	private JTextField tPNume = new JTextField();
	private JTextField tCNP = new JTextField();
	private JTextField tAdr = new JTextField();
	private JTextField tNr = new JTextField();
	private JTextField tEmail = new JTextField();
	private JTextField tNrContract = new JTextField();
	private JTextField tDAng = new JTextField();
	private JTextField tSal = new JTextField();
	private JTextField tNrOre = new JTextField();
	private JTextField tIban = new JTextField();
	
	private JButton btnInapoi = new JButton("Inapoi");
	
	PoliclinicaView7(){
		
		//text field-uri ne-editabile:
		tNume.setEditable(false);
		tPNume.setEditable(false);
		tCNP.setEditable(false);
		tAdr.setEditable(false);
		tNr.setEditable(false);
		tEmail.setEditable(false);
		tNrContract.setEditable(false);
		tDAng.setEditable(false);
		tSal.setEditable(false);
		tNrOre.setEditable(false);
		tIban.setEditable(false);
		
		//Labels:
		Modulul.setFont(new Font("Times New Roman", Font.BOLD, 15));
		tNume.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		tNume.setPreferredSize(new Dimension(200, 30));
		tPNume.setPreferredSize(new Dimension(200, 30));
		tPNume.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		tCNP.setPreferredSize(new Dimension(200, 30));
		tCNP.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		tAdr.setPreferredSize(new Dimension(200, 30));
		tAdr.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		tNr.setPreferredSize(new Dimension(200, 30));
		tNr.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		tEmail.setPreferredSize(new Dimension(200, 30));
		tEmail.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		tNrContract.setPreferredSize(new Dimension(200, 30));
		tNrContract.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		tDAng.setPreferredSize(new Dimension(200, 30));
		tDAng.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		tSal.setPreferredSize(new Dimension(200, 30));
		tSal.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		tNrOre.setPreferredSize(new Dimension(200, 30));
		tNrOre.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		tIban.setPreferredSize(new Dimension(200, 30));
		tIban.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		
		// Panels:
		JPanel p = new JPanel();
		p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));
		p.setPreferredSize(new Dimension(1000, 750));
		p.setBackground(Color.pink);

		JPanel p1 = new JPanel();
		p1.setLayout(new FlowLayout());
		p1.setBackground(Color.pink);

		//ImageIcon img = new ImageIcon("C:\\Users\\Admin\\Desktop\\An2\\POO\\Workspace\\Proiect-BD\\money_bills1.JPG");
		//JLabel limg = new JLabel(img);

		JPanel p2 = new JPanel();
		p2.setLayout(new FlowLayout());
		p2.setBackground(Color.pink);
		
		JPanel p3 = new JPanel();
		p3.setLayout(new FlowLayout());
		p3.setBackground(Color.pink);
		
		JPanel p4 = new JPanel();
		p4.setLayout(new FlowLayout());
		p4.setBackground(Color.pink);
		
		JPanel p5 = new JPanel();
		p5.setLayout(new FlowLayout());
		p5.setBackground(Color.pink);
		
		p1.add(Modulul);
		p1.add(Box.createRigidArea(new Dimension(500, 0)));
		p1.add(btnInapoi);
		
		p2.add(lNume);
		p2.add(Box.createRigidArea(new Dimension(25, 0)));
		p2.add(tNume);
		p2.add(Box.createRigidArea(new Dimension(25, 0)));
		p2.add(lPNume);
		p2.add(Box.createRigidArea(new Dimension(25, 0)));
		p2.add(tPNume);
		p2.add(Box.createRigidArea(new Dimension(25, 0)));
		p2.add(lCNP);
		p2.add(Box.createRigidArea(new Dimension(25, 0)));
		p2.add(tCNP);
		
		p3.add(lAdr);
		p3.add(Box.createRigidArea(new Dimension(25, 0)));
		p3.add(tAdr);
		p3.add(Box.createRigidArea(new Dimension(25, 0)));
		p3.add(lNr);
		p3.add(Box.createRigidArea(new Dimension(25, 0)));
		p3.add(tNr);
		p3.add(Box.createRigidArea(new Dimension(25, 0)));
		p3.add(lEmail);
		p3.add(Box.createRigidArea(new Dimension(25, 0)));
		p3.add(tEmail);
		
		p4.add(lIban);
		p4.add(Box.createRigidArea(new Dimension(30, 0)));
		p4.add(tIban);
		p4.add(Box.createRigidArea(new Dimension(40, 0)));
		p4.add(lSal);
		p4.add(Box.createRigidArea(new Dimension(30, 0)));
		p4.add(tSal);
		p4.add(Box.createRigidArea(new Dimension(40, 0)));
		p4.add(lNrOre);
		p4.add(Box.createRigidArea(new Dimension(30, 0)));
		p4.add(tNrOre);
		
		p5.add(lDAng);
		p5.add(Box.createRigidArea(new Dimension(50, 0)));
		p5.add(tDAng);
		p5.add(Box.createRigidArea(new Dimension(50, 0)));
		p5.add(lNrContract);
		p5.add(Box.createRigidArea(new Dimension(20, 0)));
		p5.add(tNrContract);
		p5.add(Box.createRigidArea(new Dimension(20, 0)));
		
		
		
		p.add(p1);
		p1.setAlignmentX(CENTER_ALIGNMENT);
		p.add(p2);
		p2.setAlignmentX(CENTER_ALIGNMENT);
		p.add(p3);
		p3.setAlignmentX(CENTER_ALIGNMENT);
		p.add(p4);
		p4.setAlignmentX(CENTER_ALIGNMENT);
		p.add(p5);
		p5.setAlignmentX(CENTER_ALIGNMENT);
		
		this.setContentPane(p);
		this.pack(); //pune toate componentele la dimesiunile dorite
		this.setTitle("Resurse Umane");
		this.setPreferredSize(new Dimension(1000, 750));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	void addInapoiListener7(ActionListener e) {
		this.btnInapoi.addActionListener(e);
	}
	
	void setTextFields(String nume, String prenume, String CNP, String adr, String nr, String email, String iban, String nrContract, String dAng, String sal, String nrOre) {
		tNume.setText(nume);
		tPNume.setText(prenume);
		tCNP.setText(CNP);
		tAdr.setText(adr);
		tNr.setText(nr);
		tEmail.setText(email);
		tIban.setText(iban);
		tNrContract.setText(nrContract);
		tDAng.setText(dAng);
		tSal.setText(sal);
		tNrOre.setText(nrOre);
	}
}

class PoliclinicaView8 extends JFrame{
	
	private JLabel Modulul = new JLabel("RESURSE UMANE - ORAR");
	private JLabel lO = new JLabel("Vizualizati orarul angajatului:");
	private JComboBox orar = new JComboBox();
	private JButton btnInapoi = new JButton("Inapoi");
	
	PoliclinicaView8(){
		
		//Labels:
		Modulul.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lO.setPreferredSize(new Dimension(200, 30));
		lO.setFont(new Font("Times New Roman", Font.BOLD, 15));
		
		// Panels:
		JPanel p = new JPanel();
		p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));
		p.setPreferredSize(new Dimension(700, 500));
		p.setBackground(Color.pink);

		JPanel p1 = new JPanel();
		p1.setLayout(new FlowLayout());
		p1.setBackground(Color.pink);

		ImageIcon img = new ImageIcon("C:\\Users\\Admin\\Desktop\\An2\\POO\\Workspace\\Proiect-BD\\cal1.PNG");
		JLabel limg = new JLabel(img);
		JLabel limg1 = new JLabel(img);
		JLabel limg2 = new JLabel(img);

		JPanel p2 = new JPanel();
		p2.setLayout(new FlowLayout());
		p2.setBackground(Color.pink);
		
		p1.add(Modulul);
		p1.add(Box.createRigidArea(new Dimension(100, 0)));
		p1.add(limg);
		p1.add(limg2);
		p1.add(Box.createRigidArea(new Dimension(50, 0)));
		p1.add(btnInapoi);
			
		p2.add(limg1);
		p2.add(lO);
		p2.add(Box.createRigidArea(new Dimension(25, 0)));
		p2.add(orar);
		
		p.add(p1);
		p1.setAlignmentX(CENTER_ALIGNMENT);
		p.add(p2);
		p2.setAlignmentX(CENTER_ALIGNMENT);

		this.setContentPane(p);
		this.pack(); //pune toate componentele la dimesiunile dorite
		this.setTitle("Resurse Umane");
		this.setPreferredSize(new Dimension(700, 400));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	void setLabel(String s) {
		lO.setText(s);
	}
	
	void setModul(String s) {
		Modulul.setText(s);
	}
	
	void addInapoiListener8(ActionListener e) {
		this.btnInapoi.addActionListener(e);
	}
	
	public JComboBox getOrar() {
		return orar;
	}
}

class PoliclinicaView9 extends JFrame{
	
	private JLabel Modulul = new JLabel("ACIVITATI OPERATIONALE");
	private JLabel lZi = new JLabel("Introduceti zi:");
	private JLabel lLuna = new JLabel("Introduceti luna:");
	private JLabel lAn = new JLabel("Introduceti an:");
	private JLabel lOraInceput = new JLabel("Introduceti ora de inceput:");
	private JLabel lS = new JLabel("Introduceti specialitate:");
	private JLabel lMedic1 = new JLabel("Introduceti id medic 1:");
	private JLabel lMedic2 = new JLabel("Introduceti id medic 2:");
	private JLabel lAsistent = new JLabel("Introduceti asistent medical:");
	private JLabel lPac = new JLabel("Introduceti asistent pacient:");
	private JLabel lServ1 = new JLabel("Introduceti serviciu 1:");
	private JLabel lServ2 = new JLabel("Introduceti serviciu 2:");
	private JLabel lServ3 = new JLabel("Introduceti serviciu 3:");
	
	private JTextField tZi = new JTextField();
	private JTextField tLuna = new JTextField();
	private JTextField tAn = new JTextField();
	private JTextField tOraInceput = new JTextField();
	private JTextField tS = new JTextField();
	private JTextField tMedic1 = new JTextField();
	private JTextField tMedic2 = new JTextField();
	private JTextField tAsistent = new JTextField();
	private JTextField tPac = new JTextField();
	private JTextField tServ1 = new JTextField();
	private JTextField tServ2 = new JTextField();
	private JTextField tServ3 = new JTextField();
	
	private JButton btnInapoi = new JButton("Inapoi");
	private JButton btnPrg = new JButton("Creati Programare");
	
	PoliclinicaView9(){
		
		//Labels:
		Modulul.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lZi.setPreferredSize(new Dimension(200, 30));
		lZi.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lLuna.setPreferredSize(new Dimension(200, 30));
		lLuna.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lAn.setPreferredSize(new Dimension(200, 30));
		lAn.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lOraInceput.setPreferredSize(new Dimension(200, 30));
		lOraInceput.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lS.setPreferredSize(new Dimension(200, 30));
		lS.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lMedic1.setPreferredSize(new Dimension(200, 30));
		lMedic1.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lMedic2.setPreferredSize(new Dimension(200, 30));
		lMedic2.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lAsistent.setPreferredSize(new Dimension(200, 30));
		lAsistent.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lPac.setPreferredSize(new Dimension(200, 30));
		lPac.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lServ1.setPreferredSize(new Dimension(200, 30));
		lServ1.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lServ2.setPreferredSize(new Dimension(200, 30));
		lServ2.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lServ3.setPreferredSize(new Dimension(200, 30));
		lServ3.setFont(new Font("Times New Roman", Font.BOLD, 15));
		
		//text fields:
		tZi.setPreferredSize(new Dimension(200, 30));
		tLuna.setPreferredSize(new Dimension(200, 30));
		tAn.setPreferredSize(new Dimension(200, 30));
		tOraInceput.setPreferredSize(new Dimension(200, 30));
		tS.setPreferredSize(new Dimension(200, 30));
		tMedic1.setPreferredSize(new Dimension(200, 30));
		tMedic2.setPreferredSize(new Dimension(200, 30));
		tAsistent.setPreferredSize(new Dimension(200, 30));
		tPac.setPreferredSize(new Dimension(200, 30));
		tServ1.setPreferredSize(new Dimension(200, 30));
		tServ2.setPreferredSize(new Dimension(200, 30));
		tServ3.setPreferredSize(new Dimension(200, 30));
		
		// Panels:
		JPanel p = new JPanel();
		p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));
		p.setPreferredSize(new Dimension(1000, 500));
		p.setBackground(Color.pink);

		JPanel p1 = new JPanel();
		p1.setLayout(new FlowLayout());
		p1.setBackground(Color.pink);
		p1.setPreferredSize(new Dimension(1000, 200));

		JPanel p2 = new JPanel();
		p2.setLayout(new FlowLayout());
		p2.setBackground(Color.pink);
		p2.setPreferredSize(new Dimension(1000, 300));
		
		ImageIcon img = new ImageIcon("C:\\Users\\Admin\\Desktop\\An2\\POO\\Workspace\\Proiect-BD\\appointment.PNG");
		JLabel limg = new JLabel(img);
		
		p1.add(Modulul);
		p1.add(Box.createRigidArea(new Dimension(200, 0)));
		p1.add(limg);
		p1.add(Box.createRigidArea(new Dimension(200, 0)));
		p1.add(btnInapoi);
			
		p2.add(lZi);
		p2.add(tZi);
		
		p2.add(lLuna);
		p2.add(tLuna);
		
		p2.add(lAn);
		p2.add(tAn);
		
		p2.add(lOraInceput);
		p2.add(tOraInceput);
		
		p2.add(lS);
		p2.add(tS);
		
		p2.add(lMedic1);
		p2.add(tMedic1);
		
		p2.add(lMedic2);
		p2.add(tMedic2);
		
		p2.add(lAsistent);
		p2.add(tAsistent);
		
		p2.add(lPac);
		p2.add(tPac);
		
		p2.add(lServ1);
		p2.add(tServ1);
		
		p2.add(lServ2);
		p2.add(tServ2);
		
		p2.add(lServ3);
		p2.add(tServ3);
		p2.add(Box.createRigidArea(new Dimension(1000, 0)));
		
		p2.add(btnPrg);

		p.add(p1);
		p.add(p2);

		this.setContentPane(p);
		this.pack(); //pune toate componentele la dimesiunile dorite
		this.setTitle("Activitati Operationale");
		this.setPreferredSize(new Dimension(1000, 500));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	void addInapoiListener9(ActionListener e) {
		this.btnInapoi.addActionListener(e);
	}
	
	void addAdaugaPrg(ActionListener e) {
		this.btnPrg.addActionListener(e);
	}
	
	JTextField txt1() {
		return tZi;
	}
	
	JTextField txt2() {
		return tLuna;
	}
	
	JTextField txt3() {
		return tAn;
	}
	
	JTextField txt4() {
		return tOraInceput;
	}
	
	JTextField txt5() {
		return tS;
	}
	
	JTextField txt6() {
		return tMedic1;
	}
	
	JTextField txt7() {
		return tMedic2;
	}
	
	JTextField txt8() {
		return tAsistent;
	}
	
	JTextField txt9() {
		return tPac;
	}
	
	JTextField txt10() {
		return tServ1;
	}
	
	JTextField txt11() {
		return tServ2;
	}
	
	JTextField txt12() {
		return tServ3;
	}
}

class PoliclinicaView10 extends JFrame{
	
	private JLabel Modulul = new JLabel("ACIVITATI OPERATIONALE");
	private JLabel lId = new JLabel("Introduceti Id Programare:");
	private JLabel lSimp = new JLabel("Introduceti Simptome:");
	private JLabel lDiag = new JLabel("Introduceti Diagnostic:");
	private JLabel lRec = new JLabel("Introduceti Recomandari:");
	private JLabel lDes1 = new JLabel("Introduceti descriere1:");
	private JLabel lDes2 = new JLabel("Introduceti descriere2:");
	private JLabel lDes3 = new JLabel("Introduceti descriere3:");
	
	private JTextField tId = new JTextField();
	private JTextField tSimp = new JTextField();
	private JTextField tDiag = new JTextField();
	private JTextField tRec = new JTextField();
	private JTextField tDes1 = new JTextField();
	private JTextField tDes2 = new JTextField();
	private JTextField tDes3 = new JTextField();
	
	private JButton btnInapoi = new JButton("Inapoi");
	private JButton btnRap = new JButton("Creati");
	private JButton btnRapIns = new JButton("Inserati");
	
	PoliclinicaView10(){
		
		//Labels:
		Modulul.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lId.setPreferredSize(new Dimension(200, 30));
		lId.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lSimp.setPreferredSize(new Dimension(200, 30));
		lSimp.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lDiag.setPreferredSize(new Dimension(200, 30));
		lDiag.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lRec.setPreferredSize(new Dimension(200, 30));
		lRec.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lDes1.setPreferredSize(new Dimension(200, 30));
		lDes1.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lDes2.setPreferredSize(new Dimension(200, 30));
		lDes2.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lDes3.setPreferredSize(new Dimension(200, 30));
		lDes3.setFont(new Font("Times New Roman", Font.BOLD, 15));
		
		//text fields:
		tId.setPreferredSize(new Dimension(200, 30));
		tSimp.setPreferredSize(new Dimension(200, 30));
		tDiag.setPreferredSize(new Dimension(200, 30));
		tRec.setPreferredSize(new Dimension(200, 30));
		tDes1.setPreferredSize(new Dimension(200, 30));
		tDes2.setPreferredSize(new Dimension(200, 30));
		tDes3.setPreferredSize(new Dimension(200, 30));
		
		ImageIcon img = new ImageIcon("C:\\Users\\Admin\\Desktop\\An2\\POO\\Workspace\\Proiect-BD\\report.PNG");
		JLabel limg = new JLabel(img);
		
		// Panels:
		JPanel p = new JPanel();
		p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));
		p.setPreferredSize(new Dimension(1000, 500));
		p.setBackground(Color.pink);

		JPanel p1 = new JPanel();
		p1.setLayout(new FlowLayout());
		p1.setBackground(Color.pink);
		p1.setPreferredSize(new Dimension(1000, 250));

		JPanel p2 = new JPanel();
		p2.setLayout(new FlowLayout());
		p2.setBackground(Color.pink);
		p2.setPreferredSize(new Dimension(1000, 250));
		
		p1.add(Modulul);
		p1.add(Box.createRigidArea(new Dimension(200, 0)));
		p1.add(limg);
		p1.add(Box.createRigidArea(new Dimension(200, 0)));
		p1.add(btnInapoi);
		
		p2.add(lId);
		p2.add(Box.createRigidArea(new Dimension(10, 0)));
		p2.add(tId);
		
		p2.add(lSimp);
		p2.add(Box.createRigidArea(new Dimension(10, 0)));
		p2.add(tSimp);
		
		p2.add(lDiag);
		p2.add(Box.createRigidArea(new Dimension(10, 0)));
		p2.add(tDiag);
		
		p2.add(lRec);
		p2.add(Box.createRigidArea(new Dimension(10, 0)));
		p2.add(tRec);
		
		p2.add(lDes1);
		p2.add(Box.createRigidArea(new Dimension(10, 0)));
		p2.add(tDes1);
		
		p2.add(lDes2);
		p2.add(Box.createRigidArea(new Dimension(10, 0)));
		p2.add(tDes2);
		
		p2.add(lDes3);
		p2.add(Box.createRigidArea(new Dimension(10, 0)));
		p2.add(tDes3);
		p2.add(Box.createRigidArea(new Dimension(270, 0)));
		
		p2.add(btnRap);
		p2.add(btnRapIns);

		p.add(p1);
		p1.setAlignmentX(CENTER_ALIGNMENT);
		p.add(p2);
		p2.setAlignmentX(CENTER_ALIGNMENT);

		this.setContentPane(p);
		this.pack(); //pune toate componentele la dimesiunile dorite
		this.setTitle("Activitati Operationale");
		this.setPreferredSize(new Dimension(1000, 500));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	void addInapoiListener10(ActionListener e) {
		this.btnInapoi.addActionListener(e);
	}
	
	void addAdaugaRap(ActionListener e) {
		this.btnRap.addActionListener(e);
	}
	
	void addAdaugaRapIns(ActionListener e) {
		this.btnRapIns.addActionListener(e);
	}
	
	JTextField txt1() {
		return tId;
	}
	
	JTextField txt2() {
		return tSimp;
	}
	
	JTextField txt3() {
		return tDiag;
	}
	
	JTextField txt4() {
		return tRec;
	}
	
	JTextField txt5() {
		return tDes1;
	}
	
	JTextField txt6() {
		return tDes2;
	}
	
	JTextField txt7() {
		return tDes3;
	}	
}

class PoliclinicaView11 extends JFrame{
	
	private JLabel Modulul = new JLabel("ACTIVITATI OPERATIONALE");
	private JLabel lO = new JLabel("Vizualizati programari:");
	private JComboBox prg = new JComboBox();
	private JButton btnInapoi = new JButton("Inapoi");
	
	PoliclinicaView11(){
		
		//Labels:
		Modulul.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lO.setPreferredSize(new Dimension(200, 30));
		lO.setFont(new Font("Times New Roman", Font.BOLD, 15));
		
		// Panels:
		JPanel p = new JPanel();
		p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));
		p.setPreferredSize(new Dimension(700, 500));
		p.setBackground(Color.pink);

		JPanel p1 = new JPanel();
		p1.setLayout(new FlowLayout());
		p1.setBackground(Color.pink);

		ImageIcon img = new ImageIcon("C:\\Users\\Admin\\Desktop\\An2\\POO\\Workspace\\Proiect-BD\\imgDoctor.PNG");
		ImageIcon img1 = new ImageIcon("C:\\Users\\Admin\\Desktop\\An2\\POO\\Workspace\\Proiect-BD\\cal1.PNG");
		JLabel limg = new JLabel(img);
		JLabel limg1 = new JLabel(img1);

		JPanel p2 = new JPanel();
		p2.setLayout(new FlowLayout());
		p2.setBackground(Color.pink);
		
		p1.add(Modulul);
		p1.add(Box.createRigidArea(new Dimension(50, 0)));
		p1.add(limg);
		p1.add(Box.createRigidArea(new Dimension(50, 0)));
		p1.add(btnInapoi);
			
		p2.add(limg1);
		p2.add(lO);
		p2.add(Box.createRigidArea(new Dimension(25, 0)));
		p2.add(prg);
		
		p.add(p1);
		p1.setAlignmentX(CENTER_ALIGNMENT);
		p.add(p2);
		p2.setAlignmentX(CENTER_ALIGNMENT);

		this.setContentPane(p);
		this.pack(); //pune toate componentele la dimesiunile dorite
		this.setTitle("Resurse Umane");
		this.setPreferredSize(new Dimension(700, 400));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	void setLabel(String s) {
		lO.setText(s);
	}
	
	void setModul(String s) {
		Modulul.setText(s);
	}
	
	void addInapoiListener11(ActionListener e) {
		this.btnInapoi.addActionListener(e);
	}
	
	public JComboBox getPrg() {
		return prg;
	}
}

class PoliclinicaView12 extends JFrame{
	//Cnp, nume, prenume, adresa, numar_tel, email, IBAN, nr_contract, data_ang, functie
	//+salariu neg, nr ore, departament.

	
	private JLabel Modulul = new JLabel("ADMINISTRATOR");
	private JLabel lCNP = new JLabel("Introduceti CNP:");
	private JLabel lN = new JLabel("Introduceti nume:");
	private JLabel lP = new JLabel("Introduceti prenume:");
	private JLabel lAdr = new JLabel("Introduceti adresa:");
	private JLabel lNr = new JLabel("Introduceti numar telefon:");
	private JLabel lE = new JLabel("Introduceti Email:");
	private JLabel lI = new JLabel("Introduceti Iban:");
	private JLabel lC = new JLabel("Introduceti numar contract:");
	private JLabel lDAng = new JLabel("Introduceti data angajarii:");
	private JLabel lFctie = new JLabel("Introduceti functie:");
	private JLabel lSal = new JLabel("Introduceti salariu:");
	private JLabel lNrOre = new JLabel("Introduceti nr ore:");
	private JLabel lDep = new JLabel("Introduceti departament:");
	
	private JTextField tCNP = new JTextField();
	private JTextField tN = new JTextField();
	private JTextField tP = new JTextField();
	private JTextField tAdr = new JTextField();
	private JTextField tNr = new JTextField();
	private JTextField tE = new JTextField();
	private JTextField tI = new JTextField();
	private JTextField tC = new JTextField();
	private JTextField tDAng = new JTextField();
	private JTextField tFctie = new JTextField();
	private JTextField tSal = new JTextField();
	private JTextField tNrOre = new JTextField();
	private JTextField tDep = new JTextField();
	
	private JButton btnInapoi = new JButton("Inapoi");
	private JButton btnCont = new JButton("Creati cont");
	
	PoliclinicaView12(){
		
		//Labels:
		Modulul.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lCNP.setPreferredSize(new Dimension(200, 30));
		lCNP.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lN.setPreferredSize(new Dimension(200, 30));
		lN.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lP.setPreferredSize(new Dimension(200, 30));
		lP.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lAdr.setPreferredSize(new Dimension(200, 30));
		lAdr.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lNr.setPreferredSize(new Dimension(200, 30));
		lNr.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lE.setPreferredSize(new Dimension(200, 30));
		lE.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lI.setPreferredSize(new Dimension(200, 30));
		lI.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lC.setPreferredSize(new Dimension(200, 30));
		lC.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lDAng.setPreferredSize(new Dimension(200, 30));
		lDAng.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lFctie.setPreferredSize(new Dimension(200, 30));
		lFctie.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lSal.setPreferredSize(new Dimension(200, 30));
		lSal.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lNrOre.setPreferredSize(new Dimension(200, 30));
		lNrOre.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lDep.setPreferredSize(new Dimension(200, 30));
		lDep.setFont(new Font("Times New Roman", Font.BOLD, 15));
		
		//TextFields:
		tCNP.setPreferredSize(new Dimension(200, 30));
		tN.setPreferredSize(new Dimension(200, 30));
		tP.setPreferredSize(new Dimension(200, 30));
		tAdr.setPreferredSize(new Dimension(200, 30));
		tNr.setPreferredSize(new Dimension(200, 30));
		tE.setPreferredSize(new Dimension(200, 30));
		tI.setPreferredSize(new Dimension(200, 30));
		tC.setPreferredSize(new Dimension(200, 30));
		tDAng.setPreferredSize(new Dimension(200, 30));
		tFctie.setPreferredSize(new Dimension(200, 30));
		tSal.setPreferredSize(new Dimension(200, 30));
		tNrOre.setPreferredSize(new Dimension(200, 30));
		tDep.setPreferredSize(new Dimension(200, 30));
		
		// Panels:
		JPanel p = new JPanel();
		p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));
		p.setPreferredSize(new Dimension(1000, 500));
		p.setBackground(Color.pink);

		JPanel p1 = new JPanel();
		p1.setLayout(new FlowLayout());
		p1.setBackground(Color.pink);
		p1.setPreferredSize(new Dimension(1000, 200));
		
		ImageIcon img = new ImageIcon("C:\\Users\\Admin\\Desktop\\An2\\POO\\Workspace\\Proiect-BD\\admin.PNG");
		JLabel limg = new JLabel(img);

		JPanel p2 = new JPanel();
		p2.setLayout(new FlowLayout());
		p2.setBackground(Color.pink);
		p2.setPreferredSize(new Dimension(700, 300));
		
		p1.add(Modulul);
		p1.add(Box.createRigidArea(new Dimension(250, 0)));
		p1.add(limg);
		p1.add(Box.createRigidArea(new Dimension(250, 0)));
		p1.add(btnInapoi);
			
		p2.add(lCNP);
		p2.add(Box.createRigidArea(new Dimension(25, 0)));
		p2.add(tCNP);
		
		p2.add(lN);
		p2.add(Box.createRigidArea(new Dimension(25, 0)));
		p2.add(tN);
		
		p2.add(lP);
		p2.add(Box.createRigidArea(new Dimension(25, 0)));
		p2.add(tP);
		
		
		p2.add(lAdr);
		p2.add(Box.createRigidArea(new Dimension(25, 0)));
		p2.add(tAdr);
		
		
		p2.add(lNr);
		p2.add(Box.createRigidArea(new Dimension(25, 0)));
		p2.add(tNr);
		
		
		p2.add(lE);
		p2.add(Box.createRigidArea(new Dimension(25, 0)));
		p2.add(tE);
		
		
		p2.add(lI);
		p2.add(Box.createRigidArea(new Dimension(25, 0)));
		p2.add(tI);
		
		
		p2.add(lC);
		p2.add(Box.createRigidArea(new Dimension(25, 0)));
		p2.add(tC);
		
		p2.add(lDAng);
		p2.add(Box.createRigidArea(new Dimension(25, 0)));
		p2.add(tDAng);
		
		p2.add(lFctie);
		p2.add(Box.createRigidArea(new Dimension(25, 0)));
		p2.add(tFctie);
		
		p2.add(lSal);
		p2.add(Box.createRigidArea(new Dimension(25, 0)));
		p2.add(tSal);
		
		p2.add(lNrOre);
		p2.add(Box.createRigidArea(new Dimension(25, 0)));
		p2.add(tNrOre);
		
		p2.add(lDep);
		p2.add(Box.createRigidArea(new Dimension(25, 0)));
		p2.add(tDep);
		
		p2.add(Box.createRigidArea(new Dimension(335, 0)));
		p2.add(btnCont);
		
		
		p.add(p1);
		p1.setAlignmentX(CENTER_ALIGNMENT);
		p.add(p2);
		p2.setAlignmentX(CENTER_ALIGNMENT);

		this.setContentPane(p);
		this.pack(); //pune toate componentele la dimesiunile dorite
		this.setTitle("Administrator");
		this.setPreferredSize(new Dimension(700, 400));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	JTextField txt1() {
		return tCNP;
	}
	
	JTextField txt2() {
		return tN;
	}
	
	JTextField txt3() {
		return tP;
	}
	
	JTextField txt4() {
		return tAdr;
	}
	
	
	JTextField txt5() {
		return tNr;
	}
	
	
	JTextField txt6() {
		return tE;
	}
	
	
	JTextField txt7() {
		return tI;
	}
	
	
	JTextField txt8() {
		return tC;
	}
	
	
	JTextField txt9() {
		return tDAng;
	}
	
	
	JTextField txt10() {
		return tFctie;
	}
	
	
	JTextField txt11() {
		return tSal;
	}
	
	
	JTextField txt12() {
		return tNrOre;
	}
	
	
	JTextField txt13() {
		return tDep;
	}
	
	void addInapoiListener12(ActionListener e) {
		this.btnInapoi.addActionListener(e);
	}
	
	void addCreatiContListener(ActionListener e) {
		this.btnCont.addActionListener(e);
	}
	
}

class PoliclinicaView13 extends JFrame{
	//Cnp, nume, prenume, adresa, numar_tel, email, IBAN, nr_contract, data_ang, functie
	
	private JLabel Modulul = new JLabel("SUPER ADMINISTRATOR");
	private JLabel lCNP = new JLabel("Introduceti CNP:");
	private JLabel lN = new JLabel("Introduceti nume:");
	private JLabel lP = new JLabel("Introduceti prenume:");
	private JLabel lAdr = new JLabel("Introduceti adresa:");
	private JLabel lNr = new JLabel("Introduceti numar telefon:");
	private JLabel lE = new JLabel("Introduceti Email:");
	private JLabel lI = new JLabel("Introduceti Iban:");
	private JLabel lC = new JLabel("Introduceti numar contract:");
	private JLabel lDAng = new JLabel("Introduceti data angajarii:");
	private JLabel lFctie = new JLabel("Introduceti functie:");
	
	private JTextField tCNP = new JTextField();
	private JTextField tN = new JTextField();
	private JTextField tP = new JTextField();
	private JTextField tAdr = new JTextField();
	private JTextField tNr = new JTextField();
	private JTextField tE = new JTextField();
	private JTextField tI = new JTextField();
	private JTextField tC = new JTextField();
	private JTextField tDAng = new JTextField();
	private JTextField tFctie = new JTextField();
	
	private JButton btnInapoi = new JButton("Inapoi");
	private JButton btnCont = new JButton("Creati cont");
	
	PoliclinicaView13(){
		
		//Labels:
		Modulul.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lCNP.setPreferredSize(new Dimension(200, 30));
		lCNP.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lN.setPreferredSize(new Dimension(200, 30));
		lN.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lP.setPreferredSize(new Dimension(200, 30));
		lP.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lAdr.setPreferredSize(new Dimension(200, 30));
		lAdr.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lNr.setPreferredSize(new Dimension(200, 30));
		lNr.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lE.setPreferredSize(new Dimension(200, 30));
		lE.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lI.setPreferredSize(new Dimension(200, 30));
		lI.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lC.setPreferredSize(new Dimension(200, 30));
		lC.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lDAng.setPreferredSize(new Dimension(200, 30));
		lDAng.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lFctie.setPreferredSize(new Dimension(200, 30));
		lFctie.setFont(new Font("Times New Roman", Font.BOLD, 15));
		
		//TextFields:
		tCNP.setPreferredSize(new Dimension(200, 30));
		tN.setPreferredSize(new Dimension(200, 30));
		tP.setPreferredSize(new Dimension(200, 30));
		tAdr.setPreferredSize(new Dimension(200, 30));
		tNr.setPreferredSize(new Dimension(200, 30));
		tE.setPreferredSize(new Dimension(200, 30));
		tI.setPreferredSize(new Dimension(200, 30));
		tC.setPreferredSize(new Dimension(200, 30));
		tDAng.setPreferredSize(new Dimension(200, 30));
		tFctie.setPreferredSize(new Dimension(200, 30));
		
		// Panels:
		JPanel p = new JPanel();
		p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));
		p.setPreferredSize(new Dimension(1000, 500));
		p.setBackground(Color.pink);

		JPanel p1 = new JPanel();
		p1.setLayout(new FlowLayout());
		p1.setBackground(Color.pink);
		p1.setPreferredSize(new Dimension(1000, 200));
		
		ImageIcon img = new ImageIcon("C:\\Users\\Admin\\Desktop\\An2\\POO\\Workspace\\Proiect-BD\\rsz_sa.PNG");
		JLabel limg = new JLabel(img);

		JPanel p2 = new JPanel();
		p2.setLayout(new FlowLayout());
		p2.setBackground(Color.pink);
		p2.setPreferredSize(new Dimension(700, 300));
		
		p1.add(Modulul);
		p1.add(Box.createRigidArea(new Dimension(250, 0)));
		p1.add(limg);
		p1.add(Box.createRigidArea(new Dimension(250, 0)));
		p1.add(btnInapoi);
			
		p2.add(lCNP);
		p2.add(Box.createRigidArea(new Dimension(25, 0)));
		p2.add(tCNP);
		
		p2.add(lN);
		p2.add(Box.createRigidArea(new Dimension(25, 0)));
		p2.add(tN);
		
		p2.add(lP);
		p2.add(Box.createRigidArea(new Dimension(25, 0)));
		p2.add(tP);
		
		
		p2.add(lAdr);
		p2.add(Box.createRigidArea(new Dimension(25, 0)));
		p2.add(tAdr);
		
		
		p2.add(lNr);
		p2.add(Box.createRigidArea(new Dimension(25, 0)));
		p2.add(tNr);
		
		
		p2.add(lE);
		p2.add(Box.createRigidArea(new Dimension(25, 0)));
		p2.add(tE);
		
		
		p2.add(lI);
		p2.add(Box.createRigidArea(new Dimension(25, 0)));
		p2.add(tI);
		
		
		p2.add(lC);
		p2.add(Box.createRigidArea(new Dimension(25, 0)));
		p2.add(tC);
		
		p2.add(lDAng);
		p2.add(Box.createRigidArea(new Dimension(25, 0)));
		p2.add(tDAng);
		
		p2.add(lFctie);
		p2.add(Box.createRigidArea(new Dimension(25, 0)));
		p2.add(tFctie);
		
		p2.add(Box.createRigidArea(new Dimension(700, 100)));
		btnCont.setAlignmentX(LEFT_ALIGNMENT);
		p2.add(btnCont);
		
		
		p.add(p1);
		p1.setAlignmentX(CENTER_ALIGNMENT);
		p.add(p2);
		p2.setAlignmentX(CENTER_ALIGNMENT);

		this.setContentPane(p);
		this.pack(); //pune toate componentele la dimesiunile dorite
		this.setTitle("Super Administrator");
		this.setPreferredSize(new Dimension(700, 400));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	JTextField txt1() {
		return tCNP;
	}
	
	JTextField txt2() {
		return tN;
	}
	
	JTextField txt3() {
		return tP;
	}
	
	JTextField txt4() {
		return tAdr;
	}
	
	
	JTextField txt5() {
		return tNr;
	}
	
	
	JTextField txt6() {
		return tE;
	}
	
	
	JTextField txt7() {
		return tI;
	}
	
	
	JTextField txt8() {
		return tC;
	}
	
	
	JTextField txt9() {
		return tDAng;
	}
	
	
	JTextField txt10() {
		return tFctie;
	}
	
	void addInapoiListener13(ActionListener e) {
		this.btnInapoi.addActionListener(e);
	}
	
	void addCreatiContListener(ActionListener e) {
		this.btnCont.addActionListener(e);
	}
	
}
