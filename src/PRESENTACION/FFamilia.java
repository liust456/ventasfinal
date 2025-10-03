package PRESENTACION;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import ENTIDADES.Familia;
import LOGICA.LFamilia;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JScrollPane;

public class FFamilia extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtIdFamilia;
	private JTextField txtNombre;
	private JTextField txtDescripcion;
	private JButton btnModificar;
	private JButton btnBorrar;
	private JScrollPane scrollPane;
	private JTable grilla;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FFamilia frame = new FFamilia();
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
	public FFamilia() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 489, 374);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtIdFamilia = new JTextField();
		txtIdFamilia.setBounds(10, 11, 430, 20);
		contentPane.add(txtIdFamilia);
		txtIdFamilia.setColumns(10);
		
		txtNombre = new JTextField();
		txtNombre.setColumns(10);
		txtNombre.setBounds(10, 49, 430, 20);
		contentPane.add(txtNombre);
		
		txtDescripcion = new JTextField();
		txtDescripcion.setColumns(10);
		txtDescripcion.setBounds(10, 91, 430, 20);
		contentPane.add(txtDescripcion);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				guardar();
				cargar();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				
			}
		});
		btnGuardar.setBounds(10, 149, 89, 23);
		contentPane.add(btnGuardar);
		
		btnModificar = new JButton("Modificar");
		btnModificar.setBounds(151, 149, 89, 23);
		contentPane.add(btnModificar);
		
		btnBorrar = new JButton("Borrar");
		btnBorrar.setBounds(295, 149, 89, 23);
		contentPane.add(btnBorrar);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(55, 223, 356, 86);
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
		new LFamilia().guardar(new Familia(0, txtNombre.getText(), txtDescripcion.getText()));
		
	}
	
	private void cargar() throws SQLException {
		String[] titulos={"ID", "NOMBRE", "DESCRIPCIÓN"};
		DefaultTableModel modelTable=new DefaultTableModel(null, titulos);
		ArrayList<Familia> familias=new LFamilia().cargar();
		for (Familia fam : familias) {
			Object[] fila= {fam.getIdfamilia(), fam.getNombre(), fam.getDescripcion()};
			modelTable.addRow(fila);
		}
		grilla.setModel(modelTable);
	}
}
