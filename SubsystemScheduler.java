package frc.robot;

import java.util.LinkedHashMap;
import java.util.Map;

public class SubsystemScheduler {

    public SubsystemScheduler() {
        Runnable periodic = () -> this.periodic();

        Scheduler.AddSubsystemPeriodic(periodic);

        // SendableRegistry.addLW(this, name, name);
        // CommandScheduler.getInstance().registerSubsystem(this);
        // SubsystemRegistry.
    }


    public void getName() {
        String name = this.getClass().getSimpleName();
        name = name.substring(name.lastIndexOf('.') + 1);
    }

    // overide this function in order for the subsystems to call their periodic function
    public void periodic() {}

    
    // private final Subsystem m_subsystems = new LinkedHashMap<>();

}
