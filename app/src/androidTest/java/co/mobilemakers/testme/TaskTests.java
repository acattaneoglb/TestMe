package co.mobilemakers.testme;

import junit.framework.TestCase;

import java.util.Date;

/**
 * Created by ariel.cattaneo on 12/02/2015.
 */
public class TaskTests extends TestCase {
    final static String TEST_TASK_NAME = "Test task";
    final static String TEST_TASK_DONE_STRING = "Test task: Done";
    final static String TEST_TASK_NOT_DONE_STRING = "Test task: NOT done";
    final static Integer TEST_TASK_TOTAL_TIME = 12;
    final static long CURRENT_DATE = 56463441l;

    public static class TestableTask extends Task {
        @Override
        protected Date getCurrentDate() {
            return new Date(CURRENT_DATE);
        }
    }

    Task mTask; //sut

    @Override
    public void setUp() throws Exception {
        super.setUp();
        mTask = new Task();
    }

    @Override
    public void tearDown() throws Exception {
        mTask = null;
        super.tearDown();
    }

    public void testDoneStatusIsDisplayedProperly() throws Exception {
        // Arrange
        mTask.setName(TEST_TASK_NAME);
        mTask.setDone(true);

        // Act
        String taskString = mTask.toString();

        // Assert
        assertEquals("String must use the format <task name>: Done",
                taskString,
                TEST_TASK_DONE_STRING);

    }

    public void testNotDoneStatusIsDisplayedProperly() throws Exception {
        mTask.setName(TEST_TASK_NAME);
        mTask.setDone(false);

        assertEquals("String must use the format <task name>: Done",
                mTask.toString(),
                TEST_TASK_NOT_DONE_STRING);

    }

       public void testTotalTimeSpentIsCalculatedProperly() throws Exception {
        mTask.setName(TEST_TASK_NAME);
        mTask.setDone(false);
        mTask.addTimeSpent(1);
        mTask.addTimeSpent(3);
        mTask.addTimeSpent(1);
        mTask.addTimeSpent(7);

        assertEquals("Total time spent must be the sum of all the time added",
                mTask.getTotalTimeSpent(),
                TEST_TASK_TOTAL_TIME);

    }

    public void testDoneDateIsSetToCurrentDateWhenTaskIsDone() throws Exception {
        TestableTask task = new TestableTask();
        task.setDone(true);

        assertEquals(task.getDoneDate(), new Date(CURRENT_DATE));
    }
}

