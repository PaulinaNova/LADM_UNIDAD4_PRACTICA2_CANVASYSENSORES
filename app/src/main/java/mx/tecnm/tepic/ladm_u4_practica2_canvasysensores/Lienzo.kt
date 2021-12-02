package mx.tecnm.tepic.ladm_u4_practica2_canvasysensores

import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.hardware.SensorEvent
import android.view.View


class Lienzo(p:MainActivity ): View(p) {
    val puntero = p
    var grados = 0F
    val pollo = BitmapFactory.decodeResource(puntero.resources, R.drawable.pollo)
    val fbajo = BitmapFactory.decodeResource(puntero.resources, R.drawable.fuegobajo)
    val fmedio = BitmapFactory.decodeResource(puntero.resources, R.drawable.fuegomedio)
    val falto = BitmapFactory.decodeResource(puntero.resources, R.drawable.fuegoalto)
    val asador = BitmapFactory.decodeResource(puntero.resources, R.drawable.asador)
    val mesa = BitmapFactory.decodeResource(puntero.resources, R.drawable.mesa)

    override fun onDraw(c: Canvas) {
        super.onDraw(c)
        val p = Paint()
        c.drawColor(Color.rgb(232, 187, 39))
        if(puntero.temperatura >= -274 && puntero.temperatura < -170){

        }else if(puntero.temperatura >= -170 && puntero.temperatura <= -70){
            c.drawBitmap(fbajo, 400f,1200f,p)
            c.drawBitmap(fbajo, 850f,1200f,p)
        }else if(puntero.temperatura > -70 && puntero.temperatura <= 30){
            c.drawBitmap(fmedio, 300f,1000f,p)
            c.drawBitmap(fmedio, 750f,1000f,p)
        }else{
            c.drawBitmap(falto, 100f,550f,p)
            c.drawBitmap(falto, 550f,550f,p)
        }
        p.color = Color.GRAY
        p.style = Paint.Style.STROKE
        p.strokeWidth = 20f
        c.drawLine(0f,350f+ puntero.proximidad*100,1700f,350f+ puntero.proximidad*100,p)
        c.drawBitmap(pollo, 500f,150f + puntero.proximidad*100 ,p)
        c.drawBitmap(asador, 300f,1150f,p)
        c.drawBitmap(mesa, 300f,1400f,p)
        //c.drawText("sensor: "+puntero.temperatura,200f,1000f,p)
        invalidate()
    }
}
