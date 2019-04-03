package it.sevenbits.homeworkBaseSpringBoot.core.model;

public enum TaskStatus {
    inbox("inbox"),
    done("done");
    private String status;

    TaskStatus(final String status) {
        this.status = status;
    }

    public static boolean isExists(final String status) {
        for (TaskStatus elem : values()) {
            if (elem.status.equals(status)) {
                return true;
            }
        }
        return false;
    }


}
