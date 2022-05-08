import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;

//aici utilizam action listenerii:
public class PoliclinicaController {
	private String f;
	private String fAng;
	//medic, asistent medical, inspector, receptioner, expert contabil.
	private PoliclinicaModel m;
	private PoliclinicaView v;
	private PoliclinicaView2 v2;
	private PoliclinicaView3 v3;
	private PoliclinicaView4 v4;
	private PoliclinicaView5 v5;
	private PoliclinicaView6 v6;
	private PoliclinicaView7 v7;
	private PoliclinicaView8 v8;
	private PoliclinicaView9 v9;
	private PoliclinicaView10 v10;
	private PoliclinicaView11 v11;
	private PoliclinicaView12 v12;
	private PoliclinicaView13 v13;
	
	PoliclinicaController(PoliclinicaModel m, PoliclinicaView v, PoliclinicaView2 v2, PoliclinicaView3 v3, PoliclinicaView4 v4, PoliclinicaView5 v5, PoliclinicaView6 v6, PoliclinicaView7 v7, PoliclinicaView8 v8, PoliclinicaView9 v9, PoliclinicaView10 v10, PoliclinicaView11 v11, PoliclinicaView12 v12, PoliclinicaView13 v13) {
		this.m = m;
		this.v = v;
		this.v2 = v2;
		this.v3 = v3;
		this.v4 = v4;
		this.v5 = v5;
		this.v6 = v6;
		this.v7 = v7;
		this.v8 = v8;
		this.v9 = v9;
		this.v10 = v10;
		this.v11 = v11;
		this.v12 = v12;
		this.v13 = v13;
		v.addLoginListener(new LoginListener());
		v.addAdminListener(new AdminListener());
		v.addSAdminListener(new SAdminListener());
		v2.addDisconnectListener(new DisconnectListener());
		v2.addBtn1Listener(new Btn1Listener());
		v2.addBtn2Listener(new Btn2Listener());
		v2.addBtn3Listener(new Btn3Listener());
		v3.addInapoiListener3(new InapoiListener3());
		v3.addAdaugaConcediuListener(new AdaugaConcediuListener());
		v3.addVizOrarListener(new VizOrarListener());
		v3.addVizOrarConcListener(new AdaugaOrarConcListener());
		v4.addInapoiListener4(new InapoiListener4());
		v4.addBtnConcediuListener(new BtnConcediuListener());
		v4.addBtnZiLiberaListener(new AdaugaZiLiberaListener());
		v5.addInapoiListener5(new InapoiListener5());
		v5.addVenitAngListener(new VenitAngListener());
		v5.addBtnPolListener(new BtnPolListener());
		v5.addBtnPolicliniciListener(new BtnPolicliniciListener());
		v6.addInapoiListener6(new InapoiListener6());
		v6.addBtnPrg(new BtnPrgListener());
		v6.addBtnBon(new BtnBonListener());
		v6.addBtnRap(new BtnRapListener());
		v6.addBtnPar(new BtnParListener());
		v6.addBtnMed(new BtnMedListener());
		v6.addBtnPac(new BtnPacListener());
		v3.addDatePersonaleListener(new DatePersonaleListener());
		v7.addInapoiListener7(new InapoiListener7());
		v8.addInapoiListener8(new InapoiListener8());
		v9.addInapoiListener9(new InapoiListener9());
		v9.addAdaugaPrg(new AdaugaPrg());
		v10.addInapoiListener10(new InapoiListener10());
		v10.addAdaugaRap(new RapListener());
		v10.addAdaugaRapIns(new RapInsListener());
		v11.addInapoiListener11(new InapoiListener11());
		v12.addInapoiListener12(new InapoiListener12());
		v12.addCreatiContListener(new CreatiContListener());
		v13.addInapoiListener13(new InapoiListener13());
		v13.addCreatiContListener(new ContAdminListener());
	}

	class AdminListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			String n = v.getUser().getText();
			String CNP = v.getPass().getText();
			
			f = m.cautareFctieUtiliz(n, CNP);
			
			if(n.equals("") == true || CNP.equals("") == true) {
				JOptionPane.showMessageDialog(v6, "Introduceti parametri!","Error",JOptionPane.INFORMATION_MESSAGE);
			}
			else if(f == null){
				JOptionPane.showMessageDialog(v6, "Nu exista contul!","Error",JOptionPane.INFORMATION_MESSAGE);
			}
			else if(f.equals("angajat") == true || f.equals("super administrator") == true) {
				JOptionPane.showMessageDialog(v6, "Nu se poate accesa cu acest cont!","Error",JOptionPane.INFORMATION_MESSAGE);
			}
			else {
				v12.setVisible(true);
				v.setVisible(false);
			}			
		}
	}
	
	class SAdminListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			String n = v.getUser().getText();
			String CNP = v.getPass().getText();
			
			f = m.cautareFctieUtiliz(n, CNP);
			
			if(n.equals("") == true || CNP.equals("") == true) {
				JOptionPane.showMessageDialog(v6, "Introduceti parametri!","Error",JOptionPane.INFORMATION_MESSAGE);
			}
			else if(f == null){
				JOptionPane.showMessageDialog(v6, "Nu exista contul!","Error",JOptionPane.INFORMATION_MESSAGE);
			}
			else if(f.equals("administrator") == true || f.equals("angajat") == true) {
				JOptionPane.showMessageDialog(v6, "Nu se poate accesa cu acest cont!","Error",JOptionPane.INFORMATION_MESSAGE);
			}
			else {
				v13.setVisible(true);
				v.setVisible(false);
			}				
		}
	}
	
	class LoginListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			String n = v.getUser().getText();
			String CNP = v.getPass().getText();
			
			f = m.cautareFctieUtiliz(n, CNP);
			
			if(n.equals("") == true || CNP.equals("") == true) {
				JOptionPane.showMessageDialog(v6, "Introduceti parametri!","Error",JOptionPane.INFORMATION_MESSAGE);
			}
			else if(f == null){
				JOptionPane.showMessageDialog(v6, "Nu exista contul!","Error",JOptionPane.INFORMATION_MESSAGE);
			}
			else if(f.equals("administrator") == true || f.equals("super administrator") == true) {
				JOptionPane.showMessageDialog(v6, "Nu se poate accesa cu acest cont!","Error",JOptionPane.INFORMATION_MESSAGE);
			}
			else {
				v2.getNumePrenume().setText(v.getUser().getText());
				fAng = m.getFctieAng(n, CNP);
				v2.getFctie().setText(fAng.toUpperCase());
				v2.setVisible(true);
				v.setVisible(false);
			}		
		}
	}
	
	class DisconnectListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			v.getUser().setText("");
			v.getPass().setText("");
			v2.setVisible(false);
			v.setVisible(true);		
		}
	}
	
	class Btn1Listener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			v2.setVisible(false);
			v3.setVisible(true);		
		}
	}
	
	class Btn2Listener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			v2.setVisible(false);
			v5.setVisible(true);		
		}
	}
	
	class Btn3Listener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			if(fAng.equals("inspector") == true || fAng.equals("expert contabil") == true) {
				JOptionPane.showMessageDialog(v6, "Nu poti accesa acest modul!","Error",JOptionPane.INFORMATION_MESSAGE);
			}
			else {
				v2.setVisible(false);
				v6.setVisible(true);	
			}	
		}
	}
	
	class InapoiListener3 implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			v3.getNume().setText("");
			v3.getPNume().setText("");
			v3.getFctie().setText("");
			v3.getNume().setText("");
			v3.setVisible(false);
			v2.setVisible(true);		
		}
	}
	
	class InapoiListener4 implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			v3.getNume().setText("");
			v3.getPNume().setText("");
			v3.getFctie().setText("");
			v4.getOraInceput().setSelectedItem(v4.getOraInceput().getItemAt(0));
			v4.getOraSfarsit().setSelectedItem(v4.getOraSfarsit().getItemAt(0));
			v4.getZiInceput().setText("data de inceput");
			v4.getZiSfarsit().setText("data de sfarsit");
			v4.setVisible(false);
			v3.setVisible(true);		
		}
	}
	
	class InapoiListener5 implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			v5.getNumeAng().setText("");
			v5.getPrenumeAng().setText("");
			v5.getNumePol().setText("");
			v5.getLuna().setSelectedItem(v5.getLuna().getItemAt(0));
			v5.setVisible(false);
			v2.setVisible(true);		
		}
	}
	
	class InapoiListener6 implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			v6.getidPrgBon().setText("Id Programare");
			v6.setVisible(false);
			v2.setVisible(true);
		}
	}
	
	class InapoiListener7 implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			v7.setVisible(false);
			//reset pentru parametri scrisi in text field-uri:
			v3.getNume().setText("");
			v3.getPNume().setText("");
			v3.getFctie().setText("");
			v3.setVisible(true);
		}
	}
	
	class InapoiListener8 implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			v8.setVisible(false);
			v8.getOrar().removeAllItems();
			v3.getNume().setText("");
			v3.getPNume().setText("");
			v3.getFctie().setText("");
			v3.setVisible(true);
		}
	}
	
	class InapoiListener9 implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			v9.setVisible(false);
			v9.txt1().setText("");
			v9.txt2().setText("");
			v9.txt3().setText("");
			v9.txt4().setText("");
			v9.txt5().setText("");
			v9.txt6().setText("");
			v9.txt7().setText("");
			v9.txt8().setText("");
			v9.txt9().setText("");
			v9.txt10().setText("");
			v9.txt11().setText("");
			v9.txt12().setText("");
			v6.getidPrgPar().setText("Id Programare");
			v6.getidPrgBon().setText("Id Programare");
			v6.setVisible(true);
		}
	}
	
	class InapoiListener10 implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			v10.txt1().setText("");
			v10.txt2().setText("");
			v10.txt3().setText("");
			v10.txt4().setText("");
			v10.txt5().setText("");
			v10.txt6().setText("");
			v10.txt7().setText("");
			v6.getidPrgPar().setText("Id Programare");
			v6.getidPrgBon().setText("Id Programare");
			v10.setVisible(false);
			v6.setVisible(true);
		}
	}
	
	class InapoiListener11 implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			v10.txt1().setText("");
			v10.txt2().setText("");
			v10.txt3().setText("");
			v10.txt4().setText("");
			v10.txt5().setText("");
			v10.txt6().setText("");
			v10.txt7().setText("");
			v6.getZi().setSelectedItem(v6.getZi().getItemAt(0));
			v6.getLuna().setSelectedItem(v6.getLuna().getItemAt(0));
			v6.getidPrgBon().setText("Id Programare");
			v6.getidMed().setText("");
			v11.setVisible(false);
			v6.setVisible(true);
		}
	}
	
	class InapoiListener12 implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			v.getUser().setText("");
			v.getPass().setText("");
			v12.setVisible(false);
			v.setVisible(true);
		}
	}
	
	class InapoiListener13 implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			v.getUser().setText("");
			v.getPass().setText("");
			v13.setVisible(false);
			v.setVisible(true);
		}
	}
	
	class BtnPrgListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			if(fAng.equals("asistent medical") == true || fAng.equals("medic") == true) {
				JOptionPane.showMessageDialog(v6, "Nu poti accesa submodulul!","Error",JOptionPane.INFORMATION_MESSAGE);
			}
			else {
				v6.setVisible(false);
				v9.setVisible(true);
			}
		}
	}
	
	class BtnRapListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			if(fAng.equals("receptioner") == true) {
				JOptionPane.showMessageDialog(v6, "Nu poti accesa submodulul!","Error",JOptionPane.INFORMATION_MESSAGE);
			}
			else {
				v6.setVisible(false);
				v10.setVisible(true);
			}		
		}
	}
	
	class BtnParListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			if(fAng.equals("receptioner") == true || fAng.equals("asistent medical") == true) {
				JOptionPane.showMessageDialog(v6, "Nu poti accesa submodulul!","Error",JOptionPane.INFORMATION_MESSAGE);
			}
			else {
				String idPrg = v6.getidPrgPar().getText();
				boolean rs = m.punereParafa(idPrg);
				if (idPrg.equals("") == true || idPrg.equals("Id Programare") == true) {
					JOptionPane.showMessageDialog(v6, "Introduceti id-ul!", "Error", JOptionPane.INFORMATION_MESSAGE);
				} else if (rs == false) {
					JOptionPane.showMessageDialog(v6, "Parametru gresit!", "Error", JOptionPane.INFORMATION_MESSAGE);
				} else {
					v6.getidPrgPar().setText("Id Programare");
					JOptionPane.showMessageDialog(v6, "Parafa inserata cu succes!", "Message",
							JOptionPane.INFORMATION_MESSAGE);
				}
			}
		}
	}
	
	class BtnBonListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			if(fAng.equals("asistent medical") == true || fAng.equals("medic") == true) {
				JOptionPane.showMessageDialog(v6, "Nu poti accesa submodulul!","Error",JOptionPane.INFORMATION_MESSAGE);
			}
			else {
				String idPrg = v6.getidPrgBon().getText();
				boolean rs = m.generareBonPrg(idPrg);
				if (idPrg.equals("") == true || idPrg.equals("Id Programare") == true) {
					JOptionPane.showMessageDialog(v6, "Introduceti id-ul!", "Error", JOptionPane.INFORMATION_MESSAGE);
				} else if (rs == false) {
					JOptionPane.showMessageDialog(v6, "Parametru gresit!", "Error", JOptionPane.INFORMATION_MESSAGE);
				} else {
					String result = m.selectBon(idPrg);
					v6.getidPrgBon().setText("Id Programare");
					JOptionPane.showMessageDialog(v6, result, "Message", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		}
	}
	
	class RapListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			String idPrg = v10.txt1().getText();
			String Simp = v10.txt2().getText();
			String Diag = v10.txt3().getText();
			String Rec = v10.txt4().getText();
			String Des1 = v10.txt5().getText();
			String Des2 = v10.txt6().getText();
			String Des3 = v10.txt7().getText();
			
			boolean rs = m.generareRapPrg(idPrg, Simp, Diag, Rec, Des1, Des2, Des3);
			if(idPrg.equals("") == true || Simp.equals("") == true|| Diag.equals("") == true || Rec.equals("") == true && (Des1.equals("") == true || Des2.equals("") == true || Des3.equals("") == true)) {
				JOptionPane.showMessageDialog(v10, "Introduceti parametri!","Error",JOptionPane.INFORMATION_MESSAGE);
			}
			else if(rs == false) {
				JOptionPane.showMessageDialog(v10, m.campErr,"Error",JOptionPane.INFORMATION_MESSAGE);
				v10.txt1().setText("");
				v10.txt2().setText("");
				v10.txt3().setText("");
				v10.txt4().setText("");
				v10.txt5().setText("");
				v10.txt6().setText("");
				v10.txt7().setText("");
			}
			else {
				JOptionPane.showMessageDialog(v10, "Inserat cu succes!","Message",JOptionPane.INFORMATION_MESSAGE);
				v10.txt1().setText("");
				v10.txt2().setText("");
				v10.txt3().setText("");
				v10.txt4().setText("");
				v10.txt5().setText("");
				v10.txt6().setText("");
				v10.txt7().setText("");
			}
		}
	}
	
	class RapInsListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			String idPrg = v10.txt1().getText();
			String Simp = v10.txt2().getText();
			String Diag = v10.txt3().getText();
			String Rec = v10.txt4().getText();
			
			boolean rs = m.inserareRapPrg(idPrg, Simp, Diag, Rec);
			if(idPrg.equals("") == true || Simp.equals("") == true|| Diag.equals("") == true || Rec.equals("") == true) {
				JOptionPane.showMessageDialog(v10, "Introduceti parametri!","Error",JOptionPane.INFORMATION_MESSAGE);
			}
			else if(rs == false) {
				JOptionPane.showMessageDialog(v10, m.campErr,"Error",JOptionPane.INFORMATION_MESSAGE);
				v10.txt1().setText("");
				v10.txt2().setText("");
				v10.txt3().setText("");
				v10.txt4().setText("");
				v10.txt5().setText("");
				v10.txt6().setText("");
				v10.txt7().setText("");
			}
			else {
				JOptionPane.showMessageDialog(v10, "Inserat cu succes!","Message",JOptionPane.INFORMATION_MESSAGE);
				v10.txt1().setText("");
				v10.txt2().setText("");
				v10.txt3().setText("");
				v10.txt4().setText("");
				v10.txt5().setText("");
				v10.txt6().setText("");
				v10.txt7().setText("");
			}
		}
	}
	
	class BtnMedListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			String idMed = v6.getidMed().getText();
			String Zi = v6.getZi().getSelectedItem().toString();
			String Luna = v6.getLuna().getSelectedItem().toString();
			int ok = 1;
			
			String[] rs = new String[100];
			rs = m.getPrgMed(idMed, Zi, Luna);
			
			if(idMed.equals("") == false && Zi.equals("zi") == false && Luna.equals("luna") == false ) {
				if(rs[0].equals("Sfarsit")) {
					ok = 0;
				}
				
				if(ok == 0) {
					JOptionPane.showMessageDialog(v11, "Medicul nu are nicio programare pentru ziua inserata. Introduceti alta zi!","Error",JOptionPane.INFORMATION_MESSAGE);
				}
				else {
					v11.getPrg().removeAllItems();
					v11.getPrg().addItem(new String("Fa scroll pentru a vedea programarile"));

					int i = 0;
					while (!rs[i].equals("Sfarsit")) {
						v11.getPrg().addItem(rs[i]);
						i++;
					}
					v6.setVisible(false);
					v11.setVisible(true);
				}
			}
			else {
				JOptionPane.showMessageDialog(v11, "Introduceti parametri!","Error",JOptionPane.INFORMATION_MESSAGE);
			}
		}
	}
	
	class BtnPacListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			String idPac = v6.getidPac().getText();
			int ok = 1;
			
			String[] rs = new String[100];
			rs = m.getPrgPac(idPac);
			
			if(idPac.equals("") == false) {
				
				if(rs[0].equals("Sfarsit")) {
					ok = 0;
				}
				
				if(ok == 0) {
					JOptionPane.showMessageDialog(v11, "Pacientul nu are nicio programare!","Error",JOptionPane.INFORMATION_MESSAGE);
				}
				else {
					v11.getPrg().removeAllItems();
					//imi adauga in plus prima chestie cand dau back:
					v11.getPrg().addItem(new String("Fa scroll pentru a vedea programarile"));

					int i = 0;
					while (!rs[i].equals("Sfarsit")) {
						v11.getPrg().addItem(rs[i]);
						i++;
					}
					v6.setVisible(false);
					v11.setVisible(true);
				}
			}
			else {
				JOptionPane.showMessageDialog(v11, "Introduceti parametri!","Error",JOptionPane.INFORMATION_MESSAGE);
			}
		}
	}
	
	class AdaugaConcediuListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			if(fAng.equals("medic") == true || fAng.equals("asistent medical") == true || fAng.equals("receptioner") == true || fAng.equals("expert contabil") == true) {
				JOptionPane.showMessageDialog(v3, "Nu puteti accesa submodulul!","Error",JOptionPane.INFORMATION_MESSAGE);
			}
			else {
				String numeInput = v3.getNume().getText();
				String prenumeInput = v3.getPNume().getText();
				String fctieInput = v3.getFctie().getText();

				if (numeInput.equals("") == true || prenumeInput.equals("") == true || fctieInput.equals("") == true) {
					JOptionPane.showMessageDialog(v3, "Introduceti parametri!", "Error",
							JOptionPane.INFORMATION_MESSAGE);
				} else if (m.getIdAng(numeInput, prenumeInput, fctieInput) == null) {
					JOptionPane.showMessageDialog(v3, "Nu exista angajatul! Introduceti alti parametri", "Error",
							JOptionPane.INFORMATION_MESSAGE);
				} else {
					v3.setVisible(false);
					v4.setVisible(true);
				}
			}
		}
	}
	
	class VizOrarListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			
			String numeInput = v3.getNume().getText();
			String prenumeInput = v3.getPNume().getText();
			String fctieInput = v3.getFctie().getText();
			
			String[] rs = null;
			int ok = 1;
			
			if(fAng.equals("medic") == true || fAng.equals("asistent medical") == true || fAng.equals("receptioner") == true) {
				if (fAng.toLowerCase().equals(fctieInput) == true && v2.getNumePrenume().getText().equals(numeInput) == true) {
					if(numeInput.equals("") == false && prenumeInput.equals("") == false && fctieInput.equals("") == false) {
						rs = m.getOrarGeneric(numeInput, prenumeInput, fctieInput);
						for(String s: rs) {
							if(s == null) {
								ok = 0;
							}
						}
						System.out.println(rs);
						if(ok == 0) {
							JOptionPane.showMessageDialog(v3, "Nu exista angajatul cautat. Introduceti alti parametri!","Error",JOptionPane.INFORMATION_MESSAGE);
						}
						else {
							v8.getOrar().addItem(new String("Fa scroll pentru a vedea orarul"));
							
							for(String s: rs) {
								v8.getOrar().addItem(s);
							}
							v3.setVisible(false);
							v8.setVisible(true);
						}
					}
					else {
						JOptionPane.showMessageDialog(v3, "Introduceti parametri!","Error",JOptionPane.INFORMATION_MESSAGE);
					}
				} else {
					JOptionPane.showMessageDialog(v3, "Nu puteti accesa datele altor angajati!", "Error",
							JOptionPane.INFORMATION_MESSAGE);
				}
			}
			else {
				if (numeInput.equals("") == false && prenumeInput.equals("") == false
						&& fctieInput.equals("") == false) {
					rs = m.getOrarGeneric(numeInput, prenumeInput, fctieInput);
					for (String s : rs) {
						if (s == null) {
							ok = 0;
						}
					}
					if (ok == 0) {
						JOptionPane.showMessageDialog(v3, "Nu exista angajatul cautat. Introduceti alti parametri!",
								"Error", JOptionPane.INFORMATION_MESSAGE);
					} else {
						v8.getOrar().addItem(new String("Fa scroll pentru a vedea orarul"));

						for (String s : rs) {
							// System.out.println(s);
							v8.getOrar().addItem(s);
						}
						v3.setVisible(false);
						v8.setVisible(true);
					}
				} else {
					JOptionPane.showMessageDialog(v3, "Introduceti parametri!", "Error",
							JOptionPane.INFORMATION_MESSAGE);
				}
			}
		}
	}
	
	//am folosit la orar generic si la orar specific aceeasi pagina
	//de interfata v8.
	class AdaugaOrarConcListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			
			String numeInput = v3.getNume().getText();
			String prenumeInput = v3.getPNume().getText();
			String fctieInput = v3.getFctie().getText();
			
			String[] rs = null;
			int ok = 1;
			
			if (fAng.equals("medic") == true || fAng.equals("asistent medical") == true
					|| fAng.equals("receptioner") == true) {
				if (fAng.toLowerCase().equals(fctieInput) == true
						&& v2.getNumePrenume().getText().equals(numeInput) == true) {
					if (numeInput.equals("") == false && prenumeInput.equals("") == false
							&& fctieInput.equals("") == false) {
						rs = m.getOrarConc(numeInput, prenumeInput, fctieInput);
						if (rs[0].equals("Sfarsit")) {
							ok = 0;
						}

						if (ok == 0) {
							JOptionPane.showMessageDialog(v3, "Nu exista angajatul cautat. Introduceti alti parametri!",
									"Error", JOptionPane.INFORMATION_MESSAGE);
						} else {

							v8.setModul("RESURSE UMANE - CONCEDII");
							v8.setLabel("Vizualizati concediile:");

							v8.getOrar().addItem(new String("Fa scroll pentru a vedea concediile"));

							int i = 0;
							while (!rs[i].equals("Sfarsit")) {
								v8.getOrar().addItem(rs[i]);
								i++;
							}
							v3.setVisible(false);
							v8.setVisible(true);
						}
					}
					else {
						JOptionPane.showMessageDialog(v3, "Introduceti parametri!", "Error",
								JOptionPane.INFORMATION_MESSAGE);
					}
				} 
				else {
					JOptionPane.showMessageDialog(v3, "Nu puteti accesa datele altor angajati!", "Error",
							JOptionPane.INFORMATION_MESSAGE);
				}
			}
			else {
				if (numeInput.equals("") == false && prenumeInput.equals("") == false
						&& fctieInput.equals("") == false) {
					rs = m.getOrarConc(numeInput, prenumeInput, fctieInput);
					if (rs[0].equals("Sfarsit")) {
						ok = 0;
					}

					if (ok == 0) {
						JOptionPane.showMessageDialog(v3, "Nu exista angajatul cautat. Introduceti alti parametri!",
								"Error", JOptionPane.INFORMATION_MESSAGE);
					} else {

						v8.setModul("RESURSE UMANE - CONCEDII");
						v8.setLabel("Vizualizati concediile:");

						v8.getOrar().addItem(new String("Fa scroll pentru a vedea concediile"));

						int i = 0;
						while (!rs[i].equals("Sfarsit")) {
							v8.getOrar().addItem(rs[i]);
							i++;
						}
						v3.setVisible(false);
						v8.setVisible(true);
					}
				} else {
					JOptionPane.showMessageDialog(v3, "Introduceti parametri!", "Error",
							JOptionPane.INFORMATION_MESSAGE);
				}
			}
		}
	}
	
	//butonul care adauga un concediu pt un angajat
	class BtnConcediuListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			String numeInput = v3.getNume().getText();
			String prenumeInput = v3.getPNume().getText();
			String fctieInput = v3.getFctie().getText();
			String ziInceputInput = v4.getZiInceput().getText();
			String ZiSfarsitInput = v4.getZiSfarsit().getText();
			boolean rs = false;
			
			rs = m.adaugareConcediu(numeInput, prenumeInput, fctieInput, ziInceputInput, ZiSfarsitInput);
			if (rs == false) {
				JOptionPane.showMessageDialog(v4, "Parametri gresiti!", "Error",
						JOptionPane.INFORMATION_MESSAGE);
				v4.getZiInceput().setText("data de inceput");
				v4.getZiSfarsit().setText("data de sfarsit");
			} else {
				JOptionPane.showMessageDialog(v4, "Adaugare realizata cu succes!", "Message",
						JOptionPane.INFORMATION_MESSAGE);
				v4.getZiInceput().setText("data de inceput");
				v4.getZiSfarsit().setText("data de sfarsit");
			}
		}	
	}
	
	//butonul care adauga un concediu pt un angajat
		class AdaugaZiLiberaListener implements ActionListener{

			@Override
			public void actionPerformed(ActionEvent e) {
				String numeInput = v3.getNume().getText();
				String prenumeInput = v3.getPNume().getText();
				String fctieInput = v3.getFctie().getText();
				String ZiInput = v4.getZiLibera().getText();
				String OreIInput = (v4.getOraInceput()).getSelectedItem().toString();
				String OreSInput = (v4.getOraSfarsit()).getSelectedItem().toString();
				boolean rs = false;
				
				rs = m.adaugareZiLibera(numeInput, prenumeInput, fctieInput, ZiInput, OreIInput, OreSInput);
				if (rs == false) {
					JOptionPane.showMessageDialog(v4, "Parametri gresiti!", "Error",
							JOptionPane.INFORMATION_MESSAGE);
					v4.getZiLibera().setText("data zi libera");
					v4.getOraInceput().setSelectedItem(v4.getOraInceput().getItemAt(0));
					v4.getOraSfarsit().setSelectedItem(v4.getOraSfarsit().getItemAt(0));
				} else {
					JOptionPane.showMessageDialog(v4, "Adaugare realizata cu succes!", "Message",
							JOptionPane.INFORMATION_MESSAGE);
					v4.getZiLibera().setText("data zi libera");
					v4.getOraInceput().setSelectedItem(v4.getOraInceput().getItemAt(0));
					v4.getOraSfarsit().setSelectedItem(v4.getOraSfarsit().getItemAt(0));
				}
			}	
		}
	
	class DatePersonaleListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			String numeInput = v3.getNume().getText();
			String prenumeInput = v3.getPNume().getText();
			String fctieInput = v3.getFctie().getText();
			String[] rs = null;
			int ok = 1;
			
			if(fAng.equals("medic") == true || fAng.equals("asistent medical") == true || fAng.equals("receptioner") == true) {
				if (fAng.toLowerCase().equals(fctieInput) == true && v2.getNumePrenume().getText().equals(numeInput) == true) {
					if (numeInput.equals("") == false && prenumeInput.equals("") == false
							&& fctieInput.equals("") == false) {
						rs = m.getDatePersonale(numeInput, prenumeInput, fctieInput);
						for (String s : rs) {
							if (s == null) {
								ok = 0;
							}
						}
						if (ok == 0) {
							JOptionPane.showMessageDialog(v3, "Nu exista angajatul cautat. Introduceti alti parametri!",
									"Error", JOptionPane.INFORMATION_MESSAGE);
						} else {
							v7.setTextFields(rs[0], rs[1], rs[2], rs[3], rs[4], rs[5], rs[6], rs[7], rs[8], rs[9],
									rs[10]);
							v3.setVisible(false);
							v7.setVisible(true);
						}
					} else {
						JOptionPane.showMessageDialog(v3, "Introduceti parametri!", "Error",
								JOptionPane.INFORMATION_MESSAGE);
					}
				} else {
					JOptionPane.showMessageDialog(v3, "Nu puteti accesa datele altor angajati!", "Error",
							JOptionPane.INFORMATION_MESSAGE);
				}
			}
			else {
				if(numeInput.equals("") == false && prenumeInput.equals("") == false && fctieInput.equals("") == false) {
					rs = m.getDatePersonale(numeInput, prenumeInput, fctieInput);
					for(String s: rs) {
						if(s == null) {
							ok = 0;
						}
					}
					if(ok == 0) {
						JOptionPane.showMessageDialog(v3, "Nu exista angajatul cautat. Introduceti alti parametri!","Error",JOptionPane.INFORMATION_MESSAGE);
					}
					else {
						v7.setTextFields(rs[0], rs[1], rs[2], rs[3], rs[4], rs[5], rs[6], rs[7], rs[8], rs[9], rs[10]);
						v3.setVisible(false);
						v7.setVisible(true);
					}
				}
				else {
					JOptionPane.showMessageDialog(v3, "Introduceti parametri!","Error",JOptionPane.INFORMATION_MESSAGE);
				}
			}
		}
	}
	
	class AdaugaPrg implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			String ZiInput = v9.txt1().getText();
			String LunaInput = v9.txt2().getText();
			String AnInput = v9.txt3().getText();
			String OIInput = v9.txt4().getText();
			String SpecInput = v9.txt5().getText();
			String Med1Input = v9.txt6().getText();
			String Med2Input = v9.txt7().getText();
			String AsistInput = v9.txt8().getText();
			String PacInput = v9.txt9().getText();
			String Serv1Input = v9.txt10().getText();
			String Serv2Input = v9.txt11().getText();
			String Serv3Input = v9.txt12().getText();
			
			boolean rs = false;
			
			rs = m.adaugarePrg(ZiInput, LunaInput, AnInput, OIInput, SpecInput, Med1Input, Med2Input, AsistInput, PacInput, Serv1Input, Serv2Input, Serv3Input);
			if(ZiInput.equals("") == true || LunaInput.equals("") == true || AnInput.equals("") == true || OIInput.equals("") == true || SpecInput.equals("") == true || Med1Input.equals("") == true || Med2Input.equals("") == true || AsistInput.equals("") == true || PacInput.equals("") == true || (Serv1Input.equals("") == true && Serv2Input.equals("") == true && Serv3Input.equals("") == true)) {
				JOptionPane.showMessageDialog(v9, "Introduceti Parametri!", "Error",
						JOptionPane.INFORMATION_MESSAGE);
			}
			else if (rs == false) {
				JOptionPane.showMessageDialog(v9, m.campErr, "Error",
						JOptionPane.INFORMATION_MESSAGE);
			}else {
				JOptionPane.showMessageDialog(v9, "Adaugare realizata cu succes!", "Message",
						JOptionPane.INFORMATION_MESSAGE);
			}
		}	
	}
	
	class ContAdminListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			String CNPInput = v13.txt1().getText();
			String NumeInput = v13.txt2().getText();
			String PrenumeInput = v13.txt3().getText();
			String AdresaInput = v13.txt4().getText();
			String NrTelInput = v13.txt5().getText();
			String EmailInput = v13.txt6().getText();
			String IbanInput = v13.txt7().getText();
			String NrContractInput = v13.txt8().getText();
			String DataAngInput = v13.txt9().getText();
			String FctieInput = v13.txt10().getText();
			
			boolean rs = false;
			
			try {
				
				
			}
			catch(Exception ex) {
				System.out.println(ex.getMessage());
			}
			
			
			rs = m.InsertUtiliz(CNPInput, NumeInput, PrenumeInput, AdresaInput, NrTelInput, EmailInput, IbanInput, NrContractInput, DataAngInput, FctieInput);
			if(CNPInput.equals("") == true || NumeInput.equals("") == true || PrenumeInput.equals("") == true || AdresaInput.equals("") == true || NrTelInput.equals("") == true || EmailInput.equals("") == true || IbanInput.equals("") == true || DataAngInput.equals("") == true || FctieInput.equals("") == true){
				JOptionPane.showMessageDialog(v13, "Introduceti Parametri!", "Error",
						JOptionPane.INFORMATION_MESSAGE);
			}
			else if (rs == false) {
				JOptionPane.showMessageDialog(v9, "Nu s-a putut crea contul!", "Error",
						JOptionPane.INFORMATION_MESSAGE);
			}else {
				JOptionPane.showMessageDialog(v9, "Cont creat cu succes!", "Message",
						JOptionPane.INFORMATION_MESSAGE);
			}
		}	
	}
	
	class CreatiContListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			String CNPInput = v12.txt1().getText();
			String NumeInput = v12.txt2().getText();
			String PrenumeInput = v12.txt3().getText();
			String AdresaInput = v12.txt4().getText();
			String NrTelInput = v12.txt5().getText();
			String EmailInput = v12.txt6().getText();
			String IbanInput = v12.txt7().getText();
			String NrContractInput = v12.txt8().getText();
			String DataAngInput = v12.txt9().getText();
			String FctieInput = v12.txt10().getText();
			String SalInput = v12.txt11().getText();
			String NrOreInput = v12.txt12().getText();
			String DepInput = v12.txt13().getText();
			
			boolean rs = false;
			
			rs = m.InsertAngajat(CNPInput, NumeInput, PrenumeInput, AdresaInput, NrTelInput, EmailInput, IbanInput, NrContractInput, DataAngInput, FctieInput, SalInput, NrOreInput, DepInput);
			if(CNPInput.equals("") == true || NumeInput.equals("") == true || PrenumeInput.equals("") == true || AdresaInput.equals("") == true || NrTelInput.equals("") == true || EmailInput.equals("") == true || IbanInput.equals("") == true || DataAngInput.equals("") == true || FctieInput.equals("") == true || SalInput.equals("") == true || NrOreInput.equals("") == true || DepInput.equals("") == true){
				JOptionPane.showMessageDialog(v12, "Introduceti Parametri!", "Error",
						JOptionPane.INFORMATION_MESSAGE);
			}
			else if (rs == false) {
				JOptionPane.showMessageDialog(v12, "Nu s-a putut crea contul!", "Error",
						JOptionPane.INFORMATION_MESSAGE);
			}else {
				JOptionPane.showMessageDialog(v12, "Cont creat cu succes!", "Message",
						JOptionPane.INFORMATION_MESSAGE);
			}
		}	
	}
	
	class VenitAngListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			String NumeInput = v5.getNumeAng().getText();
			String PrenumeInput = v5.getPrenumeAng().getText();
			String LunaInput = v5.getLuna().getSelectedItem().toString();
			String rs = null;
			
			if (fAng.equals("medic") == true || fAng.equals("asistent medical") == true
					|| fAng.equals("receptioner") == true || fAng.equals("inspector") == true) {
				if (v2.getNumePrenume().getText().equals(NumeInput) == true) {

					rs = m.getVenitAngajat(NumeInput, PrenumeInput, LunaInput);
					if (NumeInput.equals("") == true || PrenumeInput.equals("") == true) {
						JOptionPane.showMessageDialog(v5, "Introduceti Parametri!", "Error",
								JOptionPane.INFORMATION_MESSAGE);
					} else if (rs == null) {
						JOptionPane.showMessageDialog(v5, "Nu exista angajatul!", "Error",
								JOptionPane.INFORMATION_MESSAGE);
					} else {
						v5.getNumeAng().setText("");
						v5.getPrenumeAng().setText("");
						v5.getLuna().setSelectedItem(v5.getLuna().getItemAt(0));
						JOptionPane.showMessageDialog(v5, "Venitul angajatului este: " + rs, "Message",
								JOptionPane.INFORMATION_MESSAGE);
					}
				}
				else {
					JOptionPane.showMessageDialog(v5, "Nu puteti vedea venitul altui angajat!", "Error",
							JOptionPane.INFORMATION_MESSAGE);
				}
			}
			else {
				rs = m.getVenitAngajat(NumeInput, PrenumeInput, LunaInput);
				if (NumeInput.equals("") == true || PrenumeInput.equals("") == true) {
					JOptionPane.showMessageDialog(v5, "Introduceti Parametri!", "Error",
							JOptionPane.INFORMATION_MESSAGE);
				} else if (rs == null) {
					JOptionPane.showMessageDialog(v5, "Nu exista angajatul!", "Error",
							JOptionPane.INFORMATION_MESSAGE);
				} else {
					v5.getNumeAng().setText("");
					v5.getPrenumeAng().setText("");
					v5.getLuna().setSelectedItem(v5.getLuna().getItemAt(0));
					JOptionPane.showMessageDialog(v5, "Venitul angajatului este: " + rs, "Message",
							JOptionPane.INFORMATION_MESSAGE);
				}
			}
		}	
	}
		
	class BtnPolListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			String PoliclinicaInput = v5.getNumePol().getText();
			String LunaInput = v5.getLuna().getSelectedItem().toString();
			Float rs = null;
			
			if (fAng.equals("expert contabil") == true) {
				rs = m.getVenitPoliclinica(PoliclinicaInput, LunaInput);
				if (PoliclinicaInput.equals("") == true) {
					JOptionPane.showMessageDialog(v5, "Introduceti Parametru!", "Error",
							JOptionPane.INFORMATION_MESSAGE);
				} else if (rs == 0) {
					JOptionPane.showMessageDialog(v5, "Nu exista policlinica!", "Error",
							JOptionPane.INFORMATION_MESSAGE);
				} else {
					v5.getNumeAng().setText("");
					v5.getPrenumeAng().setText("");
					v5.getNumePol().setText("");
					v5.getLuna().setSelectedItem(v5.getLuna().getItemAt(0));
					JOptionPane.showMessageDialog(v5, "Venitul policlinicii este: " + rs, "Message",
							JOptionPane.INFORMATION_MESSAGE);
				}
			} else {
				JOptionPane.showMessageDialog(v5, "Nu puteti accesa submodulul", "Message",
						JOptionPane.INFORMATION_MESSAGE);
			}
		}
	}
	
	class BtnPolicliniciListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			String LunaInput = v5.getLuna().getSelectedItem().toString();
			Float rs = new Float("0");

			if (fAng.equals("expert contabil") == true) {
				rs = m.getVenitPoliclinici(LunaInput);
				if (LunaInput.equals("") == true) {
					JOptionPane.showMessageDialog(v5, "Introduceti Parametru!", "Error",
							JOptionPane.INFORMATION_MESSAGE);
				} else if (rs == 0) {
					JOptionPane.showMessageDialog(v5, "Nu exista policlinica!", "Error",
							JOptionPane.INFORMATION_MESSAGE);
				} else {
					v5.getNumeAng().setText("");
					v5.getPrenumeAng().setText("");
					v5.getNumePol().setText("");
					v5.getLuna().setSelectedItem(v5.getLuna().getItemAt(0));
					JOptionPane.showMessageDialog(v5, "Venitul policlinicii este: " + rs, "Message",
							JOptionPane.INFORMATION_MESSAGE);
				}
			} else {
				JOptionPane.showMessageDialog(v5, "Nu puteti accesa submodulul", "Message",
						JOptionPane.INFORMATION_MESSAGE);
			}
		}
	}
}
