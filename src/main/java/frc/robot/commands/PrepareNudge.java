// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import static frc.robot.Constants.LauncherConstants.*;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.CANLauncher;

public class PrepareNudge extends Command {
  CANLauncher m_launcher;

  double m_NudgePrepareLauncherSpeed = kNudgePrepareLauncherSpeed;

  /** Creates a new PrepareLaunch. */
  public PrepareNudge(CANLauncher launcher) {
    // save the launcher system internally
    m_launcher = launcher;

    SmartDashboard.putNumber("Nudge Prepare Launcher Speed", m_NudgePrepareLauncherSpeed);

    // indicate that this command requires the launcher system
    addRequirements(m_launcher);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    // Set launch wheel to speed, keep feed wheel at 0 to let launch wheel spin up.
    m_NudgePrepareLauncherSpeed =
        SmartDashboard.getNumber("Nudge Prepare Launcher Speed", m_NudgePrepareLauncherSpeed);

    m_launcher.setLaunchWheel(m_NudgePrepareLauncherSpeed);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    // There is nothing we need this command to do on each iteration. You could remove this method
    // and the default blank method
    // of the base class will run.
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    // Do nothing when the command ends. The launch wheel needs to keep spinning in order to launch
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    // Always return false so the command never ends on it's own. In this project we use a timeout
    // decorator on the command to end it.
    return false;
  }
}
