package com.slaviboy.composeunits

import androidx.compose.ui.unit.*
import com.google.common.truth.Truth.assertThat
import org.junit.Test
import org.junit.Before

class UnitsTest {

    @Before
    fun setup() {

        ScaleFactor = 1f
        ActualScaleFactor = 1f
        Density = 1.5f
        ScaleDensity = 1.7f

        // set width to be bigger than height
        DeviceWidth = 2340f
        DeviceHeight = 1080f
    }

    @Test
    fun check_PxToDp() {

        val value = 0.435f
        assertThat(value.PxToDp).isEqualTo(0.29f)
    }

    @Test
    fun check_PxToSp() {

        val value = 0.435f
        assertThat(value.PxToSp).isEqualTo(0.25588235f)
    }

    @Test
    fun check_DpToPx() {

        val value = 0.435f
        assertThat(value.DpToPx).isEqualTo(0.65250003f)
    }

    @Test
    fun check_SpToPx() {

        val value = 0.435f
        assertThat(value.SpToPx).isEqualTo(0.73950005f)
    }

    @Test
    fun check_DeviceWidth() {

        // int
        assertThat(1.dw).isEqualTo(720.0.dp)

        // float
        val multiplyFloat = 0.435f
        assertThat(multiplyFloat.dw).isEqualTo(313.19998.dp)

        // double
        val multiplyDouble = 0.435
        assertThat(multiplyDouble.dw).isEqualTo(313.19998.dp)
    }

    @Test
    fun check_DeviceHeight() {

        // int
        assertThat(1.dh).isEqualTo(1560.0.dp)

        // float
        val multiplyFloat = 0.435f
        assertThat(multiplyFloat.dh).isEqualTo(678.60004.dp)

        // double
        val multiplyDouble = 0.435
        assertThat(multiplyDouble.dh).isEqualTo(678.60004.dp)
    }

    /**
     * Should match the values expected for adh = dw, since we set the width bigger than the
     * height simulating landscape mode
     */
    @Test
    fun check_ActualDeviceHeight() {

        // int
        assertThat(1.adh).isEqualTo(720.0.dp)

        // float
        val multiplyFloat = 0.435f
        assertThat(multiplyFloat.adh).isEqualTo(313.19998.dp)

        // double
        val multiplyDouble = 0.435
        assertThat(multiplyDouble.adh).isEqualTo(313.19998.dp)
    }

    /**
     * Should match the values expected for adw = dh, since we set the width bigger than the
     * height simulating landscape mode
     */
    @Test
    fun check_ActualDeviceWidth() {

        // int
        assertThat(1.adw).isEqualTo(1560.0.dp)

        // float
        val multiplyFloat = 0.435f
        assertThat(multiplyFloat.adw).isEqualTo(678.60004.dp)

        // double
        val multiplyDouble = 0.435
        assertThat(multiplyDouble.adw).isEqualTo(678.60004.dp)
    }

    @OptIn(ExperimentalUnitApi::class)
    @Test
    fun check_Font_DeviceWidth() {

        // int
        assertThat(1.sw).isEqualTo(635.2941.sp)

        // float
        val multiplyFloat = 0.435f
        assertThat(multiplyFloat.sw).isEqualTo(276.35294.sp)

        // double
        val multiplyDouble = 0.435
        assertThat(multiplyDouble.sw).isEqualTo(276.35294.sp)
    }

    @OptIn(ExperimentalUnitApi::class)
    @Test
    fun check_Font_DeviceHeight() {

        // int
        assertThat(1.sh).isEqualTo(1376.4706.sp)

        // float
        val multiplyFloat = 0.435f
        assertThat(multiplyFloat.sh).isEqualTo(598.7647.sp)

        // double
        val multiplyDouble = 0.435
        assertThat(multiplyDouble.sh).isEqualTo(598.7647.sp)
    }
}