import java.io.Serializable;


public class GastosMes implements Serializable {
	
	//atributos GastoMes
	private String nombreMes;
	private int comida;
	private int gasolina;
	private int ocio;
	private int servicios;
	private int otros;
	
	public GastosMes(String mes,int gastoComida,int gastoGasolina,int gastoOcio,int Gastoserv,int GastoOtros){
		
		nombreMes=mes;
		comida=gastoComida;
		gasolina=gastoGasolina;
		ocio=gastoOcio;
		servicios=Gastoserv;
		otros=GastoOtros;
		
	}
	public GastosMes(){
		nombreMes="";
		comida=0;
		gasolina=0;
		ocio=0;
		servicios=0;
		otros=0;
	}
		
		
	
	
	public String getnombreMes(){
		return nombreMes;
	}
	public void setnombreMes(String nombreMes){
		this.nombreMes=nombreMes;
	}
	public int getcomida(){
		return comida;
	}
	public void setcomida(int comida){
		this.comida=comida;
	}
	public int getocio(){
		return gasolina;
	}
	public void setocio(int ocio){
		this.ocio=ocio;
	}
	public int getgasolina(){
		return gasolina;
	}
	public void setgasolina(int gasolina){
		this.gasolina=gasolina;
	}
	public int getservicios(){
		return servicios;
	}
	public void setservicios(int servicios){
		this.servicios=servicios;
	}
	public int getotros(){
		return otros;
	}
	public void setotros(int otros){
		this.otros=otros;
	}
}
