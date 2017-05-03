package org.usfirst.frc.team6072.robot.commands;

import org.usfirst.frc.team6072.robot.Robot;
import org.usfirst.frc.team6072.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class UpdateDashboard extends Command {

    public UpdateDashboard() {
//    	requires(Robot.gearslider);
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.drivetrain.getLeftEncoder().reset();
    	Robot.drivetrain.getRightEncoder().reset();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	SmartDashboard.putNumber("NavX Yaw", RobotMap.ahrs.getYaw());
    	SmartDashboard.putBoolean("NavX Connection", RobotMap.ahrs.isConnected());
    	SmartDashboard.putNumber("position", Robot.gearSlider.getPosition());
    	SmartDashboard.putNumber("Speed", Robot.gearSlider.getSpeed());
    	SmartDashboard.putBoolean("Limit Switch status", Robot.oi.getGearLimitZero().get());
    	SmartDashboard.putNumber("left Encoder", Robot.drivetrain.getLeftEncoder().get());
    	SmartDashboard.putNumber("right Encoder", Robot.drivetrain.getRightEncoder().get());
    	SmartDashboard.putNumber("viewable", RobotMap.visionTable.getNumber("viewable", 3));
    	SmartDashboard.putNumber("horiz angle", RobotMap.visionTable.getNumber("horizontal_angle", 3));
    	SmartDashboard.putNumber("distance", RobotMap.visionTable.getNumber("distance", 3));
    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
