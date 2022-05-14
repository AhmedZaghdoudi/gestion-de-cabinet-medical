package projetJava;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpinnerListModel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.SystemColor;
import java.awt.Window.Type;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.border.LineBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import java.awt.GridLayout;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.SwingConstants;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;

import java.awt.CardLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import net.miginfocom.swing.MigLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.CompoundBorder;
import javax.swing.border.BevelBorder;
import javax.swing.JList;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import javax.swing.JLayeredPane;

public class Main extends JFrame{
	int positionPatientSupp ;
	
	JMenu creationPatient , suppPatient , fichePatient , ordonnance ;
	private JPanel creationPatient_1;
	private JPanel panel_5;
	private JButton ajoutBtn;
	private JButton annulerAjoutBtn;
	private JPanel suppressionPatient;
	private JPanel panel_7;
	private JLabel lblNewLabel;
	private JPanel panel_6;
	private JLabel lblNewLabel_1;
	private JLabel nomLblSupp;
	private JLabel lblNewLabel_3;
	private JLabel prenomLblSupp;
	private JLabel lblNewLabel_5;
	private JLabel adrLblSupp;
	private JLabel lblNewLabel_7;
	private JLabel telLblSupp;
	private JPanel panel_8;
	private JButton suppBtn;
	private JButton btnNewButton_3;
	private JPanel panel;
	private JPanel panel_1;
	private JLabel lblCode;
	private JTextField codeTF;
	private JPanel panel_2;
	private JLabel lblCode_1;
	private JTextField nomTF;
	private JPanel panel_3;
	private JLabel lblCode_2;
	private JTextField prenomTF;
	private JPanel panel_4;
	private JLabel lblCode_3;
	private JTextField adrTF;
	private JPanel panel_9;
	private JLabel lblCode_4;
	private JTextField telTF;
	private JPanel panel_10;
	private JTextField pCodeSuppTF;
	private JButton chercherPatientSupp;
	private JPanel fichePatient_1;
	private JPanel panel_11;
	private JLabel lblNewLabel_9;
	private JPanel panel_13;
	private JComboBox comboBox;
	private JPanel panel_12;
	private JSpinner spinner;
	private JButton choisirPatientBtn;
	private JPanel panel_14;
	private JButton btnNewButton_6;
	private JButton btnNewButton_7;
	private JPanel panel_15;
	private JTextArea textArea;
	private JPanel panel_16;
	private JTextField textField_6;
	private JLabel lblNewLabel_10;
	private JPanel ajoutOrd;
	private JLabel lblNewLabel_11;
	private JPanel panel_18;
	private JPanel panel_19;
	private JLabel lblNewLabel_12;
	private JTextField textField_7;
	private JPanel panel_20;
	private JLabel lblNewLabel_13;
	private JTextField textField_8;
	private JPanel panel_21;
	private JLabel lblNewLabel_14;
	private JTextField textField_9;
	private JPanel panel_22;
	private JButton btnNewButton_8;
	private JButton btnNewButton_9;
	private JButton btnNewButton_10;
	private JPanel panel_23;
	private JLabel lblNewLabel_15;
	private JTextField textField_10;
	private JMenu mnListPatient;
	private JPanel listPatient;
	private JLabel lblNewLabel_16;
	private JList list;
	ArrayList<String> patientAList ;
	DefaultListModel listModel ;
	Main(){
		setResizable(false);
		getContentPane().setEnabled(false);
		
		/* Our frame */
		this.setTitle("Cabinet Hssouna");
		this.setSize(600, 427);
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    this.setLocation(500,150);
	    setType(Type.UTILITY);
	    getContentPane().setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
	    JMenuBar menu = new JMenuBar();
	    
	    creationPatient = new JMenu("Creation Patient");
	    suppPatient = new JMenu("Suppression Patient");
	    fichePatient = new JMenu("Fiche Patient");
	    ordonnance = new JMenu("Ordonnance");
	    
	    menu.add(creationPatient);
	    menu.add(suppPatient);
	    menu.add(fichePatient);
	    menu.add(ordonnance);
    	    
	    /* Variables */
	    patientAList = new ArrayList<>();
	    patientAList.add("Choisir un Patient");
	    positionPatientSupp = -1;
	    
	    /* Add items here to the Frame */
	    this.getContentPane().add(menu);
	    
	    mnListPatient = new JMenu("List Patient");
	    menu.add(mnListPatient);
	    
	    listPatient = new JPanel();
	    listPatient.setPreferredSize(new Dimension(570,350));
	    getContentPane().add(listPatient);
	    listPatient.setLayout(new BorderLayout(0, 10));
	    
	    lblNewLabel_16 = new JLabel("Liste des Patients :");
	    lblNewLabel_16.setFont(new Font("Tahoma", Font.BOLD, 16));
	    listPatient.add(lblNewLabel_16, BorderLayout.NORTH);
	    
	   
	    listModel = new DefaultListModel();
	    
	    list = new JList(listModel);
	    listPatient.add(list, BorderLayout.CENTER);
	    
	    ajoutOrd = new JPanel();
	    ajoutOrd.setPreferredSize(new Dimension(570,350));
	    getContentPane().add(ajoutOrd);
	    ajoutOrd.setVisible(false);
	    ajoutOrd.setLayout(new BorderLayout(0, 10));
	    
	    lblNewLabel_11 = new JLabel("Ajout d'ordonnance");
	    lblNewLabel_11.setFont(new Font("Tahoma", Font.PLAIN, 20));
	    ajoutOrd.add(lblNewLabel_11, BorderLayout.NORTH);
	    
	    panel_18 = new JPanel();
	    ajoutOrd.add(panel_18, BorderLayout.CENTER);
	    panel_18.setLayout(new GridLayout(4, 0, 10, 20));
	    
	    panel_20 = new JPanel();
	    panel_18.add(panel_20);
	    panel_20.setLayout(new GridLayout(0, 2, 0, 0));
	    
	    lblNewLabel_13 = new JLabel("Code du Patient :");
	    lblNewLabel_13.setFont(new Font("Tahoma", Font.BOLD, 16));
	    panel_20.add(lblNewLabel_13);
	    
	    textField_8 = new JTextField();
	    textField_8.setColumns(10);
	    panel_20.add(textField_8);
	    
	    panel_23 = new JPanel();
	    panel_18.add(panel_23);
	    panel_23.setLayout(new GridLayout(0, 2, 0, 0));
	    
	    lblNewLabel_15 = new JLabel("Nom du medicament :");
	    lblNewLabel_15.setFont(new Font("Tahoma", Font.BOLD, 16));
	    panel_23.add(lblNewLabel_15);
	    
	    textField_10 = new JTextField();
	    textField_10.setColumns(10);
	    panel_23.add(textField_10);
	    
	    panel_19 = new JPanel();
	    panel_18.add(panel_19);
	    panel_19.setLayout(new GridLayout(0, 2, 0, 0));
	    
	    lblNewLabel_12 = new JLabel("Nombre de fois par jours :");
	    lblNewLabel_12.setFont(new Font("Tahoma", Font.BOLD, 16));
	    panel_19.add(lblNewLabel_12);
	    
	    textField_7 = new JTextField();
	    panel_19.add(textField_7);
	    textField_7.setColumns(10);
	    
	    panel_21 = new JPanel();
	    panel_18.add(panel_21);
	    panel_21.setLayout(new GridLayout(0, 2, 0, 0));
	    
	    lblNewLabel_14 = new JLabel("Periode :");
	    lblNewLabel_14.setFont(new Font("Tahoma", Font.BOLD, 16));
	    panel_21.add(lblNewLabel_14);
	    
	    textField_9 = new JTextField();
	    textField_9.setColumns(10);
	    panel_21.add(textField_9);
	    
	    panel_22 = new JPanel();
	    ajoutOrd.add(panel_22, BorderLayout.SOUTH);
	    
	    btnNewButton_8 = new JButton("Enregistrer");
	    panel_22.add(btnNewButton_8);
	    
	    btnNewButton_10 = new JButton("Imprimer");
	    panel_22.add(btnNewButton_10);
	    
	    btnNewButton_9 = new JButton("Annuler");
	    panel_22.add(btnNewButton_9);
	    
	    fichePatient_1 = new JPanel();
	    fichePatient_1.setBorder(new CompoundBorder());
	    getContentPane().add(fichePatient_1);
	    fichePatient_1.setPreferredSize(new Dimension(570, 350));
	    fichePatient_1.setLayout(new BorderLayout(20, 10));
	    fichePatient_1.setVisible(false);
	    panel_13 = new JPanel();
	    fichePatient_1.add(panel_13, BorderLayout.CENTER);
	    panel_13.setLayout(new BorderLayout(20, 20));
	    
	    comboBox = new JComboBox();
	    comboBox.setPreferredSize(new Dimension(150,400));
	    panel_13.add(comboBox, BorderLayout.WEST);
	    
	    panel_15 = new JPanel();
	    panel_13.add(panel_15, BorderLayout.CENTER);
	    panel_15.setLayout(new BorderLayout(0, 10));
	    
	    textArea = new JTextArea();
	    panel_15.add(textArea, BorderLayout.CENTER);
	    
	    panel_16 = new JPanel();
	    panel_15.add(panel_16, BorderLayout.NORTH);
	    panel_16.setLayout(new BorderLayout(10, 0));
	    
	    textField_6 = new JTextField();
	    panel_16.add(textField_6, BorderLayout.CENTER);
	    textField_6.setColumns(10);
	    
	    lblNewLabel_10 = new JLabel("Titre :");
	    lblNewLabel_10.setHorizontalAlignment(SwingConstants.LEFT);
	    lblNewLabel_10.setForeground(SystemColor.windowBorder);
	    lblNewLabel_10.setFont(new Font("Serif", Font.PLAIN, 19));
	    panel_16.add(lblNewLabel_10, BorderLayout.WEST);
	    
	    panel_14 = new JPanel();
	    panel_13.add(panel_14, BorderLayout.SOUTH);
	    panel_14.setLayout(new GridLayout(0, 2, 20, 0));
	    
	    btnNewButton_6 = new JButton("Enregistrer");
	    panel_14.add(btnNewButton_6);
	    
	    btnNewButton_7 = new JButton("Annuler");
	    panel_14.add(btnNewButton_7);
	    
	    panel_11 = new JPanel();
	    fichePatient_1.add(panel_11, BorderLayout.NORTH);
	    panel_11.setLayout(new GridLayout(2, 1));
	    
	    lblNewLabel_9 = new JLabel("Choisir un patient :");
	    lblNewLabel_9.setHorizontalAlignment(SwingConstants.LEFT);
	    lblNewLabel_9.setForeground(SystemColor.windowBorder);
	    lblNewLabel_9.setFont(new Font("Serif", Font.PLAIN, 19));
	    panel_11.add(lblNewLabel_9);
	    
	    panel_12 = new JPanel();
	    panel_11.add(panel_12);
	    panel_12.setLayout(new BorderLayout(20, 0));

	    SpinnerListModel spinnerModel = new SpinnerListModel(patientAList);
	    spinner = new JSpinner(spinnerModel);
	    panel_12.add(spinner, BorderLayout.CENTER);
	    
	    choisirPatientBtn = new JButton("Choisir");
	    panel_12.add(choisirPatientBtn, BorderLayout.EAST);
	    creationPatient_1 = new JPanel();
	    creationPatient_1.setBackground(SystemColor.menu);
	    creationPatient_1.setBorder(new CompoundBorder());
	    getContentPane().add(creationPatient_1);
	    creationPatient_1.setLayout(new BorderLayout(0, 30));
	    creationPatient_1.setPreferredSize(new Dimension(400, 350));
	    creationPatient_1.setVisible(false);
	    
	    panel = new JPanel();
	    creationPatient_1.add(panel, BorderLayout.CENTER);
	    panel.setLayout(new GridLayout(0, 1, 0, 0));
	    
	    panel_1 = new JPanel();
	    panel.add(panel_1);
	    panel_1.setLayout(new GridLayout(2, 1, 0, 0));
	    
	    lblCode = new JLabel("Code");
	    lblCode.setHorizontalAlignment(SwingConstants.LEFT);
	    lblCode.setForeground(SystemColor.windowBorder);
	    lblCode.setFont(new Font("Serif", Font.PLAIN, 19));
	    panel_1.add(lblCode);
	    
	    codeTF = new JTextField();
	    codeTF.setText("123");
	    codeTF.setColumns(10);
	    panel_1.add(codeTF);
	    
	    panel_2 = new JPanel();
	    panel.add(panel_2);
	    panel_2.setLayout(new GridLayout(2, 1, 0, 0));
	    
	    lblCode_1 = new JLabel("Nom");
	    lblCode_1.setHorizontalAlignment(SwingConstants.LEFT);
	    lblCode_1.setForeground(SystemColor.windowBorder);
	    lblCode_1.setFont(new Font("Serif", Font.PLAIN, 19));
	    panel_2.add(lblCode_1);
	    
	    nomTF = new JTextField();
	    nomTF.setText("Zaghdoudi");
	    nomTF.setColumns(10);
	    panel_2.add(nomTF);
	    
	    panel_3 = new JPanel();
	    panel.add(panel_3);
	    panel_3.setLayout(new GridLayout(2, 1, 0, 0));
	    
	    lblCode_2 = new JLabel("Prenom");
	    lblCode_2.setHorizontalAlignment(SwingConstants.LEFT);
	    lblCode_2.setForeground(SystemColor.windowBorder);
	    lblCode_2.setFont(new Font("Serif", Font.PLAIN, 19));
	    panel_3.add(lblCode_2);
	    
	    prenomTF = new JTextField();
	    prenomTF.setText("Ahmed");
	    prenomTF.setColumns(10);
	    panel_3.add(prenomTF);
	    
	    panel_4 = new JPanel();
	    panel.add(panel_4);
	    panel_4.setLayout(new GridLayout(2, 1, 0, 0));
	    
	    lblCode_3 = new JLabel("Adresse");
	    lblCode_3.setHorizontalAlignment(SwingConstants.LEFT);
	    lblCode_3.setForeground(SystemColor.windowBorder);
	    lblCode_3.setFont(new Font("Serif", Font.PLAIN, 19));
	    panel_4.add(lblCode_3);
	    
	    adrTF = new JTextField();
	    adrTF.setText("Beb Jdid");
	    adrTF.setColumns(10);
	    panel_4.add(adrTF);
	    
	    panel_9 = new JPanel();
	    panel.add(panel_9);
	    panel_9.setLayout(new GridLayout(2, 1, 0, 0));
	    
	    lblCode_4 = new JLabel("Telephone");
	    lblCode_4.setHorizontalAlignment(SwingConstants.LEFT);
	    lblCode_4.setForeground(SystemColor.windowBorder);
	    lblCode_4.setFont(new Font("Serif", Font.PLAIN, 19));
	    panel_9.add(lblCode_4);
	    
	    telTF = new JTextField();
	    telTF.setText("99101001");
	    telTF.setColumns(10);
	    panel_9.add(telTF);
	    
	    panel_5 = new JPanel();
	    creationPatient_1.add(panel_5, BorderLayout.SOUTH);
	    panel_5.setLayout(new GridLayout(0, 2, 20, 20));
	    
	    ajoutBtn = new JButton("Ajouter");
	    panel_5.add(ajoutBtn);
	    
	    annulerAjoutBtn = new JButton("Annuler");
	    panel_5.add(annulerAjoutBtn);
	    
	    suppressionPatient = new JPanel();
	    suppressionPatient.setBorder(new CompoundBorder());
	    getContentPane().add(suppressionPatient);
	    suppressionPatient.setLayout(new BorderLayout(0, 5));
	    suppressionPatient.setPreferredSize(new Dimension(400, 350));
	    suppressionPatient.setVisible(false);
	    
	    panel_7 = new JPanel();
	    suppressionPatient.add(panel_7, BorderLayout.NORTH);
	    panel_7.setLayout(new GridLayout(2,1));
	    
	    lblNewLabel = new JLabel("Rechercher un patient par code :");
	    lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
	    lblNewLabel.setForeground(SystemColor.windowBorder);
	    lblNewLabel.setFont(new Font("Serif", Font.PLAIN, 19));
	    panel_7.add(lblNewLabel);
	    
	    panel_10 = new JPanel();
	    panel_7.add(panel_10);
	    panel_10.setLayout(new BorderLayout(5, 5));
	    
	    pCodeSuppTF = new JTextField();
	    pCodeSuppTF.setColumns(10);
	    panel_10.add(pCodeSuppTF);
	    
	    chercherPatientSupp = new JButton("Chercher");
	    panel_10.add(chercherPatientSupp, BorderLayout.EAST);
	    
	    panel_6 = new JPanel();
	    suppressionPatient.add(panel_6, BorderLayout.CENTER);
	    panel_6.setLayout(new GridLayout(4, 2, 0, 0));
	    
	    lblNewLabel_1 = new JLabel("Nom");
	    lblNewLabel_1.setHorizontalAlignment(SwingConstants.LEFT);
	    lblNewLabel_1.setForeground(SystemColor.windowBorder);
	    lblNewLabel_1.setFont(new Font("Serif", Font.PLAIN, 19));
	    panel_6.add(lblNewLabel_1);
	    
	    nomLblSupp = new JLabel("...");
	    nomLblSupp.setHorizontalAlignment(SwingConstants.LEFT);
	    nomLblSupp.setForeground(SystemColor.windowBorder);
	    nomLblSupp.setFont(new Font("Serif", Font.BOLD , 19));
	    panel_6.add(nomLblSupp);
	    
	    lblNewLabel_3 = new JLabel("Prenom");
	    lblNewLabel_3.setHorizontalAlignment(SwingConstants.LEFT);
	    lblNewLabel_3.setForeground(SystemColor.windowBorder);
	    lblNewLabel_3.setFont(new Font("Serif", Font.PLAIN, 19));
	    panel_6.add(lblNewLabel_3);
	    
	    prenomLblSupp = new JLabel("...");
	    prenomLblSupp.setHorizontalAlignment(SwingConstants.LEFT);
	    prenomLblSupp.setForeground(SystemColor.windowBorder);
	    prenomLblSupp.setFont(new Font("Serif", Font.BOLD, 19));
	    panel_6.add(prenomLblSupp);
	    
	    lblNewLabel_5 = new JLabel("Adresse");
	    lblNewLabel_5.setHorizontalAlignment(SwingConstants.LEFT);
	    lblNewLabel_5.setForeground(SystemColor.windowBorder);
	    lblNewLabel_5.setFont(new Font("Serif", Font.PLAIN, 19));
	    panel_6.add(lblNewLabel_5);
	    
	    adrLblSupp = new JLabel("...");
	    adrLblSupp.setHorizontalAlignment(SwingConstants.LEFT);
	    adrLblSupp.setForeground(SystemColor.windowBorder);
	    adrLblSupp.setFont(new Font("Serif", Font.BOLD, 19));
	    panel_6.add(adrLblSupp);
	    
	    lblNewLabel_7 = new JLabel("Telephone ");
	    lblNewLabel_7.setHorizontalAlignment(SwingConstants.LEFT);
	    lblNewLabel_7.setForeground(SystemColor.windowBorder);
	    lblNewLabel_7.setFont(new Font("Serif", Font.PLAIN, 19));
	    panel_6.add(lblNewLabel_7);
	    
	    telLblSupp = new JLabel("...");
	    telLblSupp.setHorizontalAlignment(SwingConstants.LEFT);
	    telLblSupp.setForeground(SystemColor.windowBorder);
	    telLblSupp.setFont(new Font("Serif", Font.BOLD, 19));
	    panel_6.add(telLblSupp);
	    
	    panel_8 = new JPanel();
	    suppressionPatient.add(panel_8, BorderLayout.SOUTH);
	    panel_8.setLayout(new GridLayout(1, 2, 10, 10));
	    
	    suppBtn = new JButton("Supprimer");
	    panel_8.add(suppBtn);
	    
	    btnNewButton_3 = new JButton("Annuler");
	    panel_8.add(btnNewButton_3);
	    
	}

	public static void main(String[] args) {
		Main mainMenu = new Main();
		mainMenu.setVisible(true);

		/* Variables */
		
		
		/* Navigation */
		mainMenu.creationPatient.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				mainMenu.creationPatient_1.setVisible(true);
				mainMenu.suppressionPatient.setVisible(false);
				mainMenu.fichePatient_1.setVisible(false);
				mainMenu.ajoutOrd.setVisible(false);
				mainMenu.listPatient.setVisible(false);
			}
		});
		
		mainMenu.suppPatient.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				mainMenu.suppressionPatient.setVisible(true);
				mainMenu.creationPatient_1.setVisible(false);
				mainMenu.fichePatient_1.setVisible(false);
				mainMenu.ajoutOrd.setVisible(false);
				mainMenu.listPatient.setVisible(false);
			}
		});
		
		mainMenu.fichePatient.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				mainMenu.fichePatient_1.setVisible(true);
				mainMenu.suppressionPatient.setVisible(false);
				mainMenu.creationPatient_1.setVisible(false);
				mainMenu.ajoutOrd.setVisible(false);
				mainMenu.listPatient.setVisible(false);
			}
		});
		
		mainMenu.ordonnance.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				mainMenu.ajoutOrd.setVisible(true);
				mainMenu.fichePatient_1.setVisible(false);
				mainMenu.suppressionPatient.setVisible(false);
				mainMenu.creationPatient_1.setVisible(false);
				mainMenu.listPatient.setVisible(false);
			}
		});
		
		mainMenu.mnListPatient.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				mainMenu.listPatient.setVisible(true);
				mainMenu.ajoutOrd.setVisible(false);
				mainMenu.fichePatient_1.setVisible(false);
				mainMenu.suppressionPatient.setVisible(false);
				mainMenu.creationPatient_1.setVisible(false);
			}
		});
	
		/* Ajout Patient */
		mainMenu.ajoutBtn.addActionListener(new ActionListener() {
	         @Override
	         public void actionPerformed(ActionEvent e) {
	        	if(mainMenu.codeTF.getText().isEmpty() && mainMenu.nomTF.getText().isEmpty() && mainMenu.prenomTF.getText().isEmpty() && mainMenu.adrTF.getText().isEmpty() && mainMenu.telTF.getText().isEmpty())
	        	{
	        		JOptionPane.showMessageDialog(mainMenu, "Il y'a des champs vides !");
	        	}else {
	        		mainMenu.patientAList.add(mainMenu.codeTF.getText()+"  |  "+mainMenu.nomTF.getText()+"  |  "+mainMenu.prenomTF.getText()+"  |  "+mainMenu.adrTF.getText()+"  |  "+mainMenu.telTF.getText());
	        		mainMenu.listModel.addElement(mainMenu.codeTF.getText()+"  |  "+mainMenu.nomTF.getText()+"  |  "+mainMenu.prenomTF.getText()+"  |  "+mainMenu.adrTF.getText()+"  |  "+mainMenu.telTF.getText()+"  |  ");
	        		JOptionPane.showMessageDialog(mainMenu, "Un Patient a été bien ajouter!");
	        		mainMenu.codeTF.setText("");
		        	mainMenu.nomTF.setText("");
		        	mainMenu.prenomTF.setText("");
		        	mainMenu.adrTF.setText("");
		        	mainMenu.telTF.setText("");
	        	}
	         }
	      });
		
		mainMenu.annulerAjoutBtn.addActionListener(new ActionListener() {
	         @Override
	         public void actionPerformed(ActionEvent e) {
	        	 mainMenu.codeTF.setText("");
	        	 mainMenu.nomTF.setText("");
	        	 mainMenu.prenomTF.setText("");
	        	 mainMenu.adrTF.setText("");
	        	 mainMenu.telTF.setText("");
	         }
	      });
		
		/* Supp Patient */
		mainMenu.suppBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int result = JOptionPane.showConfirmDialog(mainMenu, "Voulez-vous supprimer ce patient ?!");
				if( JOptionPane.NO_OPTION == result || JOptionPane.CANCEL_OPTION == result){
					//System.out.println("Battalna");
				}else {
					if(mainMenu.positionPatientSupp != -1) {
						mainMenu.patientAList.remove(mainMenu.positionPatientSupp);
						mainMenu.listModel.remove(mainMenu.positionPatientSupp-1);
						mainMenu.positionPatientSupp = -1 ;
						mainMenu.nomLblSupp.setText("...");
						mainMenu.prenomLblSupp.setText("...");
						mainMenu.adrLblSupp.setText("...");
						mainMenu.telLblSupp.setText("...");
						mainMenu.pCodeSuppTF.setText("");
					}
					
				}
				
			}
		});
		
		mainMenu.chercherPatientSupp.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String patientCode = mainMenu.pCodeSuppTF.getText() ; 
				String patientCodeList , patient = "";
				Boolean exist = false;
				for(int i = 1 ; i< mainMenu.patientAList.size() ; i++) {
					patientCodeList = mainMenu.patientAList.get(i).substring(0, mainMenu.patientAList.get(i).indexOf(" "));
					if(patientCode.equals(patientCodeList)) {
						exist = true ;
						mainMenu.positionPatientSupp = i ;
						patient = mainMenu.patientAList.get(i);
						break;
					}
				}
				if(exist == false) {
					JOptionPane.showMessageDialog(mainMenu, "Aucun Patient trouvé !");	
					mainMenu.nomLblSupp.setText("...");
					mainMenu.prenomLblSupp.setText("...");
					mainMenu.adrLblSupp.setText("...");
					mainMenu.telLblSupp.setText("...");
				}else {
					patient = patient.substring(patient.indexOf("  |  ")+5);
					mainMenu.nomLblSupp.setText(patient.substring(0,patient.indexOf("  |  ")));
					patient = patient.substring(patient.indexOf("  |  ")+5);
					mainMenu.prenomLblSupp.setText(patient.substring(0,patient.indexOf("  |  ")));
					patient = patient.substring(patient.indexOf("  |  ")+5);
					mainMenu.adrLblSupp.setText(patient.substring(0,patient.indexOf("  |  ")));
					patient = patient.substring(patient.indexOf("  |  ")+5);
					mainMenu.telLblSupp.setText(patient.substring(0));
				}
					
			}
		});
		
		/* Fiche Patient */
		mainMenu.choisirPatientBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(mainMenu.spinner.getValue()=="Choisir un Patient") {
					JOptionPane.showMessageDialog(mainMenu, "Aucun patient a été selectionnée !");
				}
				else {
					
				}
			}
		});
	
	}
}
