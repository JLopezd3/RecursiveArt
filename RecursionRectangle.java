package recursionRectangle;

import java.util.ArrayList;
import javafx.scene.paint.Color;

import javafx.scene.shape.Rectangle;

public class RecursionRectangle {
	ArrayList<Rectangle> allRectangles = new ArrayList<Rectangle>();
	Rectangle mainRectangle = new Rectangle(0,0,1200,700);
	private int count = 0;
	public RecursionRectangle() {

	}

	public Rectangle getMainRectangle() {
		return mainRectangle;
	}

	public void setMainRectangle(Rectangle mainRectangle) {
		this.mainRectangle = mainRectangle;
	}

	public ArrayList<Rectangle> getRectangles() {
		return allRectangles;
	}



	public void setRectangles(ArrayList<Rectangle> rectangles) {
		this.allRectangles = rectangles;
	}



	public ArrayList<Rectangle> fractionRectangle(Rectangle rec, int denominator) {
		ArrayList<Rectangle> twoNewRec = new ArrayList<Rectangle>();
		double numerator = ((int)((Math.random() * (denominator - 1) + 1)));
		if(rec.getWidth() >= rec.getHeight()){//vertical split
			double newWidth = rec.getWidth()-(rec.getWidth()/(double)denominator * numerator);
			Rectangle rec1 = new Rectangle(rec.getX(),rec.getY(),newWidth,rec.getHeight());
			Rectangle rec2 = new Rectangle(rec1.getX() + newWidth,rec.getY(),rec.getWidth()-newWidth,rec.getHeight());
			rec1.setStroke(Color.BLACK);
			rec1.setFill(Color.hsb(recColor(rec1.getWidth(),rec1.getHeight()), 1, 1));
			rec2.setStroke(Color.BLACK);
			rec2.setFill(Color.hsb(recColor(rec2.getWidth(),rec2.getHeight()), 1, 1));
			twoNewRec.add(rec1);
			twoNewRec.add(rec2);
		}
		else if(rec.getHeight() > rec.getWidth()) {//horizontal split
			double newHeight = rec.getHeight()-(rec.getHeight()/(double)denominator * numerator);
			Rectangle rec1 = new Rectangle(rec.getX(),rec.getY(),rec.getWidth(), newHeight);
			Rectangle rec2 = new Rectangle(rec.getX(),rec1.getY() + newHeight,rec.getWidth(),rec.getHeight() - newHeight);
			rec1.setStroke(Color.BLACK);
			rec1.setFill(Color.hsb(recColor(rec1.getWidth(),rec1.getHeight()), 1, 1));
			rec2.setStroke(Color.BLACK);
			rec2.setFill(Color.hsb(recColor(rec2.getWidth(),rec2.getHeight()), 1, 1));
			twoNewRec.add(rec1);
			twoNewRec.add(rec2);
		}
		return twoNewRec;
	}
	public int recColor(double width, double height) {
		int hueValue = (int) ((width * height)%361);
		return hueValue;
	}
	public ArrayList<Rectangle> recursiveRec(Rectangle rec,int level,int denominator) {
		if(level == 0) {
			allRectangles.clear();
			return allRectangles;
		}
		if(level == 1) {
			rec.setStroke(Color.BLACK);
			rec.setFill(Color.hsb(recColor(rec.getWidth(),rec.getHeight()), 1, 1));
			allRectangles.add(rec);
			return allRectangles;
		}
		if(level == 2) {
			allRectangles.addAll(fractionRectangle(mainRectangle, 2));
			return allRectangles;
		}

		if(count == Math.pow(2, level-1)-1) {
			System.out.println("Count: " + count + allRectangles.get(count));
			return allRectangles;
		}
		else{
			allRectangles.addAll(fractionRectangle(rec, denominator));
			System.out.println("Count: " + count + allRectangles.get(count));
			recursiveRec(allRectangles.get(this.count++), level, denominator);
		}
		return null;
	}

}
