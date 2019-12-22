package org.team1540.chonk.utils;

public class SignedAngleError {
    public static double signedAngleError(double target, double source) {
        double diff = (target - source + Math.PI) % (Math.PI * 2) - Math.PI;
        return diff < -Math.PI ? diff + (Math.PI * 2) : diff;
//        return Math.atan2(Math.sin(target - source), Math.cos(target - source));
    }
}
