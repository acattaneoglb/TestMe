package co.mobilemakers.testme;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;

/**
 * Created by ariel.cattaneo on 12/02/2015.
 */
public class Task {
    private String mName;
    private Boolean mDone;
    private List<Integer> mTimeSpent;
    private Date mDoneDate;

    public Task() {
        mTimeSpent = new ArrayList<>();
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        this.mName = name;
    }

    public Boolean getDone() {
        return mDone;
    }

    public void setDone(Boolean done) {
        this.mDone = done;
        if (mDone) {
            mDoneDate = getCurrentDate();
        }
    }

    protected Date getCurrentDate() {
        return new Date();
    }

    public Date getDoneDate() {
        return mDoneDate;
    }

    public Integer getTotalTimeSpent() {
        Integer total = 0;
        for (Integer time : mTimeSpent) {
            total += time;
        }
        return total;
    }

    public void addTimeSpent(Integer timeSpent) {
        mTimeSpent.add(timeSpent);
    }

    @Override
    public String toString() {
        return mName + ": " + (mDone ? "Done" : "NOT done");
    }
}
