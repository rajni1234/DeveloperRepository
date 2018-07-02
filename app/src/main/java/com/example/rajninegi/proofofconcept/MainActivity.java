package com.example.rajninegi.proofofconcept;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity implements SwipeRefreshLayout.OnRefreshListener {

    /**
     * Adapter used for holding the row values from the json Data
     */
    private RowAdapter mRowAdapter;
    /**
     * Layout used for pull to refresh json Data
     */
    private SwipeRefreshLayout mRefreshLayout;

    /**
     * Actionbar title
     */
    private ActionBarTitle mActionBarTitle;

    /**
     * Use to show progress till json Data load
     */
    private ProgressDialog progressDialog;

    private Boolean progressStateCheck = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRefreshLayout = findViewById(R.id.swipeRefreshLayout);
        mRefreshLayout.setOnRefreshListener(this);
        RecyclerView mList = findViewById(R.id.main_list);
        mRowAdapter = new RowAdapter(getApplicationContext(), null);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(
                mList.getContext(), linearLayoutManager.getOrientation());
        mList.setHasFixedSize(true);
        mList.setLayoutManager(linearLayoutManager);
        mList.addItemDecoration(dividerItemDecoration);
        mList.setAdapter(mRowAdapter);
        getJsonData();


    }

    /**
     * Methods is responsible for the loading of Json Data
     * Set the actionBar title dynamically
     */
    private void getJsonData() {
        showProgressDialog();
        JsonObjectRequest jsonObjReq = new JsonObjectRequest(
                Request.Method.GET, getString(R.string.jsonUrl), null, new Response.Listener<JSONObject>() {

            @Override
            public void onResponse(JSONObject response) {
                try {

                    mActionBarTitle = new ActionBarTitle(getApplicationContext());
                    mActionBarTitle.setTitle(response.getString(getString(R.string.jsonTitleKey)));
                    getSupportActionBar().setTitle(mActionBarTitle.getTitle());
                    JSONArray rowArray = response.getJSONArray(getString(R.string.jsonRowKey));
                    Rows[] rows = new Rows[rowArray.length()];
                    for (int i = 0; i < rowArray.length(); i++) {
                        JSONObject jsonObject = rowArray.getJSONObject(i);
                        Rows myRows = new Rows(getApplicationContext());
                        myRows.setTitle(jsonObject.getString(getString(R.string.jsonTitleKey)));
                        myRows.setDescription(jsonObject.getString(getString(R.string.jsonRowDescKey)));
                        myRows.setImageHref(jsonObject.getString(getString(R.string.jsonRowImageKey)));
                        rows[i] = myRows;

                    }
                    mActionBarTitle.setRows(rows);

                } catch (JSONException e) {
                    e.printStackTrace();
                    hideProgress();
                    stopRefreshingData();
                }
                mRowAdapter.setDataSource(mActionBarTitle.getRows());
                hideProgress();
                stopRefreshingData();

            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("Volley", error.toString());
                hideProgress();
                stopRefreshingData();
            }
        });

        /*
          Third party library Volley is used for the network calls
         */
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(jsonObjReq);
    }

    /**
     * Method responsibility is to show Progress Dialogue
     */
    private void showProgressDialog() {
        if (progressStateCheck.equals(true)) {
            progressDialog = new ProgressDialog(this);
            progressDialog.setMessage("Loading...");
            progressDialog.show();
        }
    }

    /**
     * Method responsibility is to hide Progress Dialogue
     */
    private void hideProgress() {
        progressDialog.dismiss();
        progressStateCheck = false;
    }

    /**
     * Method responsibility is to stop refreshing the data
     */
    private void stopRefreshingData() {
        mRefreshLayout.setRefreshing(false);
    }


    @Override
    public void onRefresh() {
        getJsonData();
    }
}
