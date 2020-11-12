	package calculatePrice;
	
	import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Connection.MyConnection;

import java.sql.Date;



	
		public class Book {
			private long idBook;
		private String Title;
		private String Author;
		private double Price;
		private Date ReleaseDate;
		Connection c =null;
		Statement stmt =null;
		
		
		public Book(long idBook, String title, String author, double price, Date releaseDate) {
			super();
			this.idBook = idBook;
			Title = title;
			Author = author;
			Price = price;
			ReleaseDate = releaseDate;
		}

		public Book() {
			super();
		}

		public String getTitle() {
			return Title;
		}
		public void setTitle(String title) {
			Title = title;
		}
		public String getAuthor() {
			return Author;
		}
		public void setAuthor(String author) {
			Author = author;
		}
		public double getPrice() {
			return Price;
		}
		public void setPrice(double price) {
			Price = price;
		}
		public Date getRealeaseDate() {
			return ReleaseDate;
		}
		public void setRealeaseDate(Date realeaseDate) {
			ReleaseDate = realeaseDate;
		}
		
		
		public void insertBooks (String Title, String Author, double Price, Date ReleaseDate ) throws ClassNotFoundException, SQLException
		  {
			MyConnection c;
		    PreparedStatement pstmt;
		    c = new MyConnection();
			    if (c==null)
		            System.out.println("server connection error!");
		            else System.out.println("Connected !");
			    pstmt =  c.Myconnect().prepareStatement("INSERT INTO `book`(idBook,title_book,author_book,price_book,releaseDate_book) VALUES (? , ?, ?, ?, ?)");
			    pstmt.setNString(1, null );
			    pstmt.setString(2, Title );
			    pstmt.setString(3, Author );
			    pstmt.setDouble(4,Price);
			    pstmt.setDate(5, ReleaseDate);
			    System.out.println("Added with Success");
			    pstmt.executeUpdate();
		  }
	
	public void deleteBook(long idbook) throws ClassNotFoundException, SQLException
	    {    MyConnection c;
	    PreparedStatement pstmt;
	    c = new MyConnection();
	    try {
	   pstmt =  c.Myconnect().prepareStatement("DELETE FROM book WHERE idBook =?");
	  
	    pstmt.setLong(1,idBook);
	    pstmt.executeUpdate();
	    System.out.println("Deleted !");
	    }
	    catch(SQLException e)
	    {e.printStackTrace();}
	           
	        }

		public void displayBook() throws ClassNotFoundException, SQLException 
	    {   MyConnection c;
	    PreparedStatement pstmt;
	    c = new MyConnection();
		    if (c==null)
	            System.out.println("server connection error!");
	            else System.out.println("Connected !");
		    
	    try {
	    	pstmt =  c.Myconnect().prepareStatement("SELECT * FROM Book "); 
	    ResultSet rs = pstmt.executeQuery();
	    int i=0;
	    while (rs.next()) {
	        i++;
	        System.out.println("Book n° "+i);
	        System.out.println("id : " + rs.getString("idBook"));
	        System.out.println("title : " + rs.getString("title_book"));
	        System.out.println("author : " + rs.getString("author_book"));
	        System.out.println("telephone : " + rs.getString("price_book"));
	        System.out.println("date: " + rs.getString("releaseDate_book"));
	    }}
	    catch(SQLException e)
	    {e.printStackTrace();}
	
	 
	
	     }
		public long getIdBook() {
			return idBook;
		}

		public void setIdBook(long idBook) {
			this.idBook = idBook;
		}

		public double CalculTotal(int quantite) throws ClassNotFoundException, SQLException
	    {    MyConnection c;
	    double CalculTotal = 0;
	    PreparedStatement pstmt;
	    c = new MyConnection();
		    if (c==null)
	            System.out.println("server connection error!");
	            else System.out.println("Connected !");
		    
	    try {
	    	pstmt =  c.Myconnect().prepareStatement("SELECT * FROM Book where idBook = ? ");
	            pstmt.setLong(1,idBook);
	            ResultSet rs = pstmt.executeQuery();
	            while (rs.next()) {
	               
	              CalculTotal = Double.parseDouble(rs.getString("price_book"))*quantite;
	           
	            }}
	            catch(SQLException e)
	    
	            {e.printStackTrace();
	            return 0 ; }
		return CalculTotal;
		
		
	    
	   
	    }
		public void updateBook(String title, String author, double price,Date releaseDate,long idBook) throws ClassNotFoundException, SQLException 
		{   MyConnection con;
		PreparedStatement pstmt;
	    con = new MyConnection();
	    
	    try {
	    		pstmt = con.Myconnect().prepareStatement("UPDATE book SET title_book = ?,author_book = ?,price_book = ?,releaseDate_book = ? WHERE idBook = ?"); 
	    		pstmt.setLong(6, idBook );
	    		pstmt.setString(2, title );
	    		pstmt.setString(3, author );
	    		pstmt.setDouble(4,price);
	    		pstmt.setDate(5, releaseDate );
	    		pstmt.executeUpdate();
	    	}
	    
	    catch(SQLException e)
	    {
	    	e.printStackTrace();}    	
		 }
		}
