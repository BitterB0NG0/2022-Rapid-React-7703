package frc.robot.subsystems;

import com.revrobotics.ColorMatch;
import com.revrobotics.ColorMatchResult;
import com.revrobotics.ColorSensorV3;

import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.math.filter.LinearFilter;
import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.BuiltInAccelerometer;
import edu.wpi.first.wpilibj.RobotController;
import edu.wpi.first.wpilibj.interfaces.Accelerometer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.util.Color;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class SensorSubsystem extends SubsystemBase {

    public static AnalogInput ultrasonic = new AnalogInput(0);
    public static Accelerometer accelerometer = new BuiltInAccelerometer();
    private static ColorSensorV3 colorSensor = new ColorSensorV3(Constants.i2cPort);
    private final ColorMatch colorMatcher = new ColorMatch();

    // Filitering Input Accelration
    LinearFilter xAccelFilter = LinearFilter.movingAverage(10);
    LinearFilter yAccelFilter = LinearFilter.movingAverage(10);
    double prevXAccel = 0;
    double prevYAccel = 0;
    
    // Defining a Camera Variables
    Thread m_visionThread;

    private final Color kBlueTarget = new Color(0.143, 0.427, 0.429);
    private final Color kGreenTarget = new Color(0.197, 0.561, 0.240);
    private final Color kRedTarget = new Color(0.561, 0.232, 0.114);
    private final Color kYellowTarget = new Color(0.361, 0.524, 0.113);

    // "SensorSubsystem()" creates a SensorSubsystem
    public SensorSubsystem() {
        colorMatcher.addColorMatch(kBlueTarget);
        colorMatcher.addColorMatch(kGreenTarget);
        colorMatcher.addColorMatch(kRedTarget);
        colorMatcher.addColorMatch(kYellowTarget);   
    }

    // "colorSensorPeriodic()" is called periodically, once per scheduler run
    @Override
    public void periodic() {
        Constants.distance = distanceSensorValuePeriodic();
    }

    // "simulationPeriodic()" is called periodically, once per scheduler run, during simulation mode
    @Override
    public void simulationPeriodic() {}

    // "cameraInit()" initilizes the
    public void cameraInit() {
        CameraServer.startAutomaticCapture();
    }

    // "colorSensorPeriodic()" runs periodically, calling the functions of the color sensor
    public void colorSensorPeriodic() {
        // Defining & Declaring Variables
        Constants.detectedColor = colorSensor.getColor();
        String colorString;
        ColorMatchResult match = colorMatcher.matchClosestColor(Constants.detectedColor);
  
        // Color Sensor Output
        if (match.color == kBlueTarget) {
            colorString = "Blue";
        } else if (match.color == kRedTarget) {
            colorString = "Red";
        } else if (match.color == kGreenTarget) {
            colorString = "Green";
        } else if (match.color == kYellowTarget) {
            colorString = "Yellow";
        } else {
            colorString = "Unknown";
        }
  
        SmartDashboard.putNumber("Red", Constants.detectedColor.red);
        SmartDashboard.putNumber("Green", Constants.detectedColor.green);
        SmartDashboard.putNumber("Blue", Constants.detectedColor.blue);
        SmartDashboard.putNumber("Confidence", match.confidence);
        SmartDashboard.putString("Detected Color", colorString);
        //System.out.println(colorString);
  
        // Accelerometer and Distance Sensor Outputs
        Constants.accel = accelerometerPeriodic();
        Constants.distance = distanceSensorValuePeriodic();
        // System.out.println(Constants.distance);
    }

    // "accelerometerPeriodic()" runs periodically, calling the functions of the accelerometer
    public double[] accelerometerPeriodic() {
        // Calculates the current acceleration in the X and Y directions
        double xAccel = accelerometer.getX();
        double yAccel = accelerometer.getY();

        // Calculates the jerk in the X and Y directions
        double xJerk = (xAccel - prevXAccel)/.02;
        double yJerk = (yAccel - prevYAccel)/.02;

        // Updating the previous acceleration in the X and Y directions
        prevXAccel = xAccel;
        prevYAccel = yAccel;  

        // Calculstes the current filtered acceleration in the X and Y directions
        double filteredXAccel = xAccelFilter.calculate(accelerometer.getX());
        double filteredYAccel = yAccelFilter.calculate(accelerometer.getY());

        // Returning acceleration values in the X and Y directions
        double[] arr = {filteredXAccel, filteredYAccel};
        return arr;
    }

    // "distanceSensorValuePeriodic() runs periodically, calling the functions of the distance sensor"
    public double distanceSensorValuePeriodic() {
        double rawValue = ultrasonic.getValue();
        double voltage_scale_factor = 5/RobotController.getVoltage5V();
        double currentDistanceCentimeters = rawValue * voltage_scale_factor * 0.125;
        return currentDistanceCentimeters;
    }
}
