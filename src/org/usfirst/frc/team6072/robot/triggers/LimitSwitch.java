package org.usfirst.frc.team6072.robot.triggers;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.buttons.Trigger;

/**
 *
 */
public class LimitSwitch extends Trigger {
	private DigitalInput limit;
	LimitSwitch(int channel){
		super();
		limit = new DigitalInput(channel);
	}
    public boolean get() {
        return limit.get();
    }
}
