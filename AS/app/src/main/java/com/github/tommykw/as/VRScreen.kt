package com.github.tommykw.`as`

import com.google.vr.sdk.base.Eye
import com.google.vr.sdk.base.HeadTransform
import jmini3d.Renderer3d

interface VRScreen {
    fun onNewFrame(transform: HeadTransform, forceRedraw: Boolean)
    fun render(eye: Eye, renderer: Renderer3d)
}