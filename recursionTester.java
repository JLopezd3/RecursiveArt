package recursionRectangle;

import java.util.Random;

import javafx.scene.shape.Rectangle;

public class recursionTester {

	public static void main(String[] args) {
		RecursionRectangle rec = new RecursionRectangle();
		Rectangle mainRectangle = new Rectangle(1200,700);
		Random r = new Random();
		double denominator = 5.0;
		//t max = denominator;
		int min = 1;
		//t randomNum =  r.nextInt((max - min) + 1) + min;
		double numerator = ((int)(Math.random() * (denominator - 1) + 1));
		//uble fract=randomNum/denominator;
		//stem.out.println(randomNum);
		//stem.out.println(fract);
		System.out.println(numerator);
		System.out.println(1200/denominator * numerator);

	}

}
