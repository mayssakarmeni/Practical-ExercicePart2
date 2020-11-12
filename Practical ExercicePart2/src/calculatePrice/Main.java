package calculatePrice;

import java.sql.SQLException;
import java.text.ParseException;
import java.sql.Date;
import java.util.Scanner;

public class Main {

	
		
		public static void main(String[] args) throws ClassNotFoundException, SQLException, ParseException {
			// TODO Auto-generated method stub
			 
			System.out.println("Welcome everyone :) ");
			Book book1 = new Book();
			User user = new User();
			Commande c =new Commande();
			byte choix=0;
			do 
			{
			
			System.out.println("choose from this Menu ");
			System.out.println("1:Add book ");
			System.out.println("2:Delete book ");
			System.out.println("3:Update book ");
			System.out.println("4: order ");
			System.out.println("5:Display all the books ");
			System.out.println("6:Add user ");
			System.out.println("7:Delete user ");
			System.out.println("8:Update user ");
			System.out.println("9:Display all the users ");
			System.out.println("10:Display all the orders ");
			System.out.println("11:delete order ");
			System.out.println("12:logout ");

			Scanner sc4 = new Scanner( System.in );
			choix   = sc4.nextByte();
			switch(choix) {
			  case 1:
			  	{	
				System.out.println("Put in the book's title ");
				Scanner sc0 = new Scanner( System.in );
				String title   = sc0.nextLine();
				System.out.println("Put in the book's author ");
				Scanner sc8 = new Scanner( System.in );
				String author   = sc8.nextLine();
				System.out.println("Put in the book's price ");
				Scanner sc2 = new Scanner( System.in );
				double price   = sc2.nextDouble();	
//				 
				System.out.println("enter the release date of the book with this forme (yyyy-mm-dd)");
	            Scanner sc5 = new Scanner( System.in );
	            String doj=sc5.next();
	            Date releasedate=java.sql.Date.valueOf(doj);
				 book1.insertBooks(title, author, price, releasedate);
					break;
				}
			  case 2:
			  	{
			  		book1.displayBook();	
				  System.out.println("Put in book's id ");
					Scanner sc0 = new Scanner( System.in );
					long id   = sc0.nextLong();
					book1.deleteBook(id);
					System.out.println("your book is deleted");
					break;
				}
			  case 3:
			  {
				  System.out.println("Put in the book's id ");
				Scanner sc11 = new Scanner( System.in );
				long id   = sc11.nextLong();
				  System.out.println("Put in the book's title ");
				Scanner sc12 = new Scanner( System.in );
				String title   = sc12.nextLine();
				System.out.println("Put in the book's author ");
				Scanner sc13 = new Scanner( System.in );
				String author   = sc13.nextLine();
				System.out.println("Put in the book's price ");
				Scanner sc7 = new Scanner( System.in );
				double price   = sc7.nextDouble();	
				System.out.println("enter the release date of the book TO UPDATE (yyyy-mm-dd)");
	          Scanner sc5 = new Scanner( System.in );
	          String doj=sc5.next();
	          Date releasedate=java.sql.Date.valueOf(doj);
	          book1.updateBook(title, author, price, releasedate, id);
	        
				break;}
			  case 4:
			  {			  book1.displayBook();

				  c.addCommande();
					break;
					}
			  case 5:
			  {
				  book1.displayBook();
					break;
				}
			  case 6:
			  {System.out.println("Put in the user's name ");
				Scanner sc0 = new Scanner( System.in );
				String name   = sc0.nextLine();
				System.out.println("Put in the user's firstname ");
				Scanner sc11 = new Scanner( System.in );
				String firstname   = sc11.nextLine();
				System.out.println("Put in the user's telephone ");
				Scanner sc2 = new Scanner( System.in );
				long telephone   = sc2.nextLong();	
				System.out.println("Put in the user's email ");
				Scanner sc5 = new Scanner( System.in );
				String email   = sc5.nextLine();
					user.addUser(name, firstname, telephone, email);
			
				break;}
			  case 7:
			  {user.displayUser();	
			  System.out.println("Put in user's id ");
				Scanner sc0 = new Scanner( System.in );
				long id   = sc0.nextLong();
				book1.deleteBook(id);
				break;
					}
			  case 8:
			  {System.out.println("Put in the user's name ");
				Scanner sc2 = new Scanner( System.in );
				String name   = sc2.nextLine();
				System.out.println("Put in the user's firstname ");
				Scanner sc5 = new Scanner( System.in );
				String firstname   = sc5.nextLine();
				System.out.println("Put in the user's telephone ");
				Scanner sc8 = new Scanner( System.in );
				long telephone   = sc8.nextLong();	
				System.out.println("Put in the user's email ");
				Scanner sc9 = new Scanner( System.in );
				String email   = sc9.nextLine();
				System.out.println("Put in user's id ");
				Scanner sc7 = new Scanner( System.in );
				long id   = sc7.nextLong();
					user.updateUser(name, firstname, telephone, email,id);
				break;
					}
			  case 9:
			  {user.displayUser();	
					break;}
			  case 10:
			  {Commande.displaycmd();	
					break;}
			  case 11:
			  {Commande.displaycmd();	
			  System.out.println("Put in cmd's id ");
				Scanner sc0 = new Scanner( System.in );
				long id   = sc0.nextLong();
				c.deletecmd(id);
				break;
					}
			}
			
			}
			while (choix!=12);

				
			System.out.println("Good bye");
			
		
			
		}

	
		
	}


