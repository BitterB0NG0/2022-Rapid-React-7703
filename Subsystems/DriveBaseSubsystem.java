package frc.robot.Subsystems;

import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import frc.robot.Constants;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

public class DriveBaseSubsystem {
    public static void main(String[] args) {
        
    }

    public void drivePercent(double percentPower) {
        Constants.frontLeftDriveMotorController.set(ControlMode.PercentOutput, percentPower * -1);
        Constants.backLeftDriveMotorController.set(ControlMode.PercentOutput, percentPower * -1);

        Constants.frontRightDriveMotorController.set(ControlMode.PercentOutput, percentPower);
        Constants.backRightDriveMotorController.set(ControlMode.PercentOutput, percentPower);
    }

    public void driveDistance(double centimeterDistance) {

    }

} 