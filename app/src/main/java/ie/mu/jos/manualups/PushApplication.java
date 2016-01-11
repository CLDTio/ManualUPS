package ie.mu.jos.manualups;

import android.app.Application;

import org.jboss.aerogear.android.unifiedpush.PushRegistrar;
import org.jboss.aerogear.android.unifiedpush.RegistrarManager;
import org.jboss.aerogear.android.unifiedpush.gcm.AeroGearGCMPushJsonConfiguration;

public class PushApplication extends Application {

    private static final String PUSH_REGISTAR_NAME = "myPushRegistar";

    @Override
    public void onCreate() {
        super.onCreate();

        RegistrarManager.config(PUSH_REGISTAR_NAME, AeroGearGCMPushJsonConfiguration.class)
                .loadConfigJson(getApplicationContext())
                .asRegistrar();
    }

    // Accessor method for Activities to access the 'PushRegistrar' object
    public PushRegistrar getPushRegistar() {
        return RegistrarManager.getRegistrar(PUSH_REGISTAR_NAME);
    }

}
