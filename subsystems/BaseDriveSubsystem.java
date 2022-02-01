package frc.robot.subsystems;

import frc.robot.commands.*;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorController;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj.motorcontrol.PWMVictorSPX;


public class DriveBaseSubsystem extends SubsystemBase {
    private PWMVictorSPX left1;
    private PWMVictorSPX left2;
    private MotorControllerGroup leftMotor;
    private PWMVictorSPX right1;
    private PWMVictorSPX right2;
    private MotorControllerGroup rightMotor;
    private DifferentialDrive drive;

    public DriveBaseSubsystem() {
        left1 = new PWMVictorSPX(0);
         addChild("left1", left1);
         left1.setInverted(false);

        left2 = new PWMVictorSPX(1);
         addChild("left2", left2);
         left2.setInverted(false);

        leftMotor = new MotorControllerGroup(left1, left2);
         addChild("Left Motor", leftMotor);


        right1 = new PWMVictorSPX(5);
         addChild("right1", right1);
         right1.setInverted(false);

        right2 = new PWMVictorSPX(6);
         addChild("right2", right2);
         right2.setInverted(false);

        rightMotor = new MotorControllerGroup(right1, right2);
         addChild("Right Motor", rightMotor);


        drive = new DifferentialDrive(leftMotor, rightMotor);
         addChild("Drive",drive);
         drive.setSafetyEnabled(true);
        drive.setExpiration(0.1);
        drive.setMaxOutput(1.0);
    }

    @Override
    public void periodic() {
        // This method will be called once per scheduler run

    }

    @Override
    public void simulationPeriodic() {
        // This method will be called once per scheduler run when in simulation

    }

    public void drive(double left, double right) {
        drive.tankDrive(left, right);
    }


    //if going to crash: 
    //    don't 



}
