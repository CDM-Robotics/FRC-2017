package org.usfirst.frc.team6072.robot.subsystems;

import org.usfirst.frc.team6072.robot.RobotMap;
import org.usfirst.frc.team6072.robot.SpeedControllerArray;

import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Drivetrain extends Subsystem {
	
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	//public RobotDrive robotDrive;
	//public VictorSP leftMotor1, leftMotor2, leftMotor3, rightMotor1, rightMotor2, rightMotor3;

	
	VictorSP leftMotor1 = new VictorSP(RobotMap.lEFT_MOTOR_1);
	VictorSP leftMotor2 = new VictorSP(RobotMap.lEFT_MOTOR_2);
	VictorSP leftMotor3 = new VictorSP(RobotMap.lEFT_MOTOR_3);
	VictorSP rightMotor1 = new VictorSP(RobotMap.RIGHT_MOTOR_1);
	VictorSP rightMotor2 = new VictorSP(RobotMap.RIGHT_MOTOR_2);
	VictorSP rightMotor3 = new VictorSP(RobotMap.RIGHT_MOTOR_3);
	
	SpeedController[] leftSideMotors = { leftMotor2, leftMotor3 };
	SpeedController[] rightSideMotors = { rightMotor2, rightMotor3 };
	
	SpeedController leftSide = new SpeedControllerArray(leftSideMotors);
	SpeedController rightSide = new SpeedControllerArray(rightSideMotors);
	    
	
	RobotDrive robotDrive = new RobotDrive(leftSide, leftMotor1, rightSide, rightMotor1);
	
	public Drivetrain(){
		super("Drivetrain System");
		
		/*
		leftMotor1 = new VictorSP(RobotMap.leftMotor1);
		leftMotor2 = new VictorSP(RobotMap.leftMotor2);
		leftMotor3 = new VictorSP(RobotMap.leftMotor3);
		rightMotor1 = new VictorSP(RobotMap.rightMotor1);
		rightMotor2 = new VictorSP(RobotMap.rightMotor1);
		rightMotor3 = new VictorSP(RobotMap.rightMotor1);
		
		SpeedController[] leftSideMotors = { leftMotor2, leftMotor3 };
		SpeedController[] rightSideMotors = { rightMotor2, rightMotor3 };
		
		SpeedController leftSide = new SpeedControllerArray(leftSideMotors);
		SpeedController rightSide = new SpeedControllerArray(rightSideMotors);
		    
		leftMotor1.setInverted(true);
		rightMotor1.setInverted(true);
		
		robotDrive = new RobotDrive(leftSide, leftMotor1, rightSide, rightMotor1);
		 */   
	}
	public void stop(){
		robotDrive.stopMotor();
	}
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	
    	
    }
    public RobotDrive getRobotDrive(){
    	return robotDrive;
    }
    
}

