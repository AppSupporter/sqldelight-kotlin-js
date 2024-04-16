package de.codecreators.youtrackkotlinjs

import app.cash.sqldelight.db.SqlDriver
import de.codecreators.youtrackkotlinjs.database.DatabaseDriverFactory
import de.codecreators.youtrackkotlinjs.database.DatabaseHandler
import de.codecreators.youtrackotlinjs.Test
import de.codecreators.youtrackotlinjs.TestDB
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.promise
import kotlin.js.Promise

@OptIn(ExperimentalJsExport::class)
@JsExport
class DatabaseTest private constructor(
    val handler: DatabaseHandler
) {
    companion object {
        private lateinit var driver: SqlDriver
        private lateinit var instance: DatabaseTest

        @OptIn(DelicateCoroutinesApi::class)
        fun initDatabase(): Promise<Unit> = GlobalScope.promise {
            driver = DatabaseDriverFactory().createDriver(TestDB.Schema)
        }

        fun getInstance(): DatabaseTest {
            if(!this::instance.isInitialized) {
                instance = DatabaseTest(
                    handler = DatabaseHandler(TestDB(driver))
                )
            }
            return instance
        }
    }

    @OptIn(DelicateCoroutinesApi::class)
    fun addTest(text: String): Promise<Unit> = GlobalScope.promise {
        handler.getDbQuery().insertTest(text)
    }

    fun getTests(): Array<Test> {
        return handler.getDbQuery().getTest().executeAsList().toTypedArray()
    }

}