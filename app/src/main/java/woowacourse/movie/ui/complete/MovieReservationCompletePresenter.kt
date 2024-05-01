package woowacourse.movie.ui.complete

import woowacourse.movie.model.data.UserTickets
import woowacourse.movie.model.movie.UserTicket

class MovieReservationCompletePresenter(
    private val view: MovieReservationCompleteContract.View,
    private val userTickets: UserTickets,
) :
    MovieReservationCompleteContract.Presenter {
    lateinit var userTicket: UserTicket
        private set

    override fun loadTicket(ticketId: Long) {
        try {
            userTicket = userTickets.find(ticketId)
        } catch (e: NoSuchElementException) {
            view.showError(e)
        }
    }

    override fun handleError(throwable: Throwable) {
        view.showError(throwable)
    }
}
