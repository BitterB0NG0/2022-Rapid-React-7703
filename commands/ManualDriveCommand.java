package frc.robot.commands;

import frc.robot.Constants;
import frc.robot.RobotContainer;
import frc.robot.subsystems.DriveSubsystem;

public class ManualDriveCommand {

    public ManualDriveCommand(DriveSubsystem driveSubsystem) {
    }


    protected void initialize() {
    }

    protected void execute() {
        double xSpeed = Constants.stick.getY();
        double zRotationRate = Constants.stick.getX();

        RobotContainer.driveSubsystem.manualDrive(xSpeed,zRotationRate);
    }

    protected void end() {
    }

    protected boolean isFinished() {
        return false;
    }
}
