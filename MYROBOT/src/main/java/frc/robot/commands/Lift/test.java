/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.Lift;
import frc.robot.Robot;
import frc.robot.RobotMap;
import edu.wpi.first.wpilibj.command.Command;

public class Test extends Command {
  public Test() {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    requires(Robot.m_Lift);

  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
        liftOn();
  }

  protected void liftOn() {
    Robot.m_Lift.lift.set(RobotMap.liftSpeed*Robot.m_oi.Controller.getRawAxis(RobotMap.Joystick_RY));
    if(Robot.m_oi.Controller.getRawButton(RobotMap.RB_Button)){
      Robot.m_Lift.climbForward.set(RobotMap.climbSpeed);
    }
    else if(Robot.m_oi.Controller.getRawButton(RobotMap.LB_Button)){
      Robot.m_Lift.climbForward.set(-RobotMap.climbSpeed);
    }
    else{
      Robot.m_Lift.climbForward.set(0.0);
    }
  }
  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
  }
}
