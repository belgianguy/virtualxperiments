package com.example.OpenGLES2Test;

import android.content.Context;
import android.opengl.GLSurfaceView;
import android.view.MotionEvent;

/**
 * Created with IntelliJ IDEA.
 * User: wietse
 * Date: 19-12-12
 * Time: 14:04
 * To change this template use File | Settings | File Templates.
 */
public class LessonFiveGLSurfaceView extends GLSurfaceView {

    private LessonFiveRenderer mRenderer;

    public LessonFiveGLSurfaceView(Context context) {
        super(context);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event)
    {
        if (event != null)
        {
            if (event.getAction() == MotionEvent.ACTION_DOWN)
            {
                if (mRenderer != null)
                {
                    // Ensure we call switchMode() on the OpenGL thread.
                    // queueEvent() is a method of GLSurfaceView that will do this for us.
                    queueEvent(new Runnable()
                    {
                        @Override
                        public void run()
                        {
                            mRenderer.switchMode();
                        }
                    });

                    return true;
                }
            }
        }

        return super.onTouchEvent(event);
    }

    // Hides superclass method.
    public void setRenderer(LessonFiveRenderer renderer)
    {
        mRenderer = renderer;
        super.setRenderer(renderer);
    }
}
