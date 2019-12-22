package org.team1540.chonk.commands.arm;

import edu.wpi.first.wpilibj.command.Command;
import org.team1540.chonk.Hardware;
import org.team1540.chonk.Robot;

public class ZeroArm extends Command {

    public ZeroArm() {
        requires(Robot.arm);
    }

    @Override
    protected void initialize() {
        Robot.arm.set(0.25);
    }

    @Override
    protected void end() {
        Robot.arm.set(0);
    }

    @Override
    protected boolean isFinished() {
        return !Hardware.armLimitSwitch.get();
    }
}
