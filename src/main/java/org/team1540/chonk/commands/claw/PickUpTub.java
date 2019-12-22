package org.team1540.chonk.commands.claw;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.TimedCommand;
import edu.wpi.first.wpilibj.command.WaitCommand;
import org.team1540.chonk.Robot;
import org.team1540.chonk.Tuning;
import org.team1540.chonk.commands.arm.MoveArmToPosition;
import org.team1540.rooster.util.SimpleCommand;

public class PickUpTub extends CommandGroup {

    public PickUpTub() {
        addSequential(new MoveArmToPosition(Tuning.ARM_BIN_POSITION));
        addSequential(new CommandGroup() {
            {
                addParallel(new MoveArmToPosition(Tuning.ARM_BIN_POSITION));
                addParallel(new SimpleCommand("Drive forward", new TimedCommand(.15) {
                    @Override
                    protected void execute() {
                        Robot.driveTrain.setThrottle(0.5, 0.5);
                    }

                    @Override
                    protected void end() {
                        Robot.driveTrain.setThrottle(0, 0);
                    }
                }::start, Robot.driveTrain));
                addParallel(new WaitCommand(.15));
            }
        });

        addSequential(new CloseClaw());
        addSequential(new CommandGroup() {
            {
                addParallel(new SimpleCommand("Drive backward", new TimedCommand(.15) {
                    @Override
                    protected void execute() {
                        Robot.driveTrain.setThrottle(-0.5, -0.5);
                    }

                    @Override
                    protected void end() {
                        Robot.driveTrain.setThrottle(0, 0);
                    }
                }::start, Robot.driveTrain));
                addParallel(new WaitCommand(.15));
            }
        });
        addSequential(new MoveArmToPosition(Tuning.ARM_DUMP_POSITION));
    }

}
