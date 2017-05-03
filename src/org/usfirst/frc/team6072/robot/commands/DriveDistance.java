package org.usfirst.frc.team6072.robot.commands;

import org.usfirst.frc.team6072.PID.DistancePID;
import org.usfirst.frc.team6072.PID.HeadingPID;
import org.usfirst.frc.team6072.robot.Robot;
import org.usfirst.frc.team6072.robot.RobotMap;

import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveDistance extends Command {

	private final HeadingPID headingPID = RobotMap.headingPID;
	private final AHRS ahrs = RobotMap.ahrs;

	private final DistancePID distancePIDLeft = RobotMap.distancePIDLeft;
	private final DistancePID distancePIDRight = RobotMap.distancePIDRight;
	private final Encoder leftEncoder = Robot.drivetrain.getLeftEncoder();
	private final Encoder rightEncoder = Robot.drivetrain.getRightEncoder();
	private double tickDistance;
    public DriveDistance(double distance) {
    	tickDistance = distance*RobotMap.ENCODER_TICKS_PER_INCH;
        tickDistance = 2368.5;
    	// Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.drivetrain);
    }

    // Called just before this Command runs the first time
    protected void initialize() {

    	headingPID.ResetPID();
    	headingPID.setAbsoluteTolerance(1.5); 
    	//how many degrees off the headingPID can be - prevents oscillation from the 
    	//robot continuously overshooting and then trying to correct itself
    	headingPID.enable();
    	ahrs.reset();  //reset the navX

    	distancePIDLeft.ResetPID();
    	distancePIDRight.ResetPID();
    	distancePIDLeft.setAbsoluteTolerance(100); 
    	distancePIDRight.setAbsoluteTolerance(100); 
    	//how many degrees off the headingPID can be - prevents oscillation from the 
    	//robot continuously overshooting and then trying to correct itself
    	distancePIDLeft.enable();
    	distancePIDRight.enable();
    	leftEncoder.reset();
    	rightEncoder.reset();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {

    	headingPID.setSetpoint(0); //the number of degrees you want the headingPID to move
    	distancePIDLeft.setSetpoint(tickDistance);
    	distancePIDRight.setSetpoint(tickDistance);
    	
    	double turnComponent = headingPID.getOutput();
    	Robot.drivetrain.tankDrive((-distancePIDLeft.getOutput())+turnComponent, distancePIDRight.getOutput()-turnComponent);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return distancePIDLeft.onTarget()&&distancePIDRight.onTarget();
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
