package be.bxl.formation.mynextgame.Db

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import be.bxl.formation.mynextgame.Db.DbInfo


class DbHelper  // Appel du constructeur parent avec tout les infos necessaire
    (context: Context?) : SQLiteOpenHelper(context, DbInfo.DB_NAME, null, DbInfo.DB_VERSION) {
    // Méthode appelé automatiquement si l'app ne contient pas la base de donnée
    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL(DbInfo.Game.REQUEST_CREATE)
       db.execSQL("INSERT INTO game_favourite VALUES('616651','Free Guy','v1VuHHdYaZJnsHBAHm7RnzgjcTd.jpg','2021-07-29')")
    }

    // Méthode appelé automatiquement si l'app  contient une version précédente de la base de donnée
    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        // Pour la mise a jour de la DB, solution simple => On detruit et on recrée
        db.execSQL(DbInfo.Game.REQUEST_DELETE)
        onCreate(db)

    }
}