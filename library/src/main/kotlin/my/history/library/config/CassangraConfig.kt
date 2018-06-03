package my.history.library.config

import org.springframework.context.annotation.Configuration
import org.springframework.data.cassandra.config.AbstractCassandraConfiguration
import org.springframework.data.cassandra.repository.config.EnableReactiveCassandraRepositories

@Configuration
@EnableReactiveCassandraRepositories
class CassandraConfig: AbstractCassandraConfiguration() {

    override fun getKeyspaceName() = "hr"

    override fun getContactPoints() = "localhost"

    override fun getEntityBasePackages() = arrayOf("my.history.library.model")
}