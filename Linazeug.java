import java.io.*;
import java.util.Scanner;

public class Linazeug {

    public static void main(String[] args) {
		lkg();
		//eea();
    }
	
	/* Erweiterter Euklidischer Algorithmus: 
	 * gibt ggT von r_1, r_2 an und Loesung x, y fuer die Gleichung 
	 * ggT(r_1, r_2) = r_1 * x + r_2 * y
	*/
	public static void eea() {
	
		Scanner scan = new Scanner(System.in);

		System.out.print("Bitte r0 eingeben: ");
		int r_2 = scan.nextInt();	
		
		System.out.print("Bitte r1 eingeben: ");
		int r_1 = scan.nextInt();
		
		// nicht zwingend, aber praktischer beim Ermitteln des ggT, wenn erste Zahl > zweite Zahl
		if (r_2 < r_1) {
			int temp1 = r_2;
			r_2 = r_1;
			r_1 = temp1;
		}
		
		int r_now, q;
		int x_now = 0, x_2 = 1, x_1 = 0;
		int y_now = 0, y_2 = 0, y_1 = 1;
		int counter = 2;
		
		while(true) {
			r_now = r_2 % r_1;
			System.out.println("r" + counter + " = " + r_2 + " mod " + r_1 + " = " + r_now);
			if (r_now == 0) {
				System.out.println("Abbruch!");
				break;
			}
			q = r_2 / r_1;
			System.out.println("q" + counter + " = " + r_2 + " div " + r_1 + " = " + q);
			x_now = x_2 - q * x_1;
			System.out.println("x" + counter + " = " + x_2 + " - " + q + " * " + x_1 + " = " + x_now);
			y_now = y_2 - q * y_1;
			System.out.println("y" + counter + " = " + y_2 + " - " + q + " * " + y_1 + " = " + y_now);
			
			r_2 = r_1;
			r_1 = r_now;
			x_2 = x_1;
			x_1 = x_now;
			y_2 = y_1;
			y_1 = y_now;
			
			counter++;
			}
			System.out.println("Ergebnisse: x = " + x_now + ", y = " + y_now + ", ggT: " + r_1);
	
	}
	/* Linearer Kongruenzgenerator
	 * Erzeugt Pseudozufallszahlen nach folgendem Prinzip:
	 * Zufallszahl i = Konstante a * Zufallszahl i-1 + Konstante c
	 * Die erste Zufallszahl wird als 'Seed' bezeichnet und wird
	 * dem Programm uebergeben. Wert 'm' beschraenkt den Bereich
	 * der moeglichen Zufallszahlen auf {0,1,...,m-1}.
	 * Parameter so waehlen, dass moeglichst lange Perioden enstehen!
	*/
    public static void lkg() {

		Scanner scan = new Scanner(System.in);

		System.out.print("Bitte m eingeben: ");
		int m = scan.nextInt();
			
		System.out.print("Bitte a eingeben: ");
		int a = scan.nextInt();
			
		System.out.print("Bitte c eingeben: ");
		int c = scan.nextInt();
			
		System.out.print("Bitte seed (x0) eingeben: ");
		int seed = scan.nextInt();

		int oldX = seed;
		int newX;

			for(int i = 1; i <= m; i++) {
				newX = (a * oldX + c) % m;
				System.out.println("X" + i + " = " + a + " * " + oldX + " + " + c + " = " + newX);
				oldX = newX;
			}
    }
}
