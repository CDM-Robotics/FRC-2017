package org.usfirst.frc.team6072.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	// For example to map the left and right motors, you could define the
	// following variables to use with your drivetrain subsystem.
	// public static int leftMotor = 1;
	// public static int rightMotor = 2;

	// If you are using multiple modules, make sure to define both the port
	// number and the module. For example you with a rangefinder:
	// public static int rangefinderPort = 1;
	// public static int rangefinderModule = 1;
	
	//---------MOTOR CONTROLLERS----------
	public static int lEFT_MOTOR_1 = 0;
	public static int lEFT_MOTOR_2 = 1;
	public static int lEFT_MOTOR_3 = 2;
	
	public static int RIGHT_MOTOR_1 = 3;
	public static int RIGHT_MOTOR_2 = 4;
	public static int RIGHT_MOTOR_3 = 5;
	
	//---------ENCODER POSITIONS----------
	public static double GEAR_SLIDER_LOAD_POSITION = 1.0;
	
	//---------DIO CHANNELS---------------
	public static int GEAR_LIMIT_ZERO_CHANNEL = 0;
}
