package frc.robot.commands.autos;

import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import frc.robot.commands.SpinCommand;
import frc.robot.subsystems.DrivetrainSubsystem;

public class CAutoCommand extends ParallelCommandGroup {
    
    public CAutoCommand(DrivetrainSubsystem drivetrainSubsystem) {
        addCommands(
            new SpinCommand(drivetrainSubsystem, .2, 2),
            new AAutoCommand(drivetrainSubsystem)
        );
    }

}
