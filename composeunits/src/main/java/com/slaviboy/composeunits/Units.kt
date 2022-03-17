package com.slaviboy.composeunits

import android.app.Activity
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.ExperimentalUnitApi
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.window.layout.WindowMetricsCalculator

// scale factors that are used when we want to scale all composable for landscape or tablets
var ScaleFactor = 1f
var ActualScaleFactor = 1f

// device width, height as px
var DeviceWidth = 0f
var DeviceHeight = 0f

// density and scale density to convert from px to sp, dp
var Density = 0f
var ScaleDensity = 0f

// convert PX to SP,DP and vice versa
inline val Number.PxToSp get() = this.toFloat() / ScaleDensity
inline val Number.SpToPx get() = this.toFloat() * ScaleDensity
inline val Number.PxToDp get() = this.toFloat() / Density
inline val Number.DpToPx get() = this.toFloat() * Density

/**
 * Call this method from your activity at onCreate() method before setContent{ }
 */
fun Activity.initSize() {

    WindowMetricsCalculator
        .getOrCreate()
        .computeCurrentWindowMetrics(this)
        .bounds.let {
            DeviceWidth = it.width().toFloat()
            DeviceHeight = it.height().toFloat()
        }
    Density = this.resources.displayMetrics.density
    ScaleDensity = this.resources.displayMetrics.scaledDensity
}

/**
 * The actual device width, so when phone is rotated in landscape mode it uses the
 * bigger side as width, and when phone is in portrait mode it uses the smalled side as width
 */
inline val Number.adw: Dp
    get() = Dp(value = (ActualScaleFactor * this.toFloat() * DeviceWidth).PxToDp)


/**
 * The actual device height, so when phone is rotated in landscape mode it uses the
 * bigger side as height, and when phone is in portrait mode it uses the smalled side as height
 */
inline val Number.adh: Dp
    get() = Dp(value = (ActualScaleFactor * this.toFloat() * DeviceHeight).PxToDp)


/**
 * This extension method converts a double value set as percentage of device width to Dp object
 * @example (0.1.dw) 10% of the device width
 */
inline val Number.dw: Dp
    get() = Dp(value = (ScaleFactor * this.toFloat() * Math.min(DeviceWidth, DeviceHeight)).PxToDp)


/**
 * This extension method converts a double value set as percentage of device height to Dp object
 * @example (0.1.dh) 10% of the device height
 */
inline val Number.dh: Dp
    get() = Dp(value = (ScaleFactor * this.toFloat() * Math.max(DeviceWidth, DeviceHeight)).PxToDp)


/**
 * This extension method converts a double value set as percentage of device width to TextUnit object
 * @example (0.1.sw) 10% of the device width
 */
@OptIn(ExperimentalUnitApi::class)
inline val Number.sw: TextUnit
    get() = TextUnit((ScaleFactor * this.toFloat() * Math.min(DeviceWidth, DeviceHeight)).PxToSp, TextUnitType.Sp)


/**
 * This extension method converts a double value set as percentage of device width to TextUnit object
 * @example (0.1.sh) 10% of the device height
 */
@OptIn(ExperimentalUnitApi::class)
inline val Number.sh: TextUnit
    get() = TextUnit((ScaleFactor * this.toFloat() * Math.max(DeviceWidth, DeviceHeight)).PxToSp, TextUnitType.Sp)
