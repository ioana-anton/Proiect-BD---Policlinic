

public class ConexiuneProiectMain {
	
	
	
	public static void main(String[] args) {
		PoliclinicaModel m = new PoliclinicaModel();
		PoliclinicaView v = new PoliclinicaView(m);
		PoliclinicaView2 v2 = new PoliclinicaView2();
		PoliclinicaView3 v3 = new PoliclinicaView3();
		PoliclinicaView4 v4 = new PoliclinicaView4();
		PoliclinicaView5 v5 = new PoliclinicaView5();
		PoliclinicaView6 v6 = new PoliclinicaView6();
		PoliclinicaView7 v7 = new PoliclinicaView7();
		PoliclinicaView8 v8 = new PoliclinicaView8();
		PoliclinicaView9 v9 = new PoliclinicaView9();
		PoliclinicaView10 v10 = new PoliclinicaView10();
		PoliclinicaView11 v11 = new PoliclinicaView11();
		PoliclinicaView12 v12 = new PoliclinicaView12();
		PoliclinicaView13 v13 = new PoliclinicaView13();
		PoliclinicaController c = new PoliclinicaController(m, v, v2, v3, v4, v5, v6, v7, v8, v9, v10, v11, v12, v13);
		v.setVisible(true);
		//v7.setVisible(true);
		//v.f.setVisible(true);
		//v3.setVisible(true);
		//v4.setVisible(true);
		//v2.setVisible(true);
		//v5.setVisible(true);
		//v6.setVisible(true);
	}
	
}

