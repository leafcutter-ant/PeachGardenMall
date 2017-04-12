package me.zoro.peachgardenmall.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.SearchView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import me.zoro.peachgardenmall.R;
import me.zoro.peachgardenmall.common.Const;
import me.zoro.peachgardenmall.fragment.MyOrderFragment;
import me.zoro.peachgardenmall.utils.ActivityUtils;

/**
 * Created by dengfengdecao on 17/4/9.
 */

public class MyOrderActivity extends AppCompatActivity {

    @BindView(R.id.toolbar_title)
    TextView mToolbarTitle;
    @BindView(R.id.searchView)
    SearchView mSearchView;
    @BindView(R.id.toolbar)
    Toolbar mToolbar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_order);
        ButterKnife.bind(this);
        mToolbar.setTitle("");
        setSupportActionBar(mToolbar);
        ActionBar ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);
        ab.setDisplayShowHomeEnabled(true);


        MyOrderFragment fragment = (MyOrderFragment) getSupportFragmentManager().findFragmentById(R.id.main_content);
        if (fragment == null) {
            fragment = MyOrderFragment.newInstance();
            ActivityUtils.addFragmentToActivity(getSupportFragmentManager(), fragment, R.id.main_content, Const.MY_ORDER_FRAG_TAG);
        }
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return super.onSupportNavigateUp();
    }
}
