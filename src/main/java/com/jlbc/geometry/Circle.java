package com.jlbc.geometry;

/*
 *    ----------------------------------------------------------
 *    |                          Circle                        |
 *    |--------------------------------------------------------|
 *    | center: Point                                          |
 *    | radius: numeric                                        |
 *    | diameter: numeric                                      |
 *    | area: numeric                                          |
 *    | perimeter: numeric                                     |
 *    |--------------------------------------------------------|
 *    | <<constructor> Circle(center: Point, radius: numeric)  |
 *    | translate(dx: numeric, dy: numeric)                    |
 *    | translate(center: Point)                               |
 *    | resize(radius: numeric)                                |
 *    ----------------------------------------------------------
 *    
 */

public class Circle {
    
    // <editor-fold desc="INTERNAL FIELDS">

    /* 
     * REMEMBER: Internal fields are variables that ALWAYS must be
     *           private (encapsulation) and they are used to store
     *           object data.
     */

    private Point center;
    private double radius;
    private double diameter;
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
    public double getDiameter() {
        return this.diameter;
    }
    public double getArea() {
        return this.area;
    }
    public double getPerimeter() {
        return this.perimeter;
    }

    // </editor-fold>

    // <editor-fold desc="CONSTRUCTORS">

    /* REMEMBER: Constructors are special functions whose name is 
     *           always the same of the class. Its responsibility
     *           is to establish an initial VALID state of the object.
     */

    public Circle(Point center, double radius) {
        // Radius must be a positive value, if not,
        // object cannot be created and an error
        // will be generated.
        if (radius > 0)
        {
            // Stores the data received.
            this.center = center;
            this.radius = radius;
            // Diameter, area, and perimeter
            // are calculated from radius,
            this.diameter = radius * 2;
            this.area = Math.PI * radius * radius;
            this.perimeter = Math.PI * 2 * radius;
        }
        else
        {
            throw new IllegalArgumentException("ERR: Radius cannot be zero or negative.");
        }
    }

    // </editor-fold>

    // <editor-fold desc="METHODS">

    /* REMEMBER: Methods are functions inside the class that defines
     *           the behaviour of the objects.
     */

    // Moves the circle offsetting its center a given horizontal
    // and vertical distance. All other properties remains the same.
    public void translate(double dx, double dy) {
        this.center.translate(dx, dy);
    }

    // Moves the circle changing its center directly.
    public void translate(Point center) {
        this.center = center;
    }

    // Changes the size of circle by setting a new radius.
    public void resize(double radius) {
        // Radius must be a positive value, if not,
        // object cannot be creates and an error
        // will be generated.
        if (radius > 0)
        {
            // Stores the data received.
            this.radius = radius;
            // Diameter, area, and perimeter
            // are calculated from radius.
            this.diameter = radius * 2;
            this.area = Math.PI * radius * radius;
            this.perimeter = Math.PI * 2 * radius;
        }
        else
        {
            throw new IllegalArgumentException("ERR: Radius cannot be zero or negative.");
        }
    }

    // </editor-fold>
}
