package mx.tecnm.tepic.ladm_u4_practica2_canvasysensores

import android.content.Context
import android.hardware.Sensor
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.hardware.SensorEvent
import android.hardware.SensorEventListener

import android.hardware.SensorManager




class MainActivity : AppCompatActivity(), SensorEventListener {
    private lateinit var sensorManager: SensorManager
    private var proximity: Sensor? = null
    private var temperature: Sensor? = null
    var temperatura=0F
    var proximidad=0F


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(Lienzo(this))
        // Get an instance of the sensor service, and use that to get an instance of
        // a particular sensor.
        sensorManager = getSystemService(Context.SENSOR_SERVICE) as SensorManager
        temperature = sensorManager.getDefaultSensor(Sensor.TYPE_AMBIENT_TEMPERATURE)
        proximity = sensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY)

    }

    override fun onAccuracyChanged(sensor: Sensor, accuracy: Int) {

    }

    override fun onSensorChanged(event: SensorEvent) {
        if (event.sensor.getType() == Sensor.TYPE_AMBIENT_TEMPERATURE) {
            temperatura = event.values[0]
        }else if (event.sensor.getType() == Sensor.TYPE_PROXIMITY) {
            proximidad = event.values[0]
        }
    }

    override fun onResume() {
        // Register a listener for the sensor.
        super.onResume()
        sensorManager.registerListener(this, proximity, SensorManager.SENSOR_DELAY_NORMAL)
        sensorManager.registerListener(this, temperature, SensorManager.SENSOR_DELAY_NORMAL)

    }

    override fun onPause() {
        // Be sure to unregister the sensor when the activity pauses.
        super.onPause()
        sensorManager.unregisterListener(this)
    }
}

