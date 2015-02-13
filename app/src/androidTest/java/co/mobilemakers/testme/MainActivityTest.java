package co.mobilemakers.testme;

import android.support.test.espresso.assertion.ViewAssertions;
import android.test.ActivityInstrumentationTestCase2;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/**
 * Created by ariel.cattaneo on 12/02/2015.
 */
public class MainActivityTest extends ActivityInstrumentationTestCase2<MainActivity> {
    MainActivity mMainActivity;

    public MainActivityTest() {
        super(MainActivity.class);
    }

    @Override
    public void setUp() throws Exception {
        super.setUp();
        mMainActivity = getActivity();
    }

    public void testHelloIsDisplayed() throws Exception {
        onView(withText("Hello world!")).check(ViewAssertions.matches(isDisplayed()));

    }

    public void testSalutationChangesWithButtonClick() throws Exception {
        onView(withText("Touch me")).perform(click());
        onView(withText("Bye bye, Moon!")).check(ViewAssertions.matches(isDisplayed()));

    }
}
