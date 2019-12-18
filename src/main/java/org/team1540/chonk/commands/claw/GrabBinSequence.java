package org.team1540.chonk.commands.claw;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;
import org.team1540.chonk.Hardware;
import org.team1540.chonk.OI;
import org.team1540.chonk.Tuning;
import org.team1540.chonk.commands.arm.MoveArmToPosition;
import org.team1540.chonk.utils.WaitUntilCommand;

public class GrabBinSequence extends CommandGroup {
    @Override
    protected void initialize() {
        System.out.println("Starting grab bin sequence");
    }

    public GrabBinSequence() {
        addParallel(new OpenClaw());
        addSequential(new MoveArmToPosition(Tuning.ARM_BIN_POSITION));
//        addSequential(new WaitForUltrasonicOrOverride());
        addSequential(new WaitUntilCommand(() -> {
//            boolean ultrasonicTriggered = Math.abs(Hardware.frontUltrasonic.getValue() - Tuning.FRONT_ULTRASONIC_BIN_DISTANCE) <= Tuning.FRONT_ULTRASONIC_THRESHOLD;
            boolean ultrasonicTriggered = false;
            boolean overridePressed = OI.getBinOverrideButtonPressed();
            return ultrasonicTriggered || overridePressed;
        }));
        addSequential(new CloseClaw());
        addSequential(new MoveArmToPosition(Tuning.ARM_DUMP_POSITION));
        addSequential(new WaitCommand(Tuning.DUMP_BIN_WAIT_TIME));
        addParallel(new CommandGroup() {
            {
                addSequential(new WaitCommand(Tuning.BIN_THROW_WAIT));
                addSequential(new OpenClaw());
            }
        });
        addSequential(new MoveArmToPosition(Tuning.ARM_AFTER_BIN_PICKUP_POSITION));
    }

    @Override
    protected void end() {
        System.out.println("Grab bin sequence finished");
    }
}
