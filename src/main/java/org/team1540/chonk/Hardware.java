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
        driveRightA = new ChickenTalon(0);
        driveRightB = new ChickenVictor(0);
        driveRightC = new ChickenVictor(0);

        driveLeftA = new ChickenTalon(0);
        driveLeftB = new ChickenVictor(0);
        driveLeftC = new ChickenVictor(0);

        driveRightB.follow(driveRightA);
        driveRightC.follow(driveRightA);

        driveLeftB.follow(driveLeftA);
        driveLeftC.follow(driveLeftA);
    }

    static void initArm() {
        armA = new ChickenTalon(0);
        armB = new ChickenTalon(0);

        armB.follow(armA);

        armA.config_kP(0, 0);
        armA.config_kI(0, 0);
        armA.config_kD(0, 0);
    }
}
