
public class Principal {
		//Clase que lanza la aplicacion
	
	public static void main(String[] args) {
		
		GastosMes gastos=new GastosMes("",0,0,0,0,0);
		GastosMes gastos2=new GastosMes();
		
		VentanaMes frame = new VentanaMes(gastos);
		frame.setVisible(true);
	}

}
