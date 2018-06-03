package my.history.library.model

import org.springframework.data.cassandra.core.mapping.PrimaryKey
import org.springframework.data.cassandra.core.mapping.Table
import java.sql.*
import java.util.*
import javax.validation.constraints.NotBlank

/**
 * Cassandra
 * 分散型DBサーバ
 * 大規模分散管理とカラム型データ構造
 *
 * docker exec -it library_my-cassandra_1 cqlsh
 *
 * 1.SCHEMA生成 CREATE SCHEMA hr WITH replication = {'class':'SimpleStrategy','replication_factor':1};
 * 2.table作成 use hr;
 *            CREATE TABLE library(id text PRIMARY KEY, title text, explain text);
 *
 * 3.データ作成 INSERT INTO library(id, title, explain) VALUES ('1', 'kotlin', 'kotlin start book');
 */

@Table
data class Library (@PrimaryKey var id: String,
                    var title: String,
                    var explain: String)

data class LibraryDto (
                      @get:NotBlank val title: String,
                      @get:NotBlank val explain: String) {

    companion object {

        fun fromDto(dto:LibraryDto) =
                Library(UUID.randomUUID().toString()
                        , dto.title
                        , dto.explain
                )

        fun toDto(library:Library) =
                LibraryDto(
                    library.title
                    , library.explain
                )
    }

}

data class LibraryReq(@get:NotBlank val title: String,
                      @get:NotBlank val explain: String)
