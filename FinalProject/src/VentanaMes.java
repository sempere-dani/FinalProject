import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class VentanaMes extends JFrame {

	private JPanel contentPane;
	private JTextField tmes;
	private JTextField tcomida;
	private JTextField tgasolina;
	private JTextField tocio;
	private JTextField tservicios;
	private JTextField totros;
	private GastosMes gastos;
	private ObjectOutputStream salida;
	private ObjectInputStream entrada;
	
	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaMes frame = new VentanaMes();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the frame.
	 */
	public VentanaMes(GastosMes gastosModificar) {
		//asignar gastos
		gastos=gastosModificar;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblMes = new JLabel("Mes");
		lblMes.setBounds(40, 40, 46, 14);
		contentPane.add(lblMes);
		
		JLabel lblComida = new JLabel("Comida");
		lblComida.setBounds(40, 65, 73, 14);
		contentPane.add(lblComida);
		
		JLabel lblGasolina = new JLabel("gasolina");
		lblGasolina.setBounds(40, 93, 93, 14);
		contentPane.add(lblGasolina);
		
		JLabel lblOcio = new JLabel("ocio");
		lblOcio.setBounds(40, 118, 46, 14);
		contentPane.add(lblOcio);
		
		tmes = new JTextField();
		tmes.setBounds(143, 37, 86, 20);
		contentPane.add(tmes);
		tmes.setColumns(10);
		
		tcomida = new JTextField();
		tcomida.setColumns(10);
		tcomida.setBounds(143, 62, 86, 20);
		contentPane.add(tcomida);
		
		tgasolina = new JTextField();
		tgasolina.setColumns(10);
		tgasolina.setBounds(143, 90, 86, 20);
		contentPane.add(tgasolina);
		
		tocio = new JTextField();
		tocio.setColumns(10);
		tocio.setBounds(143, 115, 86, 20);
		contentPane.add(tocio);
		
		JLabel lblNewLabel = new JLabel("servicios");
		lblNewLabel.setBounds(40, 149, 93, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblOtros = new JLabel("otros");
		lblOtros.setBounds(40, 174, 46, 14);
		contentPane.add(lblOtros);
		
		tservicios = new JTextField();
		tservicios.setBounds(143, 146, 86, 20);
		contentPane.add(tservicios);
		tservicios.setColumns(10);
		
		totros = new JTextField();
		totros.setColumns(10);
		totros.setBounds(143, 171, 86, 20);
		contentPane.add(totros);
		
		JButton btnGuardarF = new JButton("GuardarEnFichero");
		btnGuardarF.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				gastos.setcomida(Integer.valueOf(tcomida.getText()));
				gastos.setocio(Integer.valueOf(tocio.getText()));
				gastos.setservicios(Integer.valueOf(tservicios.getText()));
				gastos.setotros(Integer.valueOf(totros.getText()));
				gastos.setnombreMes(tmes.getText());
				gastos.setgasolina(Integer.valueOf(tgasolina.getText()));
				guardarEnFichero();
			}
		});
		btnGuardarF.setBounds(140, 215, 89, 23);
		contentPane.add(btnGuardarF);
		
		JButton btnLeer = new JButton("Leer");
		btnLeer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				recuperarFichero();//metodo recuperar fichero
				tmes.setText(gastos.getnombreMes());
				tcomida.setText(String.valueOf(gastos.getcomida()));
				tocio.setText(String.valueOf(gastos.getocio()));
				tservicios.setText(String.valueOf(gastos.getservicios()));
				totros.setText(String.valueOf(gastos.getotros()));
				tgasolina.setText(String.valueOf(gastos.getgasolina()));
				
			}
		});
		btnLeer.setBounds(248, 215, 89, 23);
		contentPane.add(btnLeer);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				guardarGastosMes();
				
			}
			
		});
		btnGuardar.setBounds(260, 24, 89, 60);
		contentPane.add(btnGuardar);
		//leerGastosMes(); 
	}
	//Guarda los datos GastosMes
	private void guardarGastosMes(){
		gastos.setcomida(Integer.valueOf(tcomida.getText()));
		gastos.setgasolina(Integer.valueOf(tgasolina.getText()));
		gastos.setnombreMes(tmes.getText());
		gastos.setocio(Integer.valueOf(tocio.getText()));
		gastos.setotros(Integer.valueOf(totros.getText()));
		gastos.setservicios(Integer.valueOf(tservicios.getText()));
		}
	//Cargar datos mes
	private void leerGastosMes(){
		tcomida.setText(String.valueOf(gastos.getcomida()));
		tgasolina.setText(String.valueOf(gastos.getgasolina()));
		tmes.setText(gastos.getnombreMes());
		tocio.setText(String.valueOf(gastos.getocio()));
		totros.setText(String.valueOf(gastos.getotros()));
		tservicios.setText(String.valueOf(gastos.getservicios()));
	}
	private void guardarEnFichero(){
		
		try//abre el archivo
		{
			salida = new ObjectOutputStream(new FileOutputStream("gastos.ser"));
						
			salida.writeObject(gastos);//envia el registro como salida
			if(salida !=null)
				salida.close();
		}//fin de try
		catch (IOException ioException){
			System.err.println("Error al escribir el archivo");
		}//fin del catch
		
		}//fin del metodo GuardarEnFichero
	
	private void recuperarFichero(){
		try//leer el archivo
		{
			entrada = new ObjectInputStream(new FileInputStream("gastos.ser"));
						
			gastos=(GastosMes)entrada.readObject();//envia el registro como salida
			if(salida !=null)
				salida.close();
		}//fin de try
		catch (IOException ioException){
			System.err.println("Error al escribir el archivo");
		}
		catch(ClassNotFoundException clException){
			System.err.println("Error al abrir el  archivo");
		
		}//fin del catch
	}//fin del metodo ecuperarFichero
}
