package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.RobotContainer;

public class DriveBaseSubsystem extends SubsystemBase {
    // Stating DriveBaseSubsystem Variables
    boolean moveByPosition = false;

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
        if (RobotContainer.mainJoystick.getRawButtonPressed(10)) {
            moveByPosition = true;
        } 
        if (RobotContainer.mainJoystick.getRawButtonPressed(11)) {
            moveByPosition = false;
        }

        if (moveByPosition == true) {
            moveDistance(50, Constants.distance);
            System.out.print("Move by Pos");
        } else {
            movePercent(RobotContainer.mainJoystick.getRawAxis(0),RobotContainer.mainJoystick.getRawAxis(1), true);
        }
    }

    // "simulationPeriodic()" is called periodically, once per scheduler run, during simulation mode
    @Override
    public void simulationPeriodic() {
    }

    // "moveDistance()" commands the DriveBaseSubsystem to move a spesific distance in centimeters
    public static void moveDistance(double finalPosition, double currentPosition) {
        double power = 0.0004 * (finalPosition - currentPosition) * (finalPosition - currentPosition);
        System.out.print(power);
        if (power > 1) {
            power = 1;            
        }
        if (finalPosition > currentPosition) {
            frontLeftDriveMotorController.set(power);
            backLeftDriveMotorController.set(power);
            frontRightDriveMotorController.set(-power);
            backRightDriveMotorController.set(-power);
        } else {
            frontLeftDriveMotorController.set(-power);
            backLeftDriveMotorController.set(-power);
            frontRightDriveMotorController.set(power);
            backRightDriveMotorController.set(power);
        }
    }

    // "drivePercentCurvature()" commands the DriveBaseSusbsystem to move under spesific power in percentages (-1,1)
    public static void movePercent(double xSpeed, double zRotation, boolean allowTurnInPlace) {
        differentialDrive.curvatureDrive(xSpeed, -zRotation, allowTurnInPlace);
    }

    public void haultMovement() {
        differentialDrive.stopMotor();
    }
}
