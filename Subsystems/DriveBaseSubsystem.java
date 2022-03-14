package frc.robot.Subsystems;

import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import frc.robot.Constants;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

public class DriveBaseSubsystem {
    public static void main(String[] args) {
        
    }

    public void drivePercent(double percent) {
        Constants.firstLeftDriveBase.set(ControlMode.PercentOutput, percent);
        Constants.secondLeftDriveBase.set(ControlMode.PercentOutput, percent);

        Constants.firstRightDriveBase.set(ControlMode.PercentOutput, percent * -1);
        Constants.secondRightDriveBase.set(ControlMode.PercentOutput, percent * -1);
    }

    public void driveDistance(double centimeters) {

    }
} 