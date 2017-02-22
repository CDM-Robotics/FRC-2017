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
	
	//---------CONTROLLER BUTTONS---------
	//All buttons are shifted over 1. Ex, a value of 4 triggers button #5
		//Joystick
	public static int SHIFT_DRIVE_HIGH_BUTTON=5;
	public static int SHIFT_DRIVE_LOW_BUTTON=3;
		//Gamepad
	public static int TOGGLE_MANUAL_GEAR_SLIDE_BUTTON=2;
	public static int ACTUATE_GEAR_SLIDER_BUTTON=0;
	public static int CLIMBER_UP_BUTTON=1;
	public static int CLIMBER_DOWN_BUTTON=3;
	//---------MOTOR CONTROLLERS----------
	public static int lEFT_MOTOR_1 = 0;
	public static int lEFT_MOTOR_2 = 1;
	public static int lEFT_MOTOR_3 = 2;
	
	public static int RIGHT_MOTOR_1 = 3;
	public static int RIGHT_MOTOR_2 = 4;
	public static int RIGHT_MOTOR_3 = 5;
	
	public static int GEARSLIDER_CAN = 5;
	
	public static int CLIMBER = 6;
	
	//---------PNEUMAMTICS PORTS----------
	public static int GEAR_SOLENOID_ON = 0;
	public static int GEAR_SOLENOID_OFF = 1;
	public static int SHIFTER_SOLENOID_ON = 2;
	public static int SHIFTER_SOLENOID_OFF = 3;
	
	//---------ENCODER POSITIONS----------
	public static double GEAR_SLIDER_LOAD_POSITION = 1.0;
	
	//---------DIO CHANNELS---------------
	public static int GEAR_LIMIT_ZERO_CHANNEL = 0;
	public static int GEAR_LIMIT_MAX_CHANNEL = 0;
	
	//---------Speeds----------------
	public static int MANUAL_GEAR_SLIDE_SPEED = 1024;
}
