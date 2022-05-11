package frc.robot.subsystems;

import frc.robot.IO;
import frc.robot.SubsystemScheduler;

public class DriveBaseSubsystem extends SubsystemScheduler {
    // Stating DriveBaseSubsystem Variables
    private boolean moveByPosition = false;

    // this will run ever 20ms durring teleop
    @Override
    public void periodic() {

        if (moveByPosition == true) {
            moveDistance(50, IO.distance);
        } else {
            movePercent(IO.mainJoystick.getRawAxis(0), IO.mainJoystick.getRawAxis(1), true);
        }
    }


    // functions to be called by IO

    public void moveByPosition() {
        moveByPosition = true;
    }

    public void moveByStick() {
        moveByPosition = false;
    }

    public static void movePercent(double xSpeed, double zRotation, boolean allowTurnInPlace) {
        IO.differentialDrive.curvatureDrive(xSpeed, -zRotation, allowTurnInPlace);
    }

    // "moveDistance()" commands the DriveBaseSubsystem to move a spesific distance in centimeters
    public static void moveDistance(double finalPosition, double currentPosition) {
        double power = 0.0004 * (finalPosition - currentPosition) * (finalPosition - currentPosition);
        System.out.print(power);
        if (power > 1) {
            power = 1;            
        }
        if (finalPosition > currentPosition) {
            IO.frontLeftDriveMotorController.set(power);
            IO.backLeftDriveMotorController.set(power);
            IO.frontRightDriveMotorController.set(-power);
            IO.backRightDriveMotorController.set(-power);
        } else {
            IO.frontLeftDriveMotorController.set(-power);
            IO.backLeftDriveMotorController.set(-power);
            IO.frontRightDriveMotorController.set(power);
            IO.backRightDriveMotorController.set(power);
        }
    }
}