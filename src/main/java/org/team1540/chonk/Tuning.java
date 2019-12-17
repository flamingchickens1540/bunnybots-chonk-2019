package org.team1540.chonk;

public class Tuning {
    public static double POINT_DRIVE_P = 0.4;
    public static double POINT_DRIVE_I = 0;
    public static double POINT_DRIVE_D = 0;

    public static double LIMELIGHT_P = 0.01;
    public static double LIMELIGHT_I = 0;
    public static double LIMELIGHT_D = 5;

    public static double LIMELIGHT_HEIGHT = 0;
    public static double LIMELIGHT_FORWARD_TOLERANCE = 0;

    public static final double ARM_P = 6;
    public static final double ARM_I = 0;
    public static final double ARM_D = 0;
    public static final double ARM_F = 0.1705;
    public static final double ARM_COSINE_FEED_FORWARD_CONSTANT = 1;
    public static final int ARM_CRUISE_VAL = 5000;
    public static final int ARM_ACCEL = 10000;
    public static final double ARM_TICKS_PER_DEGREE = 22.755555;
    public static final double ARM_POSITION_TOLERANCE = 10;

    public static final int ARM_ZERO_POSITION = 123;
    public static final double ARM_BIN_POSITION = -60;
    public static final double BIN_THROW_WAIT = 0.25;
    public static final double DUMP_BIN_WAIT_TIME = 0.5;
    public static final double CLAW_MOVE_TIME = 0.5;
    public static final double FRONT_ULTRASONIC_BIN_DISTANCE = 1;
    public static final double FRONT_ULTRASONIC_THRESHOLD = 0.25;
}
