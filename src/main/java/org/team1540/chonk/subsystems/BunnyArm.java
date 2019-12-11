package org.team1540.chonk.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import org.team1540.chonk.Hardware;

public class BunnyArm extends Subsystem {
    @Override
    protected void initDefaultCommand() {}

    public void set(boolean state) {
        Hardware.bunnyArm.set(state);
    }
}
