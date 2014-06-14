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
import javax.swing.JComboBox;


public class VentanaAnyo extends JFrame {

	private JPanel contentPane;
	private JTextField NombreMes;
	private JTextField NumMes;
	private GastosAnyo mes;
	private GastosMes gastos;
	private VentanaMes frameGastosMes;
	private JComboBox<GastosMes> comboBox;

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
		
		JLabel lblGastosMesModificar = new JLabel("Gastos Mes ");
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
		
		JButton btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				openGastosMesWindow(mes.getGastosMes(comboBox.getSelectedIndex()),true);
				
				//VentanaMes frameGastosMes = new VentanaMes(mes.getGastosMes(Integer.valueOf(gastosModificar.getText())));
				//frameGastosMes.setVisible(true);
				//frameGastosMes.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
		});
		btnModificar.setBounds(42, 217, 89, 23);
		contentPane.add(btnModificar);
		
		 comboBox = new JComboBox<GastosMes>();//pasamos los GastosMes
		comboBox.setBounds(41, 163, 90, 20);
		contentPane.add(comboBox);
		
		JButton btnMas = new JButton("+");
		btnMas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				mes.newGastosMes();//creamos un nuevo gasto
				openGastosMesWindow(mes.getGastosMes(mes.getnumMes()-1),false);
			}
		});
		btnMas.setBounds(142, 217, 54, 23);
		contentPane.add(btnMas);
		
		JButton btnMenos = new JButton("-");
		btnMenos.setBounds(212, 217, 54, 23);
		contentPane.add(btnMenos);
	}
	
	private void openGastosMesWindow(GastosMes gastos,boolean modifica){
		frameGastosMes = new VentanaMes(gastos,this.comboBox,modifica,this.mes);
		frameGastosMes.setVisible(true);
		frameGastosMes.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
}
