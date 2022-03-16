package frc.robot.Subsystems;

import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.math.filter.LinearFilter;
import edu.wpi.first.wpilibj.RobotController;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class SensorSubsystem extends SubsystemBase {

    // Filitering Input Accelration
    LinearFilter xAccelFilter = LinearFilter.movingAverage(10);
    LinearFilter yAccelFilter = LinearFilter.movingAverage(10);
    double prevXAccel = 0;
    double prevYAccel = 0;
    
    // Camera
    Thread m_visionThread;

    /** Creates a new SensorSubsystem. */
    public SensorSubsystem() {}

    @Override
    public void periodic() {
        // This method will be called once per scheduler run
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
        double xAccel = Constants.accelerometer.getX();
        double yAccel = Constants.accelerometer.getY();

        // Calculates the jerk in the X and Y directions
        // Divides by .02 because default loop timing is 20ms
        double xJerk = (xAccel - prevXAccel)/.02;
        double yJerk = (yAccel - prevYAccel)/.02;

        prevXAccel = xAccel;
        prevYAccel = yAccel;  

        double filteredXAccel = xAccelFilter.calculate(Constants.accelerometer.getX());
        double filteredYAccel = yAccelFilter.calculate(Constants.accelerometer.getY());

        double[] arr = {filteredXAccel, filteredYAccel};
        return arr;
    }

    public double distanceSensorValuePeriodic() {
        double rawValue = Constants.ultrasonic.getValue();
        double voltage_scale_factor = 5/RobotController.getVoltage5V();
        double currentDistanceCentimeters = rawValue * voltage_scale_factor * 0.125;
        return currentDistanceCentimeters;
    }
}
