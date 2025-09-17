package org.firstinspires.ftc.teamcode;

import static com.qualcomm.hardware.rev.RevHubOrientationOnRobot.xyzOrientation;

import com.qualcomm.hardware.rev.RevHubOrientationOnRobot;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.IMU;
import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.Orientation;
import org.firstinspires.ftc.robotcore.external.navigation.YawPitchRollAngles;

public class Auton{

    private double tpi = 537.7 / (Math.PI * 4);
    private DcMotor frontLeft, frontRight, backLeft, backRight;

    Telemetry telemetry;
    HardwareMap hardwareMap;
    LinearOpMode opmode;
    IMU imu;

    @Override
    public void init(LinearOpMode opMode){

        telemetry = opMode.telemetry;
        hardwareMap = opMode.hardwareMap;
        opmode = opMode;

        frontLeft = hardwareMap.get(DcMotor.class,"Frontleft");
        frontRight = hardwareMap.get(DcMotor.class,"Frontright");
        backLeft = hardwareMap.get(DcMotor.class,"Backleft");
        backRight = hardwareMap.get(DcMotor.class,"Backright");
        imu = hardwareMap.get(IMU.class, "imu");

        frontRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        frontLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        backRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        backLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        frontLeft.setDirection(DcMotorSimple.Direction.REVERSE);
        backLeft.setDirection(DcMotorSimple.Direction.REVERSE);

        double xRotation = 0;
        double yRotation = 0;
        double zRotation = 0;

        Orientation hubRotation = xyzOrientation(xRotation, yRotation, zRotation);
        RevHubOrientationOnRobot orientationOnRobot = new RevHubOrientationOnRobot(hubRotation);
        imu.initialize(new IMU.Parameters(orientationOnRobot));
    }

    public void forward(double distance, double speed){
        int position_fr = frontRight.getCurrentPosition() - (int) (distance * tpi);
        int position_bl = backLeft.getCurrentPosition() - (int) (distance * tpi);
        int position_br = backRight.getCurrentPosition() - (int) (distance * tpi);
        int position_fl = frontLeft.getCurrentPosition() - (int) (distance * tpi);

        frontRight.setTargetPosition(position_fr);
        backRight.setTargetPosition(position_br);
        backLeft.setTargetPosition(position_fl);
        frontLeft.setTargetPosition(position_bl);

        backLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        backRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        frontLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        frontRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        frontRight.setPower((Math.abs(speed)));
        frontLeft.setPower((Math.abs(speed)));
        backLeft.setPower((Math.abs(speed)));
        backRight.setPower((Math.abs(speed)));

        while (opmode.opModeIsActive() &&
                (backLeft.isBusy() && backRight.isBusy() && frontRight.isBusy() && frontLeft.isBusy())) {
            telemetry.addData("backLeft:", backLeft.getCurrentPosition());
            telemetry.addData("backRight", backRight.getCurrentPosition());
            telemetry.addData("frontLeft:", frontLeft.getCurrentPosition());
            telemetry.addData("frontRight", frontRight.getCurrentPosition());
            telemetry.update();
        }

        frontRight.setPower(0);
        frontLeft.setPower(0);
        backLeft.setPower(0);
        backRight.setPower(0);
    }

    public void backward(double distance, double speed){
        int position_fr = frontRight.getCurrentPosition() - (int) (distance * tpi);
        int position_bl = backLeft.getCurrentPosition() - (int) (distance * tpi);
        int position_br = backRight.getCurrentPosition() - (int) (distance * tpi);
        int position_fl = frontLeft.getCurrentPosition() - (int) (distance * tpi);

        frontRight.setTargetPosition(position_fr);
        backRight.setTargetPosition(position_br);
        backLeft.setTargetPosition(position_fl);
        frontLeft.setTargetPosition(position_bl);

        backLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        backRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        frontLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        frontRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        frontRight.setPower(-(Math.abs(speed)));
        frontLeft.setPower(-(Math.abs(speed)));
        backLeft.setPower(-(Math.abs(speed)));
        backRight.setPower(-(Math.abs(speed)));

        while (opmode.opModeIsActive() &&
                (backLeft.isBusy() && backRight.isBusy() && frontRight.isBusy() && frontLeft.isBusy())) {
            telemetry.addData("backLeft:", backLeft.getCurrentPosition());
            telemetry.addData("backRight", backRight.getCurrentPosition());
            telemetry.addData("frontLeft:", frontLeft.getCurrentPosition());
            telemetry.addData("frontRight", frontRight.getCurrentPosition());
            telemetry.update();
        }

        frontRight.setPower(0);
        frontLeft.setPower(0);
        backLeft.setPower(0);
        backRight.setPower(0);
    }

    public void left(double distance, double speed){
        int position_fr = frontRight.getCurrentPosition() - (int) (distance * tpi);
        int position_bl = backLeft.getCurrentPosition() - (int) (distance * tpi);
        int position_br = backRight.getCurrentPosition() - (int) (distance * tpi);
        int position_fl = frontLeft.getCurrentPosition() - (int) (distance * tpi);

        frontRight.setTargetPosition(position_fr);
        backRight.setTargetPosition(position_br);
        backLeft.setTargetPosition(position_fl);
        frontLeft.setTargetPosition(position_bl);

        backLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        backRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        frontLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        frontRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        frontRight.setPower((Math.abs(speed)));
        frontLeft.setPower(-(Math.abs(speed)));
        backLeft.setPower((Math.abs(speed)));
        backRight.setPower(-(Math.abs(speed)));

        while (opmode.opModeIsActive() &&
                (backLeft.isBusy() && backRight.isBusy() && frontRight.isBusy() && frontLeft.isBusy())) {
            telemetry.addData("backLeft:", backLeft.getCurrentPosition());
            telemetry.addData("backRight", backRight.getCurrentPosition());
            telemetry.addData("frontLeft:", frontLeft.getCurrentPosition());
            telemetry.addData("frontRight", frontRight.getCurrentPosition());
            telemetry.update();
        }

        frontRight.setPower(0);
        frontLeft.setPower(0);
        backLeft.setPower(0);
        backRight.setPower(0);
    }
    public void right(double distance, double speed){
        int position_fr = frontRight.getCurrentPosition() - (int) (distance * tpi);
        int position_bl = backLeft.getCurrentPosition() - (int) (distance * tpi);
        int position_br = backRight.getCurrentPosition() - (int) (distance * tpi);
        int position_fl = frontLeft.getCurrentPosition() - (int) (distance * tpi);

        frontRight.setTargetPosition(position_fr);
        backRight.setTargetPosition(position_br);
        backLeft.setTargetPosition(position_fl);
        frontLeft.setTargetPosition(position_bl);

        backLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        backRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        frontLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        frontRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        frontRight.setPower(-(Math.abs(speed)));
        frontLeft.setPower((Math.abs(speed)));
        backLeft.setPower(-(Math.abs(speed)));
        backRight.setPower((Math.abs(speed)));

        while (opmode.opModeIsActive() &&
                (backLeft.isBusy() && backRight.isBusy() && frontRight.isBusy() && frontLeft.isBusy())) {
            telemetry.addData("backLeft:", backLeft.getCurrentPosition());
            telemetry.addData("backRight", backRight.getCurrentPosition());
            telemetry.addData("frontLeft:", frontLeft.getCurrentPosition());
            telemetry.addData("frontRight", frontRight.getCurrentPosition());
            telemetry.update();
        }

        frontRight.setPower(0);
        frontLeft.setPower(0);
        backLeft.setPower(0);
        backRight.setPower(0);
    }

    public void turnRight(double degrees, double speed){

        imu.resetYaw();

        YawPitchRollAngles orientation = imu.getRobotYawPitchRollAngles();

        backRight.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        backLeft.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        frontRight.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        frontLeft.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        while (orientation.getYaw(AngleUnit.DEGREES) > -degrees) {

            telemetry.addData("angle",orientation.getYaw(AngleUnit.DEGREES));
            orientation = imu.getRobotYawPitchRollAngles();

            backLeft.setPower((Math.abs(speed)));
            backRight.setPower(-(Math.abs(speed)));
            frontLeft.setPower((Math.abs(speed)));
            frontRight.setPower(-(Math.abs(speed)));

            telemetry.addData("backLeft:", backLeft.getCurrentPosition());
            telemetry.addData("backRight", backRight.getCurrentPosition());
            telemetry.addData("frontLeft:", frontLeft.getCurrentPosition());
            telemetry.addData("frontRight", frontRight.getCurrentPosition());
            telemetry.update();

        }

        frontRight.setPower(0);
        frontLeft.setPower(0);
        backLeft.setPower(0);
        backRight.setPower(0);
    }
    public void turnLeft(double degrees, double speed){

        imu.resetYaw();

        YawPitchRollAngles orientation = imu.getRobotYawPitchRollAngles();

        backRight.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        backLeft.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        frontRight.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        frontLeft.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        while (orientation.getYaw(AngleUnit.DEGREES) > degrees) {

            telemetry.addData("angle",orientation.getYaw(AngleUnit.DEGREES));
            orientation = imu.getRobotYawPitchRollAngles();

            backLeft.setPower(-(Math.abs(speed)));
            backRight.setPower((Math.abs(speed)));
            frontLeft.setPower(-(Math.abs(speed)));
            frontRight.setPower((Math.abs(speed)));

            telemetry.addData("backLeft:", backLeft.getCurrentPosition());
            telemetry.addData("backRight", backRight.getCurrentPosition());
            telemetry.addData("frontLeft:", frontLeft.getCurrentPosition());
            telemetry.addData("frontRight", frontRight.getCurrentPosition());
            telemetry.update();

        }

        frontRight.setPower(0);
        frontLeft.setPower(0);
        backLeft.setPower(0);
        backRight.setPower(0);
    }
}
