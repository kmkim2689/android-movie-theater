package woowacourse.movie.ui.home.adapter

import androidx.recyclerview.widget.RecyclerView
import woowacourse.movie.databinding.ItemMovieContentBinding
import woowacourse.movie.model.movie.MovieContent
import woowacourse.movie.ui.ReservationButtonClickListener

class MovieViewHolder(
    private val binding: ItemMovieContentBinding,
    reservationButtonClickListener: ReservationButtonClickListener,
) : RecyclerView.ViewHolder(binding.root) {
    init {
        binding.onClickListener = reservationButtonClickListener
    }

    fun bind(movieContent: MovieContent) {
        binding.movieContent = movieContent
    }
}
