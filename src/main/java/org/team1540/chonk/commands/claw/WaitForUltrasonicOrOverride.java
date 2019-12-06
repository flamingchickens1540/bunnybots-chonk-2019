package org.team1540.chonk.commands.claw;

import edu.wpi.first.wpilibj.command.Command;
import org.team1540.chonk.Hardware;
import org.team1540.chonk.OI;
import org.team1540.chonk.Tuning;

public class WaitForUltrasonicOrOverride extends Command {
    @Override
    protected boolean isFinished() {
        boolean ultrasonicTriggered = Math.abs(Hardware.frontUltrasonic.getValue() - Tuning.FRONT_ULTRASONIC_BIN_DISTANCE) <= Tuning.FRONT_ULTRASONIC_THRESHOLD;
        boolean overridePressed = OI.getOverrideButtonPressed();
        return ultrasonicTriggered || overridePressed;
    }
}
