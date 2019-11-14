package org.team1540.chonk.subsystems;

import com.revrobotics.ControlType;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.team1540.chonk.Hardware;
import org.team1540.chonk.Tuning;

public class Elevator extends Subsystem {
    @Override
    protected void initDefaultCommand() {}

    public void setPosition(double position) {
//        Hardware.elevatorL.set(ControlMode.Position, position * Tuning.ELEVATOR_TICKS_PER_INCH);
        Hardware.elevatorL.getPIDController().setReference(-position / Tuning.ELEVATOR_INCHES_PER_REV, ControlType.kPosition, 0, 0.64);
    }

    public double getPosition() {
        return Hardware.elevatorL.getEncoder().getPosition() * Tuning.ELEVATOR_INCHES_PER_REV;
    }
}