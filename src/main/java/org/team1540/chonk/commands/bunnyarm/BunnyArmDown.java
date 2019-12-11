package org.team1540.chonk.commands.bunnyarm;

import edu.wpi.first.wpilibj.command.InstantCommand;
import org.team1540.chonk.Robot;
import org.team1540.chonk.subsystems.BunnyArm;

public class BunnyArmDown extends InstantCommand {
    public BunnyArmDown() {
        requires(Robot.bunnyArm);
    }

    @Override
    protected void _initialize() {
        System.out.println("Moving bunny arm down...");
        Robot.bunnyArm.set(true);
    }
}
