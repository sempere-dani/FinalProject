import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class VentanaAnyo extends JFrame {

	private JPanel contentPane;
	private JTextField NombreMes;
	private JTextField NumMes;
	private JTextField GastoModificar;
	private GastosAnyo mes;
	private GastosMes gastos;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaAnyo frame = new VentanaAnyo();
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
	public VentanaAnyo(GastosAnyo anyoModificar){
		mes=anyoModificar;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel anyo = new JLabel("A\u00F1o");
		anyo.setBounds(36, 40, 95, 14);
		contentPane.add(anyo);
		
		JLabel lblNmeroMes = new JLabel("N\u00FAmero Mes");
		lblNmeroMes.setBounds(206, 40, 95, 14);
		contentPane.add(lblNmeroMes);
		
		JLabel lblGastosMesModificar = new JLabel("Gastos Mes Modificar");
		lblGastosMesModificar.setBounds(36, 138, 128, 14);
		contentPane.add(lblGastosMesModificar);
		
		NombreMes = new JTextField();
		NombreMes.setBounds(36, 65, 86, 20);
		contentPane.add(NombreMes);
		NombreMes.setColumns(10);
		
		NumMes = new JTextField();
		NumMes.setEditable(false);
		NumMes.setText("12");
		NumMes.setColumns(10);
		NumMes.setBounds(199, 65, 86, 20);
		contentPane.add(NumMes);
		
		GastoModificar = new JTextField();
		GastoModificar.setColumns(10);
		GastoModificar.setBounds(45, 172, 86, 20);
		contentPane.add(GastoModificar);
		
		JButton btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				VentanaMes frameGastosMes = new VentanaMes(mes.getGastosMes(Integer.valueOf(GastoModificar.getText())));
				frameGastosMes.setVisible(true);
				frameGastosMes.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
		});
		btnModificar.setBounds(42, 217, 89, 23);
		contentPane.add(btnModificar);
	}
}
