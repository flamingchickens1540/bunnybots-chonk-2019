package org.team1540.chonk;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.command.Command;
import org.team1540.chonk.commands.arm.MoveArmToPosition;
import org.team1540.chonk.commands.bunnyarm.BunnyArmDown;
import org.team1540.chonk.commands.bunnyarm.BunnyArmUp;
import org.team1540.chonk.commands.claw.CloseClaw;
import org.team1540.chonk.commands.claw.GrabBinSequence;
import org.team1540.chonk.commands.claw.OpenClaw;
import org.team1540.rooster.Utilities;
import org.team1540.rooster.triggers.DPadAxis;
import org.team1540.rooster.triggers.DPadButton;
import org.team1540.rooster.util.SimpleCommand;

public class OI {
    //driver
    public static XboxController driver = new XboxController(0);

    public static Button driverAButton = new JoystickButton(driver, 1);
    public static Button driverBButton = new JoystickButton(driver, 2);
    public static Button driverXButton = new JoystickButton(driver, 3);
    public static Button driverYButton = new JoystickButton(driver, 4);

    public static Button driverRB = new JoystickButton(driver, 6);
    public static Button driverLB = new JoystickButton(driver, 5);

    public static Button driverBackButton = new JoystickButton(driver, 7);
    public static Button driverStartButton = new JoystickButton(driver, 8);

    public static Button driverRightJoystickButton = new JoystickButton(driver, 10);
    public static Button driverLeftJoystickButton = new JoystickButton(driver, 9);

    public static Button driverDpadUp = new DPadButton(driver, 0, DPadAxis.UP);
    public static Button driverDpadDown = new DPadButton(driver, 0, DPadAxis.DOWN);
    public static Button driverDpadLeft = new DPadButton(driver, 0, DPadAxis.LEFT);
    public static Button driverDpadRight = new DPadButton(driver, 0, DPadAxis.RIGHT);

    //copilot
    public static XboxController copilot = new XboxController(1);

    public static Button copilotAButton = new JoystickButton(copilot, 1);
    public static Button copilotBButton = new JoystickButton(copilot, 2);
    public static Button copilotXButton = new JoystickButton(copilot, 3);
    public static Button copilotYButton = new JoystickButton(copilot, 4);

    public static Button copilotRB = new JoystickButton(copilot, 6);
    public static Button copilotLB = new JoystickButton(copilot, 5);

    public static Button copilotBackButton = new JoystickButton(copilot, 7);
    public static Button copilotStartButton = new JoystickButton(copilot, 8);

    public static Button copilotRightJoystickButton = new JoystickButton(copilot, 10);
    public static Button copilotLeftJoystickButton = new JoystickButton(copilot, 9);

    public static Button copilotDpadUp = new DPadButton(copilot, 0, DPadAxis.UP);
    public static Button copilotDpadDown = new DPadButton(copilot, 0, DPadAxis.DOWN);
    public static Button copilotDpadLeft = new DPadButton(copilot, 0, DPadAxis.LEFT);
    public static Button copilotDpadRight = new DPadButton(copilot, 0, DPadAxis.RIGHT);

    public enum Axis {
        X,
        Y
    }

    public static double getJoystick(XboxController controller, GenericHID.Hand hand, Axis axis) {
        if (axis == Axis.X) {
            return Utilities.processDeadzone(controller.getX(hand), .1);
        } else {
            return -Utilities.processDeadzone(controller.getY(hand), .1);
        }
    }

    public static double getTriggerThrottle() {
        return Utilities.scale(Utilities.processDeadzone(OI.driver.getTriggerAxis(GenericHID.Hand.kRight) - OI.driver.getTriggerAxis(GenericHID.Hand.kLeft), .1), 2);
    }

    public static boolean getBinOverrideButtonPressed() {
        return copilotAButton.get();
    }

    //bindings
    public static void init() {
        System.out.println("Initializing OI...");

        copilotAButton.whenPressed(new BunnyArmDown());
        copilotAButton.whenReleased(new BunnyArmUp());
        copilotBButton.whenPressed(new CloseClaw());
        copilotBButton.whenReleased(new OpenClaw());
        copilotXButton.whenPressed(new MoveArmToPosition(125));
//        copilotDpadUp.whenPressed(new MoveArmToPosition(0));
//        copilotDpadDown.whenPressed(new MoveArmToPosition(Tuning.ARM_BIN_POSITION));
//        Command grabBinCommand = new GrabBinSequence();
//        driverXButton.whenPressed(grabBinCommand);
//        driverBButton.cancelWhenPressed(grabBinCommand);
    }
}