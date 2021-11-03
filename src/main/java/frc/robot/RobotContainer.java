// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.XboxController;
import frc.robot.commands.AutoDriveCommand;
import frc.robot.commands.TeleopDriveCommand;
import frc.robot.subsystems.DrivetrainSubsystem;
import edu.wpi.first.wpilibj2.command.Command;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {

  private static final int kJoystickChannel = 0;

  private XboxController xboxController;

  private DrivetrainSubsystem drivetrainSubsystem;

  private TeleopDriveCommand teleopDriveCommand;

  public RobotContainer() {
    xboxController = new XboxController(kJoystickChannel);
    teleopDriveCommand = new TeleopDriveCommand(xboxController);
    drivetrainSubsystem = new DrivetrainSubsystem();
    drivetrainSubsystem.setDefaultCommand(teleopDriveCommand);
  }

  public Command getAutonomousCommand() {
    return new AutoDriveCommand(.1, .1, 0, drivetrainSubsystem).withTimeout(1)
      .andThen(new AutoDriveCommand(.1, .1, .5, drivetrainSubsystem).withTimeout(1));
  }
}
