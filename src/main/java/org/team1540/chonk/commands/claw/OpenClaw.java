package org.team1540.chonk.commands.claw;

import edu.wpi.first.wpilibj.command.TimedCommand;
import org.team1540.chonk.Robot;
import org.team1540.chonk.Tuning;

public class OpenClaw extends TimedCommand {
    public OpenClaw() {
        super(Tuning.CLAW_MOVE_TIME);
        requires(Robot.claw);
    }

    @Override
    protected void initialize() {
        Robot.claw.set(false);
    }
}
