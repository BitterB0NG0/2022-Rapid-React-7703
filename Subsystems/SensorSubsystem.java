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
    private static ColorSensorV3 m_colorSensor = new ColorSensorV3(Constants.i2cPort);
    private final ColorMatch m_colorMatcher = new ColorMatch();

    // Filitering Input Accelration
    LinearFilter xAccelFilter = LinearFilter.movingAverage(10);
    LinearFilter yAccelFilter = LinearFilter.movingAverage(10);
    double prevXAccel = 0;
    double prevYAccel = 0;
    
    // Camera
    Thread m_visionThread;

    private final Color kBlueTarget = new Color(0.143, 0.427, 0.429);
    private final Color kGreenTarget = new Color(0.197, 0.561, 0.240);
    private final Color kRedTarget = new Color(0.561, 0.232, 0.114);
    private final Color kYellowTarget = new Color(0.361, 0.524, 0.113);

    /** Creates a new SensorSubsystem. */
    public SensorSubsystem() {
        m_colorMatcher.addColorMatch(kBlueTarget);
        m_colorMatcher.addColorMatch(kGreenTarget);
        m_colorMatcher.addColorMatch(kRedTarget);
        m_colorMatcher.addColorMatch(kYellowTarget);   
    }

    @Override
    public void periodic() {
        Constants.detectedColor = m_colorSensor.getColor();

        String colorString;
        ColorMatchResult match = m_colorMatcher.matchClosestColor(Constants.detectedColor);

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

        // System.out.println(colorString);

        SmartDashboard.putNumber("Red", Constants.detectedColor.red);
        SmartDashboard.putNumber("Green", Constants.detectedColor.green);
        SmartDashboard.putNumber("Blue", Constants.detectedColor.blue);
        SmartDashboard.putNumber("Confidence", match.confidence);
        SmartDashboard.putString("Detected Color", colorString);
        // This method will be called once per scheduler run
        Constants.accel = accelerometerPeriodic();
        Constants.distance = distanceSensorValuePeriodic();

        // System.out.println(Constants.distance);


    }

    @Override
    public void simulationPeriodic() {
        // This method will be called once per scheduler run during simulation
    }

    public void cameraInit() {
        CameraServer.startAutomaticCapture();
    }

    public double[] accelerometerPeriodic() {
        // Gets the current accelerations in the X and Y directions
        double xAccel = accelerometer.getX();
        double yAccel = accelerometer.getY();

        // Calculates the jerk in the X and Y directions
        // Divides by .02 because default loop timing is 20ms
        double xJerk = (xAccel - prevXAccel)/.02;
        double yJerk = (yAccel - prevYAccel)/.02;

        prevXAccel = xAccel;
        prevYAccel = yAccel;  

        double filteredXAccel = xAccelFilter.calculate(accelerometer.getX());
        double filteredYAccel = yAccelFilter.calculate(accelerometer.getY());

        double[] arr = {filteredXAccel, filteredYAccel};
        return arr;
    }

    public double distanceSensorValuePeriodic() {
        double rawValue = ultrasonic.getValue();
        double voltage_scale_factor = 5/RobotController.getVoltage5V();
        double currentDistanceCentimeters = rawValue * voltage_scale_factor * 0.125;
        return currentDistanceCentimeters;
    }
}
