package yasmin.ayman.alzainy.myfirebase;

public class Note {
    private String body, title, user;

    public Note(String title, String body, String user) {
        this.body = body;
        this.title = title;
        this.user = user;
    }

    public Note() {
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return title;
    }
}
