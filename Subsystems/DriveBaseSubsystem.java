package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class DriveBaseSubsystem extends SubsystemBase {
    // Stating DriveBaseSubsystem Variables
    boolean movePosition = false;

    // Stating and Defining DriveBaseSubsystem Objects
    public static WPI_VictorSPX frontLeftDriveMotorController = new WPI_VictorSPX(Constants.frontLeftDriveMotorControllerPort);
    public static WPI_VictorSPX backLeftDriveMotorController = new WPI_VictorSPX(Constants.backLeftDriveMotorControllerPort);
    static MotorControllerGroup leftDriveMotorControllerGroup = new MotorControllerGroup(frontLeftDriveMotorController, backLeftDriveMotorController);

    public static WPI_VictorSPX frontRightDriveMotorController = new WPI_VictorSPX(Constants.frontRightDriveMotorControllerPort);
    public static WPI_VictorSPX backRightDriveMotorController = new WPI_VictorSPX(Constants.backRightDriveMotorControllerPort);
    static MotorControllerGroup rightDriveControllerGroup = new MotorControllerGroup(frontRightDriveMotorController, backRightDriveMotorController);

    public static DifferentialDrive differentialDrive = new DifferentialDrive(leftDriveMotorControllerGroup, rightDriveControllerGroup);

    // "DriveBaseSubsystem()" creates a DriveBaseSubsystem
    public DriveBaseSubsystem() {}

    // "periodic()" is called periodically, once per scheduler run
    @Override
    public void periodic() {
        if (movePosition = true) {
            moveDistance(50, Constants.distance);
        }
    }

    // "simulationPeriodic()" is called periodically, once per scheduler run, during simulation mode
    @Override
    public void simulationPeriodic() {
    }

    // "moveDistance()" commands the DriveBaseSubsystem to move a spesific distance in centimeters
    public void moveDistance(double finalPosition, double currentPosition) {
        if (finalPosition > currentPosition) {
            leftDriveMotorControllerGroup.set(0.0004 * (finalPosition - currentPosition) * (finalPosition - currentPosition));
        } else {
            leftDriveMotorControllerGroup.set(-0.0004 * (finalPosition - currentPosition) * (finalPosition - currentPosition));
        }
    }

    // "drivePereentCurvature()" commands the DriveBaseSusbsystem to move under spesific power in percentages (-1,1)
    public static void drivePercent(double xSpeed, double zRotation, boolean allowTurnInPlace) {
        differentialDrive.curvatureDrive(xSpeed, zRotation, allowTurnInPlace);
    }
}
