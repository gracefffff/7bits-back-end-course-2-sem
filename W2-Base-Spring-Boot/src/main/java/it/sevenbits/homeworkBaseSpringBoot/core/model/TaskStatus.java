package it.sevenbits.homeworkBaseSpringBoot.core.model;

/**
 * this is enum class for status of the task
 */
public enum TaskStatus {
    /**
     * this is status means that task has not done
     */
    inbox("inbox"),
    /**
     * this is status means that task has done
     */
    done("done");
    private String status;

    /**
     * this is constructor of this class
     * @param status - set status of the task
     */
    TaskStatus(final String status) {
        this.status = status;
    }

    /**
     * this function for checking existence status
     * @param status - status which should be checked
     * @return true  if this status is exist
     *         false if this status is not exist
     */
    public static boolean isExists(final String status) {
        for (TaskStatus elem : values()) {
            if (elem.status.equals(status)) {
                return true;
            }
        }
        return false;
    }


}
