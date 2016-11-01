package com.github.tommykw.`as`

import jmini3d.Blending
import jmini3d.Object3d
import jmini3d.Texture
import jmini3d.Vector3
import jmini3d.geometry.VariableGeometry
import jmini3d.material.Material
import java.util.*
import kotlin.properties.Delegates

class VRTextureButton {
    private var width = 0f
    private var height = 0f
    private var vectorA = Vector3()
    private var vectorB = Vector3()
    private var vectorC = Vector3()

    private var geometry: VariableGeometry by Delegates.notNull()
    private var object3d: Object3d by Delegates.notNull()
    private var targetScale: Float = 1f
    private var lookingToMe = false
    private var timeLookingToMe = false
    private var clickListener: VRClickListener? = null

    fun VRTextureButton(width: Float,
                        height: Float,
                        texture: String,
                        clickListener: VRClickListener) {
        this.width = width
        this.height = height
        this.clickListener = clickListener

        geometry = VariableGeometry(4, 2).apply {
            addQuad(
                Vector3(-width / 2, height / 2, 0f),
                Vector3(width / 2, height / 2, 0f),
                Vector3(-width / 2, -height / 2, 0f),
                Vector3(width / 2, -height / 2, 0f)
            )
        }

        val material = Material(Texture(texture)).apply {
            setBlending(Blending.NormalBlending)
        }

        object3d = Object3d(geometry, material)
    }

    fun setPosition(x: Float, y: Float, z: Float) {
        object3d.setPosition(x, y, z)
    }

    companion object {
        const val TIME_CLICK = 1000
        const val SCALE_ANIMATION_SPEED = 3f

        interface VRClickListener {
            fun onClicked()
        }
    }
}