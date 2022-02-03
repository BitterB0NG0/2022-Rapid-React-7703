package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;
import frc.robot.subsystems.DriveBaseSubsystem;

public class ArcadeDrive extends CommandBase {
    
    // Declaring an Instance of DriveBaseSubsystem
    private final DriveBaseSubsystem driveBaseSubsystem;

    // ArcadeDrive Command Method
    public ArcadeDrive(DriveBaseSubsystem subsystem) {
        driveBaseSubsystem = subsystem;
        addRequirements(driveBaseSubsystem);
    }

    // Method Called During Command Initialization
    @Override
    public void initialize() {

    }

    // Method Called Everytime the Scheduler Runs While Command is Scheduled
    @Override
    public void execute() {
        driveBaseSubsystem.arcadeDrive(RobotContainer.stick.getY(), RobotContainer.stick.getY());
    }

    // Method Called When the Command Ends or is Interrputed
    @Override
    public void end(boolean interrupted) {
        driveBaseSubsystem.arcadeDrive(0.0, 0.0);
    }

    // Method Return "true" when the Command Should End
    @Override
    public boolean isFinished() {
        return false;
    }

    @Override
    public boolean runsWhenDisabled() {
        return false;
    }

}