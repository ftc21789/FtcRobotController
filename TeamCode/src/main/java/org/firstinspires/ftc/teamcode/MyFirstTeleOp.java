package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp
public class MyFirstTeleOp extends OpMode {
    private DcMotor frontLeft, frontRight, backLeft, backRight;
    private DcMotor arm, wrist;

    private Servo claw;

    private final double clawOpen = 1;

    private final double clawClosed = 0;

    @Override
    public void init() {
        frontLeft = hardwareMap.get(DcMotor.class,"frontLeft");
        frontRight = hardwareMap.get(DcMotor.class,"frontRight");
        backLeft = hardwareMap.get(DcMotor.class,"backLeft");
        backRight = hardwareMap.get(DcMotor.class,"backRight");

        frontLeft.setDirection(DcMotorSimple.Direction.REVERSE);
        backLeft.setDirection(DcMotorSimple.Direction.REVERSE);

        arm = hardwareMap.get(DcMotor.class, "armMotor");
        wrist = hardwareMap.get(DcMotor.class, "wristMotor");

        claw = hardwareMap.get(Servo.class, "claw");
    }

    @Override
    public void loop() {

        //Drivetrain code
        double y_command = -gamepad1.left_stick_y;
        double x_command = gamepad1.left_stick_x;
        double z_command = gamepad1.right_stick_x;

        double frontLeftCommand = y_command - x_command + z_command;
        double frontRightCommand = y_command + x_command - z_command;
        double backLeftCommand = y_command + x_command + z_command;
        double backRightCommand = y_command - x_command - z_command;

        double max = Math.max(1,frontLeftCommand);
        max = Math.max(max,frontRightCommand);
        max = Math.max(max,backLeftCommand);
        max = Math.max(max,backRightCommand);

        frontLeftCommand = frontLeftCommand/max;
        frontRightCommand = frontRightCommand/max;
        backLeftCommand = backLeftCommand/max;
        backRightCommand = backRightCommand/max;

        frontLeft.setPower(frontLeftCommand);
        frontRight.setPower(frontRightCommand);
        backLeft.setPower(backLeftCommand);
        backRight.setPower(backRightCommand);


        //Arm code
        double armCommand = -gamepad2.left_stick_y;
        double wristCommand =-gamepad2.right_stick_y;

        arm.setPower(armCommand);
        wrist.setPower(wristCommand);

        if (gamepad2.a) {
            claw.setPosition(clawOpen);
        }

        if (gamepad2.b) {
            claw.setPosition(clawClosed);
        }

        //Telemetry code
        telemetry.addData("frontLeft", frontLeft.getCurrentPosition());
        telemetry.addData("frontRight", frontRight.getCurrentPosition());
        telemetry.addData("backLeft", backLeft.getCurrentPosition());
        telemetry.addData("backRight", backRight.getCurrentPosition());
        telemetry.addData("arm", arm.getCurrentPosition());
        telemetry.addData("wrist", wrist.getCurrentPosition());
        telemetry.update();

        //Nova git test

    }
}
