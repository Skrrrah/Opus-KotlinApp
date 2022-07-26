package maurya.devansh.bookidentification

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar) }

    override fun onSupportNavigateUp() = findNavController(R.id.navHostFragment).navigateUp()

    override fun onBackPressed() {
        val navController = findNavController(R.id.navHostFragment)
        when(navController.currentDestination?.id) {
            R.id.booksListFragment -> navController.navigate(
                    R.id.action_booksListFragment_to_scanOptionsFragment)

            R.id.noResultsFoundFragment -> navController.navigate(
                    R.id.action_noResultsFoundFragment_to_scanOptionsFragment)

            else -> super.onBackPressed()
        }

    }
}
