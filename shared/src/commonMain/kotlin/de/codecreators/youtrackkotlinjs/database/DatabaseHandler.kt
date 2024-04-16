package de.codecreators.youtrackkotlinjs.database

import de.codecreators.youtrackotlinjs.TestDB
import de.codecreators.youtrackotlinjs.TestDBQueries

class DatabaseHandler(private val database: TestDB) {

    fun getDbQuery(): TestDBQueries {
        return database.testDBQueries
    }
}