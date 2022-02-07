package com.jlbc.geometry;

public class Main {

    static void testingClassPoint() {
        System.out.println("***********************");
        System.out.println("***   CLASS Point   ***");
        System.out.println("***********************");
        System.out.println();
        System.out.println("1. Create the origin point");
        Point pointA = new Point();
        System.out.println("   (" + pointA.getX() + "," + pointA.getY() + ")");
        System.out.println();
        System.out.println("2. Create the point in -3.4 y 4.35");
        Point pointB = new Point(-3.4, 4.35);
        System.out.println("   (" + pointB.getX() + "," + pointB.getY() + ")");
        System.out.println();
        System.out.println("3. Calculate distance between them");
        System.out.println("   " + pointA.distanceTo(pointB));
        System.out.println();
        System.out.println("4. Move both points 1.4 right and 3.7 down");
        pointA.translate(1.4, -3.7);
        pointB.translate(1.4, -3.7);
        System.out.println("   (" + pointA.getX() + "," + pointA.getY() + ")");
        System.out.println("   (" + pointB.getX() + "," + pointB.getY() + ")");
        System.out.println();
        System.out.println("5. Calculate distance again");
        System.out.println("   " + pointA.distanceTo(pointB));
        System.out.println();
        System.out.println();
    }

    static void testingClassCircle() {
        System.out.println("************************");
        System.out.println("***   CLASS Circle   ***");
        System.out.println("************************");
        System.out.println();
        System.out.println("1. Create circle in (-3,-7.4) with 3.77 radius");
        Point center = new Point(-3, -7.4);
        Circle circle = new Circle(center, 3.77);
        System.out.println();
        System.out.println("2. Print its information");
        System.out.println("   Center: (" + circle.getCenter().getX() + "," + circle.getCenter().getY() + ")");
        System.out.println("   Radius: " + circle.getRadius());
        System.out.println("   Diameter: " + circle.getDiameter());
        System.out.println("   Area: " + circle.getArea());
        System.out.println("   Perimeter: " + circle.getPerimeter());
        System.out.println();
        System.out.println("3. Move its center to (3,3) and after move its center 1.4 right and 3.7 down");
        circle.translate(new Point(3,3));
        circle.translate(1.4, -3.7);
        System.out.println();
        System.out.println("4. Print its information");
        System.out.println("   Center: (" + circle.getCenter().getX() + "," + circle.getCenter().getY() + ")");
        System.out.println("   Radius: " + circle.getRadius());
        System.out.println("   Diameter: " + circle.getDiameter());
        System.out.println("   Area: " + circle.getArea());
        System.out.println("   Perimeter: " + circle.getPerimeter());
        System.out.println();
        System.out.println("5. Resize its radius to 10");
        circle.resize(10);
        System.out.println();
        System.out.println("6. Print its information");
        System.out.println("   Center: (" + circle.getCenter().getX() + "," + circle.getCenter().getY() + ")");
        System.out.println("   Radius: " + circle.getRadius());
        System.out.println("   Diameter: " + circle.getDiameter());
        System.out.println("   Area: " + circle.getArea());
        System.out.println("   Perimeter: " + circle.getPerimeter());
        System.out.println();
        System.out.println();
    }

    static void testingClassEllipse() {
        System.out.println("*************************");
        System.out.println("***   CLASS Ellipse   ***");
        System.out.println("*************************");
        System.out.println();
        System.out.println("1. Create an horizontal ellipse with center in (7.5, -2.3),");
        System.out.println("   semi-major axis 3.5, and semi-minor axis 2");
        Point center = new Point(7.5, -2.3);
        Ellipse ellipse = new Ellipse(center, 3.5, 2, "Horizontal");
        System.out.println();
        System.out.println("2. Print its information");
        System.out.println("   Center: (" + ellipse.getCenter().getX() + "," + ellipse.getCenter().getY() + ")");
        System.out.println("   Semi-major axis: " + ellipse.getSemiMajorAxis());
        System.out.println("   Semi-minor axis: " + ellipse.getSemiMinorAxis());
        System.out.println("   Orientation: " + ellipse.getOrientation());
        System.out.println("   Eccentricity: " + ellipse.getEccentricity());
        System.out.println("   Area: " + ellipse.getArea());
        System.out.println("   Perimeter: " + ellipse.getPerimeter());
        System.out.println("   Focus 1: (" + ellipse.getFocus1().getX() + "," + ellipse.getFocus1().getY() + ")");
        System.out.println("   Focus 2: (" + ellipse.getFocus2().getX() + "," + ellipse.getFocus2().getY() + ")");
        System.out.println("   Vertex 1: (" + ellipse.getVertex1().getX() + "," + ellipse.getVertex1().getY() + ")");
        System.out.println("   Vertex 2: (" + ellipse.getVertex2().getX() + "," + ellipse.getVertex2().getY() + ")");
        System.out.println("   Covertex 1: (" + ellipse.getCovertex1().getX() + "," + ellipse.getCovertex1().getY() + ")");
        System.out.println("   Covertex 2: (" + ellipse.getCovertex2().getX() + "," + ellipse.getCovertex2().getY() + ")");
        System.out.println();
        System.out.println("3. Move the ellipse 1.4 right and 3.7 down");
        ellipse.translate(1.4, -3.7);
        System.out.println();
        System.out.println("4. Print its information");
        System.out.println("   Center: (" + ellipse.getCenter().getX() + "," + ellipse.getCenter().getY() + ")");
        System.out.println("   Semi-major axis: " + ellipse.getSemiMajorAxis());
        System.out.println("   Semi-minor axis: " + ellipse.getSemiMinorAxis());
        System.out.println("   Orientation: " + ellipse.getOrientation());
        System.out.println("   Eccentricity: " + ellipse.getEccentricity());
        System.out.println("   Area: " + ellipse.getArea());
        System.out.println("   Perimeter: " + ellipse.getPerimeter());
        System.out.println("   Focus 1: (" + ellipse.getFocus1().getX() + "," + ellipse.getFocus1().getY() + ")");
        System.out.println("   Focus 2: (" + ellipse.getFocus2().getX() + "," + ellipse.getFocus2().getY() + ")");
        System.out.println("   Vertex 1: (" + ellipse.getVertex1().getX() + "," + ellipse.getVertex1().getY() + ")");
        System.out.println("   Vertex 2: (" + ellipse.getVertex2().getX() + "," + ellipse.getVertex2().getY() + ")");
        System.out.println("   Covertex 1: (" + ellipse.getCovertex1().getX() + "," + ellipse.getCovertex1().getY() + ")");
        System.out.println("   Covertex 2: (" + ellipse.getCovertex2().getX() + "," + ellipse.getCovertex2().getY() + ")");
        System.out.println();
        System.out.println("5. Resize the ellipse by 1.7 factor");
        ellipse.resize(1.7);
        System.out.println();
        System.out.println("6. Print its information");
        System.out.println("   Center: (" + ellipse.getCenter().getX() + "," + ellipse.getCenter().getY() + ")");
        System.out.println("   Semi-major axis: " + ellipse.getSemiMajorAxis());
        System.out.println("   Semi-minor axis: " + ellipse.getSemiMinorAxis());
        System.out.println("   Orientation: " + ellipse.getOrientation());
        System.out.println("   Eccentricity: " + ellipse.getEccentricity());
        System.out.println("   Area: " + ellipse.getArea());
        System.out.println("   Perimeter: " + ellipse.getPerimeter());
        System.out.println("   Focus 1: (" + ellipse.getFocus1().getX() + "," + ellipse.getFocus1().getY() + ")");
        System.out.println("   Focus 2: (" + ellipse.getFocus2().getX() + "," + ellipse.getFocus2().getY() + ")");
        System.out.println("   Vertex 1: (" + ellipse.getVertex1().getX() + "," + ellipse.getVertex1().getY() + ")");
        System.out.println("   Vertex 2: (" + ellipse.getVertex2().getX() + "," + ellipse.getVertex2().getY() + ")");
        System.out.println("   Covertex 1: (" + ellipse.getCovertex1().getX() + "," + ellipse.getCovertex1().getY() + ")");
        System.out.println("   Covertex 2: (" + ellipse.getCovertex2().getX() + "," + ellipse.getCovertex2().getY() + ")");
        System.out.println();
        System.out.println();
    }

    static void testingClassRegularHeptagon() {
        System.out.println("*********************************");
        System.out.println("***   CLASS RegularHeptagon   ***");
        System.out.println("*********************************");
        System.out.println();
        System.out.println("1. Create an heptagon with center in (1,1) and first vertex in (1,6)");
        Point center = new Point(1, 1);
        Point vertex = new Point(1, 6);
        RegularHeptagon heptagon = new RegularHeptagon(center, vertex);
        System.out.println();
        System.out.println("2. Print its information");
        System.out.println("   Center: (" + heptagon.getCenter().getX() + "," + heptagon.getCenter().getY() + ")");
        System.out.println("   Radius: " + heptagon.getRadius());
        System.out.println("   Apothem: " + heptagon.getApothem());
        System.out.println("   Side: " + heptagon.getSide());
        System.out.println("   Perimeter: " + heptagon.getPerimeter());
        System.out.println("   Area: " + heptagon.getArea());
        System.out.println("   Vertices:");
        for (int i = 0; i < 7; i++)
            System.out.println("      Vertex " + (i + 1) + ": (" + 
                                      heptagon.getVertex(i).getX() + "," + 
                                      heptagon.getVertex(i).getY() + ")");
        System.out.println();
        System.out.println("3. Move the heptagon 1.4 right and 3.7 down");
        heptagon.translate(1.4, -3.7);
        System.out.println();
        System.out.println("4. Print its information");
        System.out.println("   Center: (" + heptagon.getCenter().getX() + "," + heptagon.getCenter().getY() + ")");
        System.out.println("   Radius: " + heptagon.getRadius());
        System.out.println("   Apothem: " + heptagon.getApothem());
        System.out.println("   Side: " + heptagon.getSide());
        System.out.println("   Perimeter: " + heptagon.getPerimeter());
        System.out.println("   Area: " + heptagon.getArea());
        System.out.println("   Vertices:");
        for (int i = 0; i < 7; i++)
            System.out.println("      Vertex " + (i + 1) + ": (" + 
                                      heptagon.getVertex(i).getX() + "," + 
                                      heptagon.getVertex(i).getY() + ")");
        System.out.println();
        System.out.println("5. Resize the heptagon to have 7.7 radius");
        heptagon.resize(7.7);
        System.out.println();
        System.out.println("6. Print its information");
        System.out.println("   Center: (" + heptagon.getCenter().getX() + "," + heptagon.getCenter().getY() + ")");
        System.out.println("   Radius: " + heptagon.getRadius());
        System.out.println("   Apothem: " + heptagon.getApothem());
        System.out.println("   Side: " + heptagon.getSide());
        System.out.println("   Perimeter: " + heptagon.getPerimeter());
        System.out.println("   Area: " + heptagon.getArea());
        System.out.println("   Vertices:");
        for (int i = 0; i < 7; i++)
            System.out.println("      Vertex " + (i + 1) + ": (" + 
                                      heptagon.getVertex(i).getX() + "," + 
                                      heptagon.getVertex(i).getY() + ")");
        System.out.println();
        System.out.println("7. Rotate the heptagon 37 degrees counterclockwise");
        heptagon.rotate(37);
        System.out.println();
        System.out.println("8. Print its information");
        System.out.println("   Center: (" + heptagon.getCenter().getX() + "," + heptagon.getCenter().getY() + ")");
        System.out.println("   Radius: " + heptagon.getRadius());
        System.out.println("   Apothem: " + heptagon.getApothem());
        System.out.println("   Side: " + heptagon.getSide());
        System.out.println("   Perimeter: " + heptagon.getPerimeter());
        System.out.println("   Area: " + heptagon.getArea());
        System.out.println("   Vertices:");
        for (int i = 0; i < 7; i++)
            System.out.println("      Vertex " + (i + 1) + ": (" + 
                                      heptagon.getVertex(i).getX() + "," + 
                                      heptagon.getVertex(i).getY() + ")");
        System.out.println();
        System.out.println();
    }

    public static void main(String[] args) {
        testingClassPoint();
        testingClassCircle();
        testingClassEllipse();
        testingClassRegularHeptagon();

        System.out.println("ALL DONE!");
    }    
}
