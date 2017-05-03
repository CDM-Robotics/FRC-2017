package org.usfirst.frc.team6072.PID;

//import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

import org.usfirst.frc.team6072.robot.RobotMap;



// HeadingPID class uses the navX "yaw" value to control the robot heading
public class HeadingPID  extends PIDSubsystem {
	
	double Output; // Variable used to store the PID output
	double yawOutput;
	
	// The constructor passes a name for the PIDSubsystem 
	public HeadingPID() {  
		//super("HeadingPID", .01, .0002, .1);  //calls the parent constructor with arguments P,I,D
		super("HeadingPID", .02, .00055, .065);  //calls the parent constructor with arguments P,I,D
		//keep P term at 0.06!!!!
		
		setAbsoluteTolerance(1.25);          // more parameters
		getPIDController().setContinuous(false);
		setInputRange(-180.0,  180.0);
	    setOutputRange(-.75, .75);
	    
	    LiveWindow.addActuator("HeadingPID", "HeadingPID", getPIDController());
	}
	
	public void ResetPID(){  //reset the PID controller
		getPIDController().reset();
		
	}
	protected void initDefaultCommand() {	
	}

	 protected double returnPIDInput() {
		 yawOutput = (double)RobotMap.ahrs.getYaw(); // returns the robot "Yaw" value that is providing the feedback 
	    	//for the system. (double) converts a float to double
		 yawOutput *= -1;
	    	return yawOutput;
	    	
    }

    protected void usePIDOutput(double output) {
    	
    	Output = (output); // this is the computed output value from the PIDController.
    }
	    
   public double getOutput(){  // called from the DriveBasePID 
		return Output;
   }    	
}