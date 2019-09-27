package org.team1540.chonk;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel;
import org.team1540.rooster.wrappers.ChickenTalon;
import org.team1540.rooster.wrappers.ChickenVictor;

public class Hardware {
    public static ChickenTalon driveRightA;
    public static ChickenVictor driveRightB;

    public static ChickenTalon driveLeftA;
    public static ChickenVictor driveLeftB;

    public static ChickenTalon armR;
    public static ChickenTalon armL;

    static void initAll() {
        initDrive();
        initArm();
    }

    static void initDrive() {
        driveRightA = new ChickenTalon(RobotMap.DRIVE_RIGHT_A);
        driveRightB = new ChickenVictor(RobotMap.DRIVE_RIGHT_B);

        driveLeftA = new ChickenTalon(RobotMap.DRIVE_LEFT_A);
        driveLeftB = new ChickenVictor(RobotMap.DRIVE_LEFT_B);

        driveRightB.follow(driveRightA);

        driveLeftB.follow(driveLeftA);
    }

    static void initArm() {
        armR = new ChickenTalon(RobotMap.ARM_R);
        armL = new ChickenTalon(RobotMap.ARM_L);

        armL.follow(armR);

        armR.config_kP(0, Tuning.ARM_P);
        armR.config_kI(0, Tuning.ARM_I);
        armR.config_kD(0, Tuning.ARM_D);
    }
}
