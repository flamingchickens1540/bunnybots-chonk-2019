package org.team1540.chonk.commands.leds;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import org.team1540.chonk.Robot;

public class IdleLEDs extends Command {

    @Override
    protected void initialize() {
        System.out.println("Setting LEDs to Idle");
        Robot.leds.setRaw(false, true, false);

    }

    @Override
    protected boolean isFinished() {
        return false;
    }
}
