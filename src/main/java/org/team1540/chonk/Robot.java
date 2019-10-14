package org.team1540.chonk;

import com.ctre.phoenix.motorcontrol.ControlMode;
import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.team1540.chonk.commands.drivetrain.TankDrive;
import org.team1540.chonk.subsystems.Arm;
import org.team1540.chonk.subsystems.DriveTrain;

import static org.team1540.chonk.OI.driver;

public class Robot extends TimedRobot {

    public static DriveTrain drivetrain;
    public static Arm arm;

    @Override
    public void robotInit() {
        System.out.println("Robot Initializing...");
        drivetrain = new DriveTrain();
        arm = new Arm();
        Hardware.initAll();
        OI.init();
        SmartDashboard.putNumber("arm/power", 0);
    }

    @Override
    public void teleopInit() {
        System.out.println("Teleop Initializing...");
        Hardware.armL.setSelectedSensorPosition(0);
        Hardware.setArmPID();
    }

    @Override
    public void teleopPeriodic() {
        /*
        double armPower = OI.driver.getY(GenericHID.Hand.kRight);
        Hardware.armL.set(ControlMode.PercentOutput, armPower);
        SmartDashboard.putNumber("arm/power", armPower);
         */
    }

    @Override
    public void robotPeriodic() {
        Scheduler.getInstance().run();
        SmartDashboard.putNumber("arm/encoder", arm.getPosition());
    }
}
