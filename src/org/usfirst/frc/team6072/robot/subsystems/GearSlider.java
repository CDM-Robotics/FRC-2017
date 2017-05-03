package org.usfirst.frc.team6072.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

import org.usfirst.frc.team6072.robot.Robot;
import org.usfirst.frc.team6072.robot.RobotMap;
import org.usfirst.frc.team6072.robot.commands.ManualGearSlide;

import com.ctre.CANTalon;
import com.ctre.CANTalon.FeedbackDevice;
import com.ctre.CANTalon.TalonControlMode;
/**
 *
 */
public class GearSlider extends Subsystem {
	CANTalon talon;
    DoubleSolenoid actuator = new DoubleSolenoid(1,RobotMap.GEAR_SOLENOID_OFF,RobotMap.GEAR_SOLENOID_ON);
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	public GearSlider(){
		super();
		talon = new CANTalon(5);
		
		/* grab the 360 degree position of the MagEncoder's absolute position */
		int absolutePosition = talon.getPulseWidthPosition() & 0xFFF; /* mask out the bottom12 bits, we don't care about the wrap arounds */
        /* use the low level API to set the quad encoder signal */
        talon.setEncPosition(absolutePosition);
        /* choose the sensor and sensor direction */
        talon.setFeedbackDevice(FeedbackDevice.CtreMagEncoder_Relative);
        talon.reverseSensor(false);
       
        /* set the peak and nominal outputs, 12V means full */
        talon.configNominalOutputVoltage(+0f, -0f);
        talon.configPeakOutputVoltage(8f, -8f);
        /* set the allowable closed-loop error,
         * Closed-Loop output will be neutral within this range.
         * See Table in Section 17.2.1 for native units per rotation. 
         */
        talon.setAllowableClosedLoopErr(0); /* always servo */
        /* set closed loop gains in slot0 */
        
        //GLORIOUS PERFECT PID FOR 7:1 GEARING
        talon.setProfile(0);
        talon.setF(0.0);
        talon.setP(0.75);
        talon.setI(0.0); 
        talon.setD(5.5);       
        talon.changeControlMode(TalonControlMode.Position);
       
	}
	public void reset(){
        talon.changeControlMode(TalonControlMode.Position);
		talon.setPosition(Robot.oi.getStick().getThrottle());
	}
	public void moveToPosition(double pos){
        talon.changeControlMode(TalonControlMode.Position);
		talon.set(pos);
	}
	public int getPosition(){
		return talon.getEncPosition();
	} 
	public int getSpeed(){
		return talon.getEncVelocity();
	}
	public void setSpeed(double speed){
		talon.changeControlMode(TalonControlMode.Speed);
		talon.set(speed);
	}
	public void stop(){
//		talon.disable();
		talon.changeControlMode(TalonControlMode.Speed);
		talon.set(0);
//		talon.changeControlMode(TalonControlMode.Position);
//		talon.set(getPosition());
 //       talon.enable();
	}
	public void setPosition(int pos){
		talon.setPosition(pos);
	}
	public void solenoidsOn(){
		actuator.set(DoubleSolenoid.Value.kForward);
		
	}
	public void solenoidsOff(){
		actuator.set(DoubleSolenoid.Value.kReverse);
		
	}
    public int getActuationStatus(){
    	if(actuator.get()==DoubleSolenoid.Value.kReverse){
    		return 0; //Down
    	} else if (actuator.get()==DoubleSolenoid.Value.kForward){
    		return 1; //Up
    	} else {
    		return 2; //Something is screwed up
    	}
    }
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new ManualGearSlide());
    }
}