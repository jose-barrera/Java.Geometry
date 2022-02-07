package com.jlbc.geometry;

/*
 *    ----------------------------------------------------------------
 *    |                        Ellipse                               |
 *    |--------------------------------------------------------------|
 *    | center: Point                                                |
 *    | semi-major axis: numeric                                     |
 *    | semi-minor axis: numeric                                     |
 *    | orientation: text                                            |
 *    | eccentricity: numeric                                        |
 *    | focus1: Point                                                |
 *    | focus2: Point                                                |
 *    | vertex1: Point                                               |
 *    | vertex2: Point                                               |
 *    | covertex1: Point                                             |
 *    | covertex2: Point                                             |
 *    | area: numeric                                                |
 *    | perimeter: numeric                                           |
 *    |--------------------------------------------------------------|
 *    | <<constructor> Ellipse(center: Point,                        |
 *    |                        semi-major axis: numeric,             |
 *    |                        semi-minor axis: numeric,             |
 *    |                        orientation: text)                    |
 *    | translate(dx: numeric, dy: numeric)                          |
 *    | resize(factor: numeric)                                      |
 *    ----------------------------------------------------------------
 *    
 */

public class Ellipse {
    
    // <editor-fold desc="INTERNAL FIELDS">

    /* 
     * REMEMBER: Internal fields are variables that ALWAYS must be
     *           private (encapsulation) and they are used to store
     *           object data.
     */

    private Point center;
    private double semiMajorAxis;
    private double semiMinorAxis;
    private String orientation;
    private double eccentricity;
    private Point focus1;
    private Point focus2;
    private Point vertex1;
    private Point vertex2;
    private Point covertex1;
    private Point covertex2;
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
    public double getSemiMajorAxis() {
        return this.semiMajorAxis;
    }
    public double getSemiMinorAxis() {
        return this.semiMinorAxis;
    }
    public String getOrientation() {
        return this.orientation;
    }
    public double getEccentricity() {
        return this.eccentricity;
    }
    public Point getFocus1() {
        return this.focus1;
    }
    public Point getFocus2() {
        return this.focus2;
    }
    public Point getVertex1() {
        return this.vertex1;
    }
    public Point getVertex2() {
        return this.vertex2;
    }
    public Point getCovertex1() {
        return this.covertex1;
    }
    public Point getCovertex2() {
        return this.covertex2;
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

    public Ellipse(Point center, double semiMajorAxis, double semiMinorAxis, 
                   String orientation) {
        // Axes must be positive values, major axis must be greater
        // than minor axis, and valid orientations are "Horizontal"
        // and "Vertical". If any of these conditions is not met, 
        // object cannot be created and an error will be generated.
        if (semiMajorAxis > 0 && semiMinorAxis > 0) {
            if (semiMajorAxis > semiMinorAxis) {
                // Stores the data.
                this.center = center;
                this.semiMajorAxis = semiMajorAxis;
                this.semiMinorAxis = semiMinorAxis;
                this.orientation = orientation;
                // Makes general calculations.
                double linearEccentricity = Math.sqrt(Math.pow(semiMajorAxis, 2) -
                                                      Math.pow(semiMinorAxis, 2));
                this.eccentricity = linearEccentricity / semiMajorAxis;
                this.area = Math.PI * semiMajorAxis * semiMinorAxis;
                // Calculates the approximation of perimeter
                double h = Math.pow(this.semiMajorAxis - this.semiMinorAxis, 2) /
                           Math.pow(this.semiMajorAxis + this.semiMinorAxis, 2);
                double seriesApproximation = 1 + h / 4 + Math.pow(h, 2) / 64 + 
                    Math.pow(h, 3) / 256 + 25 * Math.pow(h, 4) / 16384 + 
                    49 * Math.pow(h, 5) / 655536 + 441 * Math.pow(h, 6) / 1048576; 
                this.perimeter = Math.PI * (semiMajorAxis + semiMinorAxis) * seriesApproximation;
                // Calculates points according to orientation.
                switch(orientation) {
                    case "Horizontal":
                        this.focus1 = new Point(center.getX() - linearEccentricity, center.getY());
                        this.focus2 = new Point(center.getX() + linearEccentricity, center.getY());
                        this.vertex1 = new Point(center.getX() - semiMajorAxis, center.getY());
                        this.vertex2 = new Point(center.getX() + semiMajorAxis, center.getY());
                        this.covertex1 = new Point(center.getX(), center.getY() - semiMinorAxis);
                        this.covertex2 = new Point(center.getX(), center.getY() + semiMinorAxis);
                        break;
                    case "Vertical":
                        this.focus1 = new Point(center.getX(), center.getY() - linearEccentricity);
                        this.focus2 = new Point(center.getX(), center.getY() + linearEccentricity);
                        this.vertex1 = new Point(center.getX(), center.getY() - semiMajorAxis);
                        this.vertex2 = new Point(center.getX(), center.getY() + semiMajorAxis);
                        this.covertex1 = new Point(center.getX() - semiMinorAxis, center.getY());
                        this.covertex2 = new Point(center.getX() + semiMinorAxis, center.getY());
                        break;
                   default:
                        throw new IllegalArgumentException("ERR: Orientation is invalid.");
                }
            }
            else {
                throw new IllegalArgumentException("ERR: Semi-major axis cannot be equal or smaller than semi-minor axis.");
            }
        }
        else {
            throw new IllegalArgumentException("ERR: Semi-axes cannot be zero or negative.");
        }
    }

    // </editor-fold>

    // <editor-fold desc="METHODS">

    /* REMEMBER: Methods are functions inside the class that defines
     *           the behaviour of the objects.
     */

    // Moves the ellipse offsetting its center a given horizontal
    // and vertical distance. It is necessary to recalculate some of
    // its properties.
    public void translate(double dx, double dy) {
        // Updates the data.
        this.center.translate(dx, dy);
        double linearEccentricity = Math.sqrt(Math.pow(this.semiMajorAxis, 2) -
                                                Math.pow(this.semiMinorAxis, 2));
        // Calculates points according to orientation.
        switch(this.orientation) {
            case "Horizontal":
                this.focus1 = new Point(this.center.getX() - linearEccentricity, this.center.getY());
                this.focus2 = new Point(this.center.getX() + linearEccentricity, this.center.getY());
                this.vertex1 = new Point(this.center.getX() - this.semiMajorAxis, this.center.getY());
                this.vertex2 = new Point(this.center.getX() + this.semiMajorAxis, this.center.getY());
                this.covertex1 = new Point(this.center.getX(), this.center.getY() - this.semiMinorAxis);
                this.covertex2 = new Point(this.center.getX(), this.center.getY() + this.semiMinorAxis);
                break;
            case "Vertical":
                this.focus1 = new Point(this.center.getX(), this.center.getY() - linearEccentricity);
                this.focus2 = new Point(this.center.getX(), this.center.getY() + linearEccentricity);
                this.vertex1 = new Point(this.center.getX(), this.center.getY() - this.semiMajorAxis);
                this.vertex2 = new Point(this.center.getX(), this.center.getY() + this.semiMajorAxis);
                this.covertex1 = new Point(this.center.getX() - this.semiMinorAxis, this.center.getY());
                this.covertex2 = new Point(this.center.getX() + this.semiMinorAxis, this.center.getY());
                break;
        }
    }

    // Resizes the ellipse multiplying their axes by a factor. 
    // If factor > 1 the ellipse grows, if factor < 1 the ellipse
    // shrinks. It is necessary to recalculate some of its properties.
    public void resize(double factor) {
        // Factor must be positive; otherwise, the ellipse cannot be
        // resized and an error will be generated.
        if (factor > 0) {
            // Updates the data.
            this.semiMajorAxis *= factor;
            this.semiMinorAxis *= factor;
            double linearEccentricity = Math.sqrt(Math.pow(this.semiMajorAxis, 2) -
                                                 Math.pow(this.semiMinorAxis, 2));
            this.eccentricity = linearEccentricity / this.semiMajorAxis;
            this.area = Math.PI * this.semiMajorAxis * this.semiMinorAxis;
            // Calculates the approximation of perimeter
            double h = Math.pow(this.semiMajorAxis - this.semiMinorAxis, 2) /
                       Math.pow(this.semiMajorAxis + this.semiMinorAxis, 2);
            double seriesApproximation = 1 + h / 4 + Math.pow(h, 2) / 64 + 
                Math.pow(h, 3) / 256 + 25 * Math.pow(h, 4) / 16384 + 
                49 * Math.pow(h, 5) / 655536 + 441 * Math.pow(h, 6) / 1048576; 
            this.perimeter = Math.PI * (this.semiMajorAxis + this.semiMinorAxis) * seriesApproximation;
            // Calculates points according to orientation.
            switch(this.orientation) {
                case "Horizontal":
                    this.focus1 = new Point(this.center.getX() - linearEccentricity, this.center.getY());
                    this.focus2 = new Point(this.center.getX() + linearEccentricity, this.center.getY());
                    this.vertex1 = new Point(this.center.getX() - this.semiMajorAxis, this.center.getY());
                    this.vertex2 = new Point(this.center.getX() + this.semiMajorAxis, this.center.getY());
                    this.covertex1 = new Point(this.center.getX(), this.center.getY() - this.semiMinorAxis);
                    this.covertex2 = new Point(this.center.getX(), this.center.getY() + this.semiMinorAxis);
                    break;
                case "Vertical":
                    this.focus1 = new Point(this.center.getX(), this.center.getY() - linearEccentricity);
                    this.focus2 = new Point(this.center.getX(), this.center.getY() + linearEccentricity);
                    this.vertex1 = new Point(this.center.getX(), this.center.getY() - this.semiMajorAxis);
                    this.vertex2 = new Point(this.center.getX(), this.center.getY() + this.semiMajorAxis);
                    this.covertex1 = new Point(this.center.getX() - this.semiMinorAxis, this.center.getY());
                    this.covertex2 = new Point(this.center.getX() + this.semiMinorAxis, this.center.getY());
                break;
            }
        }
        else {
            throw new IllegalArgumentException("ERR: Factor cannot be zero or negative.");
        }    
    }

    // </editor-fold>
}
