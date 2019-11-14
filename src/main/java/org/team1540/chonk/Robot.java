package org.team1540.chonk;

import com.ctre.phoenix.motorcontrol.ControlMode;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.team1540.chonk.subsystems.Arm;
import org.team1540.chonk.subsystems.DriveTrain;
import org.team1540.chonk.subsystems.Elevator;

public class Robot extends TimedRobot {

    public static DriveTrain drivetrain;
    public static Arm arm;
    public static Elevator elevator;

    @Override
    public void robotInit() {
        System.out.println("Robot Initializing...");
        drivetrain = new DriveTrain();
        arm = new Arm();
        elevator = new Elevator();
        Hardware.initAll();
        OI.init();

        SmartDashboard.putNumber("elevator/p", Tuning.ELEVATOR_P);
        SmartDashboard.putNumber("elevator/i", Tuning.ELEVATOR_I);
        SmartDashboard.putNumber("elevator/d", Tuning.ELEVATOR_D);

        SmartDashboard.putNumber("drive/pointp", Tuning.POINT_DRIVE_P);
        SmartDashboard.putNumber("drive/pointi", Tuning.POINT_DRIVE_I);
        SmartDashboard.putNumber("drive/pointd", Tuning.POINT_DRIVE_D);

        SmartDashboard.putNumber("drive/limelightp", Tuning.LIMELIGHT_P);
        SmartDashboard.putNumber("drive/limelighti", Tuning.LIMELIGHT_I);
        SmartDashboard.putNumber("drive/limelightd", Tuning.LIMELIGHT_D);
    }

    @Override
    public void teleopInit() {
        Hardware.armL.set(ControlMode.PercentOutput, 0);
        System.out.println("Teleop Initializing...");
        Hardware.armL.setSelectedSensorPosition(0);
        Hardware.setArmPID();
        Hardware.setElevatorPID();
        Hardware.elevatorL.set(0);
    }

    @Override
    public void teleopPeriodic() {
    }

    @Override
    public void robotPeriodic() {
        Scheduler.getInstance().run();
        SmartDashboard.putNumber("arm/encoder", arm.getPosition());
        SmartDashboard.putNumber("arm/velocity", arm.getVelocity());
        SmartDashboard.putNumber("elevator/encoder", elevator.getPosition());
        SmartDashboard.putNumber("elevator/output", Hardware.elevatorL.getAppliedOutput());
    }
}
