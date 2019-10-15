package org.team1540.chonk;

import com.kauailabs.navx.frc.AHRS;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.team1540.rooster.wrappers.ChickenTalon;
import org.team1540.rooster.wrappers.ChickenVictor;

public class Hardware {
    public static ChickenTalon driveRightA;
    public static ChickenVictor driveRightB;
    public static ChickenVictor driveRightC;

    public static ChickenTalon driveLeftA;
    public static ChickenVictor driveLeftB;
    public static ChickenVictor driveLeftC;

    public static ChickenTalon armR;
    public static ChickenTalon armL;

    public static AHRS navx;

    static void initAll() {
        System.out.println("Initializing Robot Hardware...");

        initDrive();
        initArm();
        initNavX();

        System.out.println("Robot Hardware Initialized");
    }

    static void initDrive() {
        System.out.println("Initializing Drive...");

        driveRightA = new ChickenTalon(RobotMap.DRIVE_RIGHT_A);
        driveRightB = new ChickenVictor(RobotMap.DRIVE_RIGHT_B);
        driveRightC = new ChickenVictor(RobotMap.DRIVE_RIGHT_C);

        driveLeftA = new ChickenTalon(RobotMap.DRIVE_LEFT_A);
        driveLeftB = new ChickenVictor(RobotMap.DRIVE_LEFT_B);
        driveLeftC = new ChickenVictor(RobotMap.DRIVE_LEFT_C);

        driveRightA.configFactoryDefault();
        driveRightB.configFactoryDefault();
        driveRightC.configFactoryDefault();

        driveLeftA.configFactoryDefault();
        driveLeftB.configFactoryDefault();
        driveLeftC.configFactoryDefault();

        driveRightB.follow(driveRightA);
        driveRightC.follow(driveRightA);

        driveLeftB.follow(driveLeftA);
        driveLeftC.follow(driveLeftA);
    }

    static void initArm() {
        System.out.println("Initializing Arm...");

        armR = new ChickenTalon(RobotMap.ARM_R);
        armL = new ChickenTalon(RobotMap.ARM_L);

        armR.configFactoryDefault();
        armL.configFactoryDefault();

        armR.follow(armL);

        armR.setInverted(true);
        armL.setInverted(true);

//        armL.configPeakOutputForward(.5);
//        armL.configPeakOutputReverse(-.5);

        armL.setSensorPhase(true);
    }

    static void initNavX() {
        System.out.println("Initializing NavX...");
        // Navx.

        navx = new AHRS(RobotMap.NAVX);
    }

    static void setArmPID() {
        System.out.println("Setting Arm PID...");

        /*
        armL.config_kP(0, SmartDashboard.getNumber("arm/p", 1));
        armL.config_kI(0, SmartDashboard.getNumber("arm/i", 0));
        armL.config_kD(0, SmartDashboard.getNumber("arm/d", 0));
         */

        armL.config_kP(0, Tuning.ARM_P);
        armL.config_kI(0, Tuning.ARM_I);
        armL.config_kD(0, Tuning.ARM_D);
        armL.config_kF(0, Tuning.ARM_F);
        armL.configMotionCruiseVelocity(Tuning.ARM_CRUISE_VAL);
        armL.configMotionAcceleration(Tuning.ARM_ACCEL);
    }
}
