package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj.motorcontrol.PWMVictorSPX;

public class DriveBaseSubsystem extends SubsystemBase {
    
    //Declaring Instances of Component/Drive System Methods
    private PWMVictorSPX leftMotorController1;
    private PWMVictorSPX leftMotorController2;
    private MotorControllerGroup leftMotorControllerGroup;
    private PWMVictorSPX rightMotorController1;
    private PWMVictorSPX rightMotorController2;
    private MotorControllerGroup rightMotorControllerGroup;
    private DifferentialDrive differentialDrive;

    // DriveBaseSubystem Subsystem Method
    public DriveBaseSubsystem() {
        // Declaring Motor Controllers and Motor Controller Groups
        leftMotorController1 = new PWMVictorSPX(0);
         addChild("left1", leftMotorController1);
         leftMotorController1.setInverted(false);

        leftMotorController2 = new PWMVictorSPX(1);
         addChild("left2", leftMotorController2);
         leftMotorController2.setInverted(false);

        leftMotorControllerGroup = new MotorControllerGroup(leftMotorController1, leftMotorController2);
         addChild("Left Motor", leftMotorControllerGroup);

        rightMotorController1 = new PWMVictorSPX(5);
         addChild("right1", rightMotorController1);
         rightMotorController1.setInverted(false);

        rightMotorController2 = new PWMVictorSPX(6);
         addChild("right2", rightMotorController2);
         rightMotorController2.setInverted(false);
        
        rightMotorControllerGroup = new MotorControllerGroup(rightMotorController1, rightMotorController2);
         addChild("Right Motor", rightMotorControllerGroup);

        // Declaring an Instance of DifferentialDrive
        differentialDrive = new DifferentialDrive(leftMotorControllerGroup, rightMotorControllerGroup);
         addChild("Drive", differentialDrive);
        
        // Calling Miscellaneous Methods
        differentialDrive.setSafetyEnabled(true);
        differentialDrive.setExpiration(0.1);
        differentialDrive.setMaxOutput(1.0);
    }

    // Method Called Periodically, Once per Scheduler Run
    @Override
    public void periodic() {
    }

    // Method Called Periodically, Once per Scheduler Run, During a Simulation
    @Override
    public void simulationPeriodic() {
    }

    // aracdeDrive Method
    public void arcadeDrive(double xSpeed, double zRotationSpeed, boolean squareInputs) {
        differentialDrive.arcadeDrive(xSpeed, zRotationSpeed, squareInputs);
    }

    // tankDrive Method
    public void tankDrive( double xLeftSpeed, double xRightSpeed, boolean squareInputs) {
        differentialDrive.tankDrive(xLeftSpeed, xRightSpeed);
    }

    // curvature Method
    public void curvatureDrive(double xSpeed, double zRotationSpeed, boolean squareInputs) {
        differentialDrive.curvatureDrive(xSpeed, zRotationSpeed, squareInputs);
    }
} 