
package org.usfirst.frc.team2521.robot.subsystems;

import org.usfirst.frc.team2521.robot.OI;
import org.usfirst.frc.team2521.robot.RobotMap;
import org.usfirst.frc.team2521.robot.commands.TeleoperatedDrive;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.RobotDrive.MotorType;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Drivetrain extends Subsystem {
	
	private RobotDrive drive;
	
	CANTalon frontLeft, frontRight, rearLeft, rearRight;
	
	public Drivetrain() {
		frontLeft = new CANTalon(RobotMap.FRONT_LEFT_MOTOR);
		frontLeft.changeControlMode(CANTalon.TalonControlMode.Follower);
		frontLeft.enableControl();
		
		rearLeft = new CANTalon(RobotMap.REAR_LEFT_MOTOR);
		rearLeft.enableControl();
		
		frontRight = new CANTalon(RobotMap.FRONT_RIGHT_MOTOR);
		frontRight.changeControlMode(CANTalon.TalonControlMode.Follower);
		frontRight.enableControl();
		
		rearRight = new CANTalon(RobotMap.REAR_RIGHT_MOTOR);
		rearRight.enableControl();
		
		drive = new RobotDrive(rearLeft, rearRight);
		drive.setInvertedMotor(MotorType.kRearLeft, true);
		drive.setInvertedMotor(MotorType.kRearRight, true);
	}
	
	public void tankDrive() {
		double left = OI.getInstance().getLeftStick().getY();
		double right = OI.getInstance().getRightStick().getY();
		drive.tankDrive(left, right);
		
		frontRight.set(RobotMap.REAR_RIGHT_MOTOR);
		frontLeft.set(RobotMap.REAR_LEFT_MOTOR);
	}
	
	public void arcadeDrive() {
		drive.arcadeDrive(OI.getInstance().getLeftStick());
		
		frontRight.set(RobotMap.REAR_RIGHT_MOTOR);
		frontLeft.set(RobotMap.REAR_LEFT_MOTOR);
	}
	
	public void teleoperatedDrive() {
		//tankDrive();
		arcadeDrive();
	}
	
	public void initDefaultCommand() {
		setDefaultCommand(new TeleoperatedDrive());
	}
	
	public void setEncPosition(int encoderPosition) {
		frontLeft.setEncPosition(encoderPosition);
		rearLeft.setEncPosition(encoderPosition);
		frontRight.setEncPosition(encoderPosition);
		rearRight.setEncPosition(encoderPosition);
	}
}
