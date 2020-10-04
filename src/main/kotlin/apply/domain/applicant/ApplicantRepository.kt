package apply.domain.applicant

import org.springframework.data.jpa.repository.JpaRepository
import java.time.LocalDate

interface ApplicantRepository : JpaRepository<Applicant, Long> {
    fun findByNameContainingOrEmailContaining(name: String, email: String): List<Applicant>

    fun findByEmail(email: String): Applicant?

    fun existsByNameAndEmailAndBirthdayAndPassword(
        name: String,
        email: String,
        birthDay: LocalDate,
        password: String
    ): Boolean
}