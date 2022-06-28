package com.example.mapnavigator;

public interface TaskCallback {
    void onRouteDone(Object... values);
    void onDistanceMatrixDone(Object... values);
}
