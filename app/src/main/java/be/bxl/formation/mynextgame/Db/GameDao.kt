package be.bxl.formation.mynextgame.Db

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import be.bxl.formation.mynextgame.Db.DbInfo
import be.bxl.formation.mynextgame.models.Game
import be.bxl.formation.mynextgame.Db.DbHelper

import java.util.*


// Couche d'abstraction entre le modele et la base de donnée SQLite
//  Définition des méthodes d'interaction avec la Database (Connexion & CRUD)
class GameDao     //endregion
//region Constructeur
    (  //region Champs
    private val context: Context
) {
    private var dbHelper: DbHelper? = null
    private var db: SQLiteDatabase? = null

    //endregion
    //region Méthode de connexion
    fun openWritable(): GameDao {
        dbHelper = DbHelper(context)
        db = dbHelper!!.writableDatabase
        return this
    }

    fun openReadable(): GameDao {
        dbHelper = DbHelper(context)
        db = dbHelper!!.readableDatabase
        return this
    }

    fun close() {
        db!!.close()
        dbHelper!!.close()
    }


    //Méthode CRUD
    private fun cursorToProduct(c: Cursor): Game {
        // Permet de convertir les données du curseur en "Game" sur base du nom des colonnes.
        val idMovie = c.getString(c.getColumnIndex(DbInfo.Game.COLUMN_IDMOVIE))
        val title = c.getString(c.getColumnIndex(DbInfo.Game.COLUMN_NAME))
        val poster = c.getString(c.getColumnIndex(DbInfo.Game.COLUMN_PATH))
        val release = c.getString(c.getColumnIndex(DbInfo.Game.COLUMN_RELEASE))

        return Game(idMovie, title, poster, release)
    }

    private fun createCV(game: Game): ContentValues {
        // Permet de convertir un Game en "ContentValues" pour utiliser les données lors d'un insert ou update
        val cv = ContentValues()
        cv.put(DbInfo.Game.COLUMN_IDMOVIE, game.id)
        cv.put(DbInfo.Game.COLUMN_NAME, game.title)
        cv.put(DbInfo.Game.COLUMN_PATH,game.poster)
        cv.put(DbInfo.Game.COLUMN_RELEASE, game.release)
        return cv
    }

    // Create
    fun insert(game: Game): Long {
        val cv = createCV(game)
        return db!!.insert(DbInfo.Game.TABLE_NAME, null, cv)
    }

    // Read
    fun getById(id: String): Game? {
        val cursor = db!!.query(
            DbInfo.Game.TABLE_NAME,
            null, DbInfo.Game.COLUMN_ID.toString() + " = ?", arrayOf(id.toString()),
            null,
            null,
            null
        )

        // Sipas de résultat
        if (cursor.count == 0) {
            return null
        }

        // Place le cursor sur l'element trouvé
        cursor.moveToFirst()

        // Renvoie le produit extrait du curseur
        return cursorToProduct(cursor)
    }

    val all: List<Any>
        get() {
            val cursor = db!!.query(DbInfo.Game.TABLE_NAME, null, null, null, null, null, null)
            val games: MutableList<Game> = ArrayList<Game>()
            if (cursor.count == 0) {
                return games
            }
            cursor.moveToFirst()
            while (!cursor.isAfterLast) {
                val p: Game = cursorToProduct(cursor)
                games.add(p)
                cursor.moveToNext()
            }
            return games
        }

    // Update
    fun update(id: String, game: Game): Boolean {
        val cv = createCV(game)
        val nbRow = db!!.update(
            DbInfo.Game.TABLE_NAME,
            cv,
            DbInfo.Game.COLUMN_ID.toString() + " = ?",
            arrayOf(id.toString())
        )
        return nbRow == 1
    }

    // Delete
    fun delete(id: String): Boolean {
        // -> "DELETE FROM product WHERE _id = " + id;
        val nbRow = db!!.delete(
            DbInfo.Game.TABLE_NAME,
            DbInfo.Game.COLUMN_ID.toString() + " = ?",
            arrayOf(id.toString())
        )
        return nbRow == 1
    } //endregion
}