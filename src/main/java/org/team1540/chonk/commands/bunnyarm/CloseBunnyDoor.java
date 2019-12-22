package org.team1540.chonk.commands.bunnyarm;

import edu.wpi.first.wpilibj.command.TimedCommand;
import org.team1540.chonk.Robot;

public class CloseBunnyDoor extends TimedCommand {

    public CloseBunnyDoor() {
        super(0.25);
        requires(Robot.bunnyDoor);
    }

    @Override
    protected void initialize() {
        Robot.bunnyDoor.close();
    }
}
