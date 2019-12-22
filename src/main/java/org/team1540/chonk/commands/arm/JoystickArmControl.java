package org.team1540.chonk.commands.arm;

import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.GenericHID.RumbleType;
import edu.wpi.first.wpilibj.command.Command;
import org.team1540.chonk.OI;
import org.team1540.chonk.OI.Axis;
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
        double driverArmPower = OI.getTriggerThrottle(OI.driver);
        double copilotArmPower = OI.getJoystick(OI.copilot, Hand.kLeft, Axis.Y);
        double armPower = driverArmPower != 0 ?
            Tuning.ARM_JOYSTICK_SCALE * driverArmPower :
            Tuning.ARM_JOYSTICK_SCALE * copilotArmPower;

        if (Robot.arm.getPosition() < -10 || OI.getArmSafetyOverride() || armPower < 0) {
            Robot.arm.set(armPower);
            OI.copilot.setRumble(RumbleType.kLeftRumble, 0);
            OI.copilot.setRumble(RumbleType.kRightRumble, 0);
        } else {
            Robot.arm.set(0);
            OI.copilot.setRumble(RumbleType.kLeftRumble, 0.5);
            OI.copilot.setRumble(RumbleType.kRightRumble, 0.5);
        }
    }

    @Override
    protected void end() {
        System.out.println("Joystick arm control finished");
        OI.copilot.setRumble(RumbleType.kLeftRumble, 0);
        OI.copilot.setRumble(RumbleType.kRightRumble, 0);
    }

    @Override
    protected boolean isFinished() {
        return false;
    }
}
