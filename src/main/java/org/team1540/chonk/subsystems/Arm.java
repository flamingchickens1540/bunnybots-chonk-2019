package org.team1540.chonk.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.team1540.chonk.Hardware;
import org.team1540.chonk.Tuning;

public class Arm extends Subsystem {

    @Override
    protected void initDefaultCommand() {

    }

    public void setPosition(double position) {
        Hardware.armR.set(ControlMode.Position, position * Tuning.ARM_TICKS_PER_DEGREE);
    }

    public double getPosition() {
        return Hardware.armR.getSelectedSensorPosition() / Tuning.ARM_TICKS_PER_DEGREE;
    }
}
