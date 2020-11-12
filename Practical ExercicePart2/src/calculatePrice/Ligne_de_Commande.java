package calculatePrice;



public class Ligne_de_Commande {
private double Quantite;
private Book b;

@Override
public String toString() {
	return "Ligne_de_Commande [Quantite=" + Quantite + ", b=" + b + "]";
}
public Book getB() {
	return b;
}
public void setB(Book b) {
	this.b = b;
}
public double getQuantite() {
	return Quantite;
}
public void setQuantite(double quantite) {
	Quantite = quantite;
}
public Ligne_de_Commande(double quantite, Book b) {
	super();
	Quantite = quantite;
	this.b = b;
}







}


