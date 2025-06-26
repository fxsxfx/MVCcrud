package mx.com.cursodia.java21.semana3.prototipoVistas;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class VistaAccesorios extends JFrame
{

	private JPanel contentPane;
	private JTextField txtCve_acc;
	private JTextField txtNom_acc;
	private JTextField txtCve_marca_acc;
	private JTextField txtInv_acc;
	private JTextField txtPre_acc;

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
					VistaAccesorios frame = new VistaAccesorios();
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
	public VistaAccesorios() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 829, 579);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnMostrar = new JButton("Mostrar");
		btnMostrar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnMostrar.setBounds(187, 101, 137, 34);
		contentPane.add(btnMostrar);
		
		JPanel panel = new JPanel();
		panel.setBounds(64, 161, 677, 357);
		contentPane.add(panel);
		
		JButton btnAdd = new JButton("Agregar");
		btnAdd.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnAdd.setBounds(39, 101, 137, 34);
		contentPane.add(btnAdd);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnBuscar.setBounds(335, 101, 137, 34);
		contentPane.add(btnBuscar);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnEliminar.setBounds(631, 101, 137, 34);
		contentPane.add(btnEliminar);
		
		JButton btnActualizar = new JButton("Actualizar");
		btnActualizar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnActualizar.setBounds(483, 101, 137, 34);
		contentPane.add(btnActualizar);
		
		JLabel lblNom_acc = new JLabel("Nombre:");
		lblNom_acc.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNom_acc.setBounds(208, 30, 78, 16);
		contentPane.add(lblNom_acc);
		
		JLabel lblCve_acc = new JLabel("Clave:");
		lblCve_acc.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCve_acc.setBounds(39, 30, 78, 16);
		contentPane.add(lblCve_acc);
		
		txtCve_acc = new JTextField();
		txtCve_acc.setBounds(86, 28, 104, 20);
		contentPane.add(txtCve_acc);
		txtCve_acc.setColumns(10);
		
		txtNom_acc = new JTextField();
		txtNom_acc.setBounds(281, 29, 445, 20);
		contentPane.add(txtNom_acc);
		txtNom_acc.setColumns(10);
		
		JLabel lblCve_marca = new JLabel("Clave de marca:");
		lblCve_marca.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCve_marca.setBounds(39, 60, 137, 16);
		contentPane.add(lblCve_marca);
		
		txtCve_marca_acc = new JTextField();
		txtCve_marca_acc.setColumns(10);
		txtCve_marca_acc.setBounds(158, 59, 104, 20);
		contentPane.add(txtCve_marca_acc);
		
		JLabel lblInv_acc = new JLabel("En stock:");
		lblInv_acc.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblInv_acc.setBounds(291, 57, 78, 16);
		contentPane.add(lblInv_acc);
		
		txtInv_acc = new JTextField();
		txtInv_acc.setColumns(10);
		txtInv_acc.setBounds(364, 56, 104, 20);
		contentPane.add(txtInv_acc);
		
		JLabel lblPre_acc = new JLabel("Precio:");
		lblPre_acc.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPre_acc.setBounds(489, 57, 78, 16);
		contentPane.add(lblPre_acc);
		
		txtPre_acc = new JTextField();
		txtPre_acc.setColumns(10);
		txtPre_acc.setBounds(547, 56, 104, 20);
		contentPane.add(txtPre_acc);
	}

}
