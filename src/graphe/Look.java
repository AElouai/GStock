package graphe;

import Main.*;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JList;

import java.awt.List;
import java.awt.Button;
import java.awt.TextField;

import javax.swing.JLabel;

import java.awt.Choice;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Vector;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JTextField;

import Main.DBinit;
import MainMagasine.Categorier;
import MainMagasine.Produit;
import MainMagasine.Uniter;

public class Look {

	private JFrame frame;
	private JComboBox comboBox;

	/**
	 * Launch the application.
	 */
	public static void startWindows() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Look window = new Look();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Look() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 664, 465);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		TextField textField = new TextField();
		textField.setBounds(10, 233, 271, 44);
		frame.getContentPane().add(textField);
		
		JLabel lblNewLabel = new JLabel("Uniter");
		lblNewLabel.setBounds(287, 233, 75, 44);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Categorier   :");
		lblNewLabel_1.setBounds(20, 70, 145, 38);
		frame.getContentPane().add(lblNewLabel_1);
		
//----update ComBox
		initialize_ComboBox();
//----update F		
//----update List
		initialize_List();
//----update F		
		JList list = new JList();
		list.setBounds(372, 70, 266, 346);
		frame.getContentPane().add(list);
		
		JButton btnNewButton = new JButton("Ajouter");
		btnNewButton.setBounds(10, 362, 115, 44);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Enlever");
		btnNewButton_1.setBounds(247, 362, 115, 44);
		frame.getContentPane().add(btnNewButton_1);
		
		JLabel lblNewLabel_2 = new JLabel("Produit Nam   :");
		lblNewLabel_2.setBounds(20, 119, 145, 32);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Quantite Disponible  :");
		lblNewLabel_3.setBounds(20, 162, 145, 20);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("New label");
		lblNewLabel_4.setBounds(175, 165, 163, 14);
		frame.getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("New label");
		lblNewLabel_5.setBounds(175, 128, 163, 14);
		frame.getContentPane().add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("New label");
		lblNewLabel_6.setBounds(175, 82, 163, 14);
		frame.getContentPane().add(lblNewLabel_6);
	}
//------------------ initialize THE List to Show the data from the option in comboBox
private void initialize_List() {
		// TODO Auto-generated method stub
		
	}

//------------------ initialize THE comboBox to get the data
	private void initialize_ComboBox() {
		 Vector comboBoxItems =new Vector();
		 java.util.List<Categorier> LCategorier = DBinit.CategorierList;
		 for(Categorier cat : LCategorier){
			 comboBoxItems.add(cat.getNomCategorier()); 
		 }		 
		 final DefaultComboBoxModel model = new DefaultComboBoxModel(comboBoxItems);
		comboBox = new JComboBox(model);
		comboBox.setBounds(372, 39, 266, 20);
		frame.getContentPane().add(comboBox);

	}
}
