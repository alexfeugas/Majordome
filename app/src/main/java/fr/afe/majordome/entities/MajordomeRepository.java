package fr.afe.majordome.entities;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

public class MajordomeRepository {

    private ProjectDAO mProjectDao;
    private LiveData<List<ProjectEntity>> mAllProjects;

    private ProjectMemberDAO mProjectMemberDao;
    private LiveData<List<ProjectMemberEntity>> mAllMembers;

    private SpaceDAO mSpaceDao;
    private LiveData<List<SpaceEntity>> mAllSpaces;

    private SpaceKindDAO mSpaceKindDao;
    private LiveData<List<SpaceKindEntity>> mAllSpaceKinds;

    private TaskDAO mTaskDao;
    private LiveData<List<TaskEntity>> mAllTasks;

    private TaskExecutionDAO mTaskExecutionDao;
    private LiveData<List<TaskExecutionEntity>> mAllTasksExecutions;

    private TaskKindDAO mTaskKindDao;
    private LiveData<List<TaskKindEntity>> mAllTasksKinds;

    private UserDAO mUserDao;
    private LiveData<List<UserEntity>> mAllUsers;

    public MajordomeRepository(Application application) {
        AppDatabase db = AppDatabase.getDatabase(application);
        setProjectDao(db.projectDAO());
        setAllProjects(getProjectDao().getAll());

        setProjectMemberDao(db.projectMemberDAO());
        setAllMembers(getProjectMemberDao().getAll());

        setSpaceDao(db.spaceDao());
        setAllSpaces(getSpaceDao().getAll());

        setSpaceKindDao(db.spaceKindDAO());
        setAllSpaceKinds(getSpaceKindDao().getAll());

        setTaskDao(db.taskDAO());
        setAllTasks(getTaskDao().getAll());

        setTaskExecutionDao(db.taskExecutionDAO());
        setAllTasksExecutions(getTaskExecutionDao().getAll());

        setTaskKindDao(db.taskKindDAO());
        setAllTasksKinds(getTaskKindDao().getAll());

        setUserDao(db.userDAO());
        setAllUsers(getUserDao().getAll());

    }

    public ProjectDAO getProjectDao() {
        return mProjectDao;
    }

    public void setProjectDao(ProjectDAO mProjectDao) {
        this.mProjectDao = mProjectDao;
    }

    public LiveData<List<ProjectEntity>> getAllProjects() {
        return mAllProjects;
    }

    public void setAllProjects(LiveData<List<ProjectEntity>> mAllProjects) {
        this.mAllProjects = mAllProjects;
    }

    public ProjectMemberDAO getProjectMemberDao() {
        return mProjectMemberDao;
    }

    public void setProjectMemberDao(ProjectMemberDAO mProjectMemberDao) {
        this.mProjectMemberDao = mProjectMemberDao;
    }

    public LiveData<List<ProjectMemberEntity>> getAllMembers() {
        return mAllMembers;
    }

    public void setAllMembers(LiveData<List<ProjectMemberEntity>> mAllMembers) {
        this.mAllMembers = mAllMembers;
    }

    public SpaceDAO getSpaceDao() {
        return mSpaceDao;
    }

    public void setSpaceDao(SpaceDAO mSpaceDao) {
        this.mSpaceDao = mSpaceDao;
    }

    public LiveData<List<SpaceEntity>> getAllSpaces() {
        return mAllSpaces;
    }

    public void setAllSpaces(LiveData<List<SpaceEntity>> mAllSpaces) {
        this.mAllSpaces = mAllSpaces;
    }

    public SpaceKindDAO getSpaceKindDao() {
        return mSpaceKindDao;
    }

    public void setSpaceKindDao(SpaceKindDAO mSpaceKindDao) {
        this.mSpaceKindDao = mSpaceKindDao;
    }

    public LiveData<List<SpaceKindEntity>> getAllSpaceKinds() {
        return mAllSpaceKinds;
    }

    public void setAllSpaceKinds(LiveData<List<SpaceKindEntity>> mAllSpaceKinds) {
        this.mAllSpaceKinds = mAllSpaceKinds;
    }

    public TaskDAO getTaskDao() {
        return mTaskDao;
    }

    public void setTaskDao(TaskDAO mTaskDao) {
        this.mTaskDao = mTaskDao;
    }

    public LiveData<List<TaskEntity>> getAllTasks() {
        return mAllTasks;
    }

    public void setAllTasks(LiveData<List<TaskEntity>> mAllTasks) {
        this.mAllTasks = mAllTasks;
    }

    public TaskExecutionDAO getTaskExecutionDao() {
        return mTaskExecutionDao;
    }

    public void setTaskExecutionDao(TaskExecutionDAO mTaskExecutionDao) {
        this.mTaskExecutionDao = mTaskExecutionDao;
    }

    public LiveData<List<TaskExecutionEntity>> getAllTasksExecutions() {
        return mAllTasksExecutions;
    }

    public void setAllTasksExecutions(LiveData<List<TaskExecutionEntity>> mAllTasksExecutions) {
        this.mAllTasksExecutions = mAllTasksExecutions;
    }

    public TaskKindDAO getTaskKindDao() {
        return mTaskKindDao;
    }

    public void setTaskKindDao(TaskKindDAO mTaskKindDao) {
        this.mTaskKindDao = mTaskKindDao;
    }

    public LiveData<List<TaskKindEntity>> getAllTasksKinds() {
        return mAllTasksKinds;
    }

    public void setAllTasksKinds(LiveData<List<TaskKindEntity>> mAllTasksKinds) {
        this.mAllTasksKinds = mAllTasksKinds;
    }

    public UserDAO getUserDao() {
        return mUserDao;
    }

    public void setUserDao(UserDAO mUserDao) {
        this.mUserDao = mUserDao;
    }

    public LiveData<List<UserEntity>> getAllUsers() {
        return mAllUsers;
    }

    public void setAllUsers(LiveData<List<UserEntity>> mAllUsers) {
        this.mAllUsers = mAllUsers;
    }


    public void insertSpace(SpaceEntity space) {
        AppDatabase.databaseWriteExecutor.execute(() -> {
            getSpaceDao().insert(space);
        });
    }

    public void insertTask(TaskEntity task) {
        AppDatabase.databaseWriteExecutor.execute(() -> {
            getTaskDao().insert(task);
        });
    }

    public LiveData<List<TaskEntity>>  getTasksBySpaceId(int taskId) {
        return getTaskDao().findBySpaceId(taskId);
    }
}
