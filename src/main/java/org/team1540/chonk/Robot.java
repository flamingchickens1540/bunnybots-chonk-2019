package org.team1540.chonk;

import com.ctre.phoenix.motorcontrol.ControlMode;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.team1540.chonk.commands.Autonomous;
import org.team1540.chonk.subsystems.Arm;
import org.team1540.chonk.subsystems.BunnyArm;
import org.team1540.chonk.subsystems.BunnyArmDoor;
import org.team1540.chonk.subsystems.Claw;
import org.team1540.chonk.subsystems.DriveTrain;

public class Robot extends TimedRobot {

    public static DriveTrain driveTrain;
    public static Arm arm;
    public static Claw claw;
    public static BunnyArm bunnyArm;
    public static BunnyArmDoor bunnyDoor;
    private Autonomous autonomous;

    @Override
    public void robotInit() {
        System.out.println("Robot Initializing...");

        Hardware.initAll();
        driveTrain = new DriveTrain();
        arm = new Arm();
        claw = new Claw();
        bunnyArm = new BunnyArm();
        bunnyDoor = new BunnyArmDoor();
        OI.init();

        autonomous = new Autonomous();

        SmartDashboard.putNumber("drive/pointp", Tuning.POINT_DRIVE_P);
        SmartDashboard.putNumber("drive/pointi", Tuning.POINT_DRIVE_I);
        SmartDashboard.putNumber("drive/pointd", Tuning.POINT_DRIVE_D);

        SmartDashboard.putNumber("arm/p", Tuning.ARM_P);
        SmartDashboard.putNumber("arm/i", Tuning.ARM_I);
        SmartDashboard.putNumber("arm/d", Tuning.ARM_D);
        SmartDashboard.putNumber("arm/F", Tuning.ARM_F);

        SmartDashboard.putNumber("drive/limelightp", Tuning.LIMELIGHT_P);
        SmartDashboard.putNumber("drive/limelighti", Tuning.LIMELIGHT_I);
        SmartDashboard.putNumber("drive/limelightd", Tuning.LIMELIGHT_D);
    }

    @Override
    public void teleopInit() {
        System.out.println("Teleop Initializing...");
        Hardware.arm.set(ControlMode.PercentOutput, 0);
//        if (!Hardware.armLimitSwitch.get()) {
//            Hardware.arm.setSelectedSensorPosition(Tuning.ARM_ZERO_POSITION);
//        }
        Hardware.setArmPID();
        autonomous.cancel();
    }

    @Override
    public void teleopPeriodic() {
//        Hardware.arm.set(ControlMode.PercentOutput,
//            OI.getJoystick(OI.copilot, GenericHID.Hand.kLeft, OI.Axis.Y),
//            DemandType.ArbitraryFeedForward,
//            Tuning.ARM_COSINE_FEED_FORWARD_CONSTANT * Math.cos(Math.toRadians(arm.getPosition())));
//        SmartDashboard.putNumber("arm/joythrot",  OI.getJoystick(OI.copilot, GenericHID.Hand.kLeft, OI.Axis.Y));
//        servo.set(OI.getJoystick(OI.copilot, Hand.kRight, Axis.Y));
//        System.out.println(OI.getJoystick(OI.copilot, Hand.kRight, Axis.Y));
    }
// .75 .25


    @Override
    public void autonomousInit() {
        autonomous.start();
    }

    @Override
    public void robotPeriodic() {
        Scheduler.getInstance().run();

        SmartDashboard.putNumber("ultrasonic/voltage", Hardware.frontUltrasonic.getVoltage());
    }
}
