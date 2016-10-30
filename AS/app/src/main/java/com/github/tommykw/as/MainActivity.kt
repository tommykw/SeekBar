package com.github.tommykw.`as`

import android.os.Bundle
import com.google.vr.sdk.base.*
import jmini3d.JMini3d
import jmini3d.Renderer3d
import javax.microedition.khronos.egl.EGLConfig
import kotlin.properties.Delegates

class MainActivity : GvrActivity(), GvrView.StereoRenderer {
    private var vrScreen: VRScreen by Delegates.notNull()
    private var renderer: Renderer3d by Delegates.notNull()
    private var width = 0
    private var height = 0

    override fun onNewFrame(p0: HeadTransform?) {
    }

    override fun onSurfaceChanged(p0: Int, p1: Int) {
    }

    override fun onSurfaceCreated(p0: EGLConfig?) {
    }

    override fun onDrawEye(p0: Eye?) {
    }

    override fun onFinishFrame(p0: Viewport?) {
    }

    override fun onRendererShutdown() {
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        JMini3d.useOpenglAxisSystem()
        initGvrView()
    }

    private fun initGvrView() {
    }

    companion object {
        const val USE_VERTEX = false
    }
}
