package com.github.tommykw.`as`

import jmini3d.Object3d
import jmini3d.Vector3
import jmini3d.geometry.VariableGeometry
import kotlin.properties.Delegates

class VRTextureButton {
    private var width = 0f
    private var height = 0f
    private var vectorA = Vector3()
    private var vectorB = Vector3()
    private var vectorC = Vector3()

    var geometry: VariableGeometry by Delegates.notNull()
    var object3d: Object3d by Delegates.notNull()

    companion object {
        const val TIME_CLICK = 1000
        const val SCALE_ANIMATION_SPEED = 3f
    }
}