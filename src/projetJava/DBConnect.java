package projetJava;
import java.sql.*;

import javax.swing.DefaultListModel;

public class DBConnect {
	private static String jdbcUrl = "jdbc:postgresql://localhost:5432/Gestion_Cabinet";
	private static String username = "postgres";
	private static String password = "696969";
	private static Connection cnx = null ;
	
	
	DBConnect() {
			try {
            
				cnx = DriverManager.getConnection(jdbcUrl,username,password);
				System.out.println("Connected !!");
				
			}catch(SQLException ee){
				
				System.out.println("Error in connecting !!");
				ee.printStackTrace();
				
			}
	}
	
	public static Connection getConnetion() {
		if(cnx == null) {
			new DBConnect();
		}
		return cnx ;
	}
	
	public static DefaultListModel<Patient> getPatient() {
		DefaultListModel<Patient> listPatient = new DefaultListModel();
		
		try {
			
            cnx = DriverManager.getConnection(jdbcUrl,username,password);
           
            try {
            	String rq = "SELECT * FROM patient";
                Statement st = cnx.createStatement();
                ResultSet rs = st.executeQuery(rq);
                
                while(rs.next()){
                	Patient p = new Patient(rs.getInt("id"),rs.getString("code"),rs.getString("nom"),rs.getString("prenom"),rs.getString("adr"),rs.getString("tel"));
                	listPatient.addElement(p);
                }
                
            }catch (SQLException e){
            	System.out.println("Error in query !!");
                e.printStackTrace();
            }
            
        }catch(SQLException ee){
            System.out.println("Error in connecting !!");
            ee.printStackTrace();
        }
		return listPatient ;
	}
	
	public static int getLastId() {
		int id = 0;
		try {
			cnx = DriverManager.getConnection(jdbcUrl,username,password);
			
			String rep = "SELECT MAX(ID) AS id FROM patient";
			Statement statement = cnx.createStatement();
			ResultSet rs = statement.executeQuery(rep);
			
			while(rs.next()) {
				id = rs.getInt("id");
			}
			
		}catch (SQLException e){
			System.out.println("Error in connecting !!");
            e.printStackTrace();
		}
		
		return id ;
	}
	
	public static int addPatient(Patient p) {
		int res = 0 ;
		try {
			cnx = DriverManager.getConnection(jdbcUrl,username,password);
			String req = "INSERT INTO patient(id,code,nom,prenom,adr,tel) VALUES (?,?,?,?,?,?)";
			PreparedStatement ps = cnx.prepareStatement(req);
			ps.setInt(1, getLastId()+1);
			ps.setString(2, p.getCode());
			ps.setString(3, p.getNom());
			ps.setString(4, p.getPrenom());
			ps.setString(5, p.getAddress());
			ps.setString(6, p.getTel());
			
			res = ps.executeUpdate();
			
		}catch(SQLException e) {
			System.out.println("Error insertion");
			e.printStackTrace();
		}
		return res ;
	}
	
	public static int suppPatient(int id) {
		int res = 0 ;
		try {
			cnx = DriverManager.getConnection(jdbcUrl,username,password);
			String req = "DELETE FROM patient WHERE id = ? ";
			PreparedStatement ps = cnx.prepareStatement(req);
			ps.setInt(1, id);
			
			res = ps.executeUpdate();
			
		}catch(SQLException e) {
			System.out.println("Error suppression ");
			e.printStackTrace();
		}
		return res ;
	}
	

}
