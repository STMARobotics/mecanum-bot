package frc.robot.commands;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DrivetrainSubsystem;

public class TeleopDriveCommand extends CommandBase {
    
    private XboxController xboxController;
    private DrivetrainSubsystem drivetrainSubsystem;

    public TeleopDriveCommand(XboxController controller) {
        this.xboxController = controller;
        addRequirements(drivetrainSubsystem);
    }

    @Override
    public void execute() {
        drivetrainSubsystem.drive(
            xboxController.getX(Hand.kLeft) / 2,
            xboxController.getY(Hand.kLeft) / 2,
            -xboxController.getX(Hand.kRight) / 2);
    }

}
