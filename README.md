<p align="center">
  <img src="app/src/main/opus.png"  width="300" height="400">
  <h1 align="center">Opus</h1>
</p>

#### Aplikasi Android yang berguna untuk mencari informasi buku dengan melakukan pemindaian dari sampul ataupun barcodenya.

## Bagaimana Opus bekerja?

* Opus menggunakan **Firebase ML Kit Text Recognition API** untuk mengenali teks dari gambar yang sudah dipindai oleh scanner
* Teks diekstrak dari gambar lalu difilter agar sesuai dengan pencarian
* Teks yang telah difilter digunakan untuk melakukan pemanggilan GET ke **Google Books API** & menampilkan daftar buku yang relevan dengan pencarian
* Pengguna akan mengeklik buku pada daftar yang sesuai dengan pencarian


## Tech Stack yang digunakan

* **Kotlin** sebagai bahasa utama
* **MVVM** architecture pattern menggunakan Android Architecture Components
* **LiveData, ViewModel**
* **Navigation Components** untuk navigasi yang disederhanakan
* **CameraKit** untuk fungsi kamera
* **Firebase ML Kit Text Recognition API** ekstrator dari gambar ke teks
* **Glide** image loading library
* **Volley** networking library untuk permintaan jaringan
* **Lottie** penambahan animasi

## Dikembangkan Oleh
* 42620001 Miftahul Khairi Tawil
* 42620004 Annisa Resky Ramadhani
* 42620018 Syamara Taufiq
**Politeknik Negeri Ujung Pandang - Teknik Multimedia & Jaringan**
