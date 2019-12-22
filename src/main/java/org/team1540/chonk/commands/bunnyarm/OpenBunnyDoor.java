package org.team1540.chonk.commands.bunnyarm;

import edu.wpi.first.wpilibj.command.TimedCommand;
import org.team1540.chonk.Robot;

public class OpenBunnyDoor extends TimedCommand {

    public OpenBunnyDoor() {
        super(0.25);
        requires(Robot.bunnyDoor);
    }

    @Override
    protected void initialize() {
        Robot.bunnyDoor.open();
    }
}
