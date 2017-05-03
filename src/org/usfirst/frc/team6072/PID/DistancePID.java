package org.usfirst.frc.team6072.PID;

import org.usfirst.frc.team6072.robot.RobotMap;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class DistancePID extends PIDSubsystem {
	
	
	double Output; // Variable used to store the PID output	
	static double PIDOutput; // Variable used to store the PID output
	static double PIDInput;
	
	Encoder encoder;
	// The constructor passes a name for the PIDSubsystem 
	public DistancePID(Encoder driveEncoder) {  
		
		super("DistancePID", 0.00325, 0.0, 0.005);  //calls the parent constructor with arguments P,I,D
		//working PIDs: 0.24, 0, 0
		
		setAbsoluteTolerance(300);       // more parameters
		getPIDController().setContinuous(false);
		//setInputRange(-10,  10);
	    setOutputRange(-.5, .5); //1/5 speed
	    
	    encoder=driveEncoder;
	    LiveWindow.addActuator("DistancePID", "DistancePID", getPIDController());
	}
	
	public void ResetPID(){  //reset the PID controller
		getPIDController().reset();
	}

	
	protected double returnPIDInput() {
		// TODO Auto-generated method stub
		//return RobotMap.AverageDistance;
		return encoder.get();
	}
	

	protected void usePIDOutput(double output) {
		// TODO Auto-generated method stub
		Output = (output);
				
	}
	
	public double getOutput(){
		return Output;
	}
	
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		
	}
}