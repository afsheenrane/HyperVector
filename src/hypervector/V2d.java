package hypervector;

/**
 * A static vector operation class that operates on double arrays.
 * 
 * @author Afsheen, Sina
 *
 */
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
        len = len == 0 ? 1 : len; // Avoids 0 div errors.
        v[0] /= len;
        v[1] /= len;
    }

    /**
     * Returns a normalized copy of vector v.
     * 
     * @param v a vector.
     * @return a normalized copy of v.
     */
    public static double[] getNormalized(double[] v) {
        double[] nv = { v[0], v[1] };
        normalize(nv);
        return nv;
    }

    /**
     * Return the dot product of v1 and v2.
     * 
     * @param v1 the first vector.
     * @param v2 the second vector.
     * @return the dot product of v1 and v2. (v1 &#183; v2)
     */
    public static double dot(double[] v1, double[] v2) {
        return (v1[0] * v2[0]) + (v1[1] * v2[1]);
    }

    /**
     * Returns the <b>left</b> normal of vector v.
     * 
     * @param v a vector.
     * @return the left normal of v.
     */
    public static double[] getNormal(double[] v) {
        return new double[] { -v[1], v[0] };
    }

    /**
     * Adds vector v2 to v1. (v1 = v1 + v2).
     * 
     * @param v1 the vector to which v2 is getting added.
     * @param v2 the vector being added to v1.
     */
    public static void add(double[] v1, double[] v2) {
        v1[0] += v2[0];
        v1[1] += v2[1];
    }

    /**
     * Returns the vector sum of v1 and v2.
     * 
     * @param v1 a vector.
     * @param v2 another vector.
     * @return the sum of v1 and v2. (ret = v1 + v2).
     */
    public static double[] getAdded(double[] v1, double[] v2) {
        return new double[] { v1[0] + v2[0], v1[1] + v2[1] };
    }

    /**
     * Subtracts v2 from v1. (v1 = v1 - v2).
     * 
     * @param v1 the vector from which v2 is being subtracted.
     * @param v2 the vector to subtract from v1.
     */
    public static void sub(double[] v1, double[] v2) {
        v1[0] -= v2[0];
        v1[1] -= v2[1];
    }

    /**
     * Returns the vector difference of v1 and v2.
     * 
     * @param v1 a vector.
     * @param v2 another vector.
     * @return the difference of v1 and v2. (ret = v1 - v2).
     */
    public static double[] getSubed(double[] v1, double[] v2) {
        return new double[] { v1[0] - v2[0], v1[1] - v2[1] };
    }

    /**
     * Returns the 2D cross product of v1 and v2. It's also known as the
     * perpendicular dot product. <br>
     * This is useful for finding whether v2 is on the left, right, or parallel
     * to v1. Where left is positive, right is negative, and parallel is zero.
     * 
     * @param v1 a vector.
     * @param v2 another vector.
     * @return (v1 X v2).
     */
    public static double perpDotProduct(double[] v1, double[] v2) {
        return (v1[0] * v2[1]) - (v1[1] * v2[0]);
    }

    /**
     * Return a copy of vector v, scaled by mul.
     * 
     * @param v a vector.
     * @param mul the value to scale v by.
     * @return a scaled copy of v.
     */
    public static double[] getScaled(double[] v, double mul) {
        return new double[] { v[0] * mul, v[1] * mul };
    }

    /**
     * Scale vector v by mul.
     * 
     * @param v the vector to scale.
     * @param mul the value to scale v by.
     */
    public static void scaleBy(double[] v, double mul) {
        v[0] *= mul;
        v[1] *= mul;
    }

    /**
     * Negate the vector v. (v = -v).
     * 
     * @param v a vector.
     */
    public static void negate(double[] v) {
        v[0] = -v[0];
        v[1] = -v[1];
    }

    /**
     * Returns a negated copy of vector v.
     * 
     * @param v a vector.
     * @return a negated copy of v.
     */
    public static double[] getNegated(double[] v) {
        return new double[] { -v[0], -v[1] };
    }

    /**
     * Computes the vector projection of v1 onto v2.
     * 
     * @param v1 a vector.
     * @param v2 the vector onto which v1 is projected.
     * @return the vector projection of v1 onto v2. (proj<sub>v1</sub>v2).
     */
    public static double[] vecProjection(double[] v1, double[] v2) {
        return getScaled(v2, dot(v1, v2) / getSquaredLength(v2));
    }

    /**
     * Returns a copy of the vector v.
     * 
     * @param v the vector to copy.
     * @return a copy of v.
     */
    public static double[] getCopy(double[] v) {
        return v.clone();
    };

    /**
     * @param v a vector.
     * @return a string representation of this vector which can be used to
     *         reconstruct it (mostly for debug use).
     */
    public static String repr(double[] v) {
        return String.format("new double[]{%f, %f};", v[0], v[1]);
    }

    public static String toString(double[] v) {
        return String.format("[%f, %f]", v[0], v[1]);
    }

    /**
     * Checks to see whether v1 equals v2 within a given tolerance.
     * 
     * @param v1 a vector.
     * @param v2 another vector.
     * @param TOL the tolerance under which v1 and v2 are considered equal.
     * @return whether v1 &#8773; v2 under a certain tolerance.
     */
    public static boolean tolEquals(double[] v1, double[] v2, double TOL) {
        double xDif = v1[0] - v2[0];
        double yDif = v1[1] - v2[1];

        // Make both positive.
        xDif = xDif < 0 ? -xDif : xDif;
        yDif = yDif < 0 ? -yDif : yDif;

        return (xDif < TOL) && (yDif < TOL);
    }

}
