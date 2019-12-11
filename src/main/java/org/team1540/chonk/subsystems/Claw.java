package org.team1540.chonk.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import org.team1540.chonk.Hardware;
import org.team1540.chonk.commands.claw.CloseClaw;

public class Claw extends Subsystem {
    @Override
    protected void initDefaultCommand() {
//        setDefaultCommand(new CloseClaw());
    }

    public void set(boolean state) {
        Hardware.claw.set(!state);
    }
}
