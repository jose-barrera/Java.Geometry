package com.jlbc.geometry;

/*
 *    ----------------------------------------------------------------
 *    |                        RegularHeptagon                       |
 *    |--------------------------------------------------------------|
 *    | center: Point                                                |
 *    | radius: numeric                                              |
 *    | apothem: numeric                                             |
 *    | side: numeric                                                |
 *    | vertices: Point (collection)                                 |
 *    | area: numeric                                                |
 *    | perimeter: numeric                                           |
 *    |--------------------------------------------------------------|
 *    | <<constructor> RegularHeptagon(center: Point, vertex: Point) |
 *    | translate(dx: numeric, dy: numeric)                          |
 *    | resize(radius: numeric)                                      |
 *    | rotate(angle: numeric)                                       |
 *    ----------------------------------------------------------------
 *    
 */

public class RegularHeptagon {
    
    // <editor-fold desc="INTERNAL FIELDS">

    /* 
     * REMEMBER: Internal fields are variables that ALWAYS must be
     *           private (encapsulation) and they are used to store
     *           object data.
     */

    private Point center;
    private double radius;
    private double apothem;
    private double side;
    private Point[] vertices;
    private double area;
    private double perimeter;

    // </editor-fold>

    // <editor-fold desc="PROPERTIES">

    /* REMEMBER: Properties are a protection mechanism to accomplish
     *           encapsulation. Any property may have 2 components:
     *           a) ACCESSOR, responsible to give access to the
     *              internal field (read).
     *           b) MUTATOR, responsible to allow modification of
     *              the internal field (write).
     *           Properties with both accessor and mutator are READ/WRITE.
     *           Properties with only accessor are READ-ONLY.
     *           Properties with only mutator are WRITE-ONLY.
     */

    public Point getCenter() {
        return this.center;
    }
    public double getRadius() {
        return this.radius;
    }
    public double getApothem() {
        return this.apothem;
    }
    public double getSide() {
        return this.side;
    }
    public double getArea() {
        return this.area;
    }
    public double getPerimeter() {
        return this.perimeter;
    }
    public Point getVertex(int i) {
        return this.vertices[i];
    }

    // </editor-fold>

    // <editor-fold desc="CONSTRUCTORS">

    /* REMEMBER: Constructors are special functions whose name is 
     *           always the same of the class. Its responsibility
     *           is to establish an initial VALID state of the object.
     */

    // Builds a heptagon from its center and first vertex, calculating
    // other vertices counterclockwise.
    public RegularHeptagon(Point center, Point vertex) {
        // Center and vertex cannot be the same point.
        if (!(center.getX() == vertex.getX() && center.getY() == vertex.getY())) {
            // Stores the center.
            this.center = center;
            // Calculates radius (distance from center to vertex).
            this.radius = center.distanceTo(vertex);
            // Calculates vertices.
            this.vertices = new Point[7];
            this.vertices[0] = vertex;
            double x, y;
            double angle = Math.PI * 2 / 7;
            for (int i = 1; i < 7; i++) {
                x = Math.cos(i * angle) * (vertex.getX() - center.getX()) - 
                    Math.sin(i * angle) * (vertex.getY() - center.getY()) + 
                    center.getX();
                y = Math.sin(i * angle) * (vertex.getX() - center.getX()) + 
                    Math.cos(i * angle) * (vertex.getY() - center.getY()) + 
                    center.getY();
                this.vertices[i] = new Point(x, y);
            }
            // Calculates apothem (radius multiplied by the cosine of PI/7).
            this.apothem = this.radius * Math.cos(Math.PI / 7);
            // Calculates side (distance between 2 consecutive vertices).
            this.side = this.vertices[0].distanceTo(this.vertices[1]);
            // Calculates perimeter (side length multiplied by seven).
            this.perimeter = this.side * 7;
            // Calculates area (half the product of its perimeter and its apothem).
            this.area = this.perimeter * this.apothem / 2;
        }
        else {
            throw new IllegalArgumentException("ERR: Center and vertex cannot be the same point.");
        }    
    }

    // </editor-fold>

    // <editor-fold desc="METHODS">

    /* REMEMBER: Methods are functions inside the class that defines
     *           the behaviour of the objects.
     */

    // Moves the heptagon offsetting its center and vertices a given
    // horizontal and vertical distance. All other properties remains
    // the same.
    public void translate(double dx, double dy) {
        this.center.translate(dx, dy);
        for (Point vertex : this.vertices) {
            vertex.translate(dx, dy);
        }
    }

    // Resizes the heptagon based on its circumscribed radius. Some
    // of its properties must be recalculated.
    public void resize(double radius) {
        // The radius must be positive.
        if (radius > 0) {
            // Stores the radius.
            this.radius = radius;
            // Calculate the slope of the segment from center
            // to first vertex, and then the new vertex in that
            // direction from center.
            double slope, theta;
            double dx = this.vertices[0].getX() - this.center.getX();
            double dy = this.vertices[0].getY() - this.center.getY();
            if (dx != 0) {
                slope = dy / dx;
                theta = Math.atan(slope);
            }
            else if (dy > 0)
                theta = Math.PI / 2;
            else
                theta = 3 * Math.PI / 2;
            double x = this.center.getX() + radius * Math.cos(theta);
            double y = this.center.getY() + radius * Math.sin(theta);
            // Calculates the new vertices.
            Point vertex = new Point(x, y);
            this.vertices[0] = vertex;
            double angle = Math.PI * 2 / 7;
            for (int i = 1; i < 7; i++) {
                x = Math.cos(i * angle) * (vertex.getX() - this.center.getX()) - 
                    Math.sin(i * angle) * (vertex.getY() - this.center.getY()) + 
                    this.center.getX();
                y = Math.sin(i * angle) * (vertex.getX() - this.center.getX()) + 
                    Math.cos(i * angle) * (vertex.getY() - this.center.getY()) + 
                    this.center.getY();
                this.vertices[i] = new Point(x, y);
            }
            // Calculates apothem (radius multiplied by the cosine of PI/7).
            this.apothem = this.radius * Math.cos(Math.PI / 7);
            // Calculates side (distance between 2 consecutive vertices).
            this.side = this.vertices[0].distanceTo(this.vertices[1]);
            // Calculates perimeter (side length multiplied by seven).
            this.perimeter = this.side * 7;
            // Calculates area (half the product of its perimeter and its apothem).
            this.area = this.perimeter * this.apothem / 2;
        }
        else {
            throw new IllegalArgumentException("ERR: Radius cannot be zero or negative.");
        }
    }

    // Rotates the heptagon around its center (the parameters is in degrees).
    public void rotate(double angle) {
        double x, y;
        double theta = Math.toRadians(angle);
        for(int i=0; i < 7; i++) {
            x = Math.cos(theta) * (this.vertices[i].getX() - this.center.getX()) - 
                Math.sin(theta) * (this.vertices[i].getY() - this.center.getY()) + 
                this.center.getX();
            y = Math.sin(theta) * (this.vertices[i].getX() - this.center.getX()) + 
                Math.cos(theta) * (this.vertices[i].getY() - this.center.getY()) + 
                this.center.getY();
            this.vertices[i] = new Point(x, y);
        }
    }

    // </editor-fold>
}
