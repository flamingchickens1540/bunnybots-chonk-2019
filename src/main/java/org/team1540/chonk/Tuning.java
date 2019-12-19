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

    public static final double ARM_P = 3;
    public static final double ARM_I = 0;
    public static final double ARM_D = 0;
    public static final double ARM_F = 1.176;
    public static final double ARM_COSINE_FEED_FORWARD_CONSTANT = 0.1;
    public static final double ARM_JOYSTICK_SCALE = 0.25;
    public static final int ARM_CRUISE_VAL = 750;
    public static final int ARM_ACCEL = 2000;
    public static final double ARM_TICKS_PER_DEGREE = 22.755555;
    public static final double ARM_POSITION_TOLERANCE = 10;

    public static final int ARM_ZERO_POSITION = 2800;
    public static final int ARM_DUMP_POSITION = 115;
    public static final double ARM_BIN_POSITION = -57.5;
    public static final double ARM_AFTER_BIN_PICKUP_POSITION = 0;
    public static final double BIN_THROW_WAIT = 0.25;
    public static final double DUMP_BIN_WAIT_TIME = 0.1;
    public static final double CLAW_MOVE_TIME = 0.05;
    public static final double FRONT_ULTRASONIC_BIN_DISTANCE = 1;
    public static final double FRONT_ULTRASONIC_THRESHOLD = 0.25;
}
