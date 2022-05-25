package com.example.averquesale

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import com.example.averquesale.R

class MainActivity3 : AppCompatActivity(), SensorEventListener {


    private lateinit var sensorManager:SensorManager
    private lateinit var xAceleraVisor:TextView
    private lateinit var yAceleraVisor:TextView
    private lateinit var zAceleraVisor:TextView

    private lateinit var xGyroVisor:TextView
    private lateinit var yGyroVisor:TextView
    private lateinit var zGyroVisor:TextView

    private lateinit var proximity:TextView

    private lateinit var presionVisor:TextView
    private lateinit var temperatura:TextView
    private lateinit var luzAmbientalVisor:TextView

    private lateinit var mediaPlayer: MediaPlayer

    // var hora = findViewById<EditText>(R.id.editTextTime)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)



        xAceleraVisor = findViewById<TextView>(R.id.xAceleraView)
        yAceleraVisor = findViewById<TextView>(R.id.yAceleraView)
        zAceleraVisor = findViewById<TextView>(R.id.zAceleraView)

        xGyroVisor = findViewById<TextView>(R.id.idXGyro)
        yGyroVisor = findViewById<TextView>(R.id.idYGyro)
        zGyroVisor = findViewById<TextView>(R.id.idZGyro)

        proximity = findViewById<TextView>(R.id.idProximity)

        luzAmbientalVisor = findViewById<TextView>(R.id.idTemp)


        mediaPlayer = MediaPlayer.create(this,R.raw.miau)

        var sensorManager: SensorManager = getSystemService(Context.SENSOR_SERVICE)
                as SensorManager

        sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER)?.also{

            sensorManager.registerListener(
                this,
                it,
                SensorManager.SENSOR_DELAY_FASTEST,
                SensorManager.SENSOR_DELAY_FASTEST
            )
        }

        sensorManager.getDefaultSensor(Sensor.TYPE_GYROSCOPE)?.also{

            sensorManager.registerListener(
                this,
                it,
                SensorManager.SENSOR_DELAY_FASTEST,
                SensorManager.SENSOR_DELAY_FASTEST
            )
        }

        sensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY)?.also{

            sensorManager.registerListener(
                this,
                it,
                SensorManager.SENSOR_DELAY_FASTEST,
                SensorManager.SENSOR_DELAY_FASTEST
            )
        }


        sensorManager.getDefaultSensor(Sensor.TYPE_AMBIENT_TEMPERATURE)?.also{

            sensorManager.registerListener(
                this,
                it,
                SensorManager.SENSOR_DELAY_FASTEST,
                SensorManager.SENSOR_DELAY_FASTEST
            )
        }


        sensorManager.getDefaultSensor(Sensor.TYPE_PRESSURE)?.also{

            sensorManager.registerListener(
                this,
                it,
                SensorManager.SENSOR_DELAY_FASTEST,
                SensorManager.SENSOR_DELAY_FASTEST
            )
        }


        sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT)?.also{

            sensorManager.registerListener(
                this,
                it,
                SensorManager.SENSOR_DELAY_FASTEST,
                SensorManager.SENSOR_DELAY_FASTEST
            )
        }

        sensorManager.getDefaultSensor(Sensor.TYPE_RELATIVE_HUMIDITY)?.also{

            sensorManager.registerListener(
                this,
                it,
                SensorManager.SENSOR_DELAY_FASTEST,
                SensorManager.SENSOR_DELAY_FASTEST
            )
        }



    }

    fun macarena(){
        mediaPlayer?.start()
    }

    override fun onSensorChanged(event: SensorEvent?) {

        if(event?.sensor?.type == Sensor.TYPE_ACCELEROMETER) {

            var x_acel = event.values[0]
            var y_acel = event.values[1]
            var z_acel = event.values[2]
            xAceleraVisor.setText("x:"+x_acel)
            yAceleraVisor.setText("y:"+y_acel)
            zAceleraVisor.setText("z:"+z_acel)

        } else if (event?.sensor?.type == Sensor.TYPE_AMBIENT_TEMPERATURE){

            var temp = event.values[0]


            temperatura.setText("ºC "+ temp)



        }else if (event?.sensor?.type == Sensor.TYPE_PRESSURE){

            var presion = event.values[0]

            presionVisor.setText(""+ presion)




        }else if (event?.sensor?.type == Sensor.TYPE_GYROSCOPE){

            var x_gyro = event.values[0]
            var y_gyro = event.values[1]
            var z_gyro = event.values[2]
            xGyroVisor.setText("x: "+x_gyro)
            yGyroVisor.setText("x: "+y_gyro)
            zGyroVisor.setText("x: "+z_gyro)

        }else if (event?.sensor?.type == Sensor.TYPE_LIGHT){

            var luminosidad = event.values[0]
               if (luminosidad == 150.0f){
                mediaPlayer?.start()
            }

            luzAmbientalVisor.setText(""+ luminosidad)



        }else if (event?.sensor?.type == Sensor.TYPE_RELATIVE_HUMIDITY){

            var x_acel = event.values[0]

            xAceleraVisor.setText("x: "+x_acel)


        }else if (event?.sensor?.type == Sensor.TYPE_PROXIMITY){

            var dataProximity = event.values[0]

            if (dataProximity == 0.0f){
                mediaPlayer?.start()
            }

            proximity.setText("x: "+ dataProximity)


        }
    }

    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {
        return
    }

    override fun onDestroy() {
        sensorManager.unregisterListener(this)
        super.onDestroy()
    }
}
