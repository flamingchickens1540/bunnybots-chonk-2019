package org.team1540.chonk;

import com.ctre.phoenix.motorcontrol.ControlMode;
import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class ArmTestRobot extends TimedRobot {
    private static XboxController driver;

    @Override
    public void robotInit() {
        Hardware.initArm();
        driver = new XboxController(0);
    }

    @Override
    public void teleopPeriodic() {
        Hardware.arm.set(ControlMode.PercentOutput, driver.getY(GenericHID.Hand.kRight));
        SmartDashboard.putNumber("arm/encoder", Hardware.arm.getSelectedSensorPosition());
        SmartDashboard.putNumber("arm/encoder", Hardware.arm.getMotorOutputPercent());
    }
}