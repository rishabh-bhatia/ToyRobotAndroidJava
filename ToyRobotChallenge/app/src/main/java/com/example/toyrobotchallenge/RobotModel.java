package com.example.toyrobotchallenge;

public class RobotModel {

    int XCoordinate, YCoordinate;
    int direction;//North = 1, south = 2, east = 3, west =4

    public RobotModel(int XCoordinate, int YCoordinate, int direction) {
        this.XCoordinate = XCoordinate;
        this.YCoordinate = YCoordinate;
        this.direction = direction;
    }

    public int getXCoordinate() {
        return XCoordinate;
    }

    public int getYCoordinate() {
        return YCoordinate;
    }

    public int getDirection() {
        return direction;
    }

    public void setXCoordinate(int XCoordinate) {
        this.XCoordinate = XCoordinate;
    }

    public void setYCoordinate(int YCoordinate) {
        this.YCoordinate = YCoordinate;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }
}
