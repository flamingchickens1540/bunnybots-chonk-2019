package org.team1540.chonk;

import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.kauailabs.navx.frc.AHRS;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.team1540.rooster.wrappers.ChickenTalon;
import org.team1540.rooster.wrappers.ChickenVictor;
import org.team1540.rooster.wrappers.RevBlinken;

public class Hardware {
    public static ChickenTalon driveRightA;
    public static ChickenTalon driveRightB;

    public static ChickenTalon driveLeftA;
    public static ChickenTalon driveLeftB;

    public static ChickenTalon arm;
    public static DigitalInput armLimitSwitch;

    public static Solenoid claw;

    public static Solenoid bunnyArm;

    public static Compressor compressor;

    public static AnalogInput frontUltrasonic;

    public static AHRS navx;

    public static RevBlinken leds;

    public static NetworkTable limelight;

    static void initAll() {
        System.out.println("Initializing Robot Hardware...");

        initDrive();
        initArm();
        initClaw();
        initBunnyArm();
//        initUltrasonic();
        initCompressor();
        initNavX();
//        initLEDs();
//        initLimelight();

        System.out.println("Robot Hardware Initialized");
    }

    static void initDrive() {
        System.out.println("Initializing Drive...");

        driveRightA = new ChickenTalon(RobotMap.DRIVE_RIGHT_A);
        driveRightB = new ChickenTalon(RobotMap.DRIVE_RIGHT_B);

        driveLeftA = new ChickenTalon(RobotMap.DRIVE_LEFT_A);
        driveLeftB = new ChickenTalon(RobotMap.DRIVE_LEFT_B);

        driveRightA.configFactoryDefault();
        driveRightB.configFactoryDefault();

        driveLeftA.configFactoryDefault();
        driveLeftB.configFactoryDefault();

        driveRightA.setBrake(true);
        driveRightB.setBrake(false);

        driveLeftA.setBrake(true);
        driveLeftB.setBrake(false);

        driveRightB.follow(driveRightA);
        driveLeftB.follow(driveLeftA);
    }

    static void initArm() {
        System.out.println("Initializing Arm...");

        arm = new ChickenTalon(RobotMap.ARM);
        arm.configFactoryDefault();
        arm.setInverted(true);
        arm.setSensorPhase(true);
        arm.setBrake(false);
//        arm.configPeakOutputForward(.5);
        arm.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder);
        setArmPID();

        armLimitSwitch = new DigitalInput(RobotMap.ARM_LIMIT_SWITCH);
        armLimitSwitch.requestInterrupts(new InterruptHandlerFunction<>() {
            @Override
            public void interruptFired(int i, Object o) {
                System.out.println("Arm limit switch hit");
                Hardware.arm.setSelectedSensorPosition(Tuning.ARM_ZERO_POSITION);
            }
        });
        armLimitSwitch.enableInterrupts();
        armLimitSwitch.setUpSourceEdge(false, true);

        System.out.println("initialized arm limit switch in port " + RobotMap.ARM_LIMIT_SWITCH);
    }

    static void initClaw() {
        claw = new Solenoid(RobotMap.CLAW);
    }

    static void initBunnyArm() {
        bunnyArm = new Solenoid(RobotMap.BUNNY_ARM);
    }

    static void initUltrasonic() {
        frontUltrasonic = new AnalogInput(RobotMap.FRONT_ULTRASONIC);
    }

    static void initCompressor() {
        compressor = new Compressor();
        compressor.start();
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

        limelight = NetworkTableInstance.getDefault().getTable("limelight-a");
    }

    static void setArmPID() {
        System.out.println("Setting Arm PID...");

        arm.config_kP(0, SmartDashboard.getNumber("arm/p", Tuning.ARM_P));
        arm.config_kI(0, SmartDashboard.getNumber("arm/i", Tuning.ARM_I));
        arm.config_kD(0, SmartDashboard.getNumber("arm/d", Tuning.ARM_D));
        arm.config_kF(0, SmartDashboard.getNumber("arm/f", Tuning.ARM_F));
        arm.configMotionCruiseVelocity(Tuning.ARM_CRUISE_VAL);
        arm.configMotionAcceleration(Tuning.ARM_ACCEL);

//        arm.config_kP(0, Tuning.ARM_P);
//        arm.config_kI(0, Tuning.ARM_I);
//        arm.config_kD(0, Tuning.ARM_D);

//        arm.configMotionCruiseVelocity(Tuning.ARM_CRUISE_VAL);
//        arm.configMotionAcceleration(Tuning.ARM_ACCEL);
    }

    public static double getLimelightP() {
        return SmartDashboard.getNumber("drive/limelightp", Tuning.LIMELIGHT_P);
//        return Tuning.LIMELIGHT_P;
    }
    public static double getLimelightI() {
        return SmartDashboard.getNumber("drive/limelighti", Tuning.LIMELIGHT_I);
//        return Tuning.LIMELIGHT_I;
    }
    public static double getLimelightD() {
        return SmartDashboard.getNumber("drive/limelightd", Tuning.LIMELIGHT_D);
//        return Tuning.LIMELIGHT_D;
    }
}
