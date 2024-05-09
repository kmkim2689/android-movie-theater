package woowacourse.movie.ui.reservation

import woowacourse.movie.model.data.DefaultMovieDataSource
import woowacourse.movie.model.movie.MovieContent
import woowacourse.movie.model.movie.MovieContentDao
import woowacourse.movie.model.movie.ReservationCount
import woowacourse.movie.model.movie.ReservationDetail
import woowacourse.movie.model.movie.SeatInformation
import woowacourse.movie.model.movie.ScreeningDate
import woowacourse.movie.model.movie.Theater
import woowacourse.movie.model.movie.TheaterDao
import woowacourse.movie.model.movie.TicketDao
import woowacourse.movie.model.movie.UserTicket
import woowacourse.movie.model.movie.toMovieContent
import woowacourse.movie.model.movie.toTheater
import woowacourse.movie.model.movie.toTicketEntity
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.LocalTime

class MovieReservationPresenter(
    private val view: MovieReservationContract.View,
    private val movieContentDataSource: MovieContentDao,
    private val theaterDataSource: TheaterDao,
) :
    MovieReservationContract.Presenter {
    private lateinit var reservationCount: ReservationCount
    private lateinit var screeningDate: ScreeningDate
    private lateinit var movieTime: LocalTime
    private lateinit var theater: Theater
    private lateinit var movieContent: MovieContent

    override fun updateReservationCount(count: Int) {
        reservationCount = ReservationCount(count)
        view.updateReservationCount(count)
    }

    override fun selectDate(date: LocalDate) {
        screeningDate = ScreeningDate(date)
    }

    override fun selectTime(time: LocalTime) {
        movieTime = time
    }

    override fun loadScreeningContent(
        movieContentId: Long,
        theaterId: Long,
    ) {
        Thread {
            try {
                movieContent = movieContentDataSource.find(movieContentId).toMovieContent()
                theater = theaterDataSource.find(theaterId).toTheater()
                view.showScreeningContent(movieContent, theater)
            } catch (e: NoSuchElementException) {
                view.showError(e)
            }
        }.start()
    }

    override fun decreaseCount() {
        reservationCount--
        view.updateReservationCount(reservationCount.count)
    }

    override fun increaseCount() {
        reservationCount++
        view.updateReservationCount(reservationCount.count)
    }

    override fun reserveSeat() {
        val reservationDetail =
            ReservationDetail(
                title = movieContent.title,
                theater = theater.name,
                screeningDateTime = LocalDateTime.of(screeningDate.date, movieTime),
                reservationCount.count,
            )
        view.moveMovieSeatSelectionPage(reservationDetail)
    }

    override fun handleError(throwable: Throwable) {
        view.showError(throwable)
    }
}
