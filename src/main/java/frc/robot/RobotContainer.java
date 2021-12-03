// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.commands.TeleopDriveCommand;
import frc.robot.commands.autos.AAutoCommand;
import frc.robot.commands.autos.BAutoCommand;
import frc.robot.commands.autos.CAutoCommand;
import frc.robot.subsystems.DrivetrainSubsystem;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {

  private static final int kJoystickChannel = 0; // constant defining which which joystick id to use

  private XboxController xboxController; // controller used for driving the robot

  private DrivetrainSubsystem drivetrainSubsystem; // subsystem responsible for handling drivetrain operations

  private TeleopDriveCommand teleopDriveCommand; // command that will run in teleop to drive the robot manually

  // SendableChooser is a dropdown menu on SmartDashboard
  // This SendableChooser can only be populated with CommandBases
  // We do this so that in getAutonomousCommand(), we can guarantee that we return a command
  private SendableChooser<CommandBase> autoChooser;

  public RobotContainer() {
    xboxController = new XboxController(kJoystickChannel); // instantiate xboxController using kJoystickChannel constant
    drivetrainSubsystem = new DrivetrainSubsystem(); // instantiate the DrivetrainSubsystem
    teleopDriveCommand = new TeleopDriveCommand(xboxController, drivetrainSubsystem); // instantiate teleopDriveCommand
    drivetrainSubsystem.setDefaultCommand(teleopDriveCommand); // set the default command of DrivetrainSubsystem to teleopDriveCommand
    initAutoChooser(); // setup the autoChooser
    configureButtonBindings(); // setup any button bindings we want on the controller
  }

  private void initAutoChooser() {
    autoChooser = new SendableChooser<CommandBase>(); // instantiate autoChooser
    autoChooser.addOption("A Auto", new AAutoCommand(drivetrainSubsystem)); // add an instance of AAutoCommand to the autoChooser
    autoChooser.addOption("B Auto", new BAutoCommand(drivetrainSubsystem)); // add an instance of BAutoCommand to the autoChooser
    autoChooser.addOption("C Auto", new CAutoCommand(drivetrainSubsystem)); // add an instance of CAutoCommand to the autoChooser
    // add a command which is defined in line using RunCommand to the autoChooser
    autoChooser.addOption("Lambda Auto", new RunCommand(
        () -> drivetrainSubsystem.drive(.2, 0, 0), drivetrainSubsystem)
        .withTimeout(2));
    SmartDashboard.putData("Auto Chooser", autoChooser); // add the autoChooser to the SmartDashboard
  }

  public Command getAutonomousCommand() {
    // we don't need to worry about scheduling the command, the generated template handles that for us
    return autoChooser.getSelected(); // returns the command that is selected in the auto chooser on SmartDashboard
  }

  private void configureButtonBindings() {

    // add a binding to the A button on the controller to start a new AAutoCommand
    new JoystickButton(xboxController, XboxController.Button.kA.value)
        .whenPressed(new AAutoCommand(drivetrainSubsystem));

    // add a binding to the B button on the controller to start a new command which is defined in line using RunCommand
    new JoystickButton(xboxController, XboxController.Button.kB.value)
        .whenPressed(new RunCommand(() -> drivetrainSubsystem.drive(.2, 0, 0), drivetrainSubsystem)
        .withTimeout(2));

  }
}
