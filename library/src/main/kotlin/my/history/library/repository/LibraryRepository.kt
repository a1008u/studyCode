package my.history.library.repository

import my.history.library.model.Library
import org.springframework.data.cassandra.repository.ReactiveCassandraRepository
import org.springframework.stereotype.Repository

@Repository
interface LibraryRepository: ReactiveCassandraRepository<Library, String> {

}
