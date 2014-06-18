
import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JComboBox;




public class GastosAnyo implements Serializable{
	private int anyo;
	//private GastosMes gastos [];
	private ArrayList <GastosMes> gastos = new ArrayList ();
	private int numMes;
	
	//creamos DB
	private Connection conexion = null; //maneja la conexion
	private Statement instruccion = null; //instruccion de consulta
	private ResultSet conjuntoResultados = null;// maneja los resultados
	
	public GastosAnyo(Connection conexion){
		numMes=0;
		anyo=2014;
		this.conexion=conexion;
		for(int i=0;i<numMes;i++);
		gastos.add(new GastosMes());
		
		
		/*gastos = new GastosMes[numMes];
		for(int i=0;i<numMes;i++)
		{
			gastos[i]=new GastosMes();
		}*/
	}
	public GastosAnyo(Connection conexion,int numero, int nombre){
		
		numMes=numero;
		anyo=nombre;
		for(int i=0;i<numMes;i++);
		gastos.add(new GastosMes());
		this.conexion=conexion;
		/*gastos=new GastosMes[numMes];
		for(int i=0;i<numMes;i++)
		{
			gastos[i]=new GastosMes();
		}*/
	}

	//Metodos GET y SET
	public int getanyo(){
		return anyo;
	}
	public void setanyo(int anyo){
		this.anyo=anyo;
	}
	//public GastosMes [] getGastosMes(){
		//return gastos;}
	
	
	public GastosMes getGastosMes(Integer posicion) {
		
		return gastos.get(posicion);
	}
	
	public int getnumMes(){
		return numMes;
	
}
	public void newGastosMes(){
		gastos.add(new GastosMes());
		numMes++;
	}
	
	public void deleteGastosMes(int posicion){
		gastos.remove(posicion);
	}
	public void newGastosMesBD(GastosMes gastos){
		try{
			//consulta la BBDD
			instruccion = (Statement) conexion.createStatement();
			//insercion en la base de datos
			String sql_inst="INSERT INTO GastosMes (comida,gasolina,ocio,servicios, otros)";
			sql_inst=sql_inst+"VALUES("+gastos.getcomida()+","+gastos.getgasolina()+","+gastos.getocio()+","+gastos.getservicios()+","+gastos.getotros()+")";
			
			instruccion.executeUpdate(sql_inst);
		}
		catch(SQLException exceptionSql)
		{
			exceptionSql.printStackTrace();
		}
	}
	public void leerGastosAnyo(int anyo,JComboBox<GastosMes>comboBox){
		try{
			//consulta la BBDD
			instruccion = (Statement) conexion.createStatement();
			conjuntoResultados = instruccion.executeQuery("SELECT * FROM gastosmes where numAnyo like "+anyo);
			conjuntoResultados.next();
			
			while(conjuntoResultados.next())
			{
				GastosMes mes=new GastosMes();
				mes.setanyo(anyo);
				mes.setmes((int)conjuntoResultados.getObject("numMes"));
				mes.setcomida((int)conjuntoResultados.getObject("comida"));
				comboBox.addItem(mes);
			}
			//almacenar liga
			//this.numMes=(int)conjuntoResultados.getObject("numMes");
			//this.anyo=(int)conjuntoResultados.getObject("anyo");
		}
		catch(SQLException exceptionSql){
			exceptionSql.printStackTrace();
		}//fin de catch
	}
}