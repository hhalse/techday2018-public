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
    private var mAccel: Float = 0.toFloat() // acceleration apart from gravity
    private var mAccelCurrent: Float = 0.toFloat() // current acceleration including gravity
    private var mAccelLast: Float = 0.toFloat() // last acceleration including gravity

    private val mSensorListener = object : SensorEventListener {

        var TRESHOLD_HIGH = 6
        var TRESHOLD_LOW = 2

        override fun onSensorChanged(se: SensorEvent) {
            val x = se.values[0]
            val y = se.values[1]
            val z = se.values[2]
            mAccelLast = mAccelCurrent
            mAccelCurrent = Math.sqrt((x * x + y * y + z * z).toDouble()).toFloat()
            val delta = mAccelCurrent - mAccelLast
            mAccel = mAccel * 0.9f + delta // perform low-cut filter

            // track and detect shake gesture
            if (mAccel > TRESHOLD_HIGH)
                tracking = true
            else if (mAccel < TRESHOLD_LOW) {
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
            mAccel = 0.00f
            mAccelCurrent = SensorManager.GRAVITY_EARTH
            mAccelLast = SensorManager.GRAVITY_EARTH
            initialized = true
        }
    }

}
