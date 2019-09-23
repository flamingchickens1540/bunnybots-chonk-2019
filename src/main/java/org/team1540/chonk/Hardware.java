package org.team1540.chonk;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel;

public class Hardware {
    public static CANSparkMax driveRightA;
    public static CANSparkMax driveRightB;
    public static CANSparkMax driveRightC;

    public static CANSparkMax driveLeftA;
    public static CANSparkMax driveLeftB;
    public static CANSparkMax driveLeftC;

    public static CANSparkMax armA;
    public static CANSparkMax armB;

    static void initAll() {
        initDrive();
        initArm();
    }

    static void initDrive() {
        driveRightA = new CANSparkMax(0, CANSparkMaxLowLevel.MotorType.kBrushless);
        driveRightB = new CANSparkMax(0, CANSparkMaxLowLevel.MotorType.kBrushless);
        driveRightC = new CANSparkMax(0, CANSparkMaxLowLevel.MotorType.kBrushless);

        driveLeftA = new CANSparkMax(0, CANSparkMaxLowLevel.MotorType.kBrushless);
        driveLeftB = new CANSparkMax(0, CANSparkMaxLowLevel.MotorType.kBrushless);
        driveLeftC = new CANSparkMax(0, CANSparkMaxLowLevel.MotorType.kBrushless);

        driveRightB.follow(driveRightA);
        driveRightC.follow(driveRightA);

        driveLeftB.follow(driveLeftA);
        driveLeftC.follow(driveLeftA);
    }

    static void initArm() {
        armA = new CANSparkMax(0, CANSparkMaxLowLevel.MotorType.kBrushless);
        armB = new CANSparkMax(0, CANSparkMaxLowLevel.MotorType.kBrushless);

        armB.follow(armA);
    }
}
