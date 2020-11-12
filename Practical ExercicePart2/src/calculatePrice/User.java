package calculatePrice;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.PreparedStatement;

import Connection.MyConnection;

public class User {
	private long idUser;
	private String nom;
	private String prenom;
	private long telephone;
	private String email;
	
	
	public long getIdUser() {
		return idUser;
	}

	public void setIdUser(long idUser) {
		this.idUser = idUser;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public long getTelephone() {
		return telephone;
	}
	public void setTelephone(long telephone) {
		this.telephone = telephone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public User() {
		super();
	}
	public User(long idUser, String nom, String prenom, long telephone, String email) {
		super();
		this.idUser = idUser;
		this.nom = nom;
		this.prenom = prenom;
		this.telephone = telephone;
		this.email = email;
	}
	@Override
	public String toString() {
		return "User [idUser=" + idUser + ", nom=" + nom + ", prenom=" + prenom + ", telephone=" + telephone + ", email="
				+ email + "]";
	}

	public void addUser(String nom, String prenom, long telephone, String email) throws ClassNotFoundException, SQLException 
	{ 
		MyConnection c;
	PreparedStatement pstmt;
    c = new MyConnection();
    
    pstmt =  (PreparedStatement) c.Myconnect().prepareStatement("INSERT INTO `user`(idUser,nom,prenom,telephone,email) VALUES (? , ?, ?, ?, ?)");
    pstmt.setNString(1, null );
    pstmt.setString(2, nom );
    pstmt.setString(3, prenom );
    pstmt.setLong(4,telephone);
    pstmt.setString(5, email );
	System.out.println("addition with success");
	pstmt.executeUpdate();
	}

public void displayUser() throws ClassNotFoundException, SQLException 
{   MyConnection con;
PreparedStatement pstmt;
con = new MyConnection();
try {
pstmt = (PreparedStatement) con.Myconnect().prepareStatement("SELECT * FROM User "); 
ResultSet rs = pstmt.executeQuery();
int i=0;
while (rs.next()) {
	i++;
    System.out.println("User n°"+i);
    System.out.println("idUser : " + rs.getString("idUser")+" Nom : " 
    + rs.getString("nom")+" Prenom : " 
    + rs.getString("prenom")+" Telephone : " 
    + rs.getString("telephone")+" Email : " 
    + rs.getString("email"));
                   }
	}
catch(SQLException e)
{e.printStackTrace();}
 }




public void deleteUser(long id) throws ClassNotFoundException, SQLException 
{    MyConnection con;
	PreparedStatement pstmt;
	con = new MyConnection();
	try {
		pstmt = (PreparedStatement) con.Myconnect().prepareStatement("DELETE FROM user WHERE idUser =?"); 

		pstmt.setLong(1,idUser);
		pstmt.executeUpdate();
		System.out.println("user deleted succsefuly");
		}
	catch(SQLException e)
		{e.printStackTrace();}	
  }



public void updateUser(String nom, String prenom, long telephone,String email,long idUser) throws ClassNotFoundException, SQLException 
{   MyConnection con;
PreparedStatement pstmt;
con = new MyConnection();

try {
		pstmt = (PreparedStatement) con.Myconnect().prepareStatement("UPDATE user SET nom = ?,prenom = ?,telephone = ?,email = ? WHERE idUser = ?"); 
		pstmt.setLong(6, idUser);
		pstmt.setString(2, nom);
		pstmt.setString(3, prenom);
		pstmt.setLong(4,telephone);
		pstmt.setString(5, email);
		pstmt.executeUpdate();
		System.out.println("user updated succsefuly");
	}

catch(SQLException e)
{
	e.printStackTrace();}    	
 }
}