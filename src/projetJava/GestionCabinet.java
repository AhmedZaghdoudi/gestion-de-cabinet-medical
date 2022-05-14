package projetJava;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SpinnerListModel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.SystemColor;
import java.awt.Window.Type;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.border.LineBorder;
import javax.swing.event.AncestorListener;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

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

public class GestionCabinet extends JFrame{
	
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
	private JPanel panel_12;
	private JButton choisirPatientBtn;
	private JPanel panel_14;
	private JButton saveButtonFiche;
	private JButton cancelButtonFiche;
	private JPanel panel_15;
	private JTextArea textConsulArea;
	private JPanel panel_16;
	private JTextField titleTF;
	private JLabel lblNewLabel_10;
	private JPanel ajoutOrd;
	private JLabel lblNewLabel_11;
	private JPanel ajoutOrdCenter;
	private JPanel panel_19;
	private JLabel lblNewLabel_12;
	private JTextField textField_7;
	private JPanel panel_20;
	private JLabel lblNewLabel_13;
	private JTextField textField_8;
	private JPanel panel_21;
	private JLabel lblNewLabel_14;
	private JTextField textField_9;
	private JPanel ajoutOrdBot;
	private JButton btnNewButton_8;
	private JButton btnNewButton_9;
	private JButton btnNewButton_10;
	private JPanel panel_23;
	private JLabel lblNewLabel_15;
	private JTextField textField_10;
	private JMenu mnListPatient;
	private JPanel listPatient;
	private JLabel lblNewLabel_16;
	private JButton delButtonFiche;
	
	private JSpinner spinner;
	private JList list_consul;
	private JList list;
	static ArrayList<String> patientAList ;
	static DefaultListModel listModelPatientString ;
	private DefaultListModel<Consultation> listModelConsul;
	private DefaultListModel<Consultation> filtredListModel;
	private JLabel nameLbl;
	private JLabel pswLbl;
	private JTextField nameTf;
	private JPasswordField pswTf;
	private JButton logBtn;
	private JButton annulerLogBtn;
	private JCheckBox checkPwd;
	private JLabel checkPwdLbl;
	private static DefaultListModel<Patient> listModelPatient; 
	public static DefaultListModel stringListModel ;
	
	public static int consIndex = -1;
	public static int id_patient ;
	public static boolean patientExistDel = false ;
	
	void afficheConsultation() {
		//extraction du l'id du patient selectionné
		String id = spinner.getValue().toString();
		id = id.substring(0, id.indexOf("  |  "));
		
		// cette liste est pour avoir tous les consultation d'un seul patient 
		
		filtredListModel = filtre(id , listModelConsul);
		
		// cette liste est pour avoir un affichage unique (avec une convertion l'objet en string)
		stringListModel = new DefaultListModel();
		
		for(int i = 0 ; i< filtredListModel.getSize() ; i++) {
			stringListModel.addElement(filtredListModel.elementAt(i).getId()+"  |  "+filtredListModel.elementAt(i).getTitre());
		}
		
		list_consul.setModel(stringListModel);
	}
	
	GestionCabinet(){
		
		
		/* Our frame */
		this.setResizable(false);
		this.setTitle("Gestion Cabinet");
		this.setSize(600, 427);
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    this.setLocation(500,150);
	    this.setType(Type.UTILITY);
	    this.setLayout(new FlowLayout(FlowLayout.CENTER));
	    
	    
	    creationPatient = new JMenu("Creation Patient");
	    suppPatient = new JMenu("Suppression Patient");
	    fichePatient = new JMenu("Fiche Patient");
	    ordonnance = new JMenu("Ordonnance");
	    mnListPatient = new JMenu("List Patient");
	    
	    JMenuBar menu = new JMenuBar();
	    
	    menu.add(creationPatient);
	    menu.add(suppPatient);
	    menu.add(fichePatient);
	    menu.add(ordonnance);
	    menu.add(mnListPatient);
	    menu.setVisible(false);
	    
	    this.setJMenuBar(menu);
	    
	    /* Variables */
	    
	    // ceci est une  liste des patient pour les spinner (panel consultation)
	    patientAList = new ArrayList<>();
	    patientAList.add("Choisir un Patient");
	    
	    //ceci est une listeModel du type string pour afficher les patient dans un JList
	    listModelPatientString = new DefaultListModel();
	    
	    //ceci est une listeModel du patient 
	    listModelPatient = new DefaultListModel();
	    
	    //ceci est une liste des consultation 
	    listModelConsul = new DefaultListModel();
	    
	  //ceci est une liste des consultation filtré pour un seul patient
	    filtredListModel = new DefaultListModel();
	    
	    
	    /* Panel List des patients */
	    
	    listPatient = new JPanel();
	    listPatient.setPreferredSize(new Dimension(570,350));
	    listPatient.setLayout(new BorderLayout(0, 10));
	    listPatient.setVisible(false);
	    
	    lblNewLabel_16 = new JLabel("Liste des Patients :");
	    lblNewLabel_16.setFont(new Font("Tahoma", Font.BOLD, 16));
	    listPatient.add(lblNewLabel_16, BorderLayout.NORTH);
	    
	    list = new JList(listModelPatientString);
	    listPatient.add(list, BorderLayout.CENTER);
	    
	    
	    /* Panel Ajout Ordonnance */ 
	    
	    ajoutOrd = new JPanel();
	    ajoutOrd.setPreferredSize(new Dimension(570,350));
	    ajoutOrd.setVisible(false);
	    ajoutOrd.setLayout(new BorderLayout(0, 10));
	    
	    lblNewLabel_11 = new JLabel("Ajout d'ordonnance");
	    lblNewLabel_11.setFont(new Font("Tahoma", Font.PLAIN, 20));
	    ajoutOrd.add(lblNewLabel_11, BorderLayout.NORTH);
	    
	    ajoutOrdCenter = new JPanel();
	    ajoutOrd.add(ajoutOrdCenter, BorderLayout.CENTER);
	    ajoutOrdCenter.setLayout(new GridLayout(4, 0, 10, 20));
	    
	    panel_20 = new JPanel();
	    ajoutOrdCenter.add(panel_20);
	    panel_20.setLayout(new GridLayout(0, 2, 0, 0));
	    
	    ajoutOrdBot = new JPanel();
	    ajoutOrd.add(ajoutOrdBot, BorderLayout.SOUTH);
	    
	    btnNewButton_8 = new JButton("Enregistrer");
	    ajoutOrdBot.add(btnNewButton_8);
	    
	    btnNewButton_10 = new JButton("Imprimer");
	    ajoutOrdBot.add(btnNewButton_10);
	    
	    btnNewButton_9 = new JButton("Annuler");
	    ajoutOrdBot.add(btnNewButton_9);
	    
	    lblNewLabel_13 = new JLabel("Code du Patient :");
	    lblNewLabel_13.setFont(new Font("Tahoma", Font.BOLD, 16));
	    panel_20.add(lblNewLabel_13);
	    
	    textField_8 = new JTextField();
	    textField_8.setColumns(10);
	    panel_20.add(textField_8);
	    
	    panel_23 = new JPanel();
	    ajoutOrdCenter.add(panel_23);
	    panel_23.setLayout(new GridLayout(0, 2, 0, 0));
	    
	    lblNewLabel_15 = new JLabel("Nom du medicament :");
	    lblNewLabel_15.setFont(new Font("Tahoma", Font.BOLD, 16));
	    panel_23.add(lblNewLabel_15);
	    
	    textField_10 = new JTextField();
	    textField_10.setColumns(10);
	    panel_23.add(textField_10);
	    
	    panel_19 = new JPanel();
	    ajoutOrdCenter.add(panel_19);
	    panel_19.setLayout(new GridLayout(0, 2, 0, 0));
	    
	    lblNewLabel_12 = new JLabel("Nombre de fois par jours :");
	    lblNewLabel_12.setFont(new Font("Tahoma", Font.BOLD, 16));
	    panel_19.add(lblNewLabel_12);
	    
	    textField_7 = new JTextField();
	    panel_19.add(textField_7);
	    textField_7.setColumns(10);
	    
	    panel_21 = new JPanel();
	    ajoutOrdCenter.add(panel_21);
	    panel_21.setLayout(new GridLayout(0, 2, 0, 0));
	    
	    lblNewLabel_14 = new JLabel("Periode :");
	    lblNewLabel_14.setFont(new Font("Tahoma", Font.BOLD, 16));
	    panel_21.add(lblNewLabel_14);
	    
	    textField_9 = new JTextField();
	    textField_9.setColumns(10);
	    panel_21.add(textField_9);
	    
	    /* Panel Fiche Patient */
	    
	    fichePatient_1 = new JPanel();
	    fichePatient_1.setBorder(new CompoundBorder());
	    fichePatient_1.setPreferredSize(new Dimension(570, 350));
	    fichePatient_1.setLayout(new BorderLayout(20, 10));
	    fichePatient_1.setVisible(false);
	    panel_13 = new JPanel();
	    fichePatient_1.add(panel_13, BorderLayout.CENTER);
	    panel_13.setLayout(new BorderLayout(20, 20));
	    
	    list_consul = new JList();
	    list_consul.setPreferredSize(new Dimension(150,400));
	    panel_13.add(list_consul, BorderLayout.WEST);
	    
	    panel_15 = new JPanel();
	    panel_13.add(panel_15, BorderLayout.CENTER);
	    panel_15.setLayout(new BorderLayout(0, 10));
	    
	    textConsulArea = new JTextArea();
	    panel_15.add(textConsulArea, BorderLayout.CENTER);
	    
	    panel_16 = new JPanel();
	    panel_15.add(panel_16, BorderLayout.NORTH);
	    panel_16.setLayout(new BorderLayout(10, 0));
	    
	    titleTF = new JTextField();
	    panel_16.add(titleTF, BorderLayout.CENTER);
	    titleTF.setColumns(10);
	    
	    lblNewLabel_10 = new JLabel("Titre :");
	    lblNewLabel_10.setHorizontalAlignment(SwingConstants.LEFT);
	    lblNewLabel_10.setForeground(SystemColor.windowBorder);
	    lblNewLabel_10.setFont(new Font("Serif", Font.PLAIN, 19));
	    panel_16.add(lblNewLabel_10, BorderLayout.WEST);
	    
	    panel_14 = new JPanel();
	    panel_13.add(panel_14, BorderLayout.SOUTH);
	    panel_14.setLayout(new GridLayout(0, 3, 20, 0));
	    
	    saveButtonFiche = new JButton("Enregistrer");
	    panel_14.add(saveButtonFiche);
	    
	    delButtonFiche = new JButton("Supprimer");
	    panel_14.add(delButtonFiche);
	    
	    cancelButtonFiche = new JButton("Annuler");
	    panel_14.add(cancelButtonFiche);
	    
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
	    spinner.setEditor(new JSpinner.DefaultEditor(spinner));
	    panel_12.add(spinner, BorderLayout.CENTER);
	   
	    choisirPatientBtn = new JButton("Choisir");
	    panel_12.add(choisirPatientBtn, BorderLayout.EAST);
	    
	    /* Creation Patient */
	    
	    creationPatient_1 = new JPanel();
	    creationPatient_1.setBackground(SystemColor.menu);
	    creationPatient_1.setBorder(new CompoundBorder());
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
	    telTF.setColumns(10);
	    panel_9.add(telTF);
	    
	    panel_5 = new JPanel();
	    creationPatient_1.add(panel_5, BorderLayout.SOUTH);
	    panel_5.setLayout(new GridLayout(0, 2, 20, 20));
	    
	    ajoutBtn = new JButton("Ajouter");
	    panel_5.add(ajoutBtn);
	    
	    annulerAjoutBtn = new JButton("Annuler");
	    panel_5.add(annulerAjoutBtn);
	    
	    /*Suppression Patient */
	    
	    suppressionPatient = new JPanel();
	    suppressionPatient.setBorder(new CompoundBorder());
	    suppressionPatient.setLayout(new BorderLayout(0, 5));
	    suppressionPatient.setPreferredSize(new Dimension(400, 350));
	    suppressionPatient.setVisible(false);
	    
	    panel_7 = new JPanel();
	    suppressionPatient.add(panel_7, BorderLayout.NORTH);
	    panel_7.setLayout(new GridLayout(2,1));
	    
	    lblNewLabel = new JLabel("Rechercher un patient par id  :");
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

	    /* login panel */ 
	    
	    JPanel logPanel = new JPanel();
	    logPanel.setLayout(new GridLayout(4,1,20,20));
	    nameLbl = new JLabel("Utilisateur ");
	    pswLbl = new JLabel("Mot de passe");
	    nameTf = new JTextField();
	    pswTf = new JPasswordField();
	    logBtn = new JButton("Connecter");
	    checkPwd = new JCheckBox();
	    checkPwdLbl = new JLabel("Voir mot de passe ");
	    annulerLogBtn = new JButton("Annuler");
	    
	    logPanel.add(nameLbl);
	    logPanel.add(nameTf);
	    logPanel.add(pswLbl);
	    logPanel.add(pswTf);
	    logPanel.add(checkPwdLbl);
	    logPanel.add(checkPwd);
	    logPanel.add(logBtn);
	    logPanel.add(annulerLogBtn);
	    
	    annulerLogBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

				pswTf.setText("");
				nameTf.setText("");
			}
		});
	    
	    checkPwd.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(checkPwd.isSelected()) {
					pswTf.setEchoChar((char) 0);
				}else {
					pswTf.setEchoChar('*');
				}
			}
		});
	    
	    logBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if(nameTf.getText().isEmpty() || pswTf.getText().isEmpty()) {
					
					JOptionPane.showMessageDialog(logPanel,"Remplir les champs SVP !!");
					
				}else {
					JOptionPane.showMessageDialog(logPanel,"En train de se connecter !!");
					logPanel.setVisible(false);
					menu.setVisible(true);
					listPatient.setVisible(true);
				}
				
			}
		});
	    
	    this.add(logPanel);
	    this.add(listPatient);
	    this.add(fichePatient_1);
	    this.add(creationPatient_1);
	    this.add(ajoutOrd);
	    this.add(suppressionPatient );
	    
	    this.setVisible(true);
	}

	public static void main(String[] args) {
		GestionCabinet mainMenu = new GestionCabinet();
		
		/*Base donnee */ 
		DBConnect c = new DBConnect();
		id_patient = c.getLastId();
		
		// setting les patinets du base donnée dans tous les liste (liste patient du type objet/ liste patient du type string / array liste )
		init(c);
				
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
	        		
	        		id_patient = c.getLastId();
	        		Patient p = new Patient(id_patient+1 , mainMenu.codeTF.getText(),mainMenu.nomTF.getText(),mainMenu.prenomTF.getText(),mainMenu.adrTF.getText(),mainMenu.telTF.getText());
	        		int res = c.addPatient(p);
	        		
	        		if(res == 0) {
	        			JOptionPane.showMessageDialog(mainMenu, "Un erreur s'est produit !");
	        		}else {
	        			JOptionPane.showMessageDialog(mainMenu, "Un Patient a été bien ajouter!");
	        			mainMenu.codeTF.setText("");
			        	mainMenu.nomTF.setText("");
			        	mainMenu.prenomTF.setText("");
			        	mainMenu.adrTF.setText("");
			        	mainMenu.telTF.setText("");
			        	init(c);
	        		}
	        		
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
				
				if(patientExistDel) {
					int result = JOptionPane.showConfirmDialog(mainMenu, "Voulez-vous supprimer ce patient ?!");
				if( JOptionPane.NO_OPTION == result || JOptionPane.CANCEL_OPTION == result){
					//System.out.println("Battalna");
				}else {
						int res = c.suppPatient(Integer.parseInt(mainMenu.pCodeSuppTF.getText()));
						if(res==0) {
							JOptionPane.showMessageDialog(mainMenu, "Error  !");
						}else {
							init(c);
							mainMenu.nomLblSupp.setText("...");
							mainMenu.prenomLblSupp.setText("...");
							mainMenu.adrLblSupp.setText("...");
							mainMenu.telLblSupp.setText("...");
							mainMenu.pCodeSuppTF.setText("");
						}
					}
					
				}else {
					JOptionPane.showMessageDialog(mainMenu, "Choisir un patient !");
				}
				
			}
		});
		
		mainMenu.chercherPatientSupp.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int patientId = Integer.parseInt( mainMenu.pCodeSuppTF.getText()) ; 
				patientExistDel = false;
				int i ;
				
				for( i = 1 ; i< listModelPatient.size() ; i++) {

					if(patientId == listModelPatient.get(i).getId()) {
						patientExistDel = true ;
						break;
					}
				}
				
				if(patientExistDel == false) {
					JOptionPane.showMessageDialog(mainMenu, "Aucun Patient trouvé !");	
					mainMenu.nomLblSupp.setText("...");
					mainMenu.prenomLblSupp.setText("...");
					mainMenu.adrLblSupp.setText("...");
					mainMenu.telLblSupp.setText("...");
				}else {
					mainMenu.nomLblSupp.setText( listModelPatient.get(i).getNom());
					mainMenu.prenomLblSupp.setText(listModelPatient.get(i).getPrenom());
					mainMenu.adrLblSupp.setText(listModelPatient.get(i).getAddress());
					mainMenu.telLblSupp.setText(listModelPatient.get(i).getTel());
				}
					
			}
		});
		
		/* Fiche Patient */
		
		mainMenu.spinner.addChangeListener(new ChangeListener() {
			
			@Override
			public void stateChanged(ChangeEvent e) {
				// TODO Auto-generated method stub
				mainMenu.list_consul.setModel(new DefaultListModel());
				mainMenu.list_consul.clearSelection();
				consIndex = -1 ;
				mainMenu.textConsulArea.setText("");
				mainMenu.titleTF.setText("");
			}
		});
		
		mainMenu.choisirPatientBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(mainMenu.spinner.getValue()=="Choisir un Patient") {
					mainMenu.list_consul.setModel(new DefaultListModel());
					JOptionPane.showMessageDialog(mainMenu, "Aucun patient a été selectionnée !");
				}
				else {
					mainMenu.list_consul.setModel(new DefaultListModel());
					mainMenu.list_consul.clearSelection();
					mainMenu.textConsulArea.setText("");
					mainMenu.titleTF.setText("");
					mainMenu.afficheConsultation();
				}
			}
		});

		mainMenu.list_consul.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				consIndex = mainMenu.list_consul.getSelectedIndex();
				mainMenu.textConsulArea.setText(mainMenu.filtredListModel.getElementAt(consIndex).getContenu());
				mainMenu.titleTF.setText(mainMenu.filtredListModel.getElementAt(consIndex).getTitre());
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
	
		mainMenu.saveButtonFiche.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
					
					if(mainMenu.spinner.getValue()=="Choisir un Patient") {
						JOptionPane.showMessageDialog(mainMenu, "Aucun patient a été selectionnée !");
					}
					else {
						//extraction du l'id du patient selectionné
						String id = mainMenu.spinner.getValue().toString();
						id = id.substring(0, id.indexOf("  |  "));
						
						//en cas d'une nouvel consultation
						
						if(consIndex == -1) {
							if(!mainMenu.textConsulArea.getText().isEmpty() && !mainMenu.titleTF.getText().isEmpty()) {
								System.out.println("ajout ");
								Consultation c = new Consultation(id, mainMenu.titleTF.getText(), mainMenu.textConsulArea.getText());	
								mainMenu.listModelConsul.addElement(c);
								mainMenu.textConsulArea.setText("");
								mainMenu.titleTF.setText("");
								mainMenu.afficheConsultation();
								JOptionPane.showMessageDialog(mainMenu, "Ajout effectué avec succée !");
								}
						}else {
							if(!mainMenu.textConsulArea.getText().isEmpty() && !mainMenu.titleTF.getText().isEmpty()) {
								System.out.println("mise a jour ");
								mainMenu.filtredListModel.getElementAt(consIndex).setContenu(mainMenu.textConsulArea.getText());
								mainMenu.textConsulArea.setText("");
								mainMenu.titleTF.setText("");
								consIndex = -1 ;
								JOptionPane.showMessageDialog(mainMenu, "Changement effectué avec succée !");
								mainMenu.afficheConsultation();
							} 
						}
					}
			}
		});
		
		mainMenu.cancelButtonFiche.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				mainMenu.list_consul.setModel(new DefaultListModel());
				consIndex = -1 ;
				mainMenu.list_consul.clearSelection();
				mainMenu.textConsulArea.setText("");
				mainMenu.titleTF.setText("");
			}
		});
		
		mainMenu.delButtonFiche.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(mainMenu.spinner.getValue()=="Choisir un Patient") {
					JOptionPane.showMessageDialog(mainMenu, "Aucun patient a été selectionnée !");
				}else {

					if(consIndex == -1 ){
						JOptionPane.showMessageDialog(mainMenu, "Choisir lequelle des consultation vous voulez supprimer !");
					}else {
						mainMenu.listModelConsul.removeElementAt(consIndex);
						JOptionPane.showMessageDialog(mainMenu, "Suppression effectué avec succée !");
						consIndex = -1 ;
						mainMenu.afficheConsultation();
						mainMenu.textConsulArea.setText("");
						mainMenu.titleTF.setText("");
					}
				}
			}
		});
	}
	
	static DefaultListModel filtre(String id, DefaultListModel<Consultation> lista) {
		
		DefaultListModel<Consultation> list ;
		
		String p ;
		
		list = new DefaultListModel();
		
		for(int i=0 ; i<lista.getSize() ; i++) {
			p = lista.getElementAt(i).getId();
						
			if(  p.equals(id)  ) {
				list.addElement(lista.getElementAt(i));
			}
		}
		return list;
	}
	
	static void init(DBConnect c ) {
		// setting les patinets du base donnée dans tous les liste (liste patient du type objet/ liste patient du type string / array liste )
				listModelPatient = c.getPatient();
				
				listModelPatientString.removeAllElements();
				patientAList.removeAll(patientAList);
				patientAList.add("Choisir un Patient");
				
				
				for(int i =0 ; i< listModelPatient.getSize() ; i++) {
					listModelPatientString.addElement(listModelPatient.get(i).allToString());
					patientAList.add(listModelPatient.get(i).allToString());
				}
				
				//System.out.println(listModelPatientString.getElementAt(2));
				//System.out.println(patientAList.get(2));
	}
	
}

