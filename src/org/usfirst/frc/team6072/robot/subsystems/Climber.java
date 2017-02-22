package org.usfirst.frc.team6072.robot.subsystems;

import org.usfirst.frc.team6072.robot.RobotMap;

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
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    public void set(int direction){ 
    	if (direction==1){
        	climbMotor.set(1);
    	} else {
    		climbMotor.set(-1);
    	}
    }
    public void off(){
    	climbMotor.set(0);
    }
}

