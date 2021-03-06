package com.xt.kimi.uikit

import com.xt.endo.CGRect
import kotlin.math.max
import kotlin.math.min


fun CGRectIntersectsRect(r1: CGRect, r2: CGRect): Boolean {
    if (r1.x + r1.width - 0.1 <= r2.x ||
        r2.x + r2.width - 0.1 <= r1.x ||
        r1.y + r1.height - 0.1 <= r2.y ||
        r2.y + r2.height - 0.1 <= r1.y) {
        return false
    }
    return true
}

fun CGRectContainsRect(r1: CGRect, r2: CGRect): Boolean {
    if (r1.x - 0.1 <= r2.x &&
            r1.y - 0.1 <= r2.y &&
            r1.x + r1.width + 0.1 >= r2.x + r2.width &&
            r1.y + r1.height + 0.1 >= r2.y + r2.height) {
        return true
    }
    return false
}

fun CGRectUnion(r1: CGRect, r2: CGRect): CGRect {
    val x = min(r1.x, r2.x)
    val y = min(r1.y, r2.y)
    val width = max(r1.x + r1.width, r2.x + r2.width)
    val height = max(r1.y + r1.height, r2.y + r2.height)
    return CGRect(x, y, width, height)
}

fun CGRectIsEmpty(rect: CGRect): Boolean {
    return rect.width == 0.0 || rect.height == 0.0
}

fun CGRectEqualToRect(r1: CGRect, r2: CGRect): Boolean {
    return Math.abs(r1.x - r2.x) < 0.001 && Math.abs(r1.y - r2.y) < 0.001 && Math.abs(r1.width - r2.width) < 0.001 && Math.abs(r1.height - r2.height) < 0.001
}

internal class CGPointMutable(var x: Double, var y: Double) {}
internal class CGRectMutable(var x: Double, var y: Double, var width: Double, var height: Double) {}
internal class CGSizeMutable(var width: Double, var height: Double) {}