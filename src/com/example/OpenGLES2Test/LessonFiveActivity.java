package com.example.OpenGLES2Test;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.ConfigurationInfo;
import android.opengl.GLSurfaceView;
import android.os.Build;
import android.os.Bundle;
import android.view.MotionEvent;

/**
 * Created with IntelliJ IDEA.
 * User: wietse
 * Date: 16-12-12
 * Time: 21:39
 * To change this template use File | Settings | File Templates.
 */

/*

    The model matrix. This matrix is used to place a model somewhere in the “world”. For example, if you have a model of a car and you want
    it located 1000 meters to the east, you will use the model matrix to do this.

    The view matrix. This matrix represents the camera. If we want to view our car which is 1000 meters to the east, we’ll have to move
    ourselves 1000 meters to the east as well (another way of thinking about it is that we remain stationary, and the rest of the world moves 1000 meters to the west). We use the view matrix to do this.

    The projection matrix. Since our screens are flat, we need to do a final transformation to “project” our view onto our screen and get
    that nice 3D perspective. This is what the projection matrix is used for.

 */
public class LessonFiveActivity extends Activity {

    //reference to the GLSurfaceView
    private LessonFiveGLSurfaceView mLessonFiveGLSurfaceView;
    private LessonFiveRenderer renderer;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);




        mLessonFiveGLSurfaceView = new LessonFiveGLSurfaceView(this);

        //CHeck if the system supports OpenGL ES 2.0
        final ActivityManager activityManager = (ActivityManager) getSystemService(Context.ACTIVITY_SERVICE);
        final ConfigurationInfo configurationInfo = activityManager.getDeviceConfigurationInfo();
        final boolean supportsEs2 = configurationInfo.reqGlEsVersion >= 0x20000;

        if(supportsEs2)
        {
            // Request an OpenGL ES 2.0 compatible context
            mLessonFiveGLSurfaceView.setEGLContextClientVersion(2);

            renderer = new LessonFiveRenderer(this);

            // Set the renderer to our demo renderer, defined below
            mLessonFiveGLSurfaceView.setRenderer(renderer);


        }
        else
        {
            //Here a OpenGL ES 1.x could be created
            return;
        }

        setContentView(mLessonFiveGLSurfaceView);
    }



    @Override
    protected void onResume() {
        super.onResume();
        mLessonFiveGLSurfaceView.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mLessonFiveGLSurfaceView.onPause();
    }
}
