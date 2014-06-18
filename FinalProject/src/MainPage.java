import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JTextField;


public class MainPage extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private GastosAnyo anyo;
	private VentanaAnyo frameMes;
	
	
	//conexion con la BBDD
	
	Connection conexion = null; //maneja la conexion
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainPage frame = new MainPage();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainPage() {
		
		//Conectamos con nuestra BBDD
		try{
			Class.forName("com.mysql.jdbc.Driver");
			
			//establece la conexion
			conexion = DriverManager.getConnection("jdbc:mysql://localhost/FinalPoject","root","");
			
		}
		catch(SQLException exceptionSql){
			exceptionSql.printStackTrace();
		}//fin de catch
		catch (ClassNotFoundException noEncontroClase)
		{
			noEncontroClase.printStackTrace();
		}
		
		
		//Creamos el anyo
		anyo=new GastosAnyo(conexion);
		//anyo.leerGastosAnyo();
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Administrador", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(24, 11, 367, 138);
		contentPane.add(panel);
		
		JButton btnNewButton_2 = new JButton("Administrar");
		btnNewButton_2.setBounds(48, 104, 124, 23);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(textField.getText().equals(""))
				{
					JOptionPane.showMessageDialog(null, "se debe introducir un año");
				}
				else
				{
					openMesWindow(textField.getText(),anyo);
				}
				//openMesWindow(anyo);
				
			}
		});
		panel.setLayout(null);
		panel.add(btnNewButton_2);
		
		textField = new JTextField();
		textField.setBounds(48, 68, 155, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblAo = new JLabel("A\u00D1O");
		lblAo.setBounds(93, 31, 58, 14);
		panel.add(lblAo);
		
		JButton btnQuitar = new JButton("-");
		btnQuitar.setBounds(68, 216, 131, 23);
		contentPane.add(btnQuitar);
		
		JButton btnAñadir = new JButton("+");
		btnAñadir.setBounds(68, 171, 131, 23);
		contentPane.add(btnAñadir);
	}
	
	private void openMesWindow(String AnyoAdmin,GastosAnyo anyo){
		anyo.setanyo(Integer.valueOf(AnyoAdmin));
		frameMes = new VentanaAnyo(anyo);
		frameMes.setVisible(true);
		frameMes.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
}
