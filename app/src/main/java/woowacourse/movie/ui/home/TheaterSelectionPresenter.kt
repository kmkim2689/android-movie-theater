package woowacourse.movie.ui.home

import woowacourse.movie.model.movie.MovieContent
import woowacourse.movie.model.movie.MovieContentDao
import woowacourse.movie.model.movie.TheaterDao
import woowacourse.movie.model.movie.toMovieContent
import woowacourse.movie.model.movie.toTheater
import kotlin.concurrent.thread

class TheaterSelectionPresenter(
    private val view: TheaterSelectionContract.View,
    private val movieContentDataSource: MovieContentDao,
    private val theaterDataSource: TheaterDao,
) :
    TheaterSelectionContract.Presenter {
    private lateinit var movieContent: MovieContent

    override fun loadTheaters(movieContentId: Long) {
        thread {
            runCatching {
                movieContent = movieContentDataSource.find(movieContentId).toMovieContent()
                val movieTheaters =
                    movieContent.theaterIds.map { theaterId ->
                        val theater = theaterDataSource.find(theaterId).toTheater()
                        theater
                    }
                view.showTheaters(movieContentId, movieTheaters)
            }.onFailure {
                view.showError(it)
            }
        }
    }
}
