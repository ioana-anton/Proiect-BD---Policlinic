import java.sql.*;

public class PoliclinicaModel {

	static String campErr = new String();
	static final String JDBCDRIVER = "com.mysql.jdbc.Driver";
	static final String url = "jdbc:mysql://localhost/policlinica";
	static final String user = "root";
	static final String pass = "bangtanboysbts7MX";
	Connection conn = null;

	PoliclinicaModel() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Connecting to database...");
			conn = DriverManager.getConnection(url, user, pass);
		} catch (SQLException s) {
			s.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		/*
		Statement stm = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Connecting to database...");
			conn = DriverManager.getConnection(url, user, pass);

			System.out.println("Creating statement...");

			// test 1 al conexiunii:
			stm = conn.createStatement();
			String sql = "Select id_ang, functie_a from angajat";
			ResultSet rs = stm.executeQuery(sql);

			while (rs.next()) {
				int id = rs.getInt("id_ang");
				String functie = rs.getString("functie_a");
				System.out.println(id + " " + functie);
			}
			System.out.println();
			System.out.println();

			// test 2 al conexiunii:
			sql = "Select id_bon, costul from bon_fiscal";
			rs = stm.executeQuery(sql);
			while (rs.next()) {
				int id = rs.getInt("id_bon");
				float functie = rs.getFloat("costul");
				System.out.println(id + " " + functie);
			}
			System.out.println();
			System.out.println();

			stm.close();
			rs.close();

		} catch (SQLException s) {
			s.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (stm != null) {
					stm.close();
				}
			} catch (SQLException se) {
				se.printStackTrace();
			}

			try {
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException se1) {
				se1.printStackTrace();
			}
		}*/
	}
	
	//metoda de select din tabelele angajat si utilizator in interfata de afisare:
	public String[] getDatePersonale(String n, String p, String f) {
		Statement stm = null;
		ResultSet rs = null;
		String[] result = new String[11];
		try {

			stm = conn.createStatement();
			String sql = "select CNP, nume, prenume, adresa, numar_tel, email, IBAN, nr_contract, data_ang, salariu_neg, nr_ore\r\n"
					+ "from angajat, utilizator\r\n"
					+ "where functie_a ='" + f +"'"+"and id_utilizator = id_utiliz_ang and nume ='" + n +"'"+"and prenume = '"+p+"'";
			rs = stm.executeQuery(sql);
			int i = 0;
			while (rs.next()) {
				result[i] = rs.getString("nume");
				i++;
				result[i] = rs.getString("prenume");
				i++;
				result[i] = rs.getString("CNP");
				i++;
				result[i] = rs.getString("adresa");
				i++;
				result[i] = rs.getString("numar_tel");
				i++;
				result[i] = rs.getString("email");
				i++;
				result[i] = rs.getString("IBAN");
				i++;
				result[i] = rs.getString("nr_contract");
				i++;
				result[i] = rs.getString("data_ang");
				i++;
				result[i] = rs.getString("salariu_neg");
				i++;
				result[i] = rs.getString("nr_ore");		
			}
			rs.close();
			
		} catch (SQLException s) {
			s.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (stm != null) {
					stm.close();
				}
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}
		
		return result;
	}
	
	//metoda de select a orarului generic:
	public String[] getOrarGeneric(String n, String p, String f) {
		Statement stm = null;
		ResultSet rs = null;
		String[] result = new String[1095];
		
		try {

			stm = conn.createStatement();
			String sql = "select `zi-luna`, luna, an, `zi-saptamana`, id_policlinica, id_orar_ang, orar_generic.id_orar, ora_inceput, ora_final from orar_generic,\r\n"
					+ "policlinica_orar_generic, angajat, utilizator where angajat.functie_a = '"+f
					+ "' and utilizator.nume = '"+n+"' and utilizator.prenume = '"+p
					+ "' and angajat.id_utiliz_ang = utilizator.id_utilizator and id_orar_ang = id_ang\r\n"
					+ "and policlinica_orar_generic.id_angajat = angajat.id_ang and policlinica_orar_generic.id_orar = orar_generic.id_orar";
			rs = stm.executeQuery(sql);
			int i = 0;
			while (rs.next()) {
				
				result[i] = rs.getString("zi-luna")+"-"+rs.getString("luna")+"-"+rs.getString("an")
				+", "+rs.getString("zi-saptamana")+", Policlinica: "+rs.getString("id_policlinica")
				+", "+rs.getString("ora_inceput")+", "+rs.getString("ora_final");
				
				i++;
			}
			
			for(String s: result) {
				System.out.println(s);
			}
			rs.close();
			
		} catch (SQLException s) {
			s.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (stm != null) {
					stm.close();
				}
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}
		
		return result;
	}
	
	// metoda de select a orarului generic:
	public String[] getOrarConc(String n, String p, String f) {
		Statement stm = null;
		ResultSet rs = null;
		String[] result = new String[365];

		try {

			stm = conn.createStatement();
			String sql = "select `zi-luna`, luna, an, ora_inceput, ora_final, `zi-saptamana` from orar_specific, angajat, utilizator where angajat.functie_a = '"+f
					+ "' and utilizator.nume = '"+n+"' and utilizator.prenume = '"+p
					+ "' and angajat.id_utiliz_ang = utilizator.id_utilizator and orar_specific.id_angajat = angajat.id_ang;";
			
			rs = stm.executeQuery(sql);
			int i = 0;
			while (rs.next()) {

				result[i] = rs.getString("zi-luna") + "-" + rs.getString("luna") + "-" + rs.getString("an") + ", "
						+ rs.getString("zi-saptamana")+ ", "+ rs.getString("ora_inceput") + ", " + rs.getString("ora_final");

				i++;
			}
			result[i] = new String("Sfarsit");
			rs.close();

		} catch (SQLException s) {
			s.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (stm != null) {
					stm.close();
				}
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}

		return result;
	}
	
	//metoda pt returnarea Id-ului unui angajat
	public String getIdAng(String n, String p, String f) {
		Statement stm = null;
		ResultSet rs = null;
		String id = null;
		
		try {
			stm = conn.createStatement();
			String sql = "select angajat.id_ang from angajat, utilizator where angajat.functie_a = '"+f
					+ "' and utilizator.nume = '"+n+"' and utilizator.prenume = '"+p
					+ "' and angajat.id_utiliz_ang = utilizator.id_utilizator;";
			
			rs = stm.executeQuery(sql);
			
			while (rs.next()) {
				id = rs.getString("id_ang");
			}
			rs.close();
		}
		catch (SQLException s) {
			s.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (stm != null) {
					stm.close();
				}
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}
		return id;
	}
	
	//metoda de adaugare a unui concediu pt un angajat
	public boolean adaugareConcediu(String n, String p, String f, String zi_inceput, String zi_sfarsit) {	
		//ar trebui sa facem in sql la adaugare concediu, sa vedem daca
		//avem un concediu de doua ori sau nu, daca mai avem timp.
		CallableStatement stmp = null;
		boolean realizat = false;
		boolean dateCorecte = true;
		String id = null;
		Date dI = null;
		Date dF = null;
		
		try {	
			id = this.getIdAng(n, p, f);
			try {
				dI = Date.valueOf(zi_inceput);
				dF = Date.valueOf(zi_sfarsit);
			}
			catch(IllegalArgumentException e) {
				dateCorecte = false;
			}	
			
			if (id != null && dateCorecte == true) {
				stmp = conn.prepareCall("{call generare_concediu_orar_specific(?,?,?)}");
				stmp.setDate(1, dI);
				stmp.setDate(2, dF);
				stmp.setInt(3, Integer.valueOf(id));
				stmp.execute();
				realizat = true;
			}
			
		} catch (SQLException s) {
			System.out.println(s.getMessage());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (stmp != null) {
					stmp.close();
				}
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}

		return realizat;
	}
	
	//metoda de adaugare a unui concediu pt un angajat
		public boolean adaugareZiLibera(String n, String p, String f, String zi, String Orai, String Of) {	
			//ar trebui sa facem in sql la adaugare concediu, sa vedem daca
			//avem un concediu de doua ori sau nu, daca mai avem timp.
			CallableStatement stmp = null;
			boolean realizat = false;
			boolean dateCorecte = true;
			String id = null;
			Date dI = null;
			Time tI = null;
			Time tS = null;
			
			try {	
				id = this.getIdAng(n, p, f);
				try {
					dI = Date.valueOf(zi);
					tI = Time.valueOf(Orai + ":00");
					tS = Time.valueOf(Of + ":00");	
				}
				catch(IllegalArgumentException e) {
					dateCorecte = false;
				}	
				
				if (id != null && dateCorecte == true) {
					stmp = conn.prepareCall("{call generare_zi_orar_specific(?,?,?,?)}");
					stmp.setDate(1, dI);
					stmp.setTime(2, tI);
					stmp.setTime(3, tS);
					stmp.setInt(4, Integer.valueOf(id));
					stmp.execute();
					realizat = true;
				}
				
			} catch (SQLException s) {
				System.out.println(s.getMessage());
			} catch (Exception e) {
				System.out.println(e.getMessage());
			} finally {
				try {
					if (stmp != null) {
						stmp.close();
					}
				} catch (SQLException se) {
					se.printStackTrace();
				}
			}

			return realizat;
		}
		
		//metoda de adaugare a unui concediu pt un angajat
		public boolean adaugarePrg(String zi, String luna, String an, String oI, String spec, String med1, String med2, String asist, String pac, String serv1, String serv2, String serv3) {
			CallableStatement stmp = null;
			boolean realizat = false;
			boolean dateCorecte = true;
			Time tI = null;

			try {
				
				try {
					tI = Time.valueOf(oI + ":00");
				}
				catch(IllegalArgumentException e) {
					dateCorecte = false;
					campErr = "Parametri gresiti - ora";
				}	

				if (dateCorecte == true) {
					stmp = conn.prepareCall("{call generare_programare(?,?,?,?,?,?,?,?,?,?,?,?)}");
					stmp.setInt(1, Integer.valueOf(zi));
					stmp.setInt(2, Integer.valueOf(luna));
					stmp.setInt(3, Integer.valueOf(an));
					stmp.setTime(4, tI);
					stmp.setString(5, spec);
					stmp.setInt(6, Integer.valueOf(med1));
					stmp.setInt(7, Integer.valueOf(med2));
					stmp.setInt(8, Integer.valueOf(asist));
					stmp.setInt(9, Integer.valueOf(pac));
					try {
						stmp.setInt(10, Integer.valueOf(serv1));
					}
					catch(Exception e) {
						System.out.println("Serviciul 1 e null");
						stmp.setString(10, null);
					}
					try {
						stmp.setInt(11, Integer.valueOf(serv2));
					}
					catch(Exception e) {
						System.out.println("Serviciul 2 e null");
						stmp.setString(11, null);
					}
					try {
						stmp.setInt(12, Integer.valueOf(serv3));
					}
					catch(Exception e) {
						System.out.println("Serviciul 3 e null");
						stmp.setString(12, null);
					}
					stmp.execute();
					realizat = true;
				}

			} catch (SQLException s) {
				
				campErr = s.getMessage();
				System.out.println(s.getMessage());
			} catch (Exception e) {
				campErr = "Parametri gresiti - "+e.getMessage();
				System.out.println(e.getMessage());
			} finally {
				try {
					if (stmp != null) {
						stmp.close();
					}
				} catch (SQLException se) {
					se.printStackTrace();
				}
			}
			return realizat;
		}
		
		//metoda de adaugare a unui concediu pt un angajat
		public boolean generareBonPrg(String id) {
			CallableStatement stmp = null;
			boolean realizat = false;
			
			try {
				stmp = conn.prepareCall("{call generare_bon_fiscal(?)}");
				stmp.setInt(1, Integer.valueOf(id));
				stmp.execute();
				realizat = true;
			} catch (SQLException s) {
				System.out.println(s.getMessage());
			} catch (Exception e) {
				System.out.println(e.getMessage());
			} finally {
				try {
					if (stmp != null) {
						stmp.close();
					}
				} catch (SQLException se) {
					se.printStackTrace();
				}
			}
			return realizat;
		}
		
		public String selectBon(String id) {
			Statement stm = null;
			ResultSet rs = null;
			String result = null;
			
			try {
				stm = conn.createStatement();
				String sql = "Select id_prog_pacient, costul, nume_medic, zi_luna, luna, an from bon_fiscal where id_prog_pacient = '"+id+"';";
				rs = stm.executeQuery(sql);
				while (rs.next()) {
					result = "Id Programare:"+rs.getString("id_prog_pacient")+"\n"+"Cost: "+rs.getString("costul")+"\n"+"Nume Medic: "+rs.getString("nume_medic")
					+"\n"+"Data: "+rs.getString("zi_luna")+"-"+rs.getString("luna")+"-"+rs.getString("an");
				}
				rs.close();
			} catch (SQLException s) {
				System.out.println(s.getMessage());
			} catch (Exception e) {
				System.out.println(e.getMessage());
			} finally {
				try {
					if (stm != null) {
						stm.close();
					}
				} catch (SQLException se) {
					se.printStackTrace();
				}
			}
			return result;
		}
		
		//metoda de adaugare in raport pt o programare:
		public boolean generareRapPrg(String id, String simp, String diag, String rec, String des1, String des2,
				String des3) {
			CallableStatement stmp = null;
			boolean realizat = false;

			try {
				stmp = conn.prepareCall("{call inserare_raport_pacient(?,?,?,?,?,?,?)}");
				stmp.setInt(1, Integer.valueOf(id));
				stmp.setString(2, simp);
				stmp.setString(3, diag);
				stmp.setString(4, rec);
				stmp.setString(5, des1);
				stmp.setString(6, des2);
				stmp.setString(7, des3);
				stmp.execute();
				realizat = true;
			} catch (SQLException s) {
				campErr = "Raport deja inserat!";
				System.out.println(s.getMessage());
			} catch (Exception e) {
				campErr = "Parametri gresiti! Introduceti alti parametri!";
				System.out.println(e.getMessage());
			} finally {
				try {
					if (stmp != null) {
						stmp.close();
					}
				} catch (SQLException se) {
					se.printStackTrace();
				}
			}
			return realizat;
		}
		
		// metoda de update in raport pt o programare:
		public boolean inserareRapPrg(String id, String simp, String diag, String rec) {
			Statement stmp = null;
			ResultSet rs = null;
			String nr = null;
			boolean realizat = false;

			try {
				if(simp.equals("") == true || diag.equals("") == true || rec.equals("") == true) {
					
				}
				else {
					stmp = conn.createStatement();
					String sql1 = "select count(id_raport) from raport_pacient_programare where id_raport = '"+id+"';";
					rs = stmp.executeQuery(sql1);
					while(rs.next()) {
						nr = rs.getString("count(id_raport)");
					}
					if(Integer.parseInt(nr) == 1) {
						String sql = "UPDATE raport_pacient_programare SET simptome = '"+simp+"' , diagnostic = '"+diag+"' , recomandari = '"+rec+"' WHERE id_raport = '"+id+"';";
						stmp.execute(sql);
						realizat = true;
					}
					else {
						campErr = "Nu exista programarea cu acest id!";
					}
					
				}		
			} catch (SQLException s) {
				campErr = "Raportul are parafa pusa!";
				System.out.println(s.getMessage());
			} catch (Exception e) {
				campErr = "Parametri gresiti! Introduceti alti parametri!";
				System.out.println(e.getMessage());
			} finally {
				try {
					if (stmp != null) {
						stmp.close();
					}
				} catch (SQLException se) {
					se.printStackTrace();
				}
			}
			return realizat;
		}

		//metoda de adaugare in raport pt o programare:
		public boolean punereParafa(String id) {
			CallableStatement stmp = null;
			boolean realizat = false;

			try {
				stmp = conn.prepareCall("{call punere_parafa(?)}");
				stmp.setInt(1, Integer.valueOf(id));
				stmp.execute();
				realizat = true;
			} catch (SQLException s) {
				System.out.println(s.getMessage());
			} catch (Exception e) {
				System.out.println(e.getMessage());
			} finally {
				try {
					if (stmp != null) {
						stmp.close();
					}
				} catch (SQLException se) {
					se.printStackTrace();
				}
			}
			return realizat;
		}
		
		// metoda de select a programarilor unui medic:
		public String[] getPrgMed(String id, String zi, String luna) {
			Statement stm = null;
			ResultSet rs = null;
			String[] result = new String[100];
			
			int count = 0;

			try {
				
				//System.out.println(zi);
				//System.out.println(luna);
				
				stm = conn.createStatement();
				String sql = "select pacient.nume, pacient.prenume, pacient.CNP, `zi-luna`, luna, an, ora_inceput, ora_final, programare_pacient.id_medic_recomandare \r\n"
						+ "from raport_pacient_programare, programare_pacient, pacient where programare_pacient.id_pacient = pacient.id_pacient \r\n"
						+ "and raport_pacient_programare.id_prog_pacient = programare_pacient.id_prog and programare_pacient.id_medic = '"+id+"' \r\n"
						+ "and programare_pacient.`zi-luna` = '"+zi+"' and programare_pacient.luna = '"+luna+"';";
				
				rs = stm.executeQuery(sql);
				int i = 0;
				while (rs.next()) {

					result[i] = "Nume: "+rs.getString("nume") + ", Prenume:" + rs.getString("prenume") +", CNP: "+rs.getString("CNP")+", Data: " + rs.getString("zi-luna") + "-"
							+ rs.getString("luna")+ "-"+ rs.getString("an") +", "+rs.getString("ora_inceput") + "-" + rs.getString("ora_final") 
							+", Medic recomandare: " + rs.getString("id_medic_recomandare");

					i++;
				}
				result[i] = new String("Sfarsit");
				rs.close();

			} catch (SQLException s) {
				System.out.println(s.getMessage());
			} catch (Exception e) {
				System.out.println(e.getMessage());
				e.printStackTrace();
			} finally {
				try {
					if (stm != null) {
						stm.close();
					}
				} catch (SQLException se) {
					se.printStackTrace();
				}
			}

			return result;
		}
		
		public String[] getPrgPac(String id) {
			Statement stm = null;
			ResultSet rs = null;
			String[] result = new String[100];

			try {
				
				stm = conn.createStatement();
				String sql = "select pacient.nume, pacient.prenume, pacient.CNP, `zi-luna`, luna, an, ora_inceput, ora_final, cost_final, id_medic, diagnostic, recomandari\r\n"
						+ "from programare_pacient, pacient, raport_pacient_programare where pacient.id_pacient = '"+id+"' and pacient.id_pacient = programare_pacient.id_pacient\r\n"
						+ "and raport_pacient_programare.id_prog_pacient = programare_pacient.id_prog;";
				
				rs = stm.executeQuery(sql);
				int i = 0;
				while (rs.next()) {
					//mai pune si diagnostic si recomandari:
					result[i] = "Nume: "+rs.getString("nume") + ", Prenume:" + rs.getString("prenume") +", CNP: "+rs.getString("CNP")+", Data: " + rs.getString("zi-luna") + "-"
							+ rs.getString("luna")+ "-"+ rs.getString("an") +", "+rs.getString("ora_inceput") + "-" + rs.getString("ora_final");

					i++;
				}
				result[i] = new String("Sfarsit");
				rs.close();

			} catch (SQLException s) {
				System.out.println(s.getMessage());
			} catch (Exception e) {
				System.out.println(e.getMessage());
				e.printStackTrace();
			} finally {
				try {
					if (stm != null) {
						stm.close();
					}
				} catch (SQLException se) {
					se.printStackTrace();
				}
			}

			return result;
		}
		
		//metoda crearea unui cont de admin
		public boolean InsertUtiliz(String CNP, String NumeInput, String PrenumeInput, String AdresaInput, String NrTelInput, String EmailInput, String IbanInput, String NrContractInput, String DataAngInput, String FctieInput) {
			Statement stm = null;
			ResultSet rs = null;
			String id = null;
			String id_admin = null;
			boolean ok = false;
			
			try {
				
				System.out.println(DataAngInput);
				
				Date d = Date.valueOf(DataAngInput);
				
				System.out.println(d);
				
				System.out.println(NrContractInput);
				
				if (FctieInput.equals("administrator") == true) {
					
					stm = conn.createStatement();
					
					String sql = null;
					
					String sql1 = "SELECT MAX(utilizator.id_utilizator) FROM utilizator;";
					rs = stm.executeQuery(sql1);
					while(rs.next()) {
						id = rs.getString("MAX(utilizator.id_utilizator)");
					}
					if(id == null) {
						id = "1";
					}
					else {
						id = new Integer((Integer.parseInt(id) + 1)).toString();
					}
					
					
					sql ="insert into utilizator(id_utilizator, CNP, nume, prenume, adresa, numar_tel, email, IBAN, nr_contract, data_ang, utilizatorcol)values('"+id+"','"+CNP+"','"+NumeInput+"','"+PrenumeInput+"','"+AdresaInput+"','"+NrTelInput+"','"+EmailInput+"','"+IbanInput+"','"+NrContractInput+"','"+DataAngInput+"','"+FctieInput+"');";
					
					stm.executeUpdate(sql);
					
					sql = "select id_utilizator from utilizator where CNP = '"+CNP+"' and nume = '"+NumeInput+"' and prenume = '"+PrenumeInput+"';";
					
					rs = stm.executeQuery(sql);
					
					while(rs.next()) {
						id = rs.getString("id_utilizator");
					}
					
					sql = "SELECT MAX(administrator.id_admin) FROM administrator;";
					
					rs = stm.executeQuery(sql);
					
					while(rs.next()) {
						id_admin = rs.getString("MAX(administrator.id_admin)");
					}
					
					if(id_admin == null) {
						id_admin = "1";
					}
					else {
						id_admin = new Integer((Integer.parseInt(id_admin) + 1)).toString();
					}
					
					System.out.println(id);
					System.out.println(id_admin);
					
					sql = "insert into administrator(id_admin, id_utiliz) values('"+id_admin+"','"+id+"');";
					
					stm.executeUpdate(sql);
					
					ok = true;
				}
				else {
					throw new Exception("Nu inserezi functia buna!");
				}
			}
			catch (SQLException s) {
				System.out.println(s.getMessage());
			} catch (Exception e) {
				System.out.println(e.getMessage());
			} finally {
				try {
					if (stm != null) {
						stm.close();
					}
				} catch (SQLException se) {
					se.printStackTrace();
				}
			}
			return ok;
		}

		// metoda crearea unui cont de admin
		public boolean InsertAngajat(String CNP, String NumeInput, String PrenumeInput, String AdresaInput,
				String NrTelInput, String EmailInput, String IbanInput, String NrContractInput, String DataAngInput,
				String FctieInput, String SalInput, String NrOreInput, String DepInput) {
			Statement stm = null;
			ResultSet rs = null;
			String id = null;
			String id_ang = null;
			String id_admin = null;
			String fctie_util = new String("angajat");
			boolean ok = false;

			try {

				stm = conn.createStatement();

				String sql = null;

				String sql1 = "SELECT MAX(utilizator.id_utilizator) FROM utilizator;";
				rs = stm.executeQuery(sql1);
				while (rs.next()) {
					id = rs.getString("MAX(utilizator.id_utilizator)");
				}
				if (id == null) {
					id = "1";
				} else {
					id = new Integer((Integer.parseInt(id) + 1)).toString();
				}

				sql1 = "SELECT MAX(angajat.id_ang) FROM angajat;";
				rs = stm.executeQuery(sql1);
				while (rs.next()) {
					id_ang = rs.getString("MAX(angajat.id_ang)");
				}
				if (id_ang == null) {
					id = "1";
				} else {
					id_ang = new Integer((Integer.parseInt(id_ang) + 1)).toString();
				}

				if ((FctieInput.equals("medic") == true && DepInput.equals("3") == true)
						|| (FctieInput.equals("receptioner") == true && DepInput.equals("3") == true)
						|| (FctieInput.equals("asistent medical") == true && DepInput.equals("3") == true)
						|| (FctieInput.equals("inspector") == true && DepInput.equals("1") == true)
						|| (FctieInput.equals("expert contabil") == true && DepInput.equals("2") == true)) {

					sql = "insert into utilizator(id_utilizator, CNP, nume, prenume, adresa, numar_tel, email, IBAN, nr_contract, data_ang, utilizatorcol)values('"
							+ id + "','" + CNP + "','" + NumeInput + "','" + PrenumeInput + "','" + AdresaInput + "','"
							+ NrTelInput + "','" + EmailInput + "','" + IbanInput + "','" + NrContractInput + "','"
							+ DataAngInput + "','" + fctie_util + "');";

					stm.execute(sql);

					sql = "select id_utilizator from utilizator where CNP = '" + CNP + "' and nume = '" + NumeInput
							+ "' and prenume = '" + PrenumeInput + "';";

					rs = stm.executeQuery(sql);

					while (rs.next()) {
						id = rs.getString("id_utilizator");
					}

					sql = "insert into angajat(id_ang, id_utiliz_ang, salariu_neg, nr_ore, id_dep_ang, functie_a)values('"
							+ id_ang + "','" + id + "','" + SalInput + "','" + NrOreInput + "','" + DepInput + "','"
							+ FctieInput + "');";

					stm.executeUpdate(sql);

					ok = true;

				}

				if (FctieInput.equals("medic") == true && DepInput.equals("3") == true) {
					sql = "SELECT MAX(medic.id_medic) FROM medic;";

					rs = stm.executeQuery(sql);

					String id_medic = null;

					while (rs.next()) {
						id_medic = rs.getString("MAX(medic.id_medic)");
					}

					if (id_medic == null) {
						id_medic = "1";
					} else {
						id_medic = new Integer((Integer.parseInt(id_medic) + 1)).toString();
					}

					sql = "insert into medic(id_medic, id_ang_med) values('" + id_medic + "','" + id_ang + "')";
					stm.execute(sql);

				} else if (FctieInput.equals("asistent medical") == true && DepInput.equals("3") == true) {
					sql = "SELECT MAX(asistent_medical.id_asist) FROM asistent_medical;";

					rs = stm.executeQuery(sql);

					String id_asist = null;

					while (rs.next()) {
						id_asist = rs.getString("MAX(asistent_medical.id_asist)");
					}

					if (id_asist == null) {
						id_asist = "1";
					} else {
						id_asist = new Integer((Integer.parseInt(id_asist) + 1)).toString();
					}

					sql = "insert into asistent_medical(id_asist, id_ang_asist) values('" + id_asist + "','" + id_ang
							+ "')";
					stm.execute(sql);

				} else if (FctieInput.equals("receptioner") == true && DepInput.equals("3") == true) {
					sql = "SELECT MAX(receptioner.id_rec) FROM receptioner;";

					rs = stm.executeQuery(sql);

					String id_rec = null;

					while (rs.next()) {
						id_rec = rs.getString("MAX(receptioner.id_rec)");
					}

					if (id_rec == null) {
						id_rec = "1";
					} else {
						id_rec = new Integer((Integer.parseInt(id_rec) + 1)).toString();
					}

					sql = "insert into receptioner(id_rec, id_ang_rec) values('" + id_rec + "','" + id_ang + "')";
					stm.execute(sql);

				} else if (FctieInput.equals("inspector") == true && DepInput.equals("1") == true) {
					sql = "SELECT MAX(inspector_resurse_umane.id_inspector) FROM inspector_resurse_umane;";

					rs = stm.executeQuery(sql);

					String id_insp = null;

					while (rs.next()) {
						id_insp = rs.getString("MAX(inspector_resurse_umane.id_inspector)");
					}

					if (id_insp == null) {
						id_insp = "1";
					} else {
						id_insp = new Integer((Integer.parseInt(id_insp) + 1)).toString();
					}

					sql = "insert into inspector_resurse_umane(id_inspector, id_ang_insp) values('" + id_insp + "','"
							+ id_ang + "')";
					stm.execute(sql);
				} else if (FctieInput.equals("expert contabil") == true && DepInput.equals("2") == true) {
					sql = "SELECT MAX(expert_fin_cont.id_exp) FROM expert_fin_cont;";

					rs = stm.executeQuery(sql);

					String id_exp = null;

					while (rs.next()) {
						id_exp = rs.getString("MAX(expert_fin_cont.id_exp)");
					}

					if (id_exp == null) {
						id_exp = "1";
					} else {
						id_exp = new Integer((Integer.parseInt(id_exp) + 1)).toString();
					}

					sql = "insert into expert_fin_cont(id_exp, id_ang_exp) values('id_exp', 'id_ang')";
					stm.execute(sql);
				}

				rs.close();
			} catch (SQLException s) {
				System.out.println(s.getMessage());
			} catch (Exception e) {
				System.out.println(e.getMessage());
			} finally {
				try {
					if (stm != null) {
						stm.close();
					}
				} catch (SQLException se) {
					se.printStackTrace();
				}
			}
			return ok;
		}
		
		// metoda de adaugare in raport pt o programare:
		public String cautareFctieUtiliz(String n, String CNP) {
			Statement stmp = null;
			ResultSet rs = null;
			String fctie = null;
			
			try {
				stmp = conn.createStatement();
				
				String sql = "select utilizatorcol from utilizator where nume = '"+n+"' and CNP = '"+CNP+"';";
				rs = stmp.executeQuery(sql);
				
				while(rs.next()){
					fctie = rs.getString("utilizatorcol");
				}
			} catch (SQLException s) {
				System.out.println(s.getMessage());
			} catch (Exception e) {
				System.out.println(e.getMessage());
			} finally {
				try {
					if (stmp != null) {
						stmp.close();
					}
				} catch (SQLException se) {
					se.printStackTrace();
				}
			}
			System.out.println(fctie);
			return fctie;
		}		
		
		// getter pentru functia unui utilizator:
		public String cautareFctieAng(String n, String CNP) {
			Statement stmp = null;
			ResultSet rs = null;
			String fctie = null;
			
			try {
				stmp = conn.createStatement();
				
				String sql = "select functie_a from angajat, utilizator where id_utiliz_ang = id_utilizator and  utilizator.nume = '"+n+"' and utilizator.CNP = '"+CNP+"';";
				rs = stmp.executeQuery(sql);
				
				while(rs.next()){
					fctie = rs.getString("functie_a");
				}
			} catch (SQLException s) {
				System.out.println(s.getMessage());
			} catch (Exception e) {
				System.out.println(e.getMessage());
			} finally {
				try {
					if (stmp != null) {
						stmp.close();
					}
				} catch (SQLException se) {
					se.printStackTrace();
				}
			}
			return fctie;
		}	
		
		// getter pentru functia unui angajat:
		public String getFctieAng(String n, String CNP) {
			Statement stmp = null;
			ResultSet rs = null;
			String fctie = null;

			try {
				stmp = conn.createStatement();

				String sql = "select functie_a from angajat, utilizator where id_utiliz_ang = id_utilizator and  utilizator.nume = '"+n+"' and utilizator.CNP = '"+CNP+"';";
				rs = stmp.executeQuery(sql);

				while (rs.next()) {
					fctie = rs.getString("functie_a");
				}
				
			} catch (SQLException s) {
				System.out.println(s.getMessage());
			} catch (Exception e) {
				System.out.println(e.getMessage());
			} finally {
				try {
					if (stmp != null) {
						stmp.close();
					}
				} catch (SQLException se) {
					se.printStackTrace();
				}
			}
			return fctie;
		}
		
		// metoda de select a orarului generic:
		public String getVenitAngajat(String n, String p, String l) {
			Statement stm = null;
			ResultSet rs = null;
			String sal = null;
			String ore = null;
			String venit = null;
			
			String functie = null;
			String cost = null;
			String pr = null;

			try {

				stm = conn.createStatement();
				String sql = "select salariu_neg, nr_ore from angajat, utilizator where utilizator.nume = '" + n
						+ "' and utilizator.prenume = '" + p
						+ "' and utilizator.id_utilizator = angajat.id_utiliz_ang;";

				rs = stm.executeQuery(sql);

				while (rs.next()) {
					sal = rs.getString("salariu_neg");
					ore = rs.getString("nr_ore");
				}

				venit = new Float(Float.parseFloat(sal) * Float.parseFloat(ore)).toString();
				
				sql = "select functie_a from angajat, utilizator where id_utiliz_ang = id_utilizator and  utilizator.nume = '"+n+"' and utilizator.prenume = '"+p+"';";
				rs = stm.executeQuery(sql);
				
				while (rs.next()) {
					functie = rs.getString("functie_a");
				}
				
				if(functie.equals("medic") == true) {
					sql = "select procent_serv_med from medic, angajat, utilizator where id_ang_med = id_ang and id_utiliz_ang = id_utilizator and nume = '"+n+"' and prenume = '"+p+"';";
					rs = stm.executeQuery(sql);
					while (rs.next()) {
						pr = rs.getString("procent_serv_med");
					}
					
					sql = "select costul from bon_fiscal where nume_medic = '"+n+" "+p+"' and luna = '"+l+"';";
					rs = stm.executeQuery(sql);
					while (rs.next()) {
						cost = rs.getString("costul");
						if(cost != null) {
							venit = new Float((Float.parseFloat(cost) * Float.parseFloat(pr)) + Float.parseFloat(venit)).toString();
						}
					}
					
				}
				//System.out.println(venit);
				rs.close();

			} catch (SQLException s) {
				System.out.println(s.getMessage());
			} catch (Exception e) {
				System.out.println(e.getMessage());
			} finally {
				try {
					if (stm != null) {
						stm.close();
					}
				} catch (SQLException se) {
					se.printStackTrace();
				}
			}

			return venit;
		}
		
		// metoda de select a orarului generic:
		public Float getVenitPoliclinica(String id, String l) {
			Statement stm = null;
			ResultSet rs = null;
			ResultSet rs1 = null;
			String[] angN = new String[20];
			String[] angP = new String[20];
			String[] idU = new String[20];
			Float cost = new Float("0");
			Float profit = new Float("0");
			Float venitAngajati = new Float("0");

			try {
				stm = conn.createStatement();
				String sql = "select policlinica_utilizator_apartinere.id_utilizator_ap from policlinica_utilizator_apartinere where policlinica_utilizator_apartinere.id_policlinica_ap = '"
						+ id + "';";
				rs = stm.executeQuery(sql);
				int i = 0;
				while (rs.next()) {
					idU[i] = rs.getString("id_utilizator_ap");
					System.out.println(idU[i]);
					i++;
				}

				int k = 0;
				for (int j = 0; j < i; j++) {
					sql = "select utilizator.nume, utilizator.prenume from utilizator where utilizator.id_utilizator = '"
							+ idU[j] + "' ;";
					rs1 = stm.executeQuery(sql);
					while (rs1.next()) {
						angN[k] = rs1.getString("nume");
						angP[k] = rs1.getString("prenume");
						k++;
					}
				}

				System.out.println(angP.length);
				System.out.println(angN.length);

				for (int j = 0; j < k; j++) {
					System.out.println(angP[j] + " " + angN[j]);
					PreparedStatement es1 = conn
							.prepareStatement("" + "select * from bon_fiscal where bon_fiscal.nume_medic = '" + angN[j]
									+ " " + angP[j] + "' and bon_fiscal.luna = '" + l + "';");
					ResultSet rezultat = es1.executeQuery();
					while (rezultat.next()) {
						cost = cost + rezultat.getFloat("costul");
					}
				}

				System.out.println(cost);

				for (int j = 0; j < k; j++) {
					if (getVenitAngajat(angN[j], angP[j], l) != null) {
						venitAngajati = Float.parseFloat(getVenitAngajat(angN[j], angP[j], l)) + venitAngajati;
					}
				}

				System.out.println("Venit Angajati:" + venitAngajati);

				profit = cost - venitAngajati;

				System.out.println("Profit policlinica: " + profit);
				rs1.close();
				rs.close();

			} catch (SQLException s) {
				System.out.println(s.getMessage());
			} catch (Exception e) {
				System.out.println(e.getMessage());
			} finally {
				try {
					if (stm != null) {
						stm.close();
					}
				} catch (SQLException se) {
					se.printStackTrace();
				}
			}

			return profit;
		}
		
		// metoda de select a orarului generic:
		public Float getVenitPoliclinici(String l) {
			Statement stm = null;

			int[] idU = new int[20];
			Float profit = new Float("0");

			try {
				
				PreparedStatement es1 = conn.prepareStatement("" + "select * from policlinica;");
				ResultSet rezultat = es1.executeQuery();
				
				int contor = 0;
				
				while(rezultat.next()) {
					idU[contor] = rezultat.getInt("idPoliclinica");
					System.out.println(idU[contor]);
					contor++;
				}
				
				for(int i = 0; i < contor; i++) {
					profit = profit + getVenitPoliclinica(new Integer(idU[i]).toString(), l);
				}

				System.out.println("Profit policlinica: " + profit);

			} catch (SQLException s) {
				System.out.println(s.getMessage());
			} catch (Exception e) {
				System.out.println(e.getMessage());
			} finally {
				try {
					if (stm != null) {
						stm.close();
					}
				} catch (SQLException se) {
					se.printStackTrace();
				}
			}

			return profit;
		}
}
