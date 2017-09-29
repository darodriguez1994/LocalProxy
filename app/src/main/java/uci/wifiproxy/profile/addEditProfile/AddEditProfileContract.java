package uci.wifiproxy.profile.addEditProfile;

import android.support.annotation.NonNull;

import uci.wifiproxy.BasePresenter;
import uci.wifiproxy.BaseView;
import uci.wifiproxy.profile.AuthScheme;

/**
 * Created by daniel on 17/09/17.
 */

public interface AddEditProfileContract {

    interface View extends BaseView<Presenter> {

        void showEmptyProfileError();

        void finishAddEditProfileActivity();

        void setName(String name);

        void setServer(String server);

        void setInPort(String inPort);

        void setOutPort(String outPort);

        void setBypass(String bypass);

        boolean isActive();

        void setProfileEqualNameError();

        void setNameEmptyError();

        void setServerEmptyError();

        void setInPortEmptyError();

        void setOutPortEmptyError();

        void setBypassSyntaxError();

    }

    interface Presenter extends BasePresenter{

        void saveProfile(String name, String server,
                         String inPort, String outPort, String bypass);

        void populateProfile();

        boolean isDataMissing();

        void onDestroy();

    }
}
