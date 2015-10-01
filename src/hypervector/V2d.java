package hypervector;

public class V2d {
    public static final double[] ORIGIN = { 0, 0 };

    /**
     * Return the magnitude of vector v.
     * 
     * @param v a vector.
     * @return the length of v.
     */
    public static double getLength(double[] v) {
        return Math.sqrt((v[0] * v[0]) + (v[1] * v[1]));
    }

    /**
     * Return the squared length of the vector v. <br>
     * This can be used to compare vector magnitudes relative to
     * each other, without using a sqrt operation.
     * 
     * @param v a vector.
     * 
     * @return the squared length of v.
     */
    public static double getSquaredLength(double[] v) {
        return (v[0] * v[0]) + (v[1] * v[1]);
    }

    /**
     * Normalize the vector v.
     * 
     * @param v a vector.
     */
    public static void normalize(double[] v) {
        double len = getLength(v);
        v[0] /= len;
        v[1] /= len;
    }

}
