package no.finn.techday2018.JingleBells

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager

class AccelSensor internal constructor(private val listener: OnAccelEvent) {

    private var initialized = false
    private var tracking = false

    private var mSensorManager: SensorManager? = null
    private var mAccel: Float = 0.toFloat() // current acceleration including gravity

    private val mSensorListener = object : SensorEventListener {

        var TRESHOLD_HIGH = 2
        var TRESHOLD_LOW = 1

        override fun onSensorChanged(se: SensorEvent) {
            val x = se.values[0]
            val y = se.values[1]
            val z = se.values[2]
            mAccel = Math.sqrt((x * x + y * y + z * z).toDouble()).toFloat()

            // track and detect shake gesture
            if (mAccel > SensorManager.GRAVITY_EARTH + TRESHOLD_HIGH)
                tracking = true
            else if (mAccel < SensorManager.GRAVITY_EARTH + TRESHOLD_LOW) {
                if (tracking) {
                    listener.onShake()
                    tracking = false
                }
            }
        }

        override fun onAccuracyChanged(sensor: Sensor, accuracy: Int) {}
    }

    interface OnAccelEvent {
        fun onShake()
    }

    fun onPause() {
        mSensorManager?.unregisterListener(mSensorListener)
    }

    fun onResume(context: Context) {
        init(context)
        mSensorManager?.registerListener(
            mSensorListener,
            mSensorManager?.getDefaultSensor(Sensor.TYPE_ACCELEROMETER),
            SensorManager.SENSOR_DELAY_NORMAL
        )
    }

    private fun init(context: Context) {
        if (!initialized) {
            mSensorManager = context.getSystemService(Context.SENSOR_SERVICE) as SensorManager
            mSensorManager?.registerListener(
                mSensorListener,
                mSensorManager?.getDefaultSensor(Sensor.TYPE_ACCELEROMETER),
                SensorManager.SENSOR_DELAY_NORMAL
            )
            mAccel = SensorManager.GRAVITY_EARTH
            initialized = true
        }
    }

}
