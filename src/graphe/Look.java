package graphe;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JList;

import java.awt.TextField;

import javax.swing.JLabel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.ListSelectionModel;

import Main.DBinit;
import MainMagasine.Categorier;
import MainMagasine.Produit;

import javax.swing.JSpinner;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.Font;

public class Look implements ItemListener, ListSelectionListener {

	private JFrame frame;
	private DefaultComboBoxModel<String> modelComboBox = new DefaultComboBoxModel<String>();
	private JComboBox comboBox = new JComboBox(modelComboBox);
	private DefaultListModel<String> modelList =  new DefaultListModel<String>();;
	private JList list = new JList(modelList) ;
	private JButton btnajt;
	private JButton btnenlv;
	private JLabel lblqnt;
	private JLabel lblprd;
	private JLabel lblunt1;
	private JLabel lblunt2;
	private Produit prd;
	private TextField txtf;
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
		
		txtf = new TextField();
		txtf.setBounds(10, 233, 271, 44);
		frame.getContentPane().add(txtf);
		
		lblunt2 = new JLabel("..");
		lblunt2.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblunt2.setBounds(287, 233, 75, 44);
		frame.getContentPane().add(lblunt2);
		
//----update ComBox List
		//initialize_List(0);
		initialize_ComboBox();
		initialize_List(1);
		frame.getContentPane().add(list);
		frame.getContentPane().add(comboBox);

//----update F

		
		btnajt = new JButton("Ajouter");
		btnajt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int data =Integer.valueOf(txtf.getText());
				DBinit.updateProduit(prd.getIdproduit(), data);
				
			}
		});
		btnajt.setBounds(10, 362, 115, 44);
		frame.getContentPane().add(btnajt);
		
		btnenlv = new JButton("Enlever");
		btnenlv.setBounds(247, 362, 115, 44);
		frame.getContentPane().add(btnenlv);
		
		JLabel lblNewLabel_2 = new JLabel("Produit :");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 31));
		lblNewLabel_2.setBounds(10, 33, 210, 32);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Quantite Disponible  :");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNewLabel_3.setBounds(10, 101, 239, 32);
		frame.getContentPane().add(lblNewLabel_3);
		
		lblqnt = new JLabel("0.0");
		lblqnt.setFont(new Font("Tahoma", Font.PLAIN, 34));
		lblqnt.setBounds(10, 160, 271, 37);
		frame.getContentPane().add(lblqnt);
		
		lblprd = new JLabel("....");
		lblprd.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblprd.setBounds(10, 71, 352, 32);
		frame.getContentPane().add(lblprd);
		
		lblunt1 = new JLabel("");
		lblunt1.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblunt1.setBounds(287, 160, 53, 37);
		frame.getContentPane().add(lblunt1);
	}
//************************ intialize the UI	
//------------------ initialize THE List to Show the data from the option in comboBox
private void initialize_List(int id) {
//		modelList = new DefaultListModel<String>();
		java.util.List<Produit> lprd = DBinit.ListOfProduitWithCat(id);
		list.removeAll();
		modelList.clear();
		for(Produit prd : lprd){
			modelList.addElement(prd.getNomProduit());
		}
		list.setBounds(372, 70, 266, 346);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		if(id != 0)
		list.setBorder(BorderFactory.createTitledBorder
				(BorderFactory.createLineBorder(Color.DARK_GRAY, 5), ""
				+ comboBox.getSelectedItem().toString() , 0, 0, null, Color.RED));
//		list.setSelectedIndex(0);
		list.addListSelectionListener(this);
	}

//-- initialize THE comboBox to get the data
	private void initialize_ComboBox() {
		
		java.util.List<Categorier> LCategorier = DBinit.CategorierList;
		 for(Categorier cat : LCategorier){
			 modelComboBox.addElement(cat.getNomCategorier()); 
		 }		 
//		comboBox = new JComboBox(modelComboBox);
		comboBox.addItemListener(this);
		
		comboBox.setBounds(372, 39, 266, 20);
	}
//************************ Action 
/*	public void actionPerformed(ActionEvent evt) {
		if(evt.getSource().equals(comboBox)){
			String str = (String) comboBox.getSelectedItem();
			int id = DBinit.findCategorierID(str);
			
			initialize_List(id);
		}
	}*/
//**************************************

	@Override
	public void itemStateChanged(ItemEvent evt) {
		if(evt.getSource().equals(comboBox)){
			String str = (String) comboBox.getSelectedItem();
			int id = DBinit.findCategorierID(str);
			initialize_List(id);
		}		
	}

	@Override
	public void valueChanged(ListSelectionEvent evt) {
		if(evt.getSource().equals(list)){
			String str = (String) list.getSelectedValue();
			if(str != null){
				
			prd = DBinit.findProdiutWithName(str);
			String unt = DBinit.findUniterName(prd.getIdcat());
			lblunt2.setText(unt);
			lblunt1.setText(unt);
			
			lblprd.setText(prd.getNomProduit());
			lblqnt.setText(String.valueOf(prd.getQnt()));;
			}
		}
	}
}
