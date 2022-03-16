package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class DriveBaseSubsystem extends SubsystemBase {
    boolean movePosition = false;

    public static WPI_VictorSPX frontLeftDriveMotorController = new WPI_VictorSPX(Constants.frontLeftDriveMotorControllerPort);
    public static WPI_VictorSPX backLeftDriveMotorController = new WPI_VictorSPX(Constants.backLeftDriveMotorControllerPort);
    static MotorControllerGroup leftDriveMotorControllerGroup = new MotorControllerGroup(frontLeftDriveMotorController, backLeftDriveMotorController);
    public static WPI_VictorSPX frontRightDriveMotorController = new WPI_VictorSPX(Constants.frontRightDriveMotorControllerPort);
    public static WPI_VictorSPX backRightDriveMotorController = new WPI_VictorSPX(Constants.backRightDriveMotorControllerPort);
    static MotorControllerGroup rightDriveControllerGroup = new MotorControllerGroup(frontRightDriveMotorController, backRightDriveMotorController);
    public static DifferentialDrive differentialDrive = new DifferentialDrive(leftDriveMotorControllerGroup, rightDriveControllerGroup);

    /** Creates a new DriveBaseSubsystem. */
    public DriveBaseSubsystem() {}

    @Override
    public void periodic() {
        // This method will be called once per scheduler run
        if (movePosition = true) {
            moveDistance(50, Constants.distance);
        }
    }

    @Override
    public void simulationPeriodic() {
        // This method will be called once per scheduler run during simulation
    }

    // position should be in centimeters
    public void moveDistance(double finalPosition, double currentPosition) {
        if (finalPosition > currentPosition) {
            leftDriveMotorControllerGroup.set(0.0004 * (finalPosition - currentPosition) * (finalPosition - currentPosition));
        } else {
            leftDriveMotorControllerGroup.set(-0.0004 * (finalPosition - currentPosition) * (finalPosition - currentPosition));
        }
    }

    public void drivePercentArcade(double xSpeed, double zRotation, boolean squareInputs) {
        differentialDrive.arcadeDrive(xSpeed, zRotation, squareInputs);
    }

    public static void drivePercentCurvature(double xSpeed, double zRotation, boolean allowTurnInPlace) {
        differentialDrive.curvatureDrive(xSpeed, zRotation, allowTurnInPlace);
    }

    public void drivePercentTank(double leftSpeed, double rightSpeed, boolean squareInputs) {
        differentialDrive.tankDrive(leftSpeed, rightSpeed, squareInputs);
    }
}
