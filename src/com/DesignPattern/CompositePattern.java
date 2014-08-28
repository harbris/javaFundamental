package com.DesignPattern;

import java.util.List;
import java.util.ArrayList;

//컴포지트 패턴(Composite pattern)이란 객체들의 관계를 트리 구조로 구성하여 부분-전체 계층을 표현하는 패턴으로, 사용자가 단일 객체와 복합 객체 모두 동일하게 다루도록 한다

 
/** "Component" */
interface Graphic {
 
    //Prints the graphic.
    public void print();
 
}
 
/** "Composite" */
class CompositeGraphic implements Graphic {
    
	static{
		System.out.println("aa");
	}
    //Collection of child graphics.
    private List<Graphic> mChildGraphics = new ArrayList<Graphic>();
 
    //Prints the graphic.
    public void print() {
        for (Graphic graphic : mChildGraphics) {
            graphic.print();
        }
    }
 
    //Adds the graphic to the composition.
    public void add(Graphic graphic) {
        mChildGraphics.add(graphic);
    }
 
    //Removes the graphic from the composition.
    public void remove(Graphic graphic) {
        mChildGraphics.remove(graphic);
    }
 
}
 
 
/** "Leaf" */
class Ellipse implements Graphic {
 
    //Prints the graphic.
    public void print() {
        System.out.println("Ellipse");
    }
 
}
 
 
/** Client */
public class CompositePattern {
 
    public static void main(String[] args) {
        //Initialize four ellipses
        Ellipse ellipse1 = new Ellipse();
        Ellipse ellipse2 = new Ellipse();
        Ellipse ellipse3 = new Ellipse();
        Ellipse ellipse4 = new Ellipse();
 
        //Initialize three composite graphics
        CompositeGraphic graphic = new CompositeGraphic();
        CompositeGraphic graphic1 = new CompositeGraphic();
        CompositeGraphic graphic2 = new CompositeGraphic();
        System.out.println("b"+graphic.toString());
        System.out.println("b"+graphic1.toString());
        System.out.println("b"+graphic2.toString());
 
        //Composes the graphics
        graphic1.add(ellipse1);
        graphic1.add(ellipse2);
        graphic1.add(ellipse3);
 
        graphic2.add(ellipse4);
 
        graphic.add(graphic1);
        graphic.add(graphic2);
 
        //Prints the complete graphic (four times the string "Ellipse").
        graphic.print();
    }
}