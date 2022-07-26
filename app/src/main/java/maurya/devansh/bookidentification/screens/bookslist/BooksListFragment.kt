package maurya.devansh.bookidentification.screens.bookslist


import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import kotlinx.android.synthetic.main.fragment_books_list.view.*
import maurya.devansh.bookidentification.MainActivity
import maurya.devansh.bookidentification.R
import maurya.devansh.bookidentification.consts.GoogleBooksVolumesConsts
import maurya.devansh.bookidentification.extensions.getAuthorsListAsString
import maurya.devansh.bookidentification.extensions.getSmallThumbnailImageUrl
import maurya.devansh.bookidentification.extensions.getSubtitle
import maurya.devansh.bookidentification.extensions.getTitle
import maurya.devansh.bookidentification.model.BooksListItem
import org.json.JSONArray
import org.json.JSONObject
import java.net.URLEncoder

class BooksListFragment : Fragment(), OnBookItemSelectedListener {

    private val args: BooksListFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_books_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        (activity as MainActivity).supportActionBar?.show()

        val queue = Volley.newRequestQueue(context)
        val url = "https://www.googleapis.com/books/v1/volumes?q=" + URLEncoder.encode(args.queryString) +
                "&projection=lite" + "&maxResults=3"

        val jsonObjectRequest = JsonObjectRequest(
            Request.Method.GET, url, null,
            Response.Listener {
                Log.d("url", url)
                Log.d("Response", it.toString())

                val booksList = arrayListOf<BooksListItem>()

                if (it["totalItems"] as Int > 0) {
                    val items = it["items"] as JSONArray

                    for (i in 0 until items.length()) {
                        val bookListItem = makeBookListItemObject(items[i] as JSONObject)
                        booksList.add(bookListItem)
                    }

                    view.animationView.pauseAnimation()
                    view.animationView.visibility = View.GONE

                    setUpRecyclerView(view.recyclerView, booksList)
                } else {
                    noBooksFound(view)
                }
            },
            Response.ErrorListener {
                Log.d("Error", "Error")
                noBooksFound(view)
            })

        queue.add(jsonObjectRequest)

    }

    override fun onBookItemSelected(bookVolume: String) {
        val action = BooksListFragmentDirections.actionBookSelected(bookVolume)
        findNavController().navigate(action)
    }

    private fun setUpRecyclerView(recyclerView: RecyclerView, booksList: List<BooksListItem>) {
        recyclerView.apply {
            layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
            adapter = BooksListAdapter(booksList, this@BooksListFragment)
        }
    }

    private fun makeBookListItemObject(item: JSONObject): BooksListItem {
        val bookListItem = BooksListItem()

        bookListItem.apply {
            id = item[GoogleBooksVolumesConsts.ID] as String
            title = item.getTitle()
            subtitle = item.getSubtitle()
            authors = item.getAuthorsListAsString()
            smallThumbnailUrl = item.getSmallThumbnailImageUrl()
        }

        return bookListItem
    }

    private fun noBooksFound(view: View) {
        view.animationView.pauseAnimation()
        view.animationView.visibility = View.GONE
        findNavController().navigate(R.id.action_noResultsFound)
    }
}