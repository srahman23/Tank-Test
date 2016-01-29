
package org.usfirst.frc.team2521.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	
	// Autonomous
	public static final int AUTONOMOUS_DISTANCE = 150;
	
	// Ports
	public static final int LEFT_STICK_PORT = 0;
	public static final int RIGHT_STICK_PORT = 1;
	
	public static final int FRONT_LEFT_MOTOR = 50;
	public static final int FRONT_RIGHT_MOTOR = 51;
	public static final int REAR_LEFT_MOTOR = 52;
	public static final int REAR_RIGHT_MOTOR = 53;
}
