package woowacourse.movie.ui.home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.setFragmentResultListener
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import woowacourse.movie.R
import woowacourse.movie.databinding.FragmentTheaterSelectionBottomSheetBinding
import woowacourse.movie.model.data.MovieContentsImpl
import woowacourse.movie.model.data.TheatersImpl
import woowacourse.movie.model.movie.Theater
import woowacourse.movie.ui.home.adapter.TheaterAdapter
import woowacourse.movie.ui.reservation.MovieReservationActivity

class TheaterSelectionBottomSheetFragment :
    BottomSheetDialogFragment(),
    TheaterSelectionContract.View {
    private lateinit var binding: FragmentTheaterSelectionBottomSheetBinding
    private lateinit var adapter: TheaterAdapter
    private val presenter: TheaterSelectionPresenter by lazy {
        TheaterSelectionPresenter(
            this,
            MovieContentsImpl,
            TheatersImpl,
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentTheaterSelectionBottomSheetBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(
        view: View,
        savedInstanceState: Bundle?,
    ) {
        super.onViewCreated(view, savedInstanceState)
        setFragmentResultListener(MovieHomeKey.FRAGMENT_REQUEST_KEY) { _, bundle ->
            presenter.loadTheaters(
                bundle.getLong(MovieHomeKey.MOVIE_CONTENT_ID),
            )
        }
    }

    override fun showTheaters(
        movieContentId: Long,
        theaters: List<Theater>,
    ) {
        adapter =
            TheaterAdapter(theaters) { theaterId ->
                Intent(requireContext(), MovieReservationActivity::class.java).apply {
                    putExtra(MovieHomeKey.MOVIE_CONTENT_ID, movieContentId)
                    putExtra(MovieHomeKey.THEATER_ID, theaterId)
                    startActivity(this)
                }
            }
        binding.theaterList.adapter = adapter
    }

    override fun navigateToMovieReservation(
        movieContentId: Long,
        theaterId: Long,
    ) {
        Intent(requireContext(), MovieReservationActivity::class.java).apply {
            putExtra(MovieHomeKey.MOVIE_CONTENT_ID, movieContentId)
            putExtra(MovieHomeKey.THEATER_ID, theaterId)
            startActivity(this)
        }
    }

    override fun dismissDialog() {
        val context = requireContext()
        Toast.makeText(
            context,
            context.getString(R.string.toast_invalid_key),
            Toast.LENGTH_SHORT,
        ).show()
        dismiss()
    }
}
