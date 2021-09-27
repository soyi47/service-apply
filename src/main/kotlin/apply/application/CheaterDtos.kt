package apply.application

import apply.domain.applicant.Applicant
import apply.domain.cheater.Cheater
import java.time.LocalDateTime
import javax.validation.constraints.Email
import javax.validation.constraints.NotNull

data class CheaterData(
    @field:NotNull
    @field:Email
    var email: String = "",

    var description: String = ""
)

data class CheaterResponse(
    val id: Long,
    val createdDateTime: LocalDateTime,
    val description: String,
    val email: String,
    val name: String?
) {
    constructor(cheater: Cheater, applicant: Applicant?) : this(
        cheater.id,
        cheater.createdDateTime,
        cheater.description,
        cheater.email,
        applicant?.name
    )
}