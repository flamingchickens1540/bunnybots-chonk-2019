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

    static void initAll() {
        initDrive();
    }

    static void initDrive() {
        driveRightA = new CANSparkMax(0, CANSparkMaxLowLevel.MotorType.kBrushless);
        driveRightB = new CANSparkMax(0, CANSparkMaxLowLevel.MotorType.kBrushless);
        driveRightC = new CANSparkMax(0, CANSparkMaxLowLevel.MotorType.kBrushless);

        driveLeftA = new CANSparkMax(0, CANSparkMaxLowLevel.MotorType.kBrushless);
        driveLeftB = new CANSparkMax(0, CANSparkMaxLowLevel.MotorType.kBrushless);
        driveLeftC = new CANSparkMax(0, CANSparkMaxLowLevel.MotorType.kBrushless);

        Hardware.driveRightB.follow(Hardware.driveRightA);
        Hardware.driveRightC.follow(Hardware.driveRightA);

        Hardware.driveLeftB.follow(Hardware.driveLeftA);
        Hardware.driveLeftC.follow(Hardware.driveLeftA);
    }
}
