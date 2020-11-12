package calculatePrice;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Scanner;

import Connection.MyConnection;

public class Commande {
private long id;
private String  nomCommande;

private double PrixTotale;
private int qantité;
Book b;
User u;

public long getId() {
	return id;
}
public void setId(long id) {
	this.id = id;
}
public String getNomCommande() {
	return nomCommande;
}
public void setNomCommande(String nomCommande) {
	this.nomCommande = nomCommande;
}


public double getPrixTotale() {
	return PrixTotale;
}
public void setPrixTotale(double prixTotale) {
	PrixTotale = prixTotale;
}

public int getQantité() {
	return qantité;
}
public void seQantité(int quantite) {
	qantité = quantite;
}
public Book getB() {
	return b;
}
public void setB(Book b) {
	this.b = b;
}

public User getU() {
	return u;
}
public void setU(User u) {
	this.u = u;
}
@Override
public String toString() {
	return "Commande [id=" + id + ", nomCommande=" + nomCommande + ", PrixTotale="
			+ PrixTotale + ", qantité=" + qantité + "]";
}
public Commande() {
	super();
}
public Commande(long id, String nomCommande,  double prixTotale, int qantité) {
	super();
	this.id = id;
	this.nomCommande = nomCommande;
	
	PrixTotale = prixTotale;
	qantité = qantité;
}



// try {
//        pstmt = con.Myconnect().prepareStatement("SELECT * FROM Book where idBook = ? "); 
//
//        pstmt.setLong(1,idBook);
//       
//        ResultSet rs = pstmt.executeQuery();
//        while (rs.next()) 
//            {
//             pricebook =Double.parseDouble(rs.getString("Price" ));
//            }
//        }
//        catch(SQLException e)
//        {
//            e.printStackTrace();
//        }

public void addCommande ( ) throws ClassNotFoundException, SQLException
{
	Book b =new Book();
	MyConnection c;
  PreparedStatement pstmt;
  c = new MyConnection();
	    if (c==null)
          System.out.println("server connection error!");
          else System.out.println("Connected !");
	    System.out.println("Put in the book's id ");
	    Scanner sc1 = new Scanner( System.in );
	    long idBook   = sc1.nextLong();
	    System.out.println("Put in the price ");
	    Scanner sc2 = new Scanner( System.in );
	    double price_book   = sc2.nextDouble();
	    System.out.println("Put in the name ");
	    Scanner sc3 = new Scanner( System.in );
	    String nomCommande   = sc3.nextLine();
	    double priceT=0;
	    try {
	    	pstmt = c.Myconnect().prepareStatement("SELECT * FROM Book where idBook = ? ");
	    	pstmt.setDouble(1,idBook);
	    	ResultSet rs = pstmt.executeQuery();
	    	while (rs.next())
	    	{
	    		priceT =Double.parseDouble(rs.getString("price_book"));
	    	}
	    	}
	    	catch(SQLException e)
	    	{
	    	e.printStackTrace();
	    	}
	    pstmt =  c.Myconnect().prepareStatement("INSERT INTO `commande`(id,idBook,nomCommande,qantité,PrixTotale) VALUES (  ?, ?, ?,?,?)");
	    pstmt.setNString(1, null );
	    pstmt.setLong(2, idBook );
	    pstmt.setString(3, nomCommande );
	    pstmt.setInt(4, qantité );
	    pstmt.setDouble(5,qantité*price_book );
	    System.out.println("addition with success");
	    pstmt.executeUpdate();


}
public  void deletecmd(long id ) throws ClassNotFoundException, SQLException
{    MyConnection c;
PreparedStatement pstmt;
c = new MyConnection();
try {
pstmt =  c.Myconnect().prepareStatement("DELETE FROM commande WHERE id =?");

pstmt.setLong(1,id);
pstmt.executeUpdate();
System.out.println("Deleted !");
}
catch(SQLException e)
{e.printStackTrace();}
       
    }

public static void displaycmd() throws ClassNotFoundException, SQLException 
{   MyConnection c;
PreparedStatement pstmt;
c = new MyConnection();
    if (c==null)
        System.out.println("server connection error!");
        else System.out.println("Connected !");
    
try {
	pstmt =  c.Myconnect().prepareStatement("SELECT * FROM commande "); 
ResultSet rs = pstmt.executeQuery();
int i=0;
while (rs.next()) {
    i++;
    System.out.println("Commande n° "+i);
    System.out.println("id : " + rs.getString("id"));
    System.out.println("idBook : " + rs.getString("idBook"));
    System.out.println("nomCommande : " + rs.getString("nomCommande"));
    System.out.println("qantité : " + rs.getString("qantité"));
    System.out.println("PrixTotale: " + rs.getString("PrixTotale"));
}}
catch(SQLException e)
{e.printStackTrace();}
}
}

