package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class DriveBaseSubsystem extends SubsystemBase {
    /** Creates a new DriveBaseSubsystem. */
    public DriveBaseSubsystem() {}

    @Override
    public void periodic() {
        // This method will be called once per scheduler run
    }

    @Override
    public void simulationPeriodic() {
        // This method will be called once per scheduler run during simulation
    }

    public void drivePercentArcade(double xSpeed, double zRotation, boolean squareInputs) {
        Constants.differentialDrive.arcadeDrive(xSpeed, zRotation, squareInputs);
    }

    public static void drivePercentCurvature(double xSpeed, double zRotation, boolean allowTurnInPlace) {
        Constants.differentialDrive.curvatureDrive(xSpeed, zRotation, allowTurnInPlace);
    }

    public void drivePercentTank(double leftSpeed, double rightSpeed, boolean squareInputs) {
        Constants.differentialDrive.tankDrive(leftSpeed, rightSpeed, squareInputs);
    }
}
