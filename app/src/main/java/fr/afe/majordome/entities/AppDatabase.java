package fr.afe.majordome.entities;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {ProjectEntity.class, ProjectMemberEntity.class,
        SpaceEntity.class, SpaceKindEntity.class,
        TaskEntity.class, TaskExecutionEntity.class,
        TaskKindEntity.class, UserEntity.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract ProjectDAO projectDAO();
    public abstract ProjectMemberDAO projectMemberDAO();
    public abstract SpaceDAO spaceDao();
    public abstract SpaceKindDAO spaceKindDAO();
    public abstract TaskDAO taskDAO();
    public abstract TaskExecutionDAO taskExecutionDAO();
    public abstract TaskKindDAO taskKindDAO();
    public abstract UserDAO userDAO();


    private static volatile AppDatabase INSTANCE;
    private static final int NUMBER_OF_THREADS = 4;
    static final ExecutorService databaseWriteExecutor =
            Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    static AppDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (AppDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            AppDatabase.class, "word_database").addCallback(sRoomDatabaseCallback)
                            .build();
                }
            }
        }
        return INSTANCE;
    }

    private static RoomDatabase.Callback sRoomDatabaseCallback = new RoomDatabase.Callback() {
        @Override
        public void onOpen(@NonNull SupportSQLiteDatabase db) {
            super.onOpen(db);

            // If you want to keep data through app restarts,
            // comment out the following block
            databaseWriteExecutor.execute(() -> {
                // Populate the database in the background.
                // If you want to start with more words, just add them.
                SpaceDAO dao = INSTANCE.spaceDao();

                dao.deleteAll();

                SpaceEntity space = new SpaceEntity();
                space.spaceName = "Salon";
                dao.insert(space);
                space = new SpaceEntity();
                space.spaceName = "Cuisine";
                dao.insert(space);
            });
        }
    };
}
