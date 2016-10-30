package com.github.tommykw.`as`

import com.google.vr.sdk.base.Eye
import jmini3d.MatrixUtils
import jmini3d.Renderer3d
import jmini3d.Scene

class VRRender {
    var leftProjectionMatrix = FloatArray(16)
    var leftViewMatrix = FloatArray(16)
    var rightProjectionMatrix = FloatArray(16)
    var rightViewMatrix = FloatArray(16)

    fun render(scene: Scene, eye: Eye, renderer3d: Renderer3d) {
        if (eye.type == Eye.Type.LEFT) {
            MatrixUtils.copyMatrix(
                eye.getPerspective(
                    scene.camera.near,
                    scene.camera.far
                ),
                leftProjectionMatrix
            )
            renderer3d.render(scene, leftProjectionMatrix, leftViewMatrix)
        } else {
            MatrixUtils.copyMatrix(
                eye.getPerspective(
                    scene.camera.near,
                    scene.camera.far
                ),
                rightProjectionMatrix
            )
            renderer3d.render(scene, rightProjectionMatrix, rightViewMatrix)
        }
    }
}