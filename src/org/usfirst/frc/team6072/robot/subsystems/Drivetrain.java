package org.usfirst.frc.team6072.robot.subsystems;

import org.usfirst.frc.team6072.robot.RobotMap;
import org.usfirst.frc.team6072.robot.SpeedControllerArray;
import org.usfirst.frc.team6072.robot.commands.ArcadeDrive;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.RobotDrive.MotorType;
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
	
	DoubleSolenoid shifter = new DoubleSolenoid(RobotMap.SHIFTER_SOLENOID_OFF, RobotMap.SHIFTER_SOLENOID_ON);
	
	
	public Drivetrain(){
		super("Drivetrain System");
		robotDrive.setInvertedMotor(MotorType.kRearLeft, true);
		robotDrive.setInvertedMotor(MotorType.kRearRight, true);
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
    	setDefaultCommand(new ArcadeDrive());
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	
    	
    }
    public void solenoidsOn(){
    	shifter.set(DoubleSolenoid.Value.kForward);
    	shifter.set(DoubleSolenoid.Value.kForward);
    }
    public void solenoidsOff(){
    	shifter.set(DoubleSolenoid.Value.kReverse);
    	shifter.set(DoubleSolenoid.Value.kReverse);
    	
    }
    public int getGearShift(){
    	if(shifter.get()==DoubleSolenoid.Value.kReverse){
    		return 0; //Low gear (fast)
    	} else if (shifter.get()==DoubleSolenoid.Value.kForward){
    		return 1; //High gear (slow)
    	} else {
    		return 2; //Something is screwed up
    	}
    }
    public RobotDrive getRobotDrive(){
    	return robotDrive;
    }
    
}

