package org.team1540.chonk;

import com.ctre.phoenix.motorcontrol.ControlMode;
import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.team1540.rooster.util.SimpleCommand;

public class ArmTestRobot extends TimedRobot {
    private static XboxController driver;

    private static JoystickButton driverAButton;
    private static JoystickButton driverBButton;

    @Override
    public void robotInit() {
        Hardware.initArm();
        Hardware.initClaw();
        Hardware.initBunnyArm();
        Hardware.initCompressor();
        driver = new XboxController(0);
        driverAButton = new JoystickButton(driver, 1);
        driverBButton = new JoystickButton(driver, 2);
    }

    @Override
    public void teleopPeriodic() {
        Hardware.arm.set(ControlMode.PercentOutput, driver.getY(GenericHID.Hand.kRight));
        Hardware.claw.set(!driverAButton.get());
        Hardware.bunnyArm.set(driverBButton.get());
        SmartDashboard.putNumber("arm/encoder", Hardware.arm.getSelectedSensorPosition());
        SmartDashboard.putNumber("arm/encoder", Hardware.arm.getMotorOutputPercent());
    }
}