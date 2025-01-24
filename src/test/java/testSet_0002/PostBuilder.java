package testSet_0002;

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

    public PostBuilder patchUserId(int userId) {
        this.userId = userId;
        return this;
    }

    public PostBuilder patchId(int id) {
        this.id = id;
        return this;
    }

    public PostBuilder patchTitle(String title) {
        this.title = title;
        return this;
    }

    public PostBuilder patchBody(String body) {
        this.body = body;
        return this;
    }

//    public String buildThePost() {
//        return new Gson().toJson(this);
//    }
}
