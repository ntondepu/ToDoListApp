public class Task {
    private String description;
    private boolean isCompleted;

    public Task(String description){
        this.description = description;
        this.isCompleted = false;
    }

    public String getDescription(){
        return description;
    }

    public boolean isCompleted(){
        return isCompleted;
    }

    public void setCompleted(boolean completed){
        isCompleted = completed;
    }

    @Override
    public String toString(){
        String status;
        if (isCompleted){
            status = "[X]";
        } else {
            status = "[ ]";
        }
        return status + description;
    }
}
