package be.bxl.formation.mynextgame.Db

object DbInfo {
    const val DB_NAME = "my_db"
    const val DB_VERSION = 1

    object Game {
        // Nom de la table
        const val TABLE_NAME = "game_favourite"

        // Nom des colonnes
        const val COLUMN_ID = "_id"
        const val COLUMN_IDMOVIE = "id"
        const val COLUMN_NAME = "title"
        const val COLUMN_PATH = "poster_path"
        const val COLUMN_RELEASE= "release_date"

        // Requetes (DDL)
        const val REQUEST_CREATE = ("CREATE TABLE " + Game.TABLE_NAME + " ( "
                + Game.COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + Game.COLUMN_IDMOVIE + " TEXT NOT NULL, "
                + Game.COLUMN_NAME + " TEXT NOT NULL, "
                + Game.COLUMN_PATH + " TEXT, "
                + Game.COLUMN_RELEASE + " TEXT NOT NULL "
                + ");")
        const val REQUEST_DELETE = "DROP TABLE " + TABLE_NAME + ";"
    }
}