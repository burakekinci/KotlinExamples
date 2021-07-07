package com.example.sqlitepractise

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        try {
            //veritabanı oluştur
            val database = this.openOrCreateDatabase("UrunDB",Context.MODE_PRIVATE,null)
            database.execSQL("CREATE TABLE IF NOT EXISTS urunler (id INTEGER PRIMARY KEY,isim VARCHAR,fiyat INT)")

            //veri ekle
            //database.execSQL("INSERT INTO urunler (isim,fiyat) VALUES ('ayakkabi',100)")
            //database.execSQL("INSERT INTO urunler (isim,fiyat) VALUES ('elbise',130)")
            //database.execSQL("INSERT INTO urunler (isim,fiyat) VALUES ('pantolon',150)")
            //database.execSQL("INSERT INTO urunler (isim,fiyat) VALUES ('kazak',80)")

            //veri okuma önce cursor ile veri veritabanından çekilir
            val cursor = database.rawQuery("SELECT * FROM urunler",null)

            //ismi kazak olan
            //val cursor = database.rawQuery("SELECT * FROM urunler WHERE isim = 'kazak'",null)

            //ismi 'k' ile başlayan
            //val cursor = database.rawQuery("SELECT * FROM urunler WHERE isim LIKE 'k%'",null)

            //silme ve güncelleme
            database.execSQL("DELETE FROM urunler WHERE id=3")
            database.execSQL("UPDATE urunler SET fiyat=160 WHERE isim='elbise'")

            //çekilen veri print edilmeden önce ayrıştırılır
            val idColumnIndex = cursor.getColumnIndex("id")
            val isimColumnIndex = cursor.getColumnIndex("isim")
            val fiyatColumnIndex = cursor.getColumnIndex("fiyat")

            //print etme aşaması
            while(cursor.moveToNext()){
                println("ID : ${cursor.getInt(idColumnIndex)}")
                println("isim : ${cursor.getString(isimColumnIndex)}")
                println("fiyat : ${cursor.getInt(fiyatColumnIndex)}")
            }

        }catch (e : Exception){
            e.printStackTrace()
        }

    }
}