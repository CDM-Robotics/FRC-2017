package org.usfirst.frc.team6072.robot.subsystems;

import org.usfirst.frc.team6072.robot.RobotMap;
import org.usfirst.frc.team6072.robot.commands.SpinClimber;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Climber extends Subsystem {
	Spark climbMotor= new Spark(RobotMap.CLIMBER);
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
    	//setDefaultCommand(new SpinClimber());
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    public void set(double direction){ 
    	climbMotor.setSpeed(direction);
    }
    public void off(){
    	climbMotor.set(0);
    }
}

