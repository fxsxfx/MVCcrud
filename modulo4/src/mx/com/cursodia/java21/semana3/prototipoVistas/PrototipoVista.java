package mx.com.cursodia.java21.semana3.prototipoVistas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JScrollBar;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class PrototipoVista extends JFrame
{

	private JPanel contentPane;
	private JTextField txtCve_cel;
	private JTextField txtNom_cel;
	private JTextField txtCve_marca;
	private JTextField txtIMEI;
	private JTextField txtInv_cel;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				try {
					PrototipoVista frame = new PrototipoVista();
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
	public PrototipoVista() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 829, 579);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnMostrar = new JButton("Mostrar");
		btnMostrar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnMostrar.setBounds(187, 161, 137, 34);
		contentPane.add(btnMostrar);
		
		JPanel panel = new JPanel();
		panel.setBounds(64, 207, 677, 311);
		contentPane.add(panel);
		
		JButton btnAdd = new JButton("Agregar");
		btnAdd.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnAdd.setBounds(39, 161, 137, 34);
		contentPane.add(btnAdd);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnBuscar.setBounds(335, 161, 137, 34);
		contentPane.add(btnBuscar);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnEliminar.setBounds(631, 161, 137, 34);
		contentPane.add(btnEliminar);
		
		JButton btnActualizar = new JButton("Actualizar");
		btnActualizar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnActualizar.setBounds(483, 161, 137, 34);
		contentPane.add(btnActualizar);
		
		JLabel lblNom_acc = new JLabel("Nombre:");
		lblNom_acc.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNom_acc.setBounds(208, 30, 78, 16);
		contentPane.add(lblNom_acc);
		
		JLabel lblCve_cel = new JLabel("Clave:");
		lblCve_cel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCve_cel.setBounds(39, 30, 78, 16);
		contentPane.add(lblCve_cel);
		
		txtCve_cel = new JTextField();
		txtCve_cel.setBounds(86, 28, 104, 20);
		contentPane.add(txtCve_cel);
		txtCve_cel.setColumns(10);
		
		txtNom_cel = new JTextField();
		txtNom_cel.setBounds(281, 29, 445, 20);
		contentPane.add(txtNom_cel);
		txtNom_cel.setColumns(10);
		
		JLabel lblCve_marca = new JLabel("Clave de marca:");
		lblCve_marca.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCve_marca.setBounds(39, 60, 137, 16);
		contentPane.add(lblCve_marca);
		
		txtCve_marca = new JTextField();
		txtCve_marca.setColumns(10);
		txtCve_marca.setBounds(158, 59, 104, 20);
		contentPane.add(txtCve_marca);
		
		JLabel lblRam_cel = new JLabel("RAM:");
		lblRam_cel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblRam_cel.setBounds(281, 61, 43, 16);
		contentPane.add(lblRam_cel);
		
		JComboBox cbbRam_cel = new JComboBox();
		cbbRam_cel.setModel(new DefaultComboBoxModel(new String[] {"4", "8", "12", "16"}));
		cbbRam_cel.setBounds(328, 59, 70, 20);
		contentPane.add(cbbRam_cel);
		
		JComboBox cbbRom_cel_1 = new JComboBox();
		cbbRom_cel_1.setModel(new DefaultComboBoxModel(new String[] {"32", "64", "128", "256", "512"}));
		cbbRom_cel_1.setBounds(471, 59, 70, 20);
		contentPane.add(cbbRom_cel_1);
		
		JLabel lblRom_cel_1 = new JLabel("ROM:");
		lblRom_cel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblRom_cel_1.setBounds(424, 61, 43, 16);
		contentPane.add(lblRom_cel_1);
		
		JLabel lblIMEI = new JLabel("IMEI:");
		lblIMEI.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblIMEI.setBounds(39, 89, 78, 16);
		contentPane.add(lblIMEI);
		
		txtIMEI = new JTextField();
		txtIMEI.setColumns(10);
		txtIMEI.setBounds(86, 88, 445, 20);
		contentPane.add(txtIMEI);
		
		JLabel lblInv_cel = new JLabel("En stock:");
		lblInv_cel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblInv_cel.setBounds(39, 121, 78, 16);
		contentPane.add(lblInv_cel);
		
		txtInv_cel = new JTextField();
		txtInv_cel.setColumns(10);
		txtInv_cel.setBounds(112, 120, 104, 20);
		contentPane.add(txtInv_cel);
		
		JLabel lblPre_cel = new JLabel("Precio:");
		lblPre_cel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPre_cel.setBounds(237, 121, 78, 16);
		contentPane.add(lblPre_cel);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(295, 120, 104, 20);
		contentPane.add(textField_1);
	}
}
