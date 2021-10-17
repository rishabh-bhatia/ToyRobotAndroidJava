package com.example.toyrobotchallenge;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    static RobotModel robot;
    Button place, left, right, move, report;
    TextView reportTv;
    EditText xCoordinateEt, yCoordinateEt, directionEt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        place = findViewById(R.id.place);
        left = findViewById(R.id.left);
        right = findViewById(R.id.right);
        move = findViewById(R.id.move);
        report = findViewById(R.id.report);

        reportTv = findViewById(R.id.reportTv);

        xCoordinateEt = findViewById(R.id.xcoordinateEt);
        yCoordinateEt = findViewById(R.id.ycoordinateEt);
        directionEt = findViewById(R.id.directionEt);


        place.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int xCoordinate = Integer.parseInt(xCoordinateEt.getText().toString());
                int yCoordinate = Integer.parseInt(yCoordinateEt.getText().toString());
                int dir = Integer.parseInt(directionEt.getText().toString());
                Log.i("Place", " + " + xCoordinate + " " + yCoordinate + " " + dir);
                place(xCoordinate, yCoordinate , dir);
            }
        });

        left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                left(robot);
            }
        });

        right.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                right(robot);
            }
        });

        move.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                move(robot);
            }
        });

        report.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                reportTv.setText(report(robot));
            }
        });

    }

    //In a 6 x 6 table, we can say that there are 3 units on each axis from the origin where the
    //robot can move.
    public void place (int xCoordinate, int yCoordinate, int direction) {
        if (direction > 0 && direction < 4 && xCoordinate < 4 && xCoordinate > - 4 && yCoordinate < 4 && yCoordinate > - 4) {
            this.robot = new RobotModel(xCoordinate, yCoordinate, direction);
        } else {
            Toast.makeText(getApplicationContext(), "Please insert vakues into the fields" +
                    "as per the instructions provided.", Toast.LENGTH_LONG).show();
        }
    }


    //Checks if there is still more room ahead to move in this direction
    public void move (RobotModel robot) {

        if (robot.getDirection() > 0){
            if (robot.getDirection() == 3 && robot.getXCoordinate() < 3) {
                robot.setXCoordinate(robot.getXCoordinate() + 1);
            } else if(robot.getDirection() == 4  && robot.getXCoordinate() > -3) {
                robot.setXCoordinate(robot.getXCoordinate() - 1);
            } else if (robot.getDirection() == 1 && robot.getYCoordinate() < 3) {
                robot.setYCoordinate(robot.getYCoordinate() + 1);
            } else if (robot.getDirection() == 2 && robot.getYCoordinate() > - 3) {
                robot.setYCoordinate(robot.getYCoordinate() - 1);
            } else {
                Toast.makeText(getApplicationContext(), "Can't move ahead, please turn!", Toast.LENGTH_LONG).show();
            }
        }

    }

    //North = 1, south = 2, east = 3, west =4
    //Checks for current direction of the robot and then turns accordingly
    public void left(RobotModel robot) {

        if (robot.getDirection() == 1) {
            robot.setDirection(4);
        } else if (robot.getDirection() == 2) {
            robot.setDirection(3);
        } else if (robot.getDirection() == 3){
            robot.setDirection(1);
        } else if (robot.getDirection() == 4){
            robot.setDirection(2);
        }

    }

    //North = 1, south = 2, east = 3, west =4
    //Checks for current direction of the robot and then turns accordingly
    public void right (RobotModel robot) {

        if (robot.getDirection() == 1) {
            robot.setDirection(3);
        } else if (robot.getDirection() ==2) {
            robot.setDirection(4);
        } else if (robot.getDirection()==3){
            robot.setDirection(2);
        } else if (robot.getDirection() == 4){
            robot.setDirection(1);
        }

    }

    //Returns the report.
    //North = 1, south = 2, east = 3, west =4
    public String report(RobotModel robot) {
        String direction = "";
        if (robot.getDirection() == 1 ){
            direction = "NORTH";
        } else if (robot.getDirection() == 2 ){
            direction = "SOUTH";
        } else if (robot.getDirection() == 3 ){
            direction = "EAST";
        } else if (robot.getDirection() == 4 ){
            direction = "WEST";
        }
        return robot.getXCoordinate() + ", " + robot.getYCoordinate() + ", " + direction;
    }


}