
public class Principal {
		//Clase que lanza la aplicacion
	
	public static void main(String[] args) {
		
		GastosAnyo mes=new GastosAnyo();
		
		
		VentanaAnyo frame = new VentanaAnyo(mes);
		frame.setVisible(true);
	}

}
