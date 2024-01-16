package com.example.iphonecalculatorfinal

import android.annotation.SuppressLint
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import kotlin.math.log

class MainActivity : AppCompatActivity() {
    //Semua logika dibuatkan pada satu file main dan tidak menggunakan konsep yang diluar course seperti mvc
    //Metode algoritma yang digunakan yaitu logika sederhana dengan metode sequential untuk melakukan proses perhitungan

    //Kekurangan dari aplikasi kalkulator ini yaitu belum mampu untuk memperlihatkan output angka lebih dari 5 digit
    //Kekurangan aplikasi ini juga tidak bisa menjadi horizontal dan aplikasi hanya dibuat untuk vertikal

    //Inisialisasi Log Tag (berfungsi untuk log pada logcat nanti saat running)
    private val TAG = "MainActivity"

    //Membuat variabel awal dari button-button (tidak menggunakan private <for simplication>)
    lateinit var one: Button
    lateinit var two: Button
    lateinit var three: Button
    lateinit var four: Button
    lateinit var five: Button
    lateinit var six: Button
    lateinit var seven: Button
    lateinit var eight: Button
    lateinit var nine: Button
    lateinit var zero: Button
    lateinit var ac: Button
    lateinit var plusMinus: Button
    lateinit var percent: Button
    lateinit var divide: Button
    lateinit var multiply: Button
    lateinit var minus: Button
    lateinit var plus: Button
    lateinit var equal: Button
    lateinit var coma: Button
    lateinit var primaryText: TextView

    //Pembuatan variabel untuk sound effect (bersifat optional) for fun only :)
    var mediaPlayer: MediaPlayer? = null


    //Membuat variabel list untuk menampung angka dan operator menggunakan MutableList
    //sumber kotlinlang.org
    var arithmetic: MutableList<Double> = mutableListOf()
    var operations: MutableList<String> = mutableListOf()

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d(TAG, "onCreate: Masuk Ke onCreate")
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        //Preload sound effect agar bisa langsung digunakan
        mediaPlayer = MediaPlayer.create(this, R.raw.iphone_click_cut);


        //Menyambungkan variabel yang dibuat sebelumnya ke id file xml
        one = findViewById(R.id.one)
        two = findViewById(R.id.two)
        three = findViewById(R.id.three)
        four = findViewById(R.id.four)
        five = findViewById(R.id.five)
        six = findViewById(R.id.six)
        seven = findViewById(R.id.seven)
        eight = findViewById(R.id.eight)
        nine = findViewById(R.id.nine)
        zero = findViewById(R.id.zero)
        ac = findViewById(R.id.ac)
        plusMinus = findViewById(R.id.plusMinus)
        percent = findViewById(R.id.percent)
        divide = findViewById(R.id.divide)
        multiply = findViewById(R.id.multiply)
        minus = findViewById(R.id.minus)
        plus = findViewById(R.id.plus)
        equal = findViewById(R.id.equal)
        coma = findViewById(R.id.coma)
        primaryText = findViewById(R.id.inputOutput)


        //membuat OnClickListener atau logika jika button di klik
        one.setOnClickListener {
            Log.d(TAG, "onCreate: b1")
            insertToInput("1")
            mediaPlay()
        }

        two.setOnClickListener {
            Log.d(TAG, "onCreate: b2")
            insertToInput("2")
            mediaPlay()
        }

        three.setOnClickListener {
            Log.d(TAG, "onCreate: b3")
            insertToInput("3")
            mediaPlay()
        }

        four.setOnClickListener {
            Log.d(TAG, "onCreate: b4")
            insertToInput("4")
            mediaPlay()
        }

        five.setOnClickListener {
            Log.d(TAG, "onCreate: b5")
            insertToInput("5")
            mediaPlay()
        }

        six.setOnClickListener {
            Log.d(TAG, "onCreate: b6")
            insertToInput("6")
            mediaPlay()
        }

        seven.setOnClickListener {
            Log.d(TAG, "onCreate: b7")
            insertToInput("7")
            mediaPlay()
        }

        eight.setOnClickListener {
            Log.d(TAG, "onCreate: b8")
            insertToInput("8")
            mediaPlay()
        }

        nine.setOnClickListener {
            Log.d(TAG, "onCreate: b9")
            insertToInput("9")
            mediaPlay()
        }

        zero.setOnClickListener {
            Log.d(TAG, "onCreate: b0")
            insertToInput("0")
            mediaPlay()
        }

        ac.setOnClickListener {
            Log.d(TAG, "onCreate: bac")
            primaryText.text = ""
            primaryText.setHint("0")
            mediaPlay()

        }

        coma.setOnClickListener {
            Log.d(TAG, "onCreate: bcoma")
            insertToInput(".")
            mediaPlay()
        }

        plus.setOnClickListener {
            //menambahkan value sebelum klik plus ke list arithmetic dan setelah itu clear inputan untuk melakukan operasi lain
            Log.d(TAG, "onCreate: bplus")
            mediaPlay()
            //Penambahan if else untuk menghindari aplikasi crash jika user tidak klik tombol angka dan langsung klik tombol operasi
            //Sehingga akan menyebabkan penambahan list nilai kosong/null dan itu tidak boleh
            if (primaryText.text.isNotEmpty()) {
                Log.d(TAG, "onCreate: primaryText Ada")
                val tempvalue = primaryText.text.toString().toDouble()
                arithmetic.add(tempvalue)
                operations.add("+")
                primaryText.setHint("")
                primaryText.text = ""
            } else {
                Log.d(TAG, "onCreate: primaryText Empty")
            }

        }

        minus.setOnClickListener {
            Log.d(TAG, "onCreate: bminus")
            mediaPlay()
            if (primaryText.text.isNotEmpty()) {
                Log.d(TAG, "onCreate: primaryText Ada")
                val tempvalue = primaryText.text.toString().toDouble()
                arithmetic.add(tempvalue)
                operations.add("-")
                primaryText.setHint("")
                primaryText.text = ""
            } else {
                Log.d(TAG, "onCreate: primaryText Empty")
            }

        }

        multiply.setOnClickListener {
            Log.d(TAG, "onCreate: bmultiply")
            mediaPlay()
            if (primaryText.text.isNotEmpty()) {
                Log.d(TAG, "onCreate: primaryText Ada")
                val tempvalue = primaryText.text.toString().toDouble()
                arithmetic.add(tempvalue)
                operations.add("*")
                primaryText.setHint("")
                primaryText.text = ""
            } else {
                Log.d(TAG, "onCreate: primaryText Empty")
            }

        }

        divide.setOnClickListener {
            Log.d(TAG, "onCreate: bdivide")
            mediaPlay()
            if (primaryText.text.isNotEmpty()) {
                Log.d(TAG, "onCreate: primaryText Ada")
                val tempvalue = primaryText.text.toString().toDouble()
                arithmetic.add(tempvalue)
                operations.add("/")
                primaryText.setHint("")
                primaryText.text = ""
            } else {
                Log.d(TAG, "onCreate: primaryText Empty")
            }

        }

        percent.setOnClickListener {
            Log.d(TAG, "onCreate: bpercent")
            mediaPlay()
            if (primaryText.text.isNotEmpty()) {
                Log.d(TAG, "onCreate: primaryText ada")
                val valueRightNow = primaryText.text.toString().toDouble()
                val percentResult = valueRightNow / 100.0
                primaryText.text = percentResult.toString()
                arithmetic.add(percentResult)
            } else {
                Log.d(TAG, "onCreate: primaryText Empty")

            }

        }

        plusMinus.setOnClickListener {
            //Untuk membuat angka saat ini menjadi bersifat + atau -
            Log.d(TAG, "onCreate: bplusMinus")
            mediaPlay()
            if (primaryText.text.isNotEmpty()) {
                Log.d(TAG, "onCreate: primaryText Ada")
                val valueRightNow = primaryText.text.toString().toDouble()
                val invertedValue = -valueRightNow
                val checkResultInv = if (invertedValue % 1 == 0.0) {
                    invertedValue.toInt().toString()
                } else {
                    invertedValue.toString()
                }
                primaryText.text = checkResultInv
                arithmetic.clear()
            } else {
                Log.d(TAG, "onCreate: primaryText Empty")
            }

        }


        //Disini logika untuk proses perhitungan dimulai!!!!!!!!!!!!
        equal.setOnClickListener {
            Log.d(TAG, "onCreate: bequal")
            mediaPlay()
            //logika jika mengklik tombol sama dengan (=)
            if (primaryText.text.isNotEmpty()) {
                Log.d(TAG, "onCreate: primaryText Ada")
                val lastArithmetic = primaryText.text.toString().toDouble()
                arithmetic.add(lastArithmetic)

                var tempresult = arithmetic[0]
                //Menambahkan log untuk cek isian dalam list
                Log.d(
                    TAG,
                    "onCreate: sebelum loop: tempresult=$tempresult,arithmetic=$arithmetic, operations=$operations"
                )
                //Melakukan pengulangan sesuai dengan ukuran list operations
                for (i in 0 until operations.size) {
                    Log.d(TAG, "onCreate: memasuki pengulangan")
                    when (operations[i]) {
                        "+" -> tempresult += arithmetic[i + 1]
                        "-" -> tempresult -= arithmetic[i + 1]
                        "*" -> tempresult *= arithmetic[i + 1]
                        "/" -> {
                            if (arithmetic[i + 1] != 0.0) {
                                tempresult /= arithmetic[i + 1]
                            } else {
                                //Jika user melakukan pembagian dengan 0 maka hasil yang tertampil akan 0
                                Log.d(TAG, "onCreate: Memasuki else dari pembagian")
                                tempresult = 0.0
                                primaryText.text = tempresult.toInt().toString()
                            }
                        }
                    }
                }
                //Menambahkan log untuk cek isian dalam list
                Log.d(
                    TAG,
                    "onCreate: sesudah loop: tempresult=$tempresult,arithmetic=$arithmetic, operations=$operations"
                )

                //Logika untuk cek ulang jika saat klik tombol sama dengan, operations kosong maka logika
                //ini berjalan (tidak berpengaruh pada logika manapun karena hanya ngecek saja) bersifat optional
                if (operations.isEmpty()) {
                    tempresult += lastArithmetic
                }

                //Logika untuk cek apakah hasil dari perhitungan merupakan bilangan bulat atau decimal,
                //Jika decimal maka tampilkan, tetapi jika bulat maka tempresult akan diubah menjadi integer
                //!Pengingat bahwa nilai awal tempresult adalah double, dan logika ini bersifat optional
                val checkResult = if (tempresult % 1 == 0.0) {
                    tempresult.toInt().toString()
                } else {
                    tempresult.toString()
                }

                //Tampilkan kepada user hasilnya
                //!Pengingat Ganti checkResult jika logika pengecekan hasil bulat atau decimal dihapus maka menjadi tempresult!
                primaryText.text = checkResult
                arithmetic.clear()
                operations.clear()
            } else {
                Log.d(TAG, "onCreate: PrimaryText Empty")
            }
        }
    }


    //function-function

    //function untuk menambahkan value ke primaryText(inputOutput xml) + melakukan pengecekan untuk
    //tanda koma apakah ada atau tidak di dalam primaryText
    fun insertToInput(value: String) {
        if (!(value == "." && primaryText.text.contains("."))) {
            primaryText.append(value)
        }
    }

    //Function yang berfungsi untuk menghandle sound effect saat button di click
    //Dari website codersguidebook.com
    fun mediaPlay() {
        if (mediaPlayer != null) {
            mediaPlayer!!.seekTo(0);
            mediaPlayer!!.start();
        }
    }
}