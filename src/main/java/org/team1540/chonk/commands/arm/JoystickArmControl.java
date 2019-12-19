package org.team1540.chonk.commands.arm;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.command.Command;
import org.team1540.chonk.OI;
import org.team1540.chonk.Robot;
import org.team1540.chonk.Tuning;

public class JoystickArmControl extends Command {

    public JoystickArmControl() {
        requires(Robot.arm);
    }

    @Override
    protected void initialize() {
        System.out.println("Starting joystick arm control");
    }

    @Override
    protected void execute() {
        Robot.arm.set(Tuning.ARM_JOYSTICK_SCALE * OI.getJoystick(OI.copilot, GenericHID.Hand.kLeft, OI.Axis.Y));
    }

    @Override
    protected void end() {
        System.out.println("Joystick arm control finished");
    }

    @Override
    protected boolean isFinished() {
        return false;
    }
}
