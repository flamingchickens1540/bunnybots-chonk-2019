package org.team1540.chonk.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.TimedCommand;
import edu.wpi.first.wpilibj.command.WaitCommand;
import org.team1540.chonk.Hardware;
import org.team1540.chonk.Robot;
import org.team1540.chonk.Tuning;
import org.team1540.chonk.commands.arm.MoveArmToPosition;
import org.team1540.chonk.commands.claw.CloseClaw;
import org.team1540.chonk.commands.claw.OpenClaw;
import org.team1540.chonk.commands.drivetrain.MoveForwardLineUp;
import org.team1540.chonk.utils.WaitUntilCommand;
import org.team1540.rooster.util.SimpleCommand;

public class Autonomous extends CommandGroup {

    public Autonomous() {
        addSequential(new CommandGroup() {
            {
//                addParallel(new GrabBunnies());
//                addParallel(new ZeroArm());
                addParallel(new OpenClaw());
                addParallel(new MoveArmToPosition(Tuning.ARM_DUMP_POSITION));
            }
        });
        addSequential(new MoveForwardLineUp(315_000));
        addParallel(
            new SimpleCommand("stop", () -> Robot.driveTrain.setThrottle(0, 0), Robot.driveTrain));
        addSequential(new MoveArmToPosition(Tuning.ARM_PREPGRAB_POSITION));
        addParallel(new SimpleCommand("Move fwd", () -> Robot.driveTrain.setThrottle(.1, .1),
            Robot.driveTrain));
        addSequential(new WaitUntilCommand(
            () -> Hardware.frontUltrasonic.getVoltage() < Tuning.FRONT_ULTRASONIC_BIN_DISTANCE));
        addSequential(
            new SimpleCommand("stop", () -> Robot.driveTrain.setThrottle(0, 0), Robot.driveTrain));
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
