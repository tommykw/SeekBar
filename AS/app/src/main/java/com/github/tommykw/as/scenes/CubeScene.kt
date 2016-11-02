package com.github.tommykw.`as`.scenes

import android.content.Context
import jmini3d.Object3d
import jmini3d.Scene
import kotlin.properties.Delegates

class CubeScene : Scene {
    private var o3d: Object3d by Delegates.notNull()
    private var angle = 0f

    constructor(context: Context) {
        camera.apply {
            setPosition(0f, 0f, 0f)
        }
    }
}