package mx.com.cursodia.java21.semana3;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.DefaultTableModel;

import com.jtattoo.plaf.BaseTabbedPaneUI.TabbedPaneLayout;

import mx.com.cursodia.java21.semana3.prototipoVistas.VistaAccesorios;

public class ControladorCelulares implements ActionListener
{
	VistaTabbed VT;
	vistaCelulares vCel;
	Modelo MOD;
	public ControladorCelulares(VistaTabbed vT, vistaCelulares vcel,Modelo mOD) 
	{
		VT = vT;
		vCel = vcel;
		MOD = mOD;
	}
	
	public void lanzarVista()
	{
		try {
			UIManager.setLookAndFeel("com.jtattoo.plaf.luna.LunaLookAndFeel");
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		EventQueue.invokeLater(new Runnable()
		{
			
			@Override
			public void run()
			{
				VT.crearGUI();
				VT.setVisible(true);
				VT.vistaLanzada = true;
				
				System.out.println("Vista inicializada correctamente");
				
				agregarListeners();
			}
		});
	}
	
	
	
	private void agregarListeners()
	{
//		while(!VT.vistaLanzada)
//		{
//			System.out.println("Cargando...");
//		}
//		System.out.println("Conexion exitosa.");
//		VT.btnMostrar.addActionListener(this);
		
		SwingUtilities.invokeLater(() -> {
		        VT.btnMostrar.addActionListener(e -> mostrarCelulares());
		        VT.btnAgregar.addActionListener(e -> agregarCelulares());
		        VT.btnBuscar.addActionListener(e -> buscarCelulares());
		        VT.tabla.getSelectionModel().addListSelectionListener(e -> {
		       	 if(!e.getValueIsAdjusting())
		       	 {
		       		 seleccionarFila();
		       	 }
		        });
		        VT.btnActualizar.addActionListener(e -> actualizarCelulares());
		        VT.btnEliminar.addActionListener(e -> eliminarCelulares());
		        
		        System.out.println("Listeners agregados");
		    });
	}

	void mostrarCelulares()
	{
		DefaultTableModel modelo = (DefaultTableModel) VT.tabla.getModel();
		DefaultTableModel modArticulos = MOD.mostrarCelulares(modelo);
		VT.tabla.setModel(modArticulos);
		JOptionPane.showMessageDialog(null, "Articulos mostrados!");
		VT.txtCve_cel.setText(Integer.toString(MOD.ultimaClave));
		
	}
	
	void agregarCelulares()
	{
		String cve_cel = VT.txtCve_cel.getText();
		String nom_cel = VT.txtNom_cel.getText();
		String cvemarca_cel = VT.txtCve_marca.getText();
		String ram_cel = (String) VT.cbbRam_cel.getSelectedItem();
		String rom_cel = (String) VT.cbbRom_cel.getSelectedItem();
		String imei_cel = VT.txtIMEI.getText();
		String inv_cel = VT.txtInv_cel.getText();
		String pre_cel = VT.txtPre_cel.getText();
		
		MOD.agregarCelulares(cve_cel, nom_cel, cvemarca_cel, ram_cel, rom_cel, imei_cel, inv_cel, pre_cel);
		
		VT.txtCve_cel.setText(Integer.toString(MOD.ultimaClave));
		
	}
	
	void buscarCelulares()
	{
		String cve_cel = VT.txtCve_cel.getText();
		
		DefaultTableModel modelo = (DefaultTableModel) VT.tabla.getModel();
		modelo.setRowCount(0);
		DefaultTableModel modArticulos = MOD.buscarCelulares(cve_cel, modelo);
		
		VT.tabla.setModel(modArticulos);
		JOptionPane.showMessageDialog(null, "Articulos mostrados!");
	}
	
	void seleccionarFila()
	{
		int filaSeleccionada = VT.tabla.getSelectedRow();
		
		if(filaSeleccionada == -1) return;
		
		if(filaSeleccionada >= 0)
		{
			DefaultTableModel modelo = (DefaultTableModel) VT.tabla.getModel();
			
			VT.txtCve_cel.setText(modelo.getValueAt(filaSeleccionada, 0).toString());
			VT.txtNom_cel.setText(modelo.getValueAt(filaSeleccionada, 1).toString());
			VT.txtCve_marca.setText(modelo.getValueAt(filaSeleccionada, 2).toString());
			VT.cbbRam_cel.setSelectedItem(modelo.getValueAt(filaSeleccionada, 3).toString());
			VT.cbbRom_cel.setSelectedItem(modelo.getValueAt(filaSeleccionada, 4).toString());
			VT.txtIMEI.setText(modelo.getValueAt(filaSeleccionada, 5).toString());
			VT.txtInv_cel.setText(modelo.getValueAt(filaSeleccionada, 6).toString());
			VT.txtPre_cel.setText(modelo.getValueAt(filaSeleccionada, 7).toString());
		}
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		// TODO Auto-generated method stub
		
	}
	
	void actualizarCelulares() 
	{
		String cve_cel = VT.txtCve_cel.getText();
		String nom_cel = VT.txtNom_cel.getText();
		String cvemarca_cel = VT.txtCve_marca.getText();
		String ram_cel = (String) VT.cbbRam_cel.getSelectedItem();
		String rom_cel = (String) VT.cbbRom_cel.getSelectedItem();
		String imei_cel = VT.txtIMEI.getText();
		String inv_cel = VT.txtInv_cel.getText();
		String pre_cel = VT.txtPre_cel.getText();
		
		MOD.actualizarCelulares(cve_cel, nom_cel, cvemarca_cel, ram_cel, rom_cel, imei_cel, inv_cel, pre_cel);
		
		VT.txtCve_cel.setText(Integer.toString(MOD.ultimaClave));
	}
	
	void eliminarCelulares()
	{
		String cve_cel = VT.txtCve_cel.getText();
		
		MOD.eliminarCelulares(cve_cel);
		
		VT.txtCve_cel.setText(Integer.toString(MOD.ultimaClave));
	}
	
	
}
