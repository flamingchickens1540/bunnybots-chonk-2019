package org.team1540.chonk;

import edu.wpi.first.wpilibj.SPI;

public class RobotMap {
    public static final int DRIVE_LEFT_A = 1;
    public static final int DRIVE_LEFT_B = 2;

    public static final int DRIVE_RIGHT_A = 3;
    public static final int DRIVE_RIGHT_B = 4;

    public static final int ARM = 5;
    public static final int ARM_LIMIT_SWITCH = 0;

    public static final int CLAW = 1;

    public static final int BUNNY_ARM = 0;

    public static final int FRONT_ULTRASONIC = 0;

    public static final SPI.Port NAVX = SPI.Port.kMXP;

    public static final int LED = 0;
}
