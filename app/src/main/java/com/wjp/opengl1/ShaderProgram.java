package com.wjp.opengl1;

import android.opengl.GLES20;

public class ShaderProgram {
    public static int createProgram(String vertexSrc, String fragmentSrc) {
        int vertex = loadShader(vertexSrc, GLES20.GL_VERTEX_SHADER);
        int fragment = loadShader(fragmentSrc, GLES20.GL_FRAGMENT_SHADER);
        int program = GLES20.glCreateProgram();
        GLES20.glAttachShader(program, vertex);
        GLES20.glAttachShader(program, fragment);
        GLES20.glLinkProgram(program);
        return program;
    }

    public static int loadShader(String src, int type) {
        int handle = GLES20.glCreateShader(type);
        GLES20.glShaderSource(handle, src);
        GLES20.glCompileShader(handle);
        return handle;
    }
}
