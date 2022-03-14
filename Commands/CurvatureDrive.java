package main.java.frc.robot.Commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;
import frc.robot.subsystems.DriveBaseSubsystem;

public class CurvatureDrive extends CommandBase {

    // Declaring an Instance of DriveBaseSubsystem
    private final DriveBaseSubsystem driveBaseSubsystem;

    // ArcadeDrive Command Method
    public CurvatureDrive(DriveBaseSubsystem subsystem) {
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
        driveBaseSubsystem.curvatureDrive(RobotContainer.stick.getY(), RobotContainer.stick.getY(), true);
    }

    // Method Called When the Command Ends or is Interrputed
    @Override
    public void end(boolean interrupted) {
        driveBaseSubsystem.curvatureDrive(0.0, 0.0, true);
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