# ProyectoAndroidEsquema
Un proyecto en Android de 1º de DAM

# ProyectoAndroid

Cualquier duda podeis decirme. Diré por aquí lo que pone en el .kt

-Main Acitivty 1-

Declaro dos Val llamadas imagen 1 e imagen 2. Ambas se corresponden con un ImageView puesto en el XML. Debajo de imagen 1 inicio Glide con la imagen de la nube, y debajo de la imagen2 inicio Glide pero con una imagen en mi carpeta drawable. Lo siguiente que hay es un botón para pasar a la siguiente página. 

-Main Activity 2-

Este ejercicio se divide en 4 con SoundPool y 2 con MediaPlayer, primero iremos con los 4 y luego con los otros dos.
Declaro el "audioAttributes" para inicializar como indica Fran. Luego también inicio otra val del primer soundPool, que lo que hace es aplicar los audioAttributes seteados anteriormente. Luego se incia el objeto AudioManager para setear el SystemService, el context es AUDIO_SERVICE  //(Audio del dispositivo)// .

Cerramos dicho objeto seteando de nuevo que es un AudioManager. Por último antes de empezar donde entendemos, hay que declarar la val volume, ayudada por la val anterior AudioManager.//(Todo esto sale en el pdf de Fran, las características técnicas las desconozco, pero deben ir en ese orden para el correcto funcionamiento.

Ahora si empezamos a declar las VAL que entenderiamos //(Recuerdo que VAL es para que no cambie una vez establecido)//. Bien, definimos las 4 primeras de SoundPool de la forma escrita en el .kt, lo importante aquí es saber que al final de la declaración en " R.raw.mario," la R es normal que esté, el "raw" es la carpeta en cuestión y el "mario" es el sonido en cuestión, su nombre. !!Siempre en miniscula y lo más conciso posible. 

Bien continuamos con los otros 3 que faltan y hacemos 6 botones para así poder poner los 6 sonidos. Aunque actualmente solo tengamos 4, recuerdo que en total son 6. 

Iniciamos la primera acción del primer botón con el setOnClickListener y dentro metemos lo siguiente:

" soundPool1.play(sound1,volume.toFloat(),volume.toFloat(),1,0,1f) "

Bien, como recordais al principio habiamos seteado el SoundPool1 con los audioAttributes, bien pues para esto era. Luego, simplemente lo único a tener en cuenta es que donde va "sound1" debe ir el nombre de la val que le habeis dado al sonido //(donde poneis la carpeta y nombre del archivo, esa val)//. 

Los siguiente dos "volume.toFloat" es para setear el volumen del lado izquierdo o derecho, lo dejamos vacíos porque no lo necesitamos. Por último están los 3 campos que resta, el primero es la prioridad, el segundo es el Loop  y el tercero la velocidad, que lleva la f detrás.

Pasando ya al mediaplayer, es bastante más sencillo:

"var mediaPlayer: MediaPlayer? = null
        mediaPlayer = MediaPlayer.create(this,R.raw.mariomoneda)
"

Esto es lo importante, y es que declaramos una var de cualquier nombre, los dos puntitos para decirle que se refiere a un objeto MediaPlayer, la interrogación para como dijo Fran que el programa si eso falla, no se parase, y lo igualamos a null //(En minuscula). Tras ello simplemente con el nombre de nuestra variable pues la igualamos a "MediaPlayer.create" y el nombre de la carpeta y el archivo. 

Basicamente hacemos lo mismo otra vez, asignamos los dos botones que nos falta y dentro de estos ponemos " mediaPlayer?.start()" que sería el nombre de nuestra variable, la interrogación y el ".start" para que funcione.  Y ahí finalizamos el apartado 2

-Main Activity 3-

Vale, vamos por pasos porque es largo este. Como tal empezamos cogiendo el fichero de fran sobre los sensores, literalmente esa es nuestra plantilla. Dentro de este fichero, tenemos nuestro código plantilla. 

Este código plantilla lo copiamos y lo pegamos, y cambiamos el nombre del paquete arriba del todo por el nuestro, cambiamos el nombre de la actividad en: "class MainActivity3 : AppCompatActivity(), SensorEventListener {" Donde pone MainActity3, poneis el nombre de vuestra actividad si lo deseais. Bien, empezamos de verdad.

Para empezar, tenemos que definir en el XML unos cuantos TextView, ya que es donde se irán poniendo los valores de los sensores. Son 3 para el acelerometro, serían el eje X, el eje Y, y eje Z. 3 también para el  Girometro con sus respectivos ejes X, Y,Z. 1 para la proximidad. Y otro para la luz ambiental.

De momento solo he jugado con estos porque es lo que se pide, pero también hay temperatural, humedad ambiental, y cositas así.

Bien, una vez definidos los TextView en el XML es fundamental cambiarles los nombres de sus ID´S a los que están en el documento. En este caso serían:

"

        xAceleraVisor = findViewById<TextView>(R.id.xAceleraView)
        
        yAceleraVisor = findViewById<TextView>(R.id.yAceleraView)
        
        zAceleraVisor = findViewById<TextView>(R.id.zAceleraView)
        

        xGyroVisor = findViewById<TextView>(R.id.idXGyro)
        yGyroVisor = findViewById<TextView>(R.id.idYGyro)
        zGyroVisor = findViewById<TextView>(R.id.idZGyro)

        proximity = findViewById<TextView>(R.id.idProximity)

        luzAmbientalVisor = findViewById<TextView>(R.id.idTemp)"
        
Basicamente todo lo que va después del "id." pues así tenemos que configurarlo, para que salga todo correcto y todo bien en el XML. Por ejemplo, si el TextView 1 se llama "textView" nosotros lo cambiaremos a "xAceleraView" porque es donde se verá reflejado el eje X del Acerelometro. Básico. 

 Luego definiremos un archivo de audio, que será el que usaremos cuando se produzcan dos eventos:
 
       1) La distancia hacia el sensor de proximidad es 0.
       
       2) La luminosidad es 150.
       
        
  Se define el media player en este caso asi:
        
        "  mediaPlayer = MediaPlayer.create(this,R.raw.miau)"
        
   Basicamente como en el apartado 2.
    Luego de esos vereis varias funciones del sensor Manager que es muy sencillo. Aunque parezca complejo, tranquilidad, os lo voy explicando paso por paso con el giroscopio:
        
        "
        var sensorManager: SensorManager = getSystemService(Context.SENSOR_SERVICE)
                as SensorManager"
        
        
        "    sensorManager.getDefaultSensor(Sensor.TYPE_GYROSCOPE)?.also{

            sensorManager.registerListener(
                this,
                it,
                SensorManager.SENSOR_DELAY_FASTEST,
                SensorManager.SENSOR_DELAY_FASTEST
            )
        }"
        
        
 Como vereis lo que hay que hacer es declarar un sensorManager primero, para indicar el objeto que se usará, que emulando lo que hicimos antes con el mediaplayer y el audio del sistema, será un servicio del sistema llamada "SENSOR_SERVICE" que sería los sensores del dispositivo, sin especificar, porque eso lo haremos ahora.
        
  Bien, luego viene el "sensorManger.getDeafult..." con eso lo que hacemos es definir nuestro sensorManager que actualmente no está especificado en un Giroscopio, de ahí el "TYPE_GYROSCOPE". Sencillo. 
        
 Al contiunuar vemos que de nuevo llamamos a nuestra variable ahora asignada como Giroscpio para realizar un "registerListener", bien esto es lo mismo que cuando se pulsa un boton y hacemos  un "setOnClickListener" pero al ser sensores no hay que pulsar nada, es automático. Dentro de esto especificamos que es en este dispositivo con el "this" y le decimos al sensor manager que el delay //(Retraso al coger datos)// sea el menor posible mediante el "SENSOR_DELAY_FASTEST"

Bien, este es el ejemplo de uno de ellos; sin embargo si os preguntais como se hace para que una sola variable sera capaz de ser tantos sensores a la vez es por el ".also" y por haberla protegido de cualquier crash con la "?".  Eso es al menos lo que he sacado en claro. 
        
   Total, en el código se siguen desarollando las funciones hasta que se terminan de definir los sensores, el último es "RELATIVE_HUMIDITY".
        
   Una vez alcanzados este punto veremos que tenemos una función llamada "fun macarena" que lo hará es simplemente reproducir el audio que queramos para los eventos que tenemos que programar para este ejercicio.
    
Ahora se viene lo interesante, tras la función macarena viene el como funciona este ejercicio, hasta ahora solo hemos seteado variables y hemos puesto cosas en su sitio, pero tenemos que hacer que todo funcione, sino simplemente no pasaría nada. Bien esto pasa gracias a la función gigante de:
        
        "   override fun onSensorChanged(event: SensorEvent?)"
        
      Esta función lo que te dice es que cuando un sensor cambie, pase algo, y dentro de esto pues hay varias que van definiendo cada uno de los sensores que tenemos.
      Ya que el primero es el acelerometro lo voy a coger y lo voy a explicar.
        

      " if(event?.sensor?.type == Sensor.TYPE_ACCELEROMETER) {

            var x_acel = event.values[0]
            var y_acel = event.values[1]
            var z_acel = event.values[2]
            xAceleraVisor.setText("x:"+x_acel)
            yAceleraVisor.setText("y:"+y_acel)
            zAceleraVisor.setText("z:"+z_acel)
""
 
 
 Bien, este es el comienzo de varios if´s, que es donde están desarollados los cambios. Como vereis hacemos 3 variables, las cuales son arrays de float. Esto se debe al "events.values[]" que lo que hace es darte la posición de lo que va pillando.
   
Simplemente ahora hacemos una llamada a nuestros TextView del XML y les decimos que pongan en su texto, los valores que aparezcan.  Y ya estaría, tenemos en nuestros 3 TextView los 3 valores. 
        
 En cuanto a la sintaxis del if, sencillo. "event?.sensor?.type" basicamente le decimos que nos diga el evento al que se somete el sensor del tipo en cuestión. Y que si es de tipo acelerometro pues que se ejecute. 
  Lo demás ya es seguir copiando y pegando, giroscopio lo mismo pero correspondiendo con sus textview, luminosidad lo mismo pero con solo 1.
        
        "On AccuracyChanged" funcion automatica generada cuando se implementa Sensor Event Listener
        
       Y por ultimo "onDestroy" pues que cuando se cierre la aplicación deje de tomar parametros. Al menos yo lo he visto así
       
  
        Y yastaría si habeis llegado hasta aquí leyendo y os ha servido, pues perfecto. 
    
        Ala, poco más, dudas en clase o al what´s si son prioritarias.

   

//DOCUMENTADO//
