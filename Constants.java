package frc.robot;

import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.BuiltInAccelerometer;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.interfaces.Accelerometer;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.cameraserver.CameraServer;

public class Constants {
    /* 
    *  The CAN IDs are set up from first device to last, even if the said last device is not powered up, or even used by the code (I'm looking at you PDP).
    *  These motor names SHOULD be changed depending on their purpose in the final code!
    */

    // VictorSPX motor1 = new VictorSPX(2);
    // VictorSPX motor2 = new VictorSPX(3);
    // VictorSPX motor3 = new VictorSPX(4);
    // VictorSPX motor4 = new VictorSPX(5);
    // VictorSPX motor5 = new VictorSPX(6);
    // VictorSPX motor6 = new VictorSPX(7);

    public static WPI_VictorSPX frontLeftDriveMotorController = new WPI_VictorSPX(2);
    public static WPI_VictorSPX backLeftDriveMotorController = new WPI_VictorSPX(3);
    static MotorControllerGroup leftDriveMotorControllerGroup = new MotorControllerGroup(frontLeftDriveMotorController, backLeftDriveMotorController);

    public static WPI_VictorSPX frontRightDriveMotorController = new WPI_VictorSPX(8);
    public static WPI_VictorSPX backRightDriveMotorController = new WPI_VictorSPX(9);
    static MotorControllerGroup rightDriveControllerGroup = new MotorControllerGroup(frontRightDriveMotorController, backRightDriveMotorController);

    public static DifferentialDrive differentialDrive = new DifferentialDrive(leftDriveMotorControllerGroup, rightDriveControllerGroup);

    
    public static Joystick mainJoystick = new Joystick(0);
    static AnalogInput ultrasonic = new AnalogInput(0);
    static Accelerometer accelerometer = new BuiltInAccelerometer();


}
