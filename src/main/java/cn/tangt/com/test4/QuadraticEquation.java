package cn.tangt.com.test4;

/**
 * @author : tgt
 * @version : 1.0
 * @class : QuadraticEquation
 * @description : QuadraticEquation
 * @date : 2022/3/25
 */
public class QuadraticEquation {
    public static int solveQuadratic(double[] eqn, double[] roots) {
        int delta = (int) (eqn[1] * eqn[1] - 4 * eqn[0] * eqn[2]);
        if (delta >= 0) {
            roots[0] = (-eqn[1] + Math.sqrt(delta)) / 2 * eqn[0];
            roots[1] = (-eqn[1] - Math.sqrt(delta)) / 2 * eqn[0];
        }
        return delta;
    }
}
