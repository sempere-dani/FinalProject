
import java.io.Serializable;


public class GastosAnyo implements Serializable{
	private int anyo;
	private GastosMes gastos [];
	private int numMes;
	
	public GastosAnyo(){
		numMes=12;
		anyo=2014;
		gastos = new GastosMes[numMes];
		for(int i=0;i<numMes;i++)
		{
			gastos[i]=new GastosMes();
		}
	}
	/*public GastosAnyo(int numero, int nombre){
		
		numMes=numero;
		anyo=nombre;
		mes=new GastosMes[numMes];
		for(int i=0;i<numMes;i++)
		{
			mes[i]=new GastosMes();
		}
	}*/

	//Metodos GET y SET
	public int getanyo(){
		return anyo;
	}
	public void setanyo(String nombreMes){
		this.anyo=anyo;
	}
	public GastosMes [] getGastosMes(){
		return gastos;
	}
	public GastosMes getGastosMes(Integer valueOf) {
		
		return null;
	}
	
	public int getnumMes(){
		return numMes;
	
}
}