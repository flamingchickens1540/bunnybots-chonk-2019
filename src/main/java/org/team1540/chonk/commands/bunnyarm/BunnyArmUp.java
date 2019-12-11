package org.team1540.chonk.commands.bunnyarm;

import edu.wpi.first.wpilibj.command.InstantCommand;
import org.team1540.chonk.Robot;

public class BunnyArmUp extends InstantCommand {
    public BunnyArmUp() {
        requires(Robot.bunnyArm);
    }

    @Override
    protected void _initialize() {
        System.out.println("Moving bunny arm up...");
        Robot.bunnyArm.set(false);
    }
}
