package com.example.recycleview

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

/**
 * Created by Tubianto on 04/01/2021.
 */
class MainActivity : AppCompatActivity() {
    private lateinit var rvItem: RecyclerView
    private lateinit var adapter: RvAdapter
    private var dataItems = arrayListOf<DataItem>(
        DataItem("https://assets.pikiran-rakyat.com/crop/0x0:0x0/750x500/photo/2019/06/JIbxuiMk8pNBS5rDJiO1RRYQikzh7SVjOutaBFCx.jpeg","Tempat Wisata Taman Kuning,Kuningan Jawa Barat","JUNI 25, 2022","https://www.google.com/search?q=wisata+taman+kuning+jawa+barat&sca_esv=588643820&rlz=1C1ONGR_enID1061ID1061&sxsrf=AM9HkKmHyMWivY2Fa4iPGdD8wV5j3sPu6A%3A1701934463468&ei=f3VxZZ6JHN-SseMP85u1wAw&oq=wisata+taman+kuning&gs_lp=Egxnd3Mtd2l6LXNlcnAiE3dpc2F0YSB0YW1hbiBrdW5pbmcqAggCMgUQABiABDIFEAAYgAQyBhAAGBYYHjIGEAAYFhgeMgYQABgWGB4yBhAAGBYYHjIGEAAYFhgeMgYQABgWGB4yBhAAGBYYHjIGEAAYFhgeSJSgA1CyIVjdjgNwEXgBkAEBmAGoBaABj0mqAQwwLjguMTAuNC41LjO4AQPIAQD4AQGoAhHCAgoQABhHGNYEGLADwgIHECMY6gIYJ8ICHBAuGEMYnQMYqAMYgAQYigUYyAMY6gIYtALYAQHCAiIQLhiABBiKBRhDGMcBGK8BGKYDGKgDGMgDGOoCGLQC2AEBwgIlEC4YgAQYigUYQxjHARivARiYBRimAxioAxjIAxjqAhi0AtgBAcICChAjGIAEGIoFGCfCAgsQABiABBixAxiDAcICFxAuGIAEGLEDGIMBGMcBGNEDGNIDGKgDwgIKEAAYgAQYigUYQ8ICGRAuGIAEGIoFGEMYxwEYrwEYpgMYqAMYjgXCAhYQLhiABBiKBRhDGMcBGK8BGKYDGKgDwgIXEC4YgAQYsQMYgwEYxwEYrwEYqAMYpgPCAg4QABiABBiKBRixAxiDAcICCBAAGIAEGJIDwgIIEAAYgAQYsQPCAhkQLhiABBiKBRhDGMcBGK8BGKgDGKYDGI4FwgINEAAYgAQYsQMYgwEYCsICCxAAGIAEGLEDGMkDwgILEAAYgAQYigUYsQPCAhQQLhiABBjHARivARioAximAxiOBcICERAuGIAEGMcBGK8BGKYDGKgDwgIUEC4YgAQYxwEYrwEYpgMYqAMYjgXCAhEQLhiABBjHARivARioAximA8ICIBAuGIAEGMcBGK8BGKYDGKgDGJcFGNwEGN4EGOAE2AECwgILEC4YgAQYqAMYnQPCAgsQLhiABBidAxioA8ICERAuGIAEGLEDGKgDGJ0DGKIFwgIREC4YrwEYxwEYpgMYqAMYgATCAhcQLhiABBjHARivARiYBRiZBRioAximA8ICIxAuGIAEGMcBGK8BGKgDGKYDGI4FGJcFGNwEGN4EGOAE2AECwgIjEC4YgAQYxwEYrwEYpgMYqAMYjgUYlwUY3AQY3gQY4ATYAQLCAgsQLhidAxioAxiABMICFBAuGK8BGMcBGKYDGKgDGIAEGI4FwgIjEC4YrwEYxwEYpgMYqAMYgAQYjgUYlwUY3AQY3gQY4ATYAQLCAgsQABiABBiKBRiSA8ICCBAAGIAEGMsBwgIIEAAYFhgeGA_iAwQYACBBiAYBkAYIugYGCAEQARgIugYGCAIQARgU&sclient=gws-wiz-serp/"),
        DataItem("https://rumahjabodetabek.id/wp-content/uploads/2021/12/Untitled-1.jpg","Woddland Kuningan,Jawabarat","JULI 22, 2023","https://travel.kompas.com/read/2023/07/03/084047727/woodland-kuningan-harga-tiket-dan-aktivitasnya?page=all/"),
        DataItem("https://blogger.googleusercontent.com/img/b/R29vZ2xl/AVvXsEhV0tnwy-4GuoJr8SjRSxERRwDRlXaNUhZH2SqK0scnrKweysl38qBobdLrHimrs_L_AVcegqnygQoaKuIkbfqxctTEnwwp_YNpm3RuU-j14WUDErdE_nJ46PVEYjUkWRuck-UYQpQ3o5SlSO9Xx_-n6Lno9aaM5T9imhpOdMcUXu5SFYEyZEUUJIPD/s16000/ambience%20kopi%20botanika%20kuningan.jpg","Botanika Kuningan Jawa Barat","JUNI 21, 2021","https://www.budhalhealing.com/2023/05/kopi-botanika-kuningan-daya-tarik-harga.html/"),
        DataItem("https://mediatani.co/wp-content/uploads/2021/05/Telaga-Cicerem.jpg","Telaga Nilam Kuningan Jawabarat","OKTOBER 07, 2022","https://www.okocenews.com/travel/4208919384/review-wisata-telaga-nilam/"),
        DataItem("https://s.kaskus.id/images/2016/02/12/8496093_20160212102444.jpg","Taman Kota Kuningan,JawaBarat","MEI 24, 2023","https://kumparan.com/ciremaitoday/taman-kota-kuningan-jadi-alternatif-wisata-murah-sambil-kulineran-1xzTQ6yyd5f/"),
        DataItem("https://4.bp.blogspot.com/-nhW81FjmqOI/VlVbdJ1E8pI/AAAAAAAAAEM/r2IBssnkidU/s1600/maxresdefault.jpg","Taman Nasional Gunung Ciremai,Kuningan JawaBarat","JANUARI 17, 2021","https://www.google.com/search?sca_esv=588643820&rlz=1C1ONGR_enID1061ID1061&sxsrf=AM9HkKkBHmVsq6VDO7ciODLysfbr_I0jeA:1701936431609&q=Taman+Nasional+Gunung+Ciremai&stick=H4sIAAAAAAAAAONgFuLUz9U3SE82r7BQ4gIxjZNTyowytBSzk630c_KTE0sy8_PgDKvEkpKixGQQs3gRq2xIYm5inoJfYjGQn5ij4F6aV5qXruCcWZSam5gJAFvgxNtcAAAA&sa=X&ved=2ahUKEwiUnb6j7_yCAxVyyzgGHcXdAOkQ2coHegQIDBAB&biw=1536&bih=738&dpr=1.25/"),
        DataItem("https://blogger.googleusercontent.com/img/b/R29vZ2xl/AVvXsEh21FbeGjmSg_76y7qdTcFJImVUgGX-exTe5flXDICHVZ_ne8_C3MTdqCZbU_mAtuHRfQF-Lk25WXWSxyguhTapMTmLB-8D0yiVBG2Gpdo3L3_uZ7QWzMtyQ8CPs_yQSZO2CeNoLZqPUZ-IGKU8Q8SeWo-ZRdog58OufW_kjs7AoFUQGUPa5sHZqsnoYw/s720/WhatsApp%20Image%202022-09-15%20at%2021.56.38.jpeg","Arunika Eatry,Kuningan JawaBarat","NOVEMBER 15, 2023","https://www.jajandolan.com/2022/09/arunika-eatery-kuningan-lokasi-dan-menu.html/"),
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        init()
        setupUI()
    }

    private fun init() {
        rvItem = findViewById(R.id.rv_item)
        rvItem.layoutManager = LinearLayoutManager(this)
        adapter = RvAdapter(this, arrayListOf())
        rvItem.adapter = adapter
    }

    private fun setupUI() {
        getData()
    }

    private fun getData() {
        retrieveList(dataItems)
    }

    private fun retrieveList(items: List<DataItem>) {
        adapter.apply {
            addItems(items)
            notifyDataSetChanged()
        }
    }
}