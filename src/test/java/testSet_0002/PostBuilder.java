package testSet_0002;

import com.google.gson.Gson;

public class PostBuilder {
    private int userId;
    private int id;
    private String title;
    private String body;

    public PostBuilder(int userId, int id, String title, String body) {
        this.userId = userId;
        this.id = id;
        this.title = title;
        this.body = body;
    }

    public int getUserId() {
        return this.userId;
    }

    public int getId() {
        return this.id;
    }

    public String getTitle() {
        return this.title;
    }

    public String getBody() {
        return this.body;
    }

    public String buildThePost() {
        return new Gson().toJson(new PostBuilder(getUserId(), getId(), getTitle(), getBody()));
    }
}
