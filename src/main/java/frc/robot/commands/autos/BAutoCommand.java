package frc.robot.commands.autos;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.DriveStraightCommand;
import frc.robot.commands.SpinCommand;
import frc.robot.subsystems.DrivetrainSubsystem;

public class BAutoCommand extends SequentialCommandGroup {
    
    public BAutoCommand(DrivetrainSubsystem drivetrainSubsystem) {
        addCommands(
            new SpinCommand(drivetrainSubsystem, .2, 2),
            new DriveStraightCommand(drivetrainSubsystem, .2, 2)
        );
    }

}
