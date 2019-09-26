package org.team1540.chonk;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel;
import org.team1540.rooster.wrappers.ChickenTalon;
import org.team1540.rooster.wrappers.ChickenVictor;

public class Hardware {
    public static ChickenTalon driveRightA;
    public static ChickenVictor driveRightB;
    public static ChickenVictor driveRightC;

    public static ChickenTalon driveLeftA;
    public static ChickenVictor driveLeftB;
    public static ChickenVictor driveLeftC;

    public static ChickenTalon armA;
    public static ChickenTalon armB;

    static void initAll() {
        initDrive();
        initArm();
    }

    static void initDrive() {
        driveRightA = new ChickenTalon(RobotMap.DRIVE_RIGHT_A);
        driveRightB = new ChickenVictor(RobotMap.DRIVE_RIGHT_B);
        driveRightC = new ChickenVictor(RobotMap.DRIVE_RIGHT_C);

        driveLeftA = new ChickenTalon(RobotMap.DRIVE_LEFT_A);
        driveLeftB = new ChickenVictor(RobotMap.DRIVE_LEFT_B);
        driveLeftC = new ChickenVictor(RobotMap.DRIVE_LEFT_C);

        driveRightB.follow(driveRightA);
        driveRightC.follow(driveRightA);

        driveLeftB.follow(driveLeftA);
        driveLeftC.follow(driveLeftA);
    }

    static void initArm() {
        armA = new ChickenTalon(RobotMap.ARM_A);
        armB = new ChickenTalon(RobotMap.ARM_B);

        armB.follow(armA);

        armA.config_kP(0, Tuning.ARM_P);
        armA.config_kI(0, Tuning.ARM_I);
        armA.config_kD(0, Tuning.ARM_D);
    }
}
