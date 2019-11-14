package org.team1540.chonk;

public class Tuning {

    public static final double ARM_P = .5;
    public static final double ARM_I = 0;
    public static final double ARM_D = 0;
    public static final double ARM_F = 0.1705;
    public static final int ARM_CRUISE_VAL = 5000;
    public static final int ARM_ACCEL = 10000;
    public static final double ARM_TICKS_PER_DEGREE = 1;
    public static final double ARM_POSITION_TOLERANCE = 5;

    public static final double ELEVATOR_P = .1;
    public static final double ELEVATOR_I = 0;
    public static final double ELEVATOR_D = 5;
    public static final double ELEVATOR_INCHES_PER_REV = -.929926125;
    public static final double ELEVATOR_POSITION_TOLERANCE = 1;

    public static double POINT_DRIVE_P = 0.4;
    public static double POINT_DRIVE_I = 0;
    public static double POINT_DRIVE_D = 0;

    public static double LIMELIGHT_P = 0.01;
    public static double LIMELIGHT_I = 0;
    public static double LIMELIGHT_D = 5;
}
