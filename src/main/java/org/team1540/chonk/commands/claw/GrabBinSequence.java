package org.team1540.chonk.commands.claw;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;
import org.team1540.chonk.Hardware;
import org.team1540.chonk.OI;
import org.team1540.chonk.Tuning;
import org.team1540.chonk.commands.arm.MoveArmToPosition;
import org.team1540.chonk.utils.WaitUntilCommand;

public class GrabBinSequence extends CommandGroup {
    public GrabBinSequence() {
        addSequential(new MoveArmToPosition(Tuning.ARM_BIN_POSITION));
        addSequential(new OpenClaw());
//        addSequential(new WaitForUltrasonicOrOverride());
        addSequential(new WaitUntilCommand(() -> {
            boolean ultrasonicTriggered = Math.abs(Hardware.frontUltrasonic.getValue() - Tuning.FRONT_ULTRASONIC_BIN_DISTANCE) <= Tuning.FRONT_ULTRASONIC_THRESHOLD;
            boolean overridePressed = OI.getOverrideButtonPressed();
            return ultrasonicTriggered || overridePressed;
        }));
        addSequential(new CloseClaw());
        addSequential(new MoveArmToPosition(0));
        addSequential(new WaitCommand(Tuning.DUMP_BIN_WAIT_TIME));
        addParallel(new CommandGroup() {
            {
                addSequential(new WaitCommand(Tuning.BIN_THROW_WAIT));
                addSequential(new OpenClaw());
            }
        });
        addSequential(new MoveArmToPosition(Tuning.ARM_BIN_POSITION));
    }
}
