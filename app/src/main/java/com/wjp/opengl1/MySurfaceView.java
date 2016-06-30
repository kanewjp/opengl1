package com.wjp.opengl1;

import android.content.Context;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import android.opengl.Matrix;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

public class MySurfaceView extends GLSurfaceView {

    public MySurfaceView(Context context) {
        super(context);
        setEGLContextClientVersion(2);
        Renderer renderer = new MyRenderer();
        setRenderer(renderer);
    }

    private static class MyRenderer implements Renderer {
        @Override
        public void onSurfaceCreated(GL10 gl10, EGLConfig eglConfig) {
            GLES20.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
        }

        @Override
        public void onSurfaceChanged(GL10 gl10, int width, int height) {
            /*
            GLES20.glClear(GLES20.GL_COLOR_BUFFER_BIT | GLES20.GL_DEPTH_BUFFER_BIT);
            // Set the camera position (View matrix)
            Matrix.setLookAtM(mViewMatrix, 0, 0, 0, 1f, 0f, 0f, 0f, 0.0f, 1.0f, 0.0f);

            GLES20.glViewport(0, 0, width, height);
            float ratio = (float) width / height;
            // this projection matrix is applied to object coordinates
            // in the onDrawFrame() method
            // Matrix.frustumM(mProjectionMatrix, 0, -ratio, ratio, -1, 1, 1f, 10);
            Matrix.perspectiveM(mProjectionMatrix, 0, 90.0f, ratio, 0.0f, 2.0f);

            // Calculate the projection and view transformation
            Matrix.multiplyMM(mMVPMatrix, 0, mProjectionMatrix, 0, mViewMatrix, 0);*/
        }

        @Override
        public void onDrawFrame(GL10 gl10) {
            GLES20.glClear(GLES20.GL_COLOR_BUFFER_BIT | GLES20.GL_DEPTH_BUFFER_BIT);

            float red = (float)Math.sin(System.currentTimeMillis()/1000)*0.5f + 0.5f;
            float green = (float)Math.cos(System.currentTimeMillis()/1000)*0.5f + 0.5f;
            GLES20.glClearColor(red, green, 0.0f, 1.0f);
        }

        private final float[] mMVPMatrix = new float[16];
        private final float[] mProjectionMatrix = new float[16];
        private final float[] mViewMatrix = new float[16];
        private final float[] mRotationMatrix = new float[16];
    }
}
