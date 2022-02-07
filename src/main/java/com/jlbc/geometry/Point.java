package com.jlbc.geometry;

/*
 *    -------------------------------------------------
 *    |                    Point                      |
 *    |-----------------------------------------------|
 *    | x: numeric                                    |
 *    | y: numeric                                    |
 *    |-----------------------------------------------|
 *    | <<constructor> Point()                        |
 *    | <<constructor> Point(x: numeric, y: numeric)  |
 *    | translate(dx: numeric, dy: numeric)           |
 *    | distanceto(other: Point): numeric             |
 *    -------------------------------------------------
 *    
 */

public class Point {
    
    // <editor-fold desc="INTERNAL FIELDS">

    /* 
     * REMEMBER: Internal fields are variables that ALWAYS must be
     *           private (encapsulation) and they are used to store
     *           object data.
     */

    private double x;
    private double y;

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

    public double getX() {
        return this.x;
    }
    public double getY() {
        return this.y;
    }

    // </editor-fold>

    // <editor-fold desc="CONSTRUCTORS">

    /* REMEMBER: Constructors are special functions whose name is 
     *           always the same of the class. Its responsibility
     *           is to establish an initial VALID state of the object.
     */

    // Buids the origin point (default constructor).
    public Point() {
        this.x = 0;
        this.y = 0;
    }
        // Builds the specific point asked.
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    // </editor-fold>

    // <editor-fold desc="METHODS">

    /* REMEMBER: Methods are functions inside the class that defines
     *           the behaviour of the objects.
     */

    // Moves the point offsetting it a given horizontal
    // and vertical distance. If vertical displacement is
    // positive, the point moves up; otherwise if vertical 
    // displacement is negative, the point moves down. If
    // horizontal displacement is positive, the point moves
    // right; otherwise if horizontal displacement is negative,
    // the point moves left.
    public void translate(double dx, double dy) {
        this.x += dx;
        this.y += dy;
    }
    // Calculates the distance between this point (self)
    // and other point.
    public double distanceTo(Point other) {
        return Math.sqrt(Math.pow(other.x - this.x, 2) + 
                         Math.pow(other.y - this.y, 2));
    }

    // </editor-fold>
}
