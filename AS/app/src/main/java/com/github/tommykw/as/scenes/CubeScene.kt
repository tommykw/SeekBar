package com.github.tommykw.`as`.scenes

import android.content.Context
import jmini3d.Color4
import jmini3d.Object3d
import jmini3d.Scene
import jmini3d.Vector3
import jmini3d.geometry.BoxGeometry
import jmini3d.light.AmbientLight
import jmini3d.light.PointLight
import jmini3d.material.PhongMaterial
import java.util.*
import kotlin.properties.Delegates

class CubeScene : Scene {
    private var o3d: Object3d by Delegates.notNull()
    private var angle = 0f

    constructor(context: Context) {
        camera.apply {
            setPosition(0f, 0f, 0f)
            setTarget(camera.position.x, camera.position.y, camera.position.z - 1f)
            setUpAxis(0f, 1f, 0f)
        }

        val random = Random()
        addLight(AmbientLight(Color4(255, 255, 255), 0f))
        addLight(PointLight(Vector3(0f, 0f, 0f), Color4(255, 255, 255), 1.1f))

        val ambient = Color4(255, 255, 255, 255)
        val red = Color4(255, 0, 0, 255)
        val green = Color4(0, 255, 0, 255)
        val blue = Color4(0, 0, 255, 255)

        val material1 = PhongMaterial(ambient, red, red)
        val material2 = PhongMaterial(ambient, green, green)
        val material3 = PhongMaterial(ambient, blue, blue)

        val geometry = BoxGeometry(1.5f)

        for (i in 1..5) {
            for (x in 1..5) {
                val x = (i - 3) * 4
                val y = (x - 3) * 4
                val z = -25
                val o3d: Object3d = if ((i + x) % 2 == 0)
                    Object3d(geometry, material1)
                else
                    Object3d(geometry, material2)

                o3d.setPosition(x.toFloat(), y.toFloat(), z.toFloat())
                addChild(o3d)
            }
        }
    }

    fun update(timeElapsed: Long) {
        angle += (0.001 * timeElapsed).toFloat()
    }
}