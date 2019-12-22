package org.team1540.chonk.commands.bunnyarm;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.TimedCommand;
import edu.wpi.first.wpilibj.command.WaitCommand;
import org.team1540.chonk.Robot;
import org.team1540.rooster.util.SimpleCommand;

public class GrabBunnies extends CommandGroup {

    public GrabBunnies() {
        addSequential(new OpenBunnyDoor());
        addSequential(new BunnyArmDown());
        addSequential(new WaitCommand(0.5));
        addParallel(new SimpleCommand("Drive forward", new TimedCommand(3) {
            @Override
            protected void execute() {
                Robot.driveTrain.setThrottle(0.1, 0.1);
            }

            @Override
            protected void end() {
                Robot.driveTrain.setThrottle(0, 0);
            }
        }::start));
        addSequential(new WaitCommand(3.5));
        addSequential(new BunnyArmUp());
        addSequential(new WaitCommand(1));
        addSequential(new CloseBunnyDoor());
    }
}
