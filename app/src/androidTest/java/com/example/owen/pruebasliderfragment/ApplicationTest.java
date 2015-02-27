package com.example.owen.pruebasliderfragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.test.ActivityInstrumentationTestCase2;
import android.test.TouchUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.owen.pruebasliderfragment.activities.Initial;
import com.example.owen.pruebasliderfragment.fragments.Login_frag;
import com.parse.ParseUser;

/**
 * <a href="http://d.android.com/tools/testing/testing_android.html">Testing Fundamentals</a>
 */
public class ApplicationTest extends ActivityInstrumentationTestCase2<TestFragmentActivity> {
    private TestFragmentActivity mActivity;
    private Button login, logearse;
    private EditText user;
    private EditText contraseña;
    private static final String USER = "owen";
    private static final String PASS = "pass";


    public ApplicationTest() {
        super(TestFragmentActivity.class);
    }


    @Override
    protected void setUp() throws Exception {
        super.setUp();
        // da error al coger la actividad, este error sucede al tratarse de una prueba sobre un fragmento
        mActivity = getActivity();
        user = (EditText) mActivity.findViewById(R.id.user_email);
        contraseña = (EditText) mActivity.findViewById(R.id.login_Pass);
        login = (Button) mActivity.findViewById(R.id.buttonLogin);
        if(ParseUser.getCurrentUser()!=null)
            ParseUser.logOut();
    }

    protected void tearDown() throws Exception {
        super.tearDown();
    }

    public void testAddValues() {
        //on value 1 entry
        TouchUtils.tapView(this, user);
        sendKeys(USER);
        // now on value2 entry
        TouchUtils.tapView(this, contraseña);
        sendKeys(PASS);
        // now on Add button
        TouchUtils.clickView(this, login);


        String nombreActividad = getActivity().getClass().getSimpleName();
        assertTrue("Add result should be...", nombreActividad.equals("Home"));
    }

}


class TestFragmentActivity extends FragmentActivity {
    @Override
    protected void onCreate(Bundle arg0) {
        super.onCreate(arg0);
        setContentView(R.layout.fragment_login);
    }
}