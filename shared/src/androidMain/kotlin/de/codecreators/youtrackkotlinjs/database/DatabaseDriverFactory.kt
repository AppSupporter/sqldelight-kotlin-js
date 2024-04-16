package de.codecreators.youtrackkotlinjs.database

import android.annotation.SuppressLint
import android.content.Context
import app.cash.sqldelight.async.coroutines.synchronous
import app.cash.sqldelight.db.QueryResult
import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.db.SqlSchema
import app.cash.sqldelight.driver.android.AndroidSqliteDriver

actual class DatabaseDriverFactory {
    companion object {
        @SuppressLint("StaticFieldLeak")
        lateinit var context: Context

        fun initialize(context: Context) {
            if(!this::context.isInitialized) {
                this.context = context
            }
        }
    }

    actual suspend fun createDriver(schema: SqlSchema<QueryResult.AsyncValue<Unit>>): SqlDriver {
        return AndroidSqliteDriver(schema.synchronous(), context, "test.db")
    }
}