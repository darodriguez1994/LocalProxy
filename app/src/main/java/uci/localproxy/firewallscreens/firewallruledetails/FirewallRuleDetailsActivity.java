package uci.localproxy.firewallscreens.firewallruledetails;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import uci.localproxy.R;
import uci.localproxy.data.applicationPackage.ApplicationPackageLocalDataSource;
import uci.localproxy.util.ActivityUtils;

/**
 * Created by daniel on 2/10/17.
 */

public class FirewallRuleDetailsActivity extends AppCompatActivity{

    public static final String EXTRA_FIREWALL_RULE_ID = "FIREWALL_RULE_ID";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.firewallrule_details_act);

        //Set up the toolbar
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setTitle(R.string.firewallrule_details_title);

        String firewallRuleId = getIntent().getStringExtra(EXTRA_FIREWALL_RULE_ID);

        FirewallRuleDetailsFragment firewallRuleDetailsFragment = (FirewallRuleDetailsFragment) getSupportFragmentManager().
                findFragmentById(R.id.contentFrame);

        if (firewallRuleDetailsFragment == null){
            firewallRuleDetailsFragment = FirewallRuleDetailsFragment.newInstance();
            Bundle bundle = new Bundle();
            bundle.putString(FirewallRuleDetailsFragment.ARGUMENT_FIREWALL_RULE_ID, firewallRuleId);
            firewallRuleDetailsFragment.setArguments(bundle);

            ActivityUtils.addFragmentToActivity(getSupportFragmentManager(),
                    firewallRuleDetailsFragment, R.id.contentFrame);
        }

        new FirewallRuleDetailsPresenter(firewallRuleDetailsFragment,
                firewallRuleId,
                ApplicationPackageLocalDataSource.getInstance(getApplicationContext()));

    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
