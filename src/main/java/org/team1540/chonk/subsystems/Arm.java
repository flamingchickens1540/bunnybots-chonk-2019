package org.team1540.chonk.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.team1540.chonk.Tuning;

import static org.team1540.chonk.Hardware.armA;

public class Arm extends Subsystem {

    @Override
    protected void initDefaultCommand() {

    }

    public void setPosition(double position) {
        armA.set(ControlMode.Position, position * Tuning.ARM_TICKS_PER_DEGREE);
    }
}
