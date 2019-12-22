package org.team1540.chonk.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.DemandType;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.team1540.chonk.Hardware;
import org.team1540.chonk.Tuning;

public class Arm extends Subsystem {
    @Override
    protected void initDefaultCommand() {
//        setDefaultCommand(new JoystickArmControl());
    }

    public void setPosition(double position) {
//        Hardware.arm.set(ControlMode.Position, position * Tuning.ARM_TICKS_PER_DEGREE);
        Hardware.arm.set(ControlMode.MotionMagic, position * Tuning.ARM_TICKS_PER_DEGREE,  DemandType.ArbitraryFeedForward, Tuning.ARM_COSINE_FEED_FORWARD_CONSTANT * Math.cos(Math.toRadians(getPosition())));
    }

    public void set(double throttle) {
        Hardware.arm.set(ControlMode.PercentOutput, throttle + (Tuning.ARM_COSINE_FEED_FORWARD_CONSTANT * Math.cos(Math.toRadians(getPosition()))));
    }

    @Override
    public void periodic() {
        SmartDashboard.putNumber("arm/encoder", getPosition());
        SmartDashboard.putNumber("arm/velocity", getVelocity());
        SmartDashboard.putNumber("arm/throttle", Hardware.arm.getMotorOutputPercent());
        SmartDashboard.putBoolean("arm/limitswitch", !Hardware.armLimitSwitch.get());
//        System.out.println(Hardware.armLimitSwitch.get());
        if (!Hardware.armLimitSwitch.get()) {
            System.out.println("Arm limit switch hit");
            Hardware.arm.setSelectedSensorPosition(Tuning.ARM_ZERO_POSITION);
        }
    }

    public double getPosition() {
        return Hardware.arm.getSelectedSensorPosition() / Tuning.ARM_TICKS_PER_DEGREE;
    }

    public double getVelocity() {
        return (Hardware.arm.getSelectedSensorVelocity() * 10) / Tuning.ARM_TICKS_PER_DEGREE;
    }
}
