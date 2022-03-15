package frc.robot.Subsystems;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import frc.robot.Constants;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

public class DriveBaseSubsystem {
    public static void main(String[] args) {
        
    }

    public void drivePercentArcade(double xSpeed, double zRotation, boolean squareInputs) {
        
        Constants.differentialDrive.arcadeDrive(xSpeed, zRotation, squareInputs);
    }

    public void drivePercentCurvature(double xSpeed, double zRotation, boolean allowTurnInPlace) {
       
        Constants.differentialDrive.curvatureDrive(xSpeed, zRotation, allowTurnInPlace);
    }

    public void drivePercentTank(double leftSpeed, double rightSpeed, boolean squareInputs) {
      
        Constants.differentialDrive.tankDrive(leftSpeed, rightSpeed, squareInputs);
    }

    public void driveDistance(double centimeterDistance) {

    }

} 