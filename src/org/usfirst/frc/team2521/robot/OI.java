
package org.usfirst.frc.team2521.robot;

import edu.wpi.first.wpilibj.Joystick;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	
	private Joystick left;
	private Joystick right;
	private Joystick secondary;
	
	private static OI instance;
	
	public OI() {
		left = new Joystick(RobotMap.LEFT_STICK_PORT);
		right = new Joystick(RobotMap.RIGHT_STICK_PORT);
		secondary = new Joystick(RobotMap.SECONDARY_STICK_PORT);
	}
	
	public static OI getInstance() {
		if (instance == null) {
			instance = new OI();
		}
		
		return instance;
	}
	
	public Joystick getLeftStick() {
		return left;
	}
	
	public Joystick getRightStick() {
		return right;
	}
	
	public Joystick getSecondaryStick() {
		return secondary;
	}
	
	public void initButtons() {
	}
	
	public void tieButtons() {
	}
}
