package com.github.tommykw.`as`.scenes

import jmini3d.HudScene
import jmini3d.Object3d
import jmini3d.Texture
import jmini3d.geometry.SpriteGeometry
import jmini3d.material.SpriteMaterial
import kotlin.properties.Delegates

class CrossScene : HudScene() {
    private var crossObject: Object3d by Delegates.notNull()

    init {
        val crossGeometry = SpriteGeometry(1)
        crossGeometry.addSprite(0f, 0f, 0f, 0f)
        crossObject = Object3d(crossGeometry, SpriteMaterial(Texture("cross.png")))
        addChild(crossObject)
    }

    override fun onViewPortChanged(width: Int, height: Int) {
        val crossSize2 = height / 20
        (crossObject.geometry3d as SpriteGeometry).setSpritePosition(
            0,
            (width / 2.0 - crossSize2) as Float,
            (height / 2.0 - crossSize2) as Float,
            crossSize2 * 2 as Float,
            crossSize2 * 2 as Float
        )
    }
}