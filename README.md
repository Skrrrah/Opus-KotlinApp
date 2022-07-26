<p align="center">
  <img src="/app/src/main/ic_launcher-web.png"  width="300" height="300">
  <h1 align="center">PukaPuka</h1>
</p>

#### An Android app that helps to get information about any book by either scanning its cover. PukaPuka comes from the Maori word for ‘Book’.
#### The app was also an example to showcase the various design patterns used in an Android app.


#### [Checkout the presentation](https://www.slideshare.net/DevanshMaurya/pukapuka-presentation)
#### [Detailed Report (PDF)](https://drive.google.com/open?id=1C2GzC1R36ZzM7iOpnSlr0cWrwtR1iE9d)

## How it works?
* The app uses Firebase **ML Kit’s Text Recognition API** to recognize text from the image captured using device camera.
* The text extracted from the image is then filtered to remove unwanted information.
* The filtered text is then used to make a GET request to **Google Books API** to get a list of relevant books.
* The user can then click on an image that suits best with the scanned book cover and get information about it.

## Screenshots
| Home Screen  | Scanning the book |
| ------------- | ------------- |
| ![](https://github.com/Devansh-Maurya/PukaPuka/blob/master/screenshots/home.png)  | ![](https://github.com/Devansh-Maurya/PukaPuka/blob/master/screenshots/book_scanning.png)  |

| Matching books list  | Book details |
| ------------- | ------------- |
| ![](https://github.com/Devansh-Maurya/PukaPuka/blob/master/screenshots/books_list.png)  | ![](https://github.com/Devansh-Maurya/PukaPuka/blob/master/screenshots/book_details.png)  |

## Technologies Used

* **Kotlin** as the main programming language
* **MVVM** architecture pattern using the Android Architecture Components
* **LiveData, ViewModel**
* **Navigation Components** for simplified navigations
* **CameraKit** for using camera functionalities
* **Firebase ML Kit Text Recognition API** for extracting text from the image
* **Glide** image loading library
* **Volley** networking library for making network requests
* **Lottie** for adding animations
