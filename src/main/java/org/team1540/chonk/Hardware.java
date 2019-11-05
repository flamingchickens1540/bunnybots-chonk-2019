package org.team1540.chonk;

import com.kauailabs.navx.frc.AHRS;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.team1540.rooster.wrappers.ChickenTalon;
import org.team1540.rooster.wrappers.ChickenVictor;
import org.team1540.rooster.wrappers.RevBlinken;

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

    public static RevBlinken leds;

    public static NetworkTable limelight;

    static void initAll() {
        System.out.println("Initializing Robot Hardware...");

        initDrive();
        initArm();
        initNavX();
        initLEDs();
        initLimelight();

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

        driveRightA.setBrake(true);
        driveRightB.setBrake(false);
        driveRightC.setBrake(false);

        driveLeftA.setBrake(true);
        driveLeftB.setBrake(false);
        driveLeftC.setBrake(false);

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

        navx = new AHRS(RobotMap.NAVX);
    }

    static void initLEDs() {
        System.out.println("Initializing LEDs...");

        leds = new RevBlinken(RobotMap.LED);
    }

    static void initLimelight() {
        System.out.println("Initializing Limelight");

        limelight = NetworkTableInstance.getDefault().getTable("limelight");
    }

    static void setArmPID() {
        System.out.println("Setting Arm PID...");

        /*
        armL.config_kP(0, SmartDashboard.getNumber("arm/p", Tuning.ARM_P));
        armL.config_kI(0, SmartDashboard.getNumber("arm/i", Tuning.ARM_I));
        armL.config_kD(0, SmartDashboard.getNumber("arm/d", Tuning.ARM_D));
         */

        armL.config_kP(0, Tuning.ARM_P);
        armL.config_kI(0, Tuning.ARM_I);
        armL.config_kD(0, Tuning.ARM_D);
        armL.config_kF(0, Tuning.ARM_F);
        armL.configMotionCruiseVelocity(Tuning.ARM_CRUISE_VAL);
        armL.configMotionAcceleration(Tuning.ARM_ACCEL);
    }

    public static double getLimelightP() {
        double p = SmartDashboard.getNumber("drive/limelightp", Tuning.LIMELIGHT_P);
//        double p = Tuning.LIMELIGHT_P;
        return p;
    }
    public static double getLimelightI() {
        double i = SmartDashboard.getNumber("drive/limelighti", Tuning.LIMELIGHT_I);
//        double i = Tuning.LIMELIGHT_I;
        return i;
    }
    public static double getLimelightD() {
        double d = SmartDashboard.getNumber("drive/limelightd", Tuning.LIMELIGHT_D);
//        double d = Tuning.LIMELIGHT_D;
        return d;
    }
}






