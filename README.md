<p align="center">
  <img src="app/src/main/opus.png"  width="300" height="300">
  <h1 align="center">Opus</h1>
</p>

#### Aplikasi Android yang berguna untuk mencari informasi buku dengan melakukan pemindaian dari sampul ataupun barcodenya.

## Bagaimana Opus bekerja?

* Opus menggunakan Firebase **ML Kit’s Text Recognition API** untuk mengenali teks dari gambar yang didapat scanner
* Teks diekstrak dari gambar lalu difilter agar sesuai dengan pencarian
* Teks yang telah difilter digunakan untuk membuat pemanggilan GET ke **Google Books API** untuk mendapatkan daftar buku yang relevan
* Pengguna akan mengeklik pada daftar yang sesuai dengan pencarian


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
