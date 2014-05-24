import java.io.Serializable;


public class GastosMes implements Serializable {
	
	//atributos GastoMes
	private String nombreMes;
	private int comida;
	private int gasolina;
	private int ocio;
	private int servicios;
	private int otros;
	
	public GastosMes(String month,int food,int gas,int freeTime,int serv,int others){
		
		month="enero";
		food=100;
		gas=50;
		freeTime=150;
		serv=175;
		others=40;
		
	}
	
	
}
