package PRESENTACION;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import ENTIDADES.Cliente;
import ENTIDADES.Familia;
import LOGICA.LCliente;
import LOGICA.LFamilia;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;
import java.sql.SQLException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class FClientes extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtEdad;
	private JTextField txtDni;
	private JTextField txtApellidos;
	private JTextField txtNombres;
	

	private JTable grilla;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FClientes frame = new FClientes();
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
	public FClientes() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtNombres = new JTextField();
		txtNombres.setBounds(10, 11, 86, 20);
		contentPane.add(txtNombres);
		txtNombres.setColumns(10);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					guardar();
					cargar();
				} catch (Exception e2) {
					e2.printStackTrace();

				}
				
			}
		});
		btnGuardar.setBounds(205, 66, 89, 23);
		contentPane.add(btnGuardar);
		
		txtApellidos = new JTextField();
		txtApellidos.setBounds(10, 36, 86, 20);
		contentPane.add(txtApellidos);
		txtApellidos.setColumns(10);
		
		txtDni = new JTextField();
		txtDni.setBounds(10, 67, 86, 20);
		contentPane.add(txtDni);
		txtDni.setColumns(10);
		
		txtEdad = new JTextField();
		txtEdad.setBounds(10, 98, 86, 20);
		contentPane.add(txtEdad);
		txtEdad.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(69, 145, 355, 105);
		contentPane.add(scrollPane);
		
		grilla = new JTable();
		scrollPane.setViewportView(grilla);
		try {
			cargar();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	private void guardar() throws SQLException {
		new LCliente().guardar(new Cliente(0, txtNombres.getText(), txtApellidos.getText(), txtDni.getText(), Integer.parseInt(txtEdad.getText())));
		
	}
	
	private void cargar() throws SQLException {
		String[] titulos={"ID", "NOMBREs", "APELLIDOS", "DNI","EDAD"};
		DefaultTableModel modelTable=new DefaultTableModel(null, titulos);
		ArrayList<Cliente> clientes=new LCliente().cargar();
		for (Cliente cli : clientes) {
			Object[] fila= {cli.getIdcliente(), cli.getNombres(), cli.getApellidos(), cli.getDni(), cli.getEdad()};
			modelTable.addRow(fila);
		}
		grilla.setModel(modelTable);
	}

	
}
